package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class ChartPanelUceIb {
	
    private static String title = "POJAVA Projekt Tranzystor Uce / Ib";
    private ChartPanel chartPanel = createChart();
    private static Transistor t = new Transistor(/*1,1,1,1,*/1,0.0000000000000006734,0.75,140,4);
    public ChartPanelUceIb(String title,Transistor t) {
        JFrame f = new JFrame(title);
        f.setTitle(title);
       
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLayout(new BorderLayout(0, 5));
        f.add(chartPanel, BorderLayout.CENTER);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setHorizontalAxisTrace(true);
        chartPanel.setVerticalAxisTrace(true);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        f.add(panel, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }



    private ChartPanel createChart() {
    	
    	
        XYDataset roiData = createDataset(t);
        JFreeChart chart = ChartFactory.createXYLineChart(title,
        		"U_CE", "I_C", roiData); 
        
        XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE);
        
        XYLineAndShapeRenderer renderer =
            (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setBaseShapesVisible(true);
        
        NumberFormat ints = NumberFormat.getIntegerInstance();
        ints.setMaximumFractionDigits(1);
        
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setNumberFormatOverride(ints);
        
        return new ChartPanel(chart);
    }

    private XYDataset createDataset(Transistor t) {
        XYSeriesCollection tsc = new XYSeriesCollection();
        tsc.addSeries(createSeries2("U_be = 50V",t));
        
        return tsc;
    }


    private XYSeries createSeries2(String name,Transistor t) {
        XYSeries series = new XYSeries(name);
        
        	int s = 100;
     		for(int ii=0; ii<=s; ii++)
     		{
     			t.Vb=500;
     			t.incVc(0.05);
     			t.Ve = 0;
     			double tmpIc = t.getIc();
     			series.add(t.Vce,tmpIc);
     			//System.out.print(t.Vce+"\n");
     		}
            
        
        return series;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ChartPanelUceIb cpd = new ChartPanelUceIb(title,t);
            }
        });
    }
}