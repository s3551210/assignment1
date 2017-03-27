import java.util.concurrent.ThreadLocalRandom;

public class SuperAthletes extends Athletes{

	public SuperAthletes(String ID, String name, int age, String state, int totalPoints) {
		super(ID, name, age, state, totalPoints);
	}

	@Override
	public int compete(int timeRandomGeneration) {
		if (getID() == "S01") {
			timeRandomGeneration = ThreadLocalRandom.current().nextInt(100, 200 + 1);
		} else if (getID() == "C01") {
			timeRandomGeneration = ThreadLocalRandom.current().nextInt(500, 800 + 1);
		} else {
			timeRandomGeneration = ThreadLocalRandom.current().nextInt(10, 20 + 1);
		}
		return timeRandomGeneration;
	}
	

}
