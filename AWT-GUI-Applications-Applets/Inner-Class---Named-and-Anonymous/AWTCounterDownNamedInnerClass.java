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

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTCounterDownNamedInnerClass extends Frame {

	private Label lblCount;		// declare component Label
	private TextField nTextField;	// declare component TextField
	private Button btnCount;	// declare component Button
	private int n;			// n value

	// Constructor to setup UI components
	public AWTCounterDownNamedInnerClass() {
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
		btnCount.addActionListener(new BtnListener());	// btnCount is a source that fires ActionEvent when clicked.
							// The source add an anonymous instance of BtnListener as a listener, which provides
							// the ActionEvent handler called actionPerformed().
							// Clicking btnCount invokes actionPerformed().
		
		this.setSize(250, 80);			// set size of "this" Frame
		this.setTitle("AWTCounter");		// set title of "this" Frame
		this.setVisible(true);			// show "this" Frame
		
	}
	
	public static void main(String... args) {
		new AWTCounterDownNamedInnerClass(); // Invoke the constructor by allocating an anonymous instance
	}
	
	class BtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			n--;					// decrease value of count variable by 1
			nTextField.setText(n + "");		// display count on the TextField as a String
		}
	}
}
