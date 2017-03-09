package tictactoe;

import java.util.ArrayList;
import java.util.Random;

public class TicTacToe {

	private int ties = 0;
	private int p1Victories = 0;
	private int p2Victories = 0;

	private Coordinate point;

	private static int playerTurn;

	private Output output = new Output();

	private int[][] board = new int[3][3];

	private ArrayList<Coordinate> availableSquares;

	public void gameSetup() {
		playerTurn = 1;
	}

	/**
	 * Mode 1: All players move are random
	 */
	public void mode1() {
		gameSetup();
		while (!hasMatchEnded()) {
			availableSquares = findAvailableSquares();
			point = availableSquares.get(randomMove(availableSquares.size()));

			performMove(point, playerTurn);
			// output.printsCurrentBoard(board);
		}
		endGame();
	}

	/**
	 * Mode 2: The first move in the middle and the rest of the moves are random
	 */
	public void mode2() {
		gameSetup();
		point = new Coordinate(1, 1);
		performMove(point, playerTurn);

		while (!hasMatchEnded()) {
			availableSquares = findAvailableSquares();
			point = availableSquares.get(randomMove(availableSquares.size()));

			performMove(point, playerTurn);
		}
		endGame();
	}

	/**
	 * Mode 3: Player 1 first move is random, then Player 2 tries to moves to the middle, and the rest of the moves are random
	 */
	public void mode3() {
		gameSetup();
		while (!hasMatchEnded()) {
			availableSquares = findAvailableSquares();
			point = availableSquares.get(randomMove(availableSquares.size()));

			performMove(point, playerTurn);
			if (board[1][1] == 0 && playerTurn == 2) {
				point = new Coordinate(1, 1);
				performMove(point, playerTurn);
			}
		}
		endGame();

	}

	/**
	 * Sums the winner counter and resets the board to its default
	 */
	private void endGame() {
		if (player1Won()) {
			p1Victories++;
		} else if (player2Won()) {
			p2Victories++;
		} else {
			ties++;
		}
		board = new int[3][3];
	}

	/**
	 * Finds all available squares present at board
	 *
	 * @return A list with all available positions
	 */
	private ArrayList<Coordinate> findAvailableSquares() {
		ArrayList<Coordinate> freeSquares = new ArrayList<>();
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (board[i][j] == 0) {
					freeSquares.add(new Coordinate(i, j));
				}
			}
		}
		return freeSquares;
	}

	/**
	 * Checks if we have a winner or a tie
	 *
	 * @return true if the game has ended
	 */
	private boolean hasMatchEnded() {
		return (player1Won() || player2Won() || findAvailableSquares().isEmpty());
	}

	/**
	 * Set the move and switches player turn
	 *
	 * @param point the desired coordinates
	 * @param player Player 1 or 2
	 */
	private void performMove(Coordinate point, int player) {
		board[point.x][point.y] = player;
		switchPlayerTurn();
	}


	private void switchPlayerTurn() {
		if (playerTurn == 1) {
			setPlayerTurn(2);
		} else {
			setPlayerTurn(1);
		}

	}

	/**
	 * Choose a random available square index
	 *
	 * @param size The size of availableSquares
	 * @return The random index chosen
	 */
	private int randomMove(int size) {
		Random random = new Random();
		return random.nextInt(size);
	}

	/**
	 * Verifies if X (player 1) has won
	 *
	 * @return true if X won
	 */
	private boolean player1Won() {
		if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 1)
				|| (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 1)) {
			return true;
		}
		for (int i = 0; i < 3; ++i) {
			if (((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 1)
					|| (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 1))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Verifies if O (player 2) has won
	 *
	 * @return true if O won
	 */
	private boolean player2Won() {

		if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 2)
				|| (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 2)) {
			return true;
		}
		for (int i = 0; i < 3; ++i) {
			if ((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 2)
					|| (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 2)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Set the player turn to play
	 *
	 * @param playerTurn
	 *            The current player's turn
	 */
	public void setPlayerTurn(int playerTurn) {
		TicTacToe.playerTurn = playerTurn;
	}

	/**
	 * Return the amount of victories of P1
	 *
	 * @return Player's one victories count
	 */
	public int getP1Victories() {
		return p1Victories;
	}

	/**
	 * Return the amount of victories of P2
	 *
	 * @return Player's two victories count
	 */
	public int getP2Victories() {
		return p2Victories;
	}

	/**
	 * Return the amount of ties
	 *
	 * @return Tie's count
	 */
	public int getTies() {
		return ties;
	}

}