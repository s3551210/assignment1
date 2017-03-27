import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Swimmers extends Athletes{
	
	Random rand = new Random();

	public Swimmers(String ID, String name, int age, String state, int totalPoints) {
		super(ID, name, age, state, totalPoints);
	}
	
	// time randomly generate, 
	// 100 to 200 seconds for swimming
	@Override
	public int compete(int timeRandomGeneration) {
		timeRandomGeneration = ThreadLocalRandom.current().nextInt(getMinTime(MIN_TIME), getMaxTime(MAX_TIME) + 1);
		return timeRandomGeneration;
	}

	@Override
	public int getMinTime(int MIN_TIME) {
		this.MIN_TIME = 100;
		return MIN_TIME;
	}

	@Override
	public int getMaxTime(int MAX_TIME) {
		this.MAX_TIME = 200;
		return MAX_TIME;
	}


}
