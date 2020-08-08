
package com.tache;

import com.GUI.generation_frame;
import com.nsgaii.Individu;
import com.nsgaii.Population;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


public class PopulationToExcel  
{
    
   File  file  ;  
   WritableWorkbook myexcel;  
    WritableSheet mysheet  ;
    int  rang =  1   ; 

     public PopulationToExcel() {
        try {
             file  =  new  File("Excel population.xls")   ; 
             myexcel =  Workbook.createWorkbook(file)  ;
            mysheet  =  myexcel.createSheet("mySheet", 0)  ;
            Label  l1  =  new  Label(0, 0,"SDP")   ;
            Label  l2   =  new  Label(1, 0, "SFT")  ;
             Label  l3  =  new  Label(2, 0, "SDD")  ;
              Label  l4  =  new  Label(3, 0, "SDP/SFT")  ;
            mysheet.addCell(l1);
            mysheet.addCell(l2);
            mysheet.addCell(l3);
             mysheet.addCell(l4);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
     public PopulationToExcel(String  name) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy MM dd HH mm ss");
        Calendar cal = Calendar.getInstance();
     
        
             file  =  new  File(name+" "+dateFormat.format(cal.getTime()).toString()+".xls")   ; 
             myexcel =  Workbook.createWorkbook(file)  ;
            mysheet  =  myexcel.createSheet("mySheet", 0)  ;
            Label  l1  =  new  Label(0, 0,"SDP")   ;
            Label  l2   =  new  Label(1, 0, "SFT")  ;
             Label  l3  =  new  Label(2, 0, "SDD")  ;
             Label  l4  =  new  Label(3, 0, "SDP/SFT")  ;
            mysheet.addCell(l1);
            mysheet.addCell(l2);
            mysheet.addCell(l3);
             mysheet.addCell(l4);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
      public void add_population_excel (Population p  ) {
        try {
             for (Individu individu  : p.liste) {
             jxl.write.Number SDP = new jxl.write.Number(0, rang,individu.somme_sdp());
             jxl.write.Number SFT = new jxl.write.Number(1, rang, individu.somme_sft());
             jxl.write.Number SDD = new jxl.write.Number(2, rang, individu.somme_sdd());
             WritableCellFormat format = new WritableCellFormat(new NumberFormat("0.####"));
             jxl.write.Number division = new jxl.write.Number(3, rang,(float)individu.somme_sdp()/individu.somme_sft(),format);
                mysheet.addCell(SDP);
                mysheet.addCell(SFT);
                mysheet.addCell(SDD);
                 mysheet.addCell(division);
                rang++ ; 
        }
        } catch (Exception e) {
        }
       
       
    }
     public void add_population_excel_liste (ArrayList<Individu> liste ) {
        try {
             for (Individu individu  : liste) {
             jxl.write.Number SDP = new jxl.write.Number(0, rang,individu.somme_sdp());
             jxl.write.Number SFT = new jxl.write.Number(1, rang, individu.somme_sft());
             jxl.write.Number SDD = new jxl.write.Number(2, rang, individu.somme_sdd());
             WritableCellFormat format = new WritableCellFormat(new NumberFormat("0.####"));
             jxl.write.Number division = new jxl.write.Number(3, rang,(float)individu.somme_sdp()/individu.somme_sft(),format);
                mysheet.addCell(SDP);
                mysheet.addCell(SFT);
                mysheet.addCell(SDD);
                 mysheet.addCell(division);
                rang++ ; 
        }
        } catch (Exception e) {
            System.err.println(e);
        }
       
       
    }
    
    public void  write_close_excel()  {
       try {
           myexcel.write();
           myexcel.close();
           
       } catch (IOException ex) {
           Logger.getLogger(PopulationToExcel.class.getName()).log(Level.SEVERE, null, ex);
       } catch (WriteException ex) {
           Logger.getLogger(PopulationToExcel.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
}
