package com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.service;

import com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.model.QysswjXxzxTYwLbwh;

import java.util.List;

/**
 * (QysswjXxzxTYwLbwh)表服务接口
 *
 * @author makejava
 * @since 2019-09-21 10:03:41
 */
public interface QysswjXxzxTYwLbwhService {


    List<QysswjXxzxTYwLbwh> getYwLbwhList(String lxid, String ppid, String xhid, String lbmc, int kcl, int pageNum,
                                          int pageSize);

    boolean addYwLbwh(String xhid, String xhmc, String lbmc, int fz, float ysdj, int kcl);

    boolean editYwLbwhZt(List<String> idList);

    QysswjXxzxTYwLbwh getYwLbwhById(String id);

    boolean editYwLbwh(String id, String xhid, String xhmc, String kcl, double ysdj);

    List<QysswjXxzxTYwLbwh> getLbwhListAuto();
}
