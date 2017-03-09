package tictactoe;

/**
 * This class aims to manage all different types of outputs
 *
 * @author
 *
 */
public class Output {

	private static final int X_FOR_PLAYER_1 = 1;
	private static final int O_FOR_PLAYER_2 = 2;

	public void printsCurrentBoard(int[][] board) {

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (board[i][j] == X_FOR_PLAYER_1) {
					if (j != 2) {
						System.out.print("X" + " | ");
					}
					if (j == 2) {
						System.out.print("X" + "  ");
					}
				} else if (board[i][j] == O_FOR_PLAYER_2) {
					if (j != 2) {
						System.out.print("O" + " | ");
					}
					if (j == 2) {
						System.out.print("O" + "  ");
					}
				} else {
					if (j != 2) {
						System.out.print(" " + " | ");
					}
				}
			}
			if (i != 2) {
				System.out.println("\n----------");
			}

		}
		System.out.print("\n\n");
	}

}
