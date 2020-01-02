/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.StokDao;
import admin.entity.Stok;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */
@Named(value="stokBean")
@SessionScoped
public class StokBean implements Serializable{
    private Stok stok;
    private StokDao stokdao;
    private List<Stok> stoklist;
  private int page = 1;
    private int listItemCount = 10;

    
    public int sayi(){
    return this.getStokdao().kayitSay();
    }
    
    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        
        int toplamKayit;        
        toplamKayit = this.getStokdao().kayitSay();
        
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

        this.stok = new Stok();
        return "/admin/stok/Create?faces-redirect=true";//navigasyon..
    }

    public String create() {
        this.getStokdao().insert(this.stok);//dao sınıfında insert etme...
        return "/admin/stok/List?faces-redirect=true";
    }

    public String updateForm(Stok updateStok) {
        this.stok = updateStok;
        return "/admin/stok/Edit?faces-redirect=true";
    }

    public String update() {
        this.getStokdao().update(this.stok);
        return "/admin/stok/List?faces-redirect=true";
    }

    public String delete(Stok deleteStok) {
        this.getStokdao().delete(deleteStok);
        return "/admin/stok/List?faces-redirect=true";
    }

    public String detailForm(Stok stokDetail) {
        this.stok = stokDetail;
        return "/admin/stok/View?faces-redirect=true";
    }

    public Stok getStok() {
        if(this.stok == null)
            this.stok = new Stok();
        return stok;
    }

    public void setStok(Stok stok) {
        this.stok = stok;
    }

    public StokDao getStokdao() {
        if(this.stokdao == null)
            this.stokdao = new StokDao();
        return stokdao;
    }

    public void setStokdao(StokDao stokdao) {
        this.stokdao = stokdao;
    }

    public List<Stok> getStoklist() {
        this.stoklist = this.getStokdao().findAll(page,listItemCount);
        return stoklist;
    }

    public void setStoklist(List<Stok> stoklist) {
        this.stoklist = stoklist;
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
