/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.KayitDao;
import admin.entity.Kayit;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */
@Named(value = "kayitBean")
@SessionScoped
public class KayitBean implements Serializable {

    private Kayit kayit;
    private KayitDao kayitdao;
    private List<Kayit> kayitlist;

    private int page = 1;
    private int listItemCount = 10;

    public int sayi() {
        return this.getKayitdao().kayitSay();
    }

    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {

        int toplamKayit;
        toplamKayit = this.getKayitdao().kayitSay();

        if ((this.page * this.listItemCount) >= toplamKayit) {
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

        this.kayit = new Kayit();
        return "/admin/kayit/Create?faces-redirect=true";//navigasyon..
    }

    public String create() {
        this.getKayitdao().insert(this.kayit);//dao sınıfında insert etme...
        return "/admin/kayit/List?faces-redirect=true";
    }

    public String updateForm(Kayit updateKayit) {
        this.kayit = updateKayit;
        return "/admin/kayit/Edit?faces-redirect=true";
    }

    public String update() {
        this.getKayitdao().update(this.kayit);
        return "/admin/kayit/List?faces-redirect=true";
    }

    public String delete(Kayit deleteKayit) {
        this.getKayitdao().delete(deleteKayit);
        return "/admin/kayit/List?faces-redirect=true";
    }

    public String detailForm(Kayit kayitDetail) {
        this.kayit = kayitDetail;
        return "/admin/kayit/View?faces-redirect=true";
    }

    public Kayit getKayit() {
        if (this.kayit == null) {
            this.kayit = new Kayit();
        }
        return kayit;
    }

    public void setKayit(Kayit kayit) {
        this.kayit = kayit;
    }

    public KayitDao getKayitdao() {
        if (this.kayitdao == null) {
            this.kayitdao = new KayitDao();
        }
        return kayitdao;
    }

    public void setKayitdao(KayitDao kayitdao) {
        this.kayitdao = kayitdao;
    }

    public List<Kayit> getKayitlist() {
        this.kayitlist = this.getKayitdao().findAll(page,listItemCount);
        return kayitlist;
    }

    public void setKayitlist(List<Kayit> kayitlist) {
        this.kayitlist = kayitlist;
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
