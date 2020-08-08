package com.GUI;

import java.io.File;

public class Configuration {
   public int nb_population  ;
   public  int  nb_generation ;  
   public  String  selection  ;  
   public  Double  croisement ;  
   public  Double mutation  ;  
   public  String processus ; 
   public  String  bibio  ; 
   public int taille_max  ;  
   public  int  taille_min  ;  

    public Configuration(int nb_population, int nb_generation, String selection, Double croisement, Double mutation, String processus, String bibio, int taille_max, int taille_min) {
        this.nb_population = nb_population;
        this.nb_generation = nb_generation;
        this.selection = selection;
        this.croisement = croisement;
        this.mutation = mutation;
        this.processus = processus;
        this.bibio = bibio;
        this.taille_max = taille_max;
        this.taille_min = taille_min;
    }
   

   
   
   
    
}
