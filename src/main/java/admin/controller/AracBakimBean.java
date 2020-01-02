/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.AracBakimDao;
import admin.entity.AracBakim;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */
@Named(value="aracbakimBean")
@SessionScoped
public class AracBakimBean implements Serializable{
    private AracBakim arac_bakim;
    private AracBakimDao arac_bakimdao;
    private List<AracBakim> arac_bakimlist;
    
    
    private int page = 1;
    private int listItemCount = 10;

    
    public int sayi(){
    return this.getArac_bakimdao().kayitSay();
    }
    
    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        
        int toplamKayit;        
        toplamKayit = this.getArac_bakimdao().kayitSay();
        
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

        this.arac_bakim = new AracBakim();
        return "/admin/aracBakim/Create?faces-redirect=true";//navigasyon..
    }

    public String create() {
        this.getArac_bakimdao().insert(this.arac_bakim);//dao sınıfında insert etme...
        return "/admin/aracBakim/List?faces-redirect=true";
    }

    public String updateForm(AracBakim updateBakim) {
        this.arac_bakim = updateBakim;
        return "/admin/aracBakim/Edit?faces-redirect=true";
    }

    public String update() {
        this.getArac_bakimdao().update(this.arac_bakim);
        return "/admin/aracBakim/List?faces-redirect=true";
    }

    public String delete(AracBakim deleteBakim) {
        this.getArac_bakimdao().delete(deleteBakim);
        return "/admin/aracBakim/List?faces-redirect=true";
    }

    public String detailForm(AracBakim bakimDetail) {
        this.arac_bakim = bakimDetail;
        return "/admin/aracBakim/View?faces-redirect=true";
    }

    public AracBakim getArac_bakim() {
        if(this.arac_bakim == null)
            this.arac_bakim = new AracBakim();
        return arac_bakim;
    }

    public void setArac_bakim(AracBakim arac_bakim) {
        this.arac_bakim = arac_bakim;
    }

    public AracBakimDao getArac_bakimdao() {
        if(this.arac_bakimdao == null)
            this.arac_bakimdao = new AracBakimDao();
        return arac_bakimdao;
    }

    public void setArac_bakimdao(AracBakimDao arac_bakimdao) {
        this.arac_bakimdao = arac_bakimdao;
    }

    public List<AracBakim> getArac_bakimlist() {
        
        this.arac_bakimlist= this.getArac_bakimdao().findAll(page, listItemCount);
        return arac_bakimlist;
    }

    public void setArac_bakimlist(List<AracBakim> arac_bakimlist) {
        this.arac_bakimlist = arac_bakimlist;
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
