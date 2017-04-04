import java.util.Arrays;

public class Officials extends Participations{

	public Officials(String ID, String name, int age, String state) {
		super(ID, name, age, state);
	}
	
//	Official is the one that can summarize the score each game
	
	
//	1- Get all finishing time for all athletes
//	2- Order athletes based on their finishing time
//	3- Add point for them based on their order;
//	4- Print result
	
	// store all times then use sort function from upper to lower
	public int calculateFinishingTime(int finishingTime){
		Arrays [] points = new Arrays[8];
		int i = 0;
		for (i = 0; i<=points.length; i++){
//			points[i]= new Arrays("test");
		}
		return finishingTime;
	}
	
	public int orderAthletes(int athletesOrder){
		return athletesOrder;
	}
	
	public void calculateScore(){
		
	}
	
	public void displayFinalResult(){
		System.out.println("Final Result:");
		System.out.println("First : ");
		System.out.println("Second: ");
		System.out.println("Third : ");
	}
	
	
	

}
