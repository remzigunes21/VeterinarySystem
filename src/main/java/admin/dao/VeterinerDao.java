/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import admin.entity.Veteriner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cemr_
 */
public class VeterinerDao extends Dao {

    public int itemCount() {
        int count = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select count (veteriner_id) as veteriner_count from veteriner");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("veteriner_count");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public int kayitSay() {
        int c = 0;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from veteriner");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                c++;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return c;
    }

    public List<Veteriner> findAll(int page, int listItemCount) {
        List<Veteriner> veterinerList = new ArrayList<>();

        int start = (page - 1) * listItemCount;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from veteriner order by veteriner_id limit " + start + "," + listItemCount);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Veteriner tmp = new Veteriner();
                tmp.setVeterinerId(rs.getLong("veteriner_id"));
                tmp.setVeterinerNameSurname(rs.getString("veteriner_name_surname"));
                tmp.setVeterinerTc(rs.getInt("veteriner_tc"));
                tmp.setVeterinerSicilNu(rs.getInt("veteriner_sicil_nu"));

                veterinerList.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return veterinerList;
    }

    public void insert(Veteriner veteriner) {
       try{
           PreparedStatement pst = this.getConnection().prepareStatement("insert into veteriner"
                   + " (veteriner_name_surname,veteriner_tc,veteriner_sicil_nu) values(?,?,?)");
           pst.setString(1, veteriner.getVeterinerNameSurname());
           pst.setInt(2, veteriner.getVeterinerTc());
           pst.setInt(3, veteriner.getVeterinerSicilNu());
           
           pst.executeUpdate();
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void update(Veteriner veteriner) {
       try{
            PreparedStatement pst = this.getConnection().prepareStatement(" update veteriner set veteriner_name_surname=?, veteriner_tc=?,veteriner_sicil_nu=?  where veteriner_id=?");
            pst.setString(1, veteriner.getVeterinerNameSurname());
            pst.setInt(2, veteriner.getVeterinerTc());
            pst.setInt(3, veteriner.getVeterinerSicilNu());
            pst.setLong(4, veteriner.getVeterinerId());
            pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Veteriner deleteVeteriner) {
        try{
        PreparedStatement pst = this.getConnection().prepareStatement("delete from veteriner where veteriner_id="+deleteVeteriner.getVeterinerId());
        pst.executeUpdate();
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
    }

}
