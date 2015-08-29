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
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class AWTFactorialApplet extends Applet implements ActionListener {
	
	private Button btnFactorial; // counter button
	private TextField tfInput;
	private int number;
	private int factorial; // holds factorial
	
	// init() runs when the applet is loaded. Setup the UI.
	public void init() {
		add(new Label("Enter an integer"));
		
		tfInput = new TextField(10);
		add(tfInput);
		tfInput.addActionListener(this);
		
		btnFactorial = new Button("Calculate");
		btnFactorial.addActionListener(this);
		add(btnFactorial);
		// button clicking invokes actionPerformed()
	}

	// ActionEvent handler - Called back when enter key was hit on TextField.
	@Override
	public void actionPerformed(ActionEvent e) {
		number = Integer.parseInt(tfInput.getText());
		factorial = 1; // reset factorial to 1
		for (int i = 1; i <= number; i++) {
			factorial *= i;
		}
		showStatus(factorial + "");
			// show the factorial on the status bar of the browser's window
	}

}
