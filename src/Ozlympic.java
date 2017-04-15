import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Ozlympic {
	public static boolean isGamePlayed = false;
	private static final AtomicInteger swimmingGameCount = new AtomicInteger(0);
	private static final AtomicInteger cyclingGameCount = new AtomicInteger(0);
	private static final AtomicInteger runningGameCount = new AtomicInteger(0);
	public static String selectedGameID;
	public int FIRST_PLACE = 5;
	public int SECOND_PLACE = 2;
	public int THIRD_PLACE = 1;
	public int MAX_ATHLETES = 8;
	public int MIN_ATHLETES = 5;
	public String gameID;
	public static boolean userPrediction = false;
	public static String userPredictionValue;
	public static boolean isGameSelected = false;

	static Scanner input = new Scanner(System.in);

	// Display Main Screen
	public static void displayMainScreen() {
		System.out.println();
		System.out.println("==========(Ozlympic Game)==========");
		System.out.println("1. Select a game to run");
		System.out.println("2. Predict the winner of the game");
		System.out.println("3. Start the game");
		System.out.println("4. Display the final results of all games");
		System.out.println("5. Display the points of all athletes");
		System.out.println("6. Exit");
		System.out.println("-----------------------------------");
		System.out.println("Enter an option: ");
	}

	// Display Sports
	public static void displayGamesMenu() {
		System.out.println();
		System.out.println("==========(    Games    )==========");
		System.out.println("Choose a game number to run:");
		System.out.println("1- Swimming");
		System.out.println("2- Cycling");
		System.out.println("3- Running");
		System.out.println("4- Cancel");
		System.out.println("-----------------------------------");
	}

	public static Swimmers[] swimPlayers = new Swimmers[8];
	public static Cyclists[] cyclingPlayers = new Cyclists[8];
	public static Sprinters[] sprinterPlayer = new Sprinters[8];
	public static Officials referee;
	public static Athletes[] SuperAthlete1 = new Swimmers[1];
	public static Athletes[] SuperAthlete2 = new Cyclists[1];
	public static Athletes[] SuperAthlete3 = new Sprinters[1];
	static ArrayList<String> athletesArrayList = new ArrayList<String>();
	static ArrayList<String> listAthletesPoints = new ArrayList<String>();

	public static void createAthletes() {
		swimPlayers[0] = new Swimmers("SWIM01", "Bell", 21, "VIC", 0, 0);
		swimPlayers[1] = new Swimmers("SWIM02", "Mick", 24, "ACT", 0, 0);
		swimPlayers[2] = new Swimmers("SWIM03", "John", 22, "NSW", 0, 0);
		swimPlayers[3] = new Swimmers("SWIM04", "Robot", 21, "NT", 0, 0);
		swimPlayers[4] = new Swimmers("SWIM05", "Olivr", 20, "SA", 0, 0);
		swimPlayers[5] = new Swimmers("SWIM06", "Jack", 23, "QLD", 0, 0);
		swimPlayers[6] = new Swimmers("SWIM07", "Noah", 20, "TAS", 0, 0);
		swimPlayers[7] = new Swimmers("SWIM08", "James", 23, "WA", 0, 0);

		cyclingPlayers[0] = new Cyclists("CYCL01", "AA", 19, "NSW", 0, 0);
		cyclingPlayers[1] = new Cyclists("CYCL02", "BB", 19, "NSW", 0, 0);
		cyclingPlayers[2] = new Cyclists("CYCL03", "CC", 19, "NSW", 0, 0);
		cyclingPlayers[3] = new Cyclists("CYCL04", "DD", 19, "NSW", 0, 0);
		cyclingPlayers[4] = new Cyclists("CYCL05", "EE", 19, "NSW", 0, 0);
		cyclingPlayers[5] = new Cyclists("CYCL06", "FF", 19, "NSW", 0, 0);
		cyclingPlayers[6] = new Cyclists("CYCL07", "GG", 19, "NSW", 0, 0);
		cyclingPlayers[7] = new Cyclists("CYCL08", "HH", 19, "NSW", 0, 0);

		sprinterPlayer[0] = new Sprinters("SPRN01", "III", 24, "NT", 0, 0);
		sprinterPlayer[1] = new Sprinters("SPRN02", "JJJ", 22, "NT", 0, 0);
		sprinterPlayer[2] = new Sprinters("SPRN03", "KKK", 22, "NT", 0, 0);
		sprinterPlayer[3] = new Sprinters("SPRN04", "LLL", 22, "NT", 0, 0);
		sprinterPlayer[4] = new Sprinters("SPRN05", "MMM", 21, "NT", 0, 0);
		sprinterPlayer[5] = new Sprinters("SPRN06", "NNN", 23, "NT", 0, 0);
		sprinterPlayer[6] = new Sprinters("SPRN07", "OOO", 23, "NT", 0, 0);
		sprinterPlayer[7] = new Sprinters("SPRN08", "PPP", 23, "NT", 0, 0);

		SuperAthlete1[0] = new Swimmers("SWIN11", "Super", 25, "SA", 0, 0);
		SuperAthlete2[0] = new Cyclists("CYCL11", "Super", 25, "TAS", 0, 0);
		SuperAthlete3[0] = new Sprinters("SPRN11", "Super", 25, "WA", 0, 0);

		// Create one referee
		referee = new Officials("REF01", "Ryan Grant", 36, "NT");

	}

	public static void main(String[] args) {

		// Create 8 players for (Swimmers, Cyclists, Sprinters)
		createAthletes();

		// TODO Game Main Menu
		int option = 0;
		do {
			try {
				displayMainScreen();
				option = input.nextInt();
				switch (option) {
				case 1:
					selectGame();
					break;
				case 2:
					predictWinner();
					break;
				case 3:
					startGame();
					break;
				case 4:
					displayFinalResultOfAllGames();
					break;
				case 5:
					displayAthletesPoins();
					break;
				case 6:
					System.out.println("You exit");
					System.exit(0);
					break;
				default:
					System.out.println("----------<(  WARNING  )>----------");
					System.out.println("Invalid input. Please select a \nnumber from 1 - 6");
				}
			} catch (InputMismatchException e) {
				System.out.println("----------<(  WARNING  )>----------");
				System.out.println("Your entry is not an integer number. \nPlease try again.");
				input.reset();
				input.next();
			}
		} while (option != 6);
	}

	// Display the points of athletes.(athlete name and his points)
	private static void displayAthletesPoins() {
		if (isGamePlayed) {
			System.out.println("*****(Display Athletes Points)*****");
			printAthletesPoints(swimPlayers);
			printAthletesPoints(cyclingPlayers);
			printAthletesPoints(sprinterPlayer);
			isGamePlayed = false;
		} else {
			System.out.println("----------<(  WARNING  )>----------");
			System.out.println("There is no game has been started");
		}

	}

	private static void printAthletesPoints(Athletes[] athletesPoints) {
		// TODO Auto-generated method stub
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

	private static void addToAthletesArrayList(Athletes[] athleteArrayList) {
		for (int z = 0; z < athleteArrayList.length; z++) {
			athletesArrayList.add(athleteArrayList[z].getID().concat("\t" + athleteArrayList[z].getAthleteName()
					.concat("\t: " + String.valueOf(athleteArrayList[z].getTotalPoints()).concat(" Points"))));
		}
	}

	private static void printGameResultArrayList() {
		for (int i = 0; i < athletesArrayList.size(); i++) {
			System.out.println(athletesArrayList.get(i));
		}
	}

	// TODO
	// Display the final result of all games including the name of the referee
	private static void displayFinalResultOfAllGames() {
		if (getSelectedGameID() != null) {
			System.out.println("----------<(  WARNING  )>----------");
			System.out.println("There is game not started yet. Please start it.");
		} else {
			if (getFinalScore(selectedGameID, isGamePlayed) != true) {
				System.out.println("----------<(  WARNING  )>----------");
				System.out.println("No score at the moment");
			} else {
				System.out.println("=======(Display Final Result)======");
				printGameResultArrayList();
			}
		}
	}

	private static boolean getFinalScore(String str, boolean bool) {
		if (isGamePlayed != true) {
			bool = false;
		} else {
			bool = true;
		}
		return bool;
	}

	// TODO 3
	private static void startGame() {

		if (getSelectedGameID() == null) {
			System.out.println("----------<(  WARNING  )>----------");
			System.out.println("There is no game selected");
		} else {
			if (swimPlayers.length < 5 || cyclingPlayers.length < 5 || sprinterPlayer.length < 5) {
				System.out.println("----------<(  WARNING  )>----------");
				System.out.println("Game canceled because the players \nmust be more than 4");
			} else {
				System.out.println("**********(   Matching  )**********");
				System.out.println("       ( Game is starting )");
				System.out.println("___________________________________");
				runGame(selectedGameID);

				System.out.println("___________________________________");
				System.out.println("(Game ID: " + selectedGameID + " || Referee: " + referee.name + ")");
				resetValues();
				System.out.println("---------<(  Game Over  )>---------");
			}
		}

	}

	private static void runGame(String selectedGameID2) {
		if (selectedGameID2.startsWith("S")) {
			athleteCompete(swimPlayers);

		} else if (selectedGameID2.startsWith("C")) {
			athleteCompete(cyclingPlayers);

		} else {
			athleteCompete(sprinterPlayer);
		}
		isGamePlayed = true;

	}

	private static void displayAthletesArrangement(Athletes[] athleteName) {
		athleteName[0].setTotalPoints(5);
		athleteName[1].setTotalPoints(2);
		athleteName[2].setTotalPoints(1);

		for (int x = 0; x < athleteName.length; x++) {
			if (x == 0) {
				checkUserPrediction(athleteName[x].getAthleteName());
				System.out.println(athleteName[x].getAthleteName() + "\t" + athleteName[x].getTimeAchieved() + " sec\t"
						+ "5" + " Ponits");
			} else if (x == 1) {
				System.out.println(athleteName[x].getAthleteName() + "\t" + athleteName[x].getTimeAchieved() + " sec\t"
						+ "2" + " Ponits");
			} else if (x == 2) {
				System.out.println(athleteName[x].getAthleteName() + "\t" + athleteName[x].getTimeAchieved() + " sec\t"
						+ "1" + " Ponit");
			} else
				System.out.println(athleteName[x].getAthleteName() + "\t" + athleteName[x].getTimeAchieved() + " sec\t"
						+ "0" + " Ponit");
		}

	}

	private static void checkUserPrediction(String athleteName) {
		// TODO
		String firstWinner = athleteName.toUpperCase();
		boolean userPrediction = new String(firstWinner).equals(userPredictionValue.toUpperCase());
		if (userPrediction) {
			System.out.println("Congratulations You got the right winner");
			System.out.println("------<(  Congratulations  )>------");
			System.out.println("----<( Your guessing correct )>----");
		}
	}

	public static void arraySort(Athletes[] game) {
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

	private static void athleteCompete(Athletes[] athlete) {
		for (int x = 0; x < athlete.length; x++) {
			athlete[x].setTimeAchieved(athlete[x].compete());
		}
		arraySort(athlete);
		displayAthletesArrangement(athlete);
		sortAthletesBasedOnPoints(athlete);
	}

	private static void sortAthletesBasedOnPoints(Athletes[] athletesPoints) {
		sortAthleteDescending(athletesPoints);
		addToAthletesArrayList(athletesPoints);
		athletesArrayList.add("Referee: " + referee.name);
		athletesArrayList.add("-----------------------------------");
	}

	private static void sortAthleteDescending(Athletes[] athletesPoints) {
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

	private static void resetValues() {
		userPrediction = false;
		selectedGameID = null;
	}

	// TODO
	private static void predictWinner() {
		// check selected game first to display its athletes
		if (selectedGameID == null) {
			System.out.println("----------<(  WARNING  )>----------");
			System.out.println("You have not selected any game yet. \nPlease select one");
		} else {
			boolean isAthleteSelected = false;
			int option = 0;
			if (!isAthleteSelected) {
				do {
					try {
						displayAthletes();
						userPredictionValue = input.next();
						if (userPredictionValue.startsWith("9")) {
							option = 9;
						} else {
							if (storeUserPrediction(userPredictionValue)) {
								System.out.println(storeUserPrediction(userPredictionValue));
								System.out.println("User Prediction registered");
								option = 9;
							} else {
								System.out.println("Invalid Name. Try again");
							}
						}
					} catch (InputMismatchException e) {
						System.out.println("----------<(  WARNING  )>----------");
						System.out.println("Invalid input. Please try again.");
						input.reset();
						input.next();
					}
				} while (option != 9);
			} else {
				System.out.println("----------<(  WARNING  )>----------");
				System.out.println("First select game then choose your \nathlete");
			}
		}
	}

	// TODO
	// Display athletes
	private static void displayAthletes() {
		System.out.println();
		System.out.println("==========(   Athletes  )==========");
		System.out.println("See the list below. Guess who would \nwin then enter his name:");
		if (selectedGameID.startsWith("S")) {
			printGamePlayer(swimPlayers);
		} else if (selectedGameID.startsWith("C")) {
			printGamePlayer(cyclingPlayers);
		} else {
			printGamePlayer(sprinterPlayer);
		}
		System.out.println("9 Cancel");
		System.out.println("-----------------------------------");
	}

	private static void printGamePlayer(Athletes[] athletesListPlayer) {
		for (int i = 0; i < athletesListPlayer.length; i++) {
			System.out.println(athletesListPlayer[i].getAthleteName());
		}
	}

	// TODO
	private static boolean storeUserPrediction(String userPredictionValue2) {
		boolean isAthleteNameAvailable = false;
		ArrayList<String> items = new ArrayList<String>();

		if (selectedGameID.startsWith("S")) {
			copySprnPlayers(items, swimPlayers);
		} else if (selectedGameID.startsWith("C")) {
			copySprnPlayers(items, cyclingPlayers);
		} else {
			copySprnPlayers(items, sprinterPlayer);
		}

		if (items.contains(userPredictionValue2.toUpperCase())) {
			isAthleteNameAvailable = true;
		} else {
			isAthleteNameAvailable = false;
		}

		items.clear();
		return isAthleteNameAvailable;
	}

	private static ArrayList<String> copySprnPlayers(ArrayList<String> items, Athletes[] athlte) {
		for (int mm = 0; mm < athlte.length; mm++) {
			items.add(athlte[mm].getAthleteName().toUpperCase());
		}
		return items;
	}

	public static void createGameID(String gameName) {
		if (gameName == "Swimming") {
			selectedGameID = "S" + swimmingGameCount.incrementAndGet();
		}
		if (gameName == "Cycling") {
			selectedGameID = "C" + cyclingGameCount.incrementAndGet();
		}
		if (gameName == "Running") {
			selectedGameID = "R" + runningGameCount.incrementAndGet();
		}
		System.out.println("You have selected " + gameName + " game ID: " + selectedGameID);
		athletesArrayList.add("Game ID: " + selectedGameID);
	}

	public static String getSelectedGameID() {
		return selectedGameID;
	}

	// TODO
	// create game ID for each sport
	public static boolean selectGame() {

		int option = 0;
		do {
			try {
				if (selectedGameID != null) {
					System.out.println("----------<(  WARNING  )>----------");
					System.out.println("There is a game has been chosen before");
					System.out.println("Please start that previous game");
					System.out.println("then you can select a new one");
					option = 4;
				} else {
					displayGamesMenu();
					option = input.nextInt();
					switch (option) {
					case 1:
						// create Swimming game
						createGameID("Swimming");
						return true;
					case 2:
						// create Cycling game
						createGameID("Cycling");
						return true;
					case 3:
						// Create Running game
						createGameID("Running");
						return true;
					case 4:
						break;
					default:
						System.out.println("----------<(  WARNING  )>----------");
						System.out.println("Invalid input. Please select a \nnumber from 1 - 4");
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("----------<(  WARNING  )>----------");
				System.out.println("Your entry is not an integer number. \nPlease try again.");
				input.reset();
				input.next();
			}
			if (isGameSelected) {
				option = 4;
			}
		} while (option != 4);
		return isGameSelected;
	}
}