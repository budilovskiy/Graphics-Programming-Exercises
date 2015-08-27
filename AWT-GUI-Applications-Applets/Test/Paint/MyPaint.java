package customgraphics3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MyPaint extends JFrame {
	
	public static final int CANVAS_WIDTH = 400;
	public static final int CANVAS_HEIGHT = 100;
	public static final Color CANVAS_BG_COLOR = Color.WHITE;
	public static final Color LINE_COLOR = Color.BLACK;
	
	private List<PolyLine> lines;
	private PolyLine currentLine;
	
	
	public MyPaint() {
		lines = new ArrayList<PolyLine>();
		
		DrawCanvas canvas = new DrawCanvas();
		canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		canvas.setBackground(CANVAS_BG_COLOR);
		
		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				currentLine = new PolyLine();
				lines.add(currentLine);
				currentLine.addPoint(e.getX(), e.getY());
			}
		});
		
		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				currentLine.addPoint(e.getX(), e.getY());
				repaint();
			}
		});
		
		setContentPane(canvas);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Paint");
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new MyPaint();
			}
		});

	}
	
	class DrawCanvas extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(LINE_COLOR);
			for (PolyLine line : lines) {
				line.draw(g);
			}
		}
		
	}

}
