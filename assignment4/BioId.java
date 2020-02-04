import java.util.*;
class BioId{
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.println("enter the username you want...");
				while(true){
					String str = scan.nextLine();

		int n= str.length();

			if(n >= 12){
				char []arr = str.toCharArray();

				if(arr[n-1] == 'b' && arr[n-2] == 'o' && arr[n-3] == 'j' && arr[n-4] == '_'){
					System.out.println("The Username is Valid...");
					break;
				}
				else{
					System.out.println("The Username is not Valid...");
					System.out.println("Please Re-enter Any other username...");
				}
			}
			else{
				System.out.println("The Username is Not Valid...");
				System.out.println("Please Re-enter Any other username...");
			}
	}
	}
}