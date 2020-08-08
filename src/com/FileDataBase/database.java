package com.FileDataBase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class database {
    /*
    lire  tts dd le  fichier 
    */
    public static void readeallfile() {
        try {
            int comp =  0 ; 
            FileReader file = new FileReader("file.txt");
            BufferedReader reade = new BufferedReader(file);
            String line;
            while ((line = reade.readLine()) != null) {

                System.out.println(line);
                comp++ ; 
            }
             System.out.println("nb des  indvidu  "+comp)  ;  
            reade.close();
            file.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public static int nb_individu() {
        try {
            int comp =  0 ; 
            FileReader file = new FileReader("file.txt");
            BufferedReader reade = new BufferedReader(file);
            String line;
            while ((line = reade.readLine()) != null) {
                comp++ ; 
            }
             
            reade.close();
            file.close();
            return comp  ; 

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return 0 ; 
        }
    }
    
     /*
    affiche  une seule  attribut  dans  le  fichier  
    */
    public static void affiche_all() {
        try {
            FileReader file = new FileReader("file.txt");
            BufferedReader reade = new BufferedReader(file);
            String line;
            while ((line = reade.readLine()) != null) {
                String tab[] = line.split("-");
                System.out.println(tab[4]);
            }

            reade.close();
            file.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
    afficher  les  enfents  d'un  parent  
    */
    public void affiche_descendant(int id_parent) {
        try {
            FileReader file = new FileReader("file.txt");
            BufferedReader reade = new BufferedReader(file);
            String line;
            while ((line = reade.readLine()) != null) {
                String tab[] = line.split("-");
                if (Integer.parseInt(tab[2]) == id_parent || Integer.parseInt(tab[3]) == id_parent) {
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
       afficher  les  paranet de  individu  "a"     
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
    différent génération existe dans le fichier
    */
    public  ArrayList<Integer> all_generation  ()  {
        ArrayList<Integer> liste =  new  ArrayList<>()  ; 
       try {
            FileReader file = new FileReader("file.txt");
            BufferedReader reade = new BufferedReader(file);
            String line;
            while ((line = reade.readLine()) != null) {
                String tab[] = line.split("-");
                if (recherche(Integer.parseInt(tab[1]), liste)==false) {
                    liste.add(Integer.parseInt(tab[1])) ; 
                }
            }
            
            reade.close();
            file.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    return liste ; 
    }
     
    /*
    calculer la  moyene  de  chaque  génération 
    */
    
    public   ArrayList<Double> all_moyenne()  {
        ArrayList<Double> liste_moyenne =  new  ArrayList<>()  ; 
        try {
           
            for (int i = 0; i < all_generation().size(); i++) {
               liste_moyenne.add(moyenne_generation(all_generation().get(i))) ; 
            }
            
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
    return liste_moyenne ; 
    }
    
       
    /*
    la  mellieur génération  est  la génération  de la  mellier  moyenne 
    */
    public  int  mellieur_generation() {
    int  mellieur =  0  ; 
        for (int i = 1; i < all_moyenne().size(); i++) {
             if (all_moyenne().get(i)>all_moyenne().get(mellieur)) {
                mellieur  =  i ; 
            }
    
        }
    return mellieur  ; 
    
    }
    
    
    /*
    afficher  tts  les freres  d'un  individu  
    */
     public  void affiche_frere(int  id  ){
     // importer  les  information de  l'individu id 
     String tab [] =  chereche_individu(id).split("-") ; 
     int p1  = Integer.parseInt(tab[2]) ;  
     int p2  = Integer.parseInt(tab[3]) ; 
     
     /*
     somme  = somme  des  fintnes 
     compteur =  nombre des  individu
     */
    double somme  =  0   ;  
     int compteur  =  0  ; 
      try {
            FileReader file = new FileReader("file.txt");
            BufferedReader reade = new BufferedReader(file);
            String line;
            while ((line = reade.readLine()) != null) {
                String tab_line[] = line.split("-");
                
                if ((Integer.parseInt(tab_line[2]) == p1 ||Integer.parseInt(tab_line[3])==p1 || Integer.parseInt(tab_line[2]) == p2 ||Integer.parseInt(tab_line[3])==p2) && (Integer.parseInt(tab_line[0])!=id) ) {
                    System.out.println(line);
                    somme  =  somme  + Double.parseDouble(tab_line[4]) ; 
                    compteur++ ; 
                }
            }
            reade.close();
            file.close();
            if (compteur>0) {
                System.out.println("la  moyenne de  l'individu  "+id+" est "+(somme/compteur));
          }
          
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
     
     }    
    
    
    /*
    tester  si  le  nb a  exsite dans  la  liste  "list"
    */
    public  boolean recherche(int a , ArrayList<Integer> list) {
        boolean trouve = false;
        int i = 0;
        while (!trouve && i < list.size()) {
            if (list.get(i) == a) {
                trouve = true;
            } else {
                i++;
            }
        }
        return trouve;
    }
}
