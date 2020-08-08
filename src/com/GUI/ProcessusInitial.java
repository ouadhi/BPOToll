package com.GUI;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import com.nsgaii.Solution;
import com.tache.Librarie_Taches;
import com.tache.Tache;
import java.awt.BorderLayout;
import java.util.ArrayList;

public class ProcessusInitial extends javax.swing.JFrame {
    /*
    afficher  la structure de  processu initiale  a partire de  fichier  XML  de  ce  processus  
    */
    public ProcessusInitial() {
        initComponents();
        this.setLocationRelativeTo(null);
        panal_processus.removeAll();
        panal_processus.add(create_graphe(), BorderLayout.CENTER);
        panal_processus.validate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panal_processus = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Processus  Initial");
        setMaximumSize(new java.awt.Dimension(795, 494));
        setMinimumSize(new java.awt.Dimension(795, 494));
        setPreferredSize(new java.awt.Dimension(795, 494));

        panal_processus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panal_processus.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panal_processus, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panal_processus, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public mxGraphComponent create_graphe() {
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();
        graph.getModel().beginUpdate();
        try {
            Object v1, v2;
            v1 = graph.insertVertex(parent, null, "start", 100, 0, 80, 30);
            v2 = graph.insertVertex(parent, null, "Tache" + Librarie_Taches.processus_initial.get(0).getNum() + " : " + Librarie_Taches.tache_liste.get(Librarie_Taches.processus_initial.get(0).getNum()).getNom(), 100, 80, 80, 30);
            graph.insertEdge(parent, null, "", v1, v2);
            // langueur de  edge
            int t = 160;
            v1 = v2;
            for (int i = 1; i < Librarie_Taches.processus_initial.size() ; i++) {
                v2 = graph.insertVertex(parent, null, "Tache" + Librarie_Taches.processus_initial.get(i).getNum() + " : " + Librarie_Taches.tache_liste.get(Librarie_Taches.processus_initial.get(i).getNum()).getNom(), 100, t, 80, 30);
                graph.insertEdge(parent, null, "", v1, v2);
                t = t + 80;
                v1 = v2;
            }
            v2 = graph.insertVertex(parent, null, "End", 100, t, 80, 30);
            graph.insertEdge(parent, null, "", v1, v2);
        } finally {
            graph.getModel().endUpdate();
        }
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        return graphComponent;
    }

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
            java.util.logging.Logger.getLogger(ProcessusInitial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProcessusInitial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProcessusInitial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProcessusInitial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProcessusInitial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panal_processus;
    // End of variables declaration//GEN-END:variables
}
