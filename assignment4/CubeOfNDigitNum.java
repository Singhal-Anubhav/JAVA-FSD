import java.util.*;
class CubeOfNDigitNum{

	static void Cube(String st){
		int sum=0;
          int []arr = new int[st.length()];
          for(int i=0;i<st.length();i++){
          	arr[i]=st.charAt(i)-48;
          }
          int []arr2 = new int[st.length()];
          for(int j=0;j<st.length();j++){
          	arr2[j] = arr[j]*arr[j]*arr[j];
          	System.out.println("Cube of Num " +arr[j] +" is " +arr2[j]);
          	sum = sum+arr2[j];
          }
          System.out.println("The sum of the cubes of the digits of an n digit number ..." +sum);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Num...");
        String s = new String(scan.nextLine());
		Cube(s);
	}
}