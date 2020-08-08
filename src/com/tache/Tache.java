
package com.tache;

import java.util.ArrayList;
public class Tache {
    /*
     num  =  numéro de tache  
     nom = nom de  tache  
    sdp = le prix de livraison du service (SDP ou Service Delivery Price)
    sft = taux de réussite du service (SFT ou Service Fulfilment Target)
    sdd = la durée de livraison du service (SDD ou Service Delivering Duration ou Service Provinding Duration).  
    input_liste  =  les  inputs  de  la  tache 
    output_liste  =  les  sortie de  chaque  tache  
    */
    int  num  ;  
    String nom  ;  
    int sdp ;  
    int sft ;  
    int  sdd  ; 
  public  ArrayList<Integer> input_liste ; 
   public ArrayList<Integer> output_liste ;  

    public Tache(int num, String nom, int sdp, int sft, int sdd) {
        this.num = num;
        this.nom = nom;
        this.sdp = sdp;
        this.sft = sft;
        this.sdd = sdd;
        input_liste  =  new ArrayList<>()  ; 
        output_liste =  new  ArrayList<>()  ; 
    }
    public  Tache ()  {
     input_liste  =  new ArrayList<>()  ; 
        output_liste =  new  ArrayList<>()  ; 
    }

    public int getSdp() {
        return sdp;
    }

    public void setSdp(int sdp) {
        this.sdp = sdp;
    }
    
    public  void  add_input (int  input )  {
          input_liste.add(input)  ;     
    }
    public  void  add_output(int output){
          output_liste.add(output)  ;  
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSft() {
        return sft;
    }

    public void setSft(int sft) {
        this.sft = sft;
    }

    public int getSdd() {
        return sdd;
    }

    public void setSdd(int sdd) {
        this.sdd = sdd;
    }
    
}
