import java.util.*;
class SumOfIntInString{
	public static void main(String[] args) {
		int sum=0;

		Scanner scan = new Scanner(System.in);
		
			System.out.println("Enter the string of number :....");
		
			String input =new String(scan.nextLine());

			StringTokenizer dividedInput = new StringTokenizer(input," ");

			System.out.println("Individual numbers after using StringTokenizer class :...");
			while(dividedInput.hasMoreTokens()){
				String temp=dividedInput.nextToken();

				int n = Integer.parseInt(temp);
              System.out.println(n);
				sum = sum+n;
	}
	System.out.println("The Sum of all the individual integers are:...");
			System.out.println(sum);
}
}