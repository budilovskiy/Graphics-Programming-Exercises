package customgraphics4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class CGBouncingBallSwingTimer extends JFrame {

	private static final int CANVAS_WIDTH = 640;
	private static final int CANVAS_HEIGHT = 480;
	private static final int UPDATE_PERIOD = 10; // milliseconds

	private DrawCanvas canvas;

	private int x = 100;
	private int y = 100;
	private int size = 150;
	private int xSpeed = 4;
	private int ySpeed = 8;

	public CGBouncingBallSwingTimer() {
		canvas = new DrawCanvas();
		canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		setContentPane(canvas);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setTitle("Bouncing ball");
		setVisible(true);

		ActionListener updateTask = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				update();
				repaint();
			}
		};

		new Timer(UPDATE_PERIOD, updateTask).start();
	}

	protected void update() {

		x += xSpeed;
		y += ySpeed;
		
		if (x > CANVAS_WIDTH - size || x < 0) {
			xSpeed = - xSpeed;
		}
		
		if (y > CANVAS_HEIGHT - size || y < 0) {
			ySpeed = - ySpeed;
		}

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new CGBouncingBallSwingTimer();
			}
		});
	}

	private class DrawCanvas extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(Color.BLACK);
			g.setColor(Color.BLUE);
			g.fillOval(x, y, size, size);
		}

	}

}
