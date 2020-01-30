class PassNFail{
	public static void main(String[] args) {
		int first;
		int second;
		int third;
      
      first=Integer.parseInt(args[0]);
      second=Integer.parseInt(args[1]);
      third=Integer.parseInt(args[2]);
      int sum= (first + second + third);
	int flag=0;
	if(first >= 40){
		flag++;
	}
	
    if(second >= 40){
		flag++;
	}
	if(third >= 40){
		flag++;
	}

	if(sum >= 125){
		flag++;
	}

	if(flag == 4){
		System.out.println("PASSING");
	}

	if(flag != 4){
		System.out.println("FAILING");
	}
	


	}
}