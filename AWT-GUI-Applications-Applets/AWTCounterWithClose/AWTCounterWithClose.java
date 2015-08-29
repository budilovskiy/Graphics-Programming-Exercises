/*
 * 2.1  Exercise: Window-Close
 * 
 * Modify the AWTCounter program (called AWTCounterWithClose) to process 
 * the "close-window" button.
 *
 */
package graphics.programming.exercises;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class AWTCounterWithClose extends Frame implements ActionListener,
		WindowListener {

	private Label lblCount; // declare component Label
	private TextField nTextField; // declare component TextField
	private Button btnCount; // declare component Button
	private int n; // n value

	// Constructor to setup UI components
	public AWTCounterWithClose() {
		// setting Layout to "this" Frame child-class
		this.setLayout(new FlowLayout());

		lblCount = new Label("n"); // creating label
		this.add(lblCount); // adding label to "this" Frame

		nTextField = new TextField(n + "", 10); // creating TextField which
												// contents value of count
												// variable
		// and with width 10 symbols
		nTextField.setEditable(false); // making TextField non-editable
		this.add(nTextField); // adding TextField to "this" Frame

		btnCount = new Button("Count"); // creating button
		this.add(btnCount); // adding TextField to "this" Frame
		btnCount.addActionListener(this); // btnCount is a source that fires
											// ActionEvent when clicked.
		// The source add "this" object as a listener, which provides
		// the ActionEvent handler called actionPerformed().
		// Clicking btnCount invokes actionPerformed().

		this.setSize(250, 80); // set size of "this" Frame
		this.setTitle("AWTCounter"); // set title of "this" Frame
		this.setVisible(true); // show "this" Frame

	}

	// ActionEvent handler - Called back when the button has been clicked.
	@Override
	public void actionPerformed(ActionEvent arg0) {
		n++; // increase value of count variable by 1
		nTextField.setText(n + ""); // display count on the TextField as a
									// String
	}

	public static void main(String... args) {
		new AWTCounterWithClose(); // Invoke the constructor by allocating an
									// anonymous instance
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}
}
