/**
 * Study the "Move-a-line" program. Modifying the program to move 
 * a ball in response to up/down/left/right buttons, as well as 
 * the 4 arrow keys, as shown.
 */

package graphics.programming.exercises;

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
public class MoveABall extends JFrame {
	
	private static final int CANVAS_WIDTH = 400;
	private static final int CANVAS_HEIGHT = 300;
	private static final int BALL_SIZE = 100;
	public static final Color BALL_COLOR = Color.RED;
	public static final Color CANVAS_BACKGROUND = Color.BLACK;
	
	private int x = CANVAS_WIDTH / 2 - BALL_SIZE / 2;
	private int y = CANVAS_HEIGHT / 2 - BALL_SIZE / 2;
	
	private DrawCanvas canvas;
	
	public MoveABall() {
		canvas = new DrawCanvas();
		canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		
		JPanel btnPanel = new JPanel(new BorderLayout());
		btnPanel.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT / 2));
		
		JButton btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				y -= 10;
				canvas.repaint();
				requestFocus();
			}
		});
		btnPanel.add(btnUp, BorderLayout.NORTH);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				x -= 10;
				canvas.repaint();
				requestFocus();
			}
		});
		btnPanel.add(btnLeft, BorderLayout.WEST);
		
		JButton btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				x += 10;
				canvas.repaint();
				requestFocus();
			}
		});
		btnPanel.add(btnRight, BorderLayout.EAST);
		
		JButton btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				y += 10;
				canvas.repaint();
				requestFocus();
			}
		});
		btnPanel.add(btnDown, BorderLayout.SOUTH);
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(canvas, BorderLayout.CENTER);
		cp.add(btnPanel, BorderLayout.SOUTH);
		
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

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MoveABall();
			}
		});
	}
	
	private class DrawCanvas extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(CANVAS_BACKGROUND);
			g.setColor(BALL_COLOR);
			g.fillOval(x, y, BALL_SIZE, BALL_SIZE);
		}
	}

}
