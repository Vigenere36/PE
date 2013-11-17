public class C71 {
   //20ms
   public static void main(String[] args) {
      long startTime = System.nanoTime();

      double ts = 3.0/7.0;
      double closest = 0.0;
      int closestn = 0;

      for (int d = 2; d <= 1000000; d++) {
         for (int n = (d * 3)/7; n > 0; n--) {
            double f = (double)n/(double)d;
            if (f < closest) break;
            if (d%n != 0 && f > closest && f < ts) {
               closest = f;
               closestn = n;
            }
         }
      }
      System.out.println(closestn);

      long endTime = System.nanoTime();
      System.out.println((endTime-startTime)/1000000.0 + "ms");
   }
}