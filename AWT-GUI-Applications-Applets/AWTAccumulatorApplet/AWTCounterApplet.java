/*
 * An Java applet is a graphics program run inside a browser. Write a Java 
 * applet (called AWTAccumulatorApplet) which contains:
 * 1. a label "Enter an integer:",
 * 2. a TextField for user to enter a number.
 * 3. The applet shall accumulate all the integers entered and show it on 
 * 		the status bar of the browser's window.
 * TRY:
 * Modify the applet to run the "Counter" application (as in AWTCounter).
 * Modify the applet to run the "Factorial" application (as in AWTFactorial).
 */
package graphics.programming.exercises;

import java.applet.Applet;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class AWTCounterApplet extends Applet implements ActionListener {
	
	private Button btnCount; // counter button
	private int counter = 0; // counter accumulator
	
	// init() runs when the applet is loaded. Setup the UI.
	public void init() {
		btnCount = new Button("Count");
		add(btnCount);
		// button clicking invokes actionPerformed()
		btnCount.addActionListener(this);
	}

	// ActionEvent handler - Called back when enter key was hit on TextField.
	@Override
	public void actionPerformed(ActionEvent e) {
		++counter;
		showStatus("Counter: " + counter);
			// show the counter on the status bar of the browser's window
	}

}
