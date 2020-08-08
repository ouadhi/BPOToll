package com.nsgaii;

import com.GUI.Configuration;
import com.GUI.Configuration_Frame;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import com.tache.Librarie_Taches;
import com.tache.PRO;
import com.tache.Tache;
import com.tache.TestValidation;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Individu implements Cloneable {
    /*
     individu = processus  ,  
     chaque  processus  à  : 
     Liste :  Structure de  processus  
     fornt , distance  , fitness 
     */

    static int nb = 1; // compteur  de  ID 
    public int id;
    public int[][] structure_de_processus = new int[Librarie_Taches.tache_liste.size()][Librarie_Taches.tache_liste.size()];
    public double fitness;
    public int front;
    public double distance;
    public int generation;
    public int id_parent1;
    public int id_parent2;
   

    // constructeur
    public Individu() {
        remplir();
        this.fitness = calcul_fitness();
        this.front = 0;
        this.distance = 0;
       
       
    }

    public Individu(int a) {
        structure_de_processus = new int[51][51];
        for (int i = 0; i < structure_de_processus.length; i++) {
            for (int j = 0; j < structure_de_processus.length; j++) {
                structure_de_processus[i][j] = 0;
            }
        }
        this.fitness = calcul_fitness();
        this.front = 0;
        this.distance = 0;
    }

    public Double getFitness() {
        return fitness;
    }

    // pour  remplir la liste 
    /*
     min  =  La  taille  minimale de  processus  
     max  =  La  taille  maximale de  processus 
     les  deux paramtre  sont saisé par  utilisateur 
     */
    public void remplir() {
        for (int i = 0; i < structure_de_processus.length; i++) {
            for (int j = 0; j < structure_de_processus.length; j++) {
                structure_de_processus[i][j] = 0;
            }
        }
        /*
         la taille de  ce  processus  :  nombre  aléatoire génére  entre  la taille  maximale et  minimale  de processus 
         */
        int taille_de_individu = (int) ((Math.random() * ((int) Configuration_Frame.max.getValue() - (int) Configuration_Frame.min.getValue())) + (int) Configuration_Frame.min.getValue());
        PRO p  =  new  PRO()  ;
         p.creation(taille_de_individu) ; 
        
        this.structure_de_processus = p.matrice ; 
     

    }

    public void setId() {
        this.id = nb;
        nb++;

    }

    // pour  calculer fitness 
    /*
     1- parcourir  le  tableau  et récupéré la ressource consommer par chaque  la  tache  
     */
    public double calcul_fitness() {
        double sc = Math.sqrt(Math.pow(somme_sdd(), 2) + Math.pow(somme_sdp(), 2));
        double ct = Math.sqrt(Math.pow(somme_sft(), 2) + Math.pow(somme_sdp(), 2));
        double ts = Math.sqrt(Math.pow(somme_sft(), 2) + Math.pow(somme_sdd(), 2));
        /*
         la fonction objective pour l’optimisation multicritères de nos processus métier
         
         */
        double fit = sc / (2 * Math.sqrt(1 - Math.pow((Math.pow(ts, 2) + Math.pow(ct, 2) - Math.pow(sc, 2)) / (2 * ts * ct), 2)));
        return fit;
    }
    /*
     la durée  de  processus  =  la  somme du durée de chaque tache  
     */

    public int somme_sdd() {
       
        int somme  =  0;
        for (int i = 0; i < tache_utiliser().size(); i++) {
            int n_tache = tache_utiliser().get(i);
            somme = somme + Librarie_Taches.tache_liste.get(n_tache).getSdd();
        }
        return somme ;
    }
    /*
     le prix  de  processus  =  la  somme du prix de chaque tache  
     */

    public int somme_sdp() {
        int somme = 0;
        for (int i = 0; i < tache_utiliser().size(); i++) {
            int n_tache = tache_utiliser().get(i);
            somme = somme + Librarie_Taches.tache_liste.get(n_tache).getSdp();
        }
        return somme ;
    }
    /*
     le taux  de  processus  =  la  somme du taux de chaque tache  
     */

    public int somme_sft() {
        int somme = 0;
        for (int i = 0; i < tache_utiliser().size(); i++) {
            int n_tache = tache_utiliser().get(i);
            somme = somme + Librarie_Taches.tache_liste.get(n_tache).getSft();
        }
        return somme;
    }

    public void setId_parent1(int id_parent1) {
        this.id_parent1 = id_parent1;
    }

    public void setId_parent2(int id_parent2) {
        this.id_parent2 = id_parent2;
    }

    /*
     recalculé le fitnes
     */
    public void evl_individu() {
        this.fitness = 0;
        double sc = Math.sqrt(Math.pow(somme_sdd(), 2) + Math.pow(somme_sdp(), 2));
        double ct = Math.sqrt(Math.pow(somme_sft(), 2) + Math.pow(somme_sdp(), 2));
        double ts = Math.sqrt(Math.pow(somme_sft(), 2) + Math.pow(somme_sdd(), 2));
        /*
         la fonction objective pour l’optimisation multicritères de nos processus métier
         
         */
        this.fitness = sc / (2 * Math.sqrt(1 - Math.pow((Math.pow(ts, 2) + Math.pow(ct, 2) - Math.pow(sc, 2)) / (2 * ts * ct), 2)));

    }
    /*
    les taches  utiliser dans  le  processus 
    */
    public ArrayList<Integer> tache_utiliser() {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        // parcourir la  matrice 
        for (int i = 0; i < this.structure_de_processus.length; i++) {
            for (int j = 0; j < this.structure_de_processus.length; j++) {
                /*
                si la case  i,j  = 1 ajoutet  i et  j a la  liste  des  taches utliliser  
                */
                if (this.structure_de_processus[i][j] == 1) {
                    l1.add(i);
                    l1.add(j);
                }
            }
        }
         /*
        supprimer  les  taches  doublons 
        */
        for (int i = 0; i < l1.size(); i++) {
            if (recherche(l2, l1.get(i)) == false) {
                l2.add(l1.get(i));
            }
        }
        return l2;
    }
    /*
     les  taches des  inputs 
    */
    public ArrayList<Integer> get_tache_in() {
        ArrayList<Integer> in = new ArrayList<>();
        for (int i = 0; i < this.tache_utiliser().size(); i++) {
            int k = tache_utiliser().get(i);
            boolean is_in = true;
            for (int j = 0; j < structure_de_processus.length; j++) {
                if (structure_de_processus[j][k] == 1) {
                    is_in = false;
                }
            }
            if (is_in) {
                in.add(k);
            }
        }
        return in;
    }
   /*
    tache  des  ouputs 
    */
    public ArrayList<Integer> get_tache_out() {
        ArrayList<Integer> out = new ArrayList<>();
        for (int i = 0; i < this.tache_utiliser().size(); i++) {
            int k = tache_utiliser().get(i);
            boolean is_out = true;
            for (int j = 0; j < structure_de_processus.length; j++) {
                if (structure_de_processus[k][j] == 1) {
                    is_out = false;
                }
            }
            if (is_out) {
                out.add(k);
            }
        }
        return out;
    }

    public ArrayList<Integer> sauf_in() {
        ArrayList<Integer> sauf_in = new ArrayList<>();
        for (int i = 0; i < tache_utiliser().size(); i++) {
            int n = tache_utiliser().get(i);
            if (!recherche(get_tache_in(), n)) {
                sauf_in.add(n);
            }
        }
        return sauf_in;
    }
    
     public ArrayList<Integer> sauf_in_out() {
        ArrayList<Integer> sauf_in_out = new ArrayList<>();
        for (int i = 0; i < tache_utiliser().size(); i++) {
            int n = tache_utiliser().get(i);
            if (!recherche(get_tache_in(), n) && !recherche(get_tache_out(), n)) {
                sauf_in_out.add(n);
            }
        }
        return sauf_in_out;
    }

    public boolean recherche(ArrayList<Integer> list, int a) {
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

    public void affiche_individu() {
        for (int i = 0; i < structure_de_processus.length; i++) {
            for (int j = 0; j < structure_de_processus.length; j++) {
                System.out.print(structure_de_processus[i][j]);
            }
        }
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Individu{" + "fitness=" + fitness + ", front=" + front + ", distance=" + distance + '}';
    }
    /*
     copie  ce  individu dans l'individu  destination
     */

    public void copy(Individu individu_destination) {
        for (int i = 0; i < this.structure_de_processus.length; i++) {
            for (int j = 0; j < this.structure_de_processus.length; j++) {
                individu_destination.structure_de_processus[i][j] = this.structure_de_processus[i][j];
            }
        }
        individu_destination.id = this.id;
        individu_destination.evl_individu();
    }

    public String tostring() {
        return id + "-" + generation + "-" + id_parent1 + "-" + id_parent2 + "-" + fitness + "-" + tache_utiliser().size();
    }
    /*
     cette  méthode  pour  enregistrer  l'individu  dans  un  fichier  txt 
     */

    public void save() {
        try {
            FileWriter file = new FileWriter("file.txt", true);
            BufferedWriter write = new BufferedWriter(file);
            write.append(tostring());
            write.newLine();
            write.close();
            file.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public Individu clone() {
        try {
            Individu individu = (Individu) super.clone();
            return individu;

        } catch (Exception e) {
            return null;
        }

    }
}
