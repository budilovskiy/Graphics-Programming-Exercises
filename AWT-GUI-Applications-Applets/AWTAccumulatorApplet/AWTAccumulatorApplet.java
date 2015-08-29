/*
 * An Java applet is a graphics program run inside a browser. Write a Java 
 * applet (called AWTAccumulatorApplet) which contains:
 * 1. a label "Enter an integer:",
 * 2. a TextField for user to enter a number.
 * 3. The applet shall accumulate all the integers entered and show it on 
 * 		the status bar of the browser's window.
 */
package graphics.programming.exercises;

import java.applet.Applet;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class AWTAccumulatorApplet extends Applet implements ActionListener {
	
	private TextField tfInput;	// input TextField
	private int number; // entered number
	private int sum = 0; // accumulated sum
	
	// init() runs when the applet is loaded. Setup the UI.
	public void init() {
		add(new Label("Enter an integer: "));
		
		tfInput = new TextField(10);
		add(tfInput);
		// Hitting enter key on tfInput invokes actionPerformed()
		tfInput.addActionListener(this);
	}

	// ActionEvent handler - Called back when enter key was hit on TextField.
	@Override
	public void actionPerformed(ActionEvent e) {
		number = Integer.parseInt(e.getActionCommand());
		sum += number;
		tfInput.setText(""); // Clear input TextField
		showStatus("Accumulated sum is: " + sum);
			// show the sum on the status bar of the browser's window
	}

}
