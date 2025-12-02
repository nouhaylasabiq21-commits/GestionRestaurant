/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
public class User {
    private int id;
    private String email;
    private String password;

    public User() {
    }

    public User(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
    

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public int getid() {
        return id;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String login) {
        this.email = email;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "email=" +email + ", password=" + password + '}';
    }

    
    
    
    
}