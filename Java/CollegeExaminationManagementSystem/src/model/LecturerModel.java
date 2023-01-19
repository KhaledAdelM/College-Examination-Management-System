package model;

import databaseCEMS.CollegeExaminationDatabase;
import javax.swing.JTable;



public class LecturerModel extends UsersModel{

    public void viewSubjects(JTable jTableSubjects) {
        CollegeExaminationDatabase.viewSubjectsOfLec (jTableSubjects,getId(),"");
    }

    public void searchSubject(String strNamesearchSubject, JTable jTableSubjects) {
        CollegeExaminationDatabase.viewSubjectsOfLec (jTableSubjects,getId(),strNamesearchSubject);
    }

    public void viewExams(JTable jTableExams, int idSubjectInTable) {
        CollegeExaminationDatabase.viewExams (jTableExams, idSubjectInTable );
    }

    public void viewQuestions(JTable tableQuestions, int idExamInTable) {
        CollegeExaminationDatabase.viewQuestions (tableQuestions, idExamInTable);
    }

    public void deleteExam(int idExam) {
        CollegeExaminationDatabase.deleteExam(idExam);
    }

    public void renameExam(int id, String name, String details) {
        CollegeExaminationDatabase.renameExam (id,name,details); 
    }

    public void renameQuestion(int id, String name) {
        CollegeExaminationDatabase.renameQuestion(id,name);  
    }

    public String[] getChoice(int id) {
        return CollegeExaminationDatabase.getChoice(id);  
    }

    public void setChoice(String q1, String q2, String q3, String q4, int tf,int id) {
         CollegeExaminationDatabase.setChoice(q1,q2,q3,q4,tf, id);
    }

    public void viewStudentDegree(JTable tableStudentDegree, int id) {
        CollegeExaminationDatabase.viewStudentDegree( tableStudentDegree,  id);
    }

    public void searchIdStudent(int idStudent, JTable tableStudentDegree,int id) {
        CollegeExaminationDatabase.searchIdStudent( tableStudentDegree, id , idStudent);
    }

    public void viewReports(JTable tableReports, int idLecturer) {
        CollegeExaminationDatabase.viewReports( tableReports , idLecturer);
    }

    public void deleteReport(int idReport) {
        CollegeExaminationDatabase.deleteReport(idReport);
    }

    public void searchReport(JTable tableReports, int id, int IdStudent) {
        CollegeExaminationDatabase.searchReport( tableReports,  id,  IdStudent);
    }

    public int addExam(int intIdSubject, String name, String details) {
        return CollegeExaminationDatabase.addExam( intIdSubject, name, details);
    }

    public void addQuestion(int idExam ,String q, String ch1, int tf1, String ch2, int tf2, String ch3, int tf3, String ch4, int tf4, int examDegree) {
        CollegeExaminationDatabase.addQuestion( idExam, q,  ch1,  tf1,  ch2,  tf2,  ch3,  tf3,  ch4,  tf4,  examDegree);
    }

    public Boolean addReport(int idExam, int idStudent ,String report) {
        return CollegeExaminationDatabase.addReport( idExam,  idStudent,report ,this.getId());
    }
    
}
