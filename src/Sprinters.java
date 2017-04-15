import java.util.concurrent.ThreadLocalRandom;

public class Sprinters extends Athletes {
	public static final int MIN_TIME = 10;
	public static final int MAX_TIME = 20;

	public Sprinters(String ID, String name, int age, String state, int totalPoints, int timeAchieved) {
		super(ID, name, age, state, totalPoints, timeAchieved);
	}

	@Override
	public int compete() {
		return ThreadLocalRandom.current().nextInt(MIN_TIME, MAX_TIME + 1);
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
		totalPoints = getTotalPoints() + point;
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

}