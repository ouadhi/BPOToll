
package com.nsgaii;


import java.util.ArrayList;
import java.util.List;


public class Classement {

    public Classement() {
    }
     // comment classé  un individu dans front
    
    
    
    /*
     affecter a chaque  individu un  fornt  ( 0 ------ N ) 
     */
     public static void  regle_classement (Individu div  ){
      double   a  =  div.fitness%8 ;  
      div.front  = (int) a  ;      
    }
     
     /*
     affecter a chaque  individu un  fornt  ( 0 ------ N ) 
     */
      public static void classement_individus(Population p ) {
          tri_population(p);
          int  i =  0  ;  
          int  front =  0 ;  
          while (i<p.liste.size()) {              
              int j  =  0 ; 
              /*
              le  nombre des  individus dans chaque  rang est 50 
              */
              while (j<50 && i<p.liste.size()){                  
                  p.liste.get(i).front =  front  ; 
                  i++ ; 
                  j++ ;  
              }
              front ++ ; 
          }
       tri_par_rang(p);
       classement_all(p);
    }
    
     
    
    public static void tri_par_rang(Population p ) {
     Individu x;
        for (int i = 0; i < p.liste.size(); i++) {
            for (int j = i + 1; j < p.liste.size(); j++) {
                if (p.liste.get(j).front <p.liste.get(i).front) {
                     x = p.liste.get(i).clone() ; 
                     p.liste.set(i, p.liste.get(j)) ; 
                     p.liste.set(j, x) ;               
                }
            }
        }
    }
    /*
     indice de première occurrence de rang r
    */
    public static int first ( int r ,  Population p ) {
        for (int i = 0; i < p.liste.size(); i++) {
            if (p.liste.get(i).front== r) {
                return i ; 
            }
        }
        return -1 ; 
    }
     /*
     indice de dernier occurrence de rang r
    */
    public static int laste ( int r ,  Population p)  {
        if (first(r, p) == -1 ) {
            return -1 ; 
        }else{
     for (int i = first(r, p); i <p.liste.size() ; i++) {
            if (p.liste.get(i).front!= r) {
                return i-1 ; 
            }
        }
     return p.liste.size()-1 ; 
    }
    }
    
    /*
    le  rang maximale  affecter  
    */
    public static int max_front (Population p ){
      int   max  =  0  ;  
        for (Individu d : p.liste) {
            if (d.front>max) {
                max =  d.front ; 
            } 
        }
    return max ; 
    }
    public static void  trier_le_rang (int r , Population p )  {
        int d  =  first(r, p)  ;  
        int f  =  laste(r, p)+1  ; 
         Individu x ;
            for (int i = d; i < f ; i++) {
            for (int j = i + 1; j < f; j++) {
                if (p.liste.get(j).fitness<p.liste.get(i).fitness) {
                     x = p.liste.get(i).clone() ; 
                     p.liste.set(i, p.liste.get(j)) ; 
                     p.liste.set(j, x) ;               
                }
            }
        }
    }
    
    /*
    trier  la  population selon  la  valeur de  fitness
    */
    public static void  tri_population( Population p ) {
        
         Individu x ;
            for (int i = 0; i < p.liste.size() ; i++) {
            for (int j = i + 1; j <  p.liste.size(); j++) {
                if (p.liste.get(j).fitness<p.liste.get(i).fitness) {
                     x = p.liste.get(i).clone() ; 
                     p.liste.set(i, p.liste.get(j)) ; 
                     p.liste.set(j, x) ;               
                }
            }
        }
    }
    /*
    appliquer  crowdin distance 
    */
     public static void  classement_all (Population p  )  {
        int  max  = max_front(p) ; 
        for (int i = 0; i < max+1 ; i++) {
            trier_le_rang(i, p);
            crowding(i, p);
            tri_le_rang_distance(i, p);
        }
    }
     public static void  crowding (int r ,  Population p)  {
       int d  =  first(r, p)  ;  
        int f  =  laste(r, p)  ; 
        /*
        calculer  la distance :  
       1- distance 1ere  element = max  value  
        2- distance dernier  element = max  value 
       distance (i) =  fitnes (i-1 )  - fitnes(i+1) 
       */
        p.liste.get(d).distance = Integer.MAX_VALUE;
         p.liste.get(f).distance= Integer.MAX_VALUE;
        for (int i = d+1; i < f-1; i++) {
             p.liste.get(i).distance =  (p.liste.get(i).distance + ( p.liste.get(i -1).fitness - p.liste.get(i + 1).fitness));
        }
     }
     public static void  initialisation_distance(Population p)  {
        for (Individu indi : p.liste) {
         indi.distance =  0  ;  
        }
    }
    /*
    trier chaque rang  selon  la  valeur de  fitness
    */ 
    public static void  tri_le_rang_distance (int r , Population p ) {
        int d  =  first(r, p)  ;  
        int f  =  laste(r, p)+1  ; 
         Individu x ;
            for (int i = d; i < f ; i++) {
            for (int j = i + 1; j < f; j++) {
                if (p.liste.get(j).distance>p.liste.get(i).distance) {
                     x = p.liste.get(i).clone() ; 
                     p.liste.set(i, p.liste.get(j)) ; 
                     p.liste.set(j, x) ;               
                }
            }
        }
    }
}
