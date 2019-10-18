package com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.model;

import java.io.Serializable;

/**
 * (QysswjXxzxTYwLbwh)实体类
 *
 * @author makejava
 * @since 2019-10-09 16:15:50
 */
public class QysswjXxzxTYwLbwh implements Serializable {
    private static final long serialVersionUID = 928059917111626878L;
    //主键id
    private Integer id;
    //类别名称
    private String lbmc;
    //预算单价
    private String ysdj;

    private Integer kcl;

    private String xhid;

    private String xhmc;
    //创建时间
    private Object createtime;
    //状态
    private String zt;
    //备注
    private String bz;

    /*显示需要*/

    private String lxid; //类型id
    private String lxmc; //类型名称
    private String ppid; //品牌id
    private String ppmc; //品牌名称

    public String getLxid() {
        return lxid;
    }

    public void setLxid(String lxid) {
        this.lxid = lxid;
    }

    public String getLxmc() {
        return lxmc;
    }

    public void setLxmc(String lxmc) {
        this.lxmc = lxmc;
    }

    public String getPpid() {
        return ppid;
    }

    public void setPpid(String ppid) {
        this.ppid = ppid;
    }

    public String getPpmc() {
        return ppmc;
    }

    public void setPpmc(String ppmc) {
        this.ppmc = ppmc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLbmc() {
        return lbmc;
    }

    public void setLbmc(String lbmc) {
        this.lbmc = lbmc;
    }

    public String getYsdj() {
        return ysdj;
    }

    public void setYsdj(String ysdj) {
        this.ysdj = ysdj;
    }

    public Integer getKcl() {
        return kcl;
    }

    public void setKcl(Integer kcl) {
        this.kcl = kcl;
    }

    public String getXhid() {
        return xhid;
    }

    public void setXhid(String xhid) {
        this.xhid = xhid;
    }

    public String getXhmc() {
        return xhmc;
    }

    public void setXhmc(String xhmc) {
        this.xhmc = xhmc;
    }

    public Object getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Object createtime) {
        this.createtime = createtime;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

}
