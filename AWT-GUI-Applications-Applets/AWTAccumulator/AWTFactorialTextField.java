/*
 * 1.2  Exercise: AWTAccumulator
 * 
 * Write an AWT GUI application called AWTAccumulator, which has four components:
 * 1. a Label "Enter an integer and press enter";
 * 2. an input TextField;
 * 3. a Label "The accumulated sum is", and
 * 4. a protected (read-only) TextField for displaying the accumulated sum.
 * 
 * The four GUI components are placed inside a container Frame, arranged in 
 * FlowLayout. The program shall accumulate the numbers entered into the input 
 * TextField, and display the accumulated sum on the display TextField.
 *
 * TRY:
 * 1. Modify the program (called AWTAccumulatorLabel) to display the sum using 
 * a Label instead of a protected TextField, as shown.
 * 
 * 2. Modify the program (called AWTFactorialTextField) to display the factorial 
 * of the input number, as shown.
 *
 */
package graphics.programming.exercises;

import java.awt.*;		// Using AWT containers and components
import java.awt.event.*;	// Using AWT events and listener interfaces

//A GUI program inherits the top-level Container Frame
@SuppressWarnings("serial")
public class AWTFactorialTextField extends Frame {
	
	private Label lblInput; // declare input Label
	private Label lblOutput; // declare output Label
	private TextField tfInput; // declare input TextField
	private Label tfOutput; // declare output display TextField
	private int numberIn; // the number entered
	
	// Constructor to setup the UI
	public AWTFactorialTextField() {
		initComponents();
	}

	// Method to initialize UI components
	private void initComponents() {
		setLayout(new FlowLayout()); // "this" Frame sets to FlowLayout
		
		lblInput = new Label("Enter an integer and press enter"); // allocate
		add(lblInput); // "this" Frame adds the Label
		
		tfInput = new TextField(10); // allocate
		// tfInput is a source that fires ActionEvent when entered.
        	// The source add anonymous ActionEvent object as a listener, 
		// which provides an ActionEvent handler called actionPerformed().
        	// Hitting enter key on tfInput invokes actionPerformed().
		tfInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// get the String entered, convert to int
				try {
					numberIn = Integer.parseInt(tfInput.getText());
					// clear input TextField
					tfInput.setText("");
					// calculate and display factorial on the output Label
					tfOutput.setText(calculateFactorial(numberIn) + "");
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
		});
		add(tfInput); // "this" Frame adds the TextField
		
		lblOutput = new Label("The factorial is"); // allocate
		add(lblOutput); // "this" Frame adds the Label
		
		tfOutput = new Label(); // allocate
		add(tfOutput); // "this" Frame adds the TextField
		
		setTitle("AWTAccumulator"); // "this" Frame sets title
		setSize(350, 120); // "this" Frame sets initial size
		setVisible(true); // "this" Frame shows
	}
	
	/**
	 * Calculate factorial of given number
	 * 
	 * @param numberIn - number to calculate it's factorial
	 * @return factorial of given number
	 */
	private int calculateFactorial(int numberIn) {
		int result = 1;
		for (int i = 1; i <= numberIn; i++) {
			result *= i;
		}
		return result;
	}
	
	// The entry main() method
	public static void main(String... args) {
		// Invoke the constructor by allocating an anonymous instance
		new AWTFactorialTextField();
	}
	
}
