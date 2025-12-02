/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import connexion.Connexion;
import dao.IDao;
import entities.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Clientservice implements IDao<Client> {

    @Override
    public boolean create(Client o) {
        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(
                    "INSERT INTO client (nom, telephone, adresse) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            ps.setString(1, o.getNom());
            ps.setString(2, o.getTelephone());
            ps.setString(3, o.getAdresse());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    o.setId(rs.getInt(1));
                }
                return true;
            }

            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Clientservice.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean update(Client o) {
        try {
            String req = "UPDATE client SET nom=?, telephone=?,adresse=? WHERE id=?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getTelephone());
            ps.setString(3, o.getAdresse());
            ps.setInt(4, o.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Platservice.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(Client c) {
        try {
            String req = "DELETE FROM client WHERE id=?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, c.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Clientservice.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Client findById(int id) {
        try {
            String req = "select * from client where id = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Client(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("telephone"),
                        rs.getString("adresse")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(Clientservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        try {
            String req = "SELECT * FROM client";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                clients.add(new Client(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("telephone"),
                        rs.getString("adresse")
                ));
            }
        } catch (Exception ex) {
            Logger.getLogger(Clientservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clients;
    }
}
