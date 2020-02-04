import java.util.*;
class DiffOfSquareSum{

	static int sumOfSquare(int a){
		int sum = 0;
		for(int i=1;i<=a;i++){
			sum = sum+(int)Math.pow(i,2);
		}
		return sum;
	}

	static int squareOfSum(int b){
		int sum2 = 0;
		for(int i=1;i<=b;i++){
			sum2= sum2+i;
		} 
		return (int)Math.pow(sum2,2);
	}

	static int calculateTheDiffernce(int n){                 //calculate the differnce
        int result = sumOfSquare(n) - squareOfSum(n);
        return result;



	}    

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the value of n:...");
		int n = scan.nextInt();

		System.out.println(" the difference between the sum of the squares and the square of the sum of the first n natural numbers");
		System.out.println(calculateTheDiffernce(n));
	}
}