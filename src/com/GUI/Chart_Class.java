
package com.GUI;

import com.nsgaii.Individu;
import com.nsgaii.Population;
import com.nsgaii.Solution;
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
  
public class Chart_Class {
ArrayList<Individu> solution  ; 
    private static XYDataset createSampleData(List<Individu> list, PlotOrientation VERTICAL, boolean b, boolean b0, boolean b1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Chart_Class() {
    }
    public Chart_Class(ArrayList<Individu> solution ) {
        this.solution = solution  ; 
    }
    
    /*
     afficher  les individus  dans  un graphe ( x , y  ) 
     nous utilisons la bibiothéqur  Jfreechart 
     les donnée  son récupéré  par  la  fonction  createSampleData() 
     */
    public final static ChartPanel chart_x_y(Population p ){
      JFreeChart jfreechart = ChartFactory.createScatterPlot(
        ""/*titre*/, "Prix"/* nom de  1 axe*/, "Taux"/* 2eme axe*/, createSampleData_P_T(p.liste) /*les  point de graph */ ,PlotOrientation.VERTICAL, true, true, false /*configuration d'affichage */);
        XYPlot xyPlot = (XYPlot) jfreechart.getPlot();
        xyPlot.setDomainCrosshairVisible(true);
        xyPlot.setRangeCrosshairVisible(true);
        XYItemRenderer renderer = xyPlot.getRenderer(); 
        renderer.setSeriesPaint(0, Color.YELLOW);/*coleur  de  1 serie*/ 
         renderer.setSeriesPaint(1, Color.red);/*coleur  de  2serie*/ 
        ChartPanel chartPanel =  new ChartPanel(jfreechart) ; /*enregistrer  dans une  Jpanel*/
        return chartPanel ; 
        
    }
        /*
     afficher  les individus  dans  un graphe ( x ,z  ) 
    */
     public final static ChartPanel chart_x_z(Population p ){
      JFreeChart jfreechart = ChartFactory.createScatterPlot(
        "", "Prix", "Duree", createSampleData_P_D(p.liste),PlotOrientation.VERTICAL, true, true, false);
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
      public final static ChartPanel chart_y_z(Population p ){
      JFreeChart jfreechart = ChartFactory.createScatterPlot(
        "", "Taux", "Duree", createSampleData_T_D(p.liste),PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyPlot = (XYPlot) jfreechart.getPlot();
        xyPlot.setDomainCrosshairVisible(true);
        xyPlot.setRangeCrosshairVisible(true);
        XYItemRenderer renderer = xyPlot.getRenderer();
        renderer.setSeriesPaint(0, Color.blue);
         renderer.setSeriesPaint(1, Color.red);
        ChartPanel chartPanel =  new ChartPanel(jfreechart) ;
        return chartPanel ; 
        
    }
    /*
    XYDATASET :  pour  recupuré  les  données de chaque géération  
    les  donnée sont  sauvgardé  dans  une structure  appelée XYDataset 
    */
    private static XYDataset createSampleData_P_T(List <Individu> liste) {
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
        /*créer deux  serier  dans  une  collection */
        XYSeries series = new XYSeries("individu"); // serie de  tout la  population 
        XYSeries series_solution = new XYSeries("Solution");// serie des solution 
        for (Individu individu  : liste) {
             double x = individu.somme_sdp();
             double y = individu.somme_sft() ; 
            series.add(x, y);
        }
        for (Individu individu  : Solution.liste) {
             double x = individu.somme_sdp();
             double y = individu.somme_sft() ; 
            series_solution.add(x, y);
        }
        /*ergister  les deux series  dans  la collection*/
        xySeriesCollection.addSeries(series);
        xySeriesCollection.addSeries(series_solution);
        return xySeriesCollection;
    }
    private static XYDataset createSampleData_P_D(List <Individu> liste) {
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
        XYSeries series = new XYSeries("individu");
         XYSeries series_solution = new XYSeries("Solution");
        for (Individu individu  : liste) {
             double x = individu.somme_sdp();
             double y = individu.somme_sdd() ; 
            series.add(x, y);
        }
        
        for (Individu individu  : Solution.liste) {
             double x = individu.somme_sdp();
             double y = individu.somme_sdd() ; 
            series_solution.add(x, y);
        }
        xySeriesCollection.addSeries(series);
        xySeriesCollection.addSeries(series_solution);
        
        return xySeriesCollection;
    }
    private static XYDataset createSampleData_T_D(List <Individu> liste) {
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
        XYSeries series = new XYSeries("individu");
        XYSeries series_solution = new XYSeries("Solution");
        for (Individu individu  : liste) {
             double x = individu.somme_sft() ; 
             double y = individu.somme_sdd() ; 
            series.add(x, y);
        }
         for (Individu individu  : Solution.liste) {
             double x = individu.somme_sft() ; 
             double y = individu.somme_sdd() ; 
            series_solution.add(x, y);
        }
        xySeriesCollection.addSeries(series);
        xySeriesCollection.addSeries(series_solution);
        return xySeriesCollection;
    }
    
    //---------------------------------------------------- chart  a partir de  arraliste----------------------
    public  ChartPanel chart_xy( ){
      JFreeChart jfreechart = ChartFactory.createScatterPlot(
        "", "Prix", "Taux", createSampleData_PT(),PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyPlot = (XYPlot) jfreechart.getPlot();
        xyPlot.setDomainCrosshairVisible(true);
        xyPlot.setRangeCrosshairVisible(true);
        XYItemRenderer renderer = xyPlot.getRenderer() ; 
        renderer.setSeriesPaint(0, Color.yellow);
        ChartPanel chartPanel =  new ChartPanel(jfreechart) ;
        return chartPanel ; 
        
    }
    
    public  ChartPanel chart_xz(){
      JFreeChart jfreechart = ChartFactory.createScatterPlot(
        "", "Prix", "Duree", createSampleData_PD(),PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyPlot = (XYPlot) jfreechart.getPlot();
        xyPlot.setDomainCrosshairVisible(true);
        xyPlot.setRangeCrosshairVisible(true);
        XYItemRenderer renderer = xyPlot.getRenderer();
        renderer.setSeriesPaint(0, Color.BLACK);
    
        ChartPanel chartPanel =  new ChartPanel(jfreechart) ;
        return chartPanel ; 
        
    }
    
    public  ChartPanel chart_yz( ){
      JFreeChart jfreechart = ChartFactory.createScatterPlot(
        "", "Taux", "Duree", createSampleData_TD(),PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyPlot = (XYPlot) jfreechart.getPlot();
        xyPlot.setDomainCrosshairVisible(true);
        xyPlot.setRangeCrosshairVisible(true);
        XYItemRenderer renderer = xyPlot.getRenderer();
        renderer.setSeriesPaint(0, Color.blue);
         
        ChartPanel chartPanel =  new ChartPanel(jfreechart) ;
        return chartPanel ; 
        
    }
    
     
    private  XYDataset createSampleData_PT() {
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
       
        XYSeries series_solution = new XYSeries("Solution");
        
        for (Individu individu  : Solution.liste) {
             double x = individu.somme_sdp();
             double y = individu.somme_sft() ; 
            series_solution.add(x, y);
        }
        
       
        xySeriesCollection.addSeries(series_solution);
        return xySeriesCollection;
    }
     private XYDataset createSampleData_PD() {
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
     
         XYSeries series_solution = new XYSeries("Solution");
        
        
        for (Individu individu  : Solution.liste) {
             double x = individu.somme_sdp();
             double y = individu.somme_sdd() ; 
            series_solution.add(x, y);
        }
        
        xySeriesCollection.addSeries(series_solution);
        
        return xySeriesCollection;
    }
      private static XYDataset createSampleData_TD() {
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
       
        XYSeries series_solution = new XYSeries("Solution");
       
         for (Individu individu  : Solution.liste) {
             double x = individu.somme_sft() ; 
             double y = individu.somme_sdd() ; 
            series_solution.add(x, y);
        }
        
        xySeriesCollection.addSeries(series_solution);
        return xySeriesCollection;
    }
     
    
}
