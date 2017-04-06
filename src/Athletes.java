
public abstract class Athletes extends Participations {

	protected int totalPoints = 0;
	protected int MIN_TIME;
	protected int MAX_TIME;
//	private int timeCompete;
	public Athletes(String ID, String name, int age, String state, int totalPoints){
		super(ID, name, age, state);
		this.totalPoints = totalPoints;
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
	
//	public abstract int getCompete();
	
//	public abstract int setCompete(int time);
	
	
}