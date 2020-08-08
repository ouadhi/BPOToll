
package com.nsgaii.operateur_genetique;

import com.nsgaii.Individu;
import com.nsgaii.Population;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class SelectionSurDescendance {
   Population  p  ;
     ArrayList<IndividuMoyenne> liste = new ArrayList<>();

    public SelectionSurDescendance() {
    }

    public SelectionSurDescendance(Population p) {
        this.p = p;
    }
   
    
    
    public void affiche_descendance(int  id ){
        try {
            String tableau =  chereche_individu(id)  ; 
            ArrayList<String> liste  =  new  ArrayList<>()  ; 
            FileReader file = new FileReader("file.txt");
            BufferedReader reade = new BufferedReader(file);
            String line;
            while ((line = reade.readLine()) != null) {
                String tab[] = line.split("-");
                if (Integer.parseInt(tab[2]) == id || Integer.parseInt(tab[3]) == id) {
                   liste.add(line) ; 
                }
            }
            reade.close();
            file.close();
            if (liste.isEmpty()) {
                System.out.println(tableau);
            }else{
                System.out.println(tableau);
                for (int i = 0; i < liste.size(); i++) {
                    String  t[]  =  liste.get(i).split("-"); 
                    affiche_descendance(Integer.parseInt(t[0]));
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }       
    }
    
    /*
    la  somme de  fitness des  individu 
    */
     public double somme(int  id ){
        try {
            double somme_f =  0  ; 
            String tableau =  chereche_individu(id)  ;
            String ta []  =  tableau.split("-") ; 
            ArrayList<String> liste  =  new  ArrayList<>()  ; 
            FileReader file = new FileReader("file.txt");
            BufferedReader reade = new BufferedReader(file);
            String line;
            while ((line = reade.readLine()) != null) {
                String tab[] = line.split("-");
                if (Integer.parseInt(tab[2]) == id || Integer.parseInt(tab[3]) == id) {
                   liste.add(line) ; 
                }
            }
            reade.close();
            file.close();
            if (liste.isEmpty()) {
               return Double.parseDouble(ta[4]) ; 
            }else{
               somme_f  = Double.parseDouble(ta[4])  ;
                for (int i = 0; i < liste.size(); i++) {
                    String  t[]  =  liste.get(i).split("-");
                    somme_f +=somme(Integer.parseInt(t[0]))  ; 
                   
                }
            }
            return somme_f ; 

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1 ; 
        }       
    }
     
     public  Double somme_fitness(int id ) {
        String tab[] =  chereche_individu(id).split("-") ;
        return somme(id)-Double.parseDouble(tab[4]) ; 
     }
     
     
     public  int  comptage(int id ){
      try { 
            String tableau =  chereche_individu(id)  ;
            String ta []  =  tableau.split("-") ; 
            int comp  =  0   ; 
            ArrayList<String> liste  =  new  ArrayList<>()  ; 
            FileReader file = new FileReader("file.txt");
            BufferedReader reade = new BufferedReader(file);
            String line;
            while ((line = reade.readLine()) != null) {
                String tab[] = line.split("-");
                if (Integer.parseInt(tab[2]) == id || Integer.parseInt(tab[3]) == id) {
                   liste.add(line) ; 
                }
            }
            reade.close();
            file.close();
            if (liste.isEmpty()) {
               return 1 ; 
            }else{
               comp =1 ;
                for (int i = 0; i < liste.size(); i++) {
                    String  t[]  =  liste.get(i).split("-");
                    comp +=comptage(Integer.parseInt(t[0]))  ; 
                   
                }
            }
            return comp ; 

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1 ; 
        }       
     
     }
    
     
     public int  nb_enfants(int  id ){
         return comptage(id)-1 ; 
     }
     
     
     public  Double  moynne (int  id ){
         if (nb_enfants(id)==0) {
             return 0.0  ;
         } else {
             return somme_fitness(id)/nb_enfants(id) ; 
         }
     }
     
     
       /*
     calculer  la  moyenne  de chaque  individu  dans  la  population 
     */
    public void all_moyenne() {
        for (int i = 0; i < p.liste.size(); i++) {
            int id = p.liste.get(i).id; 
            IndividuMoyenne indi = new IndividuMoyenne(p.liste.get(i), moynne(id));
            liste.add(indi);
        }
    }
    
    
     public  Individu selection_descendance() {
        all_moyenne();
         Individu individu = new Individu();

        /*
         cacluler  la sommme  des moyennes 
         */
        double somme_moyenne = 0;
        for (int i = 0; i < liste.size(); i++) {
            somme_moyenne+= liste.get(i).moyenne ; 
        }
        /*
         générer un nombre aléatoire entre   et  la  sommme des  moyennes
         */
        double rand = (double) (Math.random() * somme_moyenne);
       
        double somme = 0;

        for (int i = 0; i < liste.size(); i++) {
            somme += liste.get(i).moyenne;
            /*
            si somme  supérieur ou égale a le  nombr  générer aléatoirement  return ce  individu 
            */
            if (somme >= rand) {
                liste.get(i).indivdu.copy(individu);
                return individu;
            }
        }
        return individu;
        
    }
    
    
    
    
    
    /*
    rechercher  a une individu si  il existe  dans  le  fichier 
    */
   
     public String chereche_individu(int id) {
        String l = "";
        try {

            FileReader file = new FileReader("file.txt");
            BufferedReader reade = new BufferedReader(file);
            String line;
            while ((line = reade.readLine()) != null) {
                String tab[] = line.split("-");
                if (Integer.parseInt(tab[0]) == id) {
                    l = line;
                }
            }

            reade.close();
            file.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return l;
    }
}
