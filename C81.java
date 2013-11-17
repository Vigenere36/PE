import java.io.*;
public class C81 {
   //64.597ms
   public static int[][] array = new int[80][80];
   public static int[][] shortest = new int[80][80];
   public static void main(String[] args) {
      long startTime = System.nanoTime();

      getFileData(); //Stores matrix

      shortest[0][0] = array[0][0];
      for (int i = 1; i < 80; i++) {
         findPath(i);
      }

      System.out.println(shortest[79][79]);

      long endTime = System.nanoTime();
      System.out.println((endTime-startTime)/1000000.0 + "ms");
   }

   public static void getFileData() {
      BufferedReader stream = null;
      String s = "";
      try {
         stream = new BufferedReader(new FileReader("C81.txt"));
         for (int i = 0; i < 80; i++) {
            s = stream.readLine();
            char[] digits = s.toCharArray();

            int[] line = new int[80];
            int lineindex = 0;
            String num = "";
            for (char c : digits) {
               if (c == ',') {
                  line[lineindex] = Integer.parseInt(num);
                  lineindex++;
                  num = "";
               } else {
                  num += Character.toString(c);
               }
            }
            line[lineindex] = Integer.parseInt(num);
            array[i] = line;
         }
         stream.close();
      } catch (Exception e) {}
   }

   public static void findPath(int n) {
      for (int i = 0; i < n; i++) findShortest(n, i);
      for (int i = 0; i < n; i++) findShortest(i, n);
      findShortest(n,n);
   }

   public static void findShortest(int x, int y) {
      if (y == 0) shortest[x][y] = shortest[x-1][y] + array[x][y];
      else if (x == 0) shortest[x][y] = shortest[x][y-1] + array[x][y];
      else {
         shortest[x][y] = Math.min(shortest[x-1][y], shortest[x][y-1]) + array[x][y];
      }
   }
}