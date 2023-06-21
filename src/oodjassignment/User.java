/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodjassignment;

public class User {
  private String UserId;
  private String UserPw;  
  private String Role;
  private String Name;
  private int TelNumber;
  private String Email;
  
  public User(String Uid,String Upw, String Pos, String Una, int TelNo, String Mail)
    {
       UserId = Uid;
       UserPw = Upw;
       Role = Pos;
       Name = Una;
       TelNumber = TelNo;
       Email = Mail;
    }
    public User(){

    }
    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getUserPw() {
        return UserPw;
    }

    public void setUserPw(String UserPw) {
        this.UserPw = UserPw;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getTelNumber() {
        return TelNumber;
    }

    public void setTelNumber(int TelNumber) {
        this.TelNumber = TelNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String toString() {
        return UserId + "," + UserPw + "," + Role + "," + Name + "," + TelNumber + "," + Email;
    }
    
 
}
