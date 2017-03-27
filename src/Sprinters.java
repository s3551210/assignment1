import java.util.concurrent.ThreadLocalRandom;

public class Sprinters extends Athletes{

	public Sprinters(String ID, String name, int age, String state, int totalPoints) {
		super(ID, name, age, state, totalPoints);
	}
	
	@Override
	public int compete(int timeRandomGeneration) {
		timeRandomGeneration = ThreadLocalRandom.current().nextInt(getMinTime(MIN_TIME), getMaxTime(MAX_TIME) + 1);
		return timeRandomGeneration;
	}

	@Override
	public int getMinTime(int MIN_TIME) {
		this.MIN_TIME = 10;
		return MIN_TIME;
	}

	@Override
	public int getMaxTime(int MAX_TIME) {
		this.MAX_TIME = 20;
		return MAX_TIME;
	}
	
}
