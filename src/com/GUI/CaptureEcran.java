
package com.GUI;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
/* 

     faire  un  capture d'un  elemet  swing  

*/

public class CaptureEcran {
    
    /*
    path de l'image
    comp = elemet swing 
    */
    String  file  ; 
    Component comp  ; 

    public CaptureEcran(String file, Component comp) {
        this.file = file;
        this.comp = comp;
    }

    public CaptureEcran() {
    }
    
    
    /*
    créer  le  capture 
    */
     public   BufferedImage getcaputre (){
        BufferedImage  img  =  new  BufferedImage(comp.getWidth(),comp.getHeight(), BufferedImage.TYPE_INT_RGB) ;  // taile de  l'image 
        comp.paint(img.getGraphics());
        return img ;         
    }
    
     /*
     sauvgarder  l"image  dans  un fichier  png 
     */
    public   void  savecapture ()  {
                BufferedImage img =getcaputre(); 
        try { 
            ImageIO.write(img, "png", new  File(this.file)) ;
            JOptionPane.showConfirmDialog(null, "Sauvegarder" , " image ete sauvegardé avec succès" ,  JOptionPane.INFORMATION_MESSAGE) ; 
        } catch (Exception  e) {
            System.err.println(e.getMessage());
        }
    
    } 
}
