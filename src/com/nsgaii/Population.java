package com.nsgaii;

import com.GUI.Configuration_Frame;
import com.tache.TestValidation;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Population {

    int taille;

    // liste :  la  liste  des  individus ( processus )  
    public List<Individu> liste = new ArrayList<Individu>();

    // constructure 

    public Population(int taille) {
        this.taille = taille;
        for (int i = 0; i < (int)Configuration_Frame.taille_de_population.getValue(); i++) {
            Individu d  =  new  Individu() ; 
            d.setId();
            liste.add(d)  ; 
        }
        this.evaluation();
    }

    /*
     afficher  touts les individus de  population 
     */
    public void affiche_population() {
        for (Individu indi : liste) {
           
            System.out.println(indi.tostring());
        }

    }
    /*
     evalution pour calculer fitness pour tts  les  individus de la population 
     */

    public void evaluation() {
         for (Individu liste1 : liste) {
            liste1.evl_individu();
        }
    }
 /*
    sauvgader  touts  les  individus  dans  le  fichier text 
    */
    public  void  save_all() {
        for (Individu individu : liste) {
            individu.save();
        }
    }
     
    public void  populatioIsValide() {
        for (Individu individu  : liste) {
            TestValidation test  =   new  TestValidation(individu) ; 
            System.out.println(individu.tostring()+"  "+test.isValide());
        }
    }
}
