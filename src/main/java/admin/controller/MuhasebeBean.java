/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.MuhasebeDao;
import admin.entity.Muhasebeci;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */
@Named(value = "muhasebeBean")
@SessionScoped
public class MuhasebeBean implements Serializable {

    private Muhasebeci muhasebe;
    private MuhasebeDao muhasebedao;
    private List<Muhasebeci> muhasebelist;

    private int page = 1;
    private int listItemCount = 10;

    public int sayi() {
        return this.getMuhasebedao().kayitSay();
    }

    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {

        int toplamKayit;
        toplamKayit = this.getMuhasebedao().kayitSay();

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

        this.muhasebe = new Muhasebeci();
        return "/admin/muhasebeci/Create?faces-redirect=true";//navigasyon..
    }

    public String create() {
        this.getMuhasebedao().insert(this.muhasebe);//dao sınıfında insert etme...
        return "/admin/muhasebeci/List?faces-redirect=true";
    }

    public String updateForm(Muhasebeci updateMuhasebeci) {
        this.muhasebe = updateMuhasebeci;
        return "/admin/muhasebeci/Edit?faces-redirect=true";
    }

    public String update() {
        this.getMuhasebedao().update(this.muhasebe);
        return "/admin/muhasebeci/List?faces-redirect=true";
    }

    public String delete(Muhasebeci deleteMuhasebeci) {
        this.getMuhasebedao().delete(deleteMuhasebeci);
        return "/admin/muhasebeci/List?faces-redirect=true";
    }

    public String detailForm(Muhasebeci muhasebeDetail) {
        this.muhasebe = muhasebeDetail;
        return "/admin/muhasebeci/View?faces-redirect=true";
    }

    public Muhasebeci getMuhasebe() {
        if (this.muhasebe == null) {
            this.muhasebe = new Muhasebeci();
        }
        return muhasebe;
    }

    public void setMuhasebe(Muhasebeci muhasebe) {
        this.muhasebe = muhasebe;
    }

    public MuhasebeDao getMuhasebedao() {
        if (this.muhasebedao == null) {
            this.muhasebedao = new MuhasebeDao();
        }
        return muhasebedao;
    }

    public void setMuhasebedao(MuhasebeDao muhasebedao) {
        this.muhasebedao = muhasebedao;
    }

    public List<Muhasebeci> getMuhasebelist() {
        this.muhasebelist = this.getMuhasebedao().findAll(page,listItemCount);
        return muhasebelist;
    }

    public void setMuhasebelist(List<Muhasebeci> muhasebelist) {
        this.muhasebelist = muhasebelist;
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
