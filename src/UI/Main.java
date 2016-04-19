package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame {

	public Main() throws HeadlessException {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		this.add(mainPanel);
		JPanel panelNorth = new JPanel();
		JPanel panelSouth = new JPanel();
		mainPanel.add(panelNorth,BorderLayout.NORTH);
		mainPanel.add(panelSouth,BorderLayout.SOUTH);
		
		panelNorth.setLayout(new FlowLayout());

		AnimationPanel animation = new AnimationPanel();
		panelNorth.add(animation);
		
		NewTransistorPanel transistor = new NewTransistorPanel();
		panelNorth.add(transistor);
		
		panelSouth.setLayout(new FlowLayout());
		JPanel download = new JPanel();
		download.setPreferredSize(new Dimension(200, 260));
		
		JButton downloadButton = new JButton("Download data");
		download.add(downloadButton);
		downloadButton.setLocation(40, 40);
		
		panelSouth.add(download);
		
		ParametersLook temp = new ParametersLook();
		temp.setPreferredSize(new Dimension(750,250));
		JLabel tempParameters = new JLabel("Calculated parameters go here");
		temp.add(tempParameters);
		
		panelSouth.add(temp);
		
	}


	public static void main(String[] args) {
		Main okno = new Main();
		okno.setSize(1024,768);
		okno.setVisible(true);

	}

}
