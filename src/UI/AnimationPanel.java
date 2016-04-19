package UI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class AnimationPanel extends JPanel {

	public AnimationPanel() throws HeadlessException {
		JPanel panel = new JPanel();
		this.add(panel);
		panel.setLayout(new FlowLayout());
		
		class PanelAnimacji extends JPanel{
		     @Override
		        public void paintComponent(Graphics g) {
		            super.paintComponent(g);
		            
		            g.drawRect(20, 20, 380, 400);
		        }
		};
		
		PanelAnimacji panelAn = new PanelAnimacji();
		panelAn.setPreferredSize(new Dimension(420,440));
		panel.add(panelAn);
		JPanel sliders = new JPanel();
		panel.add(sliders);
		JSlider uBE = new JSlider(JSlider.HORIZONTAL,0,30,0);
		JSlider uCE = new JSlider(JSlider.HORIZONTAL,0,30,0);
		sliders.setPreferredSize(new Dimension(200,440));
		JLabel ube = new JLabel("U_BE");
		JLabel uce = new JLabel("U_CE");
		sliders.setLayout(new FlowLayout());
		sliders.add(ube);
		sliders.add(uBE);
		sliders.add(uce);
		sliders.add(uCE);
	}

}
