package customgraphics2;

import java.awt.Color;
import java.awt.Graphics;

public class Sprite {
	int x, y, width, height;
	Color color = Color.RED;
	
	public Sprite(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

}
