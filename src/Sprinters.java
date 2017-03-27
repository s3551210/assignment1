import java.util.concurrent.ThreadLocalRandom;

public class Sprinters extends Athletes{

	public Sprinters(String ID, String name, int age, String state, int totalPoints) {
		super(ID, name, age, state, totalPoints);
	}

	@Override
	public int compete(int timeRandomGeneration) {
		timeRandomGeneration = ThreadLocalRandom.current().nextInt(10, 20 + 1);
		return timeRandomGeneration;
	}
	
}
