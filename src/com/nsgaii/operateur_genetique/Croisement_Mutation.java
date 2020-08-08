package com.nsgaii.operateur_genetique;

import com.GUI.Configuration;
import com.GUI.Configuration_Frame;
import com.nsgaii.Individu;
import com.nsgaii.Population;
import com.nsgaii.Run_Class;
import com.tache.Librarie_Taches;
import java.util.ArrayList;

public class Croisement_Mutation {

    public Croisement_Mutation() {
    }
    /*
     touts  les  méthodes de cette  class  sont static 
     */

    /*
     méthode de  croisement 
     générer deux  nombres entier   a et  b  aléatoirement 
     " a " indice de  croisment  pour  le premier processus  et " b " pour le  deuxième 
     */
    public static void croisement(Individu parent1, Individu parent2) {
        /*
        selectionner une  tache dans  chaque  processus 
        */
        int indice1 = parent1.tache_utiliser().get((int) (parent1.tache_utiliser().size() * Math.random()));
        int indice2 = parent2.tache_utiliser().get((int) (parent2.tache_utiliser().size() * Math.random()));
        
        /*
        croiser  la  ligne  et  la colonne de chaque  processus  avec l'autre 
        */
        for (int i = 0; i < parent1.structure_de_processus.length; i++) {
            int a;
            a = parent1.structure_de_processus[i][indice1];
            parent1.structure_de_processus[i][indice1] = parent2.structure_de_processus[i][indice1];
            parent2.structure_de_processus[i][indice1] = a;
            //---
            a = parent1.structure_de_processus[indice1][i];
            parent1.structure_de_processus[indice1][i] = parent2.structure_de_processus[indice1][i];
            parent2.structure_de_processus[indice1][i] = a;
            //------------------------

            a = parent1.structure_de_processus[i][indice2];
            parent1.structure_de_processus[i][indice2] = parent2.structure_de_processus[i][indice2];
            parent2.structure_de_processus[i][indice2] = a;

            a = parent1.structure_de_processus[indice2][i];
            parent1.structure_de_processus[indice2][i] = parent2.structure_de_processus[indice2][i];
            parent2.structure_de_processus[indice2][i] = a;

        }

    }

    public static void mutation(Individu parent, ArrayList<Individu> Liste_Qt) {
        // a indice de mutation  :générer par  utilisateur (  probabilité  )   
        // b  2eme  indice  généer  aléatoirment 
        if (parent.tache_utiliser().size()>0) {
            int nb1 = (int) ((double) Configuration_Frame.mutation.getValue() * parent.tache_utiliser().size());
        int a = parent.tache_utiliser().get(nb1);
        int nb2 = (int) ((double) Math.random() * parent.tache_utiliser().size());
        int b = parent.tache_utiliser().get(nb2);
        for (int i = 0; i < parent.structure_de_processus.length; i++) {
            int nb = parent.structure_de_processus[i][a];
            parent.structure_de_processus[i][a] = parent.structure_de_processus[i][b];
            parent.structure_de_processus[i][b] = nb;
        }
        for (int j = 0; j < parent.structure_de_processus.length; j++) {
            int nb = parent.structure_de_processus[a][j];
            parent.structure_de_processus[a][j] = parent.structure_de_processus[b][j];
            parent.structure_de_processus[b][j] = nb;
        }
            recomposer_processus(parent);
      Liste_Qt.add(parent) ;
        }
        
    }
    /*
     executer  croisment et mutation 
     */

    public static void croisment_et_mutation(Individu parent1, Individu parent2,ArrayList<Individu> Liste_Qt) {
        /*
        donner  a chaque  individu selection son  parent  et  son  ID et ça  génération 
        */
        if ((parent1.tache_utiliser().size()>0 && parent2.tache_utiliser().size()>0) ) {
            parent1.setId_parent1(parent1.id);
        parent1.setId_parent2(parent2.id);
        parent2.setId_parent1(parent2.id);
        parent2.setId_parent2(parent1.id);
        parent1.setId();
        parent1.generation = Run_Class.n_generatoin;
       
        parent1.save(); // sauvgarder l'individu 
        parent2.setId();
        parent2.generation = Run_Class.n_generatoin;
       
        parent2.save();
        croisement(parent1, parent2);
        mutation(parent1, Liste_Qt);
        mutation(parent2, Liste_Qt);
        } 
       
    }
          /*
      créer les  liens  entres les  taches  utilisé 
    */
    public  static void  recomposer_processus(Individu parent) {
         int[][] structure= new int[Librarie_Taches.tache_liste.size()][Librarie_Taches.tache_liste.size()];
         for (int i = 0; i < parent.tache_utiliser().size(); i++) {
             int  n  =  parent.tache_utiliser().get(i)  ; 
             if (trouve_un(Librarie_Taches.liste_inputs, Librarie_Taches.tache_liste.get(n).input_liste) && trouve_un(Librarie_Taches.liste_outputs, Librarie_Taches.tache_liste.get(n).output_liste)) {
                 structure[n][n]   =  1  ; 
             }
             for (int j = 0; j < parent.tache_utiliser().size(); j++) {
                 if (trouve_un(Librarie_Taches.tache_liste.get(n).output_liste,  Librarie_Taches.tache_liste.get(j).input_liste)) {
                  structure[n][j]   =  1  ; 
                 }
             }  
        }
         parent.structure_de_processus = structure ; 
    }
    
    /*
    rechercher un élément commune entre deux listes
    */
     public static boolean trouve_un(ArrayList<Integer> list_out, ArrayList<Integer> list_in) {
        int i = 0;
        while (i < list_in.size()) {
            if (recherche(list_out, list_in.get(i))) {
                return true;
            } else {
                i++;
            }

        }
        return false;
    }
     /*
     rechercher un élément dans  une  liste 
     */
     public static  boolean recherche(ArrayList<Integer> list, int a) {
        boolean trouve = false;
        int i = 0;
        while (!trouve && i < list.size()) {
            if (list.get(i) == a) {
                trouve = true;
            } else {
                i++;
            }
        }
        return trouve;
    }
}
