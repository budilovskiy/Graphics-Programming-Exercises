/**
 * Write a Swing application called SwingAdder as shown. The "ADD" button adds 
 * the two integers and display the result. The "CLEAR" button shall clear all 
 * the text fields.
 * Hints: Set the content-pane to 4x2 GridLayout. The components are added from 
 * left-to-right, top-to-bottom.
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
public class SWingAdder extends JFrame {

	private JTextField tfNum1, tfNum2, tfResult;
	private JButton btnAdd, btnClear;

	public SWingAdder() {
		// Swing components must be added to the ContentPane.
		Container cp = getContentPane();
		// Set this Container to grid layout of 4 rows and 2 columns
		cp.setLayout(new GridLayout(4, 2, 10, 3));

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

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double num1 = Double.parseDouble(tfNum1.getText());
					double num2 = Double.parseDouble(tfNum2.getText());
					tfResult.setText((num1 + num2) + "");
				} catch (NumberFormatException ex) { // if parseDouble throws an exception
					tfResult.setText("Enter numbers");
				}
			}
		});
		cp.add(btnAdd);

		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tfNum1.setText("");
				tfNum2.setText("");
				tfResult.setText("");
			}
		});
		cp.add(btnClear);

		setSize(300, 170);
		setTitle("Swing Adder");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SWingAdder();
			}
		});
	}
}
