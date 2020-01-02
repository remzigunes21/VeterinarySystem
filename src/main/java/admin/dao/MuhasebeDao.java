/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import admin.entity.Muhasebeci;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cemr_
 */
public class MuhasebeDao extends Dao{

    public int itemCount() {
        int count = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select count (muhasebeci_id) as muhasebeci_count from muhasebeci");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("muhasebeci_count");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public int kayitSay() {
        int c = 0;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from muhasebeci");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                c++;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return c;
    }

    public List<Muhasebeci> findAll(int page, int listItemCount) {
      List<Muhasebeci> muhasebeList = new ArrayList<>();

        int start = (page - 1) * listItemCount;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from muhasebeci order by muhasebeci_id limit " + start + "," + listItemCount);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Muhasebeci tmp = new Muhasebeci();
             tmp.setMuhasebeciId(rs.getLong("muhasebeci_id"));
             tmp.setMuhasebeNameSurname(rs.getString("muhasebe_name_surname"));
             tmp.setMuhasebeSicil(rs.getInt("muhasebe_sicil"));
             tmp.setMuhasebeTc(rs.getInt("muhasebe_tc"));

                muhasebeList.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return muhasebeList;
    }

    public void insert(Muhasebeci muhasebe) {
         try{
           PreparedStatement pst = this.getConnection().prepareStatement("insert into muhasebeci"
                   + " (muhasebe_name_surname,muhasebe_sicil,muhasebe_tc) values(?,?,?)");
           pst.setString(1, muhasebe.getMuhasebeNameSurname());
           pst.setInt(2, muhasebe.getMuhasebeSicil());
           pst.setInt(3, muhasebe.getMuhasebeTc());
           
           pst.executeUpdate();
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void update(Muhasebeci muhasebe) {
        try{
           PreparedStatement pst = this.getConnection().prepareStatement("update muhasebeci set"
                   + " muhasebe_name_surname=?,muhasebe_sicil=?,muhasebe_tc=? where muhasebeci_id=?");
           pst.setString(1, muhasebe.getMuhasebeNameSurname());
           pst.setInt(2, muhasebe.getMuhasebeSicil());
           pst.setInt(3, muhasebe.getMuhasebeTc());
           pst.setLong(4, muhasebe.getMuhasebeciId());
           
           pst.executeUpdate();
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Muhasebeci deleteMuhasebeci) {
          try{
        PreparedStatement pst = this.getConnection().prepareStatement("delete from muhasebeci where muhasebeci_id="+deleteMuhasebeci.getMuhasebeciId());
        pst.executeUpdate();
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
    }
    
}
