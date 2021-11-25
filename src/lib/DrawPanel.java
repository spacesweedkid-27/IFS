package lib;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel implements Runnable {

	int index = 0; // Beispiel Variable
	
	/**
	 * 
	 */
	public boolean cleaning = false;
	private static final long serialVersionUID = 1L;
	int speedAnimation = 0; // adjust speed here
	private JLabel ctrlStatus;
	boolean running;
	private Thread thread;

	public boolean getRunning() {
		return running;
	}


	public DrawPanel() {
		start();
	}	
	
	public void init(JLabel l) {
		ctrlStatus = l;
	}

	public void clearScreen(Graphics2D g2d) {
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2d.setColor(Color.BLACK);
	}

	private void setStatus(String text) {
		if (ctrlStatus != null)
			ctrlStatus.setText("" + text);
	}
	
	
	
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		paint(g2d);
	}
	
	
	public void paint(Graphics2D g2d) {
		
		
	}

	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public void setIndex(int i) {
		this.index = i;
	}

	public void run() {
		while (true) {
			if (running) {
				repaint();
			}
			try {			
				Thread.sleep(speedAnimation);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}