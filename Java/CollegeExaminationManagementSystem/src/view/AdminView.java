/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import collegeexaminationmanagementsystem.Tools;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khaled-HP
 */
public class AdminView extends javax.swing.JFrame {

    CardLayout cardLayoutPage;
    CardLayout cardLayoutsubjectsPage;
    DefaultTableModel dtmStudents = new DefaultTableModel();
    DefaultTableModel dtmLecturers = new DefaultTableModel();
    DefaultTableModel dtmSubjects = new DefaultTableModel();
    
    public AdminView() {
        initComponents();
        // set Date Format
        dateSetting.setDateFormatString("yyyy-MM-dd");
        // Create card Layout Page
        cardLayoutPage = (CardLayout) (jPanelRight.getLayout());
        cardLayoutsubjectsPage = (CardLayout) (subjectsjPanelRight.getLayout());
        // Create students Table
        String [] studdentsColumns = {"Id","Name","Email","Birthday","Username","NumOfSubject"};
        setColumn(dtmStudents, jTableStudents ,studdentsColumns);
        // Create Lecturers Table
        String [] LecturersColumns = {"Id","Name","Email","Birthday","Username","NumOfSubject"};
        setColumn(dtmLecturers, jTableLecturer ,LecturersColumns);
        // Create Subjects Table
        String [] SubjectsColumns = {"Id","Name","Details","Lecturer Name","NumOfStudent"};
        setColumn(dtmSubjects, jTableSubjects ,SubjectsColumns);
    }
    
    // set style and Column of Tables
    private void setColumn(DefaultTableModel tableModel, JTable jTable,String [] columns){
        jTable.setModel(tableModel);
        jTable.getTableHeader().setReorderingAllowed(false); // not allow re-ordering of columns
        for (String column :columns){
            tableModel.addColumn(column);
        }
    }
    
    //---------------------------------------------
    public void setCountstudents (int totalUsers){
        jLabelStudents.setText(""+totalUsers);
    }
    public void setCountLecturers (int lecturers){
        jLabelLecturers.setText(""+lecturers);
    }
    public void setCountSubjects (int subjects){
        jLabelSubjects.setText(""+subjects);
    }
    public void setFullNameAdmin (String fullName){
        fullNameJLabel1.setText("Hi, "+ fullName);
    }
    //--------------------------------------------
    public String getNameAddUser (){
        return nameAddUser.getText();
    }
    public String getUsernameAddUser (){
        return usernameAddUser.getText();
    }
    public String getpasswordAddUser (){
        return passwordAddUser.getText();
    }
    public int getIdModuleAddUser (){
        try{
        if(idModule.getSelection().equals(jRadioStudent.getModel()))
            return 3;
        else if(idModule.getSelection().equals(jRadioLecturer .getModel()))
            return 2;
        }catch(NullPointerException ex){Tools.errmsgBox("Id-Module Empty");}        
        return -1;
    }
    public void addNewUser (ActionListener addUserListenerButton) {
        addUserButton.addActionListener(addUserListenerButton);            
    }
    public void emptyTextFieldAddUser() {
         nameAddUser.setText("");
         usernameAddUser.setText("");
         passwordAddUser.setText("123");           
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
    public void setInfoOfAdmin (ActionListener setInfoOfAdminListenerButton) {
        settingButton.addActionListener(setInfoOfAdminListenerButton);            
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
    public void updateInfoOfAdmin (ActionListener updateInfoOfAdminListenerButton) {
        updateButton.addActionListener(updateInfoOfAdminListenerButton);            
    }
    //-----------------------------------------------
    public JTable getjTableStudents(){
        return jTableStudents;
    }
    public void setStuddentsTable (ActionListener setStuddentsTableListenerButton) {
        studentsButton.addActionListener(setStuddentsTableListenerButton);            
    }    
    public int idStudentInTable (){
        try{
        int numOfRow = jTableStudents.getSelectedRow();
        int idOfStudent = Integer.parseInt((String) jTableStudents.getModel().getValueAt(numOfRow, 0));
        return idOfStudent;
        }catch(ArrayIndexOutOfBoundsException ex){
            Tools.msgBox("Select Student ^-^");
        }
        return 0;
    }
    // Delete
    public void deleteStudent (ActionListener deleteStudentListenerButton) {                                       
        buttonDeleteStudent.addActionListener(deleteStudentListenerButton);
    }
    // Upgrade
    public int getIdModuleUpgradeStudent (){
        try{
        if(idModuleUpgrade.getSelection().equals(jRadioStudent2.getModel()))
            return 3;
        else if(idModuleUpgrade.getSelection().equals(jRadioLecturer2.getModel()))
            return 2;
        }catch(NullPointerException ex){Tools.errmsgBox("Id-Module Empty");}        
        return -1;
    }
    public int getIdUpgradeStudent (){             
        return Integer.parseInt(idUserUpgrade.getText());
    }
    public void updateStudent (ActionListener updateStudentListenerButton){                                       
        buttonUpgradeStudent.addActionListener(updateStudentListenerButton);
    }
    public void searchStudent (KeyListener searchStudentKeyReleased) {                                       
        SearchStudent.addKeyListener(searchStudentKeyReleased);
    }
    public String getUsernameSearchStudent(){
        return SearchStudent.getText();
    }
    //-----------------------------------------
    public JTable getjTableLecturer(){
        return jTableLecturer;
    }
    public void setLecturersTable (ActionListener setLecturersTableListenerButton) {
        lecturersButton.addActionListener(setLecturersTableListenerButton);            
    }    
    public int idLecturerInTable (){
        try{
        int numOfRow = jTableLecturer.getSelectedRow();
        int idOfLecturer = Integer.parseInt((String) jTableLecturer.getModel().getValueAt(numOfRow, 0));
        return idOfLecturer;
        }catch(ArrayIndexOutOfBoundsException ex){
            Tools.msgBox("Select Lecturer ^-^");
        }
        return 0;
    }
    // search
    public void searchLecturer (KeyListener searchLecturerKeyReleased) {                                       
        SearchLecturer.addKeyListener(searchLecturerKeyReleased);
    }
    public String getUsernamesearchLecturer(){
        return SearchLecturer.getText();
    }
    // Delete
    public void deleteLecturer (ActionListener deleteLecturerListenerButton) {                                       
        buttonDeleteLecturer.addActionListener(deleteLecturerListenerButton);
    }
    //---------------------------------------------------------------------
    public JTable getjTableSubjects(){
        return jTableSubjects;
    }
    public void setTableSubjects(ActionListener setTableSubjectsListenerButton) {
        subjectsButton.addActionListener(setTableSubjectsListenerButton);          
    }
    public int idSubjectInTable (){
        try{
        int numOfRow = jTableSubjects.getSelectedRow();
        int idOfSubject = Integer.parseInt((String) jTableSubjects.getModel().getValueAt(numOfRow, 0));
        return idOfSubject;
        }catch(ArrayIndexOutOfBoundsException ex){
            Tools.msgBox("Select Subject ^-^");
        }
        return 0;
    }
    public String getNameSubjectInTable (){
        try{
        int numOfRow = jTableSubjects.getSelectedRow();
        String nameSubject = (String) jTableSubjects.getModel().getValueAt(numOfRow, 1);
        return nameSubject;
        }catch(ArrayIndexOutOfBoundsException ex){
            
        }
        return "";
    }
    public String getDetailsSubjectInTable (){
        try{
        int numOfRow = jTableSubjects.getSelectedRow();
        String detailsSubject = (String) jTableSubjects.getModel().getValueAt(numOfRow, 2);
        return detailsSubject;
        }catch(ArrayIndexOutOfBoundsException ex){
            
        }
        return "";
    }
    //search
    public String getnamesearchSubject(){
        return SearchSubject.getText();
    }
    public void searchSubjects (KeyListener searchSubjectKeyReleased) {                                       
        SearchSubject.addKeyListener(searchSubjectKeyReleased);
    }
    // Delete
    public void deleteSubject (ActionListener deleteSubjectListenerButton) {                                       
        buttonDeleteSubjects.addActionListener(deleteSubjectListenerButton);
    }
    //add
    public String getNameAddSubject (){
        return nameAddSubject.getText();
    }
    public String getDetailsAddSubject (){
        return detailsAddSubject.getText();
    }
    public int getIdAddSubject (){
        try{
        return Integer.parseInt((String) idAddSubject.getText());}
        catch(NumberFormatException e){          }
        return -1;
    }
    // add
    public void addSubject (ActionListener addSubjecttListenerButton) {                                       
        addSubjectButton.addActionListener(addSubjecttListenerButton);
    }
    public void emptyTextFieldAddSubject() {
         nameAddSubject.setText("");
         detailsAddSubject.setText("");
         idAddSubject.setText("");           
    }
    public void updateSubject (ActionListener updateSubjectListenerButton){ 
        updateSubjectButton.addActionListener(updateSubjectListenerButton);
    }
    public void backToViewSubject (){ 
        cardLayoutsubjectsPage.show(subjectsjPanelRight, "viewSubject");
        cardLayoutPage.show(jPanelRight, "Subjects");
    }
    public void setNameupdateSubject (String str){
          nameUpdateSubject.setText(str);
    }
    public void setdetailsupdateSubject (String str){
         detailsUpdateSubject.setText(str);
    }
    public void setIdLucupdateSubject (String str){
         idUpdateSubject.setText(str);
    }
    public String getNameupdateSubject (){
        return  nameUpdateSubject.getText();
    }
    public String getdetailsupdateSubject (){
        return detailsUpdateSubject.getText();
    }
    public void setIdSubjectInTableToUpload (String idSubject){
        idSubjectInTableToUpload.setText(idSubject);
    }
    public String getIdSubjectInTableToUpload ( ){
        return idSubjectInTableToUpload.getText();
    }
    public int getIdModel() {     
        return Integer.parseInt(idModelUpload.getText());
    }
    public String getFileName() {      
        return fileNameUpload.getText();
    }
    public void buttonManagesSubjects (ActionListener managesSubjectsListenerButton){ 
        buttonManagesSubjects.addActionListener(managesSubjectsListenerButton);
    }
    public void uploadSubjectButton (ActionListener uploadSubjectListenerButton){ 
        uploadSubjectButton.addActionListener(uploadSubjectListenerButton);
    }
    public void goToUploadSubject (){
        cardLayoutsubjectsPage.show(subjectsjPanelRight, "AssignSubject");
        cardLayoutPage.show(jPanelRight, "Subjects");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idModule = new javax.swing.ButtonGroup();
        idModuleUpgrade = new javax.swing.ButtonGroup();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanelLeft = new javax.swing.JPanel();
        LogoImg = new javax.swing.JLabel();
        fullNameJLabel1 = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();
        studentsButton = new javax.swing.JButton();
        lecturersButton = new javax.swing.JButton();
        subjectsButton = new javax.swing.JButton();
        addNewUserButton = new javax.swing.JButton();
        settingButton = new javax.swing.JButton();
        addNewsubjectButton2 = new javax.swing.JButton();
        jPanelRight = new javax.swing.JPanel();
        HomejPanelRight = new javax.swing.JPanel();
        JPNumOfStudents = new javax.swing.JPanel();
        IconStudents = new javax.swing.JLabel();
        jLabelTStudents = new javax.swing.JLabel();
        jLabelStudents = new javax.swing.JLabel();
        JPTotalSubjects = new javax.swing.JPanel();
        IconSubjects = new javax.swing.JLabel();
        jLabelTSubjects = new javax.swing.JLabel();
        jLabelSubjects = new javax.swing.JLabel();
        JPTotalLecturers = new javax.swing.JPanel();
        IconLecturers = new javax.swing.JLabel();
        jLabelTLecturers = new javax.swing.JLabel();
        jLabelLecturers = new javax.swing.JLabel();
        LogoImg2 = new javax.swing.JLabel();
        img1 = new javax.swing.JLabel();
        addUserJPanelRight = new javax.swing.JPanel();
        Img3 = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        usernameAddUser = new javax.swing.JTextField();
        nameAddUser = new javax.swing.JTextField();
        name = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        idModule2 = new javax.swing.JLabel();
        addUserButton = new javax.swing.JButton();
        passwordAddUser = new javax.swing.JPasswordField();
        jRadioStudent = new javax.swing.JRadioButton();
        jRadioLecturer = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
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
        studentsjPanelRight = new javax.swing.JPanel();
        viewStudents = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        searchMessages1 = new javax.swing.JLabel();
        SearchStudent = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        buttonAddStudent = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableStudents = new javax.swing.JTable();
        buttonUpdateStudent = new javax.swing.JButton();
        buttonDeleteStudent = new javax.swing.JButton();
        buttonManagesSubjectsStu = new javax.swing.JButton();
        lecturersjPanelRight = new javax.swing.JPanel();
        viewLecturers = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        searchMessages2 = new javax.swing.JLabel();
        SearchLecturer = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        buttonAddLecturer = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableLecturer = new javax.swing.JTable();
        buttonUpdateLecturer = new javax.swing.JButton();
        buttonDeleteLecturer = new javax.swing.JButton();
        buttonManagesSubjectsLuc = new javax.swing.JButton();
        updateUser = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jRadioLecturer2 = new javax.swing.JRadioButton();
        jRadioStudent2 = new javax.swing.JRadioButton();
        idModule3 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        idUserUpgrade = new javax.swing.JTextField();
        buttonUpgradeStudent = new javax.swing.JButton();
        Img5 = new javax.swing.JLabel();
        subjectsjPanelRight = new javax.swing.JPanel();
        viewSubjects = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        searchMessages3 = new javax.swing.JLabel();
        SearchSubject = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        buttonAddSubjects = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableSubjects = new javax.swing.JTable();
        buttonUpdateSubjects = new javax.swing.JButton();
        buttonDeleteSubjects = new javax.swing.JButton();
        buttonManagesSubjects = new javax.swing.JButton();
        addUserJPanelRight2 = new javax.swing.JPanel();
        Img7 = new javax.swing.JLabel();
        Username3 = new javax.swing.JLabel();
        nameUpdateSubject = new javax.swing.JTextField();
        updateSubjectButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        idUpdateSubject = new javax.swing.JTextField();
        name3 = new javax.swing.JLabel();
        Username9 = new javax.swing.JLabel();
        detailsUpdateSubject = new javax.swing.JTextField();
        AssignSubjectrJPanelRight = new javax.swing.JPanel();
        Img8 = new javax.swing.JLabel();
        Username10 = new javax.swing.JLabel();
        fileNameUpload = new javax.swing.JTextField();
        uploadSubjectButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        Username11 = new javax.swing.JLabel();
        idSubjectInTableToUpload = new javax.swing.JLabel();
        idModelUpload = new javax.swing.JTextField();
        addSubjectJPanelRight = new javax.swing.JPanel();
        Img6 = new javax.swing.JLabel();
        Username1 = new javax.swing.JLabel();
        nameAddSubject = new javax.swing.JTextField();
        addSubjectButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        idAddSubject = new javax.swing.JTextField();
        name2 = new javax.swing.JLabel();
        Username2 = new javax.swing.JLabel();
        detailsAddSubject = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jSplitPane1.setDividerLocation(275);
        jSplitPane1.setDividerSize(0);
        jSplitPane1.setEnabled(false);
        jSplitPane1.setPreferredSize(new java.awt.Dimension(1280, 750));

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
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        studentsButton.setBackground(new java.awt.Color(15, 25, 38));
        studentsButton.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        studentsButton.setForeground(new java.awt.Color(255, 255, 255));
        studentsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_student_center_16px.png"))); // NOI18N
        studentsButton.setText("Students");
        studentsButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        studentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentsButtonActionPerformed(evt);
            }
        });

        lecturersButton.setBackground(new java.awt.Color(15, 25, 38));
        lecturersButton.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        lecturersButton.setForeground(new java.awt.Color(255, 255, 255));
        lecturersButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_teaching_16px.png"))); // NOI18N
        lecturersButton.setText("Lecturers");
        lecturersButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lecturersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturersButtonActionPerformed(evt);
            }
        });

        subjectsButton.setBackground(new java.awt.Color(15, 25, 38));
        subjectsButton.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        subjectsButton.setForeground(new java.awt.Color(255, 255, 255));
        subjectsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_Books_16px.png"))); // NOI18N
        subjectsButton.setText("Subjects ");
        subjectsButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        subjectsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectsButtonActionPerformed(evt);
            }
        });

        addNewUserButton.setBackground(new java.awt.Color(15, 25, 38));
        addNewUserButton.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        addNewUserButton.setForeground(new java.awt.Color(255, 255, 255));
        addNewUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_add_32px.png"))); // NOI18N
        addNewUserButton.setText("Add New User");
        addNewUserButton.setToolTipText("");
        addNewUserButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        addNewUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewUserButtonActionPerformed(evt);
            }
        });

        settingButton.setBackground(new java.awt.Color(15, 25, 38));
        settingButton.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        settingButton.setForeground(new java.awt.Color(255, 255, 255));
        settingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_settings_16px.png"))); // NOI18N
        settingButton.setText("Setting");
        settingButton.setToolTipText("");
        settingButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        settingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingButtonActionPerformed(evt);
            }
        });

        addNewsubjectButton2.setBackground(new java.awt.Color(15, 25, 38));
        addNewsubjectButton2.setFont(new java.awt.Font("Roboto Slab", 0, 12)); // NOI18N
        addNewsubjectButton2.setForeground(new java.awt.Color(255, 255, 255));
        addNewsubjectButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_add_32px.png"))); // NOI18N
        addNewsubjectButton2.setText("Add New Subject");
        addNewsubjectButton2.setToolTipText("");
        addNewsubjectButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        addNewsubjectButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewsubjectButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLeftLayout = new javax.swing.GroupLayout(jPanelLeft);
        jPanelLeft.setLayout(jPanelLeftLayout);
        jPanelLeftLayout.setHorizontalGroup(
            jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogoImg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, Short.MAX_VALUE)
            .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(studentsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fullNameJLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lecturersButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(subjectsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addNewUserButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(settingButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addNewsubjectButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(studentsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lecturersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subjectsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(settingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                .addComponent(addNewsubjectButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addNewUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jSplitPane1.setLeftComponent(jPanelLeft);

        jPanelRight.setPreferredSize(new java.awt.Dimension(1005, 750));
        jPanelRight.setLayout(new java.awt.CardLayout());

        HomejPanelRight.setPreferredSize(new java.awt.Dimension(1005, 720));

        JPNumOfStudents.setPreferredSize(new java.awt.Dimension(200, 200));

        IconStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_student_center_64px.png"))); // NOI18N

        jLabelTStudents.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTStudents.setText("Students");

        jLabelStudents.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabelStudents.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStudents.setText("15,555");

        javax.swing.GroupLayout JPNumOfStudentsLayout = new javax.swing.GroupLayout(JPNumOfStudents);
        JPNumOfStudents.setLayout(JPNumOfStudentsLayout);
        JPNumOfStudentsLayout.setHorizontalGroup(
            JPNumOfStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNumOfStudentsLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(IconStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabelTStudents)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabelStudents, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JPNumOfStudentsLayout.setVerticalGroup(
            JPNumOfStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNumOfStudentsLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(JPNumOfStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTStudents, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(IconStudents, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelStudents)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPTotalSubjects.setPreferredSize(new java.awt.Dimension(200, 200));

        IconSubjects.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_Books_64px.png"))); // NOI18N

        jLabelTSubjects.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTSubjects.setText("Subjects");

        jLabelSubjects.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabelSubjects.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSubjects.setText("1,555");
        jLabelSubjects.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabelSubjects.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelSubjects.setOpaque(true);
        jLabelSubjects.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout JPTotalSubjectsLayout = new javax.swing.GroupLayout(JPTotalSubjects);
        JPTotalSubjects.setLayout(JPTotalSubjectsLayout);
        JPTotalSubjectsLayout.setHorizontalGroup(
            JPTotalSubjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPTotalSubjectsLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(IconSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTSubjects)
                .addContainerGap())
            .addComponent(jLabelSubjects, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        JPTotalSubjectsLayout.setVerticalGroup(
            JPTotalSubjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPTotalSubjectsLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(JPTotalSubjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTSubjects, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(IconSubjects, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSubjects)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPTotalLecturers.setPreferredSize(new java.awt.Dimension(200, 200));

        IconLecturers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_teacher_64px.png"))); // NOI18N

        jLabelTLecturers.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTLecturers.setText("lecturers");

        jLabelLecturers.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabelLecturers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLecturers.setText("155,555");

        javax.swing.GroupLayout JPTotalLecturersLayout = new javax.swing.GroupLayout(JPTotalLecturers);
        JPTotalLecturers.setLayout(JPTotalLecturersLayout);
        JPTotalLecturersLayout.setHorizontalGroup(
            JPTotalLecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPTotalLecturersLayout.createSequentialGroup()
                .addGroup(JPTotalLecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPTotalLecturersLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(IconLecturers, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTLecturers))
                    .addComponent(jLabelLecturers, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                .addContainerGap())
        );
        JPTotalLecturersLayout.setVerticalGroup(
            JPTotalLecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPTotalLecturersLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(JPTotalLecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTLecturers, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(IconLecturers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLecturers))
        );

        LogoImg2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogoImg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Logo.png"))); // NOI18N

        img1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        img1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Learning-App.png"))); // NOI18N

        javax.swing.GroupLayout HomejPanelRightLayout = new javax.swing.GroupLayout(HomejPanelRight);
        HomejPanelRight.setLayout(HomejPanelRightLayout);
        HomejPanelRightLayout.setHorizontalGroup(
            HomejPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomejPanelRightLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(HomejPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HomejPanelRightLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(LogoImg2, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(img1, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(HomejPanelRightLayout.createSequentialGroup()
                        .addComponent(JPNumOfStudents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(JPTotalSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(JPTotalLecturers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        HomejPanelRightLayout.setVerticalGroup(
            HomejPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomejPanelRightLayout.createSequentialGroup()
                .addGroup(HomejPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HomejPanelRightLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(HomejPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JPTotalSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JPNumOfStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(JPTotalLecturers, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(img1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogoImg2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        jPanelRight.add(HomejPanelRight, "home");

        addUserJPanelRight.setPreferredSize(new java.awt.Dimension(1005, 720));

        Img3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/addUser.png"))); // NOI18N

        Username.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username.setText("UserName:");

        name.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        name.setText("Name:");

        password.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        password.setText("Password:");

        idModule2.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        idModule2.setText("Id-Module:");

        addUserButton.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        addUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_add_32px.png"))); // NOI18N
        addUserButton.setText("Add");

        passwordAddUser.setText("123");

        idModule.add(jRadioStudent);
        jRadioStudent.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        jRadioStudent.setText("Students");

        idModule.add(jRadioLecturer);
        jRadioLecturer.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        jRadioLecturer.setText("Lecturer");

        jLabel1.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel1.setText("Add User:");

        javax.swing.GroupLayout addUserJPanelRightLayout = new javax.swing.GroupLayout(addUserJPanelRight);
        addUserJPanelRight.setLayout(addUserJPanelRightLayout);
        addUserJPanelRightLayout.setHorizontalGroup(
            addUserJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addUserJPanelRightLayout.createSequentialGroup()
                .addGroup(addUserJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(addUserJPanelRightLayout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addGroup(addUserJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addUserJPanelRightLayout.createSequentialGroup()
                                .addGroup(addUserJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(addUserJPanelRightLayout.createSequentialGroup()
                                        .addComponent(name)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nameAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(addUserJPanelRightLayout.createSequentialGroup()
                                        .addComponent(Username)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(usernameAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(addUserJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addUserJPanelRightLayout.createSequentialGroup()
                                        .addComponent(idModule2)
                                        .addGap(28, 28, 28)
                                        .addComponent(jRadioStudent)
                                        .addGap(52, 52, 52)
                                        .addComponent(jRadioLecturer))
                                    .addGroup(addUserJPanelRightLayout.createSequentialGroup()
                                        .addComponent(password)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(passwordAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(addUserJPanelRightLayout.createSequentialGroup()
                                .addGap(279, 279, 279)
                                .addComponent(addUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(addUserJPanelRightLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Img3)))
                .addContainerGap(203, Short.MAX_VALUE))
        );
        addUserJPanelRightLayout.setVerticalGroup(
            addUserJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addUserJPanelRightLayout.createSequentialGroup()
                .addGroup(addUserJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addUserJPanelRightLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(Img3))
                    .addGroup(addUserJPanelRightLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(addUserJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addUserJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(usernameAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Username)
                        .addComponent(password)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addUserJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name)
                    .addComponent(nameAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idModule2)
                    .addComponent(jRadioStudent)
                    .addComponent(jRadioLecturer))
                .addGap(18, 18, 18)
                .addComponent(addUserButton)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jPanelRight.add(addUserJPanelRight, "addUser");

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

        studentsjPanelRight.setPreferredSize(new java.awt.Dimension(1005, 720));

        viewStudents.setPreferredSize(new java.awt.Dimension(1005, 720));

        jLabel3.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel3.setText("Students:");

        searchMessages1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchMessages1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_search_32px.png"))); // NOI18N

        SearchStudent.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        jLabel30.setText("USERNAME:");

        buttonAddStudent.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonAddStudent.setForeground(new java.awt.Color(255, 255, 255));
        buttonAddStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_Add_16px.png"))); // NOI18N
        buttonAddStudent.setText("Add");
        buttonAddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddStudent(evt);
            }
        });

        jTableStudents.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableStudents);

        buttonUpdateStudent.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonUpdateStudent.setForeground(new java.awt.Color(255, 255, 255));
        buttonUpdateStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_update_user_16px.png"))); // NOI18N
        buttonUpdateStudent.setText("Update");
        buttonUpdateStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upgradeStudentButton(evt);
            }
        });

        buttonDeleteStudent.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonDeleteStudent.setForeground(new java.awt.Color(255, 255, 255));
        buttonDeleteStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_delete_16px.png"))); // NOI18N
        buttonDeleteStudent.setText("Delete");

        buttonManagesSubjectsStu.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonManagesSubjectsStu.setForeground(new java.awt.Color(255, 255, 255));
        buttonManagesSubjectsStu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_management_16px_1.png"))); // NOI18N
        buttonManagesSubjectsStu.setText("Manages ");

        javax.swing.GroupLayout viewStudentsLayout = new javax.swing.GroupLayout(viewStudents);
        viewStudents.setLayout(viewStudentsLayout);
        viewStudentsLayout.setHorizontalGroup(
            viewStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewStudentsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewStudentsLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(247, 247, 247)
                        .addComponent(searchMessages1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(viewStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SearchStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(viewStudentsLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(buttonAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonUpdateStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDeleteStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonManagesSubjectsStu, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );
        viewStudentsLayout.setVerticalGroup(
            viewStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewStudentsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchMessages1)
                    .addGroup(viewStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(viewStudentsLayout.createSequentialGroup()
                            .addComponent(jLabel30)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(SearchStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(viewStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDeleteStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUpdateStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonManagesSubjectsStu, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout studentsjPanelRightLayout = new javax.swing.GroupLayout(studentsjPanelRight);
        studentsjPanelRight.setLayout(studentsjPanelRightLayout);
        studentsjPanelRightLayout.setHorizontalGroup(
            studentsjPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewStudents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        studentsjPanelRightLayout.setVerticalGroup(
            studentsjPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanelRight.add(studentsjPanelRight, "students");

        viewLecturers.setPreferredSize(new java.awt.Dimension(1005, 720));

        jLabel55.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel55.setText("Lecturers:");

        searchMessages2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchMessages2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_search_32px.png"))); // NOI18N

        SearchLecturer.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        jLabel31.setText("USERNAME:");

        buttonAddLecturer.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonAddLecturer.setForeground(new java.awt.Color(255, 255, 255));
        buttonAddLecturer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_Add_16px.png"))); // NOI18N
        buttonAddLecturer.setText("Add");
        buttonAddLecturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddLecturer(evt);
            }
        });

        jTableLecturer.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableLecturer);

        buttonUpdateLecturer.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonUpdateLecturer.setForeground(new java.awt.Color(255, 255, 255));
        buttonUpdateLecturer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_update_user_16px.png"))); // NOI18N
        buttonUpdateLecturer.setText("Update");
        buttonUpdateLecturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upgradeLecturerButton(evt);
            }
        });

        buttonDeleteLecturer.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonDeleteLecturer.setForeground(new java.awt.Color(255, 255, 255));
        buttonDeleteLecturer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_delete_16px.png"))); // NOI18N
        buttonDeleteLecturer.setText("Delete");

        buttonManagesSubjectsLuc.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonManagesSubjectsLuc.setForeground(new java.awt.Color(255, 255, 255));
        buttonManagesSubjectsLuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_management_16px_1.png"))); // NOI18N
        buttonManagesSubjectsLuc.setText("Manages ");

        javax.swing.GroupLayout viewLecturersLayout = new javax.swing.GroupLayout(viewLecturers);
        viewLecturers.setLayout(viewLecturersLayout);
        viewLecturersLayout.setHorizontalGroup(
            viewLecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewLecturersLayout.createSequentialGroup()
                .addGroup(viewLecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewLecturersLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(viewLecturersLayout.createSequentialGroup()
                        .addGroup(viewLecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(viewLecturersLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel55)
                                .addGap(240, 240, 240)
                                .addComponent(searchMessages2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(viewLecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SearchLecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31)))
                            .addGroup(viewLecturersLayout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(buttonAddLecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonUpdateLecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonDeleteLecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonManagesSubjectsLuc, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 163, Short.MAX_VALUE)))
                .addContainerGap())
        );
        viewLecturersLayout.setVerticalGroup(
            viewLecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewLecturersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewLecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewLecturersLayout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(5, 5, 5)
                        .addGroup(viewLecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchMessages2)
                            .addComponent(SearchLecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel55))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                .addGap(19, 19, 19)
                .addGroup(viewLecturersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAddLecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDeleteLecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUpdateLecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonManagesSubjectsLuc, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout lecturersjPanelRightLayout = new javax.swing.GroupLayout(lecturersjPanelRight);
        lecturersjPanelRight.setLayout(lecturersjPanelRightLayout);
        lecturersjPanelRightLayout.setHorizontalGroup(
            lecturersjPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewLecturers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        lecturersjPanelRightLayout.setVerticalGroup(
            lecturersjPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewLecturers, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanelRight.add(lecturersjPanelRight, "lecturers");

        updateUser.setPreferredSize(new java.awt.Dimension(1005, 720));

        jLabel4.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel4.setText("Upgrade User:");

        idModuleUpgrade.add(jRadioLecturer2);
        jRadioLecturer2.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        jRadioLecturer2.setText("Lecturer");

        idModuleUpgrade.add(jRadioStudent2);
        jRadioStudent2.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        jRadioStudent2.setText("Students");

        idModule3.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        idModule3.setText("Id-Module:");

        id.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        id.setText("Id:");

        idUserUpgrade.setEditable(false);

        buttonUpgradeStudent.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        buttonUpgradeStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_buy_upgrade_32px_1.png"))); // NOI18N
        buttonUpgradeStudent.setText("Upgrade");
        buttonUpgradeStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpgradeStudentActionPerformed(evt);
            }
        });

        Img5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/updateStudent.png"))); // NOI18N

        javax.swing.GroupLayout updateUserLayout = new javax.swing.GroupLayout(updateUser);
        updateUser.setLayout(updateUserLayout);
        updateUserLayout.setHorizontalGroup(
            updateUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateUserLayout.createSequentialGroup()
                .addGroup(updateUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateUserLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(id)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idUserUpgrade, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idModule3)
                        .addGap(28, 28, 28)
                        .addComponent(jRadioStudent2)
                        .addGap(52, 52, 52)
                        .addComponent(jRadioLecturer2)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateUserLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Img5)))
                .addContainerGap(224, Short.MAX_VALUE))
            .addGroup(updateUserLayout.createSequentialGroup()
                .addGap(422, 422, 422)
                .addComponent(buttonUpgradeStudent)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        updateUserLayout.setVerticalGroup(
            updateUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(updateUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateUserLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(Img5))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(updateUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idUserUpgrade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id)
                    .addComponent(idModule3)
                    .addComponent(jRadioStudent2)
                    .addComponent(jRadioLecturer2))
                .addGap(18, 18, 18)
                .addComponent(buttonUpgradeStudent)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        jPanelRight.add(updateUser, "updateUsers");

        subjectsjPanelRight.setPreferredSize(new java.awt.Dimension(1005, 720));
        subjectsjPanelRight.setLayout(new java.awt.CardLayout());

        viewSubjects.setPreferredSize(new java.awt.Dimension(1005, 720));

        jLabel5.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel5.setText("Subjects:");

        searchMessages3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchMessages3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_search_32px.png"))); // NOI18N

        SearchSubject.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N

        jLabel32.setFont(new java.awt.Font("Roboto Slab", 1, 14)); // NOI18N
        jLabel32.setText("name:");

        buttonAddSubjects.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonAddSubjects.setForeground(new java.awt.Color(255, 255, 255));
        buttonAddSubjects.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_Add_16px.png"))); // NOI18N
        buttonAddSubjects.setText("Add");
        buttonAddSubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddSubjectsActionPerformed(evt);
            }
        });

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

        buttonUpdateSubjects.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonUpdateSubjects.setForeground(new java.awt.Color(255, 255, 255));
        buttonUpdateSubjects.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_update_user_16px.png"))); // NOI18N
        buttonUpdateSubjects.setText("Update");
        buttonUpdateSubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateSubjectsActionPerformed(evt);
            }
        });

        buttonDeleteSubjects.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonDeleteSubjects.setForeground(new java.awt.Color(255, 255, 255));
        buttonDeleteSubjects.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_delete_16px.png"))); // NOI18N
        buttonDeleteSubjects.setText("Delete");

        buttonManagesSubjects.setFont(new java.awt.Font("Roboto Slab Medium", 0, 14)); // NOI18N
        buttonManagesSubjects.setForeground(new java.awt.Color(255, 255, 255));
        buttonManagesSubjects.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_management_16px_1.png"))); // NOI18N
        buttonManagesSubjects.setText("Manages ");

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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
            .addGroup(viewSubjectsLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(buttonAddSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonUpdateSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDeleteSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonManagesSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(buttonAddSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDeleteSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUpdateSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonManagesSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        subjectsjPanelRight.add(viewSubjects, "viewSubject");

        addUserJPanelRight2.setPreferredSize(new java.awt.Dimension(1005, 720));

        Img7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/updateSubject.png"))); // NOI18N

        Username3.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username3.setText("Name:");

        updateSubjectButton.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        updateSubjectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_buy_upgrade_32px_1.png"))); // NOI18N
        updateSubjectButton.setText("Update");

        jLabel7.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel7.setText("Update Subject:");

        idUpdateSubject.setEditable(false);

        name3.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        name3.setText("ID:");

        Username9.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username9.setText("Details:");

        javax.swing.GroupLayout addUserJPanelRight2Layout = new javax.swing.GroupLayout(addUserJPanelRight2);
        addUserJPanelRight2.setLayout(addUserJPanelRight2Layout);
        addUserJPanelRight2Layout.setHorizontalGroup(
            addUserJPanelRight2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addUserJPanelRight2Layout.createSequentialGroup()
                .addGroup(addUserJPanelRight2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addUserJPanelRight2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(0, 0, 0)
                        .addComponent(Img7))
                    .addGroup(addUserJPanelRight2Layout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addComponent(name3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idUpdateSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addUserJPanelRight2Layout.createSequentialGroup()
                .addContainerGap(168, Short.MAX_VALUE)
                .addGroup(addUserJPanelRight2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addUserJPanelRight2Layout.createSequentialGroup()
                        .addComponent(Username3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameUpdateSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(Username9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(detailsUpdateSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(213, 213, 213))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addUserJPanelRight2Layout.createSequentialGroup()
                        .addComponent(updateSubjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(436, 436, 436))))
        );
        addUserJPanelRight2Layout.setVerticalGroup(
            addUserJPanelRight2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addUserJPanelRight2Layout.createSequentialGroup()
                .addGroup(addUserJPanelRight2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addUserJPanelRight2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(Img7))
                    .addGroup(addUserJPanelRight2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addGroup(addUserJPanelRight2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addUserJPanelRight2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nameUpdateSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Username3))
                    .addGroup(addUserJPanelRight2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(detailsUpdateSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Username9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addUserJPanelRight2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name3)
                    .addComponent(idUpdateSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(updateSubjectButton)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        subjectsjPanelRight.add(addUserJPanelRight2, "updateSubject");

        AssignSubjectrJPanelRight.setPreferredSize(new java.awt.Dimension(1005, 720));

        Img8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/updateSubject.png"))); // NOI18N

        Username10.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username10.setText("File Name:");

        uploadSubjectButton.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        uploadSubjectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_buy_upgrade_32px_1.png"))); // NOI18N
        uploadSubjectButton.setText("Upload");

        jLabel8.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel8.setText("Subject:");

        Username11.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username11.setText("Id_Model");

        idSubjectInTableToUpload.setText("jLabel9");

        javax.swing.GroupLayout AssignSubjectrJPanelRightLayout = new javax.swing.GroupLayout(AssignSubjectrJPanelRight);
        AssignSubjectrJPanelRight.setLayout(AssignSubjectrJPanelRightLayout);
        AssignSubjectrJPanelRightLayout.setHorizontalGroup(
            AssignSubjectrJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AssignSubjectrJPanelRightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(90, 90, 90)
                .addComponent(Img8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AssignSubjectrJPanelRightLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(idSubjectInTableToUpload)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(AssignSubjectrJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AssignSubjectrJPanelRightLayout.createSequentialGroup()
                        .addComponent(Username11)
                        .addGap(18, 18, 18)
                        .addComponent(idModelUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AssignSubjectrJPanelRightLayout.createSequentialGroup()
                        .addComponent(Username10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fileNameUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59)
                .addComponent(uploadSubjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(297, 297, 297))
        );
        AssignSubjectrJPanelRightLayout.setVerticalGroup(
            AssignSubjectrJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AssignSubjectrJPanelRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AssignSubjectrJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AssignSubjectrJPanelRightLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(506, 506, 506))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AssignSubjectrJPanelRightLayout.createSequentialGroup()
                        .addComponent(Img8)
                        .addGap(18, 18, 18)))
                .addGroup(AssignSubjectrJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AssignSubjectrJPanelRightLayout.createSequentialGroup()
                        .addGroup(AssignSubjectrJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AssignSubjectrJPanelRightLayout.createSequentialGroup()
                                .addGroup(AssignSubjectrJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fileNameUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Username10))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AssignSubjectrJPanelRightLayout.createSequentialGroup()
                                .addComponent(idSubjectInTableToUpload)
                                .addGap(4, 4, 4)))
                        .addGroup(AssignSubjectrJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Username11)
                            .addComponent(idModelUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(AssignSubjectrJPanelRightLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(uploadSubjectButton)))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        subjectsjPanelRight.add(AssignSubjectrJPanelRight, "AssignSubject");

        jPanelRight.add(subjectsjPanelRight, "Subjects");

        addSubjectJPanelRight.setPreferredSize(new java.awt.Dimension(1005, 720));

        Img6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/addNewsubject.png"))); // NOI18N

        Username1.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username1.setText("Name:");

        addSubjectButton.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        addSubjectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8_add_32px.png"))); // NOI18N
        addSubjectButton.setText("Add");

        jLabel6.setFont(new java.awt.Font("Roboto Slab Medium", 1, 24)); // NOI18N
        jLabel6.setText("Add Subject:");

        name2.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        name2.setText("Id-Lecturer");

        Username2.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        Username2.setText("Details:");

        javax.swing.GroupLayout addSubjectJPanelRightLayout = new javax.swing.GroupLayout(addSubjectJPanelRight);
        addSubjectJPanelRight.setLayout(addSubjectJPanelRightLayout);
        addSubjectJPanelRightLayout.setHorizontalGroup(
            addSubjectJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addSubjectJPanelRightLayout.createSequentialGroup()
                .addGroup(addSubjectJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addSubjectJPanelRightLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(26, 26, 26)
                        .addComponent(Img6))
                    .addGroup(addSubjectJPanelRightLayout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(name2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idAddSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addSubjectJPanelRightLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addSubjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(436, 436, 436))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addSubjectJPanelRightLayout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(Username1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameAddSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(Username2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(detailsAddSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(213, 213, 213))
        );
        addSubjectJPanelRightLayout.setVerticalGroup(
            addSubjectJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addSubjectJPanelRightLayout.createSequentialGroup()
                .addGroup(addSubjectJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addSubjectJPanelRightLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(Img6))
                    .addGroup(addSubjectJPanelRightLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addGroup(addSubjectJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addSubjectJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nameAddSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Username1))
                    .addGroup(addSubjectJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(detailsAddSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Username2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addSubjectJPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name2)
                    .addComponent(idAddSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addSubjectButton)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jPanelRight.add(addSubjectJPanelRight, "addNewsubject");

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

    private void addNewUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewUserButtonActionPerformed
        cardLayoutPage.show(jPanelRight, "addUser");
    }//GEN-LAST:event_addNewUserButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        cardLayoutPage.show(jPanelRight, "home");
    }//GEN-LAST:event_homeButtonActionPerformed

    private void settingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingButtonActionPerformed
        cardLayoutPage.show(jPanelRight, "setting");
    }//GEN-LAST:event_settingButtonActionPerformed

    private void studentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentsButtonActionPerformed
        cardLayoutPage.show(jPanelRight, "students");
    }//GEN-LAST:event_studentsButtonActionPerformed

    private void AddStudent(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddStudent
        cardLayoutPage.show(jPanelRight, "addUser");
        emptyTextFieldAddUser();
    }//GEN-LAST:event_AddStudent

    private void upgradeStudentButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upgradeStudentButton
        if(idStudentInTable() != 0){
        cardLayoutPage.show(jPanelRight, "updateUsers");
        idUserUpgrade.setText(idStudentInTable()+"");
        }
    }//GEN-LAST:event_upgradeStudentButton

    private void buttonUpgradeStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpgradeStudentActionPerformed
        cardLayoutPage.show(jPanelRight, "home");
    }//GEN-LAST:event_buttonUpgradeStudentActionPerformed

    private void buttonAddLecturer(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddLecturer
        cardLayoutPage.show(jPanelRight, "addUser");
        emptyTextFieldAddUser();
    }//GEN-LAST:event_buttonAddLecturer

    private void lecturersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturersButtonActionPerformed
        cardLayoutPage.show(jPanelRight, "lecturers");
    }//GEN-LAST:event_lecturersButtonActionPerformed

    private void upgradeLecturerButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upgradeLecturerButton
        if(idLecturerInTable() != 0){
        cardLayoutPage.show(jPanelRight, "updateUsers");
        idUserUpgrade.setText(idLecturerInTable()+"");
        }
    }//GEN-LAST:event_upgradeLecturerButton

    private void subjectsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectsButtonActionPerformed
        cardLayoutsubjectsPage.show(subjectsjPanelRight, "viewSubject");
        cardLayoutPage.show(jPanelRight, "Subjects");
    }//GEN-LAST:event_subjectsButtonActionPerformed

    private void addNewsubjectButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewsubjectButton2ActionPerformed
        cardLayoutPage.show(jPanelRight, "addNewsubject");
    }//GEN-LAST:event_addNewsubjectButton2ActionPerformed

    private void buttonAddSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddSubjectsActionPerformed
        cardLayoutPage.show(jPanelRight, "addNewsubject");
    }//GEN-LAST:event_buttonAddSubjectsActionPerformed

    private void buttonUpdateSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateSubjectsActionPerformed
         if(idSubjectInTable()!= 0)
            {cardLayoutsubjectsPage.show(subjectsjPanelRight, "updateSubject");
            idUpdateSubject.setText(idSubjectInTable()+"");
            nameUpdateSubject.setText(getNameSubjectInTable()+"");
            detailsUpdateSubject.setText(getDetailsSubjectInTable()+"");
            }
    }//GEN-LAST:event_buttonUpdateSubjectsActionPerformed

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
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AssignSubjectrJPanelRight;
    private javax.swing.JPanel HomejPanelRight;
    private javax.swing.JLabel IconLecturers;
    private javax.swing.JLabel IconStudents;
    private javax.swing.JLabel IconSubjects;
    private javax.swing.JLabel Img3;
    private javax.swing.JLabel Img4;
    private javax.swing.JLabel Img5;
    private javax.swing.JLabel Img6;
    private javax.swing.JLabel Img7;
    private javax.swing.JLabel Img8;
    private javax.swing.JPanel JPNumOfStudents;
    private javax.swing.JPanel JPTotalLecturers;
    private javax.swing.JPanel JPTotalSubjects;
    private javax.swing.JLabel LogoImg;
    private javax.swing.JLabel LogoImg2;
    private javax.swing.JTextField SearchLecturer;
    private javax.swing.JTextField SearchStudent;
    private javax.swing.JTextField SearchSubject;
    private javax.swing.JLabel Username;
    private javax.swing.JLabel Username1;
    private javax.swing.JLabel Username10;
    private javax.swing.JLabel Username11;
    private javax.swing.JLabel Username2;
    private javax.swing.JLabel Username3;
    private javax.swing.JLabel Username4;
    private javax.swing.JLabel Username5;
    private javax.swing.JLabel Username6;
    private javax.swing.JLabel Username7;
    private javax.swing.JLabel Username8;
    private javax.swing.JLabel Username9;
    private javax.swing.JButton addNewUserButton;
    private javax.swing.JButton addNewsubjectButton2;
    private javax.swing.JButton addSubjectButton;
    private javax.swing.JPanel addSubjectJPanelRight;
    private javax.swing.JButton addUserButton;
    private javax.swing.JPanel addUserJPanelRight;
    private javax.swing.JPanel addUserJPanelRight2;
    private javax.swing.JButton buttonAddLecturer;
    private javax.swing.JButton buttonAddStudent;
    private javax.swing.JButton buttonAddSubjects;
    private javax.swing.JButton buttonDeleteLecturer;
    private javax.swing.JButton buttonDeleteStudent;
    private javax.swing.JButton buttonDeleteSubjects;
    private javax.swing.JButton buttonManagesSubjects;
    private javax.swing.JButton buttonManagesSubjectsLuc;
    private javax.swing.JButton buttonManagesSubjectsStu;
    private javax.swing.JButton buttonUpdateLecturer;
    private javax.swing.JButton buttonUpdateStudent;
    private javax.swing.JButton buttonUpdateSubjects;
    private javax.swing.JButton buttonUpgradeStudent;
    private com.toedter.calendar.JDateChooser dateSetting;
    private javax.swing.JTextField detailsAddSubject;
    private javax.swing.JTextField detailsUpdateSubject;
    private javax.swing.JTextField emailSetting;
    private javax.swing.JTextField fileNameUpload;
    private javax.swing.JLabel fullNameJLabel1;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel id;
    private javax.swing.JTextField idAddSubject;
    private javax.swing.JTextField idModelUpload;
    private javax.swing.ButtonGroup idModule;
    private javax.swing.JLabel idModule2;
    private javax.swing.JLabel idModule3;
    private javax.swing.ButtonGroup idModuleUpgrade;
    private javax.swing.JLabel idSubjectInTableToUpload;
    private javax.swing.JTextField idUpdateSubject;
    private javax.swing.JTextField idUserUpgrade;
    private javax.swing.JLabel img1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelLecturers;
    private javax.swing.JLabel jLabelStudents;
    private javax.swing.JLabel jLabelSubjects;
    private javax.swing.JLabel jLabelTLecturers;
    private javax.swing.JLabel jLabelTStudents;
    private javax.swing.JLabel jLabelTSubjects;
    private javax.swing.JPanel jPanelLeft;
    private javax.swing.JPanel jPanelRight;
    private javax.swing.JRadioButton jRadioLecturer;
    private javax.swing.JRadioButton jRadioLecturer2;
    private javax.swing.JRadioButton jRadioStudent;
    private javax.swing.JRadioButton jRadioStudent2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTableLecturer;
    private javax.swing.JTable jTableStudents;
    private javax.swing.JTable jTableSubjects;
    private javax.swing.JButton lecturersButton;
    private javax.swing.JPanel lecturersjPanelRight;
    private javax.swing.JLabel name;
    private javax.swing.JLabel name2;
    private javax.swing.JLabel name3;
    private javax.swing.JTextField nameAddSubject;
    private javax.swing.JTextField nameAddUser;
    private javax.swing.JTextField nameSetting;
    private javax.swing.JTextField nameUpdateSubject;
    private javax.swing.JLabel password;
    private javax.swing.JPasswordField passwordAddUser;
    private javax.swing.JPasswordField passwordSetting;
    private javax.swing.JLabel searchMessages1;
    private javax.swing.JLabel searchMessages2;
    private javax.swing.JLabel searchMessages3;
    private javax.swing.JButton settingButton;
    private javax.swing.JPanel settingJPanelRight;
    private javax.swing.JButton studentsButton;
    private javax.swing.JPanel studentsjPanelRight;
    private javax.swing.JButton subjectsButton;
    private javax.swing.JPanel subjectsjPanelRight;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton updateSubjectButton;
    private javax.swing.JPanel updateUser;
    private javax.swing.JButton uploadSubjectButton;
    private javax.swing.JTextField usernameAddUser;
    private javax.swing.JTextField usernameSetting;
    private javax.swing.JPanel viewLecturers;
    private javax.swing.JPanel viewStudents;
    private javax.swing.JPanel viewSubjects;
    // End of variables declaration//GEN-END:variables

    

   
}
