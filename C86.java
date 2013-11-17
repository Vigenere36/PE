public class C86 {
	//9314.048 ms
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int solutions = 0;
		int m = 1;

		while (solutions < 1000000) {
			for (int n1 = 1; n1 <= m; n1++) {
				for (int n2 = n1; n2 <= m; n2++) {
					int square = m*m + (n1+n2) * (n1+n2);
					int sqrt = (int)Math.sqrt(square);
					if (sqrt*sqrt == square) solutions++;
				}
			}
			m++;
		}
		System.out.println(m-1);

		System.out.println((System.nanoTime()-startTime)/1000000.0 + " ms");
	}
}