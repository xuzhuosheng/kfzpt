package com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * (QysswjXxzxTYwCgjh)实体类
 *
 * @author makejava
 * @since 2019-10-21 11:47:11
 */
public class QysswjXxzxTYwCgjh implements Serializable {
    private static final long serialVersionUID = -11004688003877482L;
    //主键id
    private Integer id;

    private String cgjhmc;

    @JsonFormat (pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createtime;

    private String creater;

    private String zt;

    private String bz;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCgjhmc() {
        return cgjhmc;
    }

    public void setCgjhmc(String cgjhmc) {
        this.cgjhmc = cgjhmc;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
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
