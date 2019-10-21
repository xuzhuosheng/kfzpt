package com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.mapper;

import com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.model.QysswjXxzxTYwLbwh;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (QysswjXxzxTYwLbwh)表数据库访问层
 *
 * @author makejava
 * @since 2019-09-21 10:03:41
 */
public interface QysswjXxzxTYwLbwhMapper {


    List<QysswjXxzxTYwLbwh> selectAllYwLbwhList(@Param ("lxid") String lxid, @Param ("ppid") String ppid,
                                                @Param ("xhid") String xhid, @Param ("lbmc") String lbmc,
                                                @Param ("kcl") int kcl, @Param ("pageNum") int pageNum, @Param (
                                                        "pageSize") int pageSize);

    void insertYwLbwh(@Param ("xhid") String xhid, @Param ("xhmc") String xhmc,
                      @Param ("lbmc") String lbmc, @Param ("fz") int fz,
                      @Param ("ysdj") float ysdj, @Param ("kcl") int kcl);

    void updateYwLbwhZt(@Param ("idList") List<String> idList);

    QysswjXxzxTYwLbwh selectYwLbwhById(@Param ("id") String id);
}
