/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.BelediyeDao;
import admin.entity.Belediye;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */
@Named(value="belediyeBean")
@SessionScoped
public class BelediyeBean implements Serializable{
    private Belediye belediye;
    private BelediyeDao belediyedao;
    private List<Belediye> belediyelist;
    
     private int page = 1;
    private int listItemCount = 10;

    
    public int sayi(){
    return this.getBelediyedao().kayitSay();
    }
    
    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        
        int toplamKayit;        
        toplamKayit = this.getBelediyedao().kayitSay();
        
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

        this.belediye = new Belediye();
        return "/admin/belediye/Create?faces-redirect=true";//navigasyon..
    }

    public String create() {
        this.getBelediyedao().insert(this.belediye);//dao sınıfında insert etme...
        return "/admin/belediye/List?faces-redirect=true";
    }

    public String updateForm(Belediye updateBelediye) {
        this.belediye = updateBelediye;
        return "/admin/belediye/Edit?faces-redirect=true";
    }

    public String update() {
        this.getBelediyedao().update(this.belediye);
        return "/admin/belediye/List?faces-redirect=true";
    }

    public String delete(Belediye deleteBelediye) {
        this.getBelediyedao().delete(deleteBelediye);
        return "/admin/belediye/List?faces-redirect=true";
    }

    public String detailForm(Belediye doktorBelediye) {
        this.belediye = doktorBelediye;
        return "/admin/belediye/View?faces-redirect=true";
    }

    public Belediye getBelediye() {
        if(this.belediye == null)
            this.belediye = new Belediye();
        return belediye;
    }

    public void setBelediye(Belediye belediye) {
        this.belediye = belediye;
    }

    public BelediyeDao getBelediyedao() {
        if(this.belediyedao == null)
            this.belediyedao = new BelediyeDao();
        return belediyedao;
    }

    public void setBelediyedao(BelediyeDao belediyedao) {
        this.belediyedao = belediyedao;
    }

    public List<Belediye> getBelediyelist() {
        this.belediyelist = this.getBelediyedao().findAll(page,listItemCount);
        return belediyelist;
    }

    public void setBelediyelist(List<Belediye> belediyelist) {
        this.belediyelist = belediyelist;
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
