/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.YetkiDao;
import admin.entity.Yetkilendirme;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */
@Named(value="yetkiBean")
@SessionScoped
public class YetkiBean implements Serializable{
    private Yetkilendirme yetki;
    private YetkiDao yetkidao;
    private List<Yetkilendirme> yetkilist;

      private int page = 1;
    private int listItemCount = 10;

    
    public int sayi(){
    return this.getYetkidao().kayitSay();
    }
    
    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        
        int toplamKayit;        
        toplamKayit = this.getYetkidao().kayitSay();
        
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

        this.yetki = new Yetkilendirme();
        return "/admin/yetkilendirme/Create?faces-redirect=true";//navigasyon..
    }

    public String create() {
        this.getYetkidao().insert(this.yetki);//dao sınıfında insert etme...
        return "/admin/yetkilendirme/List?faces-redirect=true";
    }

    public String updateForm(Yetkilendirme updateYetki) {
        this.yetki = updateYetki;
        return "/admin/yetkilendirme/Edit?faces-redirect=true";
    }

    public String update() {
        this.getYetkidao().update(this.yetki);
        return "/admin/yetkilendirme/List?faces-redirect=true";
    }

    public String delete(Yetkilendirme deleteYetki) {
        this.getYetkidao().delete(deleteYetki);
        return "/admin/yetkilendirme/List?faces-redirect=true";
    }

    public String detailForm(Yetkilendirme yetkiDetail) {
        this.yetki = yetkiDetail;
        return "/admin/yetkilendirme/View?faces-redirect=true";
    }

    public Yetkilendirme getYetki() {
        if(this.yetki == null)
            this.yetki=new Yetkilendirme();
        return yetki;
    }

    public void setYetki(Yetkilendirme yetki) {
        this.yetki = yetki;
    }

    public YetkiDao getYetkidao() {
        if(this.yetkidao == null)
            this.yetkidao=new YetkiDao();
        return yetkidao;
    }

    public void setYetkidao(YetkiDao yetkidao) {
        this.yetkidao = yetkidao;
    }

    public List<Yetkilendirme> getYetkilist() {
        this.yetkilist = this.getYetkidao().findAll(page,listItemCount);
        return yetkilist;
    }

    public void setYetkilist(List<Yetkilendirme> yetkilist) {
        this.yetkilist = yetkilist;
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
