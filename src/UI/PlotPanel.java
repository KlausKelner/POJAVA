package UI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.HeadlessException;

import javax.swing.JPanel;

public class PlotPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlotPanel() throws HeadlessException {
		JPanel panel = new JPanel();
		this.add(panel);
		panel.setLayout(new FlowLayout());
		
		class panelPlot extends JPanel{
		     /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
		        public void paintComponent(Graphics g) {
		            super.paintComponent(g);
		            
		            g.drawRect(0, 0,230, 230);
		        }
		};
		
		panelPlot panelAn = new panelPlot();
		panelAn.setPreferredSize(new Dimension(240,240));
		panel.add(panelAn);
}
}