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
	public String userPrediction = null;

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
//	public static SuperAthletes superPlayer = new SuperAthletes("SUPR01", "Super", 23, "WA", 0);

	public static void createAthletes() {
		swimPlayers[0] = new Swimmers("SWIM01", "Bell", 21, "VIC", 0);
		swimPlayers[1] = new Swimmers("SWIM02", "Mick", 24, "ACT", 0);
		swimPlayers[2] = new Swimmers("SWIM03", "John", 22, "NSW", 0);
		swimPlayers[3] = new Swimmers("SWIM04", "Robot", 21, "NT", 0);
		swimPlayers[4] = new Swimmers("SWIM05", "Oliver", 20, "SA", 0);
		swimPlayers[5] = new Swimmers("SWIM06", "Jack", 23, "QLD", 0);
		swimPlayers[6] = new Swimmers("SWIM07", "Noah", 20, "TAS", 0);
		swimPlayers[7] = new Swimmers("SWIM08", "James", 23, "WA", 0);

		cyclingPlayers[0] = new Cyclists("CYCL01", "AA", 19, "NSW", 0);
		cyclingPlayers[1] = new Cyclists("CYCL02", "BB", 19, "NSW", 0);
		cyclingPlayers[2] = new Cyclists("CYCL03", "CC", 19, "NSW", 0);
		cyclingPlayers[3] = new Cyclists("CYCL04", "DD", 19, "NSW", 0);
		cyclingPlayers[4] = new Cyclists("CYCL05", "EE", 19, "NSW", 0);
		cyclingPlayers[5] = new Cyclists("CYCL06", "FF", 19, "NSW", 0);
		cyclingPlayers[6] = new Cyclists("CYCL07", "GG", 19, "NSW", 0);
		cyclingPlayers[7] = new Cyclists("CYCL08", "HH", 19, "NSW", 0);

		sprinterPlayer[0] = new Sprinters("SPRN01", "III", 24, "NT", 0);
		sprinterPlayer[1] = new Sprinters("SPRN02", "JJJ", 22, "NT", 0);
		sprinterPlayer[2] = new Sprinters("SPRN03", "KKK", 22, "NT", 0);
		sprinterPlayer[3] = new Sprinters("SPRN04", "LLL", 22, "NT", 0);
		sprinterPlayer[4] = new Sprinters("SPRN05", "MMM", 21, "NT", 0);
		sprinterPlayer[5] = new Sprinters("SPRN06", "NNN", 23, "NT", 0);
		sprinterPlayer[6] = new Sprinters("SPRN07", "OOO", 23, "NT", 0);
		sprinterPlayer[7] = new Sprinters("SPRN08", "PPP", 23, "NT", 0);
	}

	public static void main(String[] args) {

		// Create one referee
		Officials referee = new Officials("REF01", "Micheal", 35, "VIC");
		// referee.calculateFinishingTime(finishingTime);

		// Create 8 players for (Swimmers, Cyclists, Sprinters)
		createAthletes();

		// swimPlayers[0] = new Swimmers("S01", "Bell", 21, "VIC", 0);
		// swimPlayers[1] = new Swimmers("S02", "Mick", 24, "NSW", 0);
		// swimPlayers[2] = new Swimmers("S03", "John", 22, "SYD", 0);
		// swimPlayers[3] = new Swimmers("S04", "John", 22, "SYD", 0);
		// swimPlayers[4] = new Swimmers("S05", "John", 22, "SYD", 0);

		// System.out.println(swimPlayers[0].compete());
		// System.out.println(swimPlayers[1].compete());
		// System.out.println(swimPlayers[2].compete());

		// swimPlayers[1].compete();
		// int tt = swimPlayers[2].compete();

		System.out.println();

		// create 1 object for each sport

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
	// to store the information of games, athletes and user predictions
	// (Does it need to be in this function?)
	private static void displayAthletesPoins() {
		System.out.println("Display Athletes Points");
	}

	// Each athlete might have points carried over from the previous games.
	// Display the final result of all games including the name of the referee
	// for each game (getRefereeName())
	// to store the information of games, athletes and user predictions
	// (Does it need to be in this function?)
	private static void displayFinalResultOfAllGames() {
		if (getSelectedGameID() != null) {
			System.out.println("There is game ");
		} else {
			System.out.println("Display Final Result for " + getSelectedGameID());
			getFinalScore();
		}

	}

	private static void getFinalScore() {
		if (isGamePlayed != true) {
			System.out.println("There is no score");
		} else {
			System.out.println("There is");
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
		Object [] gameObject = new Object [3];
		gameObject[0] = getSelectedGameID();
		gameObject[1] = swimPlayers[8].compete();
		for (int i=0 ; i<swimPlayers.length; i++){
//			System.out.println(swimPlayers.);
		}
		gameObject[2] = new Officials("REFE001", "Noah", 38, "NT");
		
		System.out.println("Start Game");
		if (getSelectedGameID() != null) {
			System.out.println("The current running game is: " + getSelectedGameID());
			isGamePlayed = true;
		} else {
			System.out.println("No running game. Choose game first:");
			isGamePlayed = false;
			selectGame();
		}
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
					System.out.println("Who would be the winner? select one:");
					if (selectedGameID.startsWith("S")) {
						for (int i = 0; i < swimPlayers.length; i++) {
							System.out.println(i + 1 + " " + swimPlayers[i].getAthleteName() + "\t " +swimPlayers[i].compete());
						}
					} else if (selectedGameID.startsWith("C")) {
						for (int i = 0; i < cyclingPlayers.length; i++) {
							System.out.println(i + 1 + " " + cyclingPlayers[i].getAthleteName());
						}
					} else {
						for (int i = 0; i < sprinterPlayer.length; i++) {
							System.out.println(i + 1 + " " + sprinterPlayer[i].getAthleteName());
						}
					}
					System.out.println("9 Cancel");
					System.out.println("-----------------------------------");
					System.out.println();
				} catch (InputMismatchException e) {
					System.out.println("WARNING");
					System.out.println("Your entry is not an integer number. Please try again.");
					input.reset();
					input.next();
				}
			} while (option!=9);
		} else {
			System.out.println("First select game then choose your athlete");
		}
	}

	public static void getGameID(String gameName) {
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

	private static void selectGame() {
		boolean isGameselected = false;
		int option = 0;
		do {
			try {
				displayGameMenu();
				option = input.nextInt();
				switch (option) {
				case 1:
					getGameID("Swimming");
					isGameselected = true;
					break;
				case 2:
					// create Cycling game
					getGameID("Cycling");
					isGameselected = true;
					break;
				case 3:
					// Create Running game
					getGameID("Running");
					isGameselected = true;
					break;
				case 4:
					isGameselected = true;
					break;
				default:
					System.out.println("WARNING");
					System.out.println("Invalid input. Please select a number from 1 - 4");
				}
			} catch (InputMismatchException e) {
				System.out.println("WARNING");
				System.out.println("Your entry is not an integer number. Please try again.");
				input.reset();
				input.next();
			}
		} while (!isGameselected);
	}

	public static void displayGameMenu() {
		System.out.println();
		System.out.println("==========(    Games    )==========");
		System.out.println("Choose a game number to run:");
		System.out.println("1- Swimming");
		System.out.println("2- Cycling");
		System.out.println("3- Running");
		System.out.println("4- Cancel");
		System.out.println("-----------------------------------");
		System.out.println();
	}
}