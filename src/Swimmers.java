import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Swimmers extends Athletes{
	
	Random rand = new Random();

	public Swimmers(String ID, String name, int age, String state, int totalPoints, int timeAchieved) {
		super(ID, name, age, state, totalPoints, timeAchieved);
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
	public String athleteID() {
		return ID;
	}

	@Override
	public String getAthleteName() {
		return name;
	}

	@Override
	public int getTotalPoints() {
		return totalPoints;
	}

	@Override
	public int setTotalPoints(int point) {
		this.totalPoints =+ point;
		return totalPoints;
	}

	@Override
	public int getTimeAchieved() {
		return timeAchieved;
	}

	@Override
	public void setTimeAchieved(int timeAchieved) {
		this.timeAchieved = timeAchieved;
	}

//	@Override
//	public int getCompete() {
//		// TODO Auto-generated method stub
//		return 0;
//	}

//	@Override
//	public int setCompete(int time) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
