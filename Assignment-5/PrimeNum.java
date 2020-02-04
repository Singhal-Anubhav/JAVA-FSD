import java.util.*;
class PrimeNum{
	static boolean prime(int n){
		if(n <=1){
			return true;
		}
		for(int i=2;i<n;i++){
			if(n%i == 0){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.println("Enter the Number upto Which All the prime Numbers needed to be print....");
		int n=scan.nextInt();

		System.out.println("All the prime numbers upto " +n +" are :...");
		for(int i=2;i<n;i++){
			if(prime(i) == true){
				System.out.print(i +" ");
			}
		}
  

	}
}