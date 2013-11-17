import java.io.*;
import java.util.LinkedList;
public class C82 {
   //123.532ms
   public static int[][] array = new int[80][80];
   public static int[][] shortest = new int[80][80];
   public static void main(String[] args) {
      long startTime = System.nanoTime();

      getFileData(); //Stores matrix

      for (int i = 0; i < 80; i++) {
         shortest[i][0] = array[i][0];
      }

      for (int i = 1; i < 80; i++) {
         findPath(i);
      }

      int least = Integer.MAX_VALUE;
      for (int[] a : shortest) {
         if (a[79] < least) least = a[79];
      }
      System.out.println(least);

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

   public static void findPath(int col) {
      for (int row = 0; row < 80; row++) {
         findShortest(row, col);
      }
   }

   public static void findShortest(int row, int col) {
      LinkedList sums = new LinkedList();
      int sumup = 0;
      int sumdown = 0;

      for (int i = row; i >= 0; i--) {
         sumup += array[i][col];
         sums.add(sumup + shortest[i][col-1]);
      }
      for (int i = row; i < 80; i++) {
         sumdown += array[i][col];
         sums.add(sumdown + shortest[i][col-1]);
      }

      Object[] list = sums.toArray();
      int least = Integer.MAX_VALUE;
      for (Object o : list) {
         if ((Integer)o < least) least = (Integer)o;
      }
      shortest[row][col] = least;
   }
}