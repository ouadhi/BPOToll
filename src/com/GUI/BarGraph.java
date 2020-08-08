package com.GUI;

import com.nsgaii.Individu;
import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

/*
    créer graphe bar pour un individu , compose de  3 catégorie ( SDP , SFT ,  SDD) 
*/

public class BarGraph extends JPanel{
    
    Individu  individu   ;

   public BarGraph(String g  , String h)
   {
          
   }
    public BarGraph(Individu individu) {
        this.individu = individu;
    }
   
    //  valeur de  chaque  catégorie entregister  dans  une  dataset 
   private CategoryDataset createDatasetIndividu( )
   {
         
      final DefaultCategoryDataset dataset =   new DefaultCategoryDataset( );  

      dataset.addValue( this.individu.somme_sdp(), "SDP" , "individu" );        
                

      dataset.addValue( this.individu.somme_sft() , "SFT" , "individu" );        
      

      dataset.addValue( this.individu.somme_sdd(), "SDD", "individu" );        
                

      return dataset; 
   }  
   
   
   /*
   céer le  panel pour afficher  le  graghe 
   */
   public  ChartPanel chart_Bar ()  {
       // creation de charte 
   JFreeChart barChart = ChartFactory.createBarChart(
         "chart",           
         "Category",            
         "Score",            
         createDatasetIndividu(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
   // backgrounde de panel
   barChart.setBackgroundPaint(Color.lightGray);
         
   // ajouter  le chart  a  une panel 
      ChartPanel chartPanel = new ChartPanel( barChart );     
      return chartPanel ; 
   
   }
   
    
}
