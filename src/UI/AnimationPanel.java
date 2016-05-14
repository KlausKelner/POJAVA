package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AnimationPanel extends JPanel {

	private int velocityB = 2;
	private int velocityC = 2;
	private int velocityE = 2;
	 	
	private int xB=15;
	private int yC=15;
	private int yE=105;
	    
	private static final long serialVersionUID = 1L;

	public AnimationPanel() throws HeadlessException {
	
		    
		JPanel panel = new JPanel();
		this.add(panel);
		panel.setLayout(new FlowLayout());
		
		class PanelPlot extends JPanel{
		 
			private static final long serialVersionUID = 1L;

			@Override
		        public void paintComponent(Graphics g) {
		            super.paintComponent(g);
		            
		            g.drawRect(0, 0,180, 170);
		            g.drawLine(15, 85, 100, 85); //cord to base
		            g.drawLine(100, 70, 100, 100);
		            g.drawLine(100, 80, 120, 65);
		            g.drawLine(100, 90, 120, 105);
		            g.drawLine(120, 65, 120, 15);
		            g.drawLine(120, 105, 120, 155);
		            for(int ii = 0; ii<8; ii++){
		            	g.setColor(Color.blue);
		                g.fillOval(xB+ii*10, 82, 5, 5);
		            }
		            for(int ii = 0; ii<5; ii++){
		            	g.setColor(Color.blue);
		                g.fillOval(118, yC+ii*10, 5, 5);
		            }
		            for(int ii = 0; ii<5; ii++){
		            	g.setColor(Color.blue);
		                g.fillOval(118, yE+ii*10, 5, 5);
		            }
		        }
		};
		
		PanelPlot panelAn = new PanelPlot();
		panelAn.setPreferredSize(new Dimension(185,185));
		panel.add(panelAn);
		
		 Timer timer = new Timer(true);
	     timer.scheduleAtFixedRate(new TimerTask() {
	            @Override
	            public void run() {
	                SwingUtilities.invokeLater(new Runnable() {  //InvokeLater
	                    @Override
	                    public void run() {
	                    	xB+=velocityB;
	                    	yC+=velocityC;
	                    	yE+=velocityE;
	                    	if(xB+8*10>=100)xB=0;
	                       repaint();
	                    }
	                });
	            }
	        }, 10, 20 );
}
}