import java.util.*;
class AgeException extends Exception{
	 void AgeException(){

	 	System.out.println("Age is Invalid...");


	}
}
public class InvalidAge
{
    public static void main(String[] args)
    {
          Scanner sc = new Scanner(System.in); 
 
          System.out.println("Enter Your Age");
 
          int age = sc.nextInt();         
 
          try
          {
              if(age < 15)
              {
                  throw new AgeException();    //throws an Exception if age is negative
              }
              System.out.println("Age is Valid...");
          }
          catch(AgeException ex)
          {
              ex.AgeException();     //Prints exception description
          }
    }
}