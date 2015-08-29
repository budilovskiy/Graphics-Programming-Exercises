/*
 * 3.  Inner Class - Named and Anonymous
 * Compared with the AWTCounter, the following programs 
 * AWTCounterNamedInnerClass and AWTCounterAnonymousInnerClass use 
 * "named inner classes" and "anonymous inner classes", respectively, 
 * as the ActionEvent listener instead of "this" object.
 *
 */
package graphics.programming.exercises;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class AWTCounterNamedInnerClass extends Frame {

	private TextField tfCount;
	private int count;

	public AWTCounterNamedInnerClass() {
		setLayout(new FlowLayout());
		add(new Label("Counter"));
		tfCount = new TextField(count + "", 10);
		tfCount.setEditable(false);
		add(tfCount);

		Button btnCount = new Button("Count");
		add(btnCount);

		btnCount.addActionListener(new BtnListener());

		setSize(300, 75);
		setTitle("Counter");
		setVisible(true);
	}

	public static void main(String... args) {
		new AWTCounterNamedInnerClass();
	}

	class BtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			++count;
			tfCount.setText(count + "");
		}
	}

}
