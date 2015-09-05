/**
 * Implement a simple calculator (called SwingCalculator).
 * 
 * Hints:
 * 
 * Set the ContentPane to BorderLayout. Add a JTextField (tfDisplay) 
 * to the NORHT. Add a JPanel (panelButtons) to the CENTER. Set the 
 * JPanel to GridLayout of 4x4, and add the 16 buttons.
 * 
 * All the number buttons can share the same listener as they can be 
 * processed with the same codes. Use event.getActionCommand() to get 
 * the label of the button that fires the event.
 * 
 * The operator buttons "+", "-", "*", "/", "%" and "=" can share a 
 * common listener.
 * 
 * Use an anonymous inner class for "C" button.
 * 
 * You need to keep track of the previous operator. For example in 
 * "1 + 2 =", the current operator is "=", while the previous operator 
 * is "+". Perform the operation specified by the previous operator.
 * 
 */
package graphics.programming.exercises;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SwingCalculator extends JFrame {

	private JTextField tfDisplay;
	private int result = 0;
	private JPanel btnPanel;
	private JButton btnC, btnCalculate, btnAdd, btnSubtract, btnProduct,
			btnDivide, btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,
			btn9;

	private String numberInStr = ""; // the number entered as String
	private char previousOpr = ' '; // the previous operator
	private char currentOpr = ' '; // the current operator

	public SwingCalculator() {
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		tfDisplay = new JTextField("0");
		tfDisplay.setHorizontalAlignment(JTextField.RIGHT);
		cp.add(tfDisplay, BorderLayout.NORTH);

		btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(4, 4, 5, 5));
		cp.add(btnPanel, BorderLayout.CENTER);

		// Declare listeners as an instances of named inner classes
		NumberButtonListener numBtnListener = new NumberButtonListener();
		OperatorButtonListener oprBtnListener = new OperatorButtonListener();

		// Add buttons to button panel
		btn7 = new JButton("7");
		btn7.addActionListener(numBtnListener);
		btnPanel.add(btn7);

		btn8 = new JButton("8");
		btn8.addActionListener(numBtnListener);
		btnPanel.add(btn8);

		btn9 = new JButton("9");
		btn9.addActionListener(numBtnListener);
		btnPanel.add(btn9);

		btnAdd = new JButton("+");
		btnAdd.addActionListener(oprBtnListener);
		btnPanel.add(btnAdd);

		btn4 = new JButton("4");
		btn4.addActionListener(numBtnListener);
		btnPanel.add(btn4);

		btn5 = new JButton("5");
		btn5.addActionListener(numBtnListener);
		btnPanel.add(btn5);

		btn6 = new JButton("6");
		btn6.addActionListener(numBtnListener);
		btnPanel.add(btn6);

		btnSubtract = new JButton("-");
		btnSubtract.addActionListener(oprBtnListener);
		btnPanel.add(btnSubtract);

		btn1 = new JButton("1");
		btn1.addActionListener(numBtnListener);
		btnPanel.add(btn1);

		btn2 = new JButton("2");
		btn2.addActionListener(numBtnListener);
		btnPanel.add(btn2);

		btn3 = new JButton("3");
		btn3.addActionListener(numBtnListener);
		btnPanel.add(btn3);

		btnProduct = new JButton("*");
		btnProduct.addActionListener(oprBtnListener);
		btnPanel.add(btnProduct);

		btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Reset all variables and display TextField
				result = 0;
				tfDisplay.setText("0");
				numberInStr = "";
				previousOpr = ' ';
				currentOpr = ' ';
			}
		});
		btnPanel.add(btnC);

		btn0 = new JButton("0");
		btn0.addActionListener(numBtnListener);
		btnPanel.add(btn0);

		btnCalculate = new JButton("=");
		btnCalculate.addActionListener(oprBtnListener);
		btnPanel.add(btnCalculate);

		btnDivide = new JButton("/");
		btnDivide.addActionListener(oprBtnListener);
		btnPanel.add(btnDivide);

		setTitle("Swing calculator");
		setSize(250, 180);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingCalculator();
			}
		});
	}

	/*
	 * Listener to the number buttons
	 */
	private class NumberButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Concatenate entered symbols and display result number
			numberInStr += e.getActionCommand();
			tfDisplay.setText(numberInStr);
		}
	}

	/*
	 * Listener to the operation buttons
	 */
	private class OperatorButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!numberInStr.equals("")) {
				previousOpr = currentOpr; // save
				currentOpr = e.getActionCommand().charAt(0);
				// Perform the operation specified by the previous operator.
				switch (previousOpr) {
				case '+':
					// Calculate result
					result += Integer.parseInt(numberInStr);
					// Display result
					tfDisplay.setText(result + "");
					// Reset number in string
					numberInStr = "";
					break;
				case '-':
					// Calculate result
					result -= Integer.parseInt(numberInStr);
					// Display result
					tfDisplay.setText(result + "");
					// Reset number in string
					numberInStr = "";
					break;
				case '*':
					// Calculate result
					result *= Integer.parseInt(numberInStr);
					// Display result
					tfDisplay.setText(result + "");
					// Reset number in string
					numberInStr = "";
					break;
				case '/':
					// Calculate result
					result /= Integer.parseInt(numberInStr);
					// Display result
					tfDisplay.setText(result + "");
					// Reset number in string
					numberInStr = "";
					break;
				case '=':
					// Reset number in string
					numberInStr = "";
					break;
				default:
					// Save previous number to result
					result = Integer.parseInt(numberInStr);
					// Reset number in string
					numberInStr = "";
				}
			} else {
				// If numberInStr equals "" simply save current operation to
				// currentOpr variable
				currentOpr = e.getActionCommand().charAt(0);
			}
		}
	}
}
