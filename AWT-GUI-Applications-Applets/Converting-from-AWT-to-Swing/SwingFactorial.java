package graphics.programming.exercises;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SwingFactorial extends JFrame {
	
	private JLabel lblInput;	// input JLabel
	private JTextField tfInput;	// input JTextField
	private JButton btnCalc;	// calculation JButton
	private JLabel lblOutput;	// output JLabel
	private JTextField tfOutput;	//output JTextField
	
	// constructor to initialize components
	public SwingFactorial() {
		// set FlowLayout to this JFrame
		setLayout(new FlowLayout());
		
		// create new listener
		InnerListener listener = new InnerListener();
		
		// create input JLabel 
		lblInput = new JLabel("Enter number");
		add(lblInput);
		
		// create input JTextField
		tfInput = new JTextField("", 5);
		tfInput.setHorizontalAlignment(JTextField.RIGHT);
		tfInput.addActionListener(listener);
		add(tfInput);
		
		// create calculation JButton
		btnCalc = new JButton("Calculate");
		btnCalc.addActionListener(listener);
		add(btnCalc);
		
		// create output JLabel
		lblOutput = new JLabel("Factorial");
		add(lblOutput);
		
		// create JTextField to display result of factorial calculation
		tfOutput = new JTextField("", 13);
		tfOutput.setEditable(false);
		tfOutput.setHorizontalAlignment(JTextField.RIGHT);
		add(tfOutput);
		
		// adjusting properties of this JFrame
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(500, 75);
		setTitle("Factorial calculator");
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingFactorial();
			}
		});
	}
	
	// named inner class implements ActionListener to use it with button and input textfield
	class InnerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// get number from input textfield
			int number = Integer.parseInt(tfInput.getText());
			// display calculated factorial
			tfOutput.setText(calculateFactorial(number) + "");
		}

	}
	
	/**
	 * Calculate factorial of given number
	 * 
	 * @param number - number to calculate it's factorial
	 * @return factorial of given number
	 */
	private long calculateFactorial(int number) {
		long res = 1;
		for (int i = 1; i <= number; i++) {
			res *= i;
		}
		return res;
	}

}
