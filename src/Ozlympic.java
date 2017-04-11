import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Ozlympic {
	public static boolean isGamePlayed;
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

	public static Swimmers[] swimPlayers = new Swimmers[8];
	public static Cyclists[] cyclingPlayers = new Cyclists[8];
	public static Sprinters[] sprinterPlayer = new Sprinters[8];
	public static Athletes[] SuperAthlete1 = new Swimmers[1];
	public static Athletes[] SuperAthlete2 = new Cyclists[1];
	public static Athletes[] SuperAthlete3 = new Sprinters[1];

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
	}

	// Create one referee
	public static Officials referee = new Officials("REF01", "Ryan", 35, "VIC");

	public static void main(String[] args) {

		// referee.calculateFinishingTime(finishingTime);

		// Create 8 players for (Swimmers, Cyclists, Sprinters)
		createAthletes();

		// Game Main Menu
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
					System.out.println("WARNING");
					System.out.println("Invalid input. Please select a number from 1 - 6");
				}
			} catch (InputMismatchException e) {
				System.out.println("WARNING");
				System.out.println("Your entry is not an integer number. Please try again.");
				input.reset();
				input.next();
			}
		} while (option != 6);
	}

	// Display the points of athletes.(athlete name and his points)
	private static void displayAthletesPoins() {
		System.out.println("Display Athletes Points");
		ArrayList<String> athletesArrayList = new ArrayList<String>();

		for (int z = 0; z < swimPlayers.length; z++) {
			athletesArrayList.add(swimPlayers[z].getID().concat("\t" + swimPlayers[z].getAthleteName()
					.concat("\t: " + String.valueOf(swimPlayers[z].getTotalPoints()))));
		}

		for (int i = 0; i < athletesArrayList.size(); i++) {
			Collections.sort(athletesArrayList);
			System.out.println(athletesArrayList.get(i));
		}
	}

	// Each athlete might have points carried over from the previous games.
	// Display the final result of all games including the name of the referee
	// for each game (getRefereeName())
	// to store the information of games, athletes and user predictions
	// (Does it need to be in this function?)
	private static void displayFinalResultOfAllGames() {
		if (getSelectedGameID() != null) {
			System.out.println("There is game not started yet. Please start the game.");
		} else {
			System.out.println("Display Final Result for " + getSelectedGameID());
			getFinalScore();
		}

	}

	private static void getFinalScore() {
		if (isGamePlayed != true) {
			System.out.println("There is no score");
		} else {
			System.out.println("There is score");

			// print Final score
		}

	}

	// private static boolean isGamePlayed() {
	// if (startGame() != null){
	// System.out.println("Not played");
	// }
	// }

	// (one sport) + (one referee) + (5 - 8 athletes)
	// game will be cancelled unless there are more than 4 participants
	// However when a game is run again, the user prediction of that game should
	// be reset.(repeated in predictWinner())
	// Start the game and award points to top 3 athletes according to their
	// finishing time (Referee will be called from this method)
	// to store the information of games, athletes and user predictions (Does it
	// need to be in this function?)
	private static void startGame() {
		System.out.println("**********(   Matching  )**********");
		if (selectedGameID.isEmpty()) {
			System.out.println("Game is not selected");
		} else {
			if (swimPlayers.length < 5 || cyclingPlayers.length<5 || sprinterPlayer.length<5){
				System.out.println("Game canceled because the players must be more than 4");
			} else {
				System.out.println("       ( Game is starting )");
				System.out.println("___________________________________");
				runGame(selectedGameID);
				System.out.println("___________________________________");
				System.out.println("  (Game ID: " + selectedGameID + " || Referee: " + referee.name +")");
				
				resetValues();
				System.out.println("---------<(  Game Over  )>---------");
			}
		}
		// Add all points to their athletes. ß
		// if (winner = userPrediction){
		// System.out.println("Congratulation. Your prediction is correct");
		// }
		// Reset: selectedGameID, userPrediction,

		// Object[] gameObject = new Object[3];
		// gameObject[0] = getSelectedGameID();
		// gameObject[1] = swimPlayers[8].compete();
		// for (int i=0 ; i<swimPlayers.length; i++){
		// System.out.println(swimPlayers.);
		// }
		// gameObject[2] = new Officials("REFE001", "Noah", 38, "NT");

		// if (getSelectedGameID() != null) {
		// System.out.println("Game ID is: " + getSelectedGameID());
		// isGamePlayed = true;
		// } else {
		// System.out.println("There is no game to start. Choose game first:");
		// isGamePlayed = false;
		// selectGame();
		// }
	}

	private static void runGame(String selectedGameID2) {
		if (selectedGameID.startsWith("S")) {
			for (int v = 0; v < swimPlayers.length; v++) {
				swimPlayers[v].setTimeAchieved(swimPlayers[v].compete());
				System.out.println(
						swimPlayers[v].getAthleteName() + "\t: " + swimPlayers[v].getTimeAchieved() + " sec");
			}
		} else if (selectedGameID.startsWith("C")) {
			for (int w = 0; w < cyclingPlayers.length; w++) {
				cyclingPlayers[w].setTimeAchieved(cyclingPlayers[w].compete());
				System.out.println(
						cyclingPlayers[w].getAthleteName() + "\t: " + cyclingPlayers[w].getTimeAchieved() + " sec");
			}
		} else {
			for (int x = 0; x < sprinterPlayer.length; x++) {
				sprinterPlayer[x].setTimeAchieved(sprinterPlayer[x].compete());
				System.out.println(
						sprinterPlayer[x].getAthleteName() + "\t: " + sprinterPlayer[x].getTimeAchieved() + " sec");
			}
		}
	}

	private static void resetValues() {
		// TODO Auto-generated method stub
		// isGameSelected = false;
		userPrediction = false;
		selectedGameID = null;
	}

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
			System.out.println("You have not selected any game yet. Please select one");
			selectGame();
		} else {
			displayAthletes();
			
		}

		/**
		 * I have to store the user input to check it later with final results
		 * to know if the winner match my prediction
		 **/

		// System.out.println("User Prediction");
	}

	private static void displayAthletes() {
		boolean isAthleteSelected = false;
		int option = 0;
		if (!isAthleteSelected) {
			do {
				try {
					System.out.println();
					System.out.println("==========(   Athletes  )==========");
					System.out.println("Guess then enter athlete No:");
					if (selectedGameID.startsWith("S")) {
						printSwimPlayers();
					} else if (selectedGameID.startsWith("C")) {
						printCyclePlayers();
					} else {
						printRunPlayer();
					}
					System.out.println("9 Cancel");
					System.out.println("-----------------------------------");
					userPredictionValue = input.next();
					if (userPredictionValue.startsWith("9")){
						option =9;
						System.out.println("Exit here");
					} else {
						// userPredictionValue = option;
						boolean testBool = storeUserPrediction(userPredictionValue);
						System.out.println(testBool);
						option = 9;
					}
				} catch (InputMismatchException e) {
					System.out.println("WARNING");
					System.out.println("Your entry is not an integer number. Please try again.");
					input.reset();
					input.next();
				}

			} while (option != 9);

		} else {
			System.out.println("First select game then choose your athlete");
		}
	}

	private static void printRunPlayer() {
		for (int i = 0; i < sprinterPlayer.length; i++) {
//			System.out.println(i + 1 + " " + sprinterPlayer[i].getAthleteName());
			System.out.println(sprinterPlayer[i].getAthleteName());
		}
	}

	private static void printCyclePlayers() {
		for (int i = 0; i < cyclingPlayers.length; i++) {
//			System.out.println(i + 1 + " " + cyclingPlayers[i].getAthleteName());
			System.out.println(cyclingPlayers[i].getAthleteName());
		}
	}

	private static void printSwimPlayers() {
		for (int i = 0; i < swimPlayers.length; i++) {
//			System.out.println(i + 1 + " " + swimPlayers[i].getAthleteName());
			System.out.println(swimPlayers[i].getAthleteName());
		}
	}

	private static boolean storeUserPrediction(String userPredictionValue2) {
		boolean isAthleteNameAvailable = false;
		
		ArrayList<String> items = new ArrayList<String>();
		for(int mm = 0; mm<swimPlayers.length; mm++){
			items.add(swimPlayers[mm].getAthleteName().toUpperCase());
		}
		
//		System.out.println(items);
		if(items.contains(userPredictionValue2.toUpperCase())){
			isAthleteNameAvailable = true;
		} else {
			isAthleteNameAvailable = false;
		}
		
		return isAthleteNameAvailable;
		
//		if (isAthleteNameCorrect(swimPlayers, userPredictionValue2)) {
//			System.out.println("Your predicName is " + userPredictionValue2);
//		} else {
//			System.out.println(userPredictionValue2 + " is not available. Try again");
//		}

		// String predictedAthleteName =
		// swimPlayers[userPredictionValue-1].getAthleteName();
		// System.out.println("Your prediction is " + userPredictionValue);
		// System.out.println("Your predicName is " + predictedAthleteName);
		//
		// predictedAthleteName =
		// cyclingPlayers[userPredictionValue-1].getAthleteName();
		// System.out.println("Your prediction is " + userPredictionValue);
		// System.out.println("Your predicName is " + predictedAthleteName);
		//
		// predictedAthleteName =
		// sprinterPlayer[userPredictionValue-1].getAthleteName();
		// System.out.println("Your prediction is " + userPredictionValue);
		// System.out.println("Your predicName is " + predictedAthleteName);
		// System.out.println(isAthleteNameCorrect(swimPlayers,
		// predictedAthleteName));
	}

	public static boolean isAthleteNameCorrect(Swimmers[] swimPlayers2, int userPredictionValue2) {
		boolean athleteNameIndex = false;
//		for (int i = 0; i < swimPlayers2.length; i++) {
//			if (swimPlayers2[i].getAthleteName() == userPredictionValue2) {
//				athleteNameIndex = true;
//				// break;
//			}
//		}
		return athleteNameIndex;
	}
	// public String find(Athletes [] array, int value) {
	// String athletName;
	// for(int i=0; i<array.length; i++)
	// if(array[i] == value){
	// athletName = array[i].getAthleteName();
	// }
	// return athletName;
	// }

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
		System.out.println("You have selected " + gameName + " game and its ID is: " + selectedGameID);
	}

	public static String getSelectedGameID() {
		// System.out.println(selectedGameID);
		return selectedGameID;
	}

	// create game ID for each sport
	public static boolean selectGame() {

		// String selectedGame = null;
		int option = 0;
		do {
			try {
				if (selectedGameID != null) {
					System.out.println("You already have chosen game ID");
					option = 4;
				} else {
					displayGamesMenu();
					option = input.nextInt();
					switch (option) {
					case 1:
						createGameID("Swimming");
						// isGameSelected = true;
						// selectedGame= "Swimming";
						return true;
					case 2:
						// create Cycling game
						createGameID("Cycling");
						// isGameSelected = true;
						// selectedGame="Cycling";
						return true;
					case 3:
						// Create Running game
						createGameID("Running");
						// isGameSelected = true;
						// selectedGame="Running";
						return true;
					case 4:
						break;
					default:
						System.out.println("WARNING");
						System.out.println("Invalid input. Please select a number from 1 - 4");
					}
				}

			} catch (InputMismatchException e) {
				System.out.println("WARNING");
				System.out.println("Your entry is not an integer number. Please try again.");
				input.reset();
				input.next();
			}
			if (isGameSelected) {
				option = 4;
			}
		} while (option != 4);
		return isGameSelected;
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
}