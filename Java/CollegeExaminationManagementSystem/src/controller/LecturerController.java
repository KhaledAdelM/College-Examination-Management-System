package controller;

import collegeexaminationmanagementsystem.Tools;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import model.LecturerModel;
import view.LecturerView;

public class LecturerController {

    private LecturerModel lecturerModel;
    private LecturerView lecturerView;
    
    LecturerController(LecturerView lecturerView, LecturerModel lecturerModel) {
        this.lecturerView   =   lecturerView;
        this.lecturerModel  =   lecturerModel;
       //Set Home JPanel Data
        setHomeData();
        // Left Buttons
        this.lecturerView.settingButton(new settingListenerButton());
        this.lecturerView.homeButton(new homeListenerButton());
        this.lecturerView.subjectsButton(new subjectsListenerButton());
        this.lecturerView.reportsButton (new reportsListenerButton());
        this.lecturerView.renameExamPageButton (new renameExamPageListenerButton());
        // Update Users
        this.lecturerView.updateInfoOfLecturer(new updateInfoListenerButton());
        // search Subjects --> NAME
        this.lecturerView.searchSubjects (new searchSubjectKeyReleased());
        // Set Exams Table
        this.lecturerView.viewExams (new viewExamsListenerButton());
        // Set Questions Table
        this.lecturerView.viewQuestions(new setTableQuestionsListenerButton());
        // Delete Subject
        this.lecturerView.deleteExam (new deleteExamListenerButton());
        // Rename Subject
        this.lecturerView.renameExam (new renameExamListenerButton());
        // Rename Question
        this.lecturerView.renameQuestion (new renameQuestionListenerButton());
        // View Question
        this.lecturerView.ViewQuestion (new ViewQuestionListenerButton());
        // V Update Question
        this.lecturerView.updateQuestion (new updateQuestionListenerButton());
        // Update Question
        this.lecturerView.setUpdateQuestion (new setUpdateQuestionListenerButton()); 
        // View Student Degree
        this.lecturerView.buttonStudentDegree (new studentDegreeListenerButton());
        // search Students --> ID
        this.lecturerView.searchIdStudents (new searchIdStudentsKeyReleased());       
        // Delete Report
        this.lecturerView.deleteReport (new deleteReportListenerButton());
        // search Repor --> IdStudent
        this.lecturerView.searchReport (new searchIdStudentReportKeyReleased());
        // Add Exam  <-- Subjects
        this.lecturerView.addExamSubjects (new addExamSubjectsListenerButton()); 
        // Add Exam  
        this.lecturerView.addExam (new addExamListenerButton());
        // Add Question  
        this.lecturerView.addQuestionButton (new addQuestionListenerButton());
        // Done Add Question   
        this.lecturerView.doneAddQuestionButton (new doneAddQuestionListenerButton());
        // button V - Add Report   
        this.lecturerView.buttonAddReport (new addReportsListenerButton());
        // button Add Report   
        this.lecturerView.addReportButton (new addReportListenerButton());
    }

    private void setHomeData() {
        lecturerView.setFullNameLecturer (lecturerModel.getName());
    }
    
    private class settingListenerButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            lecturerView.setFullName(lecturerModel.getName());
            lecturerView.setEmail(lecturerModel.getEmail());
            lecturerView.setUsername (lecturerModel.getUsername());
            lecturerView.goTosetting ();
        }  
    }
    private class homeListenerButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {           
            lecturerView.goToHome ();
        }  
    }
    private class updateInfoListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = lecturerView.getUsernameSetting();
            String email = lecturerView.getEmailSetting();
            String name = lecturerView.getNameSetting();
            String password = lecturerView.getPasswordSetting();
            String birthday = lecturerView.getBirthdaySetting();
            if(!password.isEmpty()&&!birthday.isEmpty()){
            lecturerModel.updateInfo(name, email, birthday, username, password, 2);
            setHomeData();
            } 
            else
                Tools.errmsgBox("Complete your details");
        }  
    }
    
    private class subjectsListenerButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            lecturerModel.viewSubjects(lecturerView.getjTableSubjects());
            lecturerView.goToViewSubjects();
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
                String  strNamesearchSubject       =   lecturerView.getnamesearchSubject();
                if(!strNamesearchSubject.isEmpty()){
                lecturerModel.searchSubject(strNamesearchSubject,lecturerView.getjTableSubjects());
                }else{
                    lecturerModel.viewSubjects(lecturerView.getjTableSubjects());
                }
            }catch (NumberFormatException ex){
                Tools.errmsgBox("Search by NAME");
            }
        }
    }
    private class viewExamsListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(lecturerView.idSubjectInTable()!= 0){
                lecturerModel.viewExams(lecturerView.getTableExams(),lecturerView.idSubjectInTable());                           
                lecturerView.goToViewExams();
            }
            else
                Tools.msgBox("Select Subject ^-^");
        }  
    }
    private class setTableQuestionsListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            lecturerModel.viewQuestions(lecturerView.getTableQuestions(),lecturerView.idExamInTable());
        }  
    }
    private class deleteExamListenerButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int idExam = lecturerView.idExamInTable ();
            if(idExam !=0){
                lecturerModel.deleteExam(idExam);
                lecturerModel.viewExams(lecturerView.getTableExams(),lecturerView.idSubjectInTable());
                     }else
                Tools.errmsgBox("Select Exam ^-^");
        }  
    }
    private class renameExamListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int id = lecturerView.idExamReaname (); 
            String name = lecturerView.nameExamReaname();
            String details = lecturerView.detailsExamReaname (); 
            if (!name.isEmpty()&& !details.isEmpty()) {               
                lecturerModel.renameExam(id,name,details);
                lecturerModel.viewExams(lecturerView.getTableExams(),lecturerView.idSubjectInTebleExam());
                lecturerView.backToExamsTable();
            }
          
        }  
    }
    private class renameQuestionListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int id = lecturerView.idQuestionReaname (); 
            String name = lecturerView.nameQuestionReaname();
            if (!name.isEmpty()) {               
                lecturerModel.renameQuestion(id,name);
                lecturerModel.viewQuestions(lecturerView.getTableQuestions(),lecturerView.idExamInTable());
                lecturerView.backToQuestionTable();
            }
          
        }  
    }
    private class ViewQuestionListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int id = lecturerView.idQuestionInTable();
            String[] choice = lecturerModel.getChoice(id);
            String[] question = new String[8];
            if(choice.length == 8 && ! Arrays.equals(choice, question) ){
                lecturerView.setq1 (choice[0] , trueOfFales(choice [1]));
                lecturerView.setq2 (choice[2] , trueOfFales(choice [3]));
                lecturerView.setq3 (choice[4] , trueOfFales(choice [5]));
                lecturerView.setq4 (choice[6] , trueOfFales(choice [7]));
                lecturerView.setinfoOfQ ();
            }else
                Tools.errmsgBox("Null");
        }
        private String trueOfFales (String tf){
            return tf.equals("1") ? "True" : "Fales";
        }
    }
    private class updateQuestionListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int id = lecturerView.idQuestionInTable();
            String[] choice = lecturerModel.getChoice(id);
            String[] question = new String[8];
            if(choice.length == 8 && ! Arrays.equals(choice, question) ){
                lecturerView.setUpdateq1 (choice[0]);
                lecturerView.setUpdateq2 (choice[2]);
                lecturerView.setUpdateq3 (choice[4]);
                lecturerView.setUpdateq4 (choice[6]);
            }else
                Tools.errmsgBox("Null");
        }
        
    }
    private class setUpdateQuestionListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int  tf =  lecturerView.getUpdateTF();
            int id = lecturerView.getUpdateID();
            if(tf != 0){
                String q1 = lecturerView.getUpdateq1();
                String q2 = lecturerView.getUpdateq2();
                String q3 = lecturerView.getUpdateq3();
                String q4 = lecturerView.getUpdateq4();
                lecturerModel.setChoice(q1,q2,q3,q4,tf,id);
                
            }
        }
        
    }
    private class studentDegreeListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int id = lecturerView.idSubjectInTable();
            lecturerModel.viewStudentDegree (lecturerView.getTableStudentDegree(),id);
            if (id == 0)Tools.msgBox("Select Subject ^-^");
            else lecturerView.goToViewStudentDegree();
        }
        
    }
    class searchIdStudentsKeyReleased implements KeyListener{

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
                String  strIdStudent       =   lecturerView.getIdStudent();               
                if(!strIdStudent.isEmpty()){
                    int intIdStudent = Integer.parseInt(lecturerView.getIdStudent());
                lecturerModel.searchIdStudent(intIdStudent,lecturerView.getTableStudentDegree(),lecturerView.idSubjectInTebleExam());
                }else{
                    lecturerModel.viewStudentDegree(lecturerView.getTableStudentDegree(),lecturerView.idSubjectInTebleExam());
                }
            }catch (NumberFormatException ex){
                Tools.errmsgBox("Search by ID");
            }
        }
    }
    private class reportsListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            lecturerModel.viewReports(lecturerView.getTableReports(),lecturerModel.getId());
            lecturerView.goToViewReports();
            
        }
        
    }
    private class deleteReportListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int idReport = lecturerView.idReportInTable();
            if (idReport != 0) { 
                lecturerModel.deleteReport (idReport);
                lecturerModel.viewReports(lecturerView.getTableReports(),lecturerModel.getId());                        
            }
            
        }
        
    }
    class searchIdStudentReportKeyReleased implements KeyListener{

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
                String  strIdStudent       =   lecturerView.getIdStudentInReporTable();               
                if(!strIdStudent.isEmpty()){
                    int intIdStudent = Integer.parseInt(strIdStudent);
                    lecturerModel.searchReport (lecturerView.getTableReports(),lecturerModel.getId(),intIdStudent);  
                }else{
                    lecturerModel.viewReports(lecturerView.getTableReports(),lecturerModel.getId());  
                }
            }catch (NumberFormatException ex){
                Tools.errmsgBox("Search by ID");
            }
        }
    }
    private class addExamSubjectsListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int intIdSubject = lecturerView.idSubjectInTable();
            if (intIdSubject !=0){
                lecturerView.setIdSubject(intIdSubject);
                lecturerView.goToAddExam();
            }   
        }   
    }
    private int intExamDegree = -1;
    private class addExamListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
            int intIdSubject = lecturerView.idSubjectInTebleExam();
            String name = lecturerView.getNameExam ();
            String details = lecturerView.getDetailsExam ();
            int examDegree = Integer.parseInt(lecturerView.getExamDegreeExam());
            intExamDegree = examDegree;
            if (!name.isEmpty()&& !details.isEmpty()){               
                int idExam = lecturerModel.addExam(intIdSubject,name,details);
                lecturerView.setIdExam (idExam);
                lecturerView.goToAddQuestions();
            }
            }catch (NumberFormatException ex){
                Tools.errmsgBox("Number !!");
            }
        }     
    }
    private class addQuestionListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int idExam = lecturerView.getIdExam();
            String q = lecturerView.getQuestionAddQuestion();
            String ch1 = lecturerView.getCh1AddQuestion();
            int tf1 = lecturerView.getTF1AddQuestion();
            String ch2 = lecturerView.getCh2AddQuestion();
            int tf2 = lecturerView.getTF2AddQuestion();
            String ch3 = lecturerView.getCh3AddQuestion();
            int tf3 = lecturerView.getTF3AddQuestion();
            String ch4 = lecturerView.getCh4AddQuestion();
            int tf4 = lecturerView.getTF4AddQuestion();
            int examDegree = intExamDegree;
            lecturerModel.addQuestion(idExam,q,ch1,tf1,ch2,tf2,ch3,tf3,ch4,tf4,examDegree);
            lecturerView.emptyingAddQuestion();
            
        }     
    }
    private class renameExamPageListenerButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(lecturerView.setInfoExamToRename()){
                lecturerView.goToRenameExam();
            }
        }
    }
    private class doneAddQuestionListenerButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            lecturerView.goToViewSubjects ();
        }
    }
    private class addReportsListenerButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int idExam = lecturerView.idExameInTableDagree();
            int idStudent = lecturerView.idStudentInTableDagree();
            if(idExam!=0){
            lecturerView.setIdExamAddReport(idExam+"");
            lecturerView.setIdStudentAddReport(idStudent+"");        
            lecturerView.goToAddReports ();
            }else Tools.msgBox("Select Subject ^-^");
        }
    }
    private class addReportListenerButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int idExam = Integer.parseInt(lecturerView.getIdStudentAddExam());
            int idStudent = Integer.parseInt(lecturerView.getIdStudentAddReport());
            String report = lecturerView.getReport();
            if(!report.isEmpty()){
                if(lecturerModel.addReport(idExam,idStudent,report)){
                    lecturerView.goToViewSubjects ();
                    lecturerView.emptyingAddReport();
                    Tools.msgBox("Add  successfully^-^");
                }
            }else Tools.msgBox("!!");
        }
    }
    
}
