import java.util.Scanner;
class DecimalToBinary{
	public static void main(String[] args) {
		int dec;
		dec=Integer.parseInt(args[0]);
		int i=0;
		int []arr = new int[10];
		while(dec>0){
			arr[i]=dec%2;
			i++;
			dec=dec/2;
		}
for(int j=i-1;j>0;j--){

	System.out.print(arr[j] +" ");

	}
}
}
//METHOD 1st
/* 
class DecimalToBinary{
	public static void main(String[] args) {
		int dec;
		dec=Integer.parseInt(args[0]);
		while(dec > 0){
			if(dec%2 == 1){
				System.out.print(" 1 ");
			}
			else{
				System.out.print(" 0 ")
			}
		}

}
*/