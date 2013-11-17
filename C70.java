public class C70 {
   public static int[] allprimes = new int[700000];
   public static int allprimesindex = 1;
   public static void main(String[] args) {
      long startTime = System.nanoTime();

      addPrimes();

      long maxn = 0;
      double minratio = Double.MAX_VALUE;

      for (int i = 0; i < allprimes.length; i++) {
         for (int i2 = i + 1; i2 < allprimes.length; i2++) {
            int phi = (allprimes[i]-1)*(allprimes[i2]-1);
            int n = allprimes[i] * allprimes[i2];
            if (n > 10000000) break;

            if ((double)n/(double)phi < minratio && permute(phi, n)) {
               maxn = n;
               minratio = (double)n/(double)phi;
               System.out.println("Max n: " + maxn);
            }
         }
      }
      System.out.println("Max n: " + maxn);

      long endTime = System.nanoTime();
      System.out.println((endTime-startTime)/1000000.0 + "ms");
   }

   public static void addPrimes() {
      allprimes[0] = 2;
      int num = 3;
      while (allprimesindex < allprimes.length) {
         if (isPrime(num)) {
            allprimes[allprimesindex] = num;
            allprimesindex++;
         }
         num+=2;
      }
   }

   public static boolean permute(int a, int b) {
      if (Integer.toString(a).length() != Integer.toString(b).length()) return false;
      char[] digits1 = Integer.toString(a).toCharArray();
      char[] digits2 = Integer.toString(b).toCharArray();

      for (int i = 0; i < digits1.length; i++) {
         boolean found = false;
         for (int i2 = 0; i2 < digits2.length; i2++) {
            if (digits1[i] == digits2[i2]) {
               digits2[i2] = 'N';
               found = true;
               break;
            }
         }
         if (found == false) return false;
      }
      return true;
   }

   public static boolean isPrime(int n) {
      if (n < 2) return false;
      for (int i = 2; i <= (int)Math.sqrt(n); i++) {
         if (n % i == 0) return false;
      }
      return true;
   }
}