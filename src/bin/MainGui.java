package bin;

import lib.core.Core;
import lib.DrawPanel;
import lib.core.DumpThePic;
import lib.informatics4kids.Picture;
import lib.informatics4kids.PictureViewer;
import lib.masking.Faltung;
import lib.masking.examples.Median;
import lib.masking.examples.Sobel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class MainGui extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton ctrlStart, ctrlStop, ctrlSave;
	private DrawPanel panel;
	private JLabel ctrlStatus;
	private JLabel steps;
	private JButton ctrlRestart;
	
	private Rectangle boundsBerechPanel = new Rectangle(29,40,1000,1000);


	private Core core;

	public MainGui() {

		Rectangle getExtBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().getBounds();

		setBounds(0,0,getExtBounds.width/2,(int)(getExtBounds.height/1.4));
		
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		// setUndecorated(true);
		

		setResizable(true);
		getContentPane().setLayout(null);
		
		
		

		core = new Core(boundsBerechPanel,Core.RenderMode.BeautifulButSlow);


		panel = new DrawPanel() {
			@Override
			public void paint(Graphics2D g2d) {
				core.paint(g2d);
				steps.setText("steps: "+ core.getSteps());
			}
		};
		
		panel.setBounds(boundsBerechPanel);
		panel.setRunning(false);
		panel.setLayout(null);
		getContentPane().add(panel);


				ctrlStart = new JButton("start");
				ctrlStart.setBounds(12, 12, 69, 25);
				ctrlStart.addActionListener(this);
				ctrlStop = new JButton("stop");
				ctrlStop.setBounds(88, 12, 66, 25);
				ctrlStop.addActionListener(this);
				ctrlSave = new JButton("dump");
				ctrlSave.setBounds(163, 12, 80, 25);
				ctrlSave.addActionListener(this);


				JPanel buttPanel = new JPanel();
				buttPanel.setBounds(0, 0, 552, 111);
				buttPanel.setLayout(null);
				buttPanel.add(ctrlStart);

				ctrlRestart = new JButton("restart");
				ctrlRestart.setBounds(buttPanel.getWidth()-80, 12, 80, 25);
				ctrlRestart.addActionListener(this);
				
				steps = new JLabel("steps: "+ core.getSteps());
				steps.setBounds(250, 20, 300, 12);
				buttPanel.add(steps);

				buttPanel.add(ctrlRestart);
				buttPanel.add(ctrlStop);
				buttPanel.add(ctrlSave);
				getContentPane().add(buttPanel);
				
				panel.init(ctrlStatus);

		setTitle("Integrierte Funktionssysteme: "+ core.getPresetName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}



	public static void main(String[] args) {
		new MainGui();
	}

	public void actionPerformed(ActionEvent e) {
		
		
		// Button Start
		if (e.getSource() == ctrlStart) {
			if (!core.DidStart()){
				core.start();
			}

			core.toggleRunning(true);
			panel.setRunning(true);
		}		
		
		// Button Stop
		if (e.getSource() == ctrlStop) {
			core.toggleRunning(false);			
			panel.repaint();
			System.exit(0);
			
		}
		// Button Dump
		if (e.getSource() == ctrlSave) {
			core.toggleRunning(false);
			panel.setIndex(0);
			panel.setRunning(false);

			setVisible(false);

			DumpThePic dumpThePic = new DumpThePic();

			dumpThePic.dump(panel);

			dumpThePic.setFaltung(new Sobel());
			dumpThePic.transform(Sobel.SobelType.G);
			dumpThePic.display();
		}

		if (e.getSource() == ctrlRestart){
			core = new Core(boundsBerechPanel, Core.RenderMode.BeautifulButSlow);

		}
	}
}

