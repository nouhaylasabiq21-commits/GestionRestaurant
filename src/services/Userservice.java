/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author aaa
 */

import entities.User;
import connexion.Connexion;
import dao.UserDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Userservice implements UserDAO {


    /*@Override
    /*public User findUserByLogin(String login) {
        String req = "SELECT * FROM user WHERE login = ?";
        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("login"), rs.getString("password"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
*/
    @Override
    public boolean authenticate(String email, String password) {
    String req = "SELECT * FROM users WHERE email = ? AND password = MD5(?)";
    try {
        PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return false;
}

    public boolean changerMotDePasse(String login, String nouveauMotDePasse) {
        String req = "UPDATE user SET password = SHA1(?) WHERE login = ?";
        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, nouveauMotDePasse);
            ps.setString(2, login);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du changement de mot de passe : " + ex.getMessage());
        }
        return false;
    }

    public boolean checkUserExists(String email) {
    String req = "SELECT * FROM users WHERE email = ?";
    try {
        PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return false;
}
    
    public boolean updatePassword(String newPassword) {
    try { 
        String query = "UPDATE users SET password = ? WHERE username = 'user1'";
        System.out.println("Mot de passe mis à jour : " + newPassword);
        return true;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
public boolean resetPassword(String email, String tempPassword) {
    String req = "UPDATE users SET password = MD5(?) WHERE email = ?";
    try {
        PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
        ps.setString(1, tempPassword);
        ps.setString(2, email);
        return ps.executeUpdate() > 0;
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false;
}


}