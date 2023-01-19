package view;

import collegeexaminationmanagementsystem.Tools;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class LecturerView extends javax.swing.JFrame {
    private CardLayout cardLayoutPage;
    private CardLayout cardLayoutExamsPage;
    private DefaultTableModel dtmSubjects = new DefaultTableModel();
    private DefaultTableModel dtmExams = new DefaultTableModel();
    private DefaultTableModel dtmQuestions = new DefaultTableModel();
    private DefaultTableModel dtmStudentsDegree = new DefaultTableModel();
    private DefaultTableModel dtmReports = new DefaultTableModel();
    private int idSubjectInTebleExam =-1;
    
    public LecturerView() {
        initComponents();
        // set Date Format  
        dateSetting.setDateFormatString("yyyy-MM-dd");
        // Create card Layout Page
        cardLayoutPage = (CardLayout) (jPanelRight.getLayout());
        cardLayoutExamsPage = (CardLayout) (subjectsjPanelRight.getLayout());
        // Create Subjects Table
        String [] subjectsColumns = {"Id","Name","Details","NumOfStudent"};
        setColumn(dtmSubjects, jTableSubjects ,subjectsColumns);
        // Create Exams Table
        String [] examsColumns = {"Id","Subject Name","Name","Details"};
        setColumn(dtmExams, jTableExams ,examsColumns);
        // Create Questions Table
        String [] questionsColumns = {"Id","Question","Degree"};
        setColumn(dtmQuestions, jTableQuestions  ,questionsColumns);
        // Create Students Degree Table
        String []  studentsDegreeColumns = {"Id","Id_Exam","Name_Exam","Id_Student", "Name_Student","Degree"};
        setColumn(dtmStudentsDegree, jTableStudentDegree  ,studentsDegreeColumns);
        // Create Reports Table
        String []  reportsColumns = {"Id","Id_Student", "Name_Student","Name_Exam","Report"};
        setColumn(dtmReports, jTableReports  ,reportsColumns);
    }
   
    private void setColumn(DefaultTableModel tableModel, JTable jTable,String [] columns){
        jTable.setModel(tableModel);
        jTable.getTableHeader().setReorderingAllowed(false); // not allow re-ordering of columns
        for (String column :columns){
            tableModel.addColumn(column);
        }
    }
    
    //---------------------------------------------
    public void setFullNameLecturer (String fullName){
        fullNameJLabel1.setText("Hi, "+ fullName);
        fullNameJLabel.setText("Hi, "+ fullName);
    }
    //---------------------------------------------
    public void setFullName (String name){
        nameSetting.setText(name);
    }
    public void setUsername (String username){
        usernameSetting.setText(username);
    }
    public void setEmail (String email){
        emailSetting.setText(email);
    }
    //-----------------------------------------------
    public String getUsernameSetting (){     
        return usernameSetting.getText();       
    }
    public String getPasswordSetting (){
        return passwordSetting.getText();       
    }
    public String getNameSetting (){     
        return nameSetting.getText();       
    }
    public String getEmailSetting (){     
        return emailSetting.getText();       
    }
    public String getBirthdaySetting (){
        try{
        String birthday = (dateSetting.getDate().getYear()+1900)+"-"+ (dateSetting.getDate().getMonth()+1)+"-"+dateSetting.getDate().getDate();
        return birthday;}catch(NullPointerException ex){
            return "";
        }       
    }
    public void updateInfoOfLecturer (ActionListener updateInfoOfLecturerListenerButton) {
        updateButton.addActionListener(updateInfoOfLecturerListenerButton);            
    }
    //-----------------------------------------------
    public JTable getjTableSubjects(){
        return jTableSubjects;
    }
    public int idSubjectInTable (){
        try{
        int numOfRow = jTableSubjects.getSelectedRow();
        int idOfSubject = Integer.parseInt((String) jTableSubjects.getModel().getValueAt(numOfRow, 0));
        idSubjectInTebleExam=idOfSubject;
        return idOfSubject;
        }catch(ArrayIndexOutOfBoundsException ex){}
        return 0;
    }
    //search
    public String getnamesearchSubject(){
        return SearchSubject.getText();
    }
    public void searchSubjects (KeyListener searchSubjectKeyReleased) {                                       
        SearchSubject.addKeyListener(searchSubjectKeyReleased);
    }
    //-------------------
    public void viewExams (ActionListener viewExamListenerButton) {                                       
        buttonExamSubjects.addActionListener(viewExamListenerButton); 
    }
    public JTable getTableExams() {
        return jTableExams; 
    }
    public int idExamInTable (){
        try{
        int numOfRow = jTableExams.getSelectedRow();
        int idExam = Integer.parseInt((String) jTableExams.getModel().getValueAt(numOfRow, 0));
        return idExam;
        }catch(ArrayIndexOutOfBoundsException ex){}
        return 0;
    }
    public String nameExamInTable (){
        try{
        int numOfRow = jTableSubjects.getSelectedRow();
        String nameExam = (String) jTableExams.getModel().getValueAt(numOfRow, 2);
        return nameExam;
        }catch(ArrayIndexOutOfBoundsException ex){}
        return "";
    }
    public JTable getTableQuestions() {
        return jTableQuestions; 
    }
    public void viewQuestions (ActionListener viewQuestionsListenerButton) {                          
        buttonExamModification.addActionListener(viewQuestionsListenerButton); 
    }
    public void deleteExam (ActionListener deleteExamListenerButton) {                          
        buttonDeleteExam.addActionListener(deleteExamListenerButton); 
    }
    public int idSubjectInTebleExam() {
        return idSubjectInTebleExam; 
    }
    public void renameExam (ActionListener renameExamListenerButton) {                          
        updateExamButton.addActionListener(renameExamListenerButton); 
    }
    public int idExamReaname (){    
        return Integer.parseInt(idUpdateExam.getText());
    }
    public String nameExamReaname (){    
        return nameUpdateExam.getText();
    }
    public String detailsExamReaname (){    
        return detailsUpdateExam.getText();
    }
    public void backToExamsTable(){
        cardLayoutExamsPage.show(subjectsjPanelRight, "viewExams");
    }
    public void renameQuestion (ActionListener updateQuestionListenerButton) {                          
        updateQuestionButton.addActionListener(updateQuestionListenerButton); 
    }
    public int idQuestionReaname (){    
        return Integer.parseInt(idUpdateQuestion.getText());
    }
    public String nameQuestionReaname (){    
        return nameUpdateQuestion.getText();
    }
    public void backToQuestionTable() {
        cardLayoutExamsPage.show(subjectsjPanelRight, "viewQuestions");    
    }
    public int idQuestionInTable (){
        try{
        int numOfRow = jTableQuestions.getSelectedRow();
        int idQuestion = Integer.parseInt((String) jTableQuestions.getModel().getValueAt(numOfRow, 0));
        return idQuestion;
        }catch(ArrayIndexOutOfBoundsException ex){}
        return 0;
    }
    public int idExameInTableDagree (){
        try{
        int numOfRow = jTableStudentDegree.getSelectedRow();
        int idExame = Integer.parseInt((String) jTableStudentDegree.getModel().getValueAt(numOfRow, 1));
        return idExame;
        }catch(ArrayIndexOutOfBoundsException ex){}
        return 0;
    }
    public int idStudentInTableDagree (){
        try{
        int numOfRow = jTableStudentDegree.getSelectedRow();
        int idExame = Integer.parseInt((String) jTableStudentDegree.getModel().getValueAt(numOfRow, 3));
        return idExame;
        }catch(ArrayIndexOutOfBoundsException ex){}
        return 0;
    }
    public boolean setInfoExamToRename (){
        try{
            int numOfRow = jTableExams.getSelectedRow();
            int idOfExam = Integer.parseInt((String) jTableExams.getModel().getValueAt(numOfRow, 0));
            idUpdateExam.setText(idOfExam +"");
            String nameExam = (String) jTableExams.getModel().getValueAt(numOfRow, 2);
            nameUpdateExam.setText(nameExam);
            String detailsExam = (String) jTableExams.getModel().getValueAt(numOfRow, 3);
            detailsUpdateExam.setText(detailsExam);
            return true;
        }catch(ArrayIndexOutOfBoundsException ex){Tools.errmsgBox("Select Exam ^-^");}
        return false;
    }
    public void ViewQuestion (ActionListener ViewQuestionListenerButton) {                          
        buttonViewQuestion.addActionListener(ViewQuestionListenerButton); 
    }
    public void setIdQuestion (int intIdQuestion){
        idQuestion.setText(intIdQuestion+"");
    }
    public void setNameQuestion (String questionText){
        questionTextField.setText(questionText);
    }
    public void setq1 (String q1 , String tf){
        chosen1.setText(q1);
        chosenTF1.setText(tf);
    }
    public void setq2 (String q2, String tf){
        chosen2.setText(q2);
        chosenTF2.setText(tf);
    }
    public void setq3 (String q3, String tf){
        chosen3.setText(q3);
        chosenTF3.setText(tf);
    }
    public void setq4 (String q4, String tf){
        chosen4.setText(q4);
        chosenTF4.setText(tf);
    }
    public void setinfoOfQ (){
        try{
        int numOfRow = jTableQuestions.getSelectedRow();
        int idOfQuestion = Integer.parseInt((String) jTableQuestions.getModel().getValueAt(numOfRow, 0));
        setIdQuestion (idOfQuestion);
        String strQuestion = (String) jTableQuestions.getModel().getValueAt(numOfRow, 1);
        setNameQuestion (strQuestion);
        cardLayoutExamsPage.show(subjectsjPanelRight, "viewQuestion");
        }catch(ArrayIndexOutOfBoundsException ex){Tools.errmsgBox("Select Question ^-^");}
    }
    public void updateQuestion (ActionListener updateQuestionListenerButton) {                          
        updateChosenButton1.addActionListener(updateQuestionListenerButton); 
    }
    public void setUpdateq1 (String q1){
        chosenUpdate1.setText(q1);
    }
    public void setUpdateq2 (String q2){
        chosenUpdate2.setText(q2);
    }
    public void setUpdateq3 (String q3){
        chosenUpdate3.setText(q3);
    }
    public void setUpdateq4 (String q4){
        chosenUpdate4.setText(q4);
    }
    public void setUpdateQuestion (ActionListener setUpdateQuestionListenerButton) {                          
        updateChosenButton2.addActionListener(setUpdateQuestionListenerButton); 
    }
    public String getUpdateq1 (){
        return chosenUpdate1.getText();
    }
    public String getUpdateq2 (){
        return chosenUpdate2.getText();
    }
    public String getUpdateq3 (){
        return chosenUpdate3.getText();
    }
    public String getUpdateq4 (){
        return chosenUpdate4.getText();
    }
    public int getUpdateTF (){
        try{
        if(buttonGroupTF.getSelection().equals(tfRadioButton1.getModel()))
            return 1;
        else if(buttonGroupTF.getSelection().equals(tfRadioButton2.getModel()))
            return 2;
        else if(buttonGroupTF.getSelection().equals(tfRadioButton3.getModel()))
            return 3;
        else if(buttonGroupTF.getSelection().equals(tfRadioButton4.getModel()))
            return 4;
        }catch(NullPointerException ex){Tools.errmsgBox("T/F Empty");}        
        return 0;
    }
    public int getUpdateID (){
        return Integer.parseInt(idQuestionUpdate.getText());
    }
    public void viewDegreeStudents (ActionListener viewDegreeStudentsListenerButton) { 
        buttonStudentDegree.addActionListener(viewDegreeStudentsListenerButton); 
    }
    public JTable getTableStudentDegree(){
        return jTableStudentDegree;
    }
    public String getIdStudent (){
        return SearchIdStudent.getText();
    }
    public void searchIdStudents (KeyListener searchStudentsKeyReleased) {                                       
        SearchIdStudent.addKeyListener(searchStudentsKeyReleased);
    }
    public JTable getTableReports(){
        return jTableReports;
    }
    public void viewReports (ActionListener viewReportsListenerButton) { 
        reportsButton.addActionListener(viewReportsListenerButton); 
    }
    public void deleteReport(ActionListener deleteReportListenerButton) { 
        buttonReportDelete.addActionListener(deleteReportListenerButton); 
    }
    public int idReportInTable (){
        try{
        int numOfRow = jTableReports.getSelectedRow();
        int idReports = Integer.parseInt((String) jTableReports.getModel().getValueAt(numOfRow, 0));
        return idReports;
        }catch(ArrayIndexOutOfBoundsException ex){}
        return 0;
    }
    public void searchReport (KeyListener searchIdStudentReportKeyReleased) {                                       
        SearchIdStudentReport.addKeyListener(searchIdStudentReportKeyReleased);
    }
    public String getIdStudentInReporTable () {
       return SearchIdStudentReport.getText();
    }
    public void addExamSubjects (ActionListener addExamSubjectsListenerButton) {                                       
        buttonAddExamSubjects.addActionListener(addExamSubjectsListenerButton);
    }
     public void setIdSubject (int id){
         addExamIdSubject.setText(id+"");
     }
           
    public void addExam (ActionListener addExamListenerButton) {                                       
        addExamButton.addActionListener(addExamListenerButton);
    }
    public String getNameExam (){
        return   addExamName.getText();
    }
    public String getDetailsExam (){
        return   addExamDetails.getText();
    }
    public String getExamDegreeExam (){
        return addExamDegree.getText();
    }
    public void setIdExam(int idExam) {
        addQuestionIdExam.setText(idExam+"");
    } 
    public int getIdExam() {
       return Integer.parseInt(addQuestionIdExam.getText());
    } 
    public String getQuestionAddQuestion(){
        return   addQuestionQ.getText();
    }
    public String getCh1AddQuestion (){
        return   addQuestionCh1.getText();
    }
    public String getCh2AddQuestion (){
        return   addQuestionCh2.getText();
    }
    public String getCh3AddQuestion (){
        return   addQuestionCh3.getText();
    }
    public String getCh4AddQuestion (){
        return   addQuestionCh4.getText();
    }
    public int getTF1AddQuestion (){
        if(buttonGroupTFAddQuestion.getSelection().equals(addQuestionTF1.getModel()))
            return 1;
        else
            return 0;
    }
    public int getTF2AddQuestion (){
        if(buttonGroupTFAddQuestion.getSelection().equals(addQuestionTF2.getModel()))
            return 1;
        else
            return 0;
    }
    public int getTF3AddQuestion (){
        if(buttonGroupTFAddQuestion.getSelection().equals(addQuestionTF3.getModel()))
            return 1;
        else
            return 0;
    }
    public int getTF4AddQuestion (){
        if(buttonGroupTFAddQuestion.getSelection().equals(addQuestionTF4.getModel()))
            return 1;
        else
            return 0;
    } 
    public void addQuestionButton (ActionListener addQuestionListenerButton) {                                       
        addQuestionButton.addActionListener(addQuestionListenerButton);
    } 
    public void emptyingAddQuestion(){
        addExamDoneButton.setEnabled(true);
        addQuestionQ.setText("");
        addQuestionCh1.setText("");
        addQuestionCh2.setText("");
        addQuestionCh3.setText("");
        addQuestionCh4.setText("");
    }
    public void doneAddQuestionButton (ActionListener doneAddQuestionListenerButton) {                                       
        addExamDoneButton.addActionListener(doneAddQuestionListenerButton);
    }
    public void buttonAddReport (ActionListener addReportListenerButton) {                                       
        buttonAddReport.addActionListener(addReportListenerButton);
    } 
    public void setIdExamAddReport (String idExam) {                                       
       addReportIdExam.setText(idExam);
    }
    public void setIdStudentAddReport (String idStudent) {                                       
       addReportIdStudent.setText(idStudent);
    }
    public String getReport ( ) {                                       
        return reportToAddReports.getText();
    }
    public String getIdStudentAddReport ( ) {                                       
        return addReportIdStudent.getText();
    }
    public String getIdStudentAddExam ( ) {                                       
        return addReportIdExam.getText();
    }
    public void addReportButton (ActionListener addReportListenerButton) {                                       
        addReportButton.addActionListener(addReportListenerButton);
    }
    public void emptyingAddReport ( ) {                                       
        addReportIdStudent.setText("");
    }
     //----------------------
    public void goToHome (){
        cardLayoutPage.show(jPanelRight, "home");
    }
    public void goToViewSubjects (){
        cardLayoutExamsPage.show(subjectsjPanelRight, "viewSubjects");
        cardLayoutPage.show(jPanelRight, "Subjects"); 
    }
    public void goToViewExams (){
        cardLayoutExamsPage.show(subjectsjPanelRight, "viewExams");
        cardLayoutPage.show(jPanelRight, "Subjects"); 
    }
    public void goToRenameExam (){
        cardLayoutExamsPage.show(subjectsjPanelRight, "RenameExam");
        cardLayoutPage.show(jPanelRight, "Subjects"); 
    }
    public void goToAddExam (){
        cardLayoutExamsPage.show(subjectsjPanelRight, "addExam");
        cardLayoutPage.show(jPanelRight, "Subjects"); 
    }
    public void goToAddQuestions (){
        cardLayoutExamsPage.show(subjectsjPanelRight, "addQuestions");
        cardLayoutPage.show(jPanelRight, "Subjects");
    }
    public void goToViewQuestions (){
        cardLayoutExamsPage.show(subjectsjPanelRight, "viewQuestions");
        cardLayoutPage.show(jPanelRight, "Subjects");
    }
    public void goToViewQuestion (){
        cardLayoutExamsPage.show(subjectsjPanelRight, "viewQuestion");
        cardLayoutPage.show(jPanelRight, "Subjects");
    }
    public void goToRenameQuestion (){
        cardLayoutExamsPage.show(subjectsjPanelRight, "RenameQuestion");
        cardLayoutPage.show(jPanelRight, "Subjects");
    }
    public void goToUpdateQuestion (){
        cardLayoutExamsPage.show(subjectsjPanelRight, "updateQuestion");
        cardLayoutPage.show(jPanelRight, "Subjects");
    }
    public void goToViewStudentDegree (){
        cardLayoutExamsPage.show(subjectsjPanelRight, "viewStudentDegree");
        cardLayoutPage.show(jPanelRight, "Subjects");
    }
    public void goToAddReports (){
        cardLayoutExamsPage.show(subjectsjPanelRight, "addReports");
        cardLayoutPage.show(jPanelRight, "Subjects");
    }
    public void goToViewReports (){
        cardLayoutPage.show(jPanelRight, "Reports");
    }
    public void goTosetting (){
        cardLayoutPage.show(jPanelRight, "setting");
    }
    //------------------------
    public void homeButton (ActionListener homeListenerButton) {                                       
        homeButton.addActionListener(homeListenerButton);
    }
    public void subjectsButton (ActionListener subjectsListenerButton) {                                       
        subjectsButton.addActionListener(subjectsListenerButton);
    }
    public void reportsButton (ActionListener reportsListenerButton) {                                       
        reportsButton.addActionListener(reportsListenerButton);
    }
    public void settingButton (ActionListener settingListenerButton) {                                       
        settingButton.addActionListener(settingListenerButton);
    }
    public void buttonStudentDegree (ActionListener studentDegreeListenerButton) {                                       
        buttonStudentDegree.addActionListener(studentDegreeListenerButton);
    }
    public void renameExamPageButton (ActionListener renameExamListenerButton) {                                       
        buttonRenameExam.addActionListener(renameExamListenerButton);
    } 
     



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTF = new javax.swing.ButtonGroup();
        buttonGroupTFAddQuestion = new javax.swing.ButtonGroup();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanelLeft = new javax.swing.JPanel();
        LogoImg = new javax.swing.JLabel();
        fullNameJLabel1 = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();
        subjectsButton = new javax.swing.JButton();
        settingButton = new javax.swing.JButton();
        reportsButton = new javax.swing.JButton();
        jPanelRight = new javax.swing.JPanel();
        HomejPanelRight = new javax.swing.JPanel();
        LogoImg2 = new javax.swing.JLabel();
        img1 = new javax.swing.JLabel();
        fullNameJLabel = new javax.swing.JLabel();
        settingJPanelRight = new javax.swing.JPanel();
        Img4 = new javax.swing.JLabel();
        Username4 = new javax.swing.JLabel();
        usernameSetting = new javax.swing.JTextField();
        nameSetting = new javax.swing.JTextField();
        Username5 = new javax.swing.JLabel();
        Username6 = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        passwordSetting = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        emailSetting = new javax.swing.JTextField();
        Username7 = new javax.swing.JLabel();
        Username8 = new javax.swing.JLabel();
        dateSetting = new com.toedter.calendar.JDateChooser();
        subjectsjPanelRight = new javax.swing.JPanel();
        viewSubjects = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        searchMessages3 = new javax.swing.JLabel();
        SearchSubject = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        buttonAddExamSubjects = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableSubjects = new javax.swing.JTable();
        buttonExamSubjects = new javax.swing.JButton();
        buttonStudentDegree = new javax.swing.JButton();
        addExam = new javax.swing.JPanel();
        Img5 = new javax.swing.JLabel();
        Username11 = new javax.swing.JLabel();
        addExamIdSubject = new javax.swing.JTextField();
        addExamDetails = new javax.swing.JTextField();
        Username12 = new javax.swing.JLabel();
        Username13 = new javax.swing.JLabel();
        addExamButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        addExamName = new javax.swing.JTextField();
        Username16 = new javax.swing.JLabel();
        addExamDegree = new javax.swing.JTextField();
        addQuestions = new javax.swing.JPanel();
        Img6 = new javax.swing.JLabel();
        addQuestionIdExam = new javax.swing.JTextField();
        Username15 = new javax.swing.JLabel();
        addExamDoneButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        addQuestionButton = new javax.swing.JButton();
        addQuestionQ = new javax.swing.JTextField();
        addQuestionCh1 = new javax.swing.JTextField();
        addQuestionCh2 = new javax.swing.JTextField();
        addQuestionCh4 = new javax.swing.JTextField();
        addQuestionCh3 = new javax.swing.JTextField();
        addQuestionTF2 = new javax.swing.JRadioButton();
        addQuestionTF1 = new javax.swing.JRadioButton();
        addQuestionTF3 = new javax.swing.JRadioButton();
        addQuestionTF4 = new javax.swing.JRadioButton();
        viewExams = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        buttonExamModification = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableExams = new javax.swing.JTable();
        buttonRenameExam = new javax.swing.JButton();
        buttonDeleteExam = new javax.swing.JButton();
        goBackTo1 = new javax.swing.JButton();
        renameExam = new javax.swing.JPanel();
        Img7 = new javax.swing.JLabel();
        Username3 = new javax.swing.JLabel();
        nameUpdateExam = new javax.swing.JTextField();
        updateExamButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        idUpdateExam = new javax.swing.JTextField();
        name3 = new javax.swing.JLabel();
        Username9 = new javax.swing.JLabel();
        detailsUpdateExam = new javax.swing.JTextField();
        goBackTo2 = new javax.swing.JButton();
        viewQuestions = new javax.swing.JPanel();
        nameOfExam = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableQuestions = new javax.swing.JTable();
        buttonViewQuestion = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        buttonRenameQuestion = new javax.swing.JButton();
        goBackTo3 = new javax.swing.JButton();
        renameQuestion = new javax.swing.JPanel();
        Img8 = new javax.swing.JLabel();
        Username10 = new javax.swing.JLabel();
        nameUpdateQuestion = new javax.swing.JTextField();
        updateQuestionButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        idUpdateQuestion = new javax.swing.JTextField();
        name4 = new javax.swing.JLabel();
        goBackTo4 = new javax.swing.JButton();
        viewQuestion = new javax.swing.JPanel();
        Img9 = new javax.swing.JLabel();
        chosen1 = new javax.swing.JTextField();
        updateChosenButton1 = new javax.swing.JButton();
        questionTextField = new javax.swing.JLabel();
        idQuestion = new javax.swing.JTextField();
        name5 = new javax.swing.JLabel();
        chosenTF4 = new javax.swing.JLabel();
        chosenTF3 = new javax.swing.JLabel();
        chosenTF2 = new javax.swing.JLabel();
        chosenTF1 = new javax.swing.JLabel();
        chosen2 = new javax.swing.JTextField();
        chosen3 = new javax.swing.JTextField();
        chosen4 = new javax.swing.JTextField();
        goBackTo5 = new javax.swing.JButton();
        updateQuestion = new javax.swing.JPanel();
        Img10 = new javax.swing.JLabel();
        chosenUpdate1 = new javax.swing.JTextField();
        updateChosenButton2 = new javax.swing.JButton();
        questionTextField1 = new javax.swing.JLabel();
        idQuestionUpdate = new javax.swing.JTextField();
        name6 = new javax.swing.JLabel();
        chosenUpdate2 = new javax.swing.JTextField();
        chosenUpdate3 = new javax.swing.JTextField();
        chosenUpdate4 = new javax.swing.JTextField();
        goBackTo6 = new javax.swing.JButton();
        tfRadioButton1 = new javax.swing.JRadioButton();
        tfRadioButton4 = new javax.swing.JRadioButton();
        tfRadioButton2 = new javax.swing.JRadioButton();
        tfRadioButton3 = new javax.swing.JRadioButton();
        viewDegreeStudent = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        searchMessages4 = new javax.swing.JLabel();
        SearchIdStudent = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        buttonAddReport = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableStudentDegree = new javax.swing.JTable();
        goBackTo7 = new javax.swing.JButton();
        addReports = new javax.swing.JPanel();
        Img11 = new javax.swing.JLabel();
        addReportIdExam = new javax.swing.JTextField();
        Username17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        addReportButton = new javax.swing.JButton();
        addReportIdStudent = new javax.swing.JTextField();
        Username18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reportToAddReports = new javax.swing.JTextArea();
        viewReports = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        searchMessages5 = new javax.swing.JLabel();
        SearchIdStudentReport = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableReports = new javax.swing.JTable();
        buttonReportDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jSplitPane1.setDividerLocation(275);
        jSplitPane1.setDividerSize(0);
        jSplitPane1.setEnabled(false);

        jPanelLeft.setBackground(new java.awt.Color(15, 25, 38));
        jPanelLeft.setPreferredSize(new java.awt.Dimension(275, 750));

        LogoImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Logo.png"))); // NOI18N

        fullNameJLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        fullNameJLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fullNameJLabel1.setText("Hi, Full Name");
        fullNameJLabel1.setToolTipText("");

        homeButton.setBackground(new java.awt.Color(34, 100, 115));
        homeButton.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        homeButton.setForeground(new java.awt.Color(255, 255, 255));
        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_home_16px.png"))); // NOI18N
        homeButton.setText("Home");
        homeButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        subjectsButton.setBackground(new java.awt.Color(15, 25, 38));
        subjectsButton.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        subjectsButton.setForeground(new java.awt.Color(255, 255, 255));
        subjectsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_Books_16px.png"))); // NOI18N
        subjectsButton.setText("Subjects ");
        subjectsButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        settingButton.setBackground(new java.awt.Color(15, 25, 38));
        settingButton.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        settingButton.setForeground(new java.awt.Color(255, 255, 255));
        settingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_settings_16px.png"))); // NOI18N
        settingButton.setText("Setting");
        settingButton.setToolTipText("");
        settingButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        reportsButton.setBackground(new java.awt.Color(15, 25, 38));
        reportsButton.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        reportsButton.setForeground(new java.awt.Color(255, 255, 255));
        reportsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_Report_Card_16px.png"))); // NOI18N
        reportsButton.setText("Reports");
        reportsButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanelLeftLayout = new javax.swing.GroupLayout(jPanelLeft);
        jPanelLeft.setLayout(jPanelLeftLayout);
        jPanelLeftLayout.setHorizontalGroup(
            jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogoImg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, Short.MAX_VALUE)
            .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(subjectsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(reportsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(settingButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fullNameJLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelLeftLayout.setVerticalGroup(
            jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLeftLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(fullNameJLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogoImg)
                .addGap(29, 29, 29)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subjectsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reportsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(settingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(380, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanelLeft);

        jPanelRight.setPreferredSize(new java.awt.Dimension(1005, 750));
        jPanelRight.setLayout(new java.awt.CardLayout());

        HomejPanelRight.setPreferredSize(new java.awt.Dimension(1005, 720));

        LogoImg2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogoImg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Logo.png"))); // NOI18N

        img1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        img1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/LearningApp.png"))); // NOI18N

        fullNameJLabel.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        fullNameJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fullNameJLabel.setText("jLabel1");

        javax.swing.GroupLayout HomejPanelRightLayout = new javax.swing.GroupLayout(HomejPanelRight);
        HomejPanelRight.setLayout(HomejPanelRightLayout);
        HomejPanelRightLayout.setHorizontalGroup(
            HomejPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fullNameJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(HomejPanelRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HomejPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img1, javax.swing.GroupLayout.DEFAULT_SIZE, 993, Short.MAX_VALUE)
                    .addComponent(LogoImg2, javax.swing.GroupLayout.DEFAULT_SIZE, 993, Short.MAX_VALUE))
                .addContainerGap())
        );
        HomejPanelRightLayout.setVerticalGroup(
            HomejPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomejPanelRightLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(fullNameJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(LogoImg2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(img1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelRight.add(HomejPanelRight, "home");

        settingJPanelRight.setPreferredSize(new java.awt.Dimension(1005, 720));

        Img4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Setting1.png"))); // NOI18N

        Username4.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username4.setText("UserName:");

        Username5.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username5.setText("Name:");

        Username6.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username6.setText("Password:");

        updateButton.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_update_user_32px.png"))); // NOI18N
        updateButton.setText("Update");

        jLabel2.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel2.setText("Setting:");

        Username7.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username7.setText("Email:");

        Username8.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username8.setText("Birthday:");

        javax.swing.GroupLayout settingJPanelRightLayout = new javax.swing.GroupLayout(settingJPanelRight);
        settingJPanelRight.setLayout(settingJPanelRightLayout);
        settingJPanelRightLayout.setHorizontalGroup(
            settingJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingJPanelRightLayout.createSequentialGroup()
                .addGroup(settingJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settingJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(settingJPanelRightLayout.createSequentialGroup()
                            .addGap(447, 447, 447)
                            .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(223, 223, 223))
                        .addGroup(settingJPanelRightLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Img4)))
                    .addGroup(settingJPanelRightLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(settingJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(settingJPanelRightLayout.createSequentialGroup()
                                .addComponent(Username4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(usernameSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(settingJPanelRightLayout.createSequentialGroup()
                                .addComponent(Username5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nameSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(47, 47, 47)
                        .addGroup(settingJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(settingJPanelRightLayout.createSequentialGroup()
                                .addComponent(Username6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(passwordSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(settingJPanelRightLayout.createSequentialGroup()
                                .addComponent(Username7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(emailSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(settingJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Username8)
                            .addComponent(dateSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        settingJPanelRightLayout.setVerticalGroup(
            settingJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingJPanelRightLayout.createSequentialGroup()
                .addGroup(settingJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settingJPanelRightLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(Img4))
                    .addGroup(settingJPanelRightLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGap(46, 46, 46)
                .addGroup(settingJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(settingJPanelRightLayout.createSequentialGroup()
                        .addGroup(settingJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(settingJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Username4)
                                .addComponent(Username6)
                                .addComponent(usernameSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(settingJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Username5)
                            .addComponent(Username7)
                            .addComponent(emailSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(settingJPanelRightLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Username8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(updateButton)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jPanelRight.add(settingJPanelRight, "setting");

        subjectsjPanelRight.setLayout(new java.awt.CardLayout());

        viewSubjects.setPreferredSize(new java.awt.Dimension(1005, 720));

        jLabel5.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel5.setText("Subjects:");

        searchMessages3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchMessages3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_search_32px.png"))); // NOI18N

        SearchSubject.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N

        jLabel32.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        jLabel32.setText("name:");

        buttonAddExamSubjects.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonAddExamSubjects.setForeground(new java.awt.Color(255, 255, 255));
        buttonAddExamSubjects.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_Add_16px.png"))); // NOI18N
        buttonAddExamSubjects.setText("Add Exam");

        jTableSubjects.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTableSubjects);

        buttonExamSubjects.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonExamSubjects.setForeground(new java.awt.Color(255, 255, 255));
        buttonExamSubjects.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_book_16px.png"))); // NOI18N
        buttonExamSubjects.setText("Exams");

        buttonStudentDegree.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonStudentDegree.setForeground(new java.awt.Color(255, 255, 255));
        buttonStudentDegree.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_student_center_16px.png"))); // NOI18N
        buttonStudentDegree.setText("Students");

        javax.swing.GroupLayout viewSubjectsLayout = new javax.swing.GroupLayout(viewSubjects);
        viewSubjects.setLayout(viewSubjectsLayout);
        viewSubjectsLayout.setHorizontalGroup(
            viewSubjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewSubjectsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewSubjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewSubjectsLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(247, 247, 247)
                        .addComponent(searchMessages3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(viewSubjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SearchSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32))
                        .addGap(0, 342, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewSubjectsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonAddExamSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonExamSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonStudentDegree, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250))
        );
        viewSubjectsLayout.setVerticalGroup(
            viewSubjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewSubjectsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewSubjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchMessages3)
                    .addGroup(viewSubjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(viewSubjectsLayout.createSequentialGroup()
                            .addComponent(jLabel32)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(SearchSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(viewSubjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAddExamSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonExamSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonStudentDegree, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        subjectsjPanelRight.add(viewSubjects, "viewSubjects");

        addExam.setPreferredSize(new java.awt.Dimension(1005, 720));

        Img5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/addExam.png"))); // NOI18N

        Username11.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username11.setText("Id Subject:");

        addExamIdSubject.setEditable(false);

        Username12.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username12.setText("Details:");

        Username13.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username13.setText("Exam:");

        addExamButton.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        addExamButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_add_32px.png"))); // NOI18N
        addExamButton.setText("Add");

        jLabel3.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel3.setText("Add Exam:");

        Username16.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username16.setText("Question score:");

        javax.swing.GroupLayout addExamLayout = new javax.swing.GroupLayout(addExam);
        addExam.setLayout(addExamLayout);
        addExamLayout.setHorizontalGroup(
            addExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addExamLayout.createSequentialGroup()
                .addGap(0, 54, Short.MAX_VALUE)
                .addComponent(Username11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addExamIdSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(addExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(addExamLayout.createSequentialGroup()
                        .addComponent(Username13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addExamName, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addExamLayout.createSequentialGroup()
                        .addComponent(Username16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addExamDegree)))
                .addGap(18, 18, 18)
                .addComponent(Username12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addExamDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addExamLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addExamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(430, 430, 430))
            .addGroup(addExamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(67, 67, 67)
                .addComponent(Img5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addExamLayout.setVerticalGroup(
            addExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addExamLayout.createSequentialGroup()
                .addGroup(addExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addExamLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(Img5))
                    .addGroup(addExamLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(addExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Username11)
                    .addComponent(Username13)
                    .addComponent(addExamIdSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addExamName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addExamDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Username12))
                .addGap(10, 10, 10)
                .addGroup(addExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addExamDegree, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Username16))
                .addGap(18, 18, 18)
                .addComponent(addExamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        subjectsjPanelRight.add(addExam, "addExam");

        addQuestions.setPreferredSize(new java.awt.Dimension(1005, 720));

        Img6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/addExam.png"))); // NOI18N

        Username15.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username15.setText("Id Exam:");

        addExamDoneButton.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        addExamDoneButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_ok_16px.png"))); // NOI18N
        addExamDoneButton.setText("Done");
        addExamDoneButton.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel4.setText("Add Questions:");

        addQuestionButton.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        addQuestionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_add_32px.png"))); // NOI18N
        addQuestionButton.setText("Add");

        addQuestionCh1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        addQuestionCh2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        addQuestionCh4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        addQuestionCh3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        buttonGroupTFAddQuestion.add(addQuestionTF2);
        addQuestionTF2.setText("True");

        buttonGroupTFAddQuestion.add(addQuestionTF1);
        addQuestionTF1.setText("True");

        buttonGroupTFAddQuestion.add(addQuestionTF3);
        addQuestionTF3.setText("True");

        buttonGroupTFAddQuestion.add(addQuestionTF4);
        addQuestionTF4.setText("True");

        javax.swing.GroupLayout addQuestionsLayout = new javax.swing.GroupLayout(addQuestions);
        addQuestions.setLayout(addQuestionsLayout);
        addQuestionsLayout.setHorizontalGroup(
            addQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addQuestionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addQuestionsLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30)
                        .addComponent(Img6))
                    .addGroup(addQuestionsLayout.createSequentialGroup()
                        .addComponent(Username15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addQuestionIdExam, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addQuestionsLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(addQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addQuestionQ, javax.swing.GroupLayout.PREFERRED_SIZE, 888, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addQuestionsLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(addQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(addQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(addQuestionCh4, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(addQuestionCh3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(addQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(addQuestionCh2, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(addQuestionCh1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(addQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addQuestionTF2)
                                    .addComponent(addQuestionTF1)
                                    .addComponent(addQuestionTF3)
                                    .addComponent(addQuestionTF4)))
                            .addGroup(addQuestionsLayout.createSequentialGroup()
                                .addGap(372, 372, 372)
                                .addGroup(addQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(addExamDoneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addQuestionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        addQuestionsLayout.setVerticalGroup(
            addQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addQuestionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(Img6, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Username15)
                    .addComponent(addQuestionIdExam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addQuestionQ, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(addQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addQuestionCh1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addQuestionTF1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addQuestionCh2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addQuestionTF2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addQuestionCh3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addQuestionTF3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addQuestionTF4)
                    .addComponent(addQuestionCh4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addQuestionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addExamDoneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        subjectsjPanelRight.add(addQuestions, "addQuestions");

        viewExams.setPreferredSize(new java.awt.Dimension(1005, 720));

        jLabel6.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel6.setText("Exams:");

        buttonExamModification.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonExamModification.setForeground(new java.awt.Color(255, 255, 255));
        buttonExamModification.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_settings_16px.png"))); // NOI18N
        buttonExamModification.setText("Modification");
        buttonExamModification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExamModificationActionPerformed(evt);
            }
        });

        jTableExams.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTableExams);

        buttonRenameExam.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonRenameExam.setForeground(new java.awt.Color(255, 255, 255));
        buttonRenameExam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_autograph_16px.png"))); // NOI18N
        buttonRenameExam.setText("Rename");

        buttonDeleteExam.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonDeleteExam.setForeground(new java.awt.Color(255, 255, 255));
        buttonDeleteExam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_delete_16px.png"))); // NOI18N
        buttonDeleteExam.setText("Delete");
        buttonDeleteExam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteExamActionPerformed(evt);
            }
        });

        goBackTo1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        goBackTo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_reply_arrow_32px.png"))); // NOI18N
        goBackTo1.setText("Back");
        goBackTo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackTo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viewExamsLayout = new javax.swing.GroupLayout(viewExams);
        viewExams.setLayout(viewExamsLayout);
        viewExamsLayout.setHorizontalGroup(
            viewExamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewExamsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewExamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewExamsLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 993, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(viewExamsLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(buttonExamModification, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonRenameExam, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDeleteExam, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(goBackTo1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        viewExamsLayout.setVerticalGroup(
            viewExamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewExamsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(viewExamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(goBackTo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(viewExamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonExamModification, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonRenameExam, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonDeleteExam, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        subjectsjPanelRight.add(viewExams, "viewExams");

        renameExam.setPreferredSize(new java.awt.Dimension(1005, 720));

        Img7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/RenameExam.png"))); // NOI18N

        Username3.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username3.setText("Name:");

        updateExamButton.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        updateExamButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_buy_upgrade_32px_1.png"))); // NOI18N
        updateExamButton.setText("Update");

        jLabel7.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel7.setText("Rename Exam:");

        idUpdateExam.setEditable(false);

        name3.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        name3.setText("ID:");

        Username9.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username9.setText("Details:");

        goBackTo2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        goBackTo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_reply_arrow_32px.png"))); // NOI18N
        goBackTo2.setText("Back");
        goBackTo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackTo2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout renameExamLayout = new javax.swing.GroupLayout(renameExam);
        renameExam.setLayout(renameExamLayout);
        renameExamLayout.setHorizontalGroup(
            renameExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(renameExamLayout.createSequentialGroup()
                .addGroup(renameExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(renameExamLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(0, 0, 0)
                        .addComponent(Img7))
                    .addGroup(renameExamLayout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addComponent(name3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idUpdateExam, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, renameExamLayout.createSequentialGroup()
                .addContainerGap(168, Short.MAX_VALUE)
                .addGroup(renameExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, renameExamLayout.createSequentialGroup()
                        .addComponent(Username3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameUpdateExam, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(Username9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(detailsUpdateExam, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(213, 213, 213))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, renameExamLayout.createSequentialGroup()
                        .addGroup(renameExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(goBackTo2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateExamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(436, 436, 436))))
        );
        renameExamLayout.setVerticalGroup(
            renameExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(renameExamLayout.createSequentialGroup()
                .addGroup(renameExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(renameExamLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(Img7))
                    .addGroup(renameExamLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addGroup(renameExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(renameExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nameUpdateExam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Username3))
                    .addGroup(renameExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(detailsUpdateExam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Username9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(renameExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name3)
                    .addComponent(idUpdateExam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(updateExamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(goBackTo2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        subjectsjPanelRight.add(renameExam, "RenameExam");

        viewQuestions.setPreferredSize(new java.awt.Dimension(1005, 720));
        viewQuestions.setVerifyInputWhenFocusTarget(false);

        nameOfExam.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        nameOfExam.setText("Name Of Exam");

        jTableQuestions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTableQuestions);

        buttonViewQuestion.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonViewQuestion.setForeground(new java.awt.Color(255, 255, 255));
        buttonViewQuestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_book_16px.png"))); // NOI18N
        buttonViewQuestion.setText("View");

        jLabel9.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel9.setText("Question:");

        buttonRenameQuestion.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonRenameQuestion.setForeground(new java.awt.Color(255, 255, 255));
        buttonRenameQuestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_autograph_16px.png"))); // NOI18N
        buttonRenameQuestion.setText("Rename");
        buttonRenameQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRenameQuestionActionPerformed(evt);
            }
        });

        goBackTo3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        goBackTo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_reply_arrow_32px.png"))); // NOI18N
        goBackTo3.setText("Back");
        goBackTo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackTo3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viewQuestionsLayout = new javax.swing.GroupLayout(viewQuestions);
        viewQuestions.setLayout(viewQuestionsLayout);
        viewQuestionsLayout.setHorizontalGroup(
            viewQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewQuestionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(viewQuestionsLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(nameOfExam)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(viewQuestionsLayout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(buttonRenameQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonViewQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(goBackTo3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        viewQuestionsLayout.setVerticalGroup(
            viewQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewQuestionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(nameOfExam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(viewQuestionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonViewQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRenameQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goBackTo3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        subjectsjPanelRight.add(viewQuestions, "viewQuestions");

        renameQuestion.setPreferredSize(new java.awt.Dimension(1005, 720));

        Img8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/RenameExam.png"))); // NOI18N

        Username10.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username10.setText("Name:");

        updateQuestionButton.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        updateQuestionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_buy_upgrade_32px_1.png"))); // NOI18N
        updateQuestionButton.setText("Update");

        jLabel8.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel8.setText("Rename Question:");

        idUpdateQuestion.setEditable(false);

        name4.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        name4.setText("ID:");

        goBackTo4.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        goBackTo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_reply_arrow_32px.png"))); // NOI18N
        goBackTo4.setText("Back");
        goBackTo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackTo4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout renameQuestionLayout = new javax.swing.GroupLayout(renameQuestion);
        renameQuestion.setLayout(renameQuestionLayout);
        renameQuestionLayout.setHorizontalGroup(
            renameQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(renameQuestionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(renameQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(renameQuestionLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, 0)
                        .addComponent(Img8)
                        .addContainerGap(180, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, renameQuestionLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(name4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idUpdateQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Username10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameUpdateQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(215, 215, 215))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, renameQuestionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(renameQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(goBackTo4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateQuestionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(403, 403, 403))
        );
        renameQuestionLayout.setVerticalGroup(
            renameQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(renameQuestionLayout.createSequentialGroup()
                .addGroup(renameQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(renameQuestionLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(Img8)
                        .addGap(18, 18, 18)
                        .addGroup(renameQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name4)
                            .addComponent(idUpdateQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameUpdateQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Username10))
                        .addGap(18, 18, 18)
                        .addComponent(updateQuestionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(goBackTo4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(renameQuestionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        subjectsjPanelRight.add(renameQuestion, "RenameQuestion");

        viewQuestion.setPreferredSize(new java.awt.Dimension(1005, 720));

        Img9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Img9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/RenameExam.png"))); // NOI18N
        Img9.setToolTipText("");

        chosen1.setEditable(false);
        chosen1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        updateChosenButton1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        updateChosenButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_buy_upgrade_32px_1.png"))); // NOI18N
        updateChosenButton1.setText("Update");
        updateChosenButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateChosenButton1ActionPerformed(evt);
            }
        });

        questionTextField.setFont(new java.awt.Font("Roboto Slab Medium", 1, 18)); // NOI18N
        questionTextField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        questionTextField.setText("::");

        idQuestion.setEditable(false);

        name5.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        name5.setText("ID:");

        chosenTF4.setText("jLabel1");

        chosenTF3.setText("jLabel1");

        chosenTF2.setText("jLabel1");

        chosenTF1.setText("true");

        chosen2.setEditable(false);
        chosen2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        chosen3.setEditable(false);
        chosen3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        chosen4.setEditable(false);
        chosen4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        goBackTo5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        goBackTo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_reply_arrow_32px.png"))); // NOI18N
        goBackTo5.setText("Back");
        goBackTo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackTo5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viewQuestionLayout = new javax.swing.GroupLayout(viewQuestion);
        viewQuestion.setLayout(viewQuestionLayout);
        viewQuestionLayout.setHorizontalGroup(
            viewQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Img9, javax.swing.GroupLayout.DEFAULT_SIZE, 1005, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewQuestionLayout.createSequentialGroup()
                .addGroup(viewQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(viewQuestionLayout.createSequentialGroup()
                        .addGroup(viewQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(chosen1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
                            .addComponent(chosen2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chosen3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chosen4, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(viewQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chosenTF1)
                            .addComponent(chosenTF2)
                            .addComponent(chosenTF3)
                            .addComponent(chosenTF4))
                        .addGap(28, 28, 28))
                    .addGroup(viewQuestionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(viewQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(questionTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(viewQuestionLayout.createSequentialGroup()
                                .addComponent(goBackTo5, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateChosenButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(name5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(44, 44, 44))
        );
        viewQuestionLayout.setVerticalGroup(
            viewQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewQuestionLayout.createSequentialGroup()
                .addComponent(Img9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(questionTextField)
                .addGap(12, 12, 12)
                .addGroup(viewQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name5)
                    .addComponent(idQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateChosenButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goBackTo5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(viewQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chosen1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chosenTF1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(viewQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chosen2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chosenTF2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(viewQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chosen3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chosenTF3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(viewQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chosen4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chosenTF4))
                .addGap(35, 35, 35))
        );

        subjectsjPanelRight.add(viewQuestion, "viewQuestion");

        updateQuestion.setPreferredSize(new java.awt.Dimension(1005, 720));

        Img10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Img10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/RenameExam.png"))); // NOI18N
        Img10.setToolTipText("");

        chosenUpdate1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        updateChosenButton2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        updateChosenButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_buy_upgrade_32px_1.png"))); // NOI18N
        updateChosenButton2.setText("Update");

        questionTextField1.setFont(new java.awt.Font("Roboto Slab Medium", 1, 18)); // NOI18N
        questionTextField1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        questionTextField1.setText("::");

        idQuestionUpdate.setEditable(false);

        name6.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        name6.setText("ID:");

        chosenUpdate2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        chosenUpdate3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        chosenUpdate4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        goBackTo6.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        goBackTo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_reply_arrow_32px.png"))); // NOI18N
        goBackTo6.setText("Back");
        goBackTo6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackTo6ActionPerformed(evt);
            }
        });

        buttonGroupTF.add(tfRadioButton1);
        tfRadioButton1.setText("True");

        buttonGroupTF.add(tfRadioButton4);
        tfRadioButton4.setText("True");

        buttonGroupTF.add(tfRadioButton2);
        tfRadioButton2.setText("True");

        buttonGroupTF.add(tfRadioButton3);
        tfRadioButton3.setText("True");

        javax.swing.GroupLayout updateQuestionLayout = new javax.swing.GroupLayout(updateQuestion);
        updateQuestion.setLayout(updateQuestionLayout);
        updateQuestionLayout.setHorizontalGroup(
            updateQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Img10, javax.swing.GroupLayout.DEFAULT_SIZE, 1005, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateQuestionLayout.createSequentialGroup()
                .addGroup(updateQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(updateQuestionLayout.createSequentialGroup()
                        .addGroup(updateQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(chosenUpdate1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
                            .addComponent(chosenUpdate2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chosenUpdate3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chosenUpdate4, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(updateQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateQuestionLayout.createSequentialGroup()
                                .addComponent(tfRadioButton2)
                                .addGap(17, 17, 17))
                            .addComponent(tfRadioButton1)
                            .addComponent(tfRadioButton3)
                            .addComponent(tfRadioButton4)))
                    .addGroup(updateQuestionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(updateQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(questionTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(updateQuestionLayout.createSequentialGroup()
                                .addComponent(goBackTo6, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateChosenButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(name6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idQuestionUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(44, 44, 44))
        );
        updateQuestionLayout.setVerticalGroup(
            updateQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateQuestionLayout.createSequentialGroup()
                .addComponent(Img10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(questionTextField1)
                .addGap(12, 12, 12)
                .addGroup(updateQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name6)
                    .addComponent(idQuestionUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateChosenButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goBackTo6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(updateQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chosenUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(updateQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chosenUpdate2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(updateQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chosenUpdate3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(updateQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chosenUpdate4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfRadioButton4))
                .addGap(35, 35, 35))
        );

        subjectsjPanelRight.add(updateQuestion, "updateQuestion");

        viewDegreeStudent.setPreferredSize(new java.awt.Dimension(1005, 720));

        jLabel10.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel10.setText("Degree:");

        searchMessages4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchMessages4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_search_32px.png"))); // NOI18N

        SearchIdStudent.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N

        jLabel33.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        jLabel33.setText("ID:");

        buttonAddReport.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonAddReport.setForeground(new java.awt.Color(255, 255, 255));
        buttonAddReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_Report_Card_16px.png"))); // NOI18N
        buttonAddReport.setText("Add Report");

        jTableStudentDegree.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(jTableStudentDegree);

        goBackTo7.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        goBackTo7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_reply_arrow_32px.png"))); // NOI18N
        goBackTo7.setText("Back");
        goBackTo7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackTo7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viewDegreeStudentLayout = new javax.swing.GroupLayout(viewDegreeStudent);
        viewDegreeStudent.setLayout(viewDegreeStudentLayout);
        viewDegreeStudentLayout.setHorizontalGroup(
            viewDegreeStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewDegreeStudentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewDegreeStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewDegreeStudentLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(281, 281, 281)
                        .addComponent(searchMessages4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(viewDegreeStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SearchIdStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))
                        .addGap(0, 328, Short.MAX_VALUE))
                    .addComponent(jScrollPane6))
                .addContainerGap())
            .addGroup(viewDegreeStudentLayout.createSequentialGroup()
                .addGap(335, 335, 335)
                .addComponent(buttonAddReport, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(goBackTo7, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        viewDegreeStudentLayout.setVerticalGroup(
            viewDegreeStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewDegreeStudentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewDegreeStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchMessages4)
                    .addGroup(viewDegreeStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(viewDegreeStudentLayout.createSequentialGroup()
                            .addComponent(jLabel33)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(SearchIdStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(viewDegreeStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonAddReport, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(goBackTo7, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addContainerGap())
        );

        subjectsjPanelRight.add(viewDegreeStudent, "viewStudentDegree");

        addReports.setPreferredSize(new java.awt.Dimension(1005, 720));

        Img11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/addExam.png"))); // NOI18N

        Username17.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username17.setText("Id Exam:");

        jLabel12.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel12.setText("Add Reports:");

        addReportButton.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        addReportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_add_32px.png"))); // NOI18N
        addReportButton.setText("Add");

        Username18.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username18.setText("Id Student:");

        reportToAddReports.setColumns(20);
        reportToAddReports.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        reportToAddReports.setRows(5);
        jScrollPane1.setViewportView(reportToAddReports);

        javax.swing.GroupLayout addReportsLayout = new javax.swing.GroupLayout(addReports);
        addReports.setLayout(addReportsLayout);
        addReportsLayout.setHorizontalGroup(
            addReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addReportsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(addReportsLayout.createSequentialGroup()
                        .addGroup(addReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addReportsLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(69, 69, 69)
                                .addComponent(Img11))
                            .addGroup(addReportsLayout.createSequentialGroup()
                                .addGap(424, 424, 424)
                                .addComponent(addReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addReportsLayout.createSequentialGroup()
                                .addComponent(Username17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addReportIdExam, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Username18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addReportIdStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 172, Short.MAX_VALUE)))
                .addContainerGap())
        );
        addReportsLayout.setVerticalGroup(
            addReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addReportsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(Img11, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Username17)
                    .addComponent(addReportIdExam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Username18)
                    .addComponent(addReportIdStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        subjectsjPanelRight.add(addReports, "addReports");

        jPanelRight.add(subjectsjPanelRight, "Subjects");

        viewReports.setPreferredSize(new java.awt.Dimension(1005, 720));

        jLabel11.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel11.setText("Reports:");

        searchMessages5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchMessages5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_search_32px.png"))); // NOI18N

        SearchIdStudentReport.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        jLabel34.setText("Id_Student:");

        jTableReports.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(jTableReports);

        buttonReportDelete.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonReportDelete.setForeground(new java.awt.Color(255, 255, 255));
        buttonReportDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_delete_16px.png"))); // NOI18N
        buttonReportDelete.setText("Delete");
        buttonReportDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReportDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viewReportsLayout = new javax.swing.GroupLayout(viewReports);
        viewReports.setLayout(viewReportsLayout);
        viewReportsLayout.setHorizontalGroup(
            viewReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewReportsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewReportsLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(247, 247, 247)
                        .addComponent(searchMessages5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(viewReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SearchIdStudentReport, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34))
                        .addGap(0, 353, Short.MAX_VALUE))
                    .addComponent(jScrollPane7))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewReportsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonReportDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(420, 420, 420))
        );
        viewReportsLayout.setVerticalGroup(
            viewReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewReportsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchMessages5)
                    .addGroup(viewReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(viewReportsLayout.createSequentialGroup()
                            .addComponent(jLabel34)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(SearchIdStudentReport, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel11)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonReportDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelRight.add(viewReports, "Reports");

        jSplitPane1.setRightComponent(jPanelRight);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExamModificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExamModificationActionPerformed
        if(idExamInTable()!= 0){
            cardLayoutExamsPage.show(subjectsjPanelRight, "viewQuestions");
            nameOfExam.setText(nameExamInTable()); 
        }
        else
            Tools.msgBox("Select Exam ^-^");
    }//GEN-LAST:event_buttonExamModificationActionPerformed

    private void buttonRenameQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRenameQuestionActionPerformed
        try{
        int numOfRow = jTableQuestions.getSelectedRow();
        int idOfQuestion = Integer.parseInt((String) jTableQuestions.getModel().getValueAt(numOfRow, 0));
        idUpdateQuestion.setText(idOfQuestion +"");
        String nameQuestion = (String) jTableQuestions.getModel().getValueAt(numOfRow, 1);
        nameUpdateQuestion.setText(nameQuestion);
        cardLayoutExamsPage.show(subjectsjPanelRight, "RenameQuestion");
        }catch(ArrayIndexOutOfBoundsException ex){Tools.errmsgBox("Select Exam ^-^");} 
    }//GEN-LAST:event_buttonRenameQuestionActionPerformed

    private void goBackTo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackTo5ActionPerformed
        cardLayoutExamsPage.show(subjectsjPanelRight, "viewQuestions");
    }//GEN-LAST:event_goBackTo5ActionPerformed

    private void goBackTo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackTo4ActionPerformed
        cardLayoutExamsPage.show(subjectsjPanelRight, "viewQuestions");
    }//GEN-LAST:event_goBackTo4ActionPerformed

    private void goBackTo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackTo3ActionPerformed
       cardLayoutExamsPage.show(subjectsjPanelRight, "viewExams");
    }//GEN-LAST:event_goBackTo3ActionPerformed

    private void goBackTo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackTo1ActionPerformed
        cardLayoutExamsPage.show(subjectsjPanelRight, "viewSubjects");
    }//GEN-LAST:event_goBackTo1ActionPerformed

    private void goBackTo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackTo2ActionPerformed
        cardLayoutExamsPage.show(subjectsjPanelRight, "viewExams");
    }//GEN-LAST:event_goBackTo2ActionPerformed

    private void goBackTo6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackTo6ActionPerformed
        cardLayoutExamsPage.show(subjectsjPanelRight, "viewQuestion");
    }//GEN-LAST:event_goBackTo6ActionPerformed

    private void updateChosenButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateChosenButton1ActionPerformed
        cardLayoutExamsPage.show(subjectsjPanelRight, "updateQuestion");
        questionTextField1.setText(questionTextField.getText());
        idQuestionUpdate.setText(idQuestion.getText());
    }//GEN-LAST:event_updateChosenButton1ActionPerformed

    private void goBackTo7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackTo7ActionPerformed
        cardLayoutExamsPage.show(subjectsjPanelRight, "viewSubjects"); 
    }//GEN-LAST:event_goBackTo7ActionPerformed

    private void buttonReportDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReportDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonReportDeleteActionPerformed

    private void buttonDeleteExamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteExamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonDeleteExamActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LecturerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LecturerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LecturerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LecturerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LecturerView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HomejPanelRight;
    private javax.swing.JLabel Img10;
    private javax.swing.JLabel Img11;
    private javax.swing.JLabel Img4;
    private javax.swing.JLabel Img5;
    private javax.swing.JLabel Img6;
    private javax.swing.JLabel Img7;
    private javax.swing.JLabel Img8;
    private javax.swing.JLabel Img9;
    private javax.swing.JLabel LogoImg;
    private javax.swing.JLabel LogoImg2;
    private javax.swing.JTextField SearchIdStudent;
    private javax.swing.JTextField SearchIdStudentReport;
    private javax.swing.JTextField SearchSubject;
    private javax.swing.JLabel Username10;
    private javax.swing.JLabel Username11;
    private javax.swing.JLabel Username12;
    private javax.swing.JLabel Username13;
    private javax.swing.JLabel Username15;
    private javax.swing.JLabel Username16;
    private javax.swing.JLabel Username17;
    private javax.swing.JLabel Username18;
    private javax.swing.JLabel Username3;
    private javax.swing.JLabel Username4;
    private javax.swing.JLabel Username5;
    private javax.swing.JLabel Username6;
    private javax.swing.JLabel Username7;
    private javax.swing.JLabel Username8;
    private javax.swing.JLabel Username9;
    private javax.swing.JPanel addExam;
    private javax.swing.JButton addExamButton;
    private javax.swing.JTextField addExamDegree;
    private javax.swing.JTextField addExamDetails;
    private javax.swing.JButton addExamDoneButton;
    private javax.swing.JTextField addExamIdSubject;
    private javax.swing.JTextField addExamName;
    private javax.swing.JButton addQuestionButton;
    private javax.swing.JTextField addQuestionCh1;
    private javax.swing.JTextField addQuestionCh2;
    private javax.swing.JTextField addQuestionCh3;
    private javax.swing.JTextField addQuestionCh4;
    private javax.swing.JTextField addQuestionIdExam;
    private javax.swing.JTextField addQuestionQ;
    private javax.swing.JRadioButton addQuestionTF1;
    private javax.swing.JRadioButton addQuestionTF2;
    private javax.swing.JRadioButton addQuestionTF3;
    private javax.swing.JRadioButton addQuestionTF4;
    private javax.swing.JPanel addQuestions;
    private javax.swing.JButton addReportButton;
    private javax.swing.JTextField addReportIdExam;
    private javax.swing.JTextField addReportIdStudent;
    private javax.swing.JPanel addReports;
    private javax.swing.JButton buttonAddExamSubjects;
    private javax.swing.JButton buttonAddReport;
    private javax.swing.JButton buttonDeleteExam;
    private javax.swing.JButton buttonExamModification;
    private javax.swing.JButton buttonExamSubjects;
    private javax.swing.ButtonGroup buttonGroupTF;
    private javax.swing.ButtonGroup buttonGroupTFAddQuestion;
    private javax.swing.JButton buttonRenameExam;
    private javax.swing.JButton buttonRenameQuestion;
    private javax.swing.JButton buttonReportDelete;
    private javax.swing.JButton buttonStudentDegree;
    private javax.swing.JButton buttonViewQuestion;
    private javax.swing.JTextField chosen1;
    private javax.swing.JTextField chosen2;
    private javax.swing.JTextField chosen3;
    private javax.swing.JTextField chosen4;
    private javax.swing.JLabel chosenTF1;
    private javax.swing.JLabel chosenTF2;
    private javax.swing.JLabel chosenTF3;
    private javax.swing.JLabel chosenTF4;
    private javax.swing.JTextField chosenUpdate1;
    private javax.swing.JTextField chosenUpdate2;
    private javax.swing.JTextField chosenUpdate3;
    private javax.swing.JTextField chosenUpdate4;
    private com.toedter.calendar.JDateChooser dateSetting;
    private javax.swing.JTextField detailsUpdateExam;
    private javax.swing.JTextField emailSetting;
    private javax.swing.JLabel fullNameJLabel;
    private javax.swing.JLabel fullNameJLabel1;
    private javax.swing.JButton goBackTo1;
    private javax.swing.JButton goBackTo2;
    private javax.swing.JButton goBackTo3;
    private javax.swing.JButton goBackTo4;
    private javax.swing.JButton goBackTo5;
    private javax.swing.JButton goBackTo6;
    private javax.swing.JButton goBackTo7;
    private javax.swing.JButton homeButton;
    private javax.swing.JTextField idQuestion;
    private javax.swing.JTextField idQuestionUpdate;
    private javax.swing.JTextField idUpdateExam;
    private javax.swing.JTextField idUpdateQuestion;
    private javax.swing.JLabel img1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelLeft;
    private javax.swing.JPanel jPanelRight;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTableExams;
    private javax.swing.JTable jTableQuestions;
    private javax.swing.JTable jTableReports;
    private javax.swing.JTable jTableStudentDegree;
    private javax.swing.JTable jTableSubjects;
    private javax.swing.JLabel name3;
    private javax.swing.JLabel name4;
    private javax.swing.JLabel name5;
    private javax.swing.JLabel name6;
    private javax.swing.JLabel nameOfExam;
    private javax.swing.JTextField nameSetting;
    private javax.swing.JTextField nameUpdateExam;
    private javax.swing.JTextField nameUpdateQuestion;
    private javax.swing.JPasswordField passwordSetting;
    private javax.swing.JLabel questionTextField;
    private javax.swing.JLabel questionTextField1;
    private javax.swing.JPanel renameExam;
    private javax.swing.JPanel renameQuestion;
    private javax.swing.JTextArea reportToAddReports;
    private javax.swing.JButton reportsButton;
    private javax.swing.JLabel searchMessages3;
    private javax.swing.JLabel searchMessages4;
    private javax.swing.JLabel searchMessages5;
    private javax.swing.JButton settingButton;
    private javax.swing.JPanel settingJPanelRight;
    private javax.swing.JButton subjectsButton;
    private javax.swing.JPanel subjectsjPanelRight;
    private javax.swing.JRadioButton tfRadioButton1;
    private javax.swing.JRadioButton tfRadioButton2;
    private javax.swing.JRadioButton tfRadioButton3;
    private javax.swing.JRadioButton tfRadioButton4;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton updateChosenButton1;
    private javax.swing.JButton updateChosenButton2;
    private javax.swing.JButton updateExamButton;
    private javax.swing.JPanel updateQuestion;
    private javax.swing.JButton updateQuestionButton;
    private javax.swing.JTextField usernameSetting;
    private javax.swing.JPanel viewDegreeStudent;
    private javax.swing.JPanel viewExams;
    private javax.swing.JPanel viewQuestion;
    private javax.swing.JPanel viewQuestions;
    private javax.swing.JPanel viewReports;
    private javax.swing.JPanel viewSubjects;
    // End of variables declaration//GEN-END:variables

   
    
}
