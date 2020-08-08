
package com.nsgaii;

import com.nsgaii.operateur_genetique.Croisement_Mutation;
import com.nsgaii.operateur_genetique.Selection;
import com.tache.Xml_To_Librarie;
import java.io.File;
import java.util.ArrayList;


public class test {

    
    public static void main(String[] args) {
         
      
    }

    public static void ze() {
        File f =  new  File("‪C:\\Users\\OUADHI\\Desktop\\librairie") ;
        Xml_To_Librarie xml  =  new Xml_To_Librarie(f.getPath()) ;
        xml.convertir();
        File f2 =  new  File("‪‪C:\\Users\\OUADHI\\Desktop\\trm") ;
        Xml_To_Librarie xml1  =  new Xml_To_Librarie(f2.getPath()) ;
        xml1.convertir_processus_initial();
        Population p = new Population(2);
        int nb_generation = 1;
        for (int i = 0; i < nb_generation; i++) {
            while (p.liste.size() < p.taille * 2) {
                //Croisement_Mutation.croisment_et_mutation(Selection.uniform(p), Selection.uniform(p), p);
            }
            p.evaluation();
            Classement.classement_individus(p);
            p.affiche_population();
            System.out.println("*********************************************************");
            NouvellePopulation.nouvelle_population(p);
            p.affiche_population();
        }
        System.out.println("la  Solution est ");
    }
    
    
    
    public static void affiche  (ArrayList<String> liste)  {
         for (String s : liste) {
             System.out.println(s);
        }
    
    
    }
}
