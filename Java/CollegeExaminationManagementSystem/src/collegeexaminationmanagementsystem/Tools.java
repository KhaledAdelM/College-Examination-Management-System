package collegeexaminationmanagementsystem;

import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class Tools {
    // Message Box
    public static void msgBox(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    // Error Message Box
    public static void errmsgBox(String message) {
        JOptionPane.showMessageDialog(null, message,"Error",JOptionPane.ERROR_MESSAGE);
    }
    //-----------------------------------------------------
    // open Frame
     public static void oppForme (JFrame jFrame , String title){
        try {
            createTheme ();
            jFrame.setLocationRelativeTo(null);
            Image img = ImageIO.read(CollegeExaminationManagementSystem.class.getResource("Logo.png"));
            jFrame.setIconImage(img);
            jFrame.setTitle(title);
            //JFrame.setDefaultLookAndFeelDecorated(true);
            jFrame.setVisible(true);
        } catch (IOException ex) {
            msgBox(ex.getMessage());
       }
    }
    //Create new theme
    static void createTheme (){
        try {
            //FlatCobalt2IJTheme.setup();
            //FlatGitHubDarkIJTheme.setup();
            FlatOneDarkIJTheme.setup();
        }catch(Exception e){
            msgBox(e.getMessage());
        }
    }
}
