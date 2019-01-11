package app;

import java.util.Scanner;

public class Launcher {
	
	public static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("----- WELCOME -----");
		System.out.println("-------- TO --------");
		System.out.println("---- CONNECT 4 ----");
		System.out.println("...press Enter to play");
		// takes an input and ignores it
		s.nextLine();
		Board game = new Board();
		do {
			game.reset();
			gameLoop();
			System.out.println("Do you want to play again? (y/n): ");
			s.nextLine();
		}while (s.nextLine().equals("y"));
	}
	
	public static void gameLoop() {
	// checks if the column is available
	// adds player1's 'x' to the column
		Board game = new Board();
		boolean player1 = true;
		while(true) {
			System.out.println(game);
			if(player1) {
				System.out.print("Player 1, select column:  ");
				int choice = s.nextInt();
				while(!game.dropPiece('x', choice)) {
					System.out.println("Please try again: ");
					choice = s.nextInt();
				}
				if(game.isWinner('x')) {
					System.out.println("Player 1 wins!");
					System.out.println(game);
					break;
				}
			}else {
			// checks if the column is available
			// adds player2's 'o' to the column
				System.out.print("Player 2, select column  ");
				int choice = s.nextInt();
				while(!game.dropPiece('o', choice)) {
					System.out.println("Please try again: ");
					choice = s.nextInt();
				}
				if(game.isWinner('o')) {
					System.out.println("Player 2 wins!");
					System.out.println(game);
					break;
				}
			}
			// checks if there's a winner, if so, announce who won and break
			if(game.tieGame()) {
				System.out.println("Tie game. Everyone loses.");
				break;
			}
			// change whose turn it is
			player1 = !player1;
		}
	}
	
}
