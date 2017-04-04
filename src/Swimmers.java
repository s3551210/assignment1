import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Swimmers extends Athletes{
	
	Random rand = new Random();

	public Swimmers(String ID, String name, int age, String state, int totalPoints) {
		super(ID, name, age, state, totalPoints);
	}
	
	// time randomly generate, 
	// 100 to 200 seconds for swimming
//	@Override
//	public int compete(int timeRandomGeneration) {
//		timeRandomGeneration = ThreadLocalRandom.current().nextInt(getMinTime(MIN_TIME), getMaxTime(MAX_TIME) + 1);
//		return timeRandomGeneration;
//	}
	
	@Override
	public int compete() {
		return ThreadLocalRandom.current().nextInt(getMinTime(), getMaxTime() + 1);
	}

	@Override
	public int getMinTime() {
		this.MIN_TIME = 100;
		return MIN_TIME;
	}

	@Override
	public int getMaxTime() {
		this.MAX_TIME = 200;
		return MAX_TIME;
	}
	
	public void testPrint(){
		System.out.println("test");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
