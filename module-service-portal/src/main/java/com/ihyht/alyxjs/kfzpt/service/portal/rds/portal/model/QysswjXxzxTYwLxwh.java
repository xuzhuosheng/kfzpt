package com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.model;

import com.ihyht.alyxjs.nbjcpt.component.generator.IdEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * (QysswjXxzxTYwLxwh)实体类
 *
 * @author makejava
 * @since 2019-09-21 09:59:21
 */
public class QysswjXxzxTYwLxwh   implements Serializable {
    private static final long serialVersionUID = 808275939804286963L;
    // 主键ID
    private Integer id;
    //类型
    private String lxmc;
    //创建时间
    private Date createtime;
    //状态
    private String zt;
    //备注
    private String bz;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLxmc() {
        return lxmc;
    }

    public void setLxmc(String lxmc) {
        this.lxmc = lxmc;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
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
