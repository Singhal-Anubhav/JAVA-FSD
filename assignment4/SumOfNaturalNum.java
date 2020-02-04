import java.util.*;
class SumOfNaturalNum{
	static int calculateSum(int n){
		int sum=0;
		for(int i=1;i<=n;i++){
			if(i%3 == 0 || i%5 == 0){
				sum = sum+i;
			}
			else{
				continue;
			}
        }
        return sum;
	}



	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the value Of N:....");
		int n = scan.nextInt();

		System.out.println(" The sum of first " +n +" natural numbers which are divisible by 3 or 5...");
		System.out.println(calculateSum(n));

		

	}
}