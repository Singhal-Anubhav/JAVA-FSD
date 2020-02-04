import java.util.*;
class PositiveString{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        System.out.println("Enter the String need to be Check:...");
        String input = new String(scan.nextLine());

        int []arr = new int[input.length()];
        int flag = 0;

       
        for(int i=0;i<input.length();i++){
        	arr[i] = input.charAt(i);
        	System.out.println(arr[i]);
        }


          boolean result = false;

        for(int j=0;j<input.length()-1;j++){
        	if(arr[j] > arr[j+1]){
        		System.out.println("The String is a Negative String....");
        		result=false;
        		break;
        	}
        	else{
                 result = true;
        	}
        }
        
        if(result == true){
        	System.out.println("The String is a Positive String....");
        }
	}
}