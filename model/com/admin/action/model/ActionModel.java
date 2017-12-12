package com.admin.action.model;

public class ActionModel {
    private Integer aid;

    private Integer paid;

    private Integer sortid;

    private String adescribe;

    private String awindow;

    private String navigateurl;

    private String parm;

    private String version;

    private String actiontype;

    private String carea;

    private String cisvisible;

    private Integer role;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getPaid() {
        return paid;
    }

    public void setPaid(Integer paid) {
        this.paid = paid;
    }

    public Integer getSortid() {
        return sortid;
    }

    public void setSortid(Integer sortid) {
        this.sortid = sortid;
    }

    public String getAdescribe() {
        return adescribe;
    }

    public void setAdescribe(String adescribe) {
        this.adescribe = adescribe == null ? null : adescribe.trim();
    }

    public String getAwindow() {
        return awindow;
    }

    public void setAwindow(String awindow) {
        this.awindow = awindow == null ? null : awindow.trim();
    }

    public String getNavigateurl() {
        return navigateurl;
    }

    public void setNavigateurl(String navigateurl) {
        this.navigateurl = navigateurl == null ? null : navigateurl.trim();
    }

    public String getParm() {
        return parm;
    }

    public void setParm(String parm) {
        this.parm = parm == null ? null : parm.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getActiontype() {
        return actiontype;
    }

    public void setActiontype(String actiontype) {
        this.actiontype = actiontype == null ? null : actiontype.trim();
    }

    public String getCarea() {
        return carea;
    }

    public void setCarea(String carea) {
        this.carea = carea == null ? null : carea.trim();
    }

    public String getCisvisible() {
        return cisvisible;
    }

    public void setCisvisible(String cisvisible) {
        this.cisvisible = cisvisible == null ? null : cisvisible.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}