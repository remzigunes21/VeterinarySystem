/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import admin.entity.Role;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cemr_
 */
public class RoleDao extends Dao {
    
    public List<Role> findAll(){
    List<Role>role_list=new ArrayList<>();
    
    try{
    
        PreparedStatement pst = this.getConnection().prepareStatement("select * from role order by role_id desc");
        ResultSet rs = pst.executeQuery();
        
        while(rs.next()){
        Role tmp = new Role();
        tmp.setRoleId(rs.getLong("role_id"));
        tmp.setRoleName(rs.getString("role_name"));
        tmp.setRoleBilgi(rs.getString("role_bilgi"));
        
        role_list.add(tmp);
        
        }
        
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
        
    }
    
    return role_list;
    }    

    public void insert(Role role) {
        try{
            PreparedStatement pst = this.getConnection().prepareStatement("insert into role (role_name, role_bilgi) values(?,?)");
            pst.setString(1, role.getRoleName());
            pst.setString(2, role.getRoleBilgi());
            
            pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void update(Role role) {
       try{
            PreparedStatement pst = this.getConnection().prepareStatement(" update role set role_name=?, role_bilgi=? where role_id=?");
            pst.setString(1, role.getRoleName());
            pst.setString(2, role.getRoleBilgi());
            pst.setLong(3, role.getRoleId());
            pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Role roledelete) {
       try{
        PreparedStatement pst = this.getConnection().prepareStatement("delete from role where role_id="+roledelete.getRoleId());
        pst.executeUpdate();
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
    }

    public List<Role> findAll(int page, int listItemCount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int kayitSay() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
