
package com.tache;

import java.util.ArrayList;
/*
créer une liste  pour  enregister  la  bibiothéque  des taches 
*/
public class Librarie_Taches {
    // la classe est static pour la réutiliser chaque fois sans la déclarer comme paramètre.
    
    public static ArrayList<Tache> tache_liste  = new  ArrayList<>() ; // la  liste  des taches  dans  la  bibiothéque 
   
    public static ArrayList<Tache> processus_initial  = new  ArrayList<>() ; // liste des taches  du  processus  intial
    public static ArrayList<Integer> liste_inputs =  new  ArrayList<>() ; // les ressources  d'entrée  pour une  tache 
    public static ArrayList<Integer> liste_outputs =  new  ArrayList<>() ; // les  ressources de sortie pour  une  tache 
  
    public static  int  input  ;  
    public static  int  output   ; 

    public Librarie_Taches() {   
    }
    // ajouter  une  tache  au bibiothéque  
     public static  void add_tache (Tache T)  {
         tache_liste.add(T) ; 
     } 
     // ajouter  une  tache  au  processus  initial 
      public static  void add_tache_initial (Tache T)  {
         processus_initial.add(T) ; 
     } 
     //ressource d'entrée du  processus  initial 
     public static int  getinput()  {
      return processus_initial.get(0).input_liste.get(0) ; 
     }
       //ressource de sortie  du  processus  initial 
     public static int  getoutput()  {
      return processus_initial.get(processus_initial.size()-1).output_liste.get(0) ;  
     }
     
      
    
     
}
