package collegeexaminationmanagementsystem;


import controller.LoginController;
import java.io.IOException;
import model.UsersModel;
import view.*;

/**
 * @author Khaled-HP
 * @version 1.0
 */
public class CollegeExaminationManagementSystem {

    public static void main(String[] args) throws IOException  {
        Tools.createTheme ();
        LoginView loginView = new LoginView();
        UsersModel loginModel = new UsersModel();     
        LoginController loginController = new LoginController(loginView , loginModel);
        Tools.oppForme (loginView,"College Examination || Login");            
    }
    
    
    
}
