
package com.tache;

import com.nsgaii.Individu;
import java.util.ArrayList;
/*
cette  classe  pour  tester  la  validité  de  inputs  et outputs de  processus (individu ) 
*/


public class TestValidation {
    Individu  individu  ;  // processus à  tester 

    public TestValidation(Individu individu) {
        this.individu = individu;
    }
    
    
    
    /*
   tester  la validation de  processus :   test  inptu  ,  output  est  les  taches intermedier 
    */
    public  boolean  isValide() {

       
        if (test_out() && test_in()&& tache_inter()) {
            return  true   ; 
        } else {
            return false  ;
        }
    }
    
    
    
    /*
    teste les inputs de  processus 
    */
    public boolean test_in() {
        ArrayList<Integer> liste_des_inputs =  new  ArrayList<>()   ;  
        for (int i = 0; i < individu.tache_utiliser().size(); i++) {
            int  t  =  individu.tache_utiliser().get(i)  ; 
            liste_des_inputs.addAll(Librarie_Taches.tache_liste.get(t).input_liste) ; 
        }
       
        return (contien(liste_des_inputs,Librarie_Taches.liste_inputs));
    }
    
    // teste les  ouputs de  processus 
    public boolean test_out() {
        ArrayList<Integer> liste_des_outputs =  new  ArrayList<>()   ;  
        for (int i = 0; i < individu.tache_utiliser().size(); i++) {
            int  t  =  individu.tache_utiliser().get(i)  ; 
            liste_des_outputs.addAll(Librarie_Taches.tache_liste.get(t).output_liste) ; 
        }
       
        return (contien(liste_des_outputs,Librarie_Taches.liste_outputs));
    }
     
    public boolean test_in_out( int k) {
        /*
         test  input
         */
        // ressousrce entrer a  la tache  dans  processu tetser 
        ArrayList<Integer> ressource_in = new ArrayList<>();

        // fixer les  tache  connecter  avec  la  tache  K
        ArrayList<Integer> tache_connecter = new ArrayList<>();
        for (int i = 0; i < individu.structure_de_processus.length; i++) {
            if (individu.structure_de_processus[i][k] == 1) {
                tache_connecter.add(i);
            }
        }

        for (int i = 0; i < tache_connecter.size(); i++) {
            int n = tache_connecter.get(i);
            for (int j = 0; j < Librarie_Taches.tache_liste.get(n).output_liste.size(); j++) {
                ressource_in.add(Librarie_Taches.tache_liste.get(n).output_liste.get(j));
            }
        }

        return contien(ressource_in, Librarie_Taches.tache_liste.get(k).input_liste);
    }
    
    
    /*
    tester  la  validation des  taches  intermédiaire
    */
    public  boolean  tache_inter()  {
    boolean valide = true ; 
        for (int i = 0; i < individu.tache_utiliser().size(); i++) {
            int  n  =  individu.tache_utiliser().get(i)   ;
           
            if (!test_tache( n )) {
                return  false ; 
            }
        }
        return true  ; 
    
    }
    
    // tester  si  liste  exsiste dans  liste 2
    public  boolean contien(ArrayList<Integer> liste2, ArrayList<Integer> liste) {
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
   
     /*
        recherché à un nombre dans une liste
    */
    public  boolean recherche(ArrayList<Integer> list, int a) {
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
    
    
    public  boolean test_tache (int  n_tache  )  {
        ArrayList<Integer>  liste_in  =  new  ArrayList<>()  ; 
        liste_in.addAll(Librarie_Taches.liste_inputs) ; 
        for (int i = 0; i < individu.tache_utiliser().size(); i++) {
            if (individu.tache_utiliser().get(i)!= n_tache) {
                int  n  =  individu.tache_utiliser().get(i)   ; 
                liste_in.addAll(Librarie_Taches.tache_liste.get(n).output_liste)   ; 
            }
        }
        return  trouve_un( liste_in, Librarie_Taches.tache_liste.get(n_tache).input_liste) ; 
        
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
}
