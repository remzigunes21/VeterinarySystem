/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.ElemanDao;
import admin.entity.SahaElemani;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */
@Named(value = "elemanBean")
@SessionScoped
public class ElemanBean implements Serializable {

    private SahaElemani eleman;
    private ElemanDao elemandao;
    private List<SahaElemani> elemanlist;

    private int page = 1;
    private int listItemCount = 10;

    public int sayi() {
        return this.getElemandao().kayitSay();
    }

    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {

        int toplamKayit;
        toplamKayit = this.getElemandao().kayitSay();

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

        this.eleman = new SahaElemani();
        return "/admin/sahaElemani/Create?faces-redirect=true";//navigasyon..
    }

    public String create() {
        this.getElemandao().insert(this.eleman);//dao sınıfında insert etme...
        return "/admin/sahaElemani/List?faces-redirect=true";
    }

    public String updateForm(SahaElemani updateEleman) {
        this.eleman = updateEleman;
        return "/admin/sahaElemani/Edit?faces-redirect=true";
    }

    public String update() {
        this.getElemandao().update(this.eleman);
        return "/admin/sahaElemani/List?faces-redirect=true";
    }

    public String delete(SahaElemani deleteEleman) {
        this.getElemandao().delete(deleteEleman);
        return "/admin/sahaElemani/List?faces-redirect=true";
    }

    public String detailForm(SahaElemani elemanDetail) {
        this.eleman = elemanDetail;
        return "/admin/sahaElemani/View?faces-redirect=true";
    }

    public SahaElemani getEleman() {
        if(this.eleman == null)
            this.eleman = new SahaElemani();
        return eleman;
    }

    public void setEleman(SahaElemani eleman) {
        this.eleman = eleman;
    }

    public ElemanDao getElemandao() {
        if(this.elemandao == null)
            this.elemandao = new ElemanDao();
        return elemandao;
    }

    public void setElemandao(ElemanDao elemandao) {
        this.elemandao = elemandao;
    }

    public List<SahaElemani> getElemanlist() {
        this.elemanlist = this.getElemandao().findAll(page,listItemCount);
        return elemanlist;
    }

    public void setElemanlist(List<SahaElemani> elemanlist) {
        this.elemanlist = elemanlist;
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
