/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import admin.entity.Teknisyen;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cemr_
 */
public class TeknisyenDao extends Dao {

    public int itemCount() {
        int count = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select count (teknisyen_id) as teknisyen_count from teknisyen");
            ResultSet rs = pst.executeQuery();
            count=rs.getInt("teknisyen_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public int kayitSay() {
        int c = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from teknisyen");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return c;
    }

    public List<Teknisyen> findAll(int page, int listItemCount) {
        List<Teknisyen> teknisyenList = new ArrayList<>();
        int start = (page - 1) * listItemCount;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from teknisyen order by teknisyen_id desc limit " + start + "," + listItemCount);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Teknisyen tmp = new Teknisyen();
                tmp.setTeknisyenId(rs.getLong("teknisyen_id"));
                tmp.setTeknisyenName(rs.getString("teknisyen_name"));
                tmp.setTeknisyenBilgi(rs.getString("teknisyen_bilgi"));

                teknisyenList.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return teknisyenList;
    }

    public void insert(Teknisyen teknisyen) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into teknisyen "
                    + "(teknisyen_name,teknisyen_bilgi) values(?,?)");
            pst.setString(1, teknisyen.getTeknisyenName());
            pst.setString(2, teknisyen.getTeknisyenBilgi());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Teknisyen teknisyen) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update teknisyen set "
                    + "teknisyen_name=?,teknisyen_bilgi=? where teknisyen_id=?");
            pst.setString(1, teknisyen.getTeknisyenName());
            pst.setString(2, teknisyen.getTeknisyenBilgi());
            pst.setLong(3, teknisyen.getTeknisyenId());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Teknisyen deleteTeknisyen) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from teknisyen where teknisyen_id=" + deleteTeknisyen.getTeknisyenId());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
