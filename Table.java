class Table{
	public static void main(String[] args) {
		int t;
		int limit;
		int value;
		t=Integer.parseInt(args[0]);
		limit=Integer.parseInt(args[1]);
          for(int i=1;i<100;i++){
          	value=t*i;
          	if(value <= limit){
          		System.out.println(t +" * " +i +" = " +value);
          	}
          	else{
          		break;
          	}
          }
	}
}