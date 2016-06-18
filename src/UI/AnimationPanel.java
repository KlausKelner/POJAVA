

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AnimationPanel extends JPanel {

	private int squareLength=180;
	private int margin = 30;
	private int baseCordX1 = margin+10;
	private int baseCordY1 = 20+(int)Math.floor(0.5*squareLength);
	private int baseCordX2 = margin+(int)Math.floor(0.4*squareLength);
	private int baseCordY2 = 20+(int)Math.floor(0.5*squareLength);
	private int stopperY1 = 20+(int) Math.floor(0.4*squareLength);
	private int stopperY2 = 20+(int) Math.floor(0.6*squareLength);
	private int base2EmitterX2=margin+(int)Math.floor(0.6*squareLength);;
	private int base2EmitterY1=20+(int) Math.floor(0.35*squareLength);
	private int base2EmitterY2=20+(int) Math.floor(0.45*squareLength);
	private int base2CollectorX2=margin+(int)Math.floor(0.6*squareLength);;
	private int base2CollectorY1=20+(int) Math.floor(0.65*squareLength);
	private int base2CollectorY2=20+(int) Math.floor(0.55*squareLength);
	private int collectorCordY1 = 20+(int) Math.floor(0.1*squareLength);
	private int collectorCordY2 = base2EmitterY1;
	private int emitterCordY2 = 20+(int) Math.floor(0.9*squareLength);
	private int emitterCordY1 = base2CollectorY1;
	
	private int velocityB = 1;
	private int velocityC = 1;
	private int velocityE = 1;
	 	
	private int xB=baseCordX1;
	private int xB2=baseCordX1+(int)(0.25*(baseCordX2-baseCordX1));
	private int xB3=baseCordX1+(int)(0.5*(baseCordX2-baseCordX1));
	private int xB4=baseCordX1+(int)(0.75*(baseCordX2-baseCordX1));
	
	private int yC=collectorCordY1;
	private int yC2=collectorCordY1+(int)(0.25*(collectorCordY2-collectorCordY1));
	private int yC3=collectorCordY1+(int)(0.5*(collectorCordY2-collectorCordY1));
	private int yC4=collectorCordY1+(int)(0.75*(collectorCordY2-collectorCordY1));

	private int yE=emitterCordY1;
	private int yE2=emitterCordY1+(int)(0.25*(emitterCordY2-emitterCordY1));
	private int yE3=emitterCordY1+(int)(0.5*(emitterCordY2-emitterCordY1));
	private int yE4=emitterCordY1+(int)(0.75*(emitterCordY2-emitterCordY1));
	
	private boolean animateB=true;
	private boolean animateC=true;
	private boolean animateE=true;

	private static final long serialVersionUID = 1L;


			//private static final long serialVersionUID = 1L;

			@Override
		        public void paintComponent(Graphics g) {
		            super.paintComponent(g);
		            
		            g.drawRect(margin,20,squareLength, squareLength);
		            g.drawLine(baseCordX1, baseCordY1, baseCordX2, baseCordY2); //cord to base
		            g.drawLine(baseCordX2, stopperY1, baseCordX2, stopperY2);
		            g.drawLine(baseCordX2, base2CollectorY2, base2CollectorX2, base2CollectorY1);
		            g.drawLine(baseCordX2, base2EmitterY2, base2EmitterX2, base2EmitterY1);
		            g.drawLine(base2CollectorX2, collectorCordY1, base2CollectorX2, collectorCordY2); // collector cord
		            g.drawLine(base2EmitterX2, emitterCordY1, base2EmitterX2, emitterCordY2); //emitter cord
		            g.setColor(Color.blue);
		            int xBTemp=xB;
		            int xBTemp2=xB2;
		            int xBTemp3=xB3;
		            int xBTemp4=xB4;
		            int yCTemp=yC;
		            int yCTemp2=yC2;
		            int yCTemp3=yC3;
		            int yCTemp4=yC4;
		            int yETemp=yE;
		            int yETemp2=yE2;
		            int yETemp3=yE3;
		            int yETemp4=yE4;
		            while(animateB){
		            	g.fillOval(xBTemp, baseCordY1-3, 5, 5);
		            	g.fillOval(xBTemp2, baseCordY1-3, 5, 5);
		            	g.fillOval(xBTemp3, baseCordY1-3, 5, 5);
		            	g.fillOval(xBTemp4, baseCordY1-3, 5, 5);
		            	//if(xBTemp>=baseCordX2){
		            		//xBTemp=(xB-15)%10+baseCordX1;
		            		animateB=false;
		            	//}
		            }
		            while(animateC){
		            	g.fillOval(base2CollectorX2-3, yCTemp, 5, 5);
		            	g.fillOval(base2CollectorX2-3, yCTemp2, 5, 5);
		            	g.fillOval(base2CollectorX2-3, yCTemp3, 5, 5);
		            	g.fillOval(base2CollectorX2-3, yCTemp4, 5, 5);
		            		animateC=false;
		            	}
		            
		            while(animateE){
		            	g.fillOval(base2CollectorX2-3, yETemp, 5, 5);
		            	g.fillOval(base2CollectorX2-3, yETemp2, 5, 5);
		            	g.fillOval(base2CollectorX2-3, yETemp3, 5, 5);
		            	g.fillOval(base2CollectorX2-3, yETemp4, 5, 5);
		            		animateE=false;
		            	}
		            }
		public void setVb(int n){
			velocityB=n;
		}      
		public void setVc(int n){
			velocityC=n;
		}   
		public void setVe(int n){
			velocityE=n;
		}   
		public AnimationPanel() throws HeadlessException {
		
		 Timer timer = new Timer(true);
	     timer.scheduleAtFixedRate(new TimerTask() {
	            @Override
	            public void run() {
	                SwingUtilities.invokeLater(new Runnable() {  //InvokeLater
	                    @Override
	                    public void run() {
	                    	margin = (int)Math.floor((0.1*getWidth()));
	                    	squareLength = (int)Math.floor((0.8*getWidth()));
	                    	baseCordX1 = (int)Math.floor((0.15*getWidth()));
	                    	baseCordY1 = 20+(int)Math.floor(0.5*squareLength);
	                    	baseCordX2 = margin+(int)Math.floor(0.4*squareLength);
	                    	baseCordY2 = 20+(int)Math.floor(0.5*squareLength);
	                    	stopperY1 = 20+(int) Math.floor(0.4*squareLength);
	                    	stopperY2 = 20+(int) Math.floor(0.6*squareLength);
	                    	base2EmitterX2=margin+(int)Math.floor(0.6*squareLength);;
	                    	base2EmitterY1=20+(int) Math.floor(0.35*squareLength);
	                    	base2EmitterY2=20+(int) Math.floor(0.45*squareLength);
	                    	base2CollectorX2=margin+(int)Math.floor(0.6*squareLength);;
	                    	base2CollectorY1=20+(int) Math.floor(0.65*squareLength);
	                    	base2CollectorY2=20+(int) Math.floor(0.55*squareLength);
	                    	collectorCordY1 = 20+(int) Math.floor(0.1*squareLength);
	                    	collectorCordY2 = base2EmitterY1;
	                    	emitterCordY2 = 20+(int) Math.floor(0.9*squareLength);
	                    	emitterCordY1 = base2CollectorY1;
	                    	
	                    	xB4+=velocityB;
	                    	animateB=true;
	                    	if(xB4>=baseCordX2-1)xB4=baseCordX1;
	                    	
	                    	xB3+=velocityB;
	                    	animateB=true;
	                    	if(xB3>=baseCordX2-1)xB3=baseCordX1;
	                    	
	                    	xB2+=velocityB;
	                    	animateB=true;
	                    	if(xB2>=baseCordX2-1)xB2=baseCordX1;
	                    	
	                    	xB+=velocityB;
	                    	animateB=true;
	                    	if(xB>=baseCordX2-1)xB=baseCordX1;
	                    	
	                    	yC4+=velocityC;
	                    	animateC=true;
	                    	if(yC4>=collectorCordY2-1)yC4=collectorCordY1;
	                    	
	                    	yC3+=velocityC;
	                    	animateC=true;
	                    	if(yC3>=collectorCordY2-1)yC3=collectorCordY1;
	                    	
	                    	yC2+=velocityC;
	                    	animateC=true;
	                    	if(yC2>=collectorCordY2-1)yC2=collectorCordY1;
	                    	
	                    	yC+=velocityC;
	                    	animateC=true;
	                    	if(yC>=collectorCordY2-1)yC=collectorCordY1;
	                    	
	                    	
	                    	yE4+=velocityE;
	                    	animateE=true;
	                    	if(yE4>=emitterCordY2-1)yE4=emitterCordY1;
	                    	
	                    	yE3+=velocityE;
	                    	animateE=true;
	                    	if(yE3>=emitterCordY2-1)yE3=emitterCordY1;

	                    	yE2+=velocityE;
	                    	animateE=true;
	                    	if(yE2>=emitterCordY2-1)yE2=emitterCordY1;

	                    	yE+=velocityE;
	                    	animateE=true;
	                    	if(yE>=emitterCordY2-1)yE=emitterCordY1;
	                       repaint();
	                    }
	                });
	            }
	        }, 10, 50 );
}
}