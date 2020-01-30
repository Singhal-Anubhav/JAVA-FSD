import java.util.Scanner;
class SelectionSort{
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		int []arr = new int[5];
System.out.println("Enter the 5 values in an Array");
		for(int i=0;i<arr.length;i++){
			arr[i]=scan.nextInt();
		}

		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
               if(arr[i] > arr[j]){
               	int temp = arr[i];
               	arr[i] = arr[j];
               	arr[j] = temp;
               }
               else{
               	continue;
               }
			}
		}
             System.out.println("Sorted Array Represented as :...");
		for(int i=0;i<5;i++){
			System.out.print(arr[i] +" ");
		}
	}
}