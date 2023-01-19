package databaseCEMS;

import collegeexaminationmanagementsystem.Tools;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.ExamModel;

public class CollegeExaminationDatabase {

    private static String dbUrl = "jdbc:sqlserver://HP-PC:1433;databaseName=CollegeExamination2 ";
    private static  String dbUsername = "PC-HP";
    private static  String dbPassword = "123321";
    private static Connection dbConnection;

    //Connection to Database
    public static void setConnection(){
        try {
            //System.out.println("Start");
            dbConnection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        }
        catch (SQLException ex) {
            System.out.println("ErrorSQL - Connection to Database.");
            Tools.errmsgBox("ErrorSQL - Connection to Database.");
        }
    }
    
    public static boolean login (String username , String password ,String[] userInfo) {
        try {
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Check User Validity form this Username & Password ( in SQL Server ).
            String strCheck = "select * from Users where "
                    + "Username ='" + username + "' and "
                    + "Password ='" + password + "'";
            ResultSet resultSet = stmt.executeQuery(strCheck);
            while (resultSet.next()) {
                //get and set userInfo              
                userInfo[0]= (String) resultSet.getString("Id");
                userInfo[1]= (String) resultSet.getString("Name");
                userInfo[2]= (String) resultSet.getString("Email");
                userInfo[3]= (String) resultSet.getString("Birthday");
                userInfo[4]= (String) resultSet.getString("Username");
                userInfo[5]= (String) resultSet.getString("Password");
                userInfo[6]= (String) resultSet.getString("Id_Module");            
                // close SQL Server.
                dbConnection.close();
                // check successfully.
                return true;
            }
            dbConnection.close();
        } catch (SQLException ex) {
            System.out.println("Not Found");
        }
        // check failed.
        return false;
    }

    public static boolean updateInfo (int id,String name, String email, String birthday, String username, String password, int idModule){
        try {
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Update User ( in SQL Server ).
            String strUp = "UPDATE Users SET " +
                    "Name ='" + name+ "'," +
                    "username ='" +username+ "'," +
                    "email ='" + email+ "'," +
                    "Password ='" + password + "'," +
                    "Birthday ='" + birthday + "'," +
                    "Id_Module = " + idModule +
                    "WHERE Id= " + id ;
            stmt.execute(strUp);
            // close SQL Server.
            dbConnection.close();
            // update successfully.
            Tools.msgBox("update successfully");
            return true;
        }catch (SQLException ex){
            System.out.println("Update failed");
        }
        // update Profile failed.
        return false;
    }

    public static boolean updateInfo (int id,int idModule){
        try {
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Update User ( in SQL Server ).
            String strUp = "UPDATE Users SET " +
                    "Id_Module = " + idModule +
                    "WHERE Id= " + id ;
            stmt.execute(strUp);
            // close SQL Server.
            dbConnection.close();
            // update successfully.
            Tools.msgBox("update successfully");
            return true;
        }catch (SQLException ex){
            System.out.println("Update failed");
        }
        // update Profile failed.
        return false;
    }

    public static boolean addNewUser (String name, String username, String password, int idModule){
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Add User ( in SQL Server ).
            String strAdd = "INSERT INTO Users (Name,Username,Password,Id_Module) "
                    + "VALUES ('"+ name +"','"+ username + "','" + password +"'," + idModule +")";
            // Add this user
            stmt.execute(strAdd);
            // close SQL Server.
            dbConnection.close();
            Tools.msgBox("Added successfully");
            return true;
        }
        catch(SQLException ex ){
            Tools.errmsgBox("Wrong Username");
        }
        // check failed.
        return false;
    }

    public static boolean deleteUser (int id){
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Delete User id = ....
            String strdelt = "DELETE FROM Users WHERE Id = " + id ;
            // Delete User
            stmt.execute(strdelt);
            // close SQL Server.
            dbConnection.close();
            Tools.msgBox("Delete successfully");
            return true;
        }
        catch(SQLException ex ){
            System.out.println("Delete failed");
        }
        // check failed.
        return false;
    }

    public static int countStudents() {
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // count Student  ( in SQL Server ).
            String strCount = "SELECT COUNT(Id) AS NumberOfStudent  FROM Users where Id_Module = 3";
            // Return Number of Student 
            ResultSet resultSetNum = stmt.executeQuery(strCount);
            while( resultSetNum.next() ){
                // Get number from Database.
                int num = (int) resultSetNum.getInt("NumberOfStudent");
                // close SQL Server.
                dbConnection.close();
                // Count UsersModel successfully.
                return num;
            }
            dbConnection.close();
        }
        catch(SQLException ex){
          Tools.msgBox(ex.getMessage());
        }      
        return 0;
        
    }

    public static int countSubjects() {
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // count Subjects  ( in SQL Server ).
            String strCount = "SELECT COUNT(Id) AS NumberOfSubjects  FROM Subject";
            // Return Number of Subjects 
            ResultSet resultSetNum = stmt.executeQuery(strCount);
            while( resultSetNum.next() ){
                // Get number from Database.
                int num = (int) resultSetNum.getInt("NumberOfSubjects");
                // close SQL Server.
                dbConnection.close();
                // Count UsersModel successfully.
                return num;
            }
            dbConnection.close();
        }
        catch(SQLException ex){
          Tools.msgBox(ex.getMessage());
        }      
        return 0;
        
    }

    public static int countLecturers() {
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // count Lecturers  ( in SQL Server ).
            String strCount = "SELECT COUNT(Id) AS NumberOfLecturers  FROM Users where Id_Module = 2";
            // Return Number of Lecturers 
            ResultSet resultSetNum = stmt.executeQuery(strCount);
            while( resultSetNum.next() ){
                // Get number from Database.
                int num = (int) resultSetNum.getInt("NumberOfLecturers");
                // close SQL Server.
                dbConnection.close();
                // Count UsersModel successfully.
                return num;
            }
            dbConnection.close();
        }
        catch(SQLException ex){
          Tools.msgBox(ex.getMessage());
        }      
        return 0;
        
    }

    
    public static void  viewStudents (JTable tableStudents){
        String strSelect = "SELECT Student.Id\n" +
            ",Student.Name\n" +
            ",Student.Email\n" +
            ",Student.Birthday\n" +
            ",Student.Username\n" +
            ",TNumOfSubject.NumOfSubject\n" +
            "FROM Users Student ,\n" +
            "(SELECT Stu.Id, COUNT (SubjectOfStudent.Id_Subject) As NumOfSubject\n" +
            "FROM\n" +
            "SubjectOfStudent \n" +
            "RIGHT JOIN\n" +
            "Users Stu	ON SubjectOfStudent.Id_Student = Stu.Id\n" +
            "WHERE\n" +
            "Stu.Id_Module=3\n" +
            "GROUP BY \n" +
            "Stu.Id) TNumOfSubject\n" +
            "WHERE Id_Module =3 and TNumOfSubject.Id =Student.Id";       
        fillToJTable (strSelect , tableStudents);     
    }
    
    // Set Any Table 
    private static void fillToJTable(String tableNameOrSelectStatement, JTable table){
        try{
            setConnection();
            Statement stmt = dbConnection.createStatement();
            ResultSet records;
            String SPart = tableNameOrSelectStatement.substring(0, 7).toLowerCase();
            String strSelect;
            if( "select ".equals( SPart ) ){
                strSelect = tableNameOrSelectStatement;
            }
            else{
                strSelect = "select * from " + tableNameOrSelectStatement;
            }
            records = stmt.executeQuery(strSelect);
            
            int col = records.getMetaData().getColumnCount();
            
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Vector row = new Vector();
            model.setRowCount(0);
           
            while(records.next()){
                row = new Vector(col);
                for(int i = 1 ; i <= col ; i++){
                    row.add(records.getString(i));
                }
                model.addRow(row);
            }
            if(table.getColumnCount() != col){
                Tools.msgBox("JTable Columns Count Not Equal To Query Columns Count \n JTable Columns Count Is: " 
                        + table.getColumnCount() 
                        + "\n Query Columns Count Is: " + col);
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            Tools.msgBox(ex.getMessage());
        }
      }
    public static void searchStudent (String username ,JTable tableStudent){
        String strSelect =  "SELECT Student.Id\n" +
            ",Student.Name\n" +
            ",Student.Email\n" +
            ",Student.Birthday\n" +
            ",Student.Username\n" +
            ",TNumOfSubject.NumOfSubject\n" +
            "FROM Users Student ,\n" +
            "(SELECT Stu.Id, COUNT (SubjectOfStudent.Id_Subject) As NumOfSubject\n" +
            "FROM\n" +
            "SubjectOfStudent \n" +
            "RIGHT JOIN\n" +
            "Users Stu	ON SubjectOfStudent.Id_Student = Stu.Id\n" +
            "WHERE\n" +
            "Stu.Id_Module=3\n" +
            "GROUP BY \n" +
            "Stu.Id) TNumOfSubject\n" +
            "WHERE Id_Module =3 and TNumOfSubject.Id =Student.Id \n" +
            "and Username LIKE '" + username + "%'";       
        fillToJTable (strSelect , tableStudent);     
    }

    public static void viewLecturer(JTable tableLecturer) {
        String strSelect = "SELECT Lecturer.Id\n" +
            ",Lecturer.Name\n" +
            ",Lecturer.Email\n" +
            ",Lecturer.Birthday\n" +
            ",Lecturer.Username\n" +
            ",TNumOfSubject.NumOfSubject\n" +
            "FROM Users Lecturer ,\n" +
            "(SELECT Lec.Id, COUNT (AssignSubject.Id_Subject) As NumOfSubject\n" +
            "FROM\n" +
            "AssignSubject \n" +
            "RIGHT JOIN\n" +
            "Users Lec	ON AssignSubject.Id_Lecturer = Lec.Id\n" +
            "WHERE\n" +
            "Lec.Id_Module=2\n" +
            "GROUP BY \n" +
            "Lec.Id) TNumOfSubject\n" +
            "WHERE Id_Module =2 and TNumOfSubject.Id = Lecturer.Id";
        fillToJTable (strSelect , tableLecturer); 
    }

    public static void searchLecturer(String strUsername, JTable jTableLecturer) {
        String strSelect = "SELECT Lecturer.Id\n" +
            ",Lecturer.Name\n" +
            ",Lecturer.Email\n" +
            ",Lecturer.Birthday\n" +
            ",Lecturer.Username\n" +
            ",TNumOfSubject.NumOfSubject\n" +
            "FROM Users Lecturer ,\n" +
            "(SELECT Lec.Id, COUNT (AssignSubject.Id_Subject) As NumOfSubject\n" +
            "FROM\n" +
            "AssignSubject \n" +
            "RIGHT JOIN\n" +
            "Users Lec	ON AssignSubject.Id_Lecturer = Lec.Id\n" +
            "WHERE\n" +
            "Lec.Id_Module=2\n" +
            "GROUP BY \n" +
            "Lec.Id) TNumOfSubject\n" +
            "WHERE Id_Module =2 and TNumOfSubject.Id = Lecturer.Id\n"+
            "and Username LIKE '" + strUsername + "%'"; 
        fillToJTable (strSelect , jTableLecturer);
    }

    public static void viewSubjects(JTable tableSubjects) {
         String strSelect = "SELECT one.Id,one.Name,one.Details , one.LecturerName , two.num\n" +
            "from (SELECT sub.Id,sub.Name,sub.Details ,lec.Name As LecturerName\n" +
            "FROM AssignSubject subLec \n" +
            "inner JOIN \n" +
            "Users lec on\n" +
            "lec.Id = subLec.Id_Lecturer\n" +
            "right JOIN \n" +
            "Subject sub on\n" +
            "sub.Id = subLec.Id_Subject) one \n" +
            "Left JOIN \n" +
            "(SELECT SubjectOfStudent.Id_Subject as twoId_Subject ,count(SubjectOfStudent.Id_Subject) as num \n" +
            "from SubjectOfStudent\n" +
            "GROUP BY \n" +
            "SubjectOfStudent.Id_Subject) two\n" +
            "on\n" +
            "two.twoId_Subject = one.Id";       
        fillToJTable (strSelect , tableSubjects); 
    }

    public static void searchSubject(String strName, JTable jTableSubjects) {
        String strSelect = "SELECT one.Id,one.Name,one.Details , one.LecturerName , two.num\n" +
            "from (SELECT sub.Id,sub.Name,sub.Details ,lec.Name As LecturerName\n" +
            "FROM AssignSubject subLec \n" +
            "inner JOIN \n" +
            "Users lec on\n" +
            "lec.Id = subLec.Id_Lecturer\n" +
            "right JOIN \n" +
            "Subject sub on\n" +
            "sub.Id = subLec.Id_Subject) one \n" +
            "Left JOIN \n" +
            "(SELECT SubjectOfStudent.Id_Subject as twoId_Subject ,count(SubjectOfStudent.Id_Subject) as num \n" +
            "from SubjectOfStudent\n" +
            "GROUP BY \n" +
            "SubjectOfStudent.Id_Subject) two\n" +
            "on\n" +
            "two.twoId_Subject = one.Id\n"+
            "WHERE one.Name LIKE '" + strName + "%'";     
        fillToJTable (strSelect , jTableSubjects); 
    }

    public static void deleteSubject(int idSubject) {
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Delete Subject id = ....
            String strdelt = "DELETE FROM Subject WHERE Id = " + idSubject ;
            // Delete Subject
            stmt.execute(strdelt);
            // close SQL Server.
            dbConnection.close();
            Tools.msgBox("Delete successfully");
        }
        catch(SQLException ex ){
            System.out.println("Delete failed");
        }
        // check failed.
    }

    public static void addSubject(String name, String details, int idLuc) {
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Add Subject ( in SQL Server ).
            String strAdd = "INSERT INTO Subject (Name,Details) OUTPUT Inserted.Id "
                    + "VALUES ('"+ name + "','" + details + "')";
            // Return ID from this Subject
            ResultSet resultSetID = stmt.executeQuery(strAdd);
            while( resultSetID.next() ){
                // Get Id from Database.            
                int dbId = (int) resultSetID.getInt("Id");
                Tools.msgBox("Add Subject Successfully");             
                // set Id_Lecturer in AssignSubject.
                    if(!setIdInAssignSubject(dbId,idLuc))
                        Tools.msgBox("Wrong!! Id _Lecturer");
                // close SQL Server.
                dbConnection.close();
                // Add successfully.
            }
            dbConnection.close();
        }
        catch(SQLException ex ){
          Tools.errmsgBox("Wrong!!");
        }
        // check failed.
    }

    private static boolean setIdInAssignSubject(int dbId, int idLuc) {
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Add Id s ( in SQL Server ).
            String strAdd = "INSERT INTO AssignSubject (Id_Subject,Id_Lecturer) "
                    + "VALUES ("+ dbId +","+ idLuc + ")";
            // Add id s
            stmt.execute(strAdd);
            // close SQL Server.
            dbConnection.close();
            return true;
        }
        catch(SQLException ex ){    //Errer 
        }
        // check failed.
        return false;
    }

    public static void updateSubject(int idSubject, String name, String details) {
        try {
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Update User ( in SQL Server ).
            String strUp = "UPDATE Subject SET " +
                    "name = '" + name + "'," +
                    "details ='" + details + "' "+
                    "WHERE Id= " + idSubject ;
            stmt.execute(strUp);
            // close SQL Server.
            dbConnection.close();
            // update successfully.
            Tools.msgBox("update successfully");
        }catch (SQLException ex){
            Tools.errmsgBox("Update failed");
        }
        // update Profile failed.
    }
    
    public static void viewSubjectsOfLec (JTable tableSubjects , int idLec ,String strName) {
        String strSelect = "SELECT one.Id,one.Name,one.Details , two.num\n" +
            "from (SELECT sub.Id,sub.Name,sub.Details ,lec.Name As LecturerName ,lec.Id as IdLec\n" +
            "FROM AssignSubject subLec \n" +
            "inner JOIN \n" +
            "Users lec on\n" +
            "lec.Id = subLec.Id_Lecturer\n" +
            "right JOIN \n" +
            "Subject sub on\n" +
            "sub.Id = subLec.Id_Subject) one \n" +
            "Left JOIN \n" +
            "(SELECT SubjectOfStudent.Id_Subject as twoId_Subject ,count(SubjectOfStudent.Id_Subject) as num\n" +
            "from SubjectOfStudent\n" +
            "GROUP BY \n" +
            "SubjectOfStudent.Id_Subject) two\n" +
            "on\n" +
            "two.twoId_Subject = one.Id\n" +
            "where one.IdLec = " + idLec +
            "\n and one.Name LIKE '" + strName + "%'";   
        fillToJTable (strSelect , tableSubjects); 
    }

    public static void searchSubjectOfLec(JTable tableSubjects , int idLec ,String strName) {
        viewSubjectsOfLec( tableSubjects ,  idLec , strName);
    }


    public static void viewExams(JTable jTableExams, int idSubjectInTable) {
        String strSelect = "SELECT ex.Id, sub.Name, ex.Name,ex.Details\n" +
                "  FROM Exam ex\n" +
                "inner JOIN \n" +
                "Subject sub on ex.Id_Subject = sub.Id \n"+
                "where ex.Id_Subject = " +idSubjectInTable;
        fillToJTable (strSelect , jTableExams); 
    }

    public static void viewQuestions(JTable tableQuestions, int idExamInTable) {
        String strSelect = "SELECT Id\n" +
                ",Question,  Degree\n" +
                "FROM Question\n" +
                "where Id_Exam = " + idExamInTable;
        fillToJTable (strSelect , tableQuestions);
    }

    public static void deleteExam(int idExam) {
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Delete Exam id = ....
            String strdelt = "DELETE FROM Exam WHERE Id = " + idExam ;
            // Delete Exam
            stmt.execute(strdelt);
            // close SQL Server.
            dbConnection.close();
            Tools.msgBox("Delete successfully");
        }
        catch(SQLException ex ){
            System.out.println("Delete failed");
        }
        // check failed.
    }

    public static void renameExam(int id, String name, String details) {
         try {
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Update Exam ( in SQL Server ).
            String strUp = "UPDATE Exam SET " +
                    "name = '" + name + "'," +
                    "details ='" + details + "' "+
                    "WHERE Id= " + id ;
            stmt.execute(strUp);
            // close SQL Server.
            dbConnection.close();
            // update successfully.
            Tools.msgBox("update successfully");
        }catch (SQLException ex){
            // update Profile failed.
            Tools.errmsgBox("Update failed");
        }
        
    }

    public static void renameQuestion(int id, String name) {
        try {
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Update Question ( in SQL Server ).
            String strUp = "UPDATE Question SET " +
                    "Question = '" + name + "' " +
                    "WHERE Id= " + id ;
            stmt.execute(strUp);
            // close SQL Server.
            dbConnection.close();
            // update successfully.
            Tools.msgBox("update successfully");
        }catch (SQLException ex){
            // update Profile failed.
            Tools.errmsgBox("Update failed");
        }
    }

    public static String[] getChoice(int id) {
        String[] question = new String[8];
        int i =0;
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Get  Choice  ( in SQL Server ).
            String strSelect = "SELECT Choice\n" +
                                ",T_F\n" +
                                "FROM Choice\n" +
                                "WHERE Id_Question = " + id;
            // Return Choice of Question 
            ResultSet resultSetNum = stmt.executeQuery(strSelect);
            while( resultSetNum.next() ){
                // Get Choice from Database.
                 String choice = resultSetNum.getString("Choice");
                 String tf = resultSetNum.getString("T_F");
                 question[i] = choice;
                 question[i+1] = tf;
                 i=i+2;
            }       
            dbConnection.close();
            return question;
        }
        catch(SQLException ex){
          Tools.msgBox(ex.getMessage());
        }      
        return question;
    }

    public static void setChoice(String q1, String q2, String q3, String q4, int tf,int id) {
        try {
            String [] question = {q1,q2,q3,q4};
            setConnection();
            // Open SQL Server
            Statement stmt1 = dbConnection.createStatement();
            Statement stmt2 = dbConnection.createStatement();
            
            // Update Question ( in SQL Server ).
            String strSelect = "SELECT Id\n" +
                                "FROM Choice\n" +
                                "WHERE Id_Question = " + id;
            // Return Choice of Question 
            ResultSet resultSetNum = stmt1.executeQuery(strSelect);
            int i=0;            
            while( resultSetNum.next() ){
                // Get Choice from Database.
                int ctf=0;
                int idChoice = resultSetNum.getInt("ID");
                if(i+1==tf)
                    ctf=1;
                String strUp = "UPDATE Choice SET " +
                    "Choice = '" + question[i] + "' ,\n " +
                    "T_F = " + ctf +
                    " \nWHERE Id= " + idChoice ;
                stmt2.execute(strUp);
                i++;        
            }
            dbConnection.close();
            // update successfully.
            Tools.msgBox("update successfully");
        }catch (SQLException ex){
            // update Profile failed.
            Tools.errmsgBox("Update failed");
        }
    }

    public static void viewStudentDegree(JTable tableStudentDegree, int id) {
        String strSelect = "SELECT Sd.Id ,Ex.Id ,Ex.Name AS Name_Exam , Sd.Id_Student , Users.Name , Sd.Degree\n" +
                                "FROM StudentDegree Sd\n" +
                                "JOIN Users \n" +
                                "ON Sd.Id_Student = Users.Id\n" +
                                "JOIN Exam Ex \n" +
                                "ON Sd.Id_Exam = Ex.Id\n" +
                                "WHERE\n" +
                                "Ex.Id_Subject = " + id ;               
        fillToJTable (strSelect , tableStudentDegree); 
    }
    public static void searchIdStudent(JTable tableStudentDegree, int id,int sId) {
        String strSelect = "SELECT Sd.Id , Ex.Name AS Name_Exam , Sd.Id_Student , Users.Name , Sd.Degree\n" +
                                "FROM StudentDegree Sd\n" +
                                "JOIN Users \n" +
                                "ON Sd.Id_Student = Users.Id\n" +
                                "JOIN Exam Ex \n" +
                                "ON Sd.Id_Exam = Ex.Id\n" +
                                "WHERE\n" +
                                "Ex.Id_Subject = " + id +        
        " AND Id_Student LIKE  '" + sId + "%'"; 
        fillToJTable (strSelect , tableStudentDegree); 
    }

    public static void viewReports(JTable tableReports,int idLecturer) {
            String strSelect = "SELECT StuRe.Id , StuRe.Id_Student , Users.Name , Ex.Name , StuRe.Report\n" +
                                    "FROM StudentReport StuRe\n" +
                                    "JOIN Users ON \n" +
                                    "StuRe.Id_Student = Users.Id\n" +
                                    "JOIN Exam Ex ON \n" +
                                    "StuRe.Id_Exam = Ex.Id\n" +
                                    "WHERE StuRe.Id_Lecturer =  " + idLecturer;               
        fillToJTable (strSelect , tableReports); 
    }
    public static void viewReportsStudent (JTable tableReports,int idStudent) {
            String strSelect = "SELECT StuRe.Id , StuRe.Id_Lecturer , Users.Name , Ex.Name , StuRe.Report \n" +
                                "FROM StudentReport StuRe\n" +
                                "JOIN Users ON \n" +
                                "StuRe.Id_Lecturer = Users.Id\n" +
                                "JOIN Exam Ex ON\n" +
                                "StuRe.Id_Exam = Ex.Id\n" +
                                "WHERE StuRe.Id_Student =  " + idStudent;  
            
        fillToJTable (strSelect , tableReports); 
    }

    public static void deleteReport(int idReport) {
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Delete Report id = ....
            String strdelt = "DELETE FROM StudentReport WHERE Id = " + idReport ;
            // Delete Report
            stmt.execute(strdelt);
            // close SQL Server.
            dbConnection.close();
            Tools.msgBox("Delete successfully");
        }
        catch(SQLException ex ){
            System.out.println("Delete failed");
        }
        // check failed.
    }

    public static void searchReport(JTable tableReports, int idLecturer , int IdStudent) {
        String strSelect = "SELECT StuRe.Id , StuRe.Id_Student , Users.Name , Ex.Name , StuRe.Report\n" +
                "FROM StudentReport StuRe\n" +
                "JOIN Users ON \n" +
                "StuRe.Id_Student = Users.Id\n" +
                "JOIN Exam Ex ON \n" +
                "StuRe.Id_Exam = Ex.Id\n" +
                "WHERE StuRe.Id_Lecturer =  " + idLecturer +
                " AND StuRe.Id_Student LIKE  '" + IdStudent + "%'";               
        fillToJTable (strSelect , tableReports); 
    }

    public static int addExam(int intIdSubject, String name, String details) {
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Add Exam ( in SQL Server ).
            String strAdd = "INSERT INTO Exam (Id_Subject,Name,Details) OUTPUT Inserted.Id "
                    + "VALUES ("+ intIdSubject + ",'"+ name + "','" + details + "')";
            // Return ID from this Exam
            ResultSet resultSetID = stmt.executeQuery(strAdd);
            while( resultSetID.next() ){
                // Get Id from Database.            
                int dbId = (int) resultSetID.getInt("Id");
                Tools.msgBox("Add Exam Successfully");                
                // close SQL Server.
                dbConnection.close();
                // Add successfully.
                return dbId;
            }           
            dbConnection.close();}
        catch(SQLException ex ){
          Tools.errmsgBox("Wrong!!");
        }
        return 0;
    }

    public static void addQuestion(int idExam, String q, String ch1, int tf1, String ch2, int tf2, String ch3, int tf3, String ch4, int tf4, int examDegree) {
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Add Question ( in SQL Server ).
            String strAdd = "INSERT INTO Question (Id_Exam,Question,Degree) OUTPUT Inserted.Id "
                    + "VALUES ("+ idExam + ",'"+ q + "'," + examDegree + ")";
            // Return ID from this Question
            ResultSet resultSetID = stmt.executeQuery(strAdd);
            while( resultSetID.next() ){
                // Get Id from Database.            
                int dbId = (int) resultSetID.getInt("Id");
                System.out.println(dbId);
               if(addChoice(dbId,ch1,tf1,ch2,tf2,ch3,tf3,ch4,tf4))
                Tools.msgBox("Add Question Successfully");                
                // Add successfully.              
            }   
            // close SQL Server.
            dbConnection.close();}
        catch(SQLException ex ){
          Tools.errmsgBox("Wrong!!");
        }
    }
    private static boolean addChoice (int idQuestion, String ch1, int tf1, String ch2, int tf2, String ch3, int tf3, String ch4, int tf4){
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // add Choice ( in SQL Server ).
            String strAdd = "INSERT INTO Choice (Id_Question,Choice,T_F) "
                    + "VALUES ("+ idQuestion +",'"+ ch1 + "'," + tf1 +")," +
                    "("+ idQuestion +",'"+ ch2 + "'," + tf2 +"),"+
                    "("+ idQuestion +",'"+ ch3 + "'," + tf3 +"),"+
                    "("+ idQuestion +",'"+ ch4 + "'," + tf4 +")";
            // add Choice
            System.out.println(strAdd);
            stmt.execute(strAdd);
            // close SQL Server.
            dbConnection.close();
            return true;
        }
        catch(SQLException ex ){    //Errer 
        }
        // check failed.
        return false;
    }

    public static void viewSubjectsStudent(JTable jTableSubjects, int id, String strNamesearchSubject) {
        String strSelect = "SELECT Sub.Id , Sub.Name , Sub.Details\n" +
                        "FROM SubjectOfStudent SOF\n" +
                        "JOIN Subject Sub ON\n" +
                        "Sub.Id = SOF.Id_Subject\n" +
                        "where SOF.Id_Student = " + id +
                        "\n AND Sub.Name LIKE '"+ strNamesearchSubject +"%'";               
        fillToJTable (strSelect , jTableSubjects);
    }  

    public static boolean cheExam(int idExam, int id) {
        try {
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Check Student ( in SQL Server ).
            String strCheck = "select * from StudentDegree where "
                    + "Id_Exam =" + idExam + " and "
                    + "Id_Student =" + id + "";
            ResultSet resultSet = stmt.executeQuery(strCheck);
            while (resultSet.next()) {
                // close SQL Server.
                dbConnection.close();
                // check failed.
                return false;
            }
            dbConnection.close();
        } catch (SQLException ex) {
            System.out.println("Not Found");
        }
        // check successfully.
        return true;
    }


    public static void setIdQuestionsToDo (ExamModel examModel) {
        try {
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            int idExam = examModel.getIdExam();
            // Check Student ( in SQL Server ).
            String strCheck = "select * from Question where "
                    + "Id_Exam =" + idExam;
            ResultSet resultSet = stmt.executeQuery(strCheck);
            while (resultSet.next()) {
                examModel.setIdQuestion(resultSet.getInt("Id"));
                examModel.setQuestion(resultSet.getString("Question"));
                examModel.setDegree(resultSet.getInt("Degree"));
                examModel.plusCountOfQuestions();             
            }
            // close SQL Server.
            dbConnection.close();
        } catch (SQLException ex) {
            System.out.println("Not Found");
        }
    }
    public static String getChoiceToDo(int idQuestion,ArrayList<Integer> tChoice,ArrayList<String> answer ) {
        try {
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            String Choice="";
            char i = 'A';
            // Check Student ( in SQL Server ).
            String strCheck = "select * from Choice where "
                    + "Id_Question =" + idQuestion;
            ResultSet resultSet = stmt.executeQuery(strCheck);
            while (resultSet.next()) {
                Choice = Choice + "\n" + i + ".  " + resultSet.getString("Choice");             
                if(resultSet.getInt("T_F")==1)
                    answer.add(resultSet.getString("Choice"));
                tChoice.add(resultSet.getInt("T_F"));               
                i++;
            }
            // close SQL Server.
            dbConnection.close();
            return Choice;           
        } catch (SQLException ex) {
            System.out.println("Not Found");
        }
        return "";
    }
    

/* private static void setChoiceToDo(ExamModel examModel) {
        try {
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            ArrayList<Integer> idQuestions = examModel.getIdQuestions();
            for (int idQuestion :idQuestions ){
                // Get Choice ( in SQL Server ).
                String strCheck = "select * from Choice where "
                        + "Id_Question =" + idQuestion;
                ResultSet resultSet = stmt.executeQuery(strCheck);
                while (resultSet.next()) {
                    examModel.setchoice(resultSet.getString("Choice"));
                    examModel.setTChoice(resultSet.getInt("T_F"));
                }
            }
            // close SQL Server.
            dbConnection.close();
        } catch (SQLException ex) {
            System.out.println("Not Found");
        }
    }*/

    public static void setDegree(int idExam, int id, int degree) {
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // add Choice ( in SQL Server ).
            String strAdd = "INSERT INTO StudentDegree (Id_Exam,Id_Student,Degree) "
                    + "VALUES ("+ idExam +","+ id + "," + degree +")";
            // add Choice
            stmt.execute(strAdd);
            // close SQL Server.
            dbConnection.close();
        }
        catch(SQLException ex ){    //Errer 
        }
        
    }

    public static void viewDegrees(JTable tableDegrees,int id  , String strNameExam) {
        String strSelect = "SELECT SD.Id , Sub.Name , EX.Name, SD.Degree\n" +
                            "FROM StudentDegree SD\n" +
                            "JOIN\n" +
                            "Exam EX ON\n" +
                            "SD.Id_Exam = EX.Id\n" +
                            "JOIN \n" +
                            "Subject Sub ON\n" +
                            "EX.Id_Subject = Sub.Id\n" +
                            "WHERE SD.Id_Student = " + id +
                            "\nAND Sub.Name LIKE '"+strNameExam+"%'";               
        fillToJTable (strSelect , tableDegrees);
    }

    public static Boolean addReport(int idExam, int idStudent, String report, int id) {
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Add Report ( in SQL Server ).
            String strAdd = "INSERT INTO StudentReport (Id_Lecturer,Id_Exam,Id_Student,Report) "
                    + "VALUES ("+ id +","+ idExam +", "+ idStudent+ ",'"+report +"')";
            // Add Report
            stmt.execute(strAdd);
            // close SQL Server.
            dbConnection.close();
            
            return true;           
        }
        catch(SQLException ex ){    //Errer 
        }
        return false;
    }

    public static String insertSubjectOfStudent(ArrayList<String> idS , int idSubject) {
        try{for (String id : idS){
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Add IDS ( in SQL Server ).          
            String strAdd = "INSERT INTO SubjectOfStudent (Id_Subject,Id_Student) "
                    + "VALUES ("+ idSubject + ","+ id +")";
            stmt.execute(strAdd);
            // close SQL Server.
            dbConnection.close(); }          
            return "Done";           
        }
        catch(SQLException ex ){
            System.out.println(ex.getMessage());//Errer 
            return ex.getMessage();
        }
    }
    public static String insertSubjectOfLecturer(ArrayList<String> idS , int idSubject) {
        try{for (String id : idS){
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Add IDS ( in SQL Server ).          
            String strAdd = "INSERT INTO AssignSubject (Id_Subject,Id_Lecturer) "
                    + "VALUES ("+ idSubject + ","+ id +")";
            stmt.execute(strAdd);
            // close SQL Server.
            dbConnection.close(); }          
            return "Done";           
        }
        catch(SQLException ex ){
            System.out.println(ex.getMessage());//Errer 
            return ex.getMessage();
        }
    }

    
}

