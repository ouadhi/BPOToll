package com.tache;

import java.util.ArrayList;

public class PRO {

    public ArrayList<Tache> tache_liste = new ArrayList<>(); // la  liste  des taches  dans  la  bibiothéque 
    public int matrice[][]; // matrice de processus 
    ArrayList<Integer> inputs_possible = new ArrayList<>();// les ressource d'entrée 
    ArrayList<Integer> outputs = new ArrayList<>();// les ressources de sortie 
    //  public ArrayList<Tache> tache_selectione = new ArrayList<>(); // les taches  selectionées 
    public ArrayList<Tache> liste1 = new ArrayList<>();
    public ArrayList<Tache> liste2 = new ArrayList<>();

    public ArrayList<Tache> tache_in1 = new ArrayList<>();
    public ArrayList<Tache> tache_in2 = new ArrayList<>();

    public ArrayList<Tache> tache_selectionee = new ArrayList<>();

    ArrayList<Integer> input_de_processus = new ArrayList<>();
    ArrayList<Integer> output_de_processus = new ArrayList<>();

    public PRO() {
     
        tache_liste.addAll(Librarie_Taches.tache_liste);
        matrice = new int[Librarie_Taches.tache_liste.size()][Librarie_Taches.tache_liste.size()];
        input_de_processus.addAll(Librarie_Taches.liste_inputs);
        output_de_processus.addAll(Librarie_Taches.liste_outputs);
       
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

    public int selection(int n) {
        return (int) (Math.random() * n);
    }

    public boolean trouve_un(ArrayList<Integer> list_out, ArrayList<Integer> list_in) {
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

    public void affiche_matrice() {
        System.out.println("---------Matrice-------");
        for (int i = 0; i < matrice.length; i++) {
            System.out.print(" " + i + " ");
            for (int j = 0; j < matrice.length; j++) {
                System.out.print(" " + matrice[i][j]);
            }
            System.out.println("");

        }
    }

    public boolean contien(ArrayList<Integer> liste2, ArrayList<Integer> liste) {// liste teneu dans liste 2
        int i = 0;
        boolean contien = true;
        while (i < liste.size() && contien) {
            if (recherche(liste2, liste.get(i))) {
                i++;
            } else {
                contien = false;
            }
        }
        return contien;
    }

    public void creation(int n) {
        inputs_possible.addAll(Librarie_Taches.liste_inputs)  ; 
         Tache t1 = tache_liste.get(selection(tache_liste.size()));
        //  System.out.println("tache 1 selectionnée " + t1.num);
        liste1.add(t1);
        Tache t2 = tache_liste.get(selection(tache_liste.size()));
        //   System.out.println("tache 2 selectionnée " + t2.num);
        liste1.add(t2);
        tache_selectionee.add(t1);
        tache_selectionee.add(t2);
        tache_liste.remove(t1);
        tache_liste.remove(t2);
        

        /*
         ajouter  les  outputs des  taches selectionnée  a  la  liste des inputs  possisbles  
         */
        inputs_possible.addAll(t1.output_liste);
       inputs_possible.addAll(t2.output_liste);

        if (trouve_un(t1.output_liste, t2.input_liste)) {
            matrice[t1.num][t2.num] = 1;
        }
        if (trouve_un(t2.output_liste, t1.input_liste)) {
            matrice[t2.num][t1.num] = 1;
        }
        if (trouve_un(t1.input_liste, input_de_processus) && trouve_un(t1.output_liste, output_de_processus)) {
            matrice[t1.num][t1.num] = 1;
        }
        if (trouve_un(t2.input_liste, input_de_processus) && trouve_un(t2.output_liste, output_de_processus)) {
            matrice[t2.num][t2.num] = 1;
        }

        int taille = 2;
        while (taille < n) {
            int j = 0;
            boolean selection = false;
            while (!selection) {
               // System.out.println("-----");
                Tache t = tache_liste.get(selection(tache_liste.size()));
                if (contien(inputs_possible, t.input_liste)) {
                    selection = true;
                    inputs_possible.addAll(t.output_liste);
                      taille++;
                  //   System.out.println("tache "+taille+" selectionée"+t.num);
                  
                    if (trouve_un(t.input_liste, input_de_processus) && trouve_un(t.output_liste, output_de_processus)) {
                        matrice[t.num][t.num] = 1;
                    }
                    for (int i = 0; i < tache_selectionee.size(); i++) {

                        if (trouve_un(t.output_liste, tache_selectionee.get(i).input_liste)) {
                            matrice[t.num][tache_selectionee.get(i).num] = 1;
                        }
                        if (trouve_un(tache_selectionee.get(i).output_liste, t.input_liste)) {
                            matrice[tache_selectionee.get(i).num][t.num] = 1;
                        }

                    }
                    tache_selectionee.add(t);
                    tache_liste.remove(t);
                }
            }

        }

    }

}
