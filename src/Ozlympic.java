import java.util.InputMismatchException;
import java.util.Scanner;

public class Ozlympic {
	public int FIRST_PLACE = 5;
	public int SECOND_PLACE = 2;
	public int THIRD_PLACE = 1;
	public int MAX_ATHLETES = 8;
	public int MIN_ATHLETES = 5;
	public String gameID;
	public String userPrediction = null;
	

	static Scanner input = new Scanner(System.in);
	
	public static void displayMainScreen(){
		System.out.println();
		System.out.println("Ozlympic Game");
		System.out.println("===================================");
		System.out.println("1. Select a game to run");
		System.out.println("2. Predict the winner of the game");
		System.out.println("3. Start the game");
		System.out.println("4. Display the final results of all games");
		System.out.println("5. Display the points of all athletes");
		System.out.println("6. Exit");
		System.out.println();
		System.out.println("Enter an option: ");
	}

	public static void main(String[] args) {
		
		// Create one referee
		Officials referee = new Officials("REF01", "Micheal", 35, "VIC");
//		referee.calculateFinishingTime(finishingTime);
		
		
		
		// Create 8 players for (Swimmers, Cyclists, Sprinters)
		Swimmers [] swimPlayers = new Swimmers[3];
		swimPlayers[0] = new Swimmers("S01", "Bell", 21, "VIC", 0);
		swimPlayers[1] = new Swimmers("S02", "Mick", 24, "NSW", 0);
		swimPlayers[2] = new Swimmers("S03", "John", 22, "SYD", 0);
		
		System.out.println(swimPlayers[0].compete());
		System.out.println(swimPlayers[1].compete());
		System.out.println(swimPlayers[2].compete());
		
//		swimPlayers[1].compete();
//		int tt = swimPlayers[2].compete();
		
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

//	Display the points of athletes.(athlete name and his points)
//	to store the information of games, athletes and user predictions (Does it need to be in this function?)
	private static void displayAthletesPoins() {
		System.out.println("Display Athletes Points");
	}

//	Each athlete might have points carried over from the previous games.
//	Display the final result of all games including the name of the referee for each game (getName() for referee)
//	to store the information of games, athletes and user predictions (Does it need to be in this function?)
	private static void displayFinalResultOfAllGames() {
		System.out.println("Display Final Result");
	}

//	(one sport) + (one referee) + (5 - 8 athletes)
//	game will be cancelled unless there are more than 4 participants
//	However when a game is run again, the user prediction of that game should be reset.(repeated in predictWinner())
//	Start the game and award points to top 3 athletes according to their finishing time (Referee will be called from this method)
//	to store the information of games, athletes and user predictions (Does it need to be in this function?)
	private static void startGame() {
		System.out.println("Start Game");
	}

//	A user can predict the winner for each game. 
//	Allow the user to predict the winner of that game
//	User’s prediction is limited to only one athlete in one game. 
//	If the prediction is correct, then a congratulation message will be generated
//	However when a game is run again, the user prediction of that game should be reset.
//	to store the information of games, athletes and user predictions (Does it need to be in this function?)
	private static void predictWinner() {
		System.out.println("User Prediction");
	}

	private static void selectGame() {
		System.out.println("Select Game");
	}
}