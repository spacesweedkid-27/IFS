package lib;

import lib.functionsets.Default;
import lib.functionsets.Functionset;

import java.awt.*;

public class Core {
	
	double startingPoints[] = {0,0};
	double currentPoints[] = startingPoints;
	double scaling = 100;
	Functionset default_ = new Default();
	
	
	private void drawPoint(double[] points, Graphics2D g) {
		g.drawRect( (int) (points[0]*scaling), (int) (points[1]*scaling), 1, 1);
	}
	
	public void paint(Graphics2D g) {

		g.translate(500/2, 0);
		drawPoint(currentPoints, g);
		currentPoints = default_.calculate(currentPoints);
	}

}
