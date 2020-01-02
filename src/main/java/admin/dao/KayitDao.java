/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import admin.entity.Kayit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cemr_
 */
public class KayitDao extends Dao{

      public int itemCount() {
        int count = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select count (kayit_id) as kayit_count from kayit");
            ResultSet rs = pst.executeQuery();
            count = rs.getInt("kayit_count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public int kayitSay() {
        int c = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from kayit");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return c;
    }

    public List<Kayit> findAll(int page, int listItemCount) {
         List<Kayit> kayitList = new ArrayList<>();

        int start = (page - 1) * listItemCount;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from kayit order by kayit_id desc limit " + start + "," + listItemCount);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Kayit tmp = new Kayit();
                tmp.setKayitId(rs.getLong("kayit_id"));
                tmp.setKayitNot(rs.getString("kayit_not"));
                tmp.setRandevuTarih(rs.getString("randevu_tarih"));
                tmp.setYerIsmi(rs.getString("yer_ismi"));

                kayitList.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return kayitList;
    }

    public void insert(Kayit kayit) {
        try{
           PreparedStatement pst = this.getConnection().prepareStatement("insert into kayit"
                   + " (kayit_not,randevu_tarih,yer_ismi) values(?,?,?)");
          pst.setString(1, kayit.getKayitNot());
          pst.setString(2, kayit.getRandevuTarih());
          pst.setString(3, kayit.getYerIsmi());
           
           pst.executeUpdate();
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Kayit kayit) {
       try{
           PreparedStatement pst = this.getConnection().prepareStatement("update kayit set"
                   + " kayit_not=?,randevu_tarih=?,yer_ismi=? where kayit_id=?");
          pst.setString(1, kayit.getKayitNot());
          pst.setString(2, kayit.getRandevuTarih());
          pst.setString(3, kayit.getYerIsmi());
          pst.setLong(4, kayit.getKayitId());
           
           pst.executeUpdate();
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Kayit deleteKayit) {
        try{
        PreparedStatement pst = this.getConnection().prepareStatement("delete from kayit where kayit_id="+deleteKayit.getKayitId());
        pst.executeUpdate();
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
    }
    
}
