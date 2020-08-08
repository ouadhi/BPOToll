
package com.GUI;

import com.nsgaii.Individu;
import com.nsgaii.Solution;
import com.tache.Librarie_Taches;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/*    rechercher a un un solution pour afficher les détails
*/
public class IndividuFrame extends javax.swing.JFrame {
   Individu solution ; 
    public IndividuFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        savebtn.setVisible(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sdd = new javax.swing.JTextField();
        sft = new javax.swing.JTextField();
        sdp = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        GrapheBar = new javax.swing.JPanel();
        graph = new javax.swing.JPanel();
        GrapheBar2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detail_text = new javax.swing.JTextArea();
        savebtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("SDD : ");

        jLabel2.setText("SFT : ");

        jLabel3.setText("SDP : ");

        sdd.setToolTipText("Durée");

        sft.setToolTipText("Taux");

        sdp.setToolTipText("Prix");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/active-search-symbol_icon-icons.com_53795.png"))); // NOI18N
        jButton1.setText("Rechercher");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        GrapheBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        GrapheBar.setLayout(new java.awt.BorderLayout());

        graph.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        graph.setLayout(new java.awt.BorderLayout());

        GrapheBar2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        detail_text.setColumns(20);
        detail_text.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        detail_text.setRows(5);
        jScrollPane1.setViewportView(detail_text);

        javax.swing.GroupLayout GrapheBar2Layout = new javax.swing.GroupLayout(GrapheBar2);
        GrapheBar2.setLayout(GrapheBar2Layout);
        GrapheBar2Layout.setHorizontalGroup(
            GrapheBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        GrapheBar2Layout.setVerticalGroup(
            GrapheBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        savebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save_icon-icons.com_55820.png"))); // NOI18N
        savebtn.setText("Sauvgarder");
        savebtn.setToolTipText("enregistrer la solution sous form d'un fichier XML");
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sdp, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(sft, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sdd, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(savebtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(GrapheBar, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(graph, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(GrapheBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(sft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(sdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(savebtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GrapheBar, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(graph, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GrapheBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Individu d  = null ; 
        
        if (sdd.getText().isEmpty() && sdp.getText().isEmpty() && sft.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, " Remplir deux champ au minimum  " , "Infomation" ,  JOptionPane.ERROR_MESSAGE);
        } else {
            if (sdd.getText().isEmpty() ) {
               d = recherchesft_sdp (Double.parseDouble(sft.getText())   , Double.parseDouble(sdp.getText())) ; 
            }
            if (sdp.getText().isEmpty()) {
               d =  recherchesdd_sft (Double.parseDouble(sdd.getText()) , Double.parseDouble(sft.getText())) ;  
            }
            if (sft.getText().isEmpty()) {
               d =  recherchesdd_sdp (Double.parseDouble(sdd.getText())  , Double.parseDouble(sdp.getText())) ; 
            }
            if (!sdd.getText().isEmpty() && !sdp.getText().isEmpty() && !sft.getText().isEmpty()) {
                d= recherche(Double.parseDouble(sdd.getText()) , Double.parseDouble(sft.getText()) , Double.parseDouble(sdp.getText()) ) ; 
            }
            
            affiche_details(d);
            this.solution =  d ; 
            savebtn.setVisible(true);
        
        }
        
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
        Save_file();
    }//GEN-LAST:event_savebtnActionPerformed
       /* 
         rechercher  a l'individu dans la  liste  des  solutions 
    */
       public Individu recherche (double  sdd , double  sft   , double sdp  )  {
           for (int i = 0; i < Solution.liste.size(); i++) {
              Individu d  = Solution.liste.get(i)   ; 
               if (d.somme_sdd()== sdd && d.somme_sdp()==sdp  &&   d.somme_sft()==  sft  ) {
                   return   d  ; 
               }
           }
           return null   ; 
       } 
       public Individu recherchesdd_sft (double  sdd , double  sft    )  {
           for (int i = 0; i < Solution.liste.size(); i++) {
              Individu d  = Solution.liste.get(i)   ; 
               if (d.somme_sdd()== sdd  &&   d.somme_sft()==  sft  ) {
                   return   d  ; 
               }
           }
           return null   ; 
       } 
       public Individu recherchesdd_sdp (double  sdd , double sdp  )  {
           for (int i = 0; i < Solution.liste.size(); i++) {
              Individu d  = Solution.liste.get(i)   ; 
               if (d.somme_sdd()== sdd && d.somme_sdp()==sdp   ) {
                   return   d  ; 
               }
           }
           return null   ; 
       } 
       public Individu recherchesft_sdp ( double  sft   , double sdp  )  {
           for (int i = 0; i < Solution.liste.size(); i++) {
              Individu d  = Solution.liste.get(i)   ; 
               if ( d.somme_sdp()==sdp  &&   d.somme_sft()==  sft  ) {
                   return   d  ; 
               }
           }
           return null   ; 
       } 
       
        private void affiche_details(Individu d) {
            /*
            afficher  structure du  processus 
            */
            Pocessus_Graph g =  new  Pocessus_Graph(d)  ; 
            graph.removeAll(); 
            graph.add(g.graph_de_processu()) ;  
            graph.validate();
            
            /*
            graphe  bar 
            */
            BarGraph bar  =  new  BarGraph(d)  ;  
            GrapheBar.removeAll();  
            GrapheBar.add(bar.chart_Bar()) ;  
            GrapheBar.validate();
            /*
            affiche  la  matrice  de processus
            */
            detail_text.append("ID : "+d.id+"\n");
            detail_text.append("parents : "+d.id_parent1+" "+d.id_parent2+"\n");
            detail_text.append("fitness: "+d.fitness+"\n");
            detail_text.append("generation : "+d.generation+"\n");
            for (int i = 0; i < d.structure_de_processus.length; i++) {
                for (int j = 0; j < d.structure_de_processus.length; j++) {
                 detail_text.append(" "+d.structure_de_processus[i][j]);
               }
                detail_text.append(" \n");
            }    
    }
        
        /*
        sauvgarder la solution trouvée dans un fcihier XML   
        */
         public void Save_file() throws HeadlessException {
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
        File file  =  new  File("solution recherche"+dateFormat.format(cal.getTime()).toString()+".xml") ;
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
            java.util.logging.Logger.getLogger(IndividuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IndividuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IndividuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IndividuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IndividuFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GrapheBar;
    private javax.swing.JPanel GrapheBar2;
    private javax.swing.JTextArea detail_text;
    private javax.swing.JPanel graph;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton savebtn;
    private javax.swing.JTextField sdd;
    private javax.swing.JTextField sdp;
    private javax.swing.JTextField sft;
    // End of variables declaration//GEN-END:variables

   
}
