import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is the execution class
 */
public class Driver {
	
	static Scanner input = new Scanner(System.in);

	public static void displayMainScreen() {
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
		// TODO Auto-generated method stub
		int option = 0;
		do {
			try {
				displayMainScreen();
				option = input.nextInt();
				switch (option) {
				case 1:
//					selectGame();
					break;
				case 2:
//					predictWinner();
					break;
				case 3:
//					startGame();
					break;
				case 4:
//					displayFinalResultOfAllGames();
					break;
				case 5:
//					displayAthletesPoins();
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
}
