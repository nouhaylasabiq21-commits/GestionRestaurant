/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.*;
import connexion.Connexion;
import dao.IDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Commandeservice implements IDao<Commande> {

    @Override
    public boolean create(Commande c) {
        try {
            String sql = "INSERT INTO commande(client_id, plat_id, quantite, dateCommande) VALUES(?,?,?,?)";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(sql);
            ps.setInt(1, c.getClient().getId());
            ps.setInt(2, c.getPlat().getId());
            ps.setInt(3, c.getQuantite());
            ps.setDate(4, new java.sql.Date(c.getDateCommande().getTime()));
            ps.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Commandeservice.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean update(Commande c) {
        try {
            String sql = "UPDATE commande SET client_id=?, plat_id=?, quantite=?, dateCommande=? WHERE id=?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(sql);
            ps.setInt(1, c.getClient().getId());
            ps.setInt(2, c.getPlat().getId());
            ps.setInt(3, c.getQuantite());
            ps.setDate(4, new java.sql.Date(c.getDateCommande().getTime()));
            ps.setInt(5, c.getId());
            ps.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Commandeservice.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(Commande c) {
        try {
            String sql = "DELETE FROM commande WHERE id=?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(sql);
            ps.setInt(1, c.getId());
            ps.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Commandeservice.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Commande findById(int id) {
        try {
            String sql = "SELECT * FROM commande WHERE id=?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Clientservice cd = new Clientservice();
                Platservice pd = new Platservice();
                return new Commande(
                        rs.getInt("id"),
                        cd.findById(rs.getInt("client_id")),
                        pd.findById(rs.getInt("plat_id")),
                        rs.getInt("quantite"),
                        rs.getDate("dateCommande")
                );
            }
        } catch (Exception ex) {
            Logger.getLogger(Commandeservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Commande> findAll() {
        List<Commande> commandes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM commande";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            Clientservice cd = new Clientservice();
            Platservice pd = new Platservice();

            while (rs.next()) {
                commandes.add(new Commande(
                        rs.getInt("id"),
                        cd.findById(rs.getInt("client_id")),
                        pd.findById(rs.getInt("plat_id")),
                        rs.getInt("quantite"),
                        rs.getDate("dateCommande")
                ));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Commandeservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return commandes;
    }
}
