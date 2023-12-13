/**********************************************************************************************
Programmer: Jackson Smith

Program: StixGame

Purpose: This program provides a game between the user and computer to determine who will win
by not being the last to pick up a stick.

Date: 09/01/2023
  
Class: COP 3022  
***********************************************************************************************/
import java.util.Scanner;

public class ProjectOne {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//Prompt for initial number of stix.
		System.out.print("How many stix to begin with? [5-30] > ");
		int stix = getValidInput(scanner, 5, 30);
		
		//Prompt to ask if computer goes first or not.
		System.out.print("Computer goes first? [y/n] > ");
		boolean computerFirst = getYesNoInput(scanner);
		
		//Logic if the computer goes first
		if (computerFirst) { 
		    int computerMove = computeComputerMove(stix);
		    stix -= computerMove;
		    System.out.println("Computer takes " + computerMove);

		    if (stix == 0) {
		        System.out.println("Computer wins!");
		        return;
		    }
		}

		//Main game loop
		while (stix > 0) {
		    //Player's turn
		    System.out.print("How many stix to take? [1 - " + Math.min(3, stix) + "] > ");
		    int playerMove = getValidInput(scanner, 1, Math.min(3, stix));
		    stix -= playerMove;
		    System.out.println("Stix on the table: " + drawStix(stix));

		    if (stix == 0) {
		        System.out.println("User loses!");
		        return;
		    }

		    //Computer's turn
		    int computerMove = computeComputerMove(stix);
		    stix -= computerMove;
		    System.out.println("Computer takes " + computerMove);

		    if (stix == 0) {
		        System.out.println("User wins!");
		        return;
		    }
		}
		}
	
	
		
	//Function used in order to get valid input within a specified range.	
	private static int getValidInput(Scanner scanner, int min, int max) {
		int input;
		while(true) {
			if (scanner.hasNextInt()) {
				input = scanner.nextInt();
				if (input >= min && input <= max) {
					return input;
				} else {
					System.out.println("Input must be between " + min + " and " + max);
				}
			} else {
				scanner.next();
				System.out.println("Value must be an integer");
			}
		}
	}
	
	//This function gets a yes or no input.
	private static boolean getYesNoInput(Scanner scanner) {
		while (true) {
			String input = scanner.next().toLowerCase();
			if (input.equals("y")) {
				return true;
			} else if (input.equals("n")) {
				return false;
			} else {
				System.out.println("Input must be 'y' or 'n'");
			}
		}
	}
	
	//This function is used to draw stix.
	private static String drawStix(int count) {
		StringBuilder stixString = new StringBuilder();
		for (int i = 0; i < count; i++) {
			stixString.append('|');
		} return stixString.toString();
	}
	
	//This function is used to compute the computer's move based on the number of stick remaining.
	private static int computeComputerMove(int stix) {
		if (stix > 8) {
			return stix % 4 == 0 ? 3 : stix % 4;
		} else if ( stix > 4) {
			return stix - 4;
		} else if (stix == 4) {
			return 3;
		} else if (stix == 3) {
			return 2;
		} else if (stix == 2) {
			return 1;
		} else if (stix == 1) {
			return 1;
		} else {
			if ((stix -1) % 4 == 0) {
				return 3;
			} else if ((stix - 2) % 4 == 0) {
				return 2;
			} else if ((stix - 3) % 4 == 0) {
				return 1;
			} else {
				return 1;
			}
			}
		}
	}


