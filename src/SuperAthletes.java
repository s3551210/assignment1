import java.util.concurrent.ThreadLocalRandom;

public class SuperAthletes extends Athletes{

	public SuperAthletes(String ID, String name, int age, String state, int totalPoints) {
		super(ID, name, age, state, totalPoints);
	}

//	can compete in all three games.
	// It will cast all methods from other athletes based on the game
	@Override
	public int compete() {
		if (getID() == "S01") {
			return ThreadLocalRandom.current().nextInt(getMinTime(), getMaxTime() + 1);
		} else if (getID() == "C01") {
			return ThreadLocalRandom.current().nextInt(getMinTime(), getMaxTime() + 1);
		} else {
			 return ThreadLocalRandom.current().nextInt(getMinTime(), getMaxTime() + 1);
		}
	}

	@Override
	public int getMinTime() {
//		this.MIN_TIME = MIN_TIME;
		return MIN_TIME;
	}

	@Override
	public int getMaxTime() {
//		this.MAX_TIME = MAX_TIME;
		return MAX_TIME;
	}

	@Override
	public String athleteID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAthleteName() {
		// TODO Auto-generated method stub
		return null;
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
