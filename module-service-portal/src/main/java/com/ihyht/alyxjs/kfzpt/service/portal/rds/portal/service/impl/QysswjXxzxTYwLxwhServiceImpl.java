package com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.mapper.QysswjXxzxTYwLxwhMapper;
import com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.model.Fw;
import com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.model.QysswjXxzxTYwLxwh;
import com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.service.QysswjXxzxTYwLxwhService;
import com.ihyht.alyxjs.nbjcpt.common.api.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (QysswjXxzxTYwLxwh)表服务实现类
 *
 * @author makejava
 * @since 2019-09-21 09:59:23
 */
@Service ("qysswjXxzxTYwLxwhService")
public class QysswjXxzxTYwLxwhServiceImpl implements QysswjXxzxTYwLxwhService {
    @Resource
    private QysswjXxzxTYwLxwhMapper qysswjXxzxTYwLxwhDao;


    private List<QysswjXxzxTYwLxwh> lxwhList;

    @Override
    public List<QysswjXxzxTYwLxwh> getLxwhList(QysswjXxzxTYwLxwh lxwh, int pageNum, int pageSize) {
        lxwhList = qysswjXxzxTYwLxwhDao.selectAllLxwh(lxwh, pageNum, pageSize);
        return lxwhList;
    }

    @Override
    public boolean addLxwh(String lxmc) {
        boolean flag = true;
        try {
            qysswjXxzxTYwLxwhDao.insertLxwh(lxmc);
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean editLxwh(String id, String lxmc) {
        boolean flag = true;
        try {
            qysswjXxzxTYwLxwhDao.updateLxwh(id, lxmc);
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean editLxwhZt(List<String> idList) {
        boolean flag = true;
        try {
            qysswjXxzxTYwLxwhDao.updateLxwhZt(idList);
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public QysswjXxzxTYwLxwh getLxwhById(String id) {
        QysswjXxzxTYwLxwh ywLxwh = new QysswjXxzxTYwLxwh();
        try {
            ywLxwh = qysswjXxzxTYwLxwhDao.selectOneById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ywLxwh;
    }

    @Override
    public List<QysswjXxzxTYwLxwh> getAllLxwhList() {
        lxwhList = new ArrayList<>();
        try {
            lxwhList = qysswjXxzxTYwLxwhDao.selectAllZyLxwh();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lxwhList;
    }

//    @Override
//    public PageInfo selectLxwhByExample(QysswjXxzxTYwLxwh lxwh, int pageNum, int pageSize) {
////        PageHelper.startPage(pageNum, pageSize);
////        FwExample example =new FwExample();
////        FwExample.Criteria criteria = example.createCriteria();
////
////        ObjectMapper mapper = new ObjectMapper();
////        Map<String, Object> map = mapper.convertValue(fw, Map.class);
////
////        for (Map.Entry<String, Object> entry : map.entrySet()) {
////            if(StringUtils.isNotBlank(entry.getValue()+"")){
////                if("id".equals(entry.getKey())){ criteria.andIdLike("%"+entry.getValue()+"%"); continue; }
////                if("fwmc".equals(entry.getKey())){ criteria.andFwmcLike("%"+entry.getValue()+"%"); continue; }
////                if("fwms".equals(entry.getKey())){ criteria.andFwmsLike("%"+entry.getValue()+"%"); continue; }
////                if("fwflId".equals(entry.getKey())){ criteria.andFwflIdLike("%"+entry.getValue()+"%"); continue; }
////                if("lrrq".equals(entry.getKey())){ criteria.andLrrqEqualTo(new Date((Long)entry.getValue()));
//// continue; }
////                if("xgrq".equals(entry.getKey())){ criteria.andXgrqEqualTo(new Date((Long)entry.getValue()));
//// continue; }
////                if("yxbz".equals(entry.getKey())){ criteria.andYxbzLike("%"+entry.getValue()+"%"); continue; }
////                if("scbz".equals(entry.getKey())){ criteria.andScbzLike("%"+entry.getValue()+"%"); continue; }
////                if("iconId".equals(entry.getKey())){ criteria.andIconIdLike("%"+entry.getValue()+"%"); continue; }
////                if("url".equals(entry.getKey())){ criteria.andUrlLike("%"+entry.getValue()+"%"); continue; }
////                if("xh".equals(entry.getKey())){ criteria.andXhEqualTo((java.lang.Long)entry.getValue()); continue; }
////                if("apiUrl".equals(entry.getKey())){ criteria.andApiUrlLike("%"+entry.getValue()+"%"); continue; }
////                if("pch".equals(entry.getKey())){ criteria.andPchLike("%"+entry.getValue()+"%"); continue; }
////
////            }
////        }
////
////        example.setOrderByClause("id");
//        List<QysswjXxzxTYwLxwh> list = qysswjXxzxTYwLxwhDao.selectAllLxwh2(lxwh, pageNum, pageSize);
//        PageInfo page = new PageInfo(list);
//        return page;
//    }


}
