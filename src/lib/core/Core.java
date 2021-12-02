package lib.core;

import bin.MainGui;
import lib.ColorArray;
import lib.functionsets.*;

import java.awt.*;



public class Core extends Thread {
	
	public enum RenderMode{
		FastButUgly, Medium, BeautifulButSlow 
	}
	
	
	public Core(Rectangle bounds, RenderMode rendermode){
		this.bounds = bounds;
		this.image = new ColorArray(bounds,translate);
		
		switch (rendermode) {

			case Medium: {
			image.setFac(0.9);
			return;
		}
		
		case BeautifulButSlow: {
			image.setFac(0.99999);
			return;
		}
		
		case FastButUgly:{
			image.setFac(0);
			return;
		}
		}
		
	}

	public static Color getRandmcolor() {
		return new Color((int)(255*Math.random()),(int)(255*Math.random()),(int)(255*Math.random()));
	}

	public String getPresetName(){
		return default_.getClass().getName();
	}

	public static double scaling = 300;
	int[] translate = {(int)(1400*(40/scaling)),(int)(1400*(40/scaling))};
	double startingPoints[] = {0,0};
	double currentPoints[] = startingPoints;
	
	Rectangle bounds;
	ThirdPreset default_ = new ThirdPreset();
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
			// Normal function
			functionColor = default_.colors[default_.wurfel];
			
			// Black override
			// functionColor = Color.BLACK;
			image.paint(currentPoints[0], currentPoints[1], functionColor);
			currentPoints = default_.calculate(currentPoints, null);

		}
	}}

	public void paint(Graphics2D g) {
		image.renderImage(g);
	}


}
