/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.UserDao;
import admin.entity.User;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */
@Named(value="userBean")
@SessionScoped
public class UserBean implements Serializable{
    private User user;
    private UserDao userdao;
    private List<User> userlist;

      private int page = 1;
    private int listItemCount = 10;

    
    public int sayi(){
    return this.getUserdao().kayitSay();
    }
    
    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        
        int toplamKayit;        
        toplamKayit = this.getUserdao().kayitSay();
        
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

    public String createForm() {

        this.user = new User();
        return "/admin/doktor/create?faces-redirect=true";//navigasyon..
    }

    public String create() {
        this.getUserdao().insert(this.user);//dao sınıfında insert etme...
        return "/admin/doktor/list?faces-redirect=true";
    }

    public String updateForm(User updateUser) {
        this.user = updateUser;
        return "/admin/doktor/update?faces-redirect=true";
    }

    public String update() {
        this.getUserdao().update(this.user);
        return "/admin/doktor/list?faces-redirect=true";
    }

    public String delete(User deleteUser) {
        this.getUserdao().delete(deleteUser);
        return "/admin/doktor/list?faces-redirect=true";
    }

    public String detailForm(User userDetail) {
        this.user = userDetail;
        return "/admin/doktor/detail?faces-redirect=true";
    }

    public User getUser() {
        if(this.user == null)
            this.user = new User();
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDao getUserdao() {
        if(this.userdao == null)
            this.userdao = new UserDao();
        return userdao;
    }

    public void setUserdao(UserDao userdao) {
        this.userdao = userdao;
    }

    public List<User> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<User> userlist) {
        this.userlist = userlist;
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
