import java.util.LinkedList;
public class C90 {
	//17.413 ms
	public static LinkedList<boolean[]> combos = new LinkedList<boolean[]>();
	public static void main(String[] args) {
		long startTime = System.nanoTime();

		/*
		Square numbers: 01, 04, 09, 16, 25, 36, 49, 64, 81
		Rules:
		0 - 1, 0 - 4, 0 - 6/9, 1 - 6/9, 2 - 5, 3 - 6/9, 4 - 6/9, 8 - 1

		First, generate all 210 possible combinations
		Compare each one to all 210 and count
		*/

		int sum = 0;
		addCombos();
		for (boolean[] ia1 : combos) {
			for (boolean[] ia2 : combos) {
				if (hasCombo(ia1,ia2,0,1) && hasCombo(ia1,ia2,0,4) && hasCombo(ia1,ia2,2,5) && hasCombo(ia1,ia2,8,1)) {
					if ((hasCombo(ia1,ia2,0,6) || hasCombo(ia1,ia2,0,9)) && (hasCombo(ia1,ia2,1,6) || hasCombo(ia1,ia2,1,9)) && (hasCombo(ia1,ia2,3,6) || hasCombo(ia1,ia2,3,9)) && (hasCombo(ia1,ia2,4,6) || hasCombo(ia1,ia2,4,9))) {
						sum++;
					}
				}
			}
		}
		System.out.println(sum/2);

		System.out.println((System.nanoTime()-startTime)/1000000.0 + " ms");
	}

	public static boolean hasCombo(boolean[] ba1, boolean[] ba2, int num1, int num2) {
		return ((ba1[num1] && ba2[num2]) || (ba1[num2] && ba2[num1]));
	}

	public static void addCombos() {
		int sum = 0;
		for (int a = 0; a <= 9; a++) {
			for (int b = a + 1; b <= 9; b++) {
				for (int c = b + 1; c <= 9; c++) {
					for (int d = c + 1; d <= 9; d++) {
						for (int e = d + 1; e <= 9; e++) {
							for (int f = e + 1; f <= 9; f++) {
								boolean[] ba = new boolean[10];
								ba[a] = true;
								ba[b] = true;
								ba[c] = true;
								ba[d] = true;
								ba[e] = true;
								ba[f] = true;
								combos.add(ba);
							}
						}
					}
				}
			}
		}
	}
}