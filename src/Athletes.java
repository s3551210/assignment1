
public abstract class Athletes extends Participations {

	protected int totalPoints;
	protected int MIN_TIME;
	protected int MAX_TIME;
	protected int timeAchieved;
//	private int timeCompete;
	public Athletes(String ID, String name, int age, String state, int totalPoints, int timeAchieved){
		super(ID, name, age, state);
		this.totalPoints = totalPoints;
		this.timeAchieved = timeAchieved;
	}
	
//	public Athletes(String ID, int timeCompete){
//		this.ID = ID;
//		this.timeCompete = timeCompete;
//	}
	
	public abstract int compete();
	
	public abstract int getMinTime();
	
	public abstract int getMaxTime();
	
	public abstract String athleteID();
	
	public abstract String getAthleteName();
	
	public abstract int getTotalPoints();
	
	public abstract int setTotalPoints(int point);

	public abstract int getTimeAchieved();

	public abstract void setTimeAchieved(int timeAchieved);
	
//	public abstract int getCompete();
	
//	public abstract int setCompete(int time);
	
	
}