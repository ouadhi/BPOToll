
package com.nsgaii.operateur_genetique;

import com.nsgaii.Individu;
import com.nsgaii.Population;
import static com.nsgaii.operateur_genetique.Selection.uniform;

/*
selection  massale  baser  sur  les  apparences de lindividu 
*/
public class SelctionMassale {
    Population population  ; 

    public SelctionMassale(Population population) {
        this.population = population;
    }
   
    /*
    selectionner l'individu  qui  a  la mellieur  valeur de sdp/sft
    */
     public  Individu selection_massale() {
        // selectioner  4 indifidu  aléatoirement 
         Individu individu = new Individu();
            Individu tableau [] = new  Individu[4] ; 
            for (int i = 0; i < tableau.length; i++) {
             tableau[i]  =   uniform(population) ; 
         }
            // calculer  sdp/sft et selectioner  le mellieur 
         double  division  = tableau[0].somme_sdp()/tableau[0].somme_sft() ; 
         individu =  tableau[0]  ; 
          for (int i = 1; i <tableau.length; i++) {
              double  d= 0 ; 
              if (tableau[i].somme_sft()==0) {
                    d  = Double.MAX_VALUE ; 
              }else{
                  d  = tableau[i].somme_sdp()/tableau[i].somme_sft() ;  
              }
           
              if (d<division) {
                individu =   tableau[i]  ; 
                division = d  ; 
              }
         }
       
        return individu;
        
    }
     
     /*
    selectionner l'individu  qui  a  la mellieur  valeur de sft entre  5 individu  choisie  aléatoirement 
    */
     public  Individu  selection1() {
         Individu  d  =  null  ; 
         Individu  tableau  []  =  new  Individu[5]   ;  
         for (int i = 0; i < tableau.length; i++) {
             tableau[i]  =  Selection.uniform(population)   ; 
         }
         
        double max  =  0   ; 
        
         for (int i = 0; i < tableau.length; i++) {
             if (tableau[i].somme_sft()>max) {
               d= tableau[i]  ; 
               max  = tableau[i].somme_sft() ;  
               
             }
             
         }
         return d  ; 
     }
     
     /*
    selectionner l'individu  qui  a  la mellieur  valeur de sdp entre  5 individu  choisie  aléatoirement 
    */
     public  Individu  selection2() {
         Individu  d  =  null  ; 
         Individu  tableau  []  =  new  Individu[5]   ;  
         for (int i = 0; i < tableau.length; i++) {
             tableau[i]  =  Selection.uniform(population)   ; 
         }
         
        double min  = tableau[0].somme_sdp()   ; 
        d=  tableau[0] ; 
        
         for (int i = 1; i < tableau.length; i++) {
             if (tableau[i].somme_sdp()<min) {
               d= tableau[i]  ; 
               min = tableau[i].somme_sdp() ;  
               
             }
             
         }
         return d  ; 
     }
}
