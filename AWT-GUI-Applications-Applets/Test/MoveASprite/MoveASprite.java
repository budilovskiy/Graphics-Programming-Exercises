package customgraphics2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
public class MoveASprite extends JFrame {
	
	public static final int CANVAS_WIDTH = 400;
	public static final int CANVAS_HEIGHT = 100;
	public static final Color CANVAS_BG_COLOR = Color.DARK_GRAY;
	
	private DrawCanvas canvas; // instance of inner class DrawCanvas
	private Sprite sprite; // instance of Sprite class
	
	public MoveASprite() {
		// create new sprite
		sprite = new Sprite(CANVAS_WIDTH / 2 - 5, CANVAS_HEIGHT / 2 - 40, 10, 80, Color.RED);
		
		// create JPanel with buttons "Move left" and "Move right"
		JPanel btnPanel = new JPanel(new FlowLayout());
		
		JButton btnLeft = new JButton("Move left");
		btnPanel.add(btnLeft);
		btnLeft.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				moveLeft();
				requestFocus();
			}
		});
		
		JButton btnRight = new JButton("Move right");
		btnPanel.add(btnRight);
		btnRight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				moveRight();
				requestFocus();
			}
		});
		
		// creating canvas
		canvas = new DrawCanvas();
		canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		
		// add button panel and canvas to Frame
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(btnPanel, BorderLayout.SOUTH);
		cp.add(canvas, BorderLayout.CENTER);
		
		// add key listener to Frame to move sprite with arrow keys
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_LEFT : moveLeft(); break;
					case KeyEvent.VK_RIGHT : moveRight(); break;
				}
			}
		});
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Move a sprite");
		this.pack();
		this.setVisible(true);
		this.requestFocus();
	}
	
	class DrawCanvas extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(CANVAS_BG_COLOR);
			sprite.paint(g);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new MoveASprite();
				
			}
		});

	}
	
	/**
	 * move the sprite left 
	 */
	private void moveLeft() {
		// save x position of the sprite
		int savedX = sprite.x;
		// update x position of the sprite
		sprite.x -= 10;
		// repaint only the affected areas, not the entire JFrame, for efficiency
		canvas.repaint(savedX, sprite.y, sprite.width, sprite.height);
		canvas.repaint(sprite.x, sprite.y, sprite.width, sprite.height);
	}
	
	/**
	 * move the sprite right 
	 */
	private void moveRight() {
		// save x position of the sprite
		int savedX = sprite.x;
		// update x position of the sprite
		sprite.x += 10;
		// repaint only the affected areas, not the entire JFrame, for efficiency
		canvas.repaint(savedX, sprite.y, sprite.width, sprite.height);
		canvas.repaint(sprite.x, sprite.y, sprite.width, sprite.height);
		
	}

}
