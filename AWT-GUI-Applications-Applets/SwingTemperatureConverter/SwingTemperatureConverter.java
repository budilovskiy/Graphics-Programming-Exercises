/**
 * Write a GUI program called SwingTemperatureConverter to convert 
 * temperature values between Celsius and Fahrenheit. User can enter 
 * either the Celsius or the Fahrenheit value, in floating-point number.
 * 
 * Hints: To display a floating-point number in a specific format (e.g., 
 * 1 decimal place), use the static method String.format(), which has the 
 * same form as printf(). For example, String.format("%.1f", 1.234) 
 * returns String "1.2".
 */
package graphics.programming.exercises;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SwingTemperatureConverter extends JFrame {

	private JTextField tfCelsius, tfFahrenheit;
	double num, result;

	public SwingTemperatureConverter() {
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(2, 2, 10, 4));

		cp.add(new JLabel(" Celsius: "));

		tfCelsius = new JTextField("", 10);
		tfCelsius.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					num = Double.parseDouble(e.getActionCommand());
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
				result = (9.0 / 5.0) * num + 32.0;
				tfFahrenheit.setText(String.format("%.1f", result));
			}
		});
		cp.add(tfCelsius);

		cp.add(new JLabel(" Fahrenheit: "));

		tfFahrenheit = new JTextField("", 10);
		tfFahrenheit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					num = Double.parseDouble(e.getActionCommand());
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
				result = (5.0 / 9.0) * (num - 32.0);
				tfCelsius.setText(String.format("%.1f", result));
			}
		});
		cp.add(tfFahrenheit);

		setSize(300, 100);
		setTitle("Temperature Converter");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingTemperatureConverter();
			}
		});
	}
}
