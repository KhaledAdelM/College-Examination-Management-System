package model;

import databaseCEMS.CollegeExaminationDatabase;



public class UsersModel {
    
    private static int id;
    private static String name;
    private static String email;
    private static String birthday;
    private static String username;
    private static String password;
    private static int idModule;
    
    public UsersModel(){
        
    }
    
    public int getId (){
        return id;
    }
    public String getName (){
        return name;
    }
    public String getEmail (){
        return email;
    }
    public String getBirthday (){
        return birthday;
    }
    public String getUsername (){
        return username;
    }
    public String getPassword (){
        return password;
    }
    public int getIdModule (){
        return idModule;
    }
        
    public boolean login (String username , String password){
        String[] userInfo = {"id","name","email","birthday", "username","password","idModule"};
        if(CollegeExaminationDatabase.login(username, password,userInfo)){            
            id = Integer.parseInt(userInfo[0]);
            name = userInfo[1];
            email= userInfo[2];
            birthday = userInfo[3];
            this.username = username;
            this.password = password;
            idModule = Integer.parseInt(userInfo[6]);
            return true;
        }else
            return false;   
    }
    
    public boolean updateInfo (String name, String email, String birthday, String username, String password, int idModule){
        if(CollegeExaminationDatabase.updateInfo(id, name, email, birthday, username, password, idModule)){
            this.name = name;
            this.email= email;
            this.birthday = birthday;
            this.username = username;
            this.password = password ;
            this.idModule = idModule;
            return true;
        }else
            return false;
    }
    
}
