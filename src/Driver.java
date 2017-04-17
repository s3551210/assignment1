/*
 * Abdulrahman Alzahrani
 *
 * Copyright (c) 1993-1996 Sun Microsystems, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Sun
 * Microsystems, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 *
 * SUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. SUN SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * This is the execution class
 *
 * @version 2.3 15 Apr 2017
 * @author  Abdulrahman Alzahrani
 * 
 */

public class Driver {
	private static Ozlympic newGame = new Ozlympic();
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

	    /** Create 8 players for (Swimmers, Cyclists, Sprinters) */ 
		newGame.createAthletes();
		int option = 0;
		do {
			try {
				newGame.displayMainScreen();

				/** This variable to get user input */
				option = input.nextInt();
				switch (option) {
				case 1:
					newGame.selectGame();
					break;
				case 2:
					newGame.predictWinner();
					break;
				case 3:
					newGame.startGame();
					break;
				case 4:
					newGame.displayFinalResultOfAllGames();
					break;
				case 5:
					newGame.displayAthletesPoins();
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
}
