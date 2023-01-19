package controller;

import collegeexaminationmanagementsystem.Tools;
import static collegeexaminationmanagementsystem.Tools.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;
import view.*;


public class LoginController {
    private UsersModel loginModel;
    private LoginView loginView;
    LoginController(){
        
    }
    public LoginController(LoginView loginView, UsersModel loginModel) {
        this.loginModel  =   loginModel;
        this.loginView   =   loginView;
        System.out.println("5");
        //Login Button
        this.loginView.loginListener (new LoginListener());       
    }
    
    class LoginListener implements ActionListener{
            String username;
            String password ;
        @Override
        public void actionPerformed(ActionEvent e) {
            username = loginView.getUsername();
            password = loginView.getPassword();
            boolean checkLogin = loginModel.login(username, password);
            //System.out.println(checkLogin);
            if (checkLogin) openModule();
            else {
                errmsgBox("Invalid username or password");
            }
        }
        private void openModule() {
                switch (loginModel.getIdModule()) {
                    case 1 -> {
                        //System.out.println("Admin");
                        AdminView adminView = new AdminView();
                        AdminModel adminModel = new AdminModel() ;
                        adminModel.login(username, password);
                        AdminController adminController = new AdminController(adminView , adminModel);
                        oppForme (adminView,"College Examination || " + adminModel.getName());
                    }
                    case 2 -> {
                        //System.out.println("Lecturer");
                        LecturerView lecturerView = new LecturerView();
                        LecturerModel lecturerModel = new LecturerModel() ;
                        lecturerModel.login(username, password);
                        LecturerController lecturerController = new LecturerController(lecturerView , lecturerModel);
                        oppForme (lecturerView,"College Examination || " + lecturerModel.getName());
                    }
                    case 3 -> {
                        //System.out.println("Student");
                        StudentView studentView = new StudentView();
                        StudentModel studentModel = new StudentModel() ;
                        studentModel.login(username, password);
                        StudentController studentController = new StudentController(studentView , studentModel);
                        oppForme (studentView,"College Examination || " + studentModel.getName());
                        
                    }
                    default -> Tools.errmsgBox("Error");
                }
            loginView.setVisible(false);
        }
    }
    
    
}
