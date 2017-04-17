/**
 * This class provides Officials objects which inherited from Participants class  
 */

public abstract class Athletes extends Participations {

	protected int totalPoints;
	protected int MIN_TIME;
	protected int MAX_TIME;
	protected int timeAchieved;
	
	public Athletes(String ID, String name, int age, String state, int totalPoints, int timeAchieved){
		super(ID, name, age, state);
		this.totalPoints = totalPoints;
		this.timeAchieved = timeAchieved;
	}
		
	public abstract int compete();
	
	public abstract String getAthleteName();
	
	public abstract int getTotalPoints();
	
	public abstract int setTotalPoints(int point);

	public abstract int getTimeAchieved();

	public abstract void setTimeAchieved(int timeAchieved);
	
}