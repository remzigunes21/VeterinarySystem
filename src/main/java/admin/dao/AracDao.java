/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import admin.entity.Arac;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cemr_
 */
public class AracDao extends Dao {

    public int itemCount() {
        int count = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select count (arac_id) as arac_count from arac");
            ResultSet rs = pst.executeQuery();
            count = rs.getInt("arac_count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public List<Arac> findAll(int page, int listItemCount) {
        List<Arac> aracList = new ArrayList<>();

        int start = (page - 1) * listItemCount;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from arac order by arac_id desc limit " + start + "," + listItemCount);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Arac tmp = new Arac();
                tmp.setAracId(rs.getLong("arac_id"));
                tmp.setAracMarka(rs.getString("arac_marka"));
                tmp.setAracTipi(rs.getString("arac_tipi"));
                tmp.setPlaka(rs.getString("plaka"));

                aracList.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return aracList;
    }

    public int kayitSay() {
        int c = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from arac");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return c;
    }

    public void insert(Arac arac) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into arac "
                    + "(arac_marka,arac_tipi,plaka) values(?,?,?)");
            pst.setString(1, arac.getAracMarka());
            pst.setString(2, arac.getAracTipi());
            pst.setString(3, arac.getPlaka());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Arac arac) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update arac set "
                    + "arac_marka=?,arac_tipi=?,plaka=? where arac_id=?");
            pst.setString(1, arac.getAracMarka());
            pst.setString(2, arac.getAracTipi());
            pst.setString(3, arac.getPlaka());
            pst.setLong(4, arac.getAracId());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Arac deleteArac) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from arac where arac_id=" + deleteArac.getAracId());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
