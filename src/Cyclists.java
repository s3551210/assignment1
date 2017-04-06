import java.util.concurrent.ThreadLocalRandom;

public class Cyclists extends Athletes{
	
	

	public Cyclists(String ID, String name, int age, String state, int totalPoints) {
		super(ID, name, age, state, totalPoints);
	}

	@Override
	public int getMinTime() {
		this.MIN_TIME = 500;
		return MIN_TIME;
	}

	@Override
	public int getMaxTime() {
		this.MAX_TIME = 800;
		return MAX_TIME;
	}
	
	@Override
	public int compete() {
		return ThreadLocalRandom.current().nextInt(getMinTime(), getMaxTime() + 1);
	}

	@Override
	public String athleteID() {
		return this.ID;
	}

	@Override
	public String getAthleteName() {
		return this.name;
	}

	@Override
	public int getTotalPoints() {
		return this.totalPoints;
	}

	@Override
	public int setTotalPoints(int points) {
		this.totalPoints=+points;
		return this.totalPoints;
	}
	
	

}
