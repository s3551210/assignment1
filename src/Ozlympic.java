import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Ozlympic {
	public static boolean isGamePlayed =false;
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

		//TODO Game Main Menu
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
		if (isGamePlayed){
			System.out.println("*****(Display Athletes Points)*****");
			athletesArrayList.add("-----------------------------------");
			printAthletesArrayList();
			isGamePlayed = false;
		} else {
			System.out.println("----------<(  WARNING  )>----------");
			System.out.println("There is no running game yet");
		}
		
	}

	private static void addToAthletesArrayList(Athletes[] athleteArrayList) {
		for (int z = 0; z < athleteArrayList.length; z++) { 
			athletesArrayList.add(athleteArrayList[z].getID().concat("\t" 
					+ athleteArrayList[z].getAthleteName().concat("\t: " 
					+ String.valueOf(athleteArrayList[z].getTotalPoints()))));
		}
	}
	
	private static void printAthletesArrayList() {
		for (int i = 0; i < athletesArrayList.size(); i++) {
			System.out.println(athletesArrayList.get(i));
		}
	}

//	TODO
	// Each athlete might have points carried over from the previous games.
	// Display the final result of all games including the name of the referee
	// for each game (getRefereeName())
	// to store the information of games, athletes and user predictions
	// (Does it need to be in this function?)
	private static void displayFinalResultOfAllGames() {
		if (getSelectedGameID() != null) {
			System.out.println("----------<(  WARNING  )>----------");
			System.out.println("There is game not started yet. Please start it.");
		} else {
			if(getFinalScore(selectedGameID, isGamePlayed) != true){
				System.out.println("----------<(  WARNING  )>----------");
				System.out.println("No score at the moment");
			} else {
				System.out.println("=======(Display Final Result)======");
				System.out.println("==========(Game ID : " +getSelectedGameID()+ ")==========");
				getFinalScore(selectedGameID, isGamePlayed);
			}
			
		}

	}

	//TODO
	private static boolean getFinalScore(String str, boolean bool) {
		if (isGamePlayed != true) {
			bool=false;
		} else {
			// print Final score
			bool=true;
		}
		return bool;
	}

//	TODO
	// (one sport) + (one referee) + (5 - 8 athletes)
	// game will be cancelled unless there are more than 4 participants
	// However when a game is run again, the user prediction of that game should
	// be reset.(repeated in predictWinner())
	// Start the game and award points to top 3 athletes according to their
	// finishing time (Referee will be called from this method)
	// to store the information of games, athletes and user predictions (Does it
	// need to be in this function?)
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
		// Add all points to their athletes. ß
		// if (winner = userPrediction){
		// System.out.println("Congratulation. Your prediction is correct");
		// }
		// Reset: selectedGameID, userPrediction,

	}

//	TODO
	private static boolean runGame(String selectedGameID2) {
		if (selectedGameID2.startsWith("S")) {
			athleteCompete(swimPlayers);
			arraySort(swimPlayers);
			swimPlayers[0].setTotalPoints(5);
			swimPlayers[1].setTotalPoints(2);
			swimPlayers[2].setTotalPoints(1);
			for(int q = 0; q<swimPlayers.length; q++){
				System.out.println(swimPlayers[q].name+"\t "+swimPlayers[q].timeAchieved +" "+swimPlayers[q].totalPoints);
			}
			addToAthletesArrayList(swimPlayers);
			athletesArrayList.add("Referee: "+referee.name);

		} else if (selectedGameID2.startsWith("C")) {
			athleteCompete(cyclingPlayers);
			arraySort(cyclingPlayers);
			cyclingPlayers[0].setTotalPoints(5);
			cyclingPlayers[1].setTotalPoints(2);
			cyclingPlayers[2].setTotalPoints(1);
			for(int q = 0; q<cyclingPlayers.length; q++){
				System.out.println(cyclingPlayers[q].name+"\t "+cyclingPlayers[q].timeAchieved +" "+cyclingPlayers[q].totalPoints);
			}
			addToAthletesArrayList(cyclingPlayers);
			athletesArrayList.add("Referee: "+referee.name);
		
		} else {
			athleteCompete(sprinterPlayer);
			arraySort(sprinterPlayer);
			
			sprinterPlayer[0].setTotalPoints(5);
			sprinterPlayer[1].setTotalPoints(2);
			sprinterPlayer[2].setTotalPoints(1);
			for(int q = 0; q<sprinterPlayer.length; q++){
				System.out.println(sprinterPlayer[q].name+"\t "+sprinterPlayer[q].timeAchieved +" "+sprinterPlayer[q].totalPoints);
			}
			
			addToAthletesArrayList(sprinterPlayer);
			athletesArrayList.add("Referee: "+referee.name);
		}
		isGamePlayed = true;
		
		return true; 
	}

	public static void arraySort(Athletes [] game) {
		boolean swapped = true;
		int j = 0;
		Athletes[] tempArr = new Athletes[1];
		while (swapped) {
			swapped = false;
			j++;
			for (int i = 0; i < game.length - j; i++) {
				if (game[i].timeAchieved > game[i + 1].timeAchieved) {
					tempArr[0] = game[i];
					game[i] = game[i + 1];
					game[i + 1] = tempArr[0];
					swapped = true;
				}
			}
		}
	}

	private static void athleteCompete(Athletes[] athlete) {
		for (int x = 0; x < athlete.length; x++) {
			athlete[x].setTimeAchieved(athlete[x].compete());
			System.out.println(athlete[x].getAthleteName() + "\t: " 
			+ athlete[x].getTimeAchieved() + " sec");
		}
	}

	private static void resetValues() {
		userPrediction = false;
		selectedGameID = null;
	}

	//	TODO
	// A user can predict the winner for each game.
	// Allow the user to predict the winner of that game
	// User’s prediction is limited to only one athlete in one game.
	// If the prediction is correct, then a congratulation message will be
	// generated
	// However when a game is run again, the user prediction of that game should
	// be reset.
	// to store the information of games, athletes and user predictions (Does it
	// need to be in this function?)
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

//	TODO
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

//	TODO
	private static boolean storeUserPrediction(String userPredictionValue2) {
		boolean isAthleteNameAvailable = false;
		ArrayList<String> items = new ArrayList<String>();

		if (selectedGameID.startsWith("S")) {
			copySwimPlayers(items);
		} else if (selectedGameID.startsWith("C")) {
			copyCyclPlayers(items);
		} else {
			copySprnPlayers(items);
		}

		if (items.contains(userPredictionValue2.toUpperCase())) {
			isAthleteNameAvailable = true;
		} else {
			isAthleteNameAvailable = false;
		}

		items.clear();
		return isAthleteNameAvailable;
	}

	private static ArrayList<String> copySprnPlayers(ArrayList<String> items) {
		for (int mm = 0; mm < sprinterPlayer.length; mm++) {
			items.add(sprinterPlayer[mm].getAthleteName().toUpperCase());
		}
		return items;
	}

	private static ArrayList<String> copyCyclPlayers(ArrayList<String> items) {
		for (int mm = 0; mm < cyclingPlayers.length; mm++) {
			items.add(cyclingPlayers[mm].getAthleteName().toUpperCase());
		}
		return items;
	}

	private static ArrayList<String> copySwimPlayers(ArrayList<String> items) {
		for (int mm = 0; mm < swimPlayers.length; mm++) {
			items.add(swimPlayers[mm].getAthleteName().toUpperCase());
		}
		return items;
	}

	public static void createGameID(String gameName) {
		// String selectedGameID;
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
		athletesArrayList.add("Game ID: "+selectedGameID);
	}

	public static String getSelectedGameID() {
		// System.out.println(selectedGameID);
		return selectedGameID;
	}

//	TODO
	// create game ID for each sport
	public static boolean selectGame() {

		// String selectedGame = null;
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