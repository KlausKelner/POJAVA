package UI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AnimationPanel extends JPanel {

	public AnimationPanel() throws HeadlessException {
		JPanel panel = new JPanel();
		this.add(panel);
		panel.setLayout(new FlowLayout());
		
		class PanelAnimacji extends JPanel{
		     @Override
		        public void paintComponent(Graphics g) {
		            super.paintComponent(g);
		            
		            g.drawRect(20, 20, 400, 400);
		        }
		};
		
		PanelAnimacji panelAn = new PanelAnimacji();
		panelAn.setPreferredSize(new Dimension(640,460));
		panel.add(panelAn);
		JPanel sliders = new JPanel();
		panel.add(sliders);
		
	}

}
