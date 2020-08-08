package com.GUI;

import com.nsgaii.Run_Class;
import com.tache.Librarie_Taches;
import com.tache.Xml_To_Librarie;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
//

public class Configuration_Frame extends javax.swing.JFrame {
    /*
     bibiotheque  pour importer  la  bibiotheque des  tache  
     processus  pour  importer  le  processus  initiale   
     */

    String bibiotheque, processus, in_out;
    Configuration conf;

    public Configuration_Frame() {
        initComponents();
        this.setLocationRelativeTo(null);
        taille.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fr = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        taille_de_population = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nb_des_generation = new javax.swing.JSpinner();
        taille = new javax.swing.JSpinner();
        type_de_selection = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        croisement_type = new javax.swing.JComboBox();
        croisement = new javax.swing.JSpinner();
        mutation = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        max = new javax.swing.JSpinner();
        min = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        pathFile_bibio = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        in_out_path = new javax.swing.JLabel();
        processus2 = new javax.swing.JButton();
        start = new javax.swing.JButton();

        fr.setMinimumSize(new java.awt.Dimension(471, 331));

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout frLayout = new javax.swing.GroupLayout(fr.getContentPane());
        fr.getContentPane().setLayout(frLayout);
        frLayout.setHorizontalGroup(
            frLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frLayout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(278, Short.MAX_VALUE))
        );
        frLayout.setVerticalGroup(
            frLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configuration");

        taille_de_population.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(50), Integer.valueOf(2), null, Integer.valueOf(10)));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Taille de population :");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Nomber des génération :");

        nb_des_generation.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(20), Integer.valueOf(1), null, Integer.valueOf(1)));

        taille.setModel(new javax.swing.SpinnerNumberModel(2, 2, 30, 1));

        type_de_selection.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "uniforme", "par roulette", "SUS", "RSS", "par rang", "par tournoi", "massale", "ascendance", "descendance", "collateraux", "generation" }));
        type_de_selection.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                type_de_selectionItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Type de selection :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Probabilité de croisement :");

        croisement_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normale" }));
        croisement_type.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                croisement_typeItemStateChanged(evt);
            }
        });

        croisement.setModel(new javax.swing.SpinnerNumberModel(0.8d, 0.1d, 1.0d, 0.1d));

        mutation.setModel(new javax.swing.SpinnerNumberModel(0.2d, 0.1d, 1.0d, 0.1d));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Probabilité de mutation :");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Taille Max de processus :");

        max.setModel(new javax.swing.SpinnerNumberModel(6, 4, 30, 1));

        min.setModel(new javax.swing.SpinnerNumberModel(4, 4, 30, 1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Taille Min de  processus :");

        pathFile_bibio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Bibiothéque");
        jButton1.setToolTipText("importer  un fichier XML");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        in_out_path.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        processus2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        processus2.setText("input/output");
        processus2.setToolTipText("importer un fichier XML");
        processus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processus2ActionPerformed(evt);
            }
        });

        start.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        start.setText("Start");
        start.setToolTipText("lancer  l'execution");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(taille_de_population, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nb_des_generation, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(type_de_selection, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(taille, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(min, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(max, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mutation, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(croisement_type, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(croisement, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(processus2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pathFile_bibio, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(in_out_path, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(taille_de_population, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(nb_des_generation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(type_de_selection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(taille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(croisement_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(croisement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mutation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pathFile_bibio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(in_out_path, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(processus2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        /*
         confirmé si l'utilisateur  validé la configuration pour  passé au traitement  
         */
        int a = JOptionPane.showConfirmDialog(null, "veuillez vous confirmer ???", "Validation", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            
            Thread   t   =  new  Thread(){
                public    void  run () {
                 galsspane();
                    try {  
                        sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Configuration_Frame.class.getName()).log(Level.SEVERE, null, ex);
                    }  
            conf = new Configuration((int) taille_de_population.getValue(), (int) nb_des_generation.getValue(), type_de_selection.getSelectedItem().toString(), (Double) croisement.getValue(), (Double) mutation.getValue(), bibiotheque, processus, (int) max.getValue(), (int) min.getValue());
            /*
             lancer execution ( NSGAII )   
             */
              Run_Class nsgaii = new Run_Class(conf);
              nsgaii.run();
            
              // notification indique la fin de traitement
              Notification   notification  =  new  Notification("Fin de  traitement") ; 
              notification.display();
                    setVisible(false);
           
                }
            } ;  
             t.start();
            
           
            
    
       }

    }//GEN-LAST:event_startActionPerformed

    private void type_de_selectionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_type_de_selectionItemStateChanged
        /*
         afficher textField  taille  pour ajouter  la  taille de  tournoi si  l'utilisateur choisi la selection par tournoi   
         */
        if (type_de_selection.getSelectedItem().equals("par tournoi")) {
            taille.setVisible(true);
        } else {
            taille.setVisible(false);
        }
    }//GEN-LAST:event_type_de_selectionItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /*
         importer la  bibiothéque des  taches 
         */
        JFileChooser fileChooser = new JFileChooser();/*ouvrir une fenêtre pour sélectionner un fichier*/
        fileChooser.setCurrentDirectory(new File("‪C:\\Users\\OUADHI\\Desktop"));
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.showOpenDialog(null);
        File f = fileChooser.getSelectedFile();// récuperer le fichier sélectionné
        this.bibiotheque = fileChooser.getSelectedFile().getPath();
        pathFile_bibio.setText(f.getName());
         // créer la  bibiothéque des  taches 
        Xml_To_Librarie xml = new Xml_To_Librarie(this.bibiotheque);
        xml.convertir();
        System.out.println(bibiotheque);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void processus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processus2ActionPerformed
        /*
         importer les  input et  les  outputs de  processus  initial 
         */
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("‪C:\\Users\\OUADHI\\Desktop"));
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.showOpenDialog(null);
        File f = fileChooser.getSelectedFile();
        this.in_out = fileChooser.getSelectedFile().getPath();
        in_out_path.setText(f.getName());
        Xml_To_Librarie xml = new Xml_To_Librarie(in_out);
        xml.inputs_outputs();
        System.out.println(in_out);
    }//GEN-LAST:event_processus2ActionPerformed

    private void croisement_typeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_croisement_typeItemStateChanged
        if (croisement_type.getSelectedItem().toString().equals("Rank scro")) {
            croisement.setEnabled(false);
        } else {
            croisement.setEnabled(true);
        }

    }//GEN-LAST:event_croisement_typeItemStateChanged

    public void get_File(String path, JLabel labe) throws HeadlessException {
        /*
         cette partie pour  importé le porcessus  métier eet  manupilé par l'application
         l'utilisateur peut import les fichiers XML 
         */
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("‪C:\\Users\\OUADHI\\Desktop"));
//        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichier XML", "xml");
//        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.showOpenDialog(null);
        File f = fileChooser.getSelectedFile();
        path = fileChooser.getSelectedFile().getPath();
        labe.setText(f.getName());
    }
    
    public   void  galsspane ()  {
    // Create a JPanel with semi-transparent
				// black background
				// This will be glass pane
				JPanel p=new JPanel(){
					public void paintComponent(Graphics g)
					{
						g.setColor(new Color(0,0,0,140));
						g.fillRect(0,0,getWidth(),getHeight());
					}
				};
				
				// Set it non-opaque
				p.setOpaque(false);
				
				// Set layout to JPanel
				p.setLayout(new GridBagLayout());
				
				// Add the jlabel with the image icon
				p.add(new JLabel(new ImageIcon("loading.gif")));
				
				// Take glass pane
				this.setGlassPane(p);
				
				// Add MouseListener
				p.addMouseListener(new MouseAdapter(){
					public void mousePressed(MouseEvent me)
					{
						// Consume the event, now the input is blocked
						me.consume();
						
						// Create beep sound, when mouse is pressed
						Toolkit.getDefaultToolkit().beep();
					}
				});
				
				// Make it visible, it isn't by default because
				// it is set as glass pane
				p.setVisible(true);
    
    }

    public int nb_generation() {
        return (int) nb_des_generation.getValue();
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
            java.util.logging.Logger.getLogger(Configuration_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuration_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuration_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuration_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Configuration_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JSpinner croisement;
    public static javax.swing.JComboBox croisement_type;
    private javax.swing.JFrame fr;
    private javax.swing.JLabel in_out_path;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JSpinner max;
    public static javax.swing.JSpinner min;
    public static javax.swing.JSpinner mutation;
    private javax.swing.JSpinner nb_des_generation;
    private javax.swing.JLabel pathFile_bibio;
    private javax.swing.JButton processus2;
    private javax.swing.JButton start;
    private javax.swing.JSpinner taille;
    public static javax.swing.JSpinner taille_de_population;
    public static javax.swing.JComboBox type_de_selection;
    // End of variables declaration//GEN-END:variables
}
