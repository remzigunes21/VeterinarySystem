/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.VeterinerDao;
import admin.entity.Veteriner;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */
@Named(value="veterinerBean")
@SessionScoped
public class VeterinerBean implements Serializable{
    private Veteriner veteriner;
    private VeterinerDao veterinerdao;
    private List<Veteriner> veterinerlist;
    
    private int page=1;
    private int listItemCount=10;

   public int sayi(){
       return this.getVeterinerdao().kayitSay();
   }
   
   public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        
        int toplamKayit;        
        toplamKayit = this.getVeterinerdao().kayitSay();
        
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

        this.veteriner = new Veteriner();
        return "/admin/veteriner/Create?faces-redirect=true";//navigasyon..
    }

    public String create() {
        this.getVeterinerdao().insert(this.veteriner);//dao sınıfında insert etme...
        return "/admin/veteriner/List?faces-redirect=true";
    }

    public String updateForm(Veteriner updateVeteriner) {
        this.veteriner = updateVeteriner;
        return "/admin/veteriner/Edit?faces-redirect=true";
    }

    public String update() {
        this.getVeterinerdao().update(this.veteriner);
        return "/admin/veteriner/List?faces-redirect=true";
    }

    public String delete(Veteriner deleteVeteriner) {
        this.getVeterinerdao().delete(deleteVeteriner);
        return "/admin/veteriner/List?faces-redirect=true";
    }

    public String detailForm(Veteriner veterinerDetail) {
        this.veteriner = veterinerDetail;
        return "/admin/veteriner/View?faces-redirect=true";
    }

    public Veteriner getVeteriner() {
        if(this.veteriner == null)
            this.veteriner = new Veteriner();
        return veteriner;
    }

    public void setVeteriner(Veteriner veteriner) {
        this.veteriner = veteriner;
    }

    public VeterinerDao getVeterinerdao() {
        if(this.veterinerdao == null)
            this.veterinerdao = new VeterinerDao();
        return veterinerdao;
    }

    public void setVeterinerdao(VeterinerDao veterinerdao) {
        this.veterinerdao = veterinerdao;
    }

    public List<Veteriner> getVeterinerlist() {
         this.veterinerlist = this.getVeterinerdao().findAll(page, listItemCount);
        return veterinerlist;
    }

    public void setVeterinerlist(List<Veteriner> veterinerlist) {
        this.veterinerlist = veterinerlist;
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
