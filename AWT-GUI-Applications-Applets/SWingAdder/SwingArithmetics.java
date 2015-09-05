/**
 * Modify the above exercise (called SwingArithmetics) to include 
 * buttons "+", "-", "*", "/", "%" (remainder) and "CLEAR" as shown.
 */
package graphics.programming.exercises;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SwingArithmetics extends JFrame {

	private JTextField tfNum1, tfNum2, tfResult;
	private JButton btnAdd, btnClear, btnProduct, btnDivide, btnRemind;

	public SwingArithmetics() {
		// Swing components must be added to the ContentPane.
		Container cp = getContentPane();
		// Set this Container to grid layout of 4 rows and 2 columns
		cp.setLayout(new GridLayout(6, 2, 10, 3));

		// listener is an instance of inner named class ButtonListener
		BtnListener listener = new BtnListener();

		// Create and add components the ContentPane
		cp.add(new JLabel("First number"));

		tfNum1 = new JTextField("", 10);
		tfNum1.setHorizontalAlignment(JTextField.RIGHT);
		add(tfNum1);

		cp.add(new JLabel("Second number"));

		tfNum2 = new JTextField("", 10);
		tfNum2.setHorizontalAlignment(JTextField.RIGHT);
		add(tfNum2);

		cp.add(new JLabel("Result"));

		tfResult = new JTextField("", 10);
		tfResult.setHorizontalAlignment(JTextField.RIGHT);
		tfResult.setEditable(false);
		add(tfResult);

		btnAdd = new JButton("+");
		btnAdd.addActionListener(listener);
		cp.add(btnAdd);

		btnClear = new JButton("-");
		btnClear.addActionListener(listener);
		cp.add(btnClear);

		btnProduct = new JButton("*");
		btnProduct.addActionListener(listener);
		cp.add(btnProduct);

		btnDivide = new JButton("/");
		btnDivide.addActionListener(listener);
		cp.add(btnDivide);

		btnRemind = new JButton("%");
		btnRemind.addActionListener(listener);
		cp.add(btnRemind);

		btnClear = new JButton("CLEAR");
		//add new anonymous ActionListener instance 
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tfNum1.setText("");
				tfNum2.setText("");
				tfResult.setText("");
			}
		});
		cp.add(btnClear);

		setSize(300, 220);
		setTitle("Swing Adder");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private class BtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			double result = 0;
			try {
				// Convert numbers from String to double
				double num1 = Double.parseDouble(tfNum1.getText());
				double num2 = Double.parseDouble(tfNum2.getText());
				// Calculate result of operation according to button that fired ActionEvent 
				switch (e.getActionCommand()) {
				case "+":
					result = num1 + num2;
					break;
				case "-":
					result = num1 - num2;
					break;
				case "*":
					result = num1 * num2;
					break;
				case "/":
					result = num1 / num2;
					break;
				case "%":
					result = num1 % num2;
					break;
				}
				// Display result
				tfResult.setText(result + "");
			} catch (NumberFormatException ex) { // if parseDouble throws an exception
				tfResult.setText("Enter numbers");
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingArithmetics();
			}
		});
	}
}
