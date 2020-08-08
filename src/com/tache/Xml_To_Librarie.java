
package com.tache;

import com.GUI.Librairie_Frame;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
/*
convertir le  fichier  XML  a  une  liste  contient  la  Bibbiothéque des  tachés et  autre  pour  le processus initial 

outile  utiliser  :  Jdom 2.jar

*/

public class Xml_To_Librarie {
    /*
    file  :  le fichier  XML 
    */
    String path ; 

    public Xml_To_Librarie(String path) {
        this.path = path;
    }
    
    /*
    la  méhode  de conversion
    */
    /*
    creation de  bibiothéque  des taches 
    */
    public  void convertir  () {
      try {
                
                SAXBuilder builder = new SAXBuilder() ; 
                File file  =  new  File(this.path) ; 
		Document document = (Document) builder.build(file);
		Element rootNode = document.getRootElement();
                
                /*
                choisir touts  les  elements  task  et  enregitré  dans une  liste  
                */
		List list = rootNode.getChildren("task");
                /*
                parcourir tout les tasks 
                */
		for (int i = 0; i < list.size(); i++) {
                    /*
                     création d'un  objet  tache pour  enrgistré son propriété 
                     par  les  task 
                    */
                   Tache t  =  new  Tache() ; 
		   Element node = (Element) list.get(i);
                   // numero de  tache 
                   int  num  = Integer.parseInt(node.getChildText("num_tache")) ; 
                   t.setNum(num);
                   // nom de  tache 
                   String  nom  =  node.getChildText("name_tache") ; 
                   t.setNom(nom);
                   /*
                    les  inputs  : sauvgarder  les  inputs dans  une  liste ( la liste exsite dans  l'objet tache  ) 
                   */
                     List  a  =  node.getChildren("input") ;  
                    for (int j = 0; j < a.size(); j++) {
                        Element e = (Element)a.get(j) ; 
                        int  n  =  Integer.parseInt(e.getText()) ; 
                        t.add_input(n);  
                    }
                    /*
                   les  outputs  : sauvgarder  les  outputs dans  une  liste ( la liste exsite dans  l'objet tache  ) 
                    */
                    List  a2 =  node.getChildren("output") ;  
                    for (int j = 0; j < a2.size(); j++) {
                        Element e = (Element)a2.get(j) ; 
                        int  n  =  Integer.parseInt(e.getText()) ;
                        t.add_output(n);
                    }
                    //le prix de livraison du service (SDP ou Service Delivery Price) 
                    t.setSdp(Integer.parseInt(node.getChildText("sdp")));
                   //taux de réussite du service (SFT ou Service Fulfilment Target)
                    t.setSft(Integer.parseInt(node.getChildText("sft")));
                    //la durée de livraison du service (SDD ou Service Delivering Duration ou Service Provinding Duration)
                    t.setSdd(Integer.parseInt(node.getChildText("sdd")));
                    
                    // ajouter  la tache crée  a une  bibiothéque de  tache  
                     Librarie_Taches.add_tache(t);
                   
		}
                

	  } catch (IOException io) {
		System.out.println(io.getMessage());
	  } catch (JDOMException jdomex) {
		System.out.println(jdomex.getMessage());
	  }  
    }
    /*
     convertir le  porcessus  initial 
    */
    public  void convertir_processus_initial  () {
      try {
                
                SAXBuilder builder = new SAXBuilder() ; 
                File file  =  new  File(this.path) ; 
		Document document = (Document) builder.build(file);
		Element rootNode = document.getRootElement();
                
                /*
                choisir touts  les  elements  task  et  enregitré  dans une  liste  
                */
		List list = rootNode.getChildren("task");
                /*
                parcourir tout les tasks 
                */
		for (int i = 0; i < list.size(); i++) {
                    /*
                     création d'un  objet  tache pour  enrgistré son propriété 
                     par  les  task 
                    */
                   Tache t  =  new  Tache() ; 
		   Element node = (Element) list.get(i);
                   // numero de  tache 
                   int  num  = Integer.parseInt(node.getChildText("num_tache")) ; 
                   t.setNum(num);
                   // nom de  tache 
                   String  nom  =  node.getChildText("name_tache") ; 
                   t.setNom(nom);
                   /*
                    les  inputs  : sauvgarder  les  inputs dans  une  liste ( la liste exsite dans  l'objet tache  ) 
                   */
                     List  a  =  node.getChildren("input") ;  
                    for (int j = 0; j < a.size(); j++) {
                        Element e = (Element)a.get(j) ; 
                        int  n  =  Integer.parseInt(e.getText()) ; 
                        t.add_input(n);  
                    }
                    /*
                   les  outputs  : sauvgarder  les  outputs dans  une  liste ( la liste exsite dans  l'objet tache  ) 
                    */
                    List  a2 =  node.getChildren("output") ;  
                    for (int j = 0; j < a2.size(); j++) {
                        Element e = (Element)a2.get(j) ; 
                        int  n  =  Integer.parseInt(e.getText()) ;
                        t.add_output(n);
                    }
                    
                    
                    // ajouter  la tache crée  a une  bibiothéque de  tache  
                     Librarie_Taches.add_tache_initial(t);
                   
		}
                

	  } catch (IOException io) {
		System.out.println(io.getMessage());
	  } catch (JDOMException jdomex) {
		System.out.println(jdomex.getMessage());
	  }  
    }
      public  void inputs_outputs () {
      try {
                SAXBuilder builder = new SAXBuilder() ; 
                File file  =  new  File(this.path) ; 
		Document document = (Document) builder.build(file);
		Element rootNode = document.getRootElement();
                /*
                choisi  element  
                */
                /*
                sauvegarder  les  outputs de  processus  initial dans  une liste static  liste inputs
                */
		List list = rootNode.getChildren("set_input_scenario_a");

		for (int i = 0; i < list.size(); i++) {
		   Element node = (Element) list.get(i);
                     List  a  =  node.getChildren("input_scenario_a") ;  
                    for (int j = 0; j < a.size(); j++) {
                        Element e = (Element)a.get(j) ; 
                        int  n  =  Integer.parseInt(e.getText()) ; 
                        Librarie_Taches.liste_inputs.add(n)  ;                       
                    }
		}
                
                /*
                sauvegarder  les  outputs de  processus  initial dans  une liste static  liste outputs
                */
                List list1 = rootNode.getChildren("set_output_scenario_a");

		for (int i = 0; i < list1.size(); i++) {
		   Element node = (Element) list1.get(i);
                     List  a  =  node.getChildren("output_scenario_a") ;  
                    for (int j = 0; j < a.size(); j++) {
                        Element e = (Element)a.get(j) ; 
                        int  n  =  Integer.parseInt(e.getText()) ; 
                        Librarie_Taches.liste_outputs.add(n) ;   
                    }
		}
                

	  } catch (IOException io) {
		System.out.println(io.getMessage());
	  } catch (JDOMException jdomex) {
		System.out.println(jdomex.getMessage());
	  }
        
    }
}
