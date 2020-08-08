
package com.nsgaii.operateur_genetique;

import com.nsgaii.Individu;
import com.nsgaii.Population;
import com.nsgaii.operateur_genetique.IndividuMoyenne;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class SelectionSurAscendance {
    public  Population p  ;  
    public  ArrayList<IndividuMoyenne> liste = new ArrayList<>();

    public SelectionSurAscendance() {
    }

    public SelectionSurAscendance(Population p) {
        this.p = p;
    }
    
    
    
     /*
    afficher  les  1ier  parents de  l'individu
    */
     public void affiche_ascendent(int id) {
        try {
            String individu = chereche_individu(id);
            String t[] = individu.split("-");
            FileReader file = new FileReader("file.txt");
            BufferedReader reade = new BufferedReader(file);
            String line;
            while ((line = reade.readLine()) != null) {
                String tab[] = line.split("-");
                if (Integer.parseInt(tab[0]) == Integer.parseInt(t[2]) || (Integer.parseInt(tab[0]) == Integer.parseInt(t[3]))) {
                    System.out.println(line);
                }
            }
            reade.close();
            file.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
     
     /*
     calculer  la somme des fitness de individu et leur  parents 
     */
    public Double somme_fitness(int id ,  int  i) {
        String tab[] = chereche_individu(id).split("-");
        if (Integer.parseInt(tab[2]) == 0 || Integer.parseInt(tab[3]) == 0 || i ==0) {
            return Double.parseDouble(tab[4]);
        } else {
            return Double.parseDouble(tab[4]) + somme_fitness(Integer.parseInt(tab[2]),--i) + somme_fitness(Integer.parseInt(tab[3]),--i);
        }

    }
    
    /*
     calculer  la somme des fitness du parent de  un  individu 
     */
    public Double somme(int id) {
     String tab[] = chereche_individu(id).split("-");
     Double fit =  Double.parseDouble(tab[4]) ; 
     return somme_fitness(id,3)-fit ; 
    }
    
    
    /*
    nombre des indivdu a partir de  un  individu donnée jusqu a le  peremier  parent 
    */
    public int  compte (int  id  ,  int  i)  {
         String tab[] = chereche_individu(id).split("-");
        if (Integer.parseInt(tab[2]) == 0 || Integer.parseInt(tab[3]) == 0 || i  ==0 ) {
            return 1;
        } else {
            return 1 + compte(Integer.parseInt(tab[2]),--i) + compte(Integer.parseInt(tab[3]), --i);
        }
    }
    
    
    
    /*
    nombre des  parents  d'un  individu  donnée 
    */
    public  int  nb_parent(int id) {

    return compte(id, 3)-1 ; 
    
    }
     
    public  Double moyenne( int id) {
        if(nb_parent(id)==0){
            return 0.0 ;
        }else{
            return somme(id)/nb_parent(id) ;
        }
    }
    
    /*
    calculer  la  moyenne  de chaque  individu  dans  la population 
    */
    
    public void all_moyenne() {
        for (int i = 0; i < p.liste.size(); i++) {
            IndividuMoyenne indi  = new IndividuMoyenne(p.liste.get(i), moyenne(p.liste.get(i).id)) ; 
            liste.add(indi) ;
        }
    }
    
     public  Individu selection_ascendance() {
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


