/*
 * 3.  Inner Class - Named and Anonymous
 * Compared with the AWTCounter, the following programs 
 * AWTCounterNamedInnerClass and AWTCounterAnonymousInnerClass use 
 * "named inner classes" and "anonymous inner classes", respectively, 
 * as the ActionEvent listener instead of "this" object.
 * 
 * TRY:
 * 
 * 1. Modify all the earlier programs to use (i) a named inner class; 
 * (ii) an anonymous inner class as the ActionEvent listener.
 * 
 * 2. Modify AWTCount (called AWTCounter3Buttons) to include two 
 * additional buttons for counting down and reset the count value. 
 * Use (i) "this" class as listener for all the 3 buttons; (ii) use 
 * one named inner class as listener for all the 3 buttons; (iii) use 
 * an anonymous inner class as listener for each button.
 * Hints for (i) and (ii): You can use event.getActionCommend() to 
 * retrieve the label of the button that has fired the event.
 *
 */
package graphics.programming.exercises;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class AWTCounter3Buttons extends Frame {

	private Label lblCount;		// declare component Label
	private TextField nTextField;	// declare component TextField
	private Button btnUpCount;	// declare component Button
	private Button btnDownCount;	// declare component Button
	private Button btnReset;	// declare component Button
	private int n;			// n value

	// Constructor to setup UI components
	public AWTCounter3Buttons() {
		// setting Layout to "this" Frame child-class
		this.setLayout(new FlowLayout());
		
		lblCount = new Label("n");		// creating label
		this.add(lblCount);			// adding label to "this" Frame
		
		n = 88;
		nTextField = new TextField(n + "", 10);	// creating TextField which contents value of count variable
							// and with width 10 symbols
		nTextField.setEditable(false);		// making TextField non-editable
		this.add(nTextField);			// adding TextField to "this" Frame
		
		btnUpCount = new Button("Count up");		// creating button
		this.add(btnUpCount);			// adding button to "this" Frame
		btnUpCount.addActionListener(new BtnListener());	// btnCount is a source that fires ActionEvent when clicked.
							// The source add an anonymous instance of BtnListener as a listener, which provides
							// the ActionEvent handler called actionPerformed().
							// Clicking btnCount invokes actionPerformed().
		
		btnDownCount = new Button("Count down");		// creating button
		this.add(btnDownCount);			// adding button to "this" Frame
		btnDownCount.addActionListener(new BtnListener());	// btnCount is a source that fires ActionEvent when clicked.
							// The source add an anonymous instance of BtnListener as a listener, which provides
							// the ActionEvent handler called actionPerformed().
							// Clicking btnCount invokes actionPerformed().
		
		btnReset = new Button("Reset");		// creating button
		this.add(btnReset);			// adding button to "this" Frame
		btnReset.addActionListener(new BtnListener());	// btnCount is a source that fires ActionEvent when clicked.
							// The source add an anonymous instance of BtnListener as a listener, which provides
							// the ActionEvent handler called actionPerformed().
							// Clicking btnCount invokes actionPerformed().
		
		this.setSize(350, 80);			// set size of "this" Frame
		this.setTitle("AWTCounter");		// set title of "this" Frame
		this.setVisible(true);			// show "this" Frame
		
	}
	
	public static void main(String... args) {
		new AWTCounter3Buttons(); // Invoke the constructor by allocating an anonymous instance
	}
	
	class BtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()) {
				case "Count up" : n++; break;
				case "Count down" : n--; break;
				case "Reset" : n = 0; break;
			}
			nTextField.setText(n + "");		// display count on the TextField as a String
		}
	}
}
