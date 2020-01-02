/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.SoforDao;
import admin.entity.Sofor;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */
@Named(value="soforBean")
@SessionScoped
public class SoforBean implements Serializable{
    private Sofor sofor;
    private SoforDao sofordao;
    private List<Sofor> soforlist;

      private int page = 1;
    private int listItemCount = 10;

    
    public int sayi(){
    return this.getSofordao().kayitSay();
    }
    
    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        
        int toplamKayit;        
        toplamKayit = this.getSofordao().kayitSay();
        
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

        this.sofor = new Sofor();
        return "/admin/sofor/Create?faces-redirect=true";//navigasyon..
    }

    public String create() {
        this.getSofordao().insert(this.sofor);//dao sınıfında insert etme...
        return "/admin/sofor/List?faces-redirect=true";
    }

    public String updateForm(Sofor updateSofor) {
        this.sofor = updateSofor;
        return "/admin/sofor/Edit?faces-redirect=true";
    }

    public String update() {
        this.getSofordao().update(this.sofor);
        return "/admin/sofor/List?faces-redirect=true";
    }

    public String delete(Sofor deleteSofor) {
        this.getSofordao().delete(deleteSofor);
        return "/admin/sofor/List?faces-redirect=true";
    }

    public String detailForm(Sofor soforDetail) {
        this.sofor = soforDetail;
        return "/admin/sofor/View?faces-redirect=true";
    }

    
    public Sofor getSofor() {
        if(this.sofor == null)
            this.sofor = new Sofor();
        return sofor;
    }

    public void setSofor(Sofor sofor) {
        this.sofor = sofor;
    }

    public SoforDao getSofordao() {
        if(this.sofordao == null)
            this.sofordao = new SoforDao();
        return sofordao;
    }

    public void setSofordao(SoforDao sofordao) {
        this.sofordao = sofordao;
    }

    public List<Sofor> getSoforlist() {
        this.soforlist = this.getSofordao().findAl(page,listItemCount);
        return soforlist;
    }

    public void setSoforlist(List<Sofor> soforlist) {
        this.soforlist = soforlist;
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
