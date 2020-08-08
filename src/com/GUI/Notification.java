
package com.GUI;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import javax.swing.ImageIcon;


public class Notification {
    public String text  ;  

    public Notification(String text) {
        this.text = text;
    }
    public  void  display() {
        try{
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();
        //Creating a tray icon
        ImageIcon icon = new ImageIcon("‪spinner.jpg");
        Image image = icon.getImage();
        //System.out.println(image);
        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        //Let the system resizes the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);
        trayIcon.displayMessage(this.text, "BPO tools ", TrayIcon.MessageType.INFO);
        }catch(Exception e){
            
        }
    }
}
