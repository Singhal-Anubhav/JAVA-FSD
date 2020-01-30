class Fibonocci{
	public static void main(String[] args) {
		int a=1;
		int b=1;
		int constant=1;
		int next=1;
		System.out.print("Fibonocci series from 1 to 89 is:" +a +" " +b +" ");
		for(int i=1;i<100;i++){
            b=a+b;
            a=b-a;
            System.out.print(b);
		if(b >= 89){
			break;
		}
		
		System.out.print(" ");

		}
	}
}