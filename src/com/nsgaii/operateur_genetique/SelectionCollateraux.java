package com.nsgaii.operateur_genetique;

import com.nsgaii.Individu;
import com.nsgaii.Population;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class SelectionCollateraux {
   Population  p  ;        
   ArrayList<IndividuMoyenne> liste = new ArrayList<>();

    public SelectionCollateraux(Population p) {
        this.p = p;
    }
    public SelectionCollateraux() {
       
    }
   
    /*
     les   demi- ou pleins frères-sœurs d'un  individu 
     */
    public void affiche_frere(int id) {
        // importer  les  information de  l'individu id 
        String tab[] = chereche_individu(id).split("-");
        int p1 = Integer.parseInt(tab[2]);
        int p2 = Integer.parseInt(tab[3]);

        /*
         somme  = somme  des  fintnes 
         compteur =  nombre des  individu
         */
        double somme = 0;
        int compteur = 0;
        try {
            FileReader file = new FileReader("file.txt");
            BufferedReader reade = new BufferedReader(file);
            String line;
            while ((line = reade.readLine()) != null) {
                String tab_line[] = line.split("-");

                if ((Integer.parseInt(tab_line[2]) == p1 || Integer.parseInt(tab_line[3]) == p1 || Integer.parseInt(tab_line[2]) == p2 || Integer.parseInt(tab_line[3]) == p2) && (Integer.parseInt(tab_line[0]) != id)) {
                    System.out.println(line);
                    somme = somme + Double.parseDouble(tab_line[4]);
                    compteur++;
                }
            }
            reade.close();
            file.close();
            if (compteur > 0) {
                System.out.println("la  moyenne de  l'individu  " + id + " est " + (somme / compteur));
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    /*
     calculer le  moyenne des performances de frere d'un individu 
     */
    public double moyenne_freres(int id) {
        // importer  les  information de  l'individu id 
        String tab[] = chereche_individu(id).split("-");
        int p1 = Integer.parseInt(tab[2]);
        int p2 = Integer.parseInt(tab[3]);

        /*
         somme  = somme  des  fintnes 
         compteur =  nombre des  individu
         */
        double somme = 0;
        int compteur = 0;
        double moyenne = 0;
        try {
            FileReader file = new FileReader("file.txt");
            BufferedReader reade = new BufferedReader(file);
            String line;
            while ((line = reade.readLine()) != null) {
                String tab_line[] = line.split("-");

                if ((Integer.parseInt(tab_line[2]) == p1 || Integer.parseInt(tab_line[3]) == p1 || Integer.parseInt(tab_line[2]) == p2 || Integer.parseInt(tab_line[3]) == p2) && (Integer.parseInt(tab_line[0]) != id)) {
                    somme = somme + Double.parseDouble(tab_line[4]);
                    compteur++;
                }
            }
            reade.close();
            file.close();
            if (compteur > 0) {
                moyenne = somme / compteur;
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return moyenne;
    }

    /*
     calculer  la  moyenne  de chaque  individu  dans  la  population 
     */
    public void all_moyenne() {
        for (int i = 0; i < p.liste.size(); i++) {
            int id = p.liste.get(i).id;
            IndividuMoyenne indi = new IndividuMoyenne(p.liste.get(i), moyenne_freres(id));
            liste.add(indi);
        }
    }
    
    /*
    la  méthode  de  selection  par  collateraux  :  applliquer  la Sélection par roulette basé sur   la  moyenne 
    des frére  de  chaque  individu 
    */
    
    public  Individu selection_collateraux () {
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
