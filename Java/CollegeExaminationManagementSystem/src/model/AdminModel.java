package model;

import databaseCEMS.CollegeExaminationDatabase;
import java.util.ArrayList;
import javax.swing.JTable;


public class AdminModel extends UsersModel{
    
    
    public int getCountstudents(){
        return CollegeExaminationDatabase.countStudents();
    }
    public int getCountLecturers(){
        return CollegeExaminationDatabase.countLecturers();
    }
    
    public int getCountSubjects(){
        return CollegeExaminationDatabase.countSubjects();
    }
    
    public boolean addNewUser(String name, String username, String password, int idModule){
        return CollegeExaminationDatabase.addNewUser(name, username, password, idModule);
    }
    public void viewStudents (JTable tableStudents){
        CollegeExaminationDatabase.viewStudents (tableStudents);       
    }

    public void deleteStudent(int idStudentToDelete) {
        CollegeExaminationDatabase.deleteUser(idStudentToDelete);  
    }
    public void updateStudent(int idStudent , int idModelStudemt) {
        CollegeExaminationDatabase.updateInfo(idStudent,idModelStudemt);  
    }

    public void searchStudent(String strUsernameSearchStudent, JTable jTableStudents) {
        CollegeExaminationDatabase.searchStudent(strUsernameSearchStudent,jTableStudents); 
    }

    public void viewLecturers(JTable tableLecturer) {
       CollegeExaminationDatabase.viewLecturer (tableLecturer);
    }

    public void searchLecturer(String strUsernameSearchLecturer, JTable jTableLecturer) {
        CollegeExaminationDatabase.searchLecturer(strUsernameSearchLecturer,jTableLecturer);
    }

    public void deleteLecturer(int idLecturer) {
         CollegeExaminationDatabase.deleteUser(idLecturer);
    }

    public void viewSubjects(JTable tableSubjects) {
       CollegeExaminationDatabase.viewSubjects (tableSubjects); 
    }

    public void searchSubject(String strNamesearchSubject, JTable jTableSubjects) {
        CollegeExaminationDatabase.searchSubject(strNamesearchSubject,jTableSubjects);
    }

    public void deleteSubject(int idSubject) {
        CollegeExaminationDatabase.deleteSubject(idSubject);
    }

    public void addSubject(String name, String details, int idLuc) {
        CollegeExaminationDatabase.addSubject(name, details, idLuc);
    }

    public void updateSubject(int idSubject, String name, String details) {
        CollegeExaminationDatabase. updateSubject (idSubject,name,details);
    }

    public String insertSubjectOfStudent(ArrayList<String> idS,int idSubject) {
        return CollegeExaminationDatabase.insertSubjectOfStudent(idS,idSubject);
    }

    public String insertSubjectOfLecturer(ArrayList<String> idS, int idSubject) {
        return CollegeExaminationDatabase.insertSubjectOfLecturer(idS,idSubject);
    }
    
    
}
