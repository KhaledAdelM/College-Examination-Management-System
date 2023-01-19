package controller;

import collegeexaminationmanagementsystem.Tools;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import model.ExamModel;
import model.StudentModel;
import view.StudentView;


public class StudentController {
    private StudentView studentView;
    private StudentModel studentModel;
    private ExamModel examModel;
    private static int degree ;
    
    StudentController(StudentView studentView, StudentModel studentModel) {
        this.studentView   =   studentView;
        this.studentModel  =   studentModel;
        
        // Update Users
        this.studentView.settingButton(new settingListenerButton());
        this.studentView.updateInfoOfStudent (new updateInfoStudentButton());
        // view Reports
        this.studentView.viewReports (new reportsListenerButton());
        // view subjects
        this.studentView.subjectsButton(new subjectsListenerButton());
        // search Subjects --> NAME
        this.studentView.searchSubjects (new searchSubjectKeyReleased());
        // Set Exams Table
        this.studentView.viewExams (new viewExamsListenerButton());
        // Set Question 
        this.studentView.doIT (new doExamListenerButton());
        // submit Question 
        this.studentView.submitButton (new submitListenerButton());
        // done --> Next Question 
        this.studentView.doneButton (new doneListenerButton());
        // view Degrees
        this.studentView.viewDegrees(new degreesListenerButton());
        // search Degrees --> NAME EXAM
        this.studentView.searchDegrees (new searchDegreesKeyReleased());
        
    }
    private void setexamModel (ExamModel examModel){
        this.examModel = examModel;
    }
    private class settingListenerButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            studentView.setFullName(studentModel.getName());
            studentView.setEmail(studentModel.getEmail());
            studentView.setUsername (studentModel.getUsername());
            studentView.goTosetting ();
        }  
    }
    private class updateInfoStudentButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = studentView.getUsernameSetting();
            String email = studentView.getEmailSetting();
            String name = studentView.getNameSetting();
            String password = studentView.getPasswordSetting();
            String birthday = studentView.getBirthdaySetting();
            if(!password.isEmpty()&&!birthday.isEmpty()){
            studentModel.updateInfo(name, email, birthday, username, password, 3);
            setHomeData();
            } 
            else
                Tools.errmsgBox("Complete your details");
        }  
    }
    private void setHomeData() {
        studentView.setFullNameStudent (studentModel.getName());
    }
    
    
    private class reportsListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            studentModel.viewReports(studentView.getTableReports(),studentModel.getId());
            studentView.goToViewReports();
            
        }
        
    }
    
    private class subjectsListenerButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            studentModel.viewSubjects(studentView.getjTableSubjects());
            studentView.goToViewSubjects();
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
                String  strNamesearchSubject       =   studentView.getnamesearchSubject();
                if(!strNamesearchSubject.isEmpty()){
                studentModel.searchSubject(strNamesearchSubject,studentView.getjTableSubjects());
                }else{
                    studentModel.viewSubjects(studentView.getjTableSubjects());
                }
            }catch (NumberFormatException ex){
                Tools.errmsgBox("Search by NAME");
            }
        }
    }
    private class viewExamsListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(studentView.idSubjectInTable()!= 0){
                studentModel.viewExams(studentView.getTableExams(),studentView.idSubjectInTable());                           
                studentView.goToViewExams();
            }
            else
                Tools.msgBox("Select Subject ^-^");
        }  
    }
    private class doExamListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            degree = 0;
            int idExam = studentView.idExamInTable();
            if(studentModel.cheExam(idExam)&& idExam != -1){
                studentView.setNumOfQuestion(1 +"");
                ExamModel examModel = new ExamModel(idExam); 
                setexamModel(examModel);
                String Question = examModel.getQuestion();
                studentView.setQuestion(Question);
                studentView.goToViewQuestion();                
            }else
                Tools.msgBox("Check Your Degree ^-^");
        }  
    }
    private class submitListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int answer = studentView.getAnswr();
            if(answer !=0){
                degree = degree + examModel.checkAnswer(answer);
                String a = examModel.getAnswer();
                studentView.setAnswerOfQuestion("Answer Is:  "+a);
                studentView.EnabledDoneButton(true);
                studentView.EnabledSubmitButton(false);
                Tools.msgBox("Your Degree is: " + degree);                
            }else
                Tools.msgBox("Select Answer ^-^");
        }  
    }
    private class doneListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            studentView.EnabledSubmitButton(true);
            studentView.EnabledDoneButton(false);
            studentView.setAnswerOfQuestion("");
            String Question = examModel.getQuestion();
            if(!Question.isEmpty()){
                studentView.setQuestion(Question);
                studentView.goToViewQuestion(); 
            }else{
                studentModel.setDegree(examModel.getIdExam(),degree);
                Tools.msgBox("Done ^-^" + " And Your Degree: "+degree);
                studentView.goToViewExams ();
            }
        }  
    }
    class searchDegreesKeyReleased implements KeyListener{

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
                String  strNameExamSearchDegree       =   studentView.getNameExamSearchDegree();
                if(!strNameExamSearchDegree.isEmpty()){
                studentModel.viewDegrees(studentView.getTableDegrees(),strNameExamSearchDegree);
                }else{
                    studentModel.viewDegrees(studentView.getTableDegrees(),"");
                }
            }catch (NumberFormatException ex){
                Tools.errmsgBox("Search by NAME");
            }
        }
    }
    private class degreesListenerButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            studentView.goToViewDegrees();
            studentModel.viewDegrees(studentView.getTableDegrees(),"");
        }  
    }
}
