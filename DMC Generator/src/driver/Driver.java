/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import java.awt.Component;
import javax.swing.JOptionPane;




/**
 *COPY CONSTRUCTOR for CourseResult class is available
 * @author AFRAZ
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        UetGradeBook ugb=new UetGradeBook();
        
        
        String[] options={"Choose any Option: ","\n","Choose 1 to set basic information of Student","Choose 2 to add new course to Grade Book"
                ,"Choose 3 to edit a course","Choose 4 to delete a course","Choose 5 to view all courses","Choose 6 to view CGPA","Choose 7 to view Detailed Marks Certificate"
        
        };
        
        //int h=JOptionPane.showOptionDialog(null, ugb, "title", 0, 0, null, options, options);
       String option=JOptionPane.showInputDialog(null, options, "Uet Grade Book  (AFRAZ)", 2);
          ugb.ShowDialogue(option);
        //System.out.println(h);
       
        
        
        
        
                
        
    }

  
    
}
