package tictactoe;


public class Main {
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();

		for (int i = 0; i < 1000; ++i) {
			game.mode1();
		}
		System.out.println("--Mode 1 results: ");
		System.out.println("Player1 won " + game.getP1Victories() + " times");
		System.out.println("Player2 won " + game.getP2Victories() + " times");
		System.out.println("A " + game.getTies() + " times it was a draw\n");

		game = new TicTacToe();
		for (int i = 0; i < 1000; ++i) {
			game.mode2();
		}
		System.out.println("--Mode 2 results: ");
		System.out.println("Player1 won " + game.getP1Victories() + " times");
		System.out.println("Player2 won " + game.getP2Victories() + " times");
		System.out.println("A " + game.getTies() + " times it was a draw\n");

		game = new TicTacToe();
		for (int i = 0; i < 1000; ++i) {
			game.mode3();
		}
		System.out.println("--Mode 3 results: ");
		System.out.println("Player1 won " + game.getP1Victories() + " times");
		System.out.println("Player2 won " + game.getP2Victories() + " times");
		System.out.println("A " + game.getTies() + " times it was a draw");
	}
}