public class C87 {
	//97.045 ms
	public static int fsq = (int)Math.sqrt(50000000) + 1;
	public static boolean[] primes = new boolean[fsq];
	public static boolean[] isPPT = new boolean[50000000]; // "is Prime Power Triplet", or a result of a^2 + b^3 + c^4 for some a, b, and c
	public static int[] squared = new int[fsq];
	public static int[] cubed = new int[fsq];
	public static int[] fourth = new int[fsq];

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		for (int i = 0; i < fsq; i++) {
			primes[i] = isPrime(i);
		}

		for (int c = 2; c < fsq; c++) {
			if ((int)Math.pow(c,4) > 50000000) break;
			if (primes[c]) {
				for (int b = 2; b < fsq; b++) {
					if ((int)Math.pow(b,3) > 50000000) break;
					if (primes[b]) {
						for (int a = 2; a < fsq; a++) {
							if (primes[a]) {
								int pptsum = ppt(a, b, c);
								if (pptsum < 50000000) {
									isPPT[pptsum] = true;
								}
								else break;
							}
						}
					}
				}
			}
		}

		int sum = 0;
		for (boolean b : isPPT) {
			if (b == true) sum++;
		}
		System.out.println(sum);

		System.out.println((System.nanoTime()-startTime)/1000000.0 + " ms");
	}

	public static int ppt(int a, int b, int c) {
		int square;
		int cube;
		int four;

		if (squared[a] != 0) square = squared[a];
		else {
			square = (int)Math.pow(a,2);
			squared[a] = square;
		}

		if (cubed[b] != 0) cube = cubed[b];
		else {
			cube = (int)Math.pow(b,3);
			cubed[b] = cube;
		}

		if (fourth[c] != 0) four = fourth[c];
		else {
			four = (int)Math.pow(c,4);
			fourth[c] = four;
		}

		return square + cube + four;
	}

	public static boolean isPrime(int n) {
		if (n < 2) return false;
		else if (n == 2) return true;
		else {
			for (int i = 2; i <= (int)Math.sqrt(n); i++) {
				if (n % i == 0) return false;
			}
		}
		return true;
	}
}