/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import admin.entity.Belediye;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cemr_
 */
public class BelediyeDao extends Dao{

   public int itemCount() {
        int count = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select count (balediye_id) as belediye_count from veteriner");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("belediye_count");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public int kayitSay() {
        int c = 0;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from belediye");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                c++;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return c;
    }

    public List<Belediye> findAll(int page, int listItemCount) {
        List<Belediye> belediyeList = new ArrayList<>();

        int start = (page - 1) * listItemCount;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from belediye order by belediye_id limit " + start + "," + listItemCount);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Belediye tmp = new Belediye();
             tmp.setBelediyeId(rs.getLong("belediye_id"));
             tmp.setBelediyeName(rs.getString("belediye_name"));
             tmp.setBelediyeYer(rs.getString("belediye_yer"));

                belediyeList.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return belediyeList;
    }

    public void insert(Belediye belediye) {
         try{
           PreparedStatement pst = this.getConnection().prepareStatement("insert into belediye"
                   + " (belediye_name,belediye_yer) values(?,?)");
          pst.setString(1, belediye.getBelediyeName());
          pst.setString(2, belediye.getBelediyeYer());
           
           pst.executeUpdate();
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void update(Belediye belediye) {
         try{
           PreparedStatement pst = this.getConnection().prepareStatement("update belediye set"
                   + " belediye_name=?,belediye_yer=? where belediye_id=?");
          pst.setString(1, belediye.getBelediyeName());
          pst.setString(2, belediye.getBelediyeYer());
          pst.setLong(3, belediye.getBelediyeId());
           
           pst.executeUpdate();
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Belediye deleteBelediye) {
        try{
        PreparedStatement pst = this.getConnection().prepareStatement("delete from belediye where belediye_id="+deleteBelediye.getBelediyeId());
        pst.executeUpdate();
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
    }
    
}
