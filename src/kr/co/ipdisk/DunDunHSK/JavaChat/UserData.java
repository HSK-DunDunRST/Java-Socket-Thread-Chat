package kr.co.ipdisk.DunDunHSK.JavaChat;

import java.util.Date;

public class UserData {
    String userId;
    String userPwd;
    String userName;
    String userNickname;
    String userEmail;
    Date userDate;
    
    public UserData(){
        // 기본 생성자    
    }
    
    public UserData(String envId, String envPwd, String envName, String envNickname){
        this.userId = envId;
        this.userPwd = envPwd;
        this.userName = envName;
        this.userNickname = envNickname;
    }

    public void setUserId(String envUserId) {
        this.userId = envUserId;
    }

    public void setUserPwd(String envUserPwd){
        this.userPwd = envUserPwd;
    }

    public void setUserName(String envUserName){
        this.userName = envUserName;
    }

    public void setUserNickname(String envUserNickname){
        this.userNickname = envUserNickname;
    }

    public void setUserEmail(String envUserEmail){
        this.userEmail = envUserEmail;
    }

    public String getUserId(){
        return userId;
    }

    public String getUserPwd(){
        return userPwd;
    }

    public String getUserName(){
        return  userName;
    }

    public String getUserNickname(){
        return userNickname;
    }
}
