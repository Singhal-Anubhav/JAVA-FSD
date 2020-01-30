import java.util.Scanner;
class StringToStringBuffer{
	public static void main(String[] args) {
		
		Scanner scan =new Scanner(System.in);
		System.out.println("Enter the String:");
		StringBuffer str = new StringBuffer(scan.nextLine());
         
       	System.out.println("Enter the String u need to replace with old one:");
		String str1 = new String(scan.nextLine());


        str = str.replace(0,str1.length(),str1);
        System.out.println(str);

	}
}