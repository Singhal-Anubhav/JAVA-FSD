import java.util.*;
class IncreasingNum{
	static boolean checkNumber(int n){
		String str =new String(Integer.toString(n));
		

		int []arr = new int[str.length()];
		for(int i= 0;i<str.length();i++){
			arr[i] = str.charAt(i)-48;
			//  System.out.println(arr[i] +" ");
		}

		boolean result = false;
		for(int i=0;i<str.length()-1;i++){
			if(arr[i] > arr[i+1]){
				//  System.out.println(n +"is not an increasing number...");
				result = false;
			}
			else{
				result = true;
			}

		}

		 // if(result == true){
		 // 	System.out.println(n +" is an increasing number...");
		 // }
                return result;
		}



	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the value Of N:....");
		int n = scan.nextInt();

	boolean value = checkNumber(n);
	if(value == true){
		System.out.println(n +" is an increasing number...");
	}
	else{
		System.out.println(n +" is not an increasing number...");
	}
	}

}