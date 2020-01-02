/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import admin.entity.Sofor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cemr_
 */
public class SoforDao extends Dao{

       public int itemCount() {
       int count=0;
       try{
           PreparedStatement pst = this.getConnection().prepareStatement("select count (sofor_id) as sofor_count from sofor");
           ResultSet rs = pst.executeQuery();
           while(rs.next()){
               count=rs.getInt("sofor_count");
           }
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
       return count;
    }
    public int kayitSay() {
       int c=0;
       try{
           PreparedStatement pst = this.getConnection().prepareStatement("select * from sofor");
           ResultSet rs = pst.executeQuery();
           while(rs.next()){
               c++;
           }
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
       return c;
    }

    public List<Sofor> findAl(int page, int listItemCount) {
        List<Sofor> soforList = new ArrayList<>();

        int start = (page - 1) * listItemCount;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from sofor order by sofor_id limit " + start + "," + listItemCount);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Sofor tmp = new Sofor();
                tmp.setSoforId(rs.getLong("sofor_id"));
                tmp.setSoforNameSurname(rs.getString("sofor_name_surname"));
                tmp.setSoforTc(rs.getInt("sofor_tc"));

                soforList.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return soforList;
    }

    public void insert(Sofor sofor) {
       try{
           PreparedStatement pst = this.getConnection().prepareStatement("insert into sofor (sofor_name_surname,sofor_tc)"
                   + "values(?,?)");
           pst.setString(1, sofor.getSoforNameSurname());
           pst.setInt(2, sofor.getSoforTc());
           
           pst.executeUpdate();
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
    }

    public void update(Sofor sofor) {
         try{
           PreparedStatement pst = this.getConnection().prepareStatement("update sofor set sofor_name_surname=?,sofor_tc=? where sofor_id=?");
           pst.setString(1, sofor.getSoforNameSurname());
           pst.setInt(2, sofor.getSoforTc());
           pst.setLong(3,sofor.getSoforId());
           pst.executeUpdate();
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
    }

    public void delete(Sofor deleteSofor) {
       try{
           PreparedStatement pst = this.getConnection().prepareStatement("delete from sofor where sofor_id="+deleteSofor.getSoforId());
           pst.executeUpdate();
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
    }
    
}
