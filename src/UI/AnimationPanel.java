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

	//private int panelWidth;
	
	private int velocityB = 2;
	private int velocityC = 2;
	private int velocityE = 2;
	 	
	private int xB=15;
	private int yC=15;
	private int yE=105;
	
	private boolean animateB=true;
	private boolean animateC=true;
	private boolean animateE=true;

	private static final long serialVersionUID = 1L;

	public AnimationPanel() throws HeadlessException {
		
		
		class PanelPlot extends JPanel{
			private int panelWidth=(int)(this.getPreferredSize().width);
			private static final long serialVersionUID = 1L;

			@Override
		        public void paintComponent(Graphics g) {
		            super.paintComponent(g);
		            
		            g.drawRect(0, 0,180, 180);
		            g.drawLine(15, 85, 100, 85); //cord to base
		            g.drawLine(100, 70, 100, 100);
		            g.drawLine(100, 80, 120, 65);
		            g.drawLine(100, 90, 120, 105);
		            g.drawLine(120, 65, 120, 15); // collector cord
		            g.drawLine(120, 105, 120, 155); //emitter cord
		            g.setColor(Color.blue);
		            int xBTemp=xB;
		            int yCTemp=yC;
		            int yETemp=yE;
		            while(animateB){
		            	g.fillOval(xBTemp, 82, 5, 5);
		            	xBTemp+=15;
		            	if(xBTemp>=100){
		            		xBTemp=(xB-15)%10+15;
		            		while(xBTemp<xB){
		            			g.fillOval(xBTemp, 82, 5, 5);
		            			xBTemp+=15;
		            		}
		            		animateB=false;
		            	}
		            }
		            while(animateC){
		            	g.fillOval(118, yCTemp, 5, 5);
		            	yCTemp+=15;
		            	if(yCTemp>=65){
		            		yCTemp=(yC-15)%10+15;
		            		while(yCTemp<yC){
		            			g.fillOval(118, yCTemp, 5, 5);
		            			yCTemp+=15;
		            		}
		            		animateC=false;
		            	}
		            }
		            while(animateE){
		            	g.fillOval(118, yETemp, 5, 5);
		            	yETemp+=15;
		            	if(yETemp>=155){
		            		yETemp=(yE-105)%10+105;
		            		while(yETemp<yE){
		            			g.fillOval(118, yETemp, 5, 5);
		            			yETemp+=15;
		            		}
		            		animateE=false;
		            	}
		            }
		        }
		};
		
		PanelPlot panelAn = new PanelPlot();
		panelAn.setPreferredSize(new Dimension(185,185));
		add(panelAn);
		
		 Timer timer = new Timer(true);
	     timer.scheduleAtFixedRate(new TimerTask() {
	            @Override
	            public void run() {
	                SwingUtilities.invokeLater(new Runnable() {  //InvokeLater
	                    @Override
	                    public void run() {
	                    	xB+=velocityB;
	                    	animateB=true;
	                    	if(xB>=100)xB=15;
	                    	
	                    	yC+=velocityC;
	                    	animateC=true;
	                    	if(yC>=65)yC=15;
	                    	
	                    	yE+=velocityE;
	                    	animateE=true;
	                    	if(yE>=155)yE=105;
	                    	
	                       panelAn.repaint();
	                    }
	                });
	            }
	        }, 10, 50 );
}
}