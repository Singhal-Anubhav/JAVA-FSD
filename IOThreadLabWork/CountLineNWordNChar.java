import java.util.Scanner;
import java.io.*;

public class CountLineNWordNChar
{
    public static void main(String[] input)
    {
        String fname;
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter File Name to Open with extension  : ");
        fname = scan.nextLine();
        
        String line = null;
        String []words = null;
   
        try
        {
            FileReader fileReader = new FileReader(fname);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int charactercount = 0;

            int linenumber =0;

            int wordcount = 0;

            charactercount = fname.length();
            while((line = bufferedReader.readLine()) != null)
            {
               
                words = line.split(" ");
                wordcount = wordcount + words.length;
                linenumber++;

                for(String character : words){
            	charactercount = charactercount + character.length();
            }

            }
            
            System.out.println("The word Count is:" +wordcount);
        System.out.println("The line Count is:" +linenumber);
        System.out.println("The Char Count is:" +charactercount);

            bufferedReader.close();
        }
        catch(IOException ex)
        {
            System.out.println("Error reading file named '" + fname + "'");
        }

        

    }
}