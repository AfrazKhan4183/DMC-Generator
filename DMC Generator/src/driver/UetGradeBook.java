/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * class to show DMC  
 * @author AFRAZ
 */
public class UetGradeBook        
{
    private String StudentName;
    private String Registration_Number;
    private String Degree;
    private ArrayList<CourseResult> Courses;

/**
 * No Parameter Constructor
 */
public UetGradeBook()
{
    StudentName="";
        Registration_Number="";
           Degree="";
       Courses=new ArrayList<>();
}

/**
 *                all Getters
 *
 */
    public String getStudentName() {
        return StudentName;
    }

    public String getRegistration_Number() {
        return Registration_Number;
    }

    public String getDegree() {
       
        return Degree;
    }

    public ArrayList<CourseResult> getCourses() {
        return Courses;
    }

    
    /**
     *            all  setters
     */
    public void setStudentName(String StudentName) {
       
        this.StudentName = StudentName;
    }

    public void setRegistration_Number(String Registration_Number) {
        this.Registration_Number = Registration_Number;
    }

    public void setDegree(String Degree) {
       if(Degree.equals("BS")||Degree.equals("MS")||Degree.equals("BE"))
       {
        this.Degree = Degree;
       }
       else
       {
           System.out.println("Pl, Enter a Valid Degree Type");
           System.exit(56);
       }
    }

    public void setCourses(ArrayList<CourseResult> Courses) {
        this.Courses = Courses;
    
    
    }
     
    /**
     * the following method will be invoked if 1 is pressed in main dialogue
     * @param given 
     * String entered in Student Basic info Dialogue box
     */
    public void option1(String given)  
    {
        String[] info=given.split(",");   //here split the string entered in Student basic info Dialogue box to set the Student's Credentials 
        StudentName=info[0];
        Registration_Number=info[1];
        Degree=info[2];
       
    }
    
    /**
     * the following method will be invoked if 2 is pressed in main dialogue
     * @param given 
     * String entered in Course info Dialogue box
     */
    
    public void option2 (String given)
    {
        CourseResult CR=new CourseResult();
        
        String[] courseInfo=given.split(",");  ////here split the string entered in Course info Dialogue box to set the Course's Attributes
        
        CR.setCourseID(courseInfo[0]);        
        CR.setCourseTitle(courseInfo[1]);
        
        char []CH=courseInfo[2].toCharArray();
        char []M=courseInfo[4].toCharArray();
        char []S=courseInfo[3].toCharArray();
        
        CR.setCreditHours(CH[0]-48);    
        /**
         * since all attributes of a Course are Strings and Marks can have 
         * 2 digits, so we have to convert both digits to an integer 
         */
        
        int digit1=M[0]-48;            
        int digit2=M[1]-48;
        digit1=digit1*10;
        CR.setMarks(digit1+digit2);
        CR.setSemester(S[0]-48);
        
       Courses.add(CR); //after setting all attributes of a course , adding the Course to the the List    
    }
    
    /**
     * the following method will be invoked if 3 is pressed in main dialogue
     * @param given 
     * String entered in "Edit a Course" Dialogue box or CourseID in this case
     */
    public void option3(String given)
    {              
                                    // Following are the fields to show in Main dialogue
        String[] OPTIONS={"Choose any Option: ","\n","Choose 1 to set basic information of Student","Choose 2 to add new course to Grade Book"
                ,"Choose 3 to edit a course","Choose 4 to delete a course","Choose 5 to view all courses","Choose 6 to view CGPA","Choose 7 to view Detailed Marks Certificate"
        
        };
        int length=0;
        for(int f=0;f<Courses.size();f++)
        {
            if(!(Courses.get(f).getCourseID().equals(given)))
                    {
                     length++;
                     if(length==Courses.size())
                     {
                            // if ID doesn't equal to any Course in List then following message will popup
                       JOptionPane.showMessageDialog(null, "pl, Enter valid CourseID ");
                       String opt=JOptionPane.showInputDialog(null, OPTIONS, "Uet Grade Book  (AFRAZ)", 2);
                    ShowDialogue(opt);
                     }
                    }
        }
        
        for(int h=0;h<Courses.size();h++)
        {
           
            /**
             * to insure that Course really exist in List , we compare its ID with the given CourseID
             */
            
            if(Courses.get(h).getCourseID().equals(given))
            {
                /**
                 * Setting the identified course Attributes by given ID to the values obtained by following Editing dialogue box
                 */
                 String info=JOptionPane.showInputDialog(null, "Pl, Enter the Course information in the following format\nCourseID,Course Titlt,Credit Hours,Semester,Marks", "Student Basic Information", 0); 
                 String []CourseInfo=info.split(",");
                 Courses.get(h).setCourseID(CourseInfo[0]);
                 Courses.get(h).setCourseTitle(CourseInfo[1]);
                 
                 char []CH=CourseInfo[2].toCharArray();
                 char []M=CourseInfo[4].toCharArray();
                 char []S=CourseInfo[3].toCharArray();
                 
                 /**
                  * Setting Attributes to the new Course Values
                  */
                 int digit1=M[0]-48;
                  int digit2=M[1]-48;
                  digit1=digit1*10;

                 
                 Courses.get(h).setCreditHours(CH[0]-48);
         Courses.get(h).setMarks(digit1+digit2);
         Courses.get(h).setSemester(S[0]-48);
            }
        }
        
         
    }
    
    /**
     * Main Dialogue to show the choosing options
     * @param option 
     * it is the Numerical option, which U will choose
     */
    public void ShowDialogue(String option)
    {
        // Following are the fields to show in Main dialogue
        String[] OPTIONS={"Choose any Option: ","\n","Choose 1 to set basic information of Student","Choose 2 to add new course to Grade Book"
                ,"Choose 3 to edit a course","Choose 4 to delete a course","Choose 5 to view all courses","Choose 6 to view CGPA","Choose 7 to view Detailed Marks Certificate"
        
        };
        
        /**
         *  here decision will be made to invoke a method based on given Numeric option
         * 
         *  In each case, a sub Dialogue box will be used to aquire a String 
         *  consisting of the required information being passed to the invoked method 
         */
        switch (option) {
            case "1":
                {
                    String info1=JOptionPane.showInputDialog(null, "Pl, Enter the basic information in the following format\n"
                            + "          (pl, seperate the following fields by a comma only)\n\n"+"Name,Registration Number etc(2015-EE-123),Degree(BS,MS or BE)", "Student Basic Information", 3);
                    option1(info1);
                    String opt=JOptionPane.showInputDialog(null, OPTIONS, "Uet Grade Book  (AFRAZ)", 2);
                    ShowDialogue(opt);
                    break;
                }
            case "2":
                {
                    String info2=JOptionPane.showInputDialog(null, "Pl, Enter the Course information in the following format\n"
                            + "          (pl, seperate the following fields by a comma only)\n\n"+"CourseID(2-8 letters),  Course Titlt(10-35 letters),  Credit Hours(1-3),  Semester(1-8),  Marks(0-100)", "Student Basic Information", 3);
                    option2(info2);
                    String opt=JOptionPane.showInputDialog(null, OPTIONS, "Uet Grade Book  (AFRAZ)", 2);
                    ShowDialogue(opt);
                    break;
                }
            case "3":
                {
                    String info3=JOptionPane.showInputDialog(null, "Enter Course ID to update Course...", "Update a Course", 3);
                    option3(info3);
                    String opt=JOptionPane.showInputDialog(null, OPTIONS, "Uet Grade Book  (AFRAZ)", 2);
                    ShowDialogue(opt);
                    break;
                }
            case "4":
                {
                    String info4=JOptionPane.showInputDialog(null, "Enter Course ID to delete the Course...", "Delete a Course", 3);
                    option4(info4);
                    String opt=JOptionPane.showInputDialog(null, OPTIONS, "Uet Grade Book  (AFRAZ)", 2);
                    ShowDialogue(opt);
                    break;
                }
            case "5":
                option5();
                break;
            case "6":
                {
                   // JOptionPane.showMessageDialog(null, getCGPA());
                     JOptionPane.showMessageDialog(null,  "CGPA: "+getCGPA(), "CGPA",0, null);
                    String opt=JOptionPane.showInputDialog(null, OPTIONS, "Uet Grade Book  (AFRAZ)", 2);
                    ShowDialogue(opt);
                    break;
                }
            case "7":
                {
                    option7();
                    String opt=JOptionPane.showInputDialog(null, OPTIONS, "Uet Grade Book  (AFRAZ)", 2);
                    ShowDialogue(opt);
                    break;
                }
            default:
                break;
        }
    }
    
    /**
     * the following method will be invoked if 4 is pressed in main dialogue
     * @param given 
     * String entered in "Delete a Course" Dialogue box or CourseID in this case
     */
    public void option4(String given)
    {
        // Following are the fields to show in Main dialogue
        String[] OPTIONS={"Choose any Option: ","\n","Choose 1 to set basic information of Student","Choose 2 to add new course to Grade Book"
                ,"Choose 3 to edit a course","Choose 4 to delete a course","Choose 5 to view all courses","Choose 6 to view CGPA","Choose 7 to view Detailed Marks Certificate"
        
        };
        int length=0;
        for(int f=0;f<Courses.size();f++)
        {
            if(!(Courses.get(f).getCourseID().equals(given)))
                    {
                     length++;
                     if(length==Courses.size())
                     {
                            // if ID doesn't equal to any Course in List then following message will popup
                       JOptionPane.showMessageDialog(null, "pl, Enter valid CourseID ");
                       String opt=JOptionPane.showInputDialog(null, OPTIONS, "Uet Grade Book  (AFRAZ)", 2);
                    ShowDialogue(opt);
                     }
                    }
        }
        for(int f=0;f<Courses.size();f++)
        {
            /**
             * comparing all CourseIDs with given one to Delete a Course
             */
            if(Courses.get(f).getCourseID().equals(given) )
            {
                Courses.remove(f);
            }
        }
    }
    
     /**
     * the following method will be invoked if 5 is pressed in main dialogue
     */
    
    public void option5()
    {
        String[] content=new String[Courses.size()]; // its the Array which will hold the DATA to show on "View Courses" Dialogue
          String[] ops={"Go to main menu","exit"};
          String[] OPTIONS={"Choose any Option: ","\n","Choose 1 to set basic information of Student","Choose 2 to add new course to Grade Book"
                ,"Choose 3 to edit a course","Choose 4 to delete a course","Choose 5 to view all courses","Choose 6 to view CGPA","Choose 7 to view Detailed Marks Certificate"
        
        };
        if(Courses.isEmpty())   //checking if Course List is Empty
        {
            
            int op=JOptionPane.showOptionDialog(null, "Pl Enter Courses 1st...", "Courses not found", 0, 3, null, ops, 0);
            if(op==0)
        {
            String opt=JOptionPane.showInputDialog(null, OPTIONS, "Uet Grade Book  (AFRAZ)", 2);  // generating Main Dialogue
            ShowDialogue(opt);
        }
            /**
             * checking if user presses OK or Cancel
             */
        else if(op==1)
        {
            System.exit(op);
        }
        }
        else
        {
            /**
             * showing all the Registered courses in a Output Dialogue 
             */
        for (int h=0;h<Courses.size();h++)
        {
            if(h==0)
                {
                     content[h]="ID             Name                                   CH     Marks     Grade\n"+Courses.get(h).toString()+"\n";             
                }
            else
            {
            content[h] =Courses.get(h).toString()+"\n";
            }
        }
        int op=JOptionPane.showOptionDialog(null, content, "Courses Registered", 0, 2, null, ops, 0);
        if(op==0)
        {
            String opt=JOptionPane.showInputDialog(null, OPTIONS, "Uet Grade Book  (AFRAZ)", 0);
            ShowDialogue(opt);
        }
        else if(op==1)
        {
            System.exit(op);
        }
        }
    }
    
    /**
     * following method will return number of semesters Entered
     * @return 
     */
    public int getSemesters()
    {
        int Semesters=0;
        for(int h=0;h<Courses.size();h++)
        {
           if(Semesters<Courses.get(h).getSemester())
           {
               Semesters=Courses.get(h).getSemester();
           }
        }
        
        return Semesters;
    }
    
    
    /**
     * following method will return a semester's GPA
     * @param Semester
     * it is used to know, which Semester's GPA method will return
     * @return 
     */
    public double getSemesterGPA(int Semester)
    {
        double GPA=0.0;
        double SemGradePoints=0.0;
        int SemCHs=0;
        for(int h=0;h<Courses.size();h++)
        {
            if(Semester==Courses.get(h).getSemester())
            {
               SemGradePoints+=Courses.get(h).getGradePoints();
               SemCHs+=Courses.get(h).getCreditHours();
            }
        }
        
        GPA=(SemGradePoints/SemCHs);
        
        return GPA;
    }
    
    /**
     * method will return Credit Hours of a Semester
     * @param Semester
     * Semester whose Credit Hours to be calculated
     * @return 
     */
    public int getSemesterCHs(int Semester)
    {
       
        int SemCHs=0;
        for(int h=0;h<Courses.size();h++)
        {
            if(Semester==Courses.get(h).getSemester())
            {
                SemCHs+=Courses.get(h).getCreditHours();
            } 
        }
        
              
        return SemCHs;
    }
    
    /**
     * following method will return total Credit Hours of all Semesters
     * @return 
     */
    public int getTotalCHs()
    {
        int TotalCHs=0;
        for(int h=0;h<Courses.size();h++)
        {
         TotalCHs+=Courses.get(h).getCreditHours();
        }
        
     return TotalCHs;   
    }
 
    /**
     * following method returns Discipline of Student
     * @return 
     */
    public String getDiscipline()
    {
        String []Discipline=Registration_Number.split("-");
        //System.out.println(Discipline[1]);
        return Discipline[1];
    }
    
    /**
     * returns Session of Student
     * @return 
     */
    public String getSession()
    {
        String session=Registration_Number.substring(0, 4);
        
        return session;
    }
    
    @Override   //  used to print all the GradeBook members in form of a String
    public String toString()
    {
        return StudentName+"   "+Registration_Number+"   "+Degree;
    }
    
    /**
     * following method returns Total GradePoints of all Semesters
     * @return 
     */
    
   public double getTotalGradePoints()
   {
       double TotalGradePoints=0;
       for(int h=0;h<Courses.size();h++)
       {
           TotalGradePoints+=Courses.get(h).getGradePoints();
       }
       
       return TotalGradePoints;
   }
   
   /**
    * returns CGPA 
    * @return 
    */
   public double getCGPA()
   {
       double CGPA=getTotalGradePoints()/getTotalCHs();
       
       return CGPA;
   }

     /**
     * the following method will be invoked if 7 is pressed in main dialogue
     */
   public void option7()
   {
       // fields to show in Main Dialogue
       String[] OPTIONS={"Choose any Option: ","\n","Choose 1 to set basic information of Student","Choose 2 to add new course to Grade Book"
                ,"Choose 3 to edit a course","Choose 4 to delete a course","Choose 5 to view all courses","Choose 6 to view CGPA","Choose 7 to view Detailed Marks Certificate"
        
        };
       int value=0;                                // this will hold the Int value  from the sub Dialogue Box (either to go to Main Menu or Exit)
        String[] ops={"Go to main menu","exit"};   // this array is used for the texts of sub DialogueBox's buttons
        String []content=new String[getSemesters()];   //it is the Array which'll hold DATA to show on DMC
        
        /**
         * checking whether Credentials of Student are set or not
         */
       if(StudentName.equals(""))
       {
           String content1="Pl, Enter Student's Credentials...";
           value=JOptionPane.showOptionDialog(null, content1, "Detailed Marks Certificate (DMC)", 0, 2, null, ops, 0);
           if(value==0)
        {
            String opt=JOptionPane.showInputDialog(null, OPTIONS, "Uet Grade Book  (AFRAZ)", 2);
            ShowDialogue(opt);

        }
        else if(value==1)
        {
            System.exit(value);
        }
           
       }
       
       /**
         * checking either Course List is empty or not
         */
       else if(getSemesters()==0)
       {
           String content1="Pl, Enter atleast one course to see DMC...";
           
                 //this will hold the Int value  from the sub Dialogue Box (either to go to Main Menu or Exit)
           value=JOptionPane.showOptionDialog(null, content1, "Detailed Marks Certificate (DMC)", 0, 2, null, ops, 0);
           if(value==0)
        {
             
            
            String opt=JOptionPane.showInputDialog(null, OPTIONS, "Uet Grade Book  (AFRAZ)", 2);
            ShowDialogue(opt);

        }
        else if(value==1)
        {
            System.exit(value);
        }
           
           
       }
       
       /**
        * here putting all courses DATA one by one in respective Semesters to show on DMC Dialogue 
        */
       for(int g=1;g<=getSemesters();g++)
       {
           content[g-1]="";
           if (g==1)
           {
               content[(g-1)]="NAME:     "+StudentName+"               DEGREE:  "+Degree+getDiscipline()+"\nREGISTRATION NUMBER:     "+Registration_Number+
               "\nSESSION:     "+getSession()+"\n-----------------------------------------------------------------------------\n";
           }
             
           String conc=content[g-1].concat("Semester "+g+":\n"+"          ID                  Name                                   CH     Marks     Grade\n");
             
            
           for(int v=0;v<Courses.size();v++)
           {
               
               if(Courses.get(v).getSemester()==(g))
               {  
                          conc= conc.concat("          "+Courses.get(v).toString()+"\n")  ;
                          
               }
               
           }
           if(g==getSemesters())
           {
               content[g-1]= conc.concat("\n                                                                  SGPA: "+getSemesterGPA(g)+
                       "\n----------------------------------------------------------------------------\n                                         CGPA: "+getCGPA());     
           }
           else
           {
               content[g-1]= conc.concat("\n                                                        SGPA: "+getSemesterGPA(g))+"\n------------------------------------------------------------------";
           }
          
           
       }
        
     //this will hold the Int value  from the sub Dialogue Box (either to go to Main Menu or Exit)
        value=JOptionPane.showOptionDialog(null, content, "Detailed Marks Certificate (DMC)", 0, 0, null, ops, 0);
       if(value==0)
        {
            String opt=JOptionPane.showInputDialog(null, OPTIONS, "Uet Grade Book  (AFRAZ)", 0);
            ShowDialogue(opt);

        }
        else if(value==1)
        {
            System.exit(value);
        }
   }

}