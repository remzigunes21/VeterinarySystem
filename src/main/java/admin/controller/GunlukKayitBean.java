/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.GunlukKayitDao;
import admin.entity.GunlukKayitlar;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */
@Named(value="gunlukBean")
@SessionScoped
public class GunlukKayitBean implements Serializable{
    private GunlukKayitlar gunluk_kayit;
    private GunlukKayitDao gunluk_kayitdao;
    private List<GunlukKayitlar> gunluk_kayitlist;

        private int page = 1;
    private int listItemCount = 10;

    
    public int sayi(){
    return this.getGunluk_kayitdao().kayitSay();
    }
    
    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        
        int toplamKayit;        
        toplamKayit = this.getGunluk_kayitdao().kayitSay();
        
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

        this.gunluk_kayit = new GunlukKayitlar();
        return "/admin/gunlukKayitlar/Create?faces-redirect=true";//navigasyon..
    }

    public String create() {
        this.getGunluk_kayitdao().insert(this.gunluk_kayit);//dao sınıfında insert etme...
        return "/admin/gunlukKayitlar/List?faces-redirect=true";
    }

    public String updateForm(GunlukKayitlar updateGunlukKayit) {
        this.gunluk_kayit = updateGunlukKayit;
        return "/admin/gunlukKayitlar/Edit?faces-redirect=true";
    }

    public String update() {
        this.getGunluk_kayitdao().update(this.gunluk_kayit);
        return "/admin/gunlukKayitlar/List?faces-redirect=true";
    }

    public String delete(GunlukKayitlar deleteGunlukKayit) {
        this.getGunluk_kayitdao().delete(deleteGunlukKayit);
        return "/admin/gunlukKayitlar/List?faces-redirect=true";
    }

    public String detailForm(GunlukKayitlar gunlukkayitDetail) {
        this.gunluk_kayit = gunlukkayitDetail;
        return "/admin/gunlukKayitlar/View?faces-redirect=true";
    }

    
    
    public GunlukKayitlar getGunluk_kayit() {
        if(this.gunluk_kayit == null)
            this.gunluk_kayit = new GunlukKayitlar();
        return gunluk_kayit;
    }

    public void setGunluk_kayit(GunlukKayitlar gunluk_kayit) {
        this.gunluk_kayit = gunluk_kayit;
    }

    public GunlukKayitDao getGunluk_kayitdao() {
        if(this.gunluk_kayitdao == null)
            this.gunluk_kayitdao = new GunlukKayitDao();
        return gunluk_kayitdao;
    }

    public void setGunluk_kayitdao(GunlukKayitDao gunluk_kayitdao) {
        this.gunluk_kayitdao = gunluk_kayitdao;
    }

    public List<GunlukKayitlar> getGunluk_kayitlist() {
        this.gunluk_kayitlist = this.getGunluk_kayitdao().findAll(page,listItemCount);
        return gunluk_kayitlist;
    }

    public void setGunluk_kayitlist(List<GunlukKayitlar> gunluk_kayitlist) {
        this.gunluk_kayitlist = gunluk_kayitlist;
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
