/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import admin.entity.GunlukKayitlar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cemr_
 */
public class GunlukKayitDao extends Dao {

    public int itemCount() {
        int count = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select count (gunluk_id) as gunluk_count from gunluk_kayitlar");
            ResultSet rs = pst.executeQuery();
            count = rs.getInt("gunluk_count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public int kayitSay() {
        int c = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from gunluk_kayitlar");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return c;
    }

    public List<GunlukKayitlar> findAll(int page, int listItemCount) {
        List<GunlukKayitlar> gunlukList = new ArrayList<>();

        int start = (page - 1) * listItemCount;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from gunluk_kayitlar order by gunluk_id desc limit " + start + "," + listItemCount);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                GunlukKayitlar tmp = new GunlukKayitlar();
                tmp.setGunlukId(rs.getLong("gunluk_id"));

                gunlukList.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return gunlukList;
    }

    public void insert(GunlukKayitlar gunluk_kayit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void update(GunlukKayitlar gunluk_kayit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(GunlukKayitlar deleteGunlukKayit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
