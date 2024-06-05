package tictactoe;

import java.util.Scanner;

public class TicTacToe{
	private static char[][] grid = new char[3][3];
	private static char currentPlayer = 'X';
	private static Scanner scanner = new Scanner(System.in);
	
	public static void initializeGame() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3;j++) {
				grid[i][j]=' ';
			}
		}
	}


	public static void printGrid() {
		for (int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(grid[i][j]);
				if (j<2) {
					System.out.print("|");
				}
			}
			System.out.println();
			if (i<2) {
				System.out.println("-----");
			}
		}
	}

	public static boolean checkWinner(char player) {
		for(int i=0; i<3;i++) {
			if(grid[i][0]==player&&grid[i][1]==player&&grid[i][2]==player) {
				return true;
			}
			if(grid[0][i]==player&&grid[1][i]==player&&grid[2][i]==player) {
				return true;
			}
		}
		if(grid[0][0]==player&&grid[1][1]==player&&grid[2][2]==player) {
			return true;
		}
		if(grid[0][2]==player&&grid[1][1]==player&&grid[2][0]==player) {
			return true;
		}
		return false;
	}

	public static boolean checkDraw() {
		for (int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(grid[i][j]==' ') {
					return false;
				}
			}
		}
		return true;
	}
	public static void switchPlayer() {
		currentPlayer=(currentPlayer=='X')? 'O':'X';
	}
	public static void play() {
		while(true) {
			printGrid();
			System.out.println("Player "+ currentPlayer + ", enter the row (0-2):");
			int row = scanner.nextInt();
			System.out.println("Player "+ currentPlayer + ", enter the column (0-2):");
			int col = scanner.nextInt();
			if(row<0||row>2||col<0||col>2||grid[row][col]!=' ') {
				System.out.println("Invalid move, try again!");
				continue;
			}
			grid[row][col]=currentPlayer;
			if(checkWinner(currentPlayer)) {
				printGrid();
				System.out.println("Player "+ currentPlayer + " wins!!!");
				break;
			}
			if(checkDraw()) {
				printGrid();
				System.out.println("It's a DRAW!");
				break;
			}
			switchPlayer();
		}
	}
	public static void main(String[]args) {
		initializeGame();
		play();
	}
}
