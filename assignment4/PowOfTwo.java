import java.util.*;
class PowOfTwo{
	static boolean checkNumber(int n){
		int temp= n;
		while(temp != 1 ){
			if(temp%2 != 0){
				return false;
			}
			temp = temp/2;
		}
		return true;
}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the value need to be check:...");
		int n = scan.nextInt();

		boolean result = checkNumber(n);
		if(result == true){
			System.out.println(n +" is a power of 2...");

		}
		else{
			System.out.println(n +" is not a power of 2...");
		}

	}
}