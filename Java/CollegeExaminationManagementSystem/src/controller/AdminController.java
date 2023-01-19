package controller;

import collegeexaminationmanagementsystem.Tools;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AdminModel;
import view.AdminView;

public class AdminController {

    private AdminModel adminModel;
    private AdminView adminView;
    
    public AdminController (AdminView adminView, AdminModel adminModel) {
        this.adminModel  =   adminModel;
        this.adminView   =   adminView;
        
        //Set Home JPanel Data
        setHomeData();
        // Set Info for Admin To Setting Profile
        this.adminView.setInfoOfAdmin(new setInfoOfAdminListenerButton());
        // Add Users
        this.adminView.addNewUser (new addUserListenerButton());
        // Update Users
        this.adminView.updateInfoOfAdmin(new updateInfoListenerButton());
        // Set Studdents Table
        this.adminView.setStuddentsTable(new setStuddentsTableListenerButton());
        // Delete Student
        this.adminView.deleteStudent (new deleteStudentListenerButton());
        // Update Student
        this.adminView.updateStudent (new updateStudentListenerButton());
        // search Student --> USERNAME
        this.adminView.searchStudent (new searchStudentKeyReleased());
        // Set Lecturers Table
        this.adminView.setLecturersTable(new setLecturersTableListenerButton());
        // search Lecturers --> USERNAME
        this.adminView.searchLecturer (new searchLecturerKeyReleased());
        // Delete Lecturer
        this.adminView.deleteLecturer (new deleteLecturerListenerButton());
        // Set Subjects Table
        this.adminView.setTableSubjects(new setTableSubjectsListenerButton());
        // search Subjects --> NAME
        this.adminView.searchSubjects (new searchSubjectKeyReleased());
        // Delete Subject
        this.adminView.deleteSubject (new deleteSubjectListenerButton());
        // Add Subject
        this.adminView.addSubject (new addSubjectListenerButton());
        // Update Subject
        this.adminView.updateSubject (new updateSubjectListenerButton());
        
        this.adminView.buttonManagesSubjects (new managesSubjectsListenerButton());
        this.adminView.uploadSubjectButton (new uploadSubjectListenerButton());

    }
    
    private void setHomeData (){
       adminView.setCountstudents (adminModel.getCountstudents());
       adminView.setCountLecturers (adminModel.getCountLecturers());
       adminView.setCountSubjects (adminModel.getCountSubjects());
       adminView.setFullNameAdmin (adminModel.getName());
       
    }

    

    private class addUserListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = adminView.getNameAddUser();
            String username = adminView.getUsernameAddUser();
            String password = adminView.getpasswordAddUser();
            int idModule = adminView.getIdModuleAddUser();
            if(idModule != -1){
            adminModel.addNewUser(name, username, password, idModule);
            adminView.emptyTextFieldAddUser();
            }          
        }  
    }
    
    private class setInfoOfAdminListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            adminView.setFullName(adminModel.getName());
            adminView.setEmail(adminModel.getEmail());
            adminView.setUsername (adminModel.getUsername());
        }  
    }
    
    private class updateInfoListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = adminView.getUsernameSetting();
            String email = adminView.getEmailSetting();
            String name = adminView.getNameSetting();
            String password = adminView.getPasswordSetting();
            String birthday = adminView.getBirthdaySetting();
            if(!password.isEmpty()&&!birthday.isEmpty())
            adminModel.updateInfo(name, email, birthday, username, password, 1);   
            else
                Tools.errmsgBox("Complete your details");
        }  
    }
    private class setStuddentsTableListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            adminModel.viewStudents(adminView.getjTableStudents());
        }  
    }
    private class deleteStudentListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int idStudent = adminView.idStudentInTable();
            if (idStudent != 0) {               
                 adminModel.deleteStudent(idStudent);
                 adminModel.viewStudents(adminView.getjTableStudents());
            }
          
        }  
    }
    private class updateStudentListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int idModuleStudent = adminView.getIdModuleUpgradeStudent();
            int idStudent = adminView.getIdUpgradeStudent();
            if (idStudent != 0 && idModuleStudent !=0) {               
                 adminModel.updateStudent(idStudent, idModuleStudent);
                 adminModel.viewStudents(adminView.getjTableStudents());
            }
        }
    }
    
    class searchStudentKeyReleased implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            //Not supported yet.
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //Not supported yet.
        }

        @Override
        public void keyReleased(KeyEvent e) {
            try{
                String  strUsernameSearchStudent       =   adminView.getUsernameSearchStudent();
                if(!strUsernameSearchStudent.isEmpty()){
                adminModel.searchStudent(strUsernameSearchStudent,adminView.getjTableStudents());
                }else{
                    adminModel.viewStudents(adminView.getjTableStudents());
                }
            }catch (NumberFormatException ex){
                Tools.errmsgBox("Search by USERNAME");
            }
        }
    }
    
    private class setLecturersTableListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            adminModel.viewLecturers(adminView.getjTableLecturer());
        }  
    }
    
    class searchLecturerKeyReleased implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            //Not supported yet.
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //Not supported yet.
        }

        @Override
        public void keyReleased(KeyEvent e) {
            try{
                String  strUsernameSearchLecturer       =   adminView.getUsernamesearchLecturer();
                if(!strUsernameSearchLecturer.isEmpty()){
                adminModel.searchLecturer(strUsernameSearchLecturer,adminView.getjTableLecturer());
                }else{
                    adminModel.viewLecturers(adminView.getjTableLecturer());
                }
            }catch (NumberFormatException ex){
                Tools.errmsgBox("Search by USERNAME");
            }
        }
    }
    private class deleteLecturerListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int idLecturer = adminView.idLecturerInTable();
            if (idLecturer != 0) {               
                 adminModel.deleteLecturer(idLecturer);
                 adminModel.viewLecturers(adminView.getjTableLecturer());
            }
          
        }  
    }
    private class setTableSubjectsListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            adminModel.viewSubjects(adminView.getjTableSubjects());
        }  
    }
    class searchSubjectKeyReleased implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            //Not supported yet.
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //Not supported yet.
        }

        @Override
        public void keyReleased(KeyEvent e) {
            try{
                String  strNamesearchSubject       =   adminView.getnamesearchSubject();
                if(!strNamesearchSubject.isEmpty()){
                adminModel.searchSubject(strNamesearchSubject,adminView.getjTableSubjects());
                }else{
                    adminModel.viewSubjects(adminView.getjTableSubjects());
                }
            }catch (NumberFormatException ex){
                Tools.errmsgBox("Search by NAME");
            }
        }
    }
    private class deleteSubjectListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int idSubject = adminView.idSubjectInTable();
            if (idSubject != 0) {               
                 adminModel.deleteSubject(idSubject);
                 adminModel.viewSubjects(adminView.getjTableSubjects());
            }
          
        }  
    }
    private class addSubjectListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = adminView.getNameAddSubject();
            String details = adminView.getDetailsAddSubject();
            int idLuc = adminView.getIdAddSubject();
            adminModel.addSubject(name, details,idLuc);
            adminView.emptyTextFieldAddSubject();
                    
        }  
    }
    private class updateSubjectListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int idSubject = adminView.idSubjectInTable();
            String name = adminView.getNameupdateSubject();
            String details  = adminView.getdetailsupdateSubject();
            if (idSubject != 0 && !name.isEmpty() && !details.isEmpty()) {               
                 adminModel.updateSubject(idSubject, name,details);
                 adminModel.viewSubjects(adminView.getjTableSubjects());
                 adminView.backToViewSubject();
            }else
                Tools.errmsgBox("Complete :(");
        }
    }
    private  class managesSubjectsListenerButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int idSubjectInTable = adminView.idSubjectInTable();
            adminView.setIdSubjectInTableToUpload(idSubjectInTable+"");
            adminView.goToUploadSubject ();
        }

        
    }

    private  class uploadSubjectListenerButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int idSubject = Integer.parseInt(adminView.getIdSubjectInTableToUpload());
            String fileName = adminView.getFileName();
            int idModel = adminView.getIdModel();
            try {
                InsertSubjectOfStudent (idSubject, fileName,idModel);
                adminModel.viewSubjects(adminView.getjTableSubjects());
                adminView.backToViewSubject();
            } catch (IOException ex) {
                
            }
            
        }

        
    }
    
    public void InsertSubjectOfStudent (int idSubject,String fileName ,int idModel) throws FileNotFoundException, IOException {
        ArrayList<String> idS = new ArrayList<>();
        File file = new File(fileName);
        Scanner scan = new Scanner(file);     
        while(scan.hasNextLine()){
            idS.add(scan.nextLine());
        }
        String err = "";
        System.out.println(idModel);
        if(idModel == 3)
            err = adminModel.insertSubjectOfStudent(idS,idSubject);     
        else if(idModel == 2){
            err = adminModel.insertSubjectOfLecturer(idS,idSubject);}
        
        if (!err.equals("Done")){
        try (FileWriter writer = new FileWriter("err.txt")) {
            writer.write(err);
        }
        }
        Tools.msgBox("Complete :) ");
    }
    
    
    
}
