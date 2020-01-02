/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.SekreterDao;
import admin.entity.BilgiIslemSekreteri;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */
@Named(value="sekreterBean")
@SessionScoped
public class SekreterBean implements Serializable{
    private BilgiIslemSekreteri sekreter;
    private SekreterDao sekreterdao;
    private List<BilgiIslemSekreteri> sekreterlist;

      private int page = 1;
    private int listItemCount = 10;

    
    public int sayi(){
    return this.getSekreterdao().kayitSay();
    }
    
    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        
        int toplamKayit;        
        toplamKayit = this.getSekreterdao().kayitSay();
        
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

        this.sekreter = new BilgiIslemSekreteri();
        return "/admin/bilgiIslemSekreteri/Create?faces-redirect=true";//navigasyon..
    }

    public String create() {
        this.getSekreterdao().insert(this.sekreter);//dao sınıfında insert etme...
        return "/admin/bilgiIslemSekreteri/List?faces-redirect=true";
    }

    public String updateForm(BilgiIslemSekreteri updateSekreter) {
        this.sekreter = updateSekreter;
        return "/admin/bilgiIslemSekreteri/Edit?faces-redirect=true";
    }

    public String update() {
        this.getSekreterdao().update(this.sekreter);
        return "/admin/bilgiIslemSekreteri/List?faces-redirect=true";
    }

    public String delete(BilgiIslemSekreteri deleteSekreter) {
        this.getSekreterdao().delete(deleteSekreter);
        return "/admin/bilgiIslemSekreteri/List?faces-redirect=true";
    }

    public String detailForm(BilgiIslemSekreteri sekreterDetail) {
        this.sekreter = sekreterDetail;
        return "/admin/bilgiIslemSekreteri/View?faces-redirect=true";
    }

    
    public BilgiIslemSekreteri getSekreter() {
        if(this.sekreter == null)
            this.sekreter = new BilgiIslemSekreteri();
        return sekreter;
    }

    public void setSekreter(BilgiIslemSekreteri sekreter) {
        this.sekreter = sekreter;
    }

    public SekreterDao getSekreterdao() {
        if(this.sekreterdao == null)
            this.sekreterdao = new SekreterDao();
        return sekreterdao;
    }

    public void setSekreterdao(SekreterDao sekreterdao) {
        this.sekreterdao = sekreterdao;
    }

    public List<BilgiIslemSekreteri> getSekreterlist() {
        this.sekreterlist = this.getSekreterdao().findAll(page,listItemCount);
        return sekreterlist;
    }

    public void setSekreterlist(List<BilgiIslemSekreteri> sekreterlist) {
        this.sekreterlist = sekreterlist;
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
