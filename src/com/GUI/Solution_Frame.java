package com.GUI;

import com.nsgaii.Individu;
import com.tache.Librarie_Taches;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Solution_Frame extends javax.swing.JFrame {

    //  solutionn est  l'individu de  meilleur solution
    // cette  class  afficher la soltion  final de  l'algorithme 
    // peut  enregistrer  la  solution sous  forme d'un fichier  XML nomée  Solution.xml
    Individu solution;

    public Solution_Frame(Individu solution) {
        initComponents();
        this.setLocationRelativeTo(null);
         this.solution = solution;
        panel_graphe.removeAll();
        /*
        conception de  processus 
        */
        Pocessus_Graph g = new Pocessus_Graph(this.solution);
        panel_graphe.add(g.graph_de_processu(), BorderLayout.CENTER);
        panel_graphe.validate();
       
    }

    public Solution_Frame() {
//        initComponents();
//        this.setLocationRelativeTo(null);
//        panel_graphe.removeAll();
//        Pocessus_Graph g = new Pocessus_Graph();
//        panel_graphe.add(g.create_graphe2(), BorderLayout.CENTER);
//        panel_graphe.validate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        Detail = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab = new javax.swing.JTextArea();
        Graph = new javax.swing.JFrame();
        mypanel = new javax.swing.JPanel();
        panel_graphe = new javax.swing.JPanel();
        Détails = new javax.swing.JButton();
        Capture_button = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        Detail.setMinimumSize(new java.awt.Dimension(708, 553));

        tab.setEditable(false);
        tab.setBackground(new java.awt.Color(0, 0, 0));
        tab.setColumns(20);
        tab.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tab.setForeground(new java.awt.Color(255, 255, 255));
        tab.setRows(5);
        jScrollPane1.setViewportView(tab);

        javax.swing.GroupLayout DetailLayout = new javax.swing.GroupLayout(Detail.getContentPane());
        Detail.getContentPane().setLayout(DetailLayout);
        DetailLayout.setHorizontalGroup(
            DetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
        );
        DetailLayout.setVerticalGroup(
            DetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
        );

        Graph.setMinimumSize(new java.awt.Dimension(1076, 478));

        mypanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        mypanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout GraphLayout = new javax.swing.GroupLayout(Graph.getContentPane());
        Graph.getContentPane().setLayout(GraphLayout);
        GraphLayout.setHorizontalGroup(
            GraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mypanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1076, Short.MAX_VALUE)
        );
        GraphLayout.setVerticalGroup(
            GraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mypanel, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Solution Finale");
        setMaximumSize(new java.awt.Dimension(1051, 503));
        setMinimumSize(new java.awt.Dimension(1051, 503));

        panel_graphe.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        panel_graphe.setLayout(new java.awt.BorderLayout());

        Détails.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Détails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/viewdetails_vista_3354.png"))); // NOI18N
        Détails.setText("Détail");
        Détails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DétailsActionPerformed(evt);
            }
        });

        Capture_button.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Capture_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Screenshot_icon-icons.com_55819.png"))); // NOI18N
        Capture_button.setText("Capture");
        Capture_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Capture_buttonActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/four-bars-graph_icon-icons.com_55158.png"))); // NOI18N
        jButton1.setText("Graphe Bar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Sauvegarder");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_graphe, javax.swing.GroupLayout.PREFERRED_SIZE, 1051, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(Détails, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(Capture_button, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_graphe, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Détails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Capture_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
      /*
        choisir  le  repertoir ou  la solution  va  enregistrer 
        */
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("‪C:\\Users\\OUADHI\\Desktop"));
//        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichier XML", "xml");
//        fileChooser.addChoosableFileFilter(filter);
          fileChooser.setAcceptAllFileFilterUsed(false);
          fileChooser.showOpenDialog(null);
          File f = fileChooser.getSelectedFile();
          if ( !f.isDirectory() ) {
		f = f.getParentFile();
	   }
          String path = f.getPath() ; 
        
        Save_file(path) ;
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void DétailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DétailsActionPerformed
        /*
        le  détails de solution 
        */
        tab.append("Détail de solution \n");
        tab.append("ID :"+solution.id+"\n");// identifiant
         tab.append("parents:"+solution.id_parent1+" - "+solution.id_parent2+"\n"); // les  parents de solution 
          tab.append("fitness :"+solution.fitness+"\n"); // valeur de  fitness
          tab.append("nb "+solution.tache_utiliser().size()); // nb des tache  utiliser 
          /*
          matrice  des taches 
          */
        for (int i = 0; i < solution.structure_de_processus.length; i++) {
            for (int j = 0; j < solution.structure_de_processus.length; j++) {
                tab.append(" "+solution.structure_de_processus[i][j]);
            }
            tab.append("\n");
        }
        Detail.setVisible(true);
    }//GEN-LAST:event_DétailsActionPerformed

    private void Capture_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Capture_buttonActionPerformed
         /*
        capture d'ecran 
        */
        DateFormat dateFormat = new SimpleDateFormat("yyyy MM dd HH mm ss");
          Calendar cal = Calendar.getInstance();
         String  name = "solution"+dateFormat.format(cal.getTime()).toString()+".png" ;
         CaptureEcran capture = new  CaptureEcran(name,panel_graphe) ;   
         capture.savecapture();
    }//GEN-LAST:event_Capture_buttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         /*
        graph bar 
        */
        BarGraph g  =  new  BarGraph(solution) ; 
        mypanel.removeAll();
        mypanel.add(g.chart_Bar()) ;  
        mypanel.validate();
        Graph.setVisible(true );
       
    }//GEN-LAST:event_jButton1ActionPerformed
   /*
    méthode  pour  exporter  la solution  sous  forme une  fichier  XML
    */
    public void Save_file(String path) throws HeadlessException {
        Document doc = new Document();
        Element element = new Element("Solution" ) ;
        element.setAttribute("SDP"," "+solution.somme_sdp()) ;
        element.setAttribute("SFT"," "+solution.somme_sft()) ;
        element.setAttribute("SDD"," "+solution.somme_sdd()) ;
        doc.setRootElement(element);
        for (int i = 0; i <this.solution.tache_utiliser().size(); i++) {
            Element solution_xml = new Element("task");
            int  num  =  solution.tache_utiliser().get(i) ;
            solution_xml.addContent(new Element("num_tache").setText(Integer.toString(num)));
            solution_xml.addContent(new Element("name_tache").setText(Librarie_Taches.tache_liste.get(num).getNom()));
            doc.getRootElement().addContent(solution_xml);
        }
          DateFormat dateFormat = new SimpleDateFormat("yyyy MM dd HH mm ss");
          Calendar cal = Calendar.getInstance();       
        File file  =  new  File(path+"\\solution"+dateFormat.format(cal.getTime()).toString()+".xml") ;
        //JDOM document is ready now, lets write it to file now
        XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
        try {
            //output xml to console for debugging
            //xmlOutputter.output(doc, System.out);
            xmlOutputter.output(doc, new FileOutputStream(file.getPath().toString()));
            JOptionPane.showMessageDialog(null,"Sauvegarder");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Solution_Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Solution_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(Solution_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Solution_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Solution_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Solution_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Solution_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Capture_button;
    private javax.swing.JFrame Detail;
    private javax.swing.JButton Détails;
    private javax.swing.JFrame Graph;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mypanel;
    private javax.swing.JPanel panel_graphe;
    private javax.swing.JTextArea tab;
    // End of variables declaration//GEN-END:variables
}
