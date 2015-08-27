package customgraphics3;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class PolyLine {
	private List<Integer> xList;
	private List<Integer> yList;
	
	public PolyLine() {
		xList = new ArrayList<>();
		yList = new ArrayList<>();
	}
	
	public void addPoint(int x, int y) {
		xList.add(x);
		yList.add(y);
	}
	
	public void draw(Graphics g) {
		for (int i = 0; i < xList.size() - 1; i++) {
			g.drawLine(xList.get(i), yList.get(i), xList.get(i + 1), yList.get(i + 1));
		}
	}

}
