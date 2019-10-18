package com.ihyht.alyxjs.kfzpt.portal.console;

import com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.model.QysswjXxzxTYwPpwh;
import com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.service.QysswjXxzxTYwPpwhService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * (QysswjXxzxTYwPpwh)表控制层
 *
 * @author makejava
 * @since 2019-09-21 10:01:41
 */
@Api (value = "耗材管理", description = "品牌维护类")
@RestController
@RequestMapping ("/Ppwh")
@PropertySource ("classpath:application.properties")
public class QysswjXxzxTYwPpwhController {
    /**
     * 服务对象
     */
    @Resource
    private QysswjXxzxTYwPpwhService qysswjXxzxTYwPpwhService;


    private List<QysswjXxzxTYwPpwh> ppwhList;

    @Value ("${pageSize}")
    private int pageSize;


    @ApiOperation (value = "获取所有在用品牌，并且分页", notes = "1.返回List。2.页码大于0,分页 ")
    @ApiImplicitParams ({
            @ApiImplicitParam (name = "lxid", value = "类型id,通过下拉方式获取到类型id", paramType = "query", required = false),
            @ApiImplicitParam (name = "ppmc", value = "品牌名称", paramType = "query", required = false),
            @ApiImplicitParam (name = "pageNum", value = "页码", paramType = "query", required = true)
    })
    @ApiResponse (code = 400, message = "参数没有填好", response = String.class)
    @RequestMapping (value = "/getPpwhList", method = RequestMethod.POST)
    @ResponseBody
    public List<QysswjXxzxTYwPpwh> getPpwhList(@RequestParam (required = false) String lxid,
                                               @RequestParam (required = false) String ppmc,
                                               @RequestParam (required = true) int pageNum
    ) {
        ppwhList = new ArrayList<>();
        try {
            ppwhList = qysswjXxzxTYwPpwhService.getPpwhList(lxid, ppmc, pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ppwhList;
    }

    @ApiOperation (value = "新增后保存", notes = "返回字符串，成功返回success，失败返回error")
    @ApiImplicitParams ({
            @ApiImplicitParam (name = "lxid", value = "类型id", paramType = "query", required = true),
            @ApiImplicitParam (name = "lxmc", value = "类型名称", paramType = "query", required = true),
            @ApiImplicitParam (name = "ppmc", value = "品牌名称", paramType = "query", required = true)
    })
    @ApiResponse (code = 400, message = "参数没有填好", response = String.class)
    @RequestMapping (value = "/addPpwh", method = RequestMethod.POST)
    @ResponseBody
    public String addPpwh(@RequestParam (required = true) String lxid,
                          @RequestParam (required = true) String lxmc,
                          @RequestParam (required = true) String ppmc) {
        String resultStr = "success";
        try {
            qysswjXxzxTYwPpwhService.addPpwh(lxid, lxmc, ppmc);
        } catch (Exception e) {
            resultStr = "error";
            e.printStackTrace();
        }

        return resultStr;

    }

    @ApiOperation (value = "根据id获取品牌信息", notes = "返回品牌对象")
    @ApiImplicitParams ({
            @ApiImplicitParam (name = "id", value = "品牌主键id", paramType = "query", required = true)
    })
    @ApiResponse (code = 400, message = "参数没有填好", response = String.class)
    @RequestMapping (value = "/getPpwhById", method = RequestMethod.POST)
    @ResponseBody
    public QysswjXxzxTYwPpwh getPpwhById(@RequestParam (required = true) String id) {
        QysswjXxzxTYwPpwh qysswjXxzxTYwPpwh = new QysswjXxzxTYwPpwh();
        try {
            qysswjXxzxTYwPpwh = qysswjXxzxTYwPpwhService.getPpwhById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return qysswjXxzxTYwPpwh;
    }


    @ApiOperation (value = "修改后保存", notes = "返回字符串，成功返回success，失败返回error")
    @ApiImplicitParams ({
            @ApiImplicitParam (name = "id", value = "主键id", paramType = "query", required = true),
            @ApiImplicitParam (name = "ppmc", value = "品牌名称", paramType = "query", required = true),
            @ApiImplicitParam (name = "lxid", value = "类型id", paramType = "query", required = true),
            @ApiImplicitParam (name = "lxmc", value = "类型名称", paramType = "query", required = true)
    })
    @ApiResponse (code = 400, message = "参数没有填好", response = String.class)
    @RequestMapping (value = "/editPpwh", method = RequestMethod.POST)
    @ResponseBody
    public String editPpwh(@RequestParam (required = true) String id, @RequestParam (required = true) String ppmc,
                           @RequestParam (required = true) String lxid, @RequestParam (required = true) String lxmc) {

        String resultStr = "success";

        try {
            qysswjXxzxTYwPpwhService.editPpwh(id, ppmc, lxid, lxmc);
        } catch (Exception e) {
            resultStr = "error";
            e.printStackTrace();
        }

        return resultStr;
    }


    @ApiOperation (value = "单个删除和批量删除", notes = "实际上是更新状态。返回字符串，成功返回success，失败返回error")
    @ApiImplicitParams (
            {
                    @ApiImplicitParam (name = "ids", value = "主键id的字符串。格式：id1，id2，idn", paramType = "query", required
                            = true)
            }
    )
    @ApiResponse (code = 400, message = "参数没有填好", response = String.class)
    @RequestMapping (value = "/editPpwhZt", method = RequestMethod.POST)
    @ResponseBody
    public String editPpwhZt(@RequestParam (required = true) String ids) {
        String resultStr = "success";
        try {
            String idArr[] = ids.split(",");
            List<String> idList = Arrays.asList(idArr);
            qysswjXxzxTYwPpwhService.editPpwhZt(idList);
        } catch (Exception e) {
            resultStr = "error";
            e.printStackTrace();
        }
        return resultStr;
    }


    @ApiOperation (value = "根据类型id获取所有在用品牌", notes = "返回List ")
    @ApiImplicitParams ({
            @ApiImplicitParam (name = "lxid", value = "类型id", paramType = "query", required = false)
    })
    @ApiResponse (code = 400, message = "参数没有填好", response = String.class)
    @RequestMapping (value = "/getPpwhListByLxid", method = RequestMethod.POST)
    @ResponseBody
    public List<QysswjXxzxTYwPpwh> getPpwhListByLxid(@RequestParam (required = false) String lxid) {
        ppwhList = new ArrayList<>();
        try {
            ppwhList = qysswjXxzxTYwPpwhService.getPpwhListByLxid(lxid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ppwhList;
    }


}
