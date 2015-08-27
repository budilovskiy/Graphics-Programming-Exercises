package customgraphics1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class CGMoveABall extends JFrame {

	public static final int CANVAS_WIDTH = 400;
	public static final int CANVAS_HEIGHT = 200;
	public static final int BALL_SIZE = 50;
	public static final Color BALL_COLOR = Color.RED;
	public static final Color CANVAS_BACKGROUND = Color.CYAN;

	private int x = CANVAS_WIDTH / 2 - BALL_SIZE / 2;
	private int y = CANVAS_HEIGHT / 2 - BALL_SIZE / 2;

	private DrawCanvas canvas;

	public CGMoveABall() {
		JPanel btnPanel = new JPanel(new BorderLayout());
		btnPanel.setPreferredSize(new Dimension(CANVAS_HEIGHT, CANVAS_HEIGHT));

		JButton up = new JButton("Move up");
		btnPanel.add(up, BorderLayout.NORTH);
		up.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				y -= 10;
				canvas.repaint();
				requestFocus();
			}
		});

		JButton left = new JButton("Move left");
		btnPanel.add(left, BorderLayout.WEST);
		left.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				x -= 10;
				canvas.repaint();
				requestFocus();
			}
		});

		JButton right = new JButton("Move right");
		btnPanel.add(right, BorderLayout.EAST);
		right.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				x += 10;
				canvas.repaint();
				requestFocus();
			}
		});

		JButton down = new JButton("Move down");
		btnPanel.add(down, BorderLayout.SOUTH);
		down.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				y += 10;
				canvas.repaint();
				requestFocus();
			}
		});

		canvas = new DrawCanvas();
		canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(canvas, BorderLayout.CENTER);
		cp.add(btnPanel, BorderLayout.EAST);

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				switch (evt.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					x -= 10;
					canvas.repaint();
					break;
				case KeyEvent.VK_RIGHT:
					x += 10;
					canvas.repaint();
					break;
				case KeyEvent.VK_UP:
					y -= 10;
					canvas.repaint();
					break;
				case KeyEvent.VK_DOWN:
					y += 10;
					canvas.repaint();
					break;
				}
			}
		});

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Moving a ball");
		pack();
		setVisible(true);
		requestFocus();
	}

	class DrawCanvas extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(CANVAS_BACKGROUND);
			g.setColor(BALL_COLOR);
			g.fillOval(x, y, BALL_SIZE, BALL_SIZE);
		}
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new CGMoveABall();
			}
		});

	}

}
