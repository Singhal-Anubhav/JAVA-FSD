import java.util.*;
class TrafficLight{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 1 for Red Traffic Light...");
		System.out.println("Enter 2 for Yellow Traffic Light...");
		System.out.println("Enter 3 for Green Traffic Light...");
		int value = scan.nextInt();
		String message;

		switch(value){
			case 1:
			message = "Stop";
			break;
			case 2:
			message = "Wait";
			break;
			case 3:
			message = "Go";
			break;
			default :
			message = "Invalid input";
			break;
		}

		System.out.println(message);
	}
}