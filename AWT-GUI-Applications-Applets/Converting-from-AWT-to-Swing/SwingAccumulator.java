/*
 * 4.1  Exercise: Converting from AWT to Swing
 * Convert all the previous AWT exercises (AWTCounter, AWTAccumulator, 
 * AWTFactorial, etc.) to Swing applications (called SwingCounter, 
 * SwingAccumulator, SwingFactorial, etc.).
 * Notes:
 *  - Swing Components are kept in package javax.swing. They begin with 
 * a prefix "J", e.g., JButton, JLabel, JFrame.
 *  - Swing Components are to be added onto the ContentPane of the 
 * top-level container JFrame. You can retrieve the ContentPane via 
 * method getContentPane() from a JFrame.
 * 
 * Container cp = getContentPane();  // of JFrame
 * cp.setLayout(......);
 * cp.add(......);
 */
package graphics.programming.exercises;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SwingAccumulator extends JFrame {

	private JLabel lblInput; // declare component Label
	private JLabel lblOutput; // declare component Label
	private JTextField tfInput; // declare component TextField
	private JTextField tfOutput; // declare component TextField
	private int number; // number value
	private int sum; // sum to accumulate numbers

	public SwingAccumulator() {
		this.setLayout(new FlowLayout());
		Container cp = getContentPane();
		
		lblInput = new JLabel("Input");
		cp.add(lblInput);
		
		tfInput = new JTextField(10);
		tfInput.setHorizontalAlignment(JTextField.RIGHT);
		cp.add(tfInput);
		tfInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				number = Integer.parseInt(e.getActionCommand());
				tfInput.setText("");
				sum += number;
				tfOutput.setText(sum + "");
			}
		});

		lblOutput = new JLabel("Output");
		cp.add(lblOutput);

		tfOutput = new JTextField(10);
		tfOutput.setEditable(false);
		tfOutput.setText(number + "");
		tfOutput.setHorizontalAlignment(JTextField.RIGHT);
		cp.add(tfOutput);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(350, 75));
		setTitle("Swing Accumulator");
		setVisible(true);
	}

	public static void main(String... args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingAccumulator();
			}
		});
	}

}
