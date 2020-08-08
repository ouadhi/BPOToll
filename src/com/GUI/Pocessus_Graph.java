package com.GUI;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import com.nsgaii.Individu;
import com.tache.Librarie_Taches;
import com.tache.objet_int;
import java.util.ArrayList;
import javax.swing.JPanel;
/*
 cette  class générer  le  graphe de chaque  processus
 */

public class Pocessus_Graph extends JPanel {

    Individu individu;

    public Pocessus_Graph(Individu individu) {
        this.individu = individu;
    }

    /*
    rechercher à un nombre dans une liste 
    */
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
     
       /*
       construire une conception de processus a partire d'une matrice carrée
    */
    public mxGraphComponent graph_de_processu() {

        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();
        graph.getModel().beginUpdate();
        ArrayList<objet_int> liste_object = new ArrayList<>();
        try {
            // debut
            Object v1 = graph.insertVertex(parent, null, "start", 10, 100, 80, 30);
            // fin 
            Object v2 = graph.insertVertex(parent, null, "end", 800 , 100, 80, 30);
            

            /*
            les  premiers  taches de  processus 
            */
            int x  = 200   ; // emplacemet  
            int  y  =  70   ; 
            for (int i = 0; i < individu.get_tache_in().size(); i++) { 
                 int   n  =  individu.get_tache_in().get(i) ; 
                 String resource  = "in"+ Librarie_Taches.tache_liste.get(n).input_liste.toString()+" out"+Librarie_Taches.tache_liste.get(n).output_liste.toString() ; 
                Object v = graph.insertVertex(parent, null, "Tache " + individu.get_tache_in().get(i), x, y, 80, 30);//  création du  noeud
                objet_int obj = new objet_int(v, individu.get_tache_in().get(i));//sauvegarder chaque noeud créer dans une liste
                 liste_object.add(obj);
                  graph.insertEdge(parent, null,Librarie_Taches.tache_liste.get(n).input_liste.toString() , v1, v);// relier  le noeud créer avec le  noeud de  départ 
                y += 40 ; 
            }
            
            /*
             les  derniers  tache de  processus 
            */
               x  = 600   ;  
             y  =  70   ; 
            for (int i = 0; i < individu.get_tache_out().size(); i++) { 
                  int   n  =  individu.get_tache_out().get(i) ; 
                  String resource  = "in"+ Librarie_Taches.tache_liste.get(n).input_liste.toString()+" out"+Librarie_Taches.tache_liste.get(n).output_liste.toString() ; 
                Object v = graph.insertVertex(parent, null, "Tache " + individu.get_tache_out().get(i), x, y, 80, 30);//  création du  noeud
                objet_int obj = new objet_int(v, individu.get_tache_out().get(i));//sauvegarder chaque noeud créer dans une liste
                liste_object.add(obj) ;
                  graph.insertEdge(parent, null, Librarie_Taches.tache_liste.get(n).output_liste.toString() , v, v2);// relier  le noeud créer avec le  noeud de  fin
                  y += 40 ; 
            }
            
            /*
            les  tache intermédiaire
            */
             x  = 400  ;  
             y  =  70   ; 
            for (int i = 0; i < individu.sauf_in_out().size();  i++) {
                int   n  =  individu.sauf_in_out().get(i) ; 
                  String resource  = "in"+ Librarie_Taches.tache_liste.get(n).input_liste.toString()+" out"+Librarie_Taches.tache_liste.get(n).output_liste.toString() ; 
                 Object v = graph.insertVertex(parent, null, "Tache " + individu.sauf_in_out().get(i), x, y, 80, 30);//  création du  noeud
                objet_int obj = new objet_int(v, individu.sauf_in_out().get(i));//sauvegarder chaque noeud créer dans une liste
                liste_object.add(obj);
                y += 60 ; 
            }

            /*
            création les liens entre les noeuds
            */
            for (int i = 0; i < liste_object.size(); i++) {
                for (int j = 0; j < liste_object.size(); j++) {
                    /*
                    tester si  il y a une  relation  entre  chaque  tache  avec  les  autres 
                    */
                    int  ni  =  liste_object.get(i).tach   ; 
                    int nj  =  liste_object.get(j).tach   ; 
                    /*
                    si  il y une  relation entre deux tache différent relier les deux  taches entre  aux  
                    */
                    if (i != j && individu.structure_de_processus[liste_object.get(i).tach][liste_object.get(j).tach] == 1) {
                        graph.insertEdge(parent, null, Librarie_Taches.tache_liste.get(ni).output_liste.toString()+" "+Librarie_Taches.tache_liste.get(nj).input_liste.toString(), liste_object.get(i).obj, liste_object.get(j).obj);
                    }
                    /*
                    si  il y une  relation avec ce même  relier la tache  avec  le  noeud de  départ  et le  noeud de  fin
                    */
                    if (i == j && individu.structure_de_processus[liste_object.get(i).tach][liste_object.get(i).tach] == 1) {
                        graph.insertEdge(parent, null,Librarie_Taches.tache_liste.get(ni).input_liste.toString() , v1, liste_object.get(j).obj);
                        graph.insertEdge(parent, null, Librarie_Taches.tache_liste.get(nj).output_liste.toString(), liste_object.get(j).obj, v2);
                    }
                }

            }

        } finally {
            graph.getModel().endUpdate();
        }
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        return graphComponent;

    }

    public boolean recherche2(ArrayList<objet_int> list, int a) {
        boolean trouve = false;
        int i = 0;
        while (!trouve && i < list.size()) {
            if (list.get(i).tach == a) {
                trouve = true;
            } else {
                i++;
            }
        }
        return trouve;
    }

       
   
}
