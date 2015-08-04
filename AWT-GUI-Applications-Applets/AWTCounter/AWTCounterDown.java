/*
 * 1.1 Exercise: AWTCounter
 * 
 * Write an AWT GUI application (called AWTCounter) as shown in the Figure. Each
 * time the "Count" button is clicked, the counter value shall increase by 1.
 * The program has three components:
 * 1. a Label "Counter";
 * 2. a non-editable TextField to display the counter value;
 * 3. and a Button "Count". The components are placed inside a container Frame, 
 * arranged in FlowLayout.
 * 
 * You have to use control-c, or "close" the CMD shell, or hit the "terminate" 
 * button on Eclipse's Console to terminate the program. This is because the 
 * program does not process the WindowEvent fired by the "window-close" button.
 * 
 * TRY:
 * 
 * 1. Modify the program (called AWTCounterDown) to count down, with an initial value 
 * of 88, as shown.
 * 
 * 2. Modify the program (called AWTFactorial) to display n and factorial of n, as 
 * shown. Clicking the "Next" button shall increase n by 1. n shall begin at 1.
 *
 */
package graphics.programming.exercises;

import java.awt.*;
import java.awt.event.*;

public class AWTCounterDown extends Frame implements ActionListener {

	private Label lblCount;		// declare component Label
	private TextField nTextField;	// declare component TextField
	private Button btnCount;	// declare component Button
	private int n;			// n value

	// Constructor to setup UI components
	public AWTCounterDown() {
		// setting Layout to "this" Frame child-class
		this.setLayout(new FlowLayout());
		
		lblCount = new Label("n");		// creating label
		this.add(lblCount);			// adding label to "this" Frame
		
		n = 88;
		nTextField = new TextField(n + "", 10);	// creating TextField which contents value of count variable
							// and with width 10 symbols
		nTextField.setEditable(false);		// making TextField non-editable
		this.add(nTextField);			// adding TextField to "this" Frame
		
		btnCount = new Button("Count");		// creating button
		this.add(btnCount);			// adding TextField to "this" Frame
		btnCount.addActionListener(this);	// btnCount is a source that fires ActionEvent when clicked.
							// The source add "this" object as a listener, which provides
							// the ActionEvent handler called actionPerformed().
							// Clicking btnCount invokes actionPerformed().
		
		this.setSize(250, 80);			// set size of "this" Frame
		this.setTitle("AWTCounter");		// set title of "this" Frame
		this.setVisible(true);			// show "this" Frame
		
	}
	
	// ActionEvent handler - Called back when the button has been clicked.
	@Override
	public void actionPerformed(ActionEvent arg0) {
		n--;					// decrease value of count variable by 1
		nTextField.setText(n + "");		// display count on the TextField as a String
	}
	
	public static void main(String... args) {
		new AWTCounterDown();			// Invoke the constructor by allocating an anonymous instance
	}
}
