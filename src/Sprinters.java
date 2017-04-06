import java.util.concurrent.ThreadLocalRandom;

public class Sprinters extends Athletes{

	public Sprinters(String ID, String name, int age, String state, int totalPoints) {
		super(ID, name, age, state, totalPoints);
	}
	
	@Override
	public int compete() {
		return ThreadLocalRandom.current().nextInt(getMinTime(), getMaxTime() + 1);
	}

	@Override
	public int getMinTime() {
		this.MIN_TIME = 10;
		return MIN_TIME;
	}

	@Override
	public int getMaxTime() {
		this.MAX_TIME = 20;
		return MAX_TIME;
	}

	@Override
	public String athleteID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAthleteName() {
		return name;
	}

	@Override
	public int getTotalPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setTotalPoints(int point) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
