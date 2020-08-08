
package com.GUI;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import javax.swing.JOptionPane;


public class TextToSpeak {
     private static final String VOICENAME = "kevin16"; 
    
    public   static  void  speak ()  {
    Voice voice  ; 
      VoiceManager vx  = VoiceManager.getInstance();
      voice = vx.getVoice(VOICENAME);  
      voice.allocate();
        try {
            
            voice.speak("fin de  traitement");
            JOptionPane.showMessageDialog(null, " " , " fin de  traitement" ,  JOptionPane.INFORMATION_MESSAGE) ; 
        } catch (Exception e) {
        }
    
    
    }  
    
    public   static  void  speak_text (String  text  )    {
    Voice voice  ; 
      VoiceManager vx  = VoiceManager.getInstance();
      voice = vx.getVoice(VOICENAME);  
      voice.allocate();
        try {
            
            voice.speak(text);
           
        } catch (Exception e) {
        }
    
    
    }  
}
