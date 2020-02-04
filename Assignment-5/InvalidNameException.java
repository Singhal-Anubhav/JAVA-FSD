import java.util.*;
class EmployeeFirstNameException extends Exception{

	void EmployeeFirstNameException(){

		System.out.println("Invalid First Name...");
	}
}


class EmployeeLastNameException extends Exception{

	void EmployeeLastNameException(){

		System.out.println("Invalid last Name...");
	}
}

class InvalidNameException{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the First Name...");
		String fn = scan.nextLine();
		System.out.println("Enter the Last Name...");
		String ln = scan.nextLine();
		int fn1 = fn.length();
		int ln1 = ln.length();

		try{
			if(fn1 == 0 ){
				throw new EmployeeFirstNameException();
			}
		}
		catch(EmployeeFirstNameException fnex){
			fnex.EmployeeFirstNameException();
		}


		try{
			if( ln1 == 0){
				throw new EmployeeLastNameException();
			}
		}
		catch(EmployeeLastNameException lnex){
			lnex.EmployeeLastNameException();
		}
         if(fn1 !=0 && ln1 !=0){
		System.out.println("VAlid Name...");
          }
	}
}