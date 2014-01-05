import java.util.LinkedList;
import java.util.Random;
public class test {
	public static void main(String[] args) {
		//testLLI();
		//testLLIA();
		//testbdD(200);
		char c = '6';
		int i = Integer.parseInt(Character.toString(c));
		System.out.println(i);
	}

	//testing generics with linked list of integers
	public static void testLLI() {
		LinkedList<Integer> nums = new LinkedList<Integer>();
		int num1 = 1;
		int num2 = 2;
		nums.add(num1);
		nums.add(num2);
		
		Integer[] ia = nums.toArray(new Integer[0]);
		for (int i : ia) System.out.println(i);
	}

	//testing generics furthermore with linked list of array of integers
	public static void testLLIA() {
		LinkedList<Integer[]> nums = new LinkedList<Integer[]>();
		Integer[] num1 = {1,2};
		Integer[] num2 = {3,4};
		nums.add(num1);
		nums.add(num2);
		
		Integer[][] iaa = nums.toArray(new Integer[0][0]);
		for (Integer[] ia : iaa) for (int i : ia) System.out.println(i);		
	}

	//in a group of people, what is the average number of people it takes until someone has the same birthday as another person?
	public static void testbdD(int c) {
		int sum = 0;
		int times = 0;

		while (times < c) {
			sum += bdDupe();
			times++;
		}	
		System.out.println(sum/times);
	}

	public static int bdDupe() {
		Random gen = new Random();
		LinkedList<Integer> nums = new LinkedList<Integer>();
		int n = gen.nextInt(365);
		while (!nums.contains(n)) {
			nums.add(n);
			n = gen.nextInt(365);
		}
		//System.out.println(nums.size());
		return nums.size();
	}
}