import java.util.*;
class Fibonacci{
	static int fibo(int n){
		if(n <= 1){
			return n;
		}
		else
			return fibo(n-1) + fibo(n-2);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the value upto which Fibonacci number need to be find:....");
		int value = scan.nextInt();
		System.out.println("The Nth value of Fibonacci Series is:...");
		System.out.println(fibo(value));
}
}