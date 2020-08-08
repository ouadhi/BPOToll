package com.nsgaii;

import com.nsgaii.operateur_genetique.SelectionSurAscendance;
import com.nsgaii.operateur_genetique.Croisement_Mutation;
import com.nsgaii.operateur_genetique.Selection;
import com.GUI.Configuration;
import com.GUI.Configuration_Frame;
import com.GUI.Loading;
import com.GUI.Solution_Frame;
import com.GUI.generation_frame;
import com.GUI.generation_panel;
import com.nsgaii.operateur_genetique.SelctionMassale;
import com.nsgaii.operateur_genetique.SelectionCollateraux;
import com.nsgaii.operateur_genetique.SelectionParGeneration;
import com.nsgaii.operateur_genetique.SelectionSurDescendance;
import com.nsgaii.operateur_genetique.SelectionSus;
import com.tache.PopulationToExcel;
import com.tache.SelectionExcel;
import com.tache.Xml_To_Librarie;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Run_Class {

    public static int taille_de_population;
    int nb_generation;

    Configuration conf;
    /*
     1-  le  ghraphe prix taux 
     */
    XYSeriesCollection prix_taux_Collection;
    XYSeries series = new XYSeries("individu");
    XYSeries series_solution  = new XYSeries("Solution");

    /*
     2-  le  ghraphe prix durée
     */
    XYSeriesCollection prix_duree_Collection;
    XYSeries series2 = new XYSeries("individu");
     XYSeries series2_solution  = new XYSeries("Solution");
    /*
     3-  le  ghraphe taux durée
     */
    XYSeriesCollection taux_dureeCollection;
    XYSeries series3 = new XYSeries("individu");
     XYSeries series3_solution  = new XYSeries("Solution");

    // Temps d'execution  
    public static long t1, t2;

    // numero de  génération  
    public static int n_generatoin = 1;

    /*
     constructeur
     */
    public Run_Class(Configuration conf) {
        this.conf = conf;
        this.taille_de_population = conf.nb_population;
        this.nb_generation = conf.nb_generation;
        prix_taux_Collection = new XYSeriesCollection();
        prix_duree_Collection = new XYSeriesCollection();
        taux_dureeCollection = new XYSeriesCollection();
    }

    public void run() {
        // temps de  debut  l'execution 
        t1 = System.nanoTime();
         
        // creation un fichier  excel 
        
          PopulationToExcel  p_excel =  new PopulationToExcel() ; 
        
        // fichier pour  enregitrer  les  individu de chaque  géneration 
        FileWriter file;
        try {
            file = new FileWriter("file.txt", false);
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(Run_Class.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
         générer  la  population  initial 
         */
        Population p = new Population((int) Configuration_Frame.taille_de_population.getValue());
        /*
         sauvgarder  les  individus  dans  les  fichier
         */
        p_excel.add_population_excel(p);
        p.save_all();
        createSampleData_P_D(p.liste);
        createSampleData_P_T(p.liste);
        createSampleData_T_D(p.liste);
        /*
         f  : Jframe  pour  afficher  les  graphes 
         */
        Loading d = new Loading();
     
        /*
         1ier  panel de  
         */
        generation_frame f = new generation_frame(nb_generation, d);
        f.add_panals(new generation_panel(p, "1"));

        /*
         recupérer  le  type de  coisement et du  mutation 
         */
        String type_selection = Configuration_Frame.type_de_selection.getSelectedItem().toString();
        String type_croisement = Configuration_Frame.croisement_type.getSelectedItem().toString();

        /*
        
         */
        ArrayList<Individu> liste_Qt = new ArrayList<>();

        /*
         début d'execution d'algorithme
         */
        for (int i = 0; i < nb_generation; i++) {
            System.out.println("************************* population " + i + " ************************");
            p.populatioIsValide();
            /*
             les  opérateus  génétique  (  selection  , croisement  et  mutation  ) 
             */
            while (liste_Qt.size() < p.liste.size()) {

                if (type_selection.equals("uniforme")) {
                    if (type_croisement.equals("Normale")) {
                        Croisement_Mutation.croisment_et_mutation(Selection.uniform(p), Selection.uniform(p), liste_Qt);
                    }
                }
                if (type_selection.equals("par tournoi")) {
                    if (type_croisement.equals("Normale")) {
                        Croisement_Mutation.croisment_et_mutation(Selection.tournoi(p, taille_de_population), Selection.tournoi(p, taille_de_population), liste_Qt);
                    }
                }
                if (type_selection.equals("par roulette")) {
                    if (type_croisement.equals("Normale")) {
                        Croisement_Mutation.croisment_et_mutation(Selection.RouletteWheel(p), Selection.RouletteWheel(p), liste_Qt);
                    }
                }
                if (type_selection.equals("par rang")) {
                    if (type_croisement.equals("Normale")) {
                        Croisement_Mutation.croisment_et_mutation(Selection.RankSelection(p), Selection.RankSelection(p), liste_Qt);
                    }
                }
                if (type_selection.equals("RSS")) {
                    if (type_croisement.equals("Normale")) {
                        Individu tab[] = Selection.RSS(p);
                        Croisement_Mutation.croisment_et_mutation(tab[0], tab[1], liste_Qt);
                    }
                }
                if (type_selection.equals("SUS")) {
                    if (type_croisement.equals("Normale")) {
                       SelectionSus s  =   new   SelectionSus(p)  ; 
                        Individu tab[] = s.SUS() ;
                        for (int j = 0; j < tab.length; j +=2) {
                            Croisement_Mutation.croisment_et_mutation(tab[j], tab[j + 1], liste_Qt);
                        }

                    }
                }
                if (type_selection.equals("collateraux")) {
                    if (type_croisement.equals("Normale")) {
                        SelectionCollateraux s1 = new SelectionCollateraux(p);
                        SelectionCollateraux s2 = new SelectionCollateraux(p);
                        Croisement_Mutation.croisment_et_mutation(s1.selection_collateraux(), s2.selection_collateraux(), liste_Qt);
                    }
                }
                if (type_selection.equals("generation")) {
                    if (type_croisement.equals("Normale")) {
                        SelectionParGeneration s1 = new SelectionParGeneration(p);
                        SelectionParGeneration s2 = new SelectionParGeneration(p);
                        Croisement_Mutation.croisment_et_mutation(s1.selection_par_generation(), s2.selection_par_generation(), liste_Qt);
                    }
                }
                if (type_selection.equals("ascendance")) {
                    if (type_croisement.equals("Normale")) {
                        SelectionSurAscendance s1 = new SelectionSurAscendance(p);
                        SelectionSurAscendance s2 = new SelectionSurAscendance(p);
                        Croisement_Mutation.croisment_et_mutation(s1.selection_ascendance(), s2.selection_ascendance(), liste_Qt);
                    }
                }
                if (type_selection.equals("descendance")) {
                    if (type_croisement.equals("Normale")) {
                        if (i==0) {
                              Croisement_Mutation.croisment_et_mutation(Selection.uniform(p), Selection.uniform(p), liste_Qt);
                        } else {
                            SelectionSurDescendance s1 = new SelectionSurDescendance(p);
                        SelectionSurDescendance s2 = new SelectionSurDescendance(p);
                        Croisement_Mutation.croisment_et_mutation(s1.selection_descendance(), s2.selection_descendance(), liste_Qt);
                        }
                        
                    }
                }
                if (type_selection.equals("massale")) {
                    if (type_croisement.equals("Normale")) {
                        SelctionMassale s1  = new  SelctionMassale(p) ; 
                        SelctionMassale s2  = new  SelctionMassale(p) ; 
                         Croisement_Mutation.croisment_et_mutation(s1.selection1(), s1.selection2(), liste_Qt);
                    }
                }

            }

            /*
             nouveau  enfants 
             */
            System.out.println("-------------------Qt -----------------");
            affiche_liste(liste_Qt);

            /*
             union de  pt et  Qt
             */
            p.liste.addAll(liste_Qt);
            p_excel.add_population_excel(p);
            Solution s = new Solution(p);
            s.mellieur_solution(p);
            System.out.println("-------------------------------Rt-----------");
            p.populatioIsValide();

            /*
             évaluer la  population
             */
            p.evaluation();

            /*
             classement  les individus selon leur  rang et  distance
             */
            Classement.classement_individus(p);

            /*
             générer la  nouvelle  population
             */
            NouvellePopulation.creation_nouvelle_population(p);
          
           
            createSampleData_P_D(p.liste);
            createSampleData_P_T(p.liste);
            createSampleData_T_D(p.liste);

            n_generatoin++;
            
            liste_Qt.clear();
        }

        d.setVisible(false);
        createSampleDataSoltion_T_D();
        createSampleDataSolution_P_D();
        createSampleDatasolution_P_T();
        prix_duree_Collection.addSeries(series2);
        prix_duree_Collection.addSeries(series2_solution);
        prix_taux_Collection.addSeries(series);
         prix_taux_Collection.addSeries(series_solution);
        taux_dureeCollection.addSeries(series3);
        taux_dureeCollection.addSeries(series3_solution);
        f.add_panals(new generation_panel(prix_taux_Collection, prix_duree_Collection, taux_dureeCollection, 1 + " - " + nb_generation));
        f.add_panals(new generation_panel(p, "" + nb_generation));
        f.setVisible(true);
         Solution.solutionSansDoublons();
        Solution s = new Solution(p);
        s.mellieur_solution(p);
        f.setSolution(Solution.mellieur_solution());
        p_excel.write_close_excel();
               t2 = System.nanoTime();
               SelectionExcel.write(type_selection,(int) Configuration_Frame.taille_de_population.getValue(), Solution.solution_sans_doublons.size());
    }

    /*
     les  méthodes
     enregistrer les coordonnées de chaque individu
     */
    public void createSampleData_P_D(List<Individu> liste) {
        for (Individu individu : liste) {
            series2.add(individu.somme_sdp(), individu.somme_sdd());
        }
    }
     public void createSampleDataSolution_P_D() {
        for (Individu individu : Solution.liste) {
            series2_solution.add(individu.somme_sdp(), individu.somme_sdd());
        }
    }
    

    public void createSampleData_P_T(List<Individu> liste) {
        for (Individu individu : liste) {
            series.add(individu.somme_sdp(), individu.somme_sft());
        }

    }
     public void createSampleDatasolution_P_T() {
        for (Individu individu : Solution.liste) {
            series_solution.add(individu.somme_sdp(), individu.somme_sft());
        }

    }

    public void createSampleData_T_D(List<Individu> liste) {
        for (Individu individu : liste) {
            series3.add(individu.somme_sft(), individu.somme_sdd());
        }
       
    }
     public void createSampleDataSoltion_T_D() {
        for (Individu individu : Solution.liste) {
            series3_solution.add(individu.somme_sft(), individu.somme_sdd());
        }
       
    }

    public void affiche_liste(ArrayList<Individu> liste) {
        for (Individu individu : liste) {
            System.out.println(individu.tostring());
        }

    }

}
