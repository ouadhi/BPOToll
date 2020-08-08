
package com.nsgaii.operateur_genetique;

import com.nsgaii.Individu;
import com.nsgaii.Population;


public class SelectionSus {
  Population  population  ; 

    public SelectionSus(Population population) {
        this.population = population;
    }
  
    
    
     public   Individu[] SUS() {
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
     
         public  Individu[] SUS2() {
        /*
         calculer  le  nombre des individu selctionée
         */
        Individu tableau[];
        if (population.liste.size() % 2 == 0) {
            tableau = new Individu[population.liste.size()];
        } else {
            tableau = new Individu[population.liste.size() + 1];
        }

             
        //  le saute     ; 
        double saute = (somme_fitness(population) / tableau.length);
             System.out.println("*-**-*-*-**-*-*-*-*-**-*-*-*-**-*-*-*-*--"+somme_fitness(population));

        tri_population(population);

        // pointeur d'individu  a selectionée 
        double pointeur = 0;

        for (int i = 0; i < tableau.length; i++) {
            double somme = 0;
            int j = 0;
            boolean select = false;
            while (!select && j < population.liste.size()) {
               
                somme += population.liste.get(j).fitness;
                /*
                 si somme  supérieur ou égale a le  nombr  générer aléatoirement  return ce  individu 
                 */
                if (somme >= pointeur) {
                    Individu  d  =  new  Individu()   ;  
                    population.liste.get(j).copy(d);
                    tableau[i] =   population.liste.get(j);
                    select = true ; 
         
                } else {
                    j++;
                }
            }

            pointeur = pointeur + saute;
        }
        return tableau;
    }
       /*
                    trier  la  population selon  la  valeur de  fitness

         */
    
    public  void tri_population(Population p) {

        Individu x = null;
        for (int i = 0; i < p.liste.size(); i++) {
            for (int j = i + 1; j < p.liste.size(); j++) {
                if (p.liste.get(j).fitness < p.liste.get(i).fitness) {
                    x = p.liste.get(i);
                    p.liste.set(i, p.liste.get(j));
                    p.liste.set(j, x);
                }
            }
        }
    }

    /*
     somme fitness de tous la population 
     */
    public Double somme_fitness(Population population) {
        double somme = 0;
        for (int i = 0; i < population.liste.size(); i++) {
            if (!population.liste.get(i).getFitness().isNaN()) {
                somme+=population.liste.get(i).fitness ; 
            }
            
            
                    }
        return somme ;
    }

}
