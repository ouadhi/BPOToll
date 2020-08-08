
package com.nsgaii.operateur_genetique;

import com.nsgaii.Individu;

/*
cette  class  facilite  la selection  par rang  
effecter  a chaque  individu rang   
*/
public class Individu_Rank {
    Individu  individu  ; 
    int  rang ; 
    public Individu_Rank() {
    }

    public Individu_Rank(Individu individu) {
        this.individu = individu;
        this.rang =  0   ; 
    }
    
    
}
