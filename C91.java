import java.util.Arrays;
public class C91 {
	//152.124 ms
	public static void main(String[] args) {
		long startTime = System.nanoTime();

		/*
		Go through every set of two points, and get three vectors
		Take the dot product of each pair of vectors in the triangle. If 0, then increment
		*/
		int sum = 0;
		for (int x1 = 0; x1 <= 50; x1++) {
			for (int y1 = 0; y1 <= 50; y1++) {
				for (int x2 = 0; x2 <= 50; x2++) {
					for (int y2 = 0; y2 <= 50; y2++) {
						int[] v1 = {x1,y1};
						int[] v2 = {x2,y2};
						int[] v3 = {x2-x1,y2-y1};
						if (!(Arrays.equals(v1,v2)) && !(x1 == y1 && x1 == 0) && !(x2 == y2 && x2 == 0)) { //If first two vectors are not equal, and if they are not zero vectors
							if ((v1[0] * v2[0] + v1[1] * v2[1] == 0) || (v1[0] * v3[0] + v1[1] * v3[1] == 0) || (v2[0] * v3[0] + v2[1] * v3[1] == 0)) {
								//System.out.println("<" + v1[0] + "," + v1[1] + "> " + "<" + v2[0] + "," + v2[1] + "> " + "<" + v3[0] + "," + v3[1] + ">");
								sum++;
							}
						}
					}
				}
			}
		}
		System.out.println(sum/2);

		System.out.println((System.nanoTime()-startTime)/1000000.0 + " ms");
	}
}