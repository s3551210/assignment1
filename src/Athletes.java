
public abstract class Athletes extends Participations {

	protected int totalPoints = 0;
	protected int MIN_TIME;
	protected int MAX_TIME;
	
	public Athletes(String ID, String name, int age, String state, int totalPoints){
		super(ID, name, age, state);
		this.totalPoints = totalPoints;
	}
	
	public abstract int compete();
	
	public abstract int getMinTime();
	
	public abstract int getMaxTime();
	
	public abstract String getName();
	
	
}