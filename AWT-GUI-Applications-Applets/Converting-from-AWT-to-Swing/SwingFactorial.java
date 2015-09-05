/*
 * 4.1  Exercise: Converting from AWT to Swing
 * Convert all the previous AWT exercises (AWTCounter, AWTAccumulator, 
 * AWTFactorial, etc.) to Swing applications (called SwingCounter, 
 * SwingAccumulator, SwingFactorial, etc.).
 * Notes:
 *  - Swing Components are kept in package javax.swing. They begin with 
 * a prefix "J", e.g., JButton, JLabel, JFrame.
 *  - Swing Components are to be added onto the ContentPane of the 
 * top-level container JFrame. You can retrieve the ContentPane via 
 * method getContentPane() from a JFrame.
 * 
 * Container cp = getContentPane();  // of JFrame
 * cp.setLayout(......);
 * cp.add(......);
 */
package graphics.programming.exercises;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SwingFactorial extends JFrame {
	
	private JLabel lblInput;	// input JLabel
	private JTextField tfInput;	// input JTextField
	private JButton btnCalc;	// calculation JButton
	private JLabel lblOutput;	// output JLabel
	private JTextField tfOutput;	//output JTextField
	
	// constructor to initialize components
	public SwingFactorial() {
		// set FlowLayout to this JFrame
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		
		// create new listener
		InnerListener listener = new InnerListener();
		
		// create input JLabel 
		cp.add(new JLabel("Enter number"));
		
		// create input JTextField
		tfInput = new JTextField("", 5);
		tfInput.setHorizontalAlignment(JTextField.RIGHT);
		tfInput.addActionListener(listener);
		cp.add(tfInput);
		
		// create calculation JButton
		btnCalc = new JButton("Calculate");
		btnCalc.addActionListener(listener);
		cp.add(btnCalc);
		
		// create output JLabel
		cp.add(new JLabel("Factorial"));
		
		// create JTextField to display result of factorial calculation
		tfOutput = new JTextField("", 13);
		tfOutput.setEditable(false);
		tfOutput.setHorizontalAlignment(JTextField.RIGHT);
		cp.add(tfOutput);
		
		// adjusting properties of this JFrame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 75);
		setTitle("Factorial calculator");
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingFactorial();
			}
		});
	}
	
	// named inner class implements ActionListener to use it with button and input textfield
	class InnerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// get number from input textfield
			int number = Integer.parseInt(tfInput.getText());
			// display calculated factorial
			tfOutput.setText(calculateFactorial(number) + "");
		}

	}
	
	/**
	 * Calculate factorial of given number
	 * 
	 * @param number - number to calculate it's factorial
	 * @return factorial of given number
	 */
	private long calculateFactorial(int number) {
		long res = 1;
		for (int i = 1; i <= number; i++) {
			res *= i;
		}
		return res;
	}

}
