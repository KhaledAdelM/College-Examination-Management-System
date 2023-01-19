package databaseCEMS;

import java.sql.*;

public class CollegeExaminationDatabase {

    private static String dbUrl = "jdbc:sqlserver://HP-PC:1433;databaseName=CollegeExamination ";
    private static  String dbUsername = "PC-HP";
    private static  String dbPassword = "123321";
    private static Connection dbConnection;

    //Connection to Database
    public static void setConnection(){
        try {
            System.out.println("Start");
            dbConnection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
            System.out.println("Done");
        }
        catch (SQLException ex) {
            System.out.println("ErrorSQL - Connection to Database.");
        }
    }
    public static boolean login (String username , String password) {
        try {
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Check User Validity form this Username & Password ( in SQL Server ).
            String strCheck = "select * from Users where "
                    + "Username ='" + username + "' and "
                    + "Password ='" + password + "'";
            ResultSet resultSet = stmt.executeQuery(strCheck);
            while (resultSet.next()) {
                // Get data from Database.


                // set data in User Object.


                // close SQL Server.
                dbConnection.close();
                // check successfully.
                return true;
            }
            dbConnection.close();
        } catch (SQLException ex) {
            System.out.println("Not Found");
        }
        // check failed.
        return false;
    }

    public static boolean updateInfo (int id,String name, String email, String birthday, String username, String password, int idModule){
        try {
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Update User ( in SQL Server ).
            String strUp = "UPDATE Users SET " +
                    "Name ='" + name+ "'," +
                    "username ='" +username+ "'," +
                    "email ='" + email+ "'," +
                    "Password ='" + password + "'," +
                    "Birthday ='" + birthday + "'," +
                    "Id_Module = " + idModule +
                    "WHERE Id= " + id ;
            stmt.execute(strUp);
            // close SQL Server.
            dbConnection.close();
            // update successfully.
            return true;
        }catch (SQLException ex){
            System.out.println("Update failed");
        }
        // update Profile failed.
        return false;
    }

    public static boolean updateInfo (int id,int idModule){
        try {
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Update User ( in SQL Server ).
            String strUp = "UPDATE Users SET " +
                    "Id_Module = " + idModule +
                    "WHERE Id= " + id ;
            stmt.execute(strUp);
            // close SQL Server.
            dbConnection.close();
            // update successfully.
            return true;
        }catch (SQLException ex){
            System.out.println("Update failed");
        }
        // update Profile failed.
        return false;
    }

    public static boolean addNewUser (String name, String username, String password, int idModule){
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Add User ( in SQL Server ).
            String strAdd = "INSERT INTO Users (Name,Username,Password,Id_Module) "
                    + "VALUES ('"+ name +"','"+ username + "','" + password +"'," + idModule +")";
            // Add this user
            stmt.execute(strAdd);
            // close SQL Server.
            dbConnection.close();
            return true;
        }
        catch(SQLException ex ){
            System.out.println("Wrong Username");
        }
        // check failed.
        return false;
    }

    public static boolean deleteUser (int id){
        try{
            setConnection();
            // Open SQL Server
            Statement stmt = dbConnection.createStatement();
            // Delete User id = ....
            String strdelt = "DELETE FROM Users WHERE Id = " + id ;
            // Delete User
            stmt.execute(strdelt);
            // close SQL Server.
            dbConnection.close();
            return true;
        }
        catch(SQLException ex ){
            System.out.println("Delete failed");
        }
        // check failed.
        return false;
    }


}
