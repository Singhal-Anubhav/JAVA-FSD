import java.util.Scanner;
class BubbleSort{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the 5 values of an array need to be sorted:....");
		int []arr = new int[5];
		for(int i=0;i<arr.length;i++){
			arr[i]=scan.nextInt();
		}

		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j] > arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
				else{
					continue;
				}
			}
		}

		System.out.println("The Sorted Array can be Represented as:...");
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i] +" ");
		}

	}
}