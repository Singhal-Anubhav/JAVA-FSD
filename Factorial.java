class Factorial
{
	public static void main(String[] args) 
	{
		int number;
		number = Integer.parseInt(args[0]);
		int constant=1;
		for(int i =1;i<=number;i++)
		{
			constant = i * constant;
		}
		System.out.println("Factorial of the number is:  " + constant);
	}
}