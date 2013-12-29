import java.io.*;
import java.util.LinkedList;

public class C89 {
	//6.472 ms

	public static LinkedList<String> numerals = new LinkedList<String>();
	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int sum = 0;
		read("roman.txt");
		for (String s : numerals) {
			int ori_l = s.length();
			int val = value(s);
			sum += (ori_l - rn_length(val));
		}
		System.out.println(sum);

		System.out.println((System.nanoTime()-startTime)/1000000.0 + " ms");
	}

	//Reads file and adds Strings to LinkedList numerals by reading line by line
	public static void read(String filename) {
		BufferedReader input;
		try {
			input = new BufferedReader(new FileReader(filename));
		} catch (Exception e) {
			System.out.println("File not found");
			return;
		}

		while (true) {
			try {
				String s = input.readLine();
				if (s == null) break;
				numerals.add(s);
			} catch (Exception e) {
				break;
			}
		}
	}

	//Returns the value of a Roman Numeral string, assuming it is valid
	public static int value(String s) {
		char[] values = s.toCharArray();
		int sum = 0;
		int last_val = 0;
		int curr_val = 0;
		for (int i = values.length-1; i >= 0; i--) {
			if (values[i] == 'I') curr_val = 1;
			else if (values[i] == 'V') curr_val = 5;
			else if (values[i] == 'X') curr_val = 10;
			else if (values[i] == 'L') curr_val = 50;
			else if (values[i] == 'C') curr_val = 100;
			else if (values[i] == 'D') curr_val = 500;
			else if (values[i] == 'M') curr_val = 1000;

			if (curr_val >= last_val) sum += curr_val;
			else sum -= curr_val;
			last_val = curr_val;
		}
		return sum;
	}

	//Returns length of minimal Roman Numeral form of a number
	public static int rn_length(int n) {
		int sum = 0;

		sum += (int)n/1000;
		n = n%1000;

		if ((n >= 900) || (n >= 400 && n < 500)) sum += 2;
		else if (n >= 500) sum += (1 + (int)((n-500)/100));
		else sum += (int)n/100;
		n = n%100;

		if ((n >= 90) || (n >= 40 && n < 50)) sum += 2;
		else if (n >= 50) sum += (1 + (int)((n-50)/10));
		else sum += (int)n/10;
		n = n % 10;

		if ((n >= 9) || (n >= 4 && n < 5)) sum += 2;
		else if (n >= 5) sum += (1 + n - 5);
		else sum += n;

		return sum;
	}
}