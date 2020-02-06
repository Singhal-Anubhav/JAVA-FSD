import java.util.*;
class CustomClassCollectionAPI{
	public static void main(String[] args) {
		Computer first = new Computer("HP","Black","4ff4",500,8);
		Scanner scan =new Scanner(System.in);
            List list =new ArrayList();

            list.add(first);
 
        System.out.println("List : " + list);

		System.out.println("Enter the Following operations u need to be done...");         
		System.out.println("Enter 1 if u want to add...");                                   
		System.out.println("Enter 2 if u want to Display... ");                                   
		System.out.println("Enter 3 if u want to Search...");                                      
		System.out.println("Enter 4 if u want to delete... ");                                 
		System.out.println("Enter 5 if u want to Update... ");                                 
		int in = scan.nextInt(); 


switch(in){
		case 1 :
		System.out.println("Enter the number of computers you need to be add:...");
		int n= scan.nextInt();

		for(int i=1;i<=n;i++){
			System.out.println("Enter the following properties related to the Computer " +i +"...");
			Computer comp = input();
			list.add(comp);
		}

		System.out.println("List of the Following computers are:...");
		for(Object obj : list){
			System.out.println(obj +" ");
		}
		break;

		case 2 :
		System.out.println(list);

         case 3 :

		System.out.println("Enter the value according to which u need to search a computer... ");         
		System.out.println("Enter 1 if u want to search by Brand... ");                                   
		System.out.println("Enter 2 if u want to search by color... ");                                   
		System.out.println("Enter 3 if u want to search by id... ");                                      
		System.out.println("Enter 4 if u want to search by hddSize... ");                                 
		System.out.println("Enter 5 if u want to search by ramSize... ");                                 
		int search = scan.nextInt();                                                                      
                                                                                                           
		Search(search,list);  
		break;                                                                             
        
       
        case 4 :
        scan.nextLine();
        System.out.println("Enter the Id of Computer needed to be delete...");
        String delete_id = scan.nextLine();
        for(Object dltvalue : list){
        	if(delete_id.equals(((Computer)dltvalue).getId())){
        		list.remove((Computer)dltvalue);
        		break;
        	}
        }

        System.out.println(list);
        break;

        case 5 :
		update(list);
		break;

		
}


	}

	public static void update(List list){
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the Id of the Computer needed to be update... ");                                
		String update_num = scan.nextLine(); 

		boolean flag = false;

		for(Object value : list){
			if(update_num.equals(((Computer)value).getId()));{
			flag =true;
			System.out.println("Enter 1 if u need to update Brand...");
			System.out.println("");
			System.out.println("Enter 2 if u need to update color...");
			System.out.println("");
			System.out.println("Enter 3 if u need to update ramSize...");
			System.out.println("");
			System.out.println("Enter 4 if u need to update hddSize...");
			int num1 = scan.nextInt();

			switch(num1){
				case 1 : 
				scan.nextLine();
				 System.out.println("Enter the Updated value of brand...");
				 String brand1 = scan.nextLine();

				 ((Computer)value).setBrand(brand1);
				 System.out.println(list);
				 break;

				 case 2 : 
				 scan.nextLine();
				 System.out.println("Enter the Updated value of color...");
				 String color1 = scan.nextLine();

				 ((Computer)value).setColor(color1);
				 System.out.println(list);
				 break;

				 case 3 : 
				 scan.nextLine();
				 System.out.println("Enter the Updated value of hddSize...");
				 int hddSize1 = scan.nextInt();

				 ((Computer)value).sethddSize(hddSize1);
				 System.out.println(list);
				 break;

				 case 4 : 
				 scan.nextLine();
				 System.out.println("Enter the Updated value of ramSize...");
				 int ramSize1 = scan.nextInt();

				 ((Computer)value).setramSize(ramSize1);
				 System.out.println(list);
				 break;

				 default :
				 try{
				 	throw new IllegalStateException();
				 }catch(IllegalStateException ex){
				 	ex.printStackTrace();
				 }
				 break;

			}
		}
	}

	 if(flag == false){
	 	System.out.println("id not found");
	 }

		// switch(n){
		// 	case 1 :
		// 	System.out.println("Enter the name of  brand need to be change...");
		// 	String old_brand = scan.nextLine();
		// 	System.out.println("Enter the updated brand name...");
		// 	String update_brand = scan.nextLine();
		// 	boolean flag = false;
		// 	for(Object value : list){
		// 		int index_brand = list.indexOf(old_brand);
		// 		list.set(index_brand,update_brand);
		// 	}
		// 	break;
		// }
	}


public static void Search(int n,List list){
	Scanner scan =new Scanner(System.in);

	switch(n){
		case 1 :
		System.out.println("Enter the name of Brand:");
		String str =scan.nextLine();
		boolean flag_brand =false;
		for(Object value : list){
			if(str.equals(((Computer)value).getBrand())){
				System.out.println(value);
				flag_brand =true;
			}
		}
		if(flag_brand == false){
				System.out.println("Not Found....");
			}
		break;

		case 2 :
		System.out.println("Enter the name of color:");
		String str1 =scan.nextLine();
		boolean flag =false;
		for(Object value : list){
			if(str1.equals(((Computer)value).getColor())){
				System.out.println(value);
				flag =true;
			}
		}
		if(flag == false){
				System.out.println("Not Found....");
			}
		break;

		case 3 :
		System.out.println("Enter the name of id:");
		String str2 =scan.nextLine();
		boolean flag_color =false;
		for(Object value : list){
			if(str2.equals(((Computer)value).getId())){
				System.out.println(value);
				flag_color = true;
			}
		}
		if(flag_color == false){
				System.out.println("Not Found....");
			}
		break;

		case 4 :
		System.out.println("Enter the size of hdd:");
		int str3 =scan.nextInt();
		boolean flag_hdd =false;
		for(Object value : list){
			if(str3 == (((Computer)value).getHddSize())){
				System.out.println(value);
				flag_hdd = true;
			}
		}
		if(flag_hdd == false){
				System.out.println("Not Found....");
			}
		break;

		case 5 :
		System.out.println("Enter the size of ram:");
		int str4 =scan.nextInt();
		boolean flag_ram =false;
		for(Object value : list){
			if(str4 == (((Computer)value).getRamSize())){
				System.out.println(value);
				flag_ram = true;
			}
		}
		if(flag_ram == false){
				System.out.println("Not Found....");
			}
		break;
	}

}

    public static Computer input(){
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter the brand name...");
    	String brand =scan.nextLine();
    	System.out.println("Enter the color name...");
    	String color =scan.nextLine();
    	System.out.println("Enter the computer ID name...");
    	String id =scan.nextLine();
    	System.out.println("Enter the hddSize name...");
    	int hddSize =scan.nextInt();
    	System.out.println("Enter the ramSize name...");
    	int ramSize =scan.nextInt();


    	return (new Computer(brand,color,id,hddSize,ramSize));
 }


}




	class Computer{
	    String brand, color,id;
	    int hddSize, ramSize;

	 
	    Computer(String brand, String color,String id, int hddSize, int ramSize){
	        this.brand = brand;
	        this.color = color;
	        this.id = id;
	        this.hddSize = hddSize;
	        this.ramSize = ramSize;
	    }
	 
	    public String getColor(){
	        return this.color;
	    }

	     public String getId(){
	        return this.id;
	    }
	 
	    public String getBrand(){
	        return this.brand;
	    }
	 
	    public Integer getHddSize(){
	        return this.hddSize;
	    }
	     
	    public Integer getRamSize(){
	        return this.ramSize;
	    }

	    public void setColor(String color_update){
	    	this.color = color_update;
	    }

	    public void setBrand(String brand_update){
	    	this.brand = brand_update;
	    }

	    public void sethddSize(Integer hdd_update){
	    	this.hddSize = hdd_update;
	    }

	    public void setramSize(Integer ram_update){
	    	this.ramSize = ram_update;
	    }
	 
	    @Override
	    public String toString(){
	        return "Computer : (" + this.getBrand() + ", " + this.getColor() +" , " +this.getId()
	            + ", " + this.getHddSize()
	            + ", " + this.getRamSize()
	            + ")";
	    }
	  
	}
