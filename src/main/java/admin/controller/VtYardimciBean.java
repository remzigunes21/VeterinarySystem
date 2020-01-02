/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.V_yrdDao;
import admin.entity.VtYardimci;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */
@Named(value="yardimciBean")
@SessionScoped
public class VtYardimciBean implements Serializable{
    
    private VtYardimci yardimci;
    private V_yrdDao yardimcidao;
    private List<VtYardimci> yardimcilist;

      private int page = 1;
    private int listItemCount = 10;

    
    public int sayi(){
    return this.getYardimcidao().kayitSay();
    }
    
    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        
        int toplamKayit;        
        toplamKayit = this.getYardimcidao().kayitSay();
        
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

        this.yardimci = new VtYardimci();
        return "/admin/vtYardimci/Create?faces-redirect=true";//navigasyon..
    }

    public String create() {
        this.getYardimcidao().insert(this.yardimci);//dao sınıfında insert etme...
        return "/admin/vtYardimci/List?faces-redirect=true";
    }

    public String updateForm(VtYardimci updateYardimci) {
        this.yardimci = updateYardimci;
        return "/admin/vtYardimci/Edit?faces-redirect=true";
    }

    public String update() {
        this.getYardimcidao().update(this.yardimci);
        return "/admin/vtYardimci/List?faces-redirect=true";
    }

    public String delete(VtYardimci deleteYardimci) {
        this.getYardimcidao().delete(deleteYardimci);
        return "/admin/vtYardimci/List?faces-redirect=true";
    }

    public String detailForm(VtYardimci yardimciDetail) {
        this.yardimci = yardimciDetail;
        return "/admin/vtYardimci/View?faces-redirect=true";
    }

    public VtYardimci getYardimci() {
        if(this.yardimci == null)
            this.yardimci = new VtYardimci();
        return yardimci;
    }

    public void setYardimci(VtYardimci yardimci) {
        this.yardimci = yardimci;
    }

    public V_yrdDao getYardimcidao() {
        if(this.yardimcidao == null)
            this.yardimcidao = new V_yrdDao();
        return yardimcidao;
    }

    public void setYardimcidao(V_yrdDao yardimcidao) {
        this.yardimcidao = yardimcidao;
    }

    public List<VtYardimci> getYardimcilist() {
        this.yardimcilist = this.getYardimcidao().findAll(page,listItemCount);
        return yardimcilist;
    }

    public void setYardimcilist(List<VtYardimci> yardimcilist) {
        this.yardimcilist = yardimcilist;
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
