/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import admin.entity.SahaElemani;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cemr_
 */
public class ElemanDao extends Dao {

    public int itemCount() {
        int count = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select count (eleman_id) as eleman_count from saha_elemani");
            ResultSet rs = pst.executeQuery();
            count = rs.getInt("eleman_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public int kayitSay() {
        int c = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from saha_elemani");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return c;
    }

    public List<SahaElemani> findAll(int page, int listItemCount) {
        List<SahaElemani> elemanList = new ArrayList<>();
        int start = (page - 1) * listItemCount;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from saha_elemani order by eleman_id desc limit " + start + "," + listItemCount);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                SahaElemani tmp = new SahaElemani();
               tmp.setElemanId(rs.getLong("eleman_id"));
               tmp.setElemanName(rs.getString("eleman_name"));
               tmp.setElemanTc(rs.getInt("eleman_tc"));

                elemanList.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return elemanList;
    }

    public void insert(SahaElemani eleman) {
         try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into saha_elemani "
                    + "(eleman_name,eleman_tc) values(?,?)");
           pst.setString(1, eleman.getElemanName());
           pst.setInt(2, eleman.getElemanTc());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(SahaElemani eleman) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update saha_elemani set "
                    + "eleman_name=?,eleman_tc=? where eleman_id=?");
            pst.setString(1, eleman.getElemanName());
            pst.setInt(2, eleman.getElemanTc());
            pst.setLong(3, eleman.getElemanId());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(SahaElemani deleteEleman) {
         try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from saha_elemani where eleman_id=" + deleteEleman.getElemanId());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
