
package com.tache;

import java.io.File;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


public class SelectionExcel {
    
    
 public static void  write (String methode , int population  , int  solution){
       try {
    Workbook workbook1 = Workbook.getWorkbook(new File("selection\\"+methode+".xls"));
    WritableWorkbook copy = Workbook.createWorkbook(new File("selection\\"+methode+".xls"), workbook1);
    WritableSheet sheet2 = copy.getSheet(0); 
    int row  =sheet2.getRows() ; 
    jxl.write.Number taille = new jxl.write.Number(0, row,population);
    jxl.write.Number nb_solution = new jxl.write.Number(1, row,solution);
    sheet2.addCell(taille);
    sheet2.addCell(nb_solution);
    copy.write();
    copy.close();

        } catch (Exception e) {
            System.err.println(e);
        }
 }
}
