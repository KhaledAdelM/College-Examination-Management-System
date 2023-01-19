module collegeexaminationms.collegeexaminationmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens collegeexaminationms.collegeexaminationmanagementsystem to javafx.fxml;
    exports collegeexaminationms.collegeexaminationmanagementsystem;
}