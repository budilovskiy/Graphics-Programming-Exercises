/*
 * 3.  Inner Class - Named and Anonymous
 * Compared with the AWTCounter, the following programs 
 * AWTCounterNamedInnerClass and AWTCounterAnonymousInnerClass use 
 * "named inner classes" and "anonymous inner classes", respectively, 
 * as the ActionEvent listener instead of "this" object.
 * 
 * TRY:
 * 
 * Modify all the earlier programs to use (i) a named inner class; 
 * (ii) an anonymous inner class as the ActionEvent listener.
 *
 */
package graphics.programming.exercises;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class AWTFactorialAnonymousInnerClass extends Frame {

	private Label nLbl; // declare component Label
	private TextField nTextField; // declare component TextField
	private Label factLbl; // declare component Label
	private TextField factTextField; // declare component TextField
	private Button btnCount; // declare component Button
	private int n; // n value

	// Constructor to setup UI components
	public AWTFactorialAnonymousInnerClass() {
		// setting Layout to "this" Frame child-class
		this.setLayout(new FlowLayout());

		nLbl = new Label("n"); // creating label
		this.add(nLbl); // adding label to "this" Frame

		n = 1;
		nTextField = new TextField(n + "", 10); 	// creating TextField which
								// contents value of count
								// variable and with width 10
								// symbols
		nTextField.setEditable(true); // making TextField non-editable
		this.add(nTextField); // adding TextField to "this" Frame

		factLbl = new Label("factorial(n)"); // creating label
		this.add(factLbl); // adding label to "this" Frame

		factTextField = new TextField(factorial(n) + "", 10); 	// creating TextField which
																// contents factorial of
																// n and with width 10 symbols
		factTextField.setEditable(false); // making TextField non-editable
		this.add(factTextField); // adding TextField to "this" Frame

		btnCount = new Button("Next"); // creating button
		this.add(btnCount); // adding TextField to "this" Frame
		btnCount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				n++; // increase value of count variable by 1
				nTextField.setText(n + ""); // display value of n on the TextField as a String
				factTextField.setText(factorial(n) + ""); 	// display factorial of n on
										// the TextField as a String
			}
		}); 

		this.setSize(400, 80); // set size of "this" Frame
		this.setTitle("AWTCounter"); // set title of "this" Frame
		this.setVisible(true); // show "this" Frame

	}

	/**
	 * Calculating factorial of given number
	 * 
	 * @param n
	 *            - number to calculate it's factorial
	 * @return factorial of number
	 */
	private long factorial(int n) {
		long fact = 1;
		for (int i = 1; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}

	public static void main(String... args) {
		new AWTFactorialAnonymousInnerClass(); // Invoke the constructor by allocating an anonymous instance
	}

}
