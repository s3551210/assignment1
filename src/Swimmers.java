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
		timeRandomGeneration = ThreadLocalRandom.current().nextInt(100, 200 + 1);
		return timeRandomGeneration;
	}


}
