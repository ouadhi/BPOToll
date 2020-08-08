package com.nsgaii.operateur_genetique;

import com.nsgaii.Individu;
import com.nsgaii.Population;
import java.util.ArrayList;
import java.util.Random;

public class Selection {

    public Selection() {

    }
    /*
     selection  uniform 
     */

    public static Individu uniform(Population population)  {
        /*
         générer  un  nombre  aléatoirement  ( indice de  element  selection  )
         */
        int a = (int) (Math.random() * population.liste.size());
        /*
         copie l'elemente selectionnée  dans un nouveau  individu  parent
         */
         Individu  indi  =  new  Individu()  ; 
         population.liste.get(a).copy(indi);
        return  indi ;  
    }

    /*
     selection  pa  tournoi 
     */
    public static Individu tournoi(Population population, int taille_de_tournoi){
        //  individu selectionnée
        Individu parent = new Individu();
        // les  individus de tournoi 
        Individu tab_tournoi[] = new Individu[taille_de_tournoi];
        //  remplir  la  tableau " tab tournoi"  alétoirement 
        for (int i = 0; i < taille_de_tournoi; i++) {
            /*
             générer  un  nombre  aléatoirement  ( indice de  element  selection  )
             */
            int a = (int) (Math.random() * population.liste.size());
            tab_tournoi[i] = population.liste.get(a);
        }

        /*
         choisir  le  meilleur element dans  la  tournoi 
         */
        int indice_meilleur = 0;
        double max_fitness = tab_tournoi[0].fitness;
        for (int i = 0; i < tab_tournoi.length; i++) {
            if (tab_tournoi[i].fitness<max_fitness) {
                indice_meilleur = i;
            }
        }

        /*
         copie l'elemente selectionnée  dans un nouveau  individu  parent
         */
       tab_tournoi[indice_meilleur].copy(parent); 
      
        return parent;
    }

    /*
     selection Roulette Wheel 
     */
    public static Individu RouletteWheel(Population population) {
        Individu individu = new Individu();

        /*
         cacluler  la sommme  des fitness 
         */
        double somme_fitness = 0;
        for (int i = 0; i < population.liste.size(); i++) {
            somme_fitness += population.liste.get(i).fitness;
        }
        /*
         générer un nombre aléatoire entre   et  la  sommme des  fitness 
         */
        double rand = (double) (Math.random() * somme_fitness);
       
        double somme = 0;

        for (int i = 0; i < population.liste.size(); i++) {
            somme += population.liste.get(i).fitness;
            /*
            si somme  supérieur ou égale a le  nombr  générer aléatoirement  return ce  individu 
            */
            if (somme >= rand) {
              population.liste.get(i).copy(individu);
                return individu;
            }
        }
        return individu;
    }
    
    //------------------------------------------------------- Rank selection  méthode ----------------------------------------------------
    public static  Individu RankSelection(Population p ) {
    Individu individu  =  new  Individu()  ;
     /*
    creation des  individu_rank a partir du  les  individus de  la  population et  stocker  dans  un  liste " list_rank " 
    */ 
        tri_population(p);
        ArrayList<Individu_Rank> list_rank  =  new  ArrayList<>()  ; 
        for (int i = 0; i < p.liste.size(); i++) {
            Individu_Rank  ind_rang =  new  Individu_Rank(p.liste.get(i)) ;
            list_rank.add(ind_rang)  ; 
        }
        
        //  générer  un nombre aléatoire entre  ( 1 et  le  rang  max  )
        int  random_nombre =  (int)(Math.random()*somme_rang(list_rank))  ;
        int rang = 0 ; 
        for (int i = 0; i < list_rank.size(); i++) {
            rang += list_rank.get(i).rang ; 
            if (rang>=random_nombre) {
                  list_rank.get(i).individu.copy(individu);
                return individu ; 
            }
        }
    return individu ; 
    }
    
    
    /*
    tri la  liste  des  individus et  effectuer a chaque  individu un rang 
    */
    public  static void  tri_rang ( ArrayList<Individu_Rank>  liste ) {
     /*
        tri ascendant 
        */
   Individu_Rank  x  =  new  Individu_Rank()  ; 
        for (int i = 0; i < liste.size(); i++) {
            for (int j = i + 1; j < liste.size(); j++) {
                if (liste.get(j).individu.fitness <liste.get(i).individu.fitness) {
                     x = liste.get(i); 
                    liste.set(i, liste.get(j) ) ; 
                    liste.set(j, x)  ;        
                }
            }
        }
        /*
      effectuer un rang  a  chaque  element 
        */
        int  rang  = 1    ; 
        for (int i = 0; i < liste.size(); i++) {
            liste.get(i).rang = rang  ;  
            rang ++ ; 
        }
    
    }
    /*
    le rang maximale 
    */
     public static int  max_rang (ArrayList<Individu_Rank>  liste ) {
     int  max  =    0   ; 
         for (int i = 0; i < liste.size(); i++) {
            
            if (liste.get(i).rang > max ) {
                max = liste.get(i).rang ; 
            }
        
         }
     return max   ; 
     }
     
     public  static  int somme_rang(ArrayList<Individu_Rank>  liste){
         int  somme  =  0   ;
          for (int i = 0; i < liste.size(); i++) {
            
           somme+= liste.get(i).rang ; 
         }
          return somme  ; 
     }
     //------------------------------------------------------------------------
     /*
      Remainder Stochastic Sampling  
     */
     
     public static Individu[] RSS(Population population) {
       
      Individu [] tableau =  new  Individu[2]  ; 
      Individu [] tableau_candidat =  new  Individu[4]  ; 
        //  selection  un  individu  aléatoirement 
      tableau[0] =   uniform(population) ; 
      
      tableau[1] = null ; 
      // phi  est  le  nombre d'or
         double phi  =  1.681  ; 
         double compare  =  Double.MAX_VALUE ;
         
         for (int i = 0; i < tableau_candidat.length; i++) {
             tableau_candidat[i] =  uniform(population) ;
         }
         /*
         2eme  individu  selctionnée  est  :  résultat de  division plus  proche  a  le  nombre d'or 
         */
         for (int i = 0; i <tableau_candidat.length; i++) {
             /*
             diviser chaque  individu sur  1ere  individu selectionée
             ensuit  calculer  la distance  Entre eux  
             */
             double  a  =  tableau[0].fitness/tableau_candidat[i].fitness ; 
             double b  =  Math.abs(a-phi) ; 
             /*
             selectionée  l'individu le  plus  proche 
             */
             if (b<compare) {
                 compare  =  b   ; 
               tableau[1] =tableau_candidat[i] ;
             }
             
         }
         return tableau   ; 
     
     }
 //*************************************************************** Stochastic Universal Sampling *******************************************************
     /*
     sélectionne tous les parents simultanément
     */
     public static  Individu[] SUS(Population population) {
        Individu tableau  [] ; 
         if (population.liste.size()%2 == 0) {
             tableau =  new  Individu [population.liste.size()] ;  
         } else {
              tableau =  new  Individu [population.liste.size()+1] ;  
         }
         for (int i = 0; i < tableau.length; i++) {
             int  a  =  (int)(Math.random()*population.liste.size())  ;
             Individu d = new  Individu() ; 
             population.liste.get(a).copy(d);
             tableau[i] =d ;
         }
     return tableau ; 
     }
     
     
     
    
     public static void  tri_population( Population p ) {
        
         Individu x ;
            for (int i = 0; i < p.liste.size() ; i++) {
            for (int j = i + 1; j <  p.liste.size(); j++) {
                if (p.liste.get(j).fitness>p.liste.get(i).fitness) {
                     x = p.liste.get(i).clone() ; 
                     p.liste.set(i, p.liste.get(j)) ; 
                     p.liste.set(j, x) ;               
                }
            }
        }
    }
}
