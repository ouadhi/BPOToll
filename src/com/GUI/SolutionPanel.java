
package com.GUI;

import com.nsgaii.Individu;
import com.nsgaii.Solution;
import java.awt.BorderLayout;

/*
afficher le graph bar  et  conception de  chaque  individu solution 
*/
public class SolutionPanel extends javax.swing.JPanel {
  public  Individu  solution  ; 
   
    public SolutionPanel() {
        initComponents();
    }
    
     public SolutionPanel(Individu solution ) {
        initComponents();
        this.solution  =  solution ; 
        Graphe();  
        graph_bar() ; 
        
    }
    /*
     conception de  solution
     */
 public void Graphe() {
        
        Pocessus_Graph g = new Pocessus_Graph(solution);
        Structurdeprocessus.removeAll();
        Structurdeprocessus.add(g.graph_de_processu(), BorderLayout.CENTER);
       Structurdeprocessus.validate();
    }
 /*
 graph bar 
 */
 public  void  graph_bar()  {
     BarGraph g  =  new  BarGraph(solution) ; 
        garphbar.removeAll();
        garphbar.add(g.chart_Bar()) ;  
      garphbar.validate(); 
 
 } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Structurdeprocessus = new javax.swing.JPanel();
        garphbar = new javax.swing.JPanel();

        Structurdeprocessus.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        Structurdeprocessus.setLayout(new java.awt.BorderLayout());

        garphbar.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        garphbar.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Structurdeprocessus, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(garphbar, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Structurdeprocessus, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addComponent(garphbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Structurdeprocessus;
    private javax.swing.JPanel garphbar;
    // End of variables declaration//GEN-END:variables
}
