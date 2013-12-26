import java.util.LinkedList;
public class test {
	public static void main(String[] args) {
		/*LinkedList<Integer> nums = new LinkedList<Integer>();
		int num1 = 1;
		int num2 = 2;
		nums.add(num1);
		nums.add(num2);
		
		Integer[] ia = nums.toArray(new Integer[0]);
		for (int i : ia) System.out.println(i);*/


		LinkedList<Integer[]> nums = new LinkedList<Integer[]>();
		Integer[] num1 = {1,2};
		Integer[] num2 = {3,4};
		nums.add(num1);
		nums.add(num2);
		
		Integer[][] iaa = nums.toArray(new Integer[0][0]);
		for (Integer[] ia : iaa) for (int i : ia) System.out.println(i);
	}
}