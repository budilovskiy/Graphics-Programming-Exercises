package graphics.programming.exercises;

import java.util.Random;

public class Puzzle {
	
	public static final int GRID_SIZE = 9; // Size of the board
	public static final int SUBGRID_SIZE = 3; // Size of the sub-grid
	
	private static Random random = new Random();
	
	private static int[][] puzzle = { 
			{ 5, 3, 4, 6, 7, 8, 9, 1, 2 },
			{ 6, 7, 2, 1, 9, 5, 3, 4, 8 },
			{ 1, 9, 8, 3, 4, 2, 5, 6, 7 },
			
			{ 8, 5, 9, 7, 6, 1, 4, 2, 3 },
			{ 4, 2, 6, 8, 5, 3, 7, 9, 1 },
			{ 7, 1, 3, 9, 2, 4, 8, 5, 6 },
			
			{ 9, 6, 1, 5, 3, 7, 2, 8, 4 },
			{ 2, 8, 7, 4, 1, 9, 6, 3, 5 },
			{ 3, 4, 5, 2, 8, 6, 1, 7, 9 } };
	
	public static int[][] getPuzzle() {
		return generatePuzzle();
	}
	
	private static int[][] generatePuzzle() {
		int[] tmpRow;
		for (int i = 0; i < 10; i++) {
			int rowNum = (random.nextInt(GRID_SIZE));
			int newRow = (rowNum / SUBGRID_SIZE) * SUBGRID_SIZE + random.nextInt(GRID_SIZE / SUBGRID_SIZE);
			// swap rows
			tmpRow = puzzle[rowNum];
			puzzle[rowNum] = puzzle[newRow];
			puzzle[newRow] = tmpRow;
		}
		return puzzle;
	}
	
	private static int[][] generateBlankPuzzle() {
		for (int i = 0; i < SUBGRID_SIZE*SUBGRID_SIZE; i++)
			for (int j = 0; j < SUBGRID_SIZE*SUBGRID_SIZE; j++)
				puzzle[i][j] = (i*SUBGRID_SIZE + i/SUBGRID_SIZE + j) % (SUBGRID_SIZE*SUBGRID_SIZE) + 1;
		return puzzle;
	}
}
