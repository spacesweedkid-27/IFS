package lib;

import bin.MainGui;
import lib.functionsets.Default;
import lib.functionsets.Functionset;

import java.awt.*;

public class Core extends Thread {

	public Core(Rectangle bounds){
		this.bounds = bounds;
		this.image = new ColorArray(bounds,translate);
	}

	int[] translate = {250,100};
	double startingPoints[] = {0,0};
	double currentPoints[] = startingPoints;
	static double scaling = 100;
	Rectangle bounds;

	Default default_ = new Default();
	ColorArray image;



	@Override
	public void run() {
		for (;;) {

			image.paint(currentPoints[0], currentPoints[1], Color.GREEN.darker().darker().darker());
			currentPoints = default_.calculate(currentPoints, null);

		}
	}

	public void paint(Graphics2D g) {
		//g.setColor(default_.colors[default_.wurfel]);


		image.renderImage(g);
	}


}
