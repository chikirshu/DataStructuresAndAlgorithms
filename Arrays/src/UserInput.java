import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UserInput {

	public static void main(String[] args) {
		
		System.out.println("Select 1 for Scanner input and 2 for BufferedReader");
		Scanner sc = new Scanner(System.in);
		if(sc.nextInt()==1) {
			callScanner();
		}
		else {
			try {
				callBuffered();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		sc.close();
	}
	
	private static void callScanner() {
		long startTime, endTime;
		int[] nums = new int[3];
		int i=0;
		System.out.println("Enter the list of numbers to be read using Scanner:");
		Scanner sc1 = new Scanner(System.in);
		startTime = System.nanoTime();
		String[] s = sc1.nextLine().split("\\s");
		for(String s1:s) {
			nums[i]=Integer.parseInt(s1);
			i++;
		}
		endTime = System.nanoTime();
		display(nums);
		System.out.println("\nTotal time Taken:"+(endTime-startTime));
		sc1.close();
	}
	private static void callBuffered() throws IOException {
		long startTime, endTime;
		int[] nums = new int[3];
		String[] strNums;
		int i=0;
		System.out.println("Enter the list of numbers to be read using Buffered:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		startTime = System.nanoTime();
		strNums = br.readLine().split("\\s");
		for(i=0;i<strNums.length;i++) {
			nums[i]=Integer.parseInt(strNums[i]);
		}
		endTime = System.nanoTime();
		display(nums);
		System.out.println("\nTotal time Taken:"+(endTime-startTime));
	}
	
	private static void display(int[] nums) {
		for(int i:nums) {
			System.out.print(i+" ");
		}
	}

}
