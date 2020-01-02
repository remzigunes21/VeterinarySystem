/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.TeknisyenDao;
import admin.entity.Teknisyen;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */
@Named(value="teknisyenBean")
@SessionScoped
public class TeknisyenBean implements Serializable{
    private Teknisyen teknisyen;
    private TeknisyenDao teknisyendao;
    private List<Teknisyen> teknisyenlist;
  private int page = 1;
    private int listItemCount = 10;

    
    public int sayi(){
    return this.getTeknisyendao().kayitSay();
    }
    
    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        
        int toplamKayit;        
        toplamKayit = this.getTeknisyendao().kayitSay();
        
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

        this.teknisyen = new Teknisyen();
        return "/admin/teknisyen/Create?faces-redirect=true";//navigasyon..
    }

    public String create() {
        this.getTeknisyendao().insert(this.teknisyen);//dao sınıfında insert etme...
        return "/admin/teknisyen/List?faces-redirect=true";
    }

    public String updateForm(Teknisyen updateTeknisyen) {
        this.teknisyen = updateTeknisyen;
        return "/admin/teknisyen/Edit?faces-redirect=true";
    }

    public String update() {
        this.getTeknisyendao().update(this.teknisyen);
        return "/admin/teknisyen/List?faces-redirect=true";
    }

    public String delete(Teknisyen deleteTeknisyen) {
        this.getTeknisyendao().delete(deleteTeknisyen);
        return "/admin/teknisyen/List?faces-redirect=true";
    }

    public String detailForm(Teknisyen teknisyenDetail) {
        this.teknisyen = teknisyenDetail;
        return "/admin/teknisyen/View?faces-redirect=true";
    }

    public Teknisyen getTeknisyen() {
        if(this.teknisyen == null)
            this.teknisyen = new Teknisyen();
        return teknisyen;
    }

    public void setTeknisyen(Teknisyen teknisyen) {
        this.teknisyen = teknisyen;
    }

    public TeknisyenDao getTeknisyendao() {
        if(this.teknisyendao == null)
            this.teknisyendao = new TeknisyenDao();
        return teknisyendao;
    }

    public void setTeknisyendao(TeknisyenDao teknisyendao) {
        this.teknisyendao = teknisyendao;
    }

    public List<Teknisyen> getTeknisyenlist() {
        this.teknisyenlist = this.getTeknisyendao().findAll(page,listItemCount);
        return teknisyenlist;
    }

    public void setTeknisyenlist(List<Teknisyen> teknisyenlist) {
        this.teknisyenlist = teknisyenlist;
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
