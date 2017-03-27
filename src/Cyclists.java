import java.util.concurrent.ThreadLocalRandom;

public class Cyclists extends Athletes{

	public Cyclists(String ID, String name, int age, String state, int totalPoints) {
		super(ID, name, age, state, totalPoints);
	}

	@Override
	public int compete(int timeRandomGeneration) {
		timeRandomGeneration = ThreadLocalRandom.current().nextInt(500, 800 + 1);
		return timeRandomGeneration;
	}
	

}
