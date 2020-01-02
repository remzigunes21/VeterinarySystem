/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.RoleDao;
import admin.entity.Role;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */
@Named(value="role")
@SessionScoped
public class RoleBean implements Serializable{
    
    private Role role;
    private RoleDao roledao;
    private List<Role> rolelist;
    
      private int page = 1;
    private int listItemCount = 10;

    
    public int sayi(){
    return this.getRoledao().kayitSay();
    }
    
    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        
        int toplamKayit;        
        toplamKayit = this.getRoledao().kayitSay();
        
        if ((this.page*this.listItemCount) >= toplamKayit) {
            return false;
        } else {
            return true;
        }
    }

    public void previous() {
        this.setPage(this.page - 1);
    }

    public void next() {
        this.setPage(this.page + 1);
    }

    
    public String delete(Role roledelete){
        this.getRoledao().delete(roledelete);
        return "/admin/user_role/list?faces-redirect=true";
    }
    
    public String updateForm(Role updaterole){
        this.role=updaterole;
    return "/admin/user_role/update?faces-redirect=true";
    }
    
    public String update(){
        this.getRoledao().update(this.role);
        return "/admin/user_role/list?faces-redirect=true";
    }
    
    public String createForm(){
        this.role=new Role();
        return "/admin/user_role/create?faces-redirect=true";
    }
    
    
    public String create(){
        this.getRoledao().insert(this.role);
        return "/admin/user_role/list?faces-redirect=true";
    }

    public Role getRole() {
        if(this.role==null)
            this.role=new Role();
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public RoleDao getRoledao() {
        if(this.roledao==null)
            this.roledao=new RoleDao();
        return roledao;
    }

    public void setRoledao(RoleDao roledao) {
        this.roledao = roledao;
    }

    public List<Role> getRolelist() {
        this.rolelist=this.getRoledao().findAll();
        return rolelist;
    }

    public void setRolelist(List<Role> rolelist) {
        this.rolelist = rolelist;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getListItemCount() {
        return listItemCount;
    }

    public void setListItemCount(int listItemCount) {
        this.listItemCount = listItemCount;
    }
    
    
}
