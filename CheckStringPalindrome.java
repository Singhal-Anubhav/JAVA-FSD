import java.util.Scanner;
class CheckStringPalindrome{
	public static void main(String[] args) {

      	Scanner scan = new Scanner(System.in);
        System.out.println("Enter the String:");
		StringBuffer str = new StringBuffer(scan.nextLine());

		String str1=str.toString();

		StringBuffer newstr = str.reverse();
		System.out.println("Reverse String is:" +newstr);

		String newstr1=newstr.toString();

		if(str1.equals(newstr1)){
			System.out.println("It is an Palindrome... ");
		}
		else{
			System.out.println("It is not an Palindrome");
		}

	}
}