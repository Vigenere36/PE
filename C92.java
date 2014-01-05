public class C92 {
	//12912.116 ms
	public static int[] endChain = new int[568];
	public static int[] squareDigitsMemo = new int[10000000];
	public static void main(String[] args) {
		long startTime = System.nanoTime();

		/*
		Create int array of 10 million
		Using memoization iterate to 10 million
		*/
		for (int i = 1; i < endChain.length; i++) {
			int n = i;
			while (n != 1 && n != 89) {
				n = squareDigits(n);
			}
			endChain[i] = n;
		}

		int sum = 0;
		for (int i = 1; i < 10000000; i++) {
			int n = i;
			while (n >= endChain.length) n = squareDigits(n);
			if (endChain[n] == 89) sum++;
		}
		System.out.println(sum);

		System.out.println((System.nanoTime()-startTime)/1000000.0 + " ms");
	}

	public static int squareDigits(int n) {
		if (squareDigitsMemo[n] != 0) return squareDigitsMemo[n];
		int s = 0;
		char[] digits = Integer.toString(n).toCharArray();
		for (char c : digits) {
			s += (int)Math.pow(Integer.parseInt(Character.toString(c)),2);
		}
		squareDigitsMemo[n] = s;
		return s;
	}
}