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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SwingCounter extends JFrame {

	private JLabel lblCount; // declare component Label
	private JTextField nTextField; // declare component TextField
	private JButton btnCount; // declare component Button
	private int n; // n value

	public SwingCounter() {
		this.setLayout(new FlowLayout());
		Container cp = getContentPane();

		lblCount = new JLabel("Count");
		cp.add(lblCount);

		nTextField = new JTextField(10);
		nTextField.setEditable(false);
		nTextField.setText(n + "");
		nTextField.setHorizontalAlignment(JTextField.RIGHT);
		cp.add(nTextField);

		btnCount = new JButton("Count");
		cp.add(btnCount);
		btnCount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				++n;
				nTextField.setText(n + "");
			}
		});

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(350, 75));
		setTitle("Swing Counter");
		setVisible(true);
	}

	public static void main(String... args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingCounter();
			}
		});
	}

}
