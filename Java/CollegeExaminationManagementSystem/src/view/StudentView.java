package view;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khaled-HP
 */
public class StudentView extends javax.swing.JFrame {

    private CardLayout cardLayoutPage;
    private CardLayout cardLayoutExamsPage;
    private DefaultTableModel dtmReports = new DefaultTableModel();
    private DefaultTableModel dtmSubjects = new DefaultTableModel();
    private DefaultTableModel dtmExams = new DefaultTableModel();
    private DefaultTableModel dtmDegrees = new DefaultTableModel();
    private int idExam = -1;
    
    /**
     *
     */
    public StudentView() {
        initComponents();
        // set Date Format  
        dateSetting.setDateFormatString("yyyy-MM-dd");
        // Create card Layout Page
        cardLayoutPage = (CardLayout) (jPanelRight.getLayout());
        cardLayoutExamsPage = (CardLayout) (subjectsjPanelRight.getLayout());
        // Create Reports Table
        String []  reportsColumns = {"Id","Id_Lecturer", "Name_Lecturer","Name_Exam","Report"};
        setColumn(dtmReports, jTableReports  ,reportsColumns);
        // Create Subjects Table
        String [] subjectsColumns = {"Id","Name","Details"};
        setColumn(dtmSubjects, jTableSubjects ,subjectsColumns);
        // Create Exams Table
        String [] examsColumns = {"Id","Subject Name","Name","Details"};
        setColumn(dtmExams, jTableExams ,examsColumns);
        // Create Degrees Table
        String [] degreesColumns = {"Id","Subject Name","Exam Name","Degree"};
        setColumn(dtmDegrees, jTableDegrees ,degreesColumns);
    }
    
    // set style and Column of Tables
    private void setColumn(DefaultTableModel tableModel, JTable jTable,String [] columns){
        jTable.setModel(tableModel);
        jTable.getTableHeader().setReorderingAllowed(false); // not allow re-ordering of columns
        for (String column :columns){
            tableModel.addColumn(column);
        }
    }
    
    //---

    /**
     *
     */
    public void goToHome (){
        cardLayoutPage.show(jPanelRight, "home");
    }

    /**
     *
     */
    public void goToViewSubjects (){
        cardLayoutExamsPage.show(subjectsjPanelRight, "viewSubjects");
        cardLayoutPage.show(jPanelRight, "Subjects"); 
    }

    /**
     *
     */
    public void goTosetting (){
        cardLayoutPage.show(jPanelRight, "setting");
    }

    /**
     *
     */
    public void goToViewReports (){
        cardLayoutPage.show(jPanelRight, "Reports");
    }

    /**
     *
     */
    public void goToViewDegrees (){
        cardLayoutPage.show(jPanelRight, "Degrees");
    }

    /**
     *
     */
    public void goToViewExams (){
        cardLayoutExamsPage.show(subjectsjPanelRight, "viewExams");
        cardLayoutPage.show(jPanelRight, "Subjects"); 
    }

    /**
     *
     */
    public void goToViewQuestion (){
        cardLayoutExamsPage.show(subjectsjPanelRight, "doIT");
        cardLayoutPage.show(jPanelRight, "Subjects"); 
    }
    //---

    /**
     *
     * @param fullName
     */
    public void setFullNameStudent (String fullName){
        fullNameJLabel1.setText("Hi, "+ fullName);
    }

    /**
     *
     * @param name
     */
    public void setFullName (String name){
        nameSetting.setText(name);
    }

    /**
     *
     * @param username
     */
    public void setUsername (String username){
        usernameSetting.setText(username);
    }

    /**
     *
     * @param email
     */
    public void setEmail (String email){
        emailSetting.setText(email);
    }
    //-----------------------------------------------

    /**
     *
     * @return
     */
    public String getUsernameSetting (){     
        return usernameSetting.getText();       
    }

    /**
     *
     * @return
     */
    public String getPasswordSetting (){
        return passwordSetting.getText();       
    }

    /**
     *
     * @return
     */
    public String getNameSetting (){     
        return nameSetting.getText();       
    }

    /**
     *
     * @return
     */
    public String getEmailSetting (){     
        return emailSetting.getText();       
    }

    /**
     *
     * @return
     */
    public String getBirthdaySetting (){
        try{
        String birthday = (dateSetting.getDate().getYear()+1900)+"-"+ (dateSetting.getDate().getMonth()+1)+"-"+dateSetting.getDate().getDate();
        return birthday;}catch(NullPointerException ex){
            return "";
        }       
    }

    /**
     *
     * @param updateInfoOfStudentListenerButton
     */
    public void updateInfoOfStudent (ActionListener updateInfoOfStudentListenerButton) {
        updateButton.addActionListener(updateInfoOfStudentListenerButton);            
    }

    /**
     *
     * @param settingListenerButton
     */
    public void settingButton (ActionListener settingListenerButton) {                                       
        settingButton.addActionListener(settingListenerButton);
    }
    //-----------------------------------------------

    /**
     *
     * @param viewReportsListenerButton
     */
    public void viewReports (ActionListener viewReportsListenerButton) {
        reportsButton.addActionListener(viewReportsListenerButton); 
    }

    /**
     *
     * @return
     */
    public JTable getTableReports(){
        return jTableReports;
    }

    /**
     *
     * @param subjectsListenerButton
     */
    public void subjectsButton (ActionListener subjectsListenerButton) {                                       
        subjectsButton.addActionListener(subjectsListenerButton);
    }

    /**
     *
     * @return
     */
    public JTable getjTableSubjects(){
        return jTableSubjects;
    }
    //search

    /**
     *
     * @return
     */
    public String getnamesearchSubject(){
        return SearchSubject.getText();
    }

    /**
     *
     * @param searchSubjectKeyReleased
     */
    public void searchSubjects (KeyListener searchSubjectKeyReleased) {                                       
        SearchSubject.addKeyListener(searchSubjectKeyReleased);
    }
    //-------------------

    /**
     *
     * @param viewExamListenerButton
     */
    public void viewExams (ActionListener viewExamListenerButton) {                                       
        buttonExamSubjects.addActionListener(viewExamListenerButton); 
    }

    /**
     *
     * @return
     */
    public JTable getTableExams() {
        return jTableExams; 
    }

    /**
     *
     * @return
     */
    public int idSubjectInTable (){
        try{
        int numOfRow = jTableSubjects.getSelectedRow();
        int idOfSubject = Integer.parseInt((String) jTableSubjects.getModel().getValueAt(numOfRow, 0));
        return idOfSubject;
        }catch(ArrayIndexOutOfBoundsException ex){}
        return 0;
        
    }

    /**
     *
     * @return
     */
    public int idExamInTable (){
        try{
        int numOfRow = jTableExams.getSelectedRow();
        int idOfExam = Integer.parseInt((String) jTableExams.getModel().getValueAt(numOfRow, 0));
        idExam = idOfExam;
        return idOfExam;
        }catch(ArrayIndexOutOfBoundsException ex){}
        return idExam;       
    }

    /**
     *
     * @param doExamListenerButton
     */
    public void doIT (ActionListener doExamListenerButton) {                                       
        buttonDOExam.addActionListener(doExamListenerButton); 
    }

    /**
     *
     * @param strNumOfQuestion
     */
    public void setNumOfQuestion (String strNumOfQuestion){
        numOfQuestion.setText(strNumOfQuestion);
    }

    /**
     *
     * @param strQuestion
     */
    public void setQuestion (String strQuestion){
        jTextAreaViewQuestion.setText(strQuestion);
    }

    /**
     *
     * @param answerOfQuestion
     */
    public void setAnswerOfQuestion (String answerOfQuestion){
        jTextAreaViewAnswer.setText(answerOfQuestion);
    }

    /**
     *
     * @param enabled
     */
    public void EnabledSubmitButton (Boolean enabled) {                                       
        submitButton.setEnabled(enabled);
    }

    /**
     *
     * @param submitListenerButton
     */
    public void submitButton (ActionListener submitListenerButton) {                                       
        submitButton.addActionListener(submitListenerButton); 
    }

    /**
     *
     * @param enabled
     */
    public void EnabledDoneButton (Boolean enabled) {                                       
        doneButton.setEnabled(enabled);
    }

    /**
     *
     * @param doneListenerButton
     */
    public void doneButton (ActionListener doneListenerButton) {                                       
        doneButton.addActionListener(doneListenerButton); 
    }

    /**
     *
     * @return
     */
    public int getAnswr (){
        if(buttonGroupTFDoIT.getSelection().equals(jRadioButtonA.getModel()))
            return 1;
        if(buttonGroupTFDoIT.getSelection().equals(jRadioButtonB.getModel()))
            return 2;
        if(buttonGroupTFDoIT.getSelection().equals(jRadioButtonC.getModel()))
            return 3;
        if(buttonGroupTFDoIT.getSelection().equals(jRadioButtonD.getModel()))
            return 4;     
        return 0;
    }
    //search

    /**
     *
     * @return
     */
    public String getNameExamSearchDegree(){
        return SearchDegree.getText();
    }

    /**
     *
     * @param searchDegreesKeyReleased
     */
    public void searchDegrees (KeyListener searchDegreesKeyReleased) {                                       
        SearchDegree.addKeyListener(searchDegreesKeyReleased);
    }
    //-------------------

    /**
     *
     * @param viewDegreesListenerButton
     */
    public void viewDegrees (ActionListener viewDegreesListenerButton) {                                       
        degreeButton.addActionListener(viewDegreesListenerButton); 
    }

    /**
     *
     * @return
     */
    public JTable getTableDegrees() {
        return jTableDegrees; 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTFDoIT = new javax.swing.ButtonGroup();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanelLeft = new javax.swing.JPanel();
        LogoImg = new javax.swing.JLabel();
        fullNameJLabel1 = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();
        subjectsButton = new javax.swing.JButton();
        settingButton = new javax.swing.JButton();
        reportsButton = new javax.swing.JButton();
        degreeButton = new javax.swing.JButton();
        jPanelRight = new javax.swing.JPanel();
        HomejPanelRight = new javax.swing.JPanel();
        LogoImg2 = new javax.swing.JLabel();
        img1 = new javax.swing.JLabel();
        addexamButton = new javax.swing.JButton();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableSubjects = new javax.swing.JTable();
        buttonExamSubjects = new javax.swing.JButton();
        viewExams = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableExams = new javax.swing.JTable();
        buttonDOExam = new javax.swing.JButton();
        goBackTo1 = new javax.swing.JButton();
        viewQuestion = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaViewAnswer = new javax.swing.JTextArea();
        jRadioButtonD = new javax.swing.JRadioButton();
        jRadioButtonA = new javax.swing.JRadioButton();
        jRadioButtonB = new javax.swing.JRadioButton();
        jRadioButtonC = new javax.swing.JRadioButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaViewQuestion = new javax.swing.JTextArea();
        doneButton = new javax.swing.JButton();
        numOfQuestion = new javax.swing.JLabel();
        viewReports = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableReports = new javax.swing.JTable();
        viewDegree = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        searchMessages4 = new javax.swing.JLabel();
        SearchDegree = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableDegrees = new javax.swing.JTable();

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

        degreeButton.setBackground(new java.awt.Color(15, 25, 38));
        degreeButton.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        degreeButton.setForeground(new java.awt.Color(255, 255, 255));
        degreeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_flying_mortarboard_16px.png"))); // NOI18N
        degreeButton.setText("Degrees");
        degreeButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanelLeftLayout = new javax.swing.GroupLayout(jPanelLeft);
        jPanelLeft.setLayout(jPanelLeftLayout);
        jPanelLeftLayout.setHorizontalGroup(
            jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogoImg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, Short.MAX_VALUE)
            .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(subjectsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(reportsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fullNameJLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(degreeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(settingButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(degreeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(settingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(330, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanelLeft);

        jPanelRight.setPreferredSize(new java.awt.Dimension(1005, 750));
        jPanelRight.setLayout(new java.awt.CardLayout());

        HomejPanelRight.setPreferredSize(new java.awt.Dimension(1005, 720));

        LogoImg2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogoImg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Logo.png"))); // NOI18N

        img1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        img1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/LearningApp.png"))); // NOI18N

        addexamButton.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        addexamButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_add_32px.png"))); // NOI18N
        addexamButton.setText("Add Exam");

        javax.swing.GroupLayout HomejPanelRightLayout = new javax.swing.GroupLayout(HomejPanelRight);
        HomejPanelRight.setLayout(HomejPanelRightLayout);
        HomejPanelRightLayout.setHorizontalGroup(
            HomejPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomejPanelRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HomejPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LogoImg2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(HomejPanelRightLayout.createSequentialGroup()
                        .addGap(375, 375, 375)
                        .addComponent(addexamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 369, Short.MAX_VALUE)))
                .addContainerGap())
        );
        HomejPanelRightLayout.setVerticalGroup(
            HomejPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomejPanelRightLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(img1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogoImg2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addexamButton)
                .addContainerGap(104, Short.MAX_VALUE))
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
                .addComponent(buttonExamSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(420, 420, 420))
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
                .addComponent(buttonExamSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        subjectsjPanelRight.add(viewSubjects, "viewSubjects");

        viewExams.setPreferredSize(new java.awt.Dimension(1005, 720));

        jLabel6.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel6.setText("Exams:");

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

        buttonDOExam.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonDOExam.setForeground(new java.awt.Color(255, 255, 255));
        buttonDOExam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_Done_16px.png"))); // NOI18N
        buttonDOExam.setText("Do IT");

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
                .addGap(267, 267, 267)
                .addComponent(buttonDOExam, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(viewExamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonDOExam, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goBackTo1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        subjectsjPanelRight.add(viewExams, "viewExams");

        viewQuestion.setPreferredSize(new java.awt.Dimension(1005, 720));

        jLabel7.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel7.setText("Exams:");

        submitButton.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        submitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_expand_arrow_16px_1.png"))); // NOI18N
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        jTextAreaViewAnswer.setEditable(false);
        jTextAreaViewAnswer.setColumns(20);
        jTextAreaViewAnswer.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextAreaViewAnswer.setRows(2);
        jTextAreaViewAnswer.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane2.setViewportView(jTextAreaViewAnswer);

        buttonGroupTFDoIT.add(jRadioButtonD);
        jRadioButtonD.setText("D");

        buttonGroupTFDoIT.add(jRadioButtonA);
        jRadioButtonA.setText("A");

        buttonGroupTFDoIT.add(jRadioButtonB);
        jRadioButtonB.setText("B");

        buttonGroupTFDoIT.add(jRadioButtonC);
        jRadioButtonC.setText("C");

        jTextAreaViewQuestion.setEditable(false);
        jTextAreaViewQuestion.setColumns(20);
        jTextAreaViewQuestion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextAreaViewQuestion.setRows(12);
        jTextAreaViewQuestion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane5.setViewportView(jTextAreaViewQuestion);

        doneButton.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        doneButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_Done_16px.png"))); // NOI18N
        doneButton.setText("Done");
        doneButton.setEnabled(false);
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        numOfQuestion.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        numOfQuestion.setText("1");

        javax.swing.GroupLayout viewQuestionLayout = new javax.swing.GroupLayout(viewQuestion);
        viewQuestion.setLayout(viewQuestionLayout);
        viewQuestionLayout.setHorizontalGroup(
            viewQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewQuestionLayout.createSequentialGroup()
                .addGroup(viewQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewQuestionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(viewQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane5)))
                    .addGroup(viewQuestionLayout.createSequentialGroup()
                        .addGroup(viewQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(viewQuestionLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numOfQuestion))
                            .addGroup(viewQuestionLayout.createSequentialGroup()
                                .addGap(417, 417, 417)
                                .addComponent(doneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 417, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(viewQuestionLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jRadioButtonA)
                .addGap(70, 70, 70)
                .addComponent(jRadioButtonB)
                .addGap(70, 70, 70)
                .addComponent(jRadioButtonC)
                .addGap(70, 70, 70)
                .addComponent(jRadioButtonD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        viewQuestionLayout.setVerticalGroup(
            viewQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewQuestionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(numOfQuestion))
                .addGap(2, 2, 2)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(viewQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonA)
                    .addComponent(jRadioButtonB)
                    .addComponent(jRadioButtonC)
                    .addComponent(jRadioButtonD))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(doneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        subjectsjPanelRight.add(viewQuestion, "doIT");

        jPanelRight.add(subjectsjPanelRight, "Subjects");

        viewReports.setPreferredSize(new java.awt.Dimension(1005, 720));

        jLabel11.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel11.setText("Reports:");

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

        javax.swing.GroupLayout viewReportsLayout = new javax.swing.GroupLayout(viewReports);
        viewReports.setLayout(viewReportsLayout);
        viewReportsLayout.setHorizontalGroup(
            viewReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewReportsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewReportsLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 993, Short.MAX_VALUE))
                .addContainerGap())
        );
        viewReportsLayout.setVerticalGroup(
            viewReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewReportsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanelRight.add(viewReports, "Reports");

        viewDegree.setPreferredSize(new java.awt.Dimension(1005, 720));

        jLabel8.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel8.setText("Degrees:");

        searchMessages4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchMessages4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_search_32px.png"))); // NOI18N

        SearchDegree.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N

        jLabel33.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        jLabel33.setText("name of Exam:");

        jTableDegrees.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(jTableDegrees);

        javax.swing.GroupLayout viewDegreeLayout = new javax.swing.GroupLayout(viewDegree);
        viewDegree.setLayout(viewDegreeLayout);
        viewDegreeLayout.setHorizontalGroup(
            viewDegreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewDegreeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewDegreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewDegreeLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(247, 247, 247)
                        .addComponent(searchMessages4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(viewDegreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SearchDegree, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))
                        .addGap(0, 349, Short.MAX_VALUE))
                    .addComponent(jScrollPane6))
                .addContainerGap())
        );
        viewDegreeLayout.setVerticalGroup(
            viewDegreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewDegreeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewDegreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchMessages4)
                    .addGroup(viewDegreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(viewDegreeLayout.createSequentialGroup()
                            .addComponent(jLabel33)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(SearchDegree, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel8.getAccessibleContext().setAccessibleName("Degrees");

        jPanelRight.add(viewDegree, "Degrees");

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

    private void goBackTo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackTo1ActionPerformed
        cardLayoutExamsPage.show(subjectsjPanelRight, "viewSubjects");
    }//GEN-LAST:event_goBackTo1ActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitButtonActionPerformed

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doneButtonActionPerformed

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
            java.util.logging.Logger.getLogger(StudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HomejPanelRight;
    private javax.swing.JLabel Img4;
    private javax.swing.JLabel LogoImg;
    private javax.swing.JLabel LogoImg2;
    private javax.swing.JTextField SearchDegree;
    private javax.swing.JTextField SearchSubject;
    private javax.swing.JLabel Username4;
    private javax.swing.JLabel Username5;
    private javax.swing.JLabel Username6;
    private javax.swing.JLabel Username7;
    private javax.swing.JLabel Username8;
    private javax.swing.JButton addexamButton;
    private javax.swing.JButton buttonDOExam;
    private javax.swing.JButton buttonExamSubjects;
    private javax.swing.ButtonGroup buttonGroupTFDoIT;
    private com.toedter.calendar.JDateChooser dateSetting;
    private javax.swing.JButton degreeButton;
    private javax.swing.JButton doneButton;
    private javax.swing.JTextField emailSetting;
    private javax.swing.JLabel fullNameJLabel1;
    private javax.swing.JButton goBackTo1;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel img1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanelLeft;
    private javax.swing.JPanel jPanelRight;
    private javax.swing.JRadioButton jRadioButtonA;
    private javax.swing.JRadioButton jRadioButtonB;
    private javax.swing.JRadioButton jRadioButtonC;
    private javax.swing.JRadioButton jRadioButtonD;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTableDegrees;
    private javax.swing.JTable jTableExams;
    private javax.swing.JTable jTableReports;
    private javax.swing.JTable jTableSubjects;
    private javax.swing.JTextArea jTextAreaViewAnswer;
    private javax.swing.JTextArea jTextAreaViewQuestion;
    private javax.swing.JTextField nameSetting;
    private javax.swing.JLabel numOfQuestion;
    private javax.swing.JPasswordField passwordSetting;
    private javax.swing.JButton reportsButton;
    private javax.swing.JLabel searchMessages3;
    private javax.swing.JLabel searchMessages4;
    private javax.swing.JButton settingButton;
    private javax.swing.JPanel settingJPanelRight;
    private javax.swing.JButton subjectsButton;
    private javax.swing.JPanel subjectsjPanelRight;
    private javax.swing.JButton submitButton;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField usernameSetting;
    private javax.swing.JPanel viewDegree;
    private javax.swing.JPanel viewExams;
    private javax.swing.JPanel viewQuestion;
    private javax.swing.JPanel viewReports;
    private javax.swing.JPanel viewSubjects;
    // End of variables declaration//GEN-END:variables

  
}
