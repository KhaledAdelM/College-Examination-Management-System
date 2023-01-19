package model;

import databaseCEMS.CollegeExaminationDatabase;
import javax.swing.JTable;


public class StudentModel extends UsersModel {
    
    
    
    public void viewReports(JTable tableReports, int id) {
        CollegeExaminationDatabase.viewReportsStudent(tableReports, id);
    }

    public void viewSubjects(JTable jTableSubjects) {
        CollegeExaminationDatabase.viewSubjectsStudent(jTableSubjects, this.getId() , "");
    }

    public void searchSubject(String strNamesearchSubject, JTable jTableSubjects) {
        CollegeExaminationDatabase.viewSubjectsStudent(jTableSubjects, this.getId() ,strNamesearchSubject);
    }

    public void viewExams(JTable tableExams, int idSubjectInTable) {
        CollegeExaminationDatabase.viewExams (tableExams, idSubjectInTable );
    }

    public boolean cheExam(int idExam) {
        return CollegeExaminationDatabase.cheExam(idExam,this.getId());
    }

    public void setDegree(int idExam, int degree) {
        CollegeExaminationDatabase.setDegree( idExam,this.getId(), degree);
    }

    public void viewDegrees(JTable tableDegrees, String strNameExam) {
        CollegeExaminationDatabase.viewDegrees( tableDegrees, this.getId(), strNameExam);
    }
    
}
