import java.util.concurrent.ThreadLocalRandom;

public class SuperAthletes extends Athletes{

	public SuperAthletes(String ID, String name, int age, String state, int totalPoints) {
		super(ID, name, age, state, totalPoints);
	}

	@Override
	public int compete(int timeRandomGeneration) {
		if (getID() == "S01") {
			timeRandomGeneration = ThreadLocalRandom.current().nextInt(getMinTime(MIN_TIME), getMaxTime(MAX_TIME) + 1);
		} else if (getID() == "C01") {
			timeRandomGeneration = ThreadLocalRandom.current().nextInt(getMinTime(MIN_TIME), getMaxTime(MAX_TIME) + 1);
		} else {
			timeRandomGeneration = ThreadLocalRandom.current().nextInt(getMinTime(MIN_TIME), getMaxTime(MAX_TIME) + 1);
		}
		return timeRandomGeneration;
	}

	@Override
	public int getMinTime(int MIN_TIME) {
//		this.MIN_TIME = MIN_TIME;
		return MIN_TIME;
	}

	@Override
	public int getMaxTime(int MAX_TIME) {
//		this.MAX_TIME = MAX_TIME;
		return MAX_TIME;
	}
	

}
