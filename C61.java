import java.util.LinkedList;
public class C61 {
   //350.115ms
   public static LinkedList triangles = new LinkedList();
   public static LinkedList squares = new LinkedList();
   public static LinkedList pentagonals = new LinkedList();
   public static LinkedList hexagonals = new LinkedList();
   public static LinkedList heptagonals = new LinkedList();
   public static LinkedList octagonals = new LinkedList();
   public static LinkedList pairs = new LinkedList();
   public static LinkedList pairs2 = new LinkedList();
   public static LinkedList pairs3 = new LinkedList();
   public static void main(String[] args) {
      long startTime = System.nanoTime();

      for (int i = 1; i <= 150; i++) {
         triangles.add((i * (i + 1))/2);
         squares.add(i * i);
         pentagonals.add((i * ((3 * i) - 1))/2);
         hexagonals.add(i * ((2 * i) - 1));
         heptagonals.add((i * ((5 * i) - 3))/2);
         octagonals.add(i * ((3 * i) - 2));
      }

      addPairs();
      for (Object o : pairs) { //Switch around pairs
         Object[] oa = (Object[])o;
         if (!cy(oa[0],oa[1])) {
            Object temp = oa[0];
            oa[0] = oa[1];
            oa[1] = temp;
         }
      }
      addPairs2();

      outerloop:
      for (Object p2 : pairs2) {
         Object[] oa2 = (Object[])p2;
         for (Object p : pairs) {
            Object[] oa1 = (Object[])p;
            if (diff((Integer)oa1[2],(Integer)oa1[3],(Integer)oa2[4],(Integer)oa2[5],(Integer)oa2[6],(Integer)oa2[7])) {
               if (cy(oa2[3], oa1[0]) && cy(oa1[1],oa2[0])) {
                  System.out.println("Sum: " + ((Integer)oa2[0] + (Integer)oa2[1] + (Integer)oa2[2] + (Integer)oa2[3] + (Integer)oa1[0] + (Integer)oa1[1]));
                  break outerloop;
               }
            }
         }
      }

      long endTime = System.nanoTime();
      System.out.println((endTime-startTime)/1000000.0 + "ms");
   }

   public static void addPairs() {
      for (Object o1 : triangles) {
         for (Object o2 : squares) {
            if (cy(o1,o2) || cy(o2, o1)) {
               Object[] o = {o1, o2, 0, 1};
               pairs.add(o);
            }
         }
         for (Object o2 : pentagonals) {
            if (cy(o1,o2) || cy(o2, o1)) {
               Object[] o = {o1, o2, 0, 2};
               pairs.add(o);
            }
         }
         for (Object o2 : hexagonals) {
            if (cy(o1,o2) || cy(o2, o1)) {
               Object[] o = {o1, o2, 0, 3};
               pairs.add(o);
            }
         }
         for (Object o2 : heptagonals) {
            if (cy(o1,o2) || cy(o2, o1)) {
               Object[] o = {o1, o2, 0, 4};
               pairs.add(o);
            }
         }
         for (Object o2 : octagonals) {
            if (cy(o1,o2) || cy(o2, o1)) {
               Object[] o = {o1, o2, 0, 5};
               pairs.add(o);
            }
         }
      }
      for (Object o1 : squares) {
         for (Object o2 : pentagonals) {
            if (cy(o1,o2) || cy(o2, o1)) {
               Object[] o = {o1, o2, 1, 2};
               pairs.add(o);
            }
         }
         for (Object o2 : hexagonals) {
            if (cy(o1,o2) || cy(o2, o1)) {
               Object[] o = {o1, o2, 1, 3};
               pairs.add(o);
            }
         }
         for (Object o2 : heptagonals) {
            if (cy(o1,o2) || cy(o2, o1)) {
               Object[] o = {o1, o2, 1, 4};
               pairs.add(o);
            }
         }
         for (Object o2 : octagonals) {
            if (cy(o1,o2) || cy(o2, o1)) {
               Object[] o = {o1, o2, 1, 5};
               pairs.add(o);
            }
         }
      }
      for (Object o1 : pentagonals) {
         for (Object o2 : hexagonals) {
            if (cy(o1,o2) || cy(o2, o1)) {
               Object[] o = {o1, o2, 2, 3};
               pairs.add(o);
            }
         }
         for (Object o2 : heptagonals) {
            if (cy(o1,o2) || cy(o2, o1)) {
               Object[] o = {o1, o2, 2, 4};
               pairs.add(o);
            }
         }
         for (Object o2 : octagonals) {
            if (cy(o1,o2) || cy(o2, o1)) {
               Object[] o = {o1, o2, 2, 5};
               pairs.add(o);
            }
         }
      }
      for (Object o1 : hexagonals) {
         for (Object o2 : heptagonals) {
            if (cy(o1,o2) || cy(o2, o1)) {
               Object[] o = {o1, o2, 3, 4};
               pairs.add(o);
            }
         }
         for (Object o2 : octagonals) {
            if (cy(o1,o2) || cy(o2, o1)) {
               Object[] o = {o1, o2, 3, 5};
               pairs.add(o);
            }
         }
      }
      for (Object o1 : heptagonals) {
         for (Object o2 : octagonals) {
            if (cy(o1,o2) || cy(o2, o1)) {
               Object[] o = {o1, o2, 4, 5};
               pairs.add(o);
            }
         }
      }
   }

   public static void addPairs2() {
      for (Object p1 : pairs) {
         Object[] o1 = (Object[]) p1;
         for (Object p2 : pairs) {
            Object[] o2 = (Object[]) p2;
            if (o1[2] != o2[2] && o1[2] != o2[3] && o1[3] != o2[2] && o1[3] != o2[3]) {
               if (cy(o1[1],o2[0]) && diff((Integer)o1[0],(Integer)o1[1],(Integer)o2[0],(Integer)o2[1])) {
                  Object[] o = {o1[0],o1[1],o2[0],o2[1],o1[2],o1[3],o2[2],o2[3]};
                  pairs2.add(o);
               }
            }
         }
      }
   }

   public static boolean diff(int i1, int i2, int i3, int i4, int i5, int i6) {
      if (i1 == i2 || i1 == i3 || i1 == i4 || i1 == i5 || i1 == i6) return false;
      if (i2 == i3 || i2 == i4 || i2 == i5 || i2 == i6) return false;
      if (i3 == i4 || i3 == i5 || i3 == i6) return false;
      if (i4 == i5 || i4 == i6) return false;
      if (i5 == i6) return false;
      return true;
   }

   public static boolean diff(int i1, int i2, int i3, int i4) {
      if (i1 == i2 || i1 == i3 || i1 == i4) return false;
      if (i2 == i3 || i2 == i4) return false;
      if (i3 == i4) return false;
      return true;
   }

   public static boolean cyi(int a, int b) {
      if (Integer.toString(a).length() != 4) return false;
      if (Integer.toString(b).length() != 4) return false;
      return Integer.toString(b).substring(0, 2).contains(Integer.toString(a).substring(2));
   }

   public static boolean cy(Object a, Object b) {
      return cyi((Integer)a, (Integer)b);
   }
}