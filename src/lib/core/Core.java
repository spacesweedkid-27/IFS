package lib.core;

import bin.MainGui;
import lib.ColorArray;
import lib.functionsets.Default;
import lib.functionsets.Functionset;

import java.awt.*;

public class Core extends Thread {

	public Core(Rectangle bounds){
		this.bounds = bounds;
		this.image = new ColorArray(bounds,translate);
	}

	public static Color randmcolor = new Color((int)(255*Math.random()),(int)(255*Math.random()),(int)(255*Math.random()));


	int[] translate = {280,0};
	double startingPoints[] = {0,0};
	double currentPoints[] = startingPoints;
	public static double scaling = 130;
	Rectangle bounds;
	Default default_ = new Default();
	ColorArray image;
	boolean shouldRun = false;
	boolean didStart = false;
	double speed = 1;


	int steps = 0;

	private Color functionColor = default_.colors[default_.wurfel];

	public int getSteps() {
		return steps;
	}

	public boolean DidStart() {
		return didStart;
	}

	public void toggleRunning(boolean bool){
		shouldRun = bool;
	}

	@Override
	public void run() {
		didStart = true;
		while (true){
		while (!shouldRun) {

		}
		while (shouldRun) {
			steps++;
			functionColor = default_.colors[default_.wurfel];
			image.paint(currentPoints[0], currentPoints[1], functionColor);
			currentPoints = default_.calculate(currentPoints, null);

		}
	}}

	public void paint(Graphics2D g) {
		image.renderImage(g);
	}


}
