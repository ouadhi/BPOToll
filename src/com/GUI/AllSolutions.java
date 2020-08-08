
package com.GUI;

import com.nsgaii.Individu;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.ArrayList;
       
/*
afficher  structure , chart  graph et  la  matrice  de  chaque  solution trouvée 
*/
public class AllSolutions extends javax.swing.JFrame {
     ArrayList<Individu> liste ; 
     // conteneur des graphes  
     Container content;   
    public AllSolutions() {
        initComponents();
        content = new Panel();
        content.setLayout(new GridLayout(3, 1));
    }
    
    // liste  =  la  liste des  solutions 
    public AllSolutions(ArrayList<Individu> liste ) {
        initComponents();
        this.setLocationRelativeTo(null);
        content = new Panel();
        this.liste = liste;
        // créer un nombre des etage egale a la taille des solution
        content.setLayout(new GridLayout(liste.size(), 1));
         addpanel();
        scroolpanel.add(content);
       
    }

    
    public  void addpanel()  {
        for (int i = 0; i < liste.size(); i++) {
            /*
            Soltion panel  est  un Jpanel contien les ghraphe d'une  solution 
            */
            SolutionPanel panel_sol  =  new  SolutionPanel(liste.get(i)) ; 
            content.add(panel_sol) ; 
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroolpanel = new java.awt.ScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroolpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroolpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AllSolutions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllSolutions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllSolutions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllSolutions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AllSolutions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.ScrollPane scroolpanel;
    // End of variables declaration//GEN-END:variables
}
