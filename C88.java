import java.util.LinkedList;

public class C88 {
	//Answer: 7587457
	//415534.533 ms
	//I need more practice, first challenge in quite some time. Rewarding, learned about generics.
	//Possible optimization would be to record factors, not sure how much time that would save.

	//After optimization: 20607.901 ms, same answer

	public static boolean[] prime = new boolean[24001];
	public static boolean[] crossed = new boolean[24001];
	public static LinkedList<Integer[]> pairs = new LinkedList<Integer[]>();
	public static Object[] factors = new Object[24001];
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int sum = 0;

		for (int i = -1; i < prime.length; i+=2) if (isprime(i)) prime[i] = true; //Check if all possible N are prime, reducing number of possible N checked
		for (int i = 0; i < factors.length; i++) {
			LinkedList f = new LinkedList();
			if (!prime[i]) {
				for (int d = 2; d <= (int)Math.sqrt(i); d++) {
					if (i % d == 0) {
						f.add(d);
					}
				}
			}
			factors[i] = f;
		}


		for (int k = 2; k <= 12000; k++) {
			int[] digits = new int[k];
			for (int i = 0; i < k; i++) digits[i] = 1;
			int n = k; //N is candidate product-sum

			n_loop:
				while (n <= 2*k) { //2*k is upper bound
					if (prime[n]) n++;

					pairs = new LinkedList<Integer[]>();
					for (int i = 2; i <= (int)Math.sqrt(n); i++) {
						if (n % i == 0) factor(i,n/i,0,0);
					}

					for (Integer[] num_sum : pairs) {
						if (k-num_sum[0]+num_sum[1] == n) { //if k-#factors+E(factors) = N, then N is a minial product-sum number
							if (!crossed[n]) {
								sum += n;
								crossed[n] = true;
							}
							break n_loop;
						}
					}
					n++;
				}
		}

		System.out.println(sum);

		System.out.println((System.nanoTime()-startTime)/1000000.0 + " ms");
	}

	public static void factor(int a, int b, int num, int sum) {
		Integer[] pair = {num + 2, a+b+sum};
		pairs.add(pair);

		//if both are prime, do nothing
		if (prime[a] ^ prime[b]) {
			if (prime[a]) {
				for (int i : (LinkedList<Integer>)factors[b]) factor(i, b/i, num+1, sum+a);
				/*for (int i = 2; i <= (int)Math.sqrt(b); i++) {
					if (b % i == 0) factor(i, b/i, num+1, sum+a);
				}*/
			} else {
				for (int i : (LinkedList<Integer>)factors[a]) factor(i, a/i, num+1, sum+b);
				/*for (int i = 2; i <= (int)Math.sqrt(a);i++) {
					if (a % i == 0) factor(i, a/i, num+1, sum+b);
				}*/
			}
		} else if ((!prime[a]) && (!prime[b])) { //neither prime

			//asums and bsums are for when the counterpart to a branch has sub-branches
			/*
			normal factoring:
			 / \
			/\  

			with asum and bsum in factoring:
			 / \
			/\ /\
			(the bottom branches are included)

			with asum and bsum factoring, all possible factorings are included
			*/
			LinkedList<Integer> asums = new LinkedList<Integer>();
			LinkedList<Integer> bsums = new LinkedList<Integer>();
			for (int i : (LinkedList<Integer>)factors[a]) {
				factor(i, a/i, num+1, sum+b);
				bsums.add(i + (a/i));
			}
			for (int i : (LinkedList<Integer>)factors[b]) {
				factor(i, b/i, num+1, sum+a);
				asums.add(i + (b/i));
			}

			for (int asum : asums) for (int i : (LinkedList<Integer>)factors[a]) factor(i, a/i, num+2, sum+asum);
			for (int bsum : bsums) for (int i : (LinkedList<Integer>)factors[b]) factor(i, b/i, num+2, sum+bsum);

			/*
			for (int i = 2; i <= Math.max((int)Math.sqrt(a),(int)Math.sqrt(b)); i++) {
				if (a % i == 0) {
					factor(i, a/i, num+1, sum+b);
					bsums.add(i + (a/i));
				}
				if (b % i == 0) {
					factor(i, b/i, num+1, sum+a);
					asums.add(i + (b/i));
				}
			}
			for (int asum : asums) for (int i = 2; i <= (int)Math.sqrt(a); i++) if (a % i == 0) factor(i, a/i, num+2, sum+asum);
			for (int bsum : bsums) for (int i = 2; i <= (int)Math.sqrt(b); i++) if (b % i == 0) factor(i, b/i, num+2, sum+bsum);
			*/
		}
	}

	public static boolean isprime(int n) {
		if (n < 2) return false;
		if (n == 2) return true;
		for (int div = 2; div <= (int)Math.sqrt(n); div++) {
			if (n % div == 0) return false;
		}
		return true;
	}
}