package com.nsgaii;

import com.GUI.Configuration_Frame;
import com.tache.TestValidation;
import java.util.ArrayList;

public class Solution {

    public static Individu solution = new Individu();
    public static int nb_solution;
    public static double max_fitness = 0;
    // la  liste des solution 
    public static ArrayList<Individu> liste = new ArrayList<>();
    // liste des solution  sans doublons 
     public static ArrayList<Individu> solution_sans_doublons = new  ArrayList<>() ; 
    public Population population;

    public Solution() {

    }
    
   
    public Solution(Population population) {
        this.population = population;
    }
       /*
        mellieur  solution 
    */
    public static Individu getSolution() {
        return solution;
    }

   

    public void mellieur_solution(Population p) {

        for (int i = 0; i < p.liste.size(); i++) {
            TestValidation test = new TestValidation(p.liste.get(i));
            /*
            la solution est l'individu   = 
            les  taches sont valide  
            taille des  tache  entre  taille min et  max  
            */
            if (test.isValide() && p.liste.get(i).tache_utiliser().size() <= (int) Configuration_Frame.max.getValue() && p.liste.get(i).tache_utiliser().size() >= (int) Configuration_Frame.min.getValue() && !trouve(p.liste.get(i).id)) {
                max_fitness = p.liste.get(i).fitness;
                p.liste.get(i).copy(solution);
                Individu d = new Individu();
                solution.copy(d);
                liste.add(d);
                nb_solution++;
                  
            }
        }

    }

    public void affiche_all_solution() {
        for (int i = 0; i < liste.size(); i++) {
            liste.get(i).affiche_individu();
        }

    }
  /*
    mellieur solution trouvée 
    */
    public static Individu mellieur_solution() {
        if (liste.isEmpty()) {
            return null;
        } else {
            /*
           meilleur solution est la solution de grande valeur de fitness
            */
            Individu d = liste.get(0);
            for (int i = 1; i < liste.size(); i++) {
                if (liste.get(i).fitness < d.fitness) {
                    d = liste.get(i);
                }
            }
            return d;

        }
    }
    
    public static  Individu solution_prix_taux ()  {
     if (liste.isEmpty()) {
            return null;
        } else {
            Individu d = liste.get(0);
            for (int i = 1; i < liste.size(); i++) {
                if ((liste.get(i).somme_sdp()/liste.get(i).somme_sft()) <(d.somme_sdp()/d.somme_sft())) {
                    d = liste.get(i);
                }
            }
            return d;
        }
    }
    
    /*
    rechercher un  individu  dans  une  liste  
    */
    public  static boolean  trouve ( int  id ) {
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).id == id  )  {
                return true   ; 
            }
        }
        return false  ; 
    
    }
     /*
   tester si deux individus sont égaux( matrice) 
    */
     public static  boolean egaux ( Individu d1  ,Individu d2 ) {
        for (int i = 0; i <d1.structure_de_processus.length; i++) {
            for (int j = 0; j < d1.structure_de_processus.length; j++) {
                if (d1.structure_de_processus[i][j]!=d2.structure_de_processus[i][j]) {
                    return false ; 
                }
            }
        }
        return true  ; 
    }
      /*
     supprimer les solution doublons 
     */
 public static void solutionSansDoublons() {
     solution_sans_doublons.add(liste.get(0)) ; 
     for (int i = 1; i < liste.size(); i++) {
         if (trouve(solution_sans_doublons, liste.get(i))== false) {
             solution_sans_doublons.add(liste.get(i)) ; 
         }
     }
 }
 /*
 tester si  une solution trouver  dans la liste des  solution 
 */
    public static  boolean trouve ( ArrayList<Individu> solutionsans , Individu d ) {
        for (int i = 0; i < solutionsans.size(); i++) {
            if (egaux(solutionsans.get(i), d)) {
                return true ; 
            }
        }
        return false  ; 
    }

}
