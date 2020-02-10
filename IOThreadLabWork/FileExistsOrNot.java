import java.util.Scanner;
import java.io.*; 

public class FileExistsOrNot{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String fname;

		System.out.println("Enter the name of file with extension :...");
		fname = scan.nextLine();

		File f = new File(fname);


		boolean ex = f.exists();
		if(ex){
			System.out.println("The File Exists");
		}
		else{
			System.out.println("The file does not exists...");
		}

		boolean readable = f.canRead();
		if(readable){
			System.out.println("The File is Readable");
		}
		else{
			System.out.println("The file is not Readable...");
		}


		boolean writable = f.canWrite();
		if(writable){
			System.out.println("The File is writable");
		}
		else{
			System.out.println("The file is not writable...");
		}

		if(ex){
			double bytes = f.length();
			System.out.println("The length of file is:.." +bytes);
		
		}

		String fileName = f.getName();
		if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0){
			System.out.println("The extension of the file is..." +fileName.substring(fileName.lastIndexOf(".")));
		}
		else{
			System.out.println("The extension of the file is ...." +" ");
		}



	}
}