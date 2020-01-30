import java.util.Scanner;
/*
class CharInString{
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.println("Enter the String:");
		String str = new String(scan.nextLine());
     System.out.println("Enter the Character to be find:");
		char word =scan.next().charAt(0);

		int position = str.indexOf(word);
		System.out.println("The position of the Char In The String is at : " +position +" position");
	}
}
*/
class CharInString{
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.println("Enter the String:");
		String str = new String(scan.nextLine());

     System.out.println("Enter the Character to be find:");
		char word =scan.next().charAt(0);

		char []arr = str.toCharArray();

		for(int i=0;i<arr.length;i++){
			if(arr[i] == word){
				System.out.println("The position of the Char In The String is at : " +i +" position");
			}
		}



	}
}