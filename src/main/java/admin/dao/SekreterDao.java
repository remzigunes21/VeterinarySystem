/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import admin.entity.BilgiIslemSekreteri;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cemr_
 */
public class SekreterDao extends Dao{

    public int itemCount() {
        int count = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select count (bi_sekreter_id) as sekreter_count from bilgi_islem_sekreteri");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("sekreter_count");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public int kayitSay() {
        int c = 0;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from bilgi_islem_sekreteri");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                c++;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return c;
    }

    public List<BilgiIslemSekreteri> findAll(int page, int listItemCount) {
        List<BilgiIslemSekreteri> sekreterList = new ArrayList<>();

        int start = (page - 1) * listItemCount;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from bilgi_islem_sekreteri order by bi_sekreter_id limit " + start + "," + listItemCount);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                BilgiIslemSekreteri tmp = new BilgiIslemSekreteri();
               tmp.setBiSekreterId(rs.getLong("bi_sekreter_id"));
               tmp.setBiSekreterNameSurname(rs.getString("bi_sekreter_name_surname"));
               tmp.setBiSekreterTc(rs.getInt("bi_sekreter_tc"));

                sekreterList.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return sekreterList;
    }

    public void insert(BilgiIslemSekreteri sekreter) {
      try{
           PreparedStatement pst = this.getConnection().prepareStatement("insert into bilgi_islem_sekreteri"
                   + " (bi_sekreter_name_surname,bi_sekreter_tc) values(?,?)");
           pst.setString(1, sekreter.getBiSekreterNameSurname());
           pst.setInt(2, sekreter.getBiSekreterTc());
           
           
           pst.executeUpdate();
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(BilgiIslemSekreteri sekreter) {
        try{
           PreparedStatement pst = this.getConnection().prepareStatement("update bilgi_islem_sekreteri set"
                   + " bi_sekreter_name_surname=?,bi_sekreter_tc=? where bi_sekreter_id=?");
           pst.setString(1, sekreter.getBiSekreterNameSurname());
           pst.setInt(2, sekreter.getBiSekreterTc());
           pst.setLong(3, sekreter.getBiSekreterId());
           
           pst.executeUpdate();
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(BilgiIslemSekreteri deleteSekreter) {
        try{
        PreparedStatement pst = this.getConnection().prepareStatement("delete from bilgi_islem_sekreteri where bi_sekreter_id="+deleteSekreter.getBiSekreterId());
        pst.executeUpdate();
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
    }
    
}
