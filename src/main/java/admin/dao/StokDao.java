/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import admin.entity.Stok;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cemr_
 */
public class StokDao extends Dao{
 public int itemCount() {
        int count = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select count (stok_id) as stok_count from stok");
            ResultSet rs = pst.executeQuery();
            count=rs.getInt("stok_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public List<Stok> findAll(int page, int listItemCount) {
        List<Stok> stokList = new ArrayList<>();
        int start = (page-1)*listItemCount;
        try{
            PreparedStatement pst = this.getConnection().prepareStatement("select * from stok order by stok_id desc limit "+start+","+listItemCount);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Stok tmp = new Stok();
                tmp.setStokId(rs.getLong("stok_id"));
                tmp.setStokName(rs.getString("stok_name"));
                tmp.setStokSayi(rs.getLong("stok_sayi"));
                
                stokList.add(tmp);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return stokList;
    }

    public void insert(Stok stok) {
        try{
         PreparedStatement pst = this.getConnection().prepareStatement("insert into stok "
                 + "(stok_name,stok_sayi) values(?,?)");
         pst.setString(1, stok.getStokName());
         pst.setLong(2, stok.getStokSayi());
         
         pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void update(Stok stok) {
         try{
         PreparedStatement pst = this.getConnection().prepareStatement("update stok set "
                 + "stok_name=?,stok_sayi=? where stok_id=?");
         pst.setString(1, stok.getStokName());
         pst.setLong(2, stok.getStokSayi());
         pst.setLong(3, stok.getStokId());
         
         pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Stok deleteStok) {
        try{
         PreparedStatement pst = this.getConnection().prepareStatement("delete from stok where stok_id="+deleteStok.getStokId());
        
         pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public int kayitSay() {
        int c=0;
        
        try{
            PreparedStatement pst = this.getConnection().prepareStatement("select * from stok");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                c++;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return c;
    }
    
}
 