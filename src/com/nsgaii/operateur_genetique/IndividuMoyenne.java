
package com.nsgaii.operateur_genetique;

import com.nsgaii.Individu;

/*
nouvelle  structure  utiliser dans  les selection génétique 
*/
public class IndividuMoyenne {
    public Individu indivdu ; 
    public double  moyenne  ; 

    public IndividuMoyenne(Individu indivdu, double moyenne) {
        this.indivdu = indivdu;
        this.moyenne = moyenne;
    }

    public Individu getIndivdu() {
        return indivdu;
    }

    public void setIndivdu(Individu indivdu) {
        this.indivdu = indivdu;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }
   
    
}
