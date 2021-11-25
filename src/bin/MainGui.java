package bin;

import lib.Core;
import lib.DrawPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGui extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton ctrlStart, ctrlStop, ctrlReset;
	private DrawPanel panel;
	private JLabel ctrlStatus;
	private JTextField ctrlInput;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;

	public MainGui() {
		Core core = new Core();
		
		
		setTitle("Friedrich-Schiller-Gymnasium");
		setResizable(true);
		getContentPane().setLayout(null);
		
		panel = new DrawPanel() {
			@Override
			public void paint(Graphics2D g2d) {
				core.paint(g2d);
			}
		};
		
		panel.setBounds(29, 0, 1000, 1000);
		panel.setRunning(false);
		panel.setLayout(null);
		getContentPane().add(panel);
		
				ctrlStart = new JButton("start");
				ctrlStart.setBounds(12, 12, 69, 25);
				ctrlStart.addActionListener(this);
				ctrlStop = new JButton("stop");
				ctrlStop.setBounds(93, 12, 66, 25);
				ctrlStop.addActionListener(this);
				ctrlReset = new JButton("reset");
				ctrlReset.setBounds(163, 12, 72, 25);
				ctrlReset.addActionListener(this);
				JPanel buttPanel = new JPanel();
				buttPanel.setBounds(0, 0, 552, 111);
				buttPanel.setLayout(null);
				buttPanel.add(ctrlStart);
				
				label = new JLabel("test");
				label.setBounds(69, 53, 0, 0);
				buttPanel.add(label);
				
				label_1 = new JLabel("test2");
				label_1.setBounds(69, 53, 0, 0);
				buttPanel.add(label_1);
				
				label_2 = new JLabel("");
				label_2.setBounds(69, 53, 0, 0);
				buttPanel.add(label_2);
				
				label_3 = new JLabel("");
				label_3.setBounds(69, 53, 0, 0);
				buttPanel.add(label_3);
				
				label_4 = new JLabel("");
				label_4.setBounds(69, 53, 0, 0);
				buttPanel.add(label_4);
				buttPanel.add(ctrlStop);
				buttPanel.add(ctrlReset);
				getContentPane().add(buttPanel);
				
				
				ctrlInput = new JTextField();
				ctrlInput.setBounds(393, 11, 147, 27);
				buttPanel.add(ctrlInput);
				ctrlInput.setColumns(10);
			
				
				panel.init(ctrlStatus);

		this.setSize(560, 516);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new MainGui();
	}

	public void actionPerformed(ActionEvent e) {
		
		
		// Button Start
		if (e.getSource() == ctrlStart) {
			panel.setRunning(true);
		}		
		
		// Button Stop
		if (e.getSource() == ctrlStop) {
			
			panel.setRunning(false);			
			panel.repaint();
			
		}
		// Button Reset
		if (e.getSource() == ctrlReset) {
			
			panel.setIndex(0);
			panel.setRunning(false);
			
			
		}
	}
}

