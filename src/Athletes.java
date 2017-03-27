
public abstract class Athletes extends Participations {
	private int totalPoints = 0;
	public Athletes(String ID, String name, int age, String state, int totalPoints){
		super(ID, name, age, state);
		this.totalPoints = totalPoints;
	}
	
	public abstract int compete(int timeRandomGeneration);
	
}
