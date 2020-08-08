
package com.nsgaii;

import com.GUI.Configuration_Frame;
import com.tache.Librarie_Taches;
import com.tache.TestValidation;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class NouvellePopulation {

    public NouvellePopulation() {
        
    }
    /*
    supprimer  les  individus qui il  dépassent  la  taille  de population 
    */
    public static void nouvelle_population(Population  p )  {
     /*
        choisir les  meilleur individus
        */
        for (int i = 0; i < p.liste.size(); i++) {
           TestValidation test  =  new  TestValidation(p.liste.get(i)) ; 
           int  taille_processus  =  p.liste.get(i).tache_utiliser().size()  ; 
            if (test.isValide()==false || taille_processus>(int)Configuration_Frame.max.getValue() || taille_processus<(int)Configuration_Frame.min.getValue()  ) {
                
                p.liste.remove(p.liste.get(i)) ; 
            } 
        }
        if (p.liste.size()==0 ) {
            JOptionPane.showMessageDialog(null, "pas de solution");
            System.exit(0);
        }
         
    }
    
    public  static void creation_nouvelle_population(Population p) {
    ArrayList<Individu> liste  =  new ArrayList<>() ; 
    for (int i = 0; i < Run_Class.taille_de_population; i++) {
           liste.add(p.liste.get(i)) ;
        }
    p.liste.clear();
    p.liste.addAll(liste) ; 
        
    }
    
    public static void nouvelle_population2(Population  p )  {
          ArrayList<Individu> liste  =  new ArrayList<>() ; 
     /*
        choisir les  meilleur individus
        */
        for (int i = 0; i < p.liste.size(); i++) {
           TestValidation test  =  new  TestValidation(p.liste.get(i)) ;
            if (test.isValide()==true ||( p.liste.get(i).tache_utiliser().size()  <=(int)Configuration_Frame.max.getValue() && p.liste.get(i).tache_utiliser().size()  >=(int)Configuration_Frame.min.getValue())  ) {
               liste.add(p.liste.get(i)) ; 
                System.out.println("new "+p.liste.get(i).tache_utiliser().size());
            } 
        }
        if (!liste.isEmpty()) {
             p.liste.clear();
    p.liste.addAll(liste) ; 
        }else{
            JOptionPane.showMessageDialog(null, "pas de solution");
            System.exit(0);
        }
         
    }

}
