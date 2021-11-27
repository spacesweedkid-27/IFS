package lib;

import bin.MainGui;
import lib.functionsets.Default;
import lib.functionsets.Functionset;

import java.awt.*;

public class Core extends Thread {

	public Core(Rectangle bounds){
		this.bounds = bounds;
		this.image = new ColorArray(bounds);
		start();
	}

	double startingPoints[] = {0,0};
	double currentPoints[] = startingPoints;
	static double scaling = 70;
	Rectangle bounds;

	Default default_ = new Default();
	ColorArray image;



	@Override
	public void run() {
		image.paint((int)currentPoints[0],(int)currentPoints[1],Color.BLACK);
		currentPoints = default_.calculate(currentPoints,null);
	}

	public void paint(Graphics2D g) {
		//g.setColor(default_.colors[default_.wurfel]);
		int[] translate = {250,0};

		image.renderImage(g,translate);
	}


}
