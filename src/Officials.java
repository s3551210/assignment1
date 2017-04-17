import java.util.ArrayList;

/**
 * This class provides Officials objects which inherited from Participants class
 */

public class Officials extends Participations {

	private int FIRST_PLACE = 5;
	private int SECOND_PLACE = 2;
	private int THIRD_PLACE = 1;

	public Officials(String ID, String name, int age, String state) {
		super(ID, name, age, state);
	}

	/**
	 * After running compete function, sort the athlete based on finishing time.
	 * This function is used only to display the final result for each game
	 * instantly
	 */
	protected void calculateFinishingTime(Athletes[] game) {
		boolean swapped = true;
		int j = 0;
		Athletes[] tempArray = new Athletes[1];
		while (swapped) {
			swapped = false;
			j++;
			for (int i = 0; i < game.length - j; i++) {
				if (game[i].timeAchieved > game[i + 1].timeAchieved) {
					tempArray[0] = game[i];
					game[i] = game[i + 1];
					game[i + 1] = tempArray[0];
					swapped = true;
				}
			}
		}
	}

	/**
	 * Sort athletes based on the running game and add there points for the top
	 * three then display the result
	 */
	protected void displayAthletesArrangement(Athletes[] athleteName, String userPredictionValue) {
		athleteName[0].setTotalPoints(FIRST_PLACE);
		athleteName[1].setTotalPoints(SECOND_PLACE);
		athleteName[2].setTotalPoints(THIRD_PLACE);

		for (int x = 0; x < athleteName.length; x++) {
			if (x == 0) {
				checkUserPrediction(athleteName[x].getAthleteName(), userPredictionValue);
				System.out.println(athleteName[x].getAthleteName() + "\t" + athleteName[x].getTimeAchieved() + " sec\t"
						+ FIRST_PLACE + " Ponits");
			} else if (x == 1) {
				System.out.println(athleteName[x].getAthleteName() + "\t" + athleteName[x].getTimeAchieved() + " sec\t"
						+ SECOND_PLACE + " Ponits");
			} else if (x == 2) {
				System.out.println(athleteName[x].getAthleteName() + "\t" + athleteName[x].getTimeAchieved() + " sec\t"
						+ THIRD_PLACE + " Ponit");
			} else
				System.out.println(athleteName[x].getAthleteName() + "\t" + athleteName[x].getTimeAchieved() + " sec\t"
						+ "0" + " Ponit");
		}
	}

	/**
	 * Check user prediction and display congratulation message if correct. This
	 * function will return nothing for empty prediction
	 */
	private void checkUserPrediction(String athleteName, String userPredictionValue) {
		String firstWinner = athleteName.toUpperCase();
		if (userPredictionValue != null) {
			boolean userPrediction = new String(firstWinner).equals(userPredictionValue.toUpperCase());
			if (userPrediction) {
				System.out.println("Congratulations You got the right winner");
				System.out.println("------<(  Congratulations  )>------");
				System.out.println("----<( Your guessing correct )>----");
			}
		}
		userPredictionValue = null;
	}

	/**
	 * Sort athletes based on the highest total points and add the result to
	 * arrayList
	 */
	protected void sortAthletesBasedOnPoints(Athletes[] athletesPoints, ArrayList<String> athletesArrayList) {
		sortAthleteDescending(athletesPoints);
		addToAthletesArrayList(athletesPoints, athletesArrayList);
		athletesArrayList.add("Referee: " + this.name);
		athletesArrayList.add("-----------------------------------");
	}

	/** Sort athletes' arrays based on total points */
	private void sortAthleteDescending(Athletes[] athletesPoints) {
		boolean swapped = true;
		int j = 0;
		Athletes[] tempArray = new Athletes[1];
		while (swapped) {
			swapped = false;
			j++;
			for (int i = 0; i < athletesPoints.length - j; i++) {
				if (athletesPoints[i].getTotalPoints() < athletesPoints[i + 1].getTotalPoints()) {
					tempArray[0] = athletesPoints[i];
					athletesPoints[i] = athletesPoints[i + 1];
					athletesPoints[i + 1] = tempArray[0];
					swapped = true;
				}
			}
		}

	}

	/** Store the game result in arrayList to be displayed when needed */
	private void addToAthletesArrayList(Athletes[] athleteArrayList, ArrayList<String> athletesArrayList) {
		for (int z = 0; z < athleteArrayList.length; z++) {
			athletesArrayList.add(athleteArrayList[z].getID().concat("\t" + athleteArrayList[z].getAthleteName()
					.concat("\t: " + String.valueOf(athleteArrayList[z].getTotalPoints()).concat(" Points"))));
		}

	}

	/** Print the game result */
	protected void printGameResultArrayList(ArrayList<String> athletesArrayList) {
		for (int i = 0; i < athletesArrayList.size(); i++) {
			System.out.println(athletesArrayList.get(i));
		}
	}

	/** Display athletes' names and their points */
	protected void printAthletesPoints(Athletes[] athletesPoints) {
		sortAthleteDescending(athletesPoints);
		int checkTotalPoint = 0;
		for (int f = 0; f < athletesPoints.length; f++) {
			checkTotalPoint += athletesPoints[f].getTotalPoints();
		}

		if (checkTotalPoint != 0) {
			for (int e = 0; e < athletesPoints.length; e++) {
				System.out.println(athletesPoints[e].getAthleteName() + "\t" + athletesPoints[e].getTotalPoints());
			}
			System.out.println("-----------------------------------");
		}
	}
}
