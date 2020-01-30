import java.util.Scanner;
class SearchInArray{

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the 10 values of an array:....");

		int []arr = new int[10];
		for(int i=0;i<10;i++){

			arr[i]=scan.nextInt();
		}
		System.out.println("Enter the Number to be search: ");
		int num = scan.nextInt();

		for(int i=0;i<arr.length;i++){
			if(arr[i] == num){
				System.out.println("The position of number in an Array is:" +i);
			}
			else{
				continue;
			}
		}
	}
}