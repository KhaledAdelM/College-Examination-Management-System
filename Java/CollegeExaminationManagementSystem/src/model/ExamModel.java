package model;

import databaseCEMS.CollegeExaminationDatabase;
import java.util.ArrayList;

public class ExamModel {
    private  int count;
    private  int idExam;
    private  int countOfQuestions=0;
    private  ArrayList<Integer> idQuestions = new ArrayList<>();
    private  ArrayList<String> questions = new ArrayList<>();
    private  ArrayList<Integer> tChoice = new ArrayList<>();
    private  ArrayList<String> answer = new ArrayList<>();
    private  ArrayList<Integer> degreeOfQuestion = new ArrayList<>();

    public ExamModel(int idExam) {
        count = -1;
        this.idExam = idExam;
        setExam ();
    }
    private  void setExam (){
        CollegeExaminationDatabase.setIdQuestionsToDo(ExamModel.this);
    }
    public int getIdExam (){
        return idExam;
    }
    public ArrayList<Integer> getIdQuestions (){
        return idQuestions;
    }
    public void plusCountOfQuestions (){
        countOfQuestions++;
    }
    public void setIdQuestion (int idQuestion ){
        idQuestions.add(idQuestion);
    }
    public void setQuestion (String question ){
        questions.add(question);
    }
    public void setDegree (int Degree ){
        degreeOfQuestion.add(Degree);
    }
    public String getQuestion ( ){
        int idQuestion = -1;
        count++;
        if(count < countOfQuestions){
            idQuestion = idQuestions.get(count);
            String question = questions.get(count);
            String choice = CollegeExaminationDatabase.getChoiceToDo(idQuestion,tChoice,answer);
            return question + "\n" + choice;
        }
        return "";
    }

    public int checkAnswer(int answer) {
        if(tChoice.get(answer-1) == 1 )
            return degreeOfQuestion.get(count);              
        return 0;        
    }

    public String getAnswer() {
        return answer.get(count);
    }
}
