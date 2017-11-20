/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

/**
 * @author AFRAZ
 * 
 * Class to show the result of a Specific Course
 */
public class CourseResult {

    private String CourseID;
    private String CourseTitle;
    private int CreditHours;
    private int Marks;
    private int Semester;
    
    /**
     * No-Parameter Constructor for CourseResult class 
     */
    public CourseResult()
    {
        CourseID="";
        CourseTitle="";
        CreditHours=0;
        Marks=0;
        Semester=0;
    }
    /**
     * Constructor with Parameters
     * Course ID
     * @param CID
     * @param CTI
     * @param CH
     * @param M
     * @param S 
     */
    public CourseResult(String CID,String CTI,int CH,int M,int S)
    {
        CourseID=CID;
        CourseTitle=CTI;
        CreditHours=CH;
        Marks=M;
        Semester=S;
    }
    
    /**
     * A Copy Constructor for CourseResult class
     * @param CR 
     * CR is the CourseResult object which have to be copied
     */
    public  CourseResult(CourseResult CR)
    {
        this.CourseID=CR.CourseID;
        this.CourseTitle=CR.CourseTitle;
        this.CreditHours=CR.CreditHours;
        this.Marks=CR.Marks;
        this.Semester=CR.Semester;
    }

    /**
     *       all   Getters
     * 
     */
    public String getCourseID() {
        return CourseID;
    }

    public String getCourseTitle() {
        return CourseTitle;
    }

    public int getCreditHours() {
        return CreditHours;
    }

    public int getMarks() {
        return Marks;
    }

    public int getSemester() {
        return Semester;
    }
/**
 *       all     Setters
 * 
 */
    public void setCourseID(String CourseID) {
      
        if(CourseID.length()<2||CourseID.length()>8)
        {
            System.out.println("CourseID must be from 2-8 Letters...");
            System.exit(80);
        }
        else
        {
        this.CourseID = CourseID;
    }
    }

    public void setCourseTitle(String CourseTitle) {
        if(CourseTitle.length()<10||CourseTitle.length()>35)
        {
            System.out.println("CourseTitle must be from 10-35 Letters...");
            System.exit(80);
        }
        else
        {
        this.CourseTitle = CourseTitle;
    }
    }

    public void setCreditHours(int CreditHours) {
        
         if(CreditHours<1||CreditHours>3)
        {
            System.out.println("CreditHours must be from 1-3 Letters...");
            System.exit(105);
        }
        else
        {
        this.CreditHours = CreditHours;
    }
    }

    public void setMarks(int Marks) {
        if(Marks<0||Marks>100)
        {
            System.out.println("Marks must be from 0-100 Letters...");
            System.exit(105);
        }
        else if(Marks>=0||Marks<=100)
        {
        this.Marks = Marks;
    }
    }

    public void setSemester(int Semester) {
        if(Semester<0||Semester>100)
        {
            System.out.println("Semesters must be from 1-8 Letters...");
            System.exit(105);
        }
        else
        {
        this.Semester = Semester;
    }
        
        
    }
   
    /**
     * the following method will return a GRADE based on Marks member
     * @return 
     */
    public String getGrade()
    {
             String GRADE="";
        if(Marks<=40)
        {
            GRADE="F";
        }
        else if(Marks<=50&&Marks>40)
        {
            GRADE="D";
        }
        else if(Marks>50&&Marks<=55)
        {
            GRADE="C";
        }
        else if(Marks>55&&Marks<=60)
        {
            GRADE="C+";
        }
        else if(Marks>60&&Marks<=65)
        {
            GRADE="B-";
        }
        else if(Marks>65&&Marks<=70)
        {
            GRADE="B+";
        }
        else if(Marks>70&&Marks<=80)
        {
            GRADE="A-";
        }
        else if(Marks>80)
        {
            GRADE="A";
        }
        //System.out.println(GRADE);
        return GRADE;
    }
    
    /**
     * the following method will return Grade-Points for a specific Course
     * @return 
     */
    public double getGradePoints()
    {
        double GP=0;
        switch (getGrade()) {
            case "F":
                GP=0.0;
                break;
            case "D":
                GP=1.0;
                break;
            case "C":
                GP=2.3;
                break;
            case "C+":
                GP=2.7;
                break;
            case "B-":
                GP=3.0;
                break;
            case "B+":
                GP=3.3;
                break;
            case "A-":
                GP=3.7;
                break;
            case "A":
                GP=4.0;
                break;
            default:
                break;
        }
        
        double GPs=GP*CreditHours;
        
        return GPs;
    }
    
    /**
     * this method will return a String containing all attributes with set values
     * @return 
     */
    @Override
    public String toString()
    {
        return CourseID+"        "+CourseTitle+"            "+CreditHours+"        "+Marks+"        "+getGrade();
    }
    
    
}

