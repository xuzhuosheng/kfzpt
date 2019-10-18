package com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.service.impl;

import com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.mapper.QysswjXxzxTYwPpwhMapper;
import com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.model.QysswjXxzxTYwPpwh;
import com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.service.QysswjXxzxTYwPpwhService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (QysswjXxzxTYwPpwh)表服务实现类
 *
 * @author makejava
 * @since 2019-09-21 10:01:41
 */
@Service ("qysswjXxzxTYwPpwhService")
public class QysswjXxzxTYwPpwhServiceImpl implements QysswjXxzxTYwPpwhService {
    @Resource
    private QysswjXxzxTYwPpwhMapper qysswjXxzxTYwPpwhDao;

    private List<QysswjXxzxTYwPpwh> ppwhList;

    @Override
    public List<QysswjXxzxTYwPpwh> getPpwhList(String lxid, String ppmc, int pageNum, int pageSize) {
        ppwhList = qysswjXxzxTYwPpwhDao.selectAllPpwh(lxid, ppmc, pageNum, pageSize);
        return ppwhList;
    }

    @Override
    public void addPpwh(String lxid, String lxmc, String ppmc) {
        qysswjXxzxTYwPpwhDao.insertPpwh(lxid, lxmc, ppmc);
    }

    @Override
    public void editPpwh(String id, String ppmc, String lxid, String lxmc) {
        qysswjXxzxTYwPpwhDao.updatePpwh(id, ppmc, lxid, lxmc);
    }

    @Override
    public void editPpwhZt(List<String> idList) {
        qysswjXxzxTYwPpwhDao.updatePpwhZt(idList);
    }

    @Override
    public QysswjXxzxTYwPpwh getPpwhById(String id) {
        QysswjXxzxTYwPpwh qysswjXxzxTYwPpwh = new QysswjXxzxTYwPpwh();
        qysswjXxzxTYwPpwh = qysswjXxzxTYwPpwhDao.selectOneById(id);
        return qysswjXxzxTYwPpwh;
    }

    @Override
    public List<QysswjXxzxTYwPpwh> getPpwhListByLxid(String lxid) {
        ppwhList = qysswjXxzxTYwPpwhDao.selectAllPpwhByLxid(lxid);
        return ppwhList;
    }

//    @Override
//    public int addPpwh(String ppmc) {
//
//        int id = qysswjXxzxTYwPpwhDao.insertPpwh(ppmc);
//        return id;
//    }
}
