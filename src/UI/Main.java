package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {

	public Main() throws HeadlessException {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		this.add(mainPanel);
		JPanel panelNorth = new JPanel();
		JPanel panelSouth = new JPanel();
		int xx = (int) mainPanel.getWidth();
		int yy = (int) mainPanel.getHeight();
		mainPanel.add(panelNorth,BorderLayout.NORTH);
		mainPanel.add(panelSouth,BorderLayout.SOUTH);
		panelNorth.setBackground(Color.black);
		panelSouth.setBackground(Color.yellow);
		
		AnimationPanel animation = new AnimationPanel();
		panelNorth.setLayout(new FlowLayout());
		panelNorth.add(animation);
		
	}


	public static void main(String[] args) {
		Main okno = new Main();
		okno.setSize(1024,768);
		okno.setVisible(true);

	}

}
