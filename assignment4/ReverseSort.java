import java.util.*;
/*class reverseSort{
   static void getSorted(int []arr){
   String []arr2 = new String[arr.length];
   	for(int i= 0;i<arr.length;i++){
         arr2[i] =Integer.toString(arr[i]);
   	}
     StringBuilder []arr3 = new StringBuilder[arr.length];
     for(int i=0;i<arr.length;i++){
     	arr3[i].append(arr2[i]);
     	arr3[i] = arr3[i].reverse();
     }

     for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
               if(arr3[i] > arr3[j]){
               	int temp = arr3[i];
               	arr3[i] = arr3[j];
               	arr3[j] = temp;
               }
               else{
               	continue;
               }
			}
		}
             System.out.println("Sorted Array Represented as :...");
		for(int i=0;i<5;i++){
			System.out.print(arr3[i] +" ");
		}

   }


public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the size of the array that is to be created::");
      int size = sc.nextInt();
      int[] myArray = new int[size];
      System.out.println("Enter the elements of the array ::");

      for(int i=0; i<size; i++) {
         myArray[i] = sc.nextInt();
      }

}
}*/

class ReverseSort{
   static int reverse(int num){
   	StringBuilder revstr = new StringBuilder(Integer.toString(num));
   revstr = revstr.reverse();
   return Integer.parseInt(revstr.toString());
   }

   static void getSorted(int []arr){

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

	public static void main(String[] args) {
		Scanner scan  = new Scanner(System.in);
System.out.println("Enter the Length Of an Array:...");
int l = scan.nextInt();
       
       int []arr = new int[l];
System.out.println("Enter the elements of an array:...");
       for(int i=0;i<l;i++){
       	arr[i] = scan.nextInt();
       }

       for(int i = 0;i<l;i++){
       	arr[i] = reverse(arr[i]);
       }

       getSorted(arr);

System.out.println("The Sorted Array After Seprate reversal:...");
       for(int i=0;i<l;i++){
       	System.out.println(arr[i] +" ");
       }
	}

}