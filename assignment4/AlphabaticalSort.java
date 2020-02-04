import java.util.*;
class AlphabaticalSort{
	static void sort(String st){
// 		Scanner scan =new Scanner(System.in);
// System.out.println("enter the length of array:...");
// int length = scan.nextInt();
		String []arr = new String[st.length()];
		System.out.println("enter the String:...");
		for(int i=0;i<st.length();i++){
			arr[i] = st[0];
		}
           for(int i=0;i<st.length();i++){
			System.out.println(arr[i]);
		}


	}


 //        for(int i=0;i<st.length()-1;i++){
 //        	for(int j=i+1;j<st.length();j++){
 //        		if(arr[i] > arr[j]){
 //        			int temp =arr[i];
 //        			arr[i] = arr[j];
 //        			arr[j] = temp;
 //        		}
 //        	}
 //        }


 //        char []arr2 = new char[st.length()];

 //        for(int i=0;i<st.length();i++){
 //        	arr2[i] = (char)arr[i];
 //        }

 //        if(st.length()%2 == 0){
                
 //        }
	// }
  










	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = new String(scan.nextLine());
		sort(input);
	}
}