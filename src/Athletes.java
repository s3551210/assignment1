
public abstract class Athletes extends Participations {

	protected int totalPoints = 0;
	protected int MIN_TIME;
	protected int MAX_TIME;
	
	public Athletes(String ID, String name, int age, String state, int totalPoints){
		super(ID, name, age, state);
		this.totalPoints = totalPoints;
	}
	
	public abstract int compete(int timeRandomGeneration);
	
	public abstract int getMinTime(int MIN_TIME);
	
	public abstract int getMaxTime(int MAX_TIME);
	
}