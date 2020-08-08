
package com.nsgaii.operateur_genetique;

import com.nsgaii.Individu;
import com.nsgaii.Population;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class SelectionParGeneration {
   Population  p  ;        
   ArrayList<IndividuMoyenne> liste = new ArrayList<>();

    public SelectionParGeneration(Population p) {
        this.p = p;
    }
    public SelectionParGeneration() {
       
    }
   
     /*
    afficher  tout  les  individu d'une  generation N 
    */
    public void affiche_par_generation(int generation) {
        try {
            FileReader file = new FileReader("file.txt");
            BufferedReader reade = new BufferedReader(file);
            String line;
            while ((line = reade.readLine()) != null) {
                String tab[] = line.split("-");
                if (Integer.parseInt(tab[1]) == generation) {
                    System.out.println(line);
                }
            }
            reade.close();
            file.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
     
     
    /*
    cette fonction  calculer  moyenne de  fitness  d'une  generation n 
    */

    public double moyenne_generation(int n_generation) {
        double somme = 0;
        int compteur = 0;
        try {
            FileReader file = new FileReader("file.txt");
            BufferedReader reade = new BufferedReader(file);
            String line;
            while ((line = reade.readLine()) != null) {
                String tab[] = line.split("-");
                if (Integer.parseInt(tab[1]) == n_generation) {
                    somme = Double.parseDouble(tab[4]) + somme;
                    compteur++;
                }
            }
            reade.close();
            file.close();
            if (compteur > 0) {
                return somme / compteur;
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
       /*
     calculer  la  moyenne  de chaque  individu  dans  la  population 
     */
    public void all_moyenne() {
        for (int i = 0; i < p.liste.size(); i++) {
            int n_generation = p.liste.get(i).generation ; 
            IndividuMoyenne indi = new IndividuMoyenne(p.liste.get(i), moyenne_generation(n_generation));
            liste.add(indi);
        }
    }
    
    
     /*
    la  méthode  de  selection  par  collateraux  :  applliquer  la Sélection par roulette basé sur   la  moyenne 
    des frére  de  chaque  individu 
    */
    
    public  Individu selection_par_generation () {
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
     
}