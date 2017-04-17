/**
 * This class is created for Participants for both: Athletes and officials. 
 */

public abstract class Participations {
	
	protected String ID;
	protected String name;
	protected int age;
	protected String state;
	
	public Participations (String ID, String name, int age, String state) {
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.state = state;
	}

	public String getID() {
		return ID;
	}
}
