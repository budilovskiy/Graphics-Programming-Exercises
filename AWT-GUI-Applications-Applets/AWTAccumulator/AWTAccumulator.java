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
public class AWTAccumulator extends Frame {
	
	private Label lblInput; 	// declare input Label
	private Label lblOutput; 	// declare output Label
	private TextField tfInput; 	// declare input TextField
	private TextField tfOutput; 	// declare output display TextField
	private int numberIn; 		// the number entered
	private int sum = 0; 		// the accumulated sum, init to 0
	
	// Constructor to setup the UI
	public AWTAccumulator() {
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
				numberIn = Integer.parseInt(tfInput.getText());
				// accumulate numbers entered into sum
				sum += numberIn;
				// clear input TextField
				tfInput.setText("");
				// display sum on the output TextField
				tfOutput.setText(sum + "");
			}
		});
		add(tfInput); // "this" Frame adds the TextField
		
		lblOutput = new Label("The accumulated sum is"); // allocate
		add(lblOutput); // "this" Frame adds the Label
		
		tfOutput = new TextField(10); // allocate
		tfOutput.setEditable(false); // read-only
		tfOutput.setText(sum + ""); // display sum on the output TextField
		add(tfOutput); // "this" Frame adds the TextField
		
		setTitle("AWTAccumulator"); // "this" Frame sets title
		setSize(350, 120); // "this" Frame sets initial size
		setVisible(true); // "this" Frame shows
	}
	
	// The entry main() method
	public static void main(String... args) {
		// Invoke the constructor by allocating an anonymous instance
		new AWTAccumulator();
	}
	
}
