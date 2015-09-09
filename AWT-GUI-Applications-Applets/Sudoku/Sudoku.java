/**
 * Produce the display for a Sudoku game, as shown. It consists of 9x9 JTextFields 
 * arranged in a GridLayout.
 * 
 * Hints: Use the following variables.
 * // Game board
 * int[][] board = new int[9][9];
 * JTextField[][] tfDisplays = new JTextField[9][9];
 * 
 * // Puzzle to solve - 0 are the empty cells
 * int[][] puzzle = {{5, 3, 4, 6, 7, 0, 9, 1, 2},
 *                   {6, 7, 2, 1, 9, 5, 3, 4, 0},
 *                   {1, 9, 0, 3, 4, 2, 5, 6, 7},
 *                   {0, 5, 9, 7, 6, 1, 4, 2, 3},
 *                   {4, 2, 6, 0, 5, 3, 7, 9, 1},
 *                   {7, 1, 3, 9, 2, 4, 0, 5, 6},
 *                   {9, 6, 1, 5, 3, 7, 2, 0, 4},
 *                   {2, 0, 7, 4, 1, 9, 6, 3, 5},
 *                   {3, 4, 5, 2, 0, 6, 1, 7, 9}};
 *                   
 * Start with the GUI for display. The GUI codes is simple. You can simply use a 
 * 9x9 JTextFields arranged in a 9x9 GridLayout.
 * The steps for producing the display are:
 * Set the JFrame's content-pane to 9×9 GridLayout. Create 9×9 JTextFields (called 
 * tfDisplays) and add to the content-pane. The JTextFields shall contain the string 
 * "1" to "9" (the number from the puzzle or the number guessed) or empty string 
 * (for blank cells).
 * Initialize the game by reading in an input puzzle (int[9][9] puzzle) with blank 
 * cells (handled by boolean[9][9] masks), and populate the tfDisplays arrays. Set 
 * the non-empty cells to non-editable containing the number from the puzzle; and 
 * set the empty cells to editable containing an empty string.
 */

package graphics.programming.exercises;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class Sudoku extends JFrame {

	public static final int GRID_SIZE = Puzzle.GRID_SIZE; // Size of the board
	public static final int SUBGRID_SIZE = Puzzle.SUBGRID_SIZE; // Size of the

	public static final int CELL_SIZE = 50; // Cell width/height in pixels
	public static final int CANVAS_WIDTH = CELL_SIZE * GRID_SIZE;
	public static final int CANVAS_HEIGHT = CELL_SIZE * GRID_SIZE;

	public static final Color OPEN_CELL_BGCOLOR = Color.YELLOW;
	public static final Color OPEN_CELL_TEXT_YES = new Color(0, 255, 0); // RGB
	public static final Color OPEN_CELL_TEXT_NO = Color.RED;
	public static final Color CLOSED_CELL_BGCOLOR = new Color(240, 240, 240); // RGB
	public static final Color CLOSED_CELL_TEXT = Color.BLACK;
	public static final Font FONT_NUMBERS = new Font("Monospaced", Font.BOLD, 18);

	public static int difficultyLevel; // 1 - 5
	public static int closedCellsNum; // difficultyLevel * 10

	public static JPanel board;
	public static JPanel statusPanel;
	public static JLabel statusLabel;
	public static JMenuBar menu;

	JTextField[][] tfDisplays = new JTextField[GRID_SIZE][GRID_SIZE];

	// Puzzle to be solved and the mask (which can be used to control the
	// difficulty level).
	private int[][] puzzle = Puzzle.getPuzzle();

	private static boolean[][] masks = {
			{ false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false } };

	public Sudoku() {

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		// Create game board
		board = new JPanel();
		board.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
		cp.add(board, BorderLayout.CENTER);

		// Create status panel
		statusPanel = new JPanel();
		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		statusPanel.setPreferredSize(new Dimension(cp.getWidth(), 25));
		statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
		statusLabel = new JLabel("Cells remaining: " + closedCellsNum);
		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		statusPanel.add(statusLabel);
		cp.add(statusPanel, BorderLayout.SOUTH);
		
		// Creating menu bar and menu items
		menu = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
	        JMenuItem newGameItem = new JMenuItem("New game");
	        newGameItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
	        fileMenu.add(newGameItem);
	        JMenuItem resetGameItem = new JMenuItem("Reset game");
	        resetGameItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
	        fileMenu.add(resetGameItem);
	        JMenuItem exitItem = new JMenuItem("Exit");
	        exitItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
	        fileMenu.add(exitItem);
	        menu.add(fileMenu);
	        
	        JMenu optionsMenu = new JMenu("Options");
	        JMenu difficultyMenu = new JMenu("Difficulty level");
	        optionsMenu.add(difficultyMenu);
	        DifficultyMenuListener dmlistener = new DifficultyMenuListener();
	        JMenuItem level1Item = new JMenuItem("Level 1");
	        level1Item.addActionListener(dmlistener);
	        difficultyMenu.add(level1Item);
	        JMenuItem level2Item = new JMenuItem("Level 2");
	        level2Item.addActionListener(dmlistener);
	        difficultyMenu.add(level2Item);
	        JMenuItem level3Item = new JMenuItem("Level 3");
	        level3Item.addActionListener(dmlistener);
	        difficultyMenu.add(level3Item);
	        JMenuItem level4Item = new JMenuItem("Level 4");
	        level4Item.addActionListener(dmlistener);
	        difficultyMenu.add(level4Item);
	        JMenuItem level5Item = new JMenuItem("Level 5");
	        level5Item.addActionListener(dmlistener);
	        difficultyMenu.add(level5Item);
	        JMenuItem level6Item = new JMenuItem("Level 6");
	        level6Item.addActionListener(dmlistener);
	        difficultyMenu.add(level6Item);
	        JMenuItem level7Item = new JMenuItem("Level 7");
	        level7Item.addActionListener(dmlistener);
	        difficultyMenu.add(level7Item);
	        menu.add(optionsMenu);
	        
	        setJMenuBar(menu);
	
	        // Initialize game
		initGame(board);

		// Set the size of the content-pane and pack all the components
		// under this container.
		cp.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		pack();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Sudoku");
		setVisible(true);
	}

	/**
	 * Initialize table of the game
	 * 
	 * @param board - JPanel game board to put table in
	 */
	private void initGame(JPanel board) {
		// Declare and allocate a common instance called listener of the
		// InputListener class
		InputListener listener = new InputListener();

		for (int row = 0; row < GRID_SIZE; ++row) {
			for (int col = 0; col < GRID_SIZE; ++col) {
				tfDisplays[row][col] = new JTextField(); // Allocate element of array
				tfDisplays[row][col].setHorizontalAlignment(JTextField.CENTER);
				tfDisplays[row][col].setFont(FONT_NUMBERS);
				board.add(tfDisplays[row][col]); // ContentPane adds JTextField
				if (masks[row][col]) {
					tfDisplays[row][col].setText(""); // set to empty string
					tfDisplays[row][col].setEditable(true);
					tfDisplays[row][col].setBackground(OPEN_CELL_BGCOLOR);
					// All editable JTextField adds ActionEvent listener
					tfDisplays[row][col].addActionListener(listener);
				} else {
					tfDisplays[row][col].setText(puzzle[row][col] + "");
					tfDisplays[row][col].setEditable(false);
					tfDisplays[row][col].setBackground(CLOSED_CELL_BGCOLOR);
					tfDisplays[row][col].setForeground(CLOSED_CELL_TEXT);
				}
			}
		}
	}

	/**
	 * Set difficulty level by setting the number of closed cells
	 * Cells to be closed are selected randomly
	 * @param difficultyLevel - selected by user number of difficulty
	 */
	private static void setDifficultyLevel(int difficultyLevel) {
		closedCellsNum = difficultyLevel * 10;
		Random random = new Random();
		int randomRow = 0;
		int randomCol = 0;
		// Close random cells according to difficulty level
		for (int i = 0; i < closedCellsNum; i++) {
			randomRow = random.nextInt(GRID_SIZE);
			randomCol = random.nextInt(GRID_SIZE);
			// If random cell is open, close it.
			// else decrease loop counter and try again
			if (!masks[randomRow][randomCol]) {
				masks[randomRow][randomCol] = true;
			} else {
				i--;
			}
		}
	}

	/**
	 * Inner class to be used as ActionEvent listener for all JTextFields
	 */
	private class InputListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int rowSelected = -1;
			int colSelected = -1;

			// Get the source object that fired the event
			JTextField source = (JTextField) e.getSource();
			// Scan all rows and columns, and match with the source object
			boolean found = false;
			for (int row = 0; row < GRID_SIZE && !found; row++) {
				for (int col = 0; col < GRID_SIZE && !found; col++) {
					if (tfDisplays[row][col] == source) {
						rowSelected = row;
						colSelected = col;
						found = true; // break the inner/outer loops
					}
				}
			}

			// Get the input String and convert it to int
			int input = -1;
			try {
				input = Integer.parseInt(source.getText());
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Enter number from 1 to 9");
			}
			// Compare the input number with the number in the puzzle. If they
			// are the same, display in green; otherwise, display in red.
			int subgridFirstRowNum = rowSelected / SUBGRID_SIZE * SUBGRID_SIZE; // 0, 3 or 6
			int subgridFirstColNum = colSelected / SUBGRID_SIZE * SUBGRID_SIZE; // 0, 3 or 6
			if (input == puzzle[rowSelected][colSelected]) {
				tfDisplays[rowSelected][colSelected] .setForeground(OPEN_CELL_TEXT_YES);
				tfDisplays[rowSelected][colSelected].setEditable(false);
				masks[rowSelected][colSelected] = false;
				// Repaint highlighted cells in sub-grid
				for (int row = subgridFirstRowNum; row < subgridFirstRowNum + SUBGRID_SIZE; row++) {
					for (int col = subgridFirstColNum; col < subgridFirstColNum + SUBGRID_SIZE; col++) {
						if (!masks[row][col]) {
							tfDisplays[row][col] .setBackground(CLOSED_CELL_BGCOLOR);
						}
					}
				}
				// decrease number of closed cells and display it on status bar
				statusLabel.setText("Cells remaining: " + --closedCellsNum);
			} else {
				tfDisplays[rowSelected][colSelected]
						.setForeground(OPEN_CELL_TEXT_NO);
				// Highlight conflicting number in sub-grid
				for (int row = subgridFirstRowNum; row < subgridFirstRowNum
						+ SUBGRID_SIZE; row++) {
					for (int col = subgridFirstColNum; col < subgridFirstColNum
							+ SUBGRID_SIZE; col++) {
						if (puzzle[row][col] == input && !masks[row][col]) {
							tfDisplays[row][col]
									.setBackground(OPEN_CELL_TEXT_NO);
						}
					}
				}
			}
			
			// Check if the player has solved the puzzle after this move
			boolean win = true;
			for (int row = 0; row < GRID_SIZE && win; row++) {
				for (int col = 0; col < GRID_SIZE && win; col++) {
					win = !masks[row][col];
				}
			}

			// If all the cells are filled properly, display Congratulation
			// dialog
			if (win) {
				JOptionPane.showMessageDialog(null, "Congratulation!");
			}
		}

	}
	
	/**
	 * Inner class to be used as ActionEvent listener to set 
	 * difficulty level from menu
	 */
	private class DifficultyMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Level 1":
				setDifficultyLevel(1);
				break;
			case "Level 2":
				setDifficultyLevel(2);
				break;
			case "Level 3":
				setDifficultyLevel(3);
				break;
			case "Level 4":
				setDifficultyLevel(4);
				break;
			case "Level 5":
				setDifficultyLevel(5);
				break;
			case "Level 6":
				setDifficultyLevel(6);
				break;
			case "Level 7":
				setDifficultyLevel(7);
				break;
			default:
				setDifficultyLevel(1);
				break;
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				setDifficultyLevel(1);
				new Sudoku();
			}
		});
	}

}
