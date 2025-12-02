/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import connexion.Connexion;
import dao.IDao;
import entities.Plat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aaa
 */
public class Platservice implements IDao<Plat> {

    @Override
    public boolean create(Plat o) {
        try {
            String req = "INSERT INTO plat (nom, categorie, prix) VALUES (?, ?, ?)";

            PreparedStatement ps = Connexion.getConnection().prepareStatement(req,Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, o.getNom());
            ps.setString(2, o.getCategorie());
            ps.setDouble(3, o.getPrix());

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
            Logger.getLogger(Platservice.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean update(Plat o) {
        try {
            String req = "UPDATE `plat` SET `nom`=?, `categorie`=?, `prix`=? WHERE `plat`.`id`=?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getCategorie());
            ps.setDouble(3, o.getPrix());
            ps.setInt(4, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Platservice.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(Plat o) {
        try {
            String req = "delete from plat where id = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Platservice.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public Plat findById(int id) {
        try {
            String sql = "SELECT * FROM plat WHERE id=?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Plat(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("categorie"),
                        rs.getDouble("prix")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(Platservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Plat> findAll() {
        List<Plat> plats = new ArrayList<>();
        try {
            String req = "SELECT * FROM plat";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                plats.add(new Plat(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("categorie"),
                        rs.getDouble("prix")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Platservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return plats;
    }

    public List<Plat> getByCategorie(String categorie) {
        List<Plat> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM plat WHERE categorie = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, categorie);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Plat p = new Plat(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("categorie"),
                        rs.getDouble("prix")
                );
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Platservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
