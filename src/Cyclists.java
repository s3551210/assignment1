/**
 * This class provides Cyclists objects with their variables and methods  
 */

import java.util.concurrent.ThreadLocalRandom;

public class Cyclists extends Athletes {
	public static final int MIN_TIME = 500;
	public static final int MAX_TIME = 800;

	public Cyclists(String ID, String name, int age, String state, int totalPoints, int timeAchieved) {
		super(ID, name, age, state, totalPoints, timeAchieved);
	}

	@Override
	public int compete() {
		return ThreadLocalRandom.current().nextInt(MIN_TIME, MAX_TIME + 1);
	}

	@Override
	public String getAthleteName() {
		return this.name;
	}

	@Override
	public int getTotalPoints() {
		return this.totalPoints;
	}

	@Override
	public int setTotalPoints(int point) {
		totalPoints = getTotalPoints() + point;
		return this.totalPoints;
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