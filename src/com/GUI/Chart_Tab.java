
package com.GUI;

import com.nsgaii.Individu;
import com.nsgaii.Population;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/*
générer un chart  a partire  d'un  liste des  collections des  points créer a partir  les  popualtions
*/
public class Chart_Tab {
    /*
    Les collection des  point  pour  générer les  graphe  
    */
  public XYSeriesCollection prix_taux ; 
  public XYSeriesCollection prix_duree ;  
  public XYSeriesCollection taux_duree ; 

    public Chart_Tab(XYSeriesCollection prix_taux, XYSeriesCollection prix_duree, XYSeriesCollection taux_duree) {
        this.prix_taux = prix_taux;
        this.prix_duree = prix_duree;
        this.taux_duree = taux_duree;
    }

    
     public  ChartPanel chart_prix_taux(){
      JFreeChart jfreechart = ChartFactory.createScatterPlot(
        "", "Prix", "Taux", prix_taux ,PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyPlot = (XYPlot) jfreechart.getPlot();
        xyPlot.setDomainCrosshairVisible(true);
        xyPlot.setRangeCrosshairVisible(true);
        XYItemRenderer renderer = xyPlot.getRenderer();
        renderer.setSeriesPaint(0, Color.yellow);
        renderer.setSeriesPaint(1, Color.red);
        ChartPanel chartPanel =  new ChartPanel(jfreechart) ;
        return chartPanel ; 
        
    }
        /*
     afficher  les individus  dans  un graphe ( x ,z  ) 
    */
     public  ChartPanel chart_prix_duree( ){
      JFreeChart jfreechart = ChartFactory.createScatterPlot(
        "", "Prix", "Duree", prix_duree,PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyPlot = (XYPlot) jfreechart.getPlot();
        xyPlot.setDomainCrosshairVisible(true);
        xyPlot.setRangeCrosshairVisible(true);
        XYItemRenderer renderer = xyPlot.getRenderer();
        renderer.setSeriesPaint(0, Color.BLACK);
         renderer.setSeriesPaint(1, Color.red);
        ChartPanel chartPanel =  new ChartPanel(jfreechart) ;
        return chartPanel ; 
        
    }
     /*
     afficher  les individus  dans  un graphe ( z ,y  ) 
    */
      public  ChartPanel chart_taux_duree( ){
      JFreeChart jfreechart = ChartFactory.createScatterPlot(
        "", "Taux", "Duree", taux_duree,PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyPlot = (XYPlot) jfreechart.getPlot();
        xyPlot.setDomainCrosshairVisible(true);
        xyPlot.setRangeCrosshairVisible(true);
        XYItemRenderer renderer = xyPlot.getRenderer();
        renderer.setSeriesPaint(0, Color.blue);
         renderer.setSeriesPaint(1, Color.red);
        ChartPanel chartPanel =  new ChartPanel(jfreechart) ;
        return chartPanel ; 
        
    }
    
    
    
    
}
