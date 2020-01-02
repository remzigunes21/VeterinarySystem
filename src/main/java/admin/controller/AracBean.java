/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.AracDao;
import admin.entity.Arac;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */
@Named(value="aracBean")
@SessionScoped
public class AracBean implements Serializable{
    private Arac arac;
    private AracDao aracdao;
    private List<Arac> araclist;

      private int page = 1;
    private int listItemCount = 10;

    
    public int sayi(){
    return this.getAracdao().kayitSay();
    }
    
    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        
        int toplamKayit;        
        toplamKayit = this.getAracdao().kayitSay();
        
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

        this.arac = new Arac();
        return "/admin/arac/Create?faces-redirect=true";//navigasyon..
    }

    public String create() {
        this.getAracdao().insert(this.arac);//dao sınıfında insert etme...
        return "/admin/arac/List?faces-redirect=true";
    }

    public String updateForm(Arac updateArac) {
        this.arac = updateArac;
        return "/admin/arac/Edit?faces-redirect=true";
    }

    public String update() {
        this.getAracdao().update(this.arac);
        return "/admin/arac/List?faces-redirect=true";
    }

    public String delete(Arac deleteArac) {
        this.getAracdao().delete(deleteArac);
        return "/admin/arac/List?faces-redirect=true";
    }

    public String detailForm(Arac aracDetail) {
        this.arac = aracDetail;
        return "/admin/arac/View?faces-redirect=true";
    }
    
    public Arac getArac() {
        if(this.arac == null)
            this.arac = new Arac();
        return arac;
    }

    public void setArac(Arac arac) {
        this.arac = arac;
    }

    public AracDao getAracdao() {
        if(this.aracdao == null)
            this.aracdao = new AracDao();
        return aracdao;
    }

    public void setAracdao(AracDao aracdao) {
        this.aracdao = aracdao;
    }

    public List<Arac> getAraclist() {
        this.araclist=this.getAracdao().findAll(page, listItemCount);
        return araclist;
    }

    public void setAraclist(List<Arac> araclist) {
        this.araclist = araclist;
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
