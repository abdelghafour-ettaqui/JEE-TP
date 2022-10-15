package dao;

import metier.entities.Produit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDaoImpl implements IProduitDao {

    @Override
    public Produit save(Produit p) {
        Connection connection = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO PRODUITS(DESIGNATION,PRIX,QUANTITE)VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getDesignation());
            ps.setDouble(2, p.getPrix());
            ps.setInt(3, p.getQuantite());
            int affectedRows = ps.executeUpdate();
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                p.setId(resultSet.getLong(1));
            }
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return p;
    }

    @Override
    public List<Produit> produitsParMC(String mc) {
        List<Produit> produits = new ArrayList<>();
        Connection connection = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM PRODUITS WHERE DESIGNATION LIKE ?");
            ps.setString(1, mc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getLong("ID"));
                p.setDesignation(rs.getString("DESIGNATION"));
                p.setPrix(rs.getDouble("PRIX"));
                p.setQuantite(rs.getInt("QUANTITE"));
                produits.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produits;
    }

    @Override
    public Produit getProduit(Long id) {
        Produit p = null;
        Connection connection = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM PRODUITS WHERE ID=?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = new Produit();
                p.setId(rs.getLong("ID"));
                p.setDesignation(rs.getString("DESIGNATION"));
                p.setPrix(rs.getDouble("PRIX"));
                p.setQuantite(rs.getInt("QUANTITE"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    @Override
    public Produit update(Produit p) {

        Connection connection = SingletonConnection.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement
                    ("UPDATE PRODUITS SET DESIGNATION=?,PRIX=?,QUANTITE=? WHERE ID=?");
            ps.setString(1,p.getDesignation());
            ps.setDouble(2,p.getPrix());
            ps.setInt(3,p.getQuantite());
            ps.setLong(4,p.getId());
            ps.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return p;

    }

    @Override
    public void deleteProduit(Long id) {
        Connection connection = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM PRODUITS WHERE ID=?");
            ps.setLong(1, id);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
