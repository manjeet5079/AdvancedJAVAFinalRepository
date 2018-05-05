package com.praveen.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.praveen.model.Product;
import com.praveen.util.DBConnect;


public class ProductDAO {

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();

        String sql = "select * from product";

        try {
            ResultSet rs = DBConnect.getConnection().createStatement().executeQuery(sql);
            while (rs.next()) {
                list.add(new Product(rs.getInt("pid"), rs.getString("pname"), rs.getDouble("price"), rs.getInt("qty")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean saveProduct(Product p) {
        String sql = "insert into product (pname, price, qty) values (?, ?, ?)";

        try {
            PreparedStatement pst = DBConnect.getConnection().prepareStatement(sql);
            pst.setString(1, p.getPname());
            pst.setDouble(2, p.getPrice());
            pst.setInt(3, p.getQty());
            int value = pst.executeUpdate();
            if (value > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public boolean updateProduct(Product p) {
        String sql = "update product set pname=?, price=?, qty=? where pid=?";

        try {
            PreparedStatement pst = DBConnect.getConnection().prepareStatement(sql);
            pst.setString(1, p.getPname());
            pst.setDouble(2, p.getPrice());
            pst.setInt(3, p.getQty());
            pst.setInt(4, p.getPid());
            int value = pst.executeUpdate();
            if (value > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public boolean deleteProduct(int id) {
        String sql = "delete from product where pid=?";

        try {
            PreparedStatement pst = DBConnect.getConnection().prepareStatement(sql);

            pst.setInt(1, id);
            int value = pst.executeUpdate();
            if (value > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public Product getProduct(int id) {
        Product p = new Product();

        String sql = "select * from product where pid=" + id;
        
        try {
            ResultSet rs = DBConnect.getConnection().createStatement().executeQuery(sql);
            if(rs.next()){
                p.setPid(rs.getInt("pid"));
                p.setPname(rs.getString("pname"));
                p.setPrice(rs.getDouble("price"));
                p.setQty(rs.getInt("qty"));
            }
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
