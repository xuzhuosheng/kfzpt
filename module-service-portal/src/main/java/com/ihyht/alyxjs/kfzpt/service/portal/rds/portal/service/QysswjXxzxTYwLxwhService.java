package com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.service;

import com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.model.QysswjXxzxTYwLxwh;

import java.util.List;

/**
 * (QysswjXxzxTYwLxwh)表服务接口
 *
 * @author makejava
 * @since 2019-09-21 09:59:23
 */
public interface QysswjXxzxTYwLxwhService {


    List<QysswjXxzxTYwLxwh> getLxwhList(String searchContent, int pageNum, int pageSize);

    void addLxwh(String lxmc);

    void editLxwh(String id, String lxmc);

    void editLxwhZt(List<String> idList);

    QysswjXxzxTYwLxwh getLxwhById(String id);

    List<QysswjXxzxTYwLxwh> getAllLxwhList();
}
