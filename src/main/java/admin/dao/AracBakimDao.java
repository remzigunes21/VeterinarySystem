/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import admin.entity.AracBakim;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cemr_
 */
public class AracBakimDao extends Dao{
 public int itemCount() {
        int count = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select count (bakim_id) as bakim_count from arac");
            ResultSet rs = pst.executeQuery();
            count = rs.getInt("bakim_count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public int kayitSay() {
        int c = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from arac_bakim");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return c;
    }

   

    public void insert(AracBakim arac_bakim) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into arac_bakim "
                    + "(arac_masraf,bilgi,tarih) values(?,?,?)");
            pst.setString(1, arac_bakim.getAracMasraf());
            pst.setString(2, arac_bakim.getBilgi());
            pst.setString(3, arac_bakim.getTarih());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(AracBakim arac_bakim) {
         try {
            PreparedStatement pst = this.getConnection().prepareStatement("update arac_bakim set "
                    + "arac_masraf=?,bilgi=?,tarih=? where bakim_id=?");
            pst.setString(1, arac_bakim.getAracMasraf());
            pst.setString(2, arac_bakim.getBilgi());
            pst.setString(3, arac_bakim.getTarih());
            pst.setLong(4, arac_bakim.getBakimId());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(AracBakim deleteBakim) {
         try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from arac_bakim where bakim_id=" + deleteBakim.getBakimId());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<AracBakim> findAll(int page, int listItemCount) {
         List<AracBakim> bakimList = new ArrayList<>();

        int start = (page - 1) * listItemCount;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from arac_bakim order by bakim_id desc limit " + start + "," + listItemCount);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                AracBakim tmp = new AracBakim();
               tmp.setBakimId(rs.getLong("bakim_id"));
               tmp.setAracMasraf(rs.getString("arac_masraf"));
               tmp.setBilgi(rs.getString("bilgi"));
               tmp.setTarih(rs.getString("tarih"));

                bakimList.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return bakimList;
    }
    
}
