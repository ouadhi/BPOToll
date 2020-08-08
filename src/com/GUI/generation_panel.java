package com.GUI;

import com.nsgaii.Population;
import com.nsgaii.Solution;
import java.awt.BorderLayout;
import java.awt.Panel;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeriesCollection;

public class generation_panel extends javax.swing.JPanel {

    // nb  est  le  numero de  génération créer
    public String numero_de_generation;
    public Population p;
    ArrayList<Population> liste_population;

    public generation_panel() {
        initComponents();
    }

    public generation_panel(Population p, String nom) {
        initComponents();
        this.p = p;
        chart_ghraph();
        Graphe();
        numero_generation.setText(nom);
    }

    public generation_panel(XYSeriesCollection prix_taux, XYSeriesCollection prix_duree, XYSeriesCollection taux_duree, String nom) {
        initComponents();
        chart_ghraph_liste(prix_taux, prix_duree, taux_duree);
        numero_generation.setText(nom);
    }
// pour afficher processus 

    public void Graphe() {
      
            graphe.removeAll();
        Solution s = new Solution(p);
        s.mellieur_solution(p);
        Pocessus_Graph g = new Pocessus_Graph(Solution.mellieur_solution());
        graphe.add(g.graph_de_processu(), BorderLayout.CENTER);
        graphe.validate();
        panelGrapheProcessus.add(g.graph_de_processu(), BorderLayout.CENTER);
       
        
    }
// pour afficher chart graphe (  les  individus ) 

    public void chart_ghraph() {
        chart_graphe_x_y.removeAll();
        chart_graphe_x_y.add(Chart_Class.chart_x_y(p), BorderLayout.CENTER);
        chart_graphe_x_y.validate();
        panelx_y.removeAll();
        panelx_y.add(Chart_Class.chart_x_y(p), BorderLayout.CENTER);
        panelx_y.validate();

        chart_graphe_x_z.removeAll();
        chart_graphe_x_z.add(Chart_Class.chart_x_z(p), BorderLayout.CENTER);
        chart_graphe_x_z.validate();
        panelx_z.removeAll();
        panelx_z.add(Chart_Class.chart_x_z(p), BorderLayout.CENTER);
        panelx_z.validate();

        chart_graphe_y_z.removeAll();
        chart_graphe_y_z.add(Chart_Class.chart_y_z(p), BorderLayout.CENTER);
        chart_graphe_y_z.validate();
        panely_z.removeAll();
        panely_z.add(Chart_Class.chart_y_z(p), BorderLayout.CENTER);
        panely_z.validate();

    }

    public void chart_ghraph_liste(XYSeriesCollection prix_taux, XYSeriesCollection prix_duree, XYSeriesCollection taux_duree) {
        Chart_Tab chart_tab = new Chart_Tab(prix_taux, prix_duree, taux_duree);
        chart_graphe_x_y.removeAll();
        chart_graphe_x_y.add(chart_tab.chart_prix_taux(), BorderLayout.CENTER);
        chart_graphe_x_y.validate();
        panelx_y.removeAll();
        panelx_y.add(chart_tab.chart_prix_taux(), BorderLayout.CENTER);
        panelx_y.validate();

        chart_graphe_x_z.removeAll();
        chart_graphe_x_z.add(chart_tab.chart_prix_duree(), BorderLayout.CENTER);
        chart_graphe_x_z.validate();
        panelx_z.removeAll();
        panelx_z.add(chart_tab.chart_prix_duree(), BorderLayout.CENTER);
        panelx_z.validate();

        chart_graphe_y_z.removeAll();
        chart_graphe_y_z.add(chart_tab.chart_taux_duree(), BorderLayout.CENTER);
        chart_graphe_y_z.validate();
        panely_z.removeAll();
        panely_z.add(chart_tab.chart_taux_duree(), BorderLayout.CENTER);
        panely_z.validate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Framex_y = new javax.swing.JFrame();
        panelx_y = new javax.swing.JPanel();
        Framex_z = new javax.swing.JFrame();
        panelx_z = new javax.swing.JPanel();
        Framey_z = new javax.swing.JFrame();
        panely_z = new javax.swing.JPanel();
        FrameGrapheProcessus = new javax.swing.JFrame();
        panelGrapheProcessus = new javax.swing.JPanel();
        numero_generation = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        chart_graphe_x_y = new javax.swing.JPanel();
        graphe = new javax.swing.JPanel();
        chart_graphe_x_z = new javax.swing.JPanel();
        chart_graphe_y_z = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        Framex_y.setLocationRelativeTo(null);
        Framex_y.setMinimumSize(new java.awt.Dimension(792, 495));

        panelx_y.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout Framex_yLayout = new javax.swing.GroupLayout(Framex_y.getContentPane());
        Framex_y.getContentPane().setLayout(Framex_yLayout);
        Framex_yLayout.setHorizontalGroup(
            Framex_yLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelx_y, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
        );
        Framex_yLayout.setVerticalGroup(
            Framex_yLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelx_y, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
        );

        Framex_y.setLocationRelativeTo(null);
        Framex_z.setMinimumSize(new java.awt.Dimension(792, 495));

        panelx_z.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout Framex_zLayout = new javax.swing.GroupLayout(Framex_z.getContentPane());
        Framex_z.getContentPane().setLayout(Framex_zLayout);
        Framex_zLayout.setHorizontalGroup(
            Framex_zLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelx_z, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
        );
        Framex_zLayout.setVerticalGroup(
            Framex_zLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelx_z, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
        );

        Framex_y.setLocationRelativeTo(null);
        Framey_z.setMinimumSize(new java.awt.Dimension(792, 495));

        panely_z.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout Framey_zLayout = new javax.swing.GroupLayout(Framey_z.getContentPane());
        Framey_z.getContentPane().setLayout(Framey_zLayout);
        Framey_zLayout.setHorizontalGroup(
            Framey_zLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panely_z, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
        );
        Framey_zLayout.setVerticalGroup(
            Framey_zLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panely_z, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
        );

        Framex_y.setLocationRelativeTo(null);
        FrameGrapheProcessus.setMinimumSize(new java.awt.Dimension(792, 495));

        panelGrapheProcessus.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout FrameGrapheProcessusLayout = new javax.swing.GroupLayout(FrameGrapheProcessus.getContentPane());
        FrameGrapheProcessus.getContentPane().setLayout(FrameGrapheProcessusLayout);
        FrameGrapheProcessusLayout.setHorizontalGroup(
            FrameGrapheProcessusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGrapheProcessus, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
        );
        FrameGrapheProcessusLayout.setVerticalGroup(
            FrameGrapheProcessusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGrapheProcessus, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
        );

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        setMaximumSize(new java.awt.Dimension(1032, 344));
        setMinimumSize(new java.awt.Dimension(1032, 344));
        setRequestFocusEnabled(false);

        numero_generation.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Génération N° : ");

        chart_graphe_x_y.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        chart_graphe_x_y.setMaximumSize(new java.awt.Dimension(322, 290));
        chart_graphe_x_y.setMinimumSize(new java.awt.Dimension(322, 290));
        chart_graphe_x_y.setPreferredSize(new java.awt.Dimension(322, 290));
        chart_graphe_x_y.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chart_graphe_x_yMouseClicked(evt);
            }
        });
        chart_graphe_x_y.setLayout(new java.awt.BorderLayout());

        graphe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)));
        graphe.setMaximumSize(new java.awt.Dimension(322, 290));
        graphe.setMinimumSize(new java.awt.Dimension(322, 290));
        graphe.setPreferredSize(new java.awt.Dimension(322, 290));
        graphe.setLayout(new java.awt.BorderLayout());

        chart_graphe_x_z.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        chart_graphe_x_z.setMaximumSize(new java.awt.Dimension(322, 290));
        chart_graphe_x_z.setMinimumSize(new java.awt.Dimension(322, 290));
        chart_graphe_x_z.setPreferredSize(new java.awt.Dimension(322, 290));
        chart_graphe_x_z.setLayout(new java.awt.BorderLayout());

        chart_graphe_y_z.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        chart_graphe_y_z.setMaximumSize(new java.awt.Dimension(322, 290));
        chart_graphe_y_z.setMinimumSize(new java.awt.Dimension(322, 290));
        chart_graphe_y_z.setPreferredSize(new java.awt.Dimension(322, 290));
        chart_graphe_y_z.setLayout(new java.awt.BorderLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maximizethewindow_theapplication_maximizar_2873.png"))); // NOI18N
        jButton1.setToolTipText("à grandir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maximizethewindow_theapplication_maximizar_2873.png"))); // NOI18N
        jButton2.setToolTipText("à grandir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maximizethewindow_theapplication_maximizar_2873.png"))); // NOI18N
        jButton3.setToolTipText("à grandir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maximizethewindow_theapplication_maximizar_2873.png"))); // NOI18N
        jButton4.setToolTipText("à grandir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numero_generation, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(chart_graphe_x_y, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chart_graphe_x_z, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chart_graphe_y_z, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(graphe, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 13, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(297, 297, 297)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(305, 305, 305)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                    .addComponent(numero_generation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chart_graphe_x_y, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chart_graphe_x_z, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chart_graphe_y_z, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(graphe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chart_graphe_x_yMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chart_graphe_x_yMouseClicked

    }//GEN-LAST:event_chart_graphe_x_yMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        Graphe_Generation_Frame f = new Graphe_Generation_Frame(chart_graphe_x_y );
//        f.setVisible(true);
        Framex_y.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//        Graphe_Generation_Frame f = new Graphe_Generation_Frame(chart_graphe_x_z);
//        f.setVisible(true);
        Framex_z.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        Graphe_Generation_Frame f = new Graphe_Generation_Frame(chart_graphe_y_z);
//        f.setVisible(true);
        Framey_z.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
//        Graphe_Generation_Frame f = new Graphe_Generation_Frame(graphe);
//        f.setVisible(true);
        FrameGrapheProcessus.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame FrameGrapheProcessus;
    private javax.swing.JFrame Framex_y;
    private javax.swing.JFrame Framex_z;
    private javax.swing.JFrame Framey_z;
    private javax.swing.JPanel chart_graphe_x_y;
    private javax.swing.JPanel chart_graphe_x_z;
    private javax.swing.JPanel chart_graphe_y_z;
    private javax.swing.JPanel graphe;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel numero_generation;
    private javax.swing.JPanel panelGrapheProcessus;
    private javax.swing.JPanel panelx_y;
    private javax.swing.JPanel panelx_z;
    private javax.swing.JPanel panely_z;
    // End of variables declaration//GEN-END:variables
}
