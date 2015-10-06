package com.project2.db.flyr;

/**
 * Created by karthick on 06/10/2015.
 */
public class users {
    int id;
    String username,password;
    public void setid(int id){
        this.id = id;

    }
    public int getid(){
        return this.id;
    }
    public void setusername(String username){
        this.username = username;

    }
    public String getusername(){
        return this.username;
    }
    public void setpassword(String password){
        this.password = password;

    }
    public String getpassword(){
        return this.password;
    }
}
