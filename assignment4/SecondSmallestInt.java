import java.util.*;
class SecondSmallestInt{
	static void sort(int []arr){
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
	}

	static int getSecondSmallest(int []arr){
		return arr[1];
	}
    



	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the length of an array:...");
		int l = scan.nextInt();

		System.out.println("Enter the elemnts of an Array:...");
		int []arr = new int[l];
		for(int i=0;i<l;i++){
			arr[i]= scan.nextInt();
		}

		sort(arr);
		/*System.out.println("The sorted array is:...");
		for(int i=0;i<l;i++){
			System.out.println(arr[i] +" ");
		}
*/


		int result = getSecondSmallest(arr);

		System.out.println("The second Smallest element in an Array is:....");
		System.out.println(result);

	}
}