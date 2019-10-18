package com.ihyht.alyxjs.kfzpt.portal.console;

import com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.model.QysswjXxzxTYwXhwh;
import com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.service.QysswjXxzxTYwXhwhService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * (QysswjXxzxTYwXhwh)表控制层
 *
 * @author makejava
 * @since 2019-09-21 10:02:29
 */
@Api (value = "耗材管理", description = "型号维护类")
@PropertySource ("classpath:application.properties")
@RestController
@RequestMapping ("/Xhwh")
public class QysswjXxzxTYwXhwhController {
    /**
     * 服务对象
     */
    @Resource
    private QysswjXxzxTYwXhwhService qysswjXxzxTYwXhwhService;


    @Value ("${pageSize}")
    private int pageSize;

    private List<QysswjXxzxTYwXhwh> xhwhList;

    @ApiOperation (value = "获取所有在用品牌，并且分页", notes = "1.返回List。2.页码大于0,分页 ")
    @ApiImplicitParams ({
            @ApiImplicitParam (name = "lxid", value = "类型id，下拉获取", paramType = "query", required = false),
            @ApiImplicitParam (name = "ppid", value = "类型id，下拉获取", paramType = "query", required = false),
            @ApiImplicitParam (name = "xhmc", value = "型号名称", paramType = "query", required = false),
            @ApiImplicitParam (name = "pageNum", value = "页码", paramType = "query", required = true)
    })
    @ApiResponse (code = 400, message = "参数没有填好", response = String.class)
    @RequestMapping (value = "/getXhwhList", method = RequestMethod.POST)
    @ResponseBody
    public List<QysswjXxzxTYwXhwh> getXhwhList(@RequestParam (required = false) String lxid,
                                               @RequestParam (required = false) String ppid,
                                               @RequestParam (required = false) String xhmc,
                                               @RequestParam (required = true) int pageNum) {
        xhwhList = new ArrayList<>();
        try {
            xhwhList = qysswjXxzxTYwXhwhService.getXhwhList(lxid, ppid, xhmc, pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return xhwhList;
    }


    @ApiOperation (value = "新增后保存", notes = "返回字符串，成功返回success，失败返回error")
    @ApiImplicitParams ({

            @ApiImplicitParam (name = "ppid", value = "品牌id", paramType = "query", required = true),
            @ApiImplicitParam (name = "ppmc", value = "品牌名称", paramType = "query", required = true),
            @ApiImplicitParam (name = "xhmc", value = "型号名称", paramType = "query", required = true)
    })
    @ApiResponse (code = 400, message = "参数没有填好", response = String.class)
    @RequestMapping (value = "/addXhwh", method = RequestMethod.POST)
    @ResponseBody
    public String addXhwh(@RequestParam (required = true) String ppid,
                          @RequestParam (required = true) String ppmc,
                          @RequestParam (required = true) String xhmc) {
        String resultStr = "success";
        try {
            qysswjXxzxTYwXhwhService.addXhwh(ppid, ppmc, xhmc);
        } catch (Exception e) {
            resultStr = "error";
            e.printStackTrace();
        }

        return resultStr;

    }


    @ApiOperation (value = "根据id获取对象", notes = "返回型号对象")
    @ApiImplicitParams ({
            @ApiImplicitParam (name = "id", value = "型号id", paramType = "query", required = true)
    })
    @ApiResponse (code = 400, message = "参数没有填好", response = String.class)
    @RequestMapping (value = "/getXhwhById", method = RequestMethod.POST)
    @ResponseBody
    public QysswjXxzxTYwXhwh getXhwhById(@RequestParam (required = true) String id) {
        QysswjXxzxTYwXhwh qysswjXxzxTYwXhwh = new QysswjXxzxTYwXhwh();
        try {
            qysswjXxzxTYwXhwh = qysswjXxzxTYwXhwhService.getXhwhById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return qysswjXxzxTYwXhwh;
    }


    @ApiOperation (value = "修改后保存", notes = "返回字符串，成功返回success，失败返回error")
    @ApiImplicitParams ({

            @ApiImplicitParam (name = "ppid", value = "品牌id", paramType = "query", required = true),
            @ApiImplicitParam (name = "ppmc", value = "品牌名称", paramType = "query", required = true),
            @ApiImplicitParam (name = "xhmc", value = "型号名称", paramType = "query", required = true),
            @ApiImplicitParam (name = "id", value = "型号主键id", paramType = "query", required = true)
    })
    @ApiResponse (code = 400, message = "参数没有填好", response = String.class)
    @RequestMapping (value = "/editXhwh", method = RequestMethod.POST)
    @ResponseBody
    public String editXhwh(@RequestParam (required = true) String ppid,
                           @RequestParam (required = true) String ppmc,
                           @RequestParam (required = true) String xhmc,
                           @RequestParam (required = true) String id) {
        String resultStr = "success";
        try {
            qysswjXxzxTYwXhwhService.editXhwh(ppid, ppmc, xhmc, id);
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
    @RequestMapping (value = "/editXhwhZt", method = RequestMethod.POST)
    @ResponseBody
    public String editXhwhZt(@RequestParam (required = true) String ids) {
        String resultStr = "success";
        try {
            String idArr[] = ids.split(",");
            List<String> idList = Arrays.asList(idArr);
            qysswjXxzxTYwXhwhService.editXhwhZt(idList);
        } catch (Exception e) {
            resultStr = "error";
            e.printStackTrace();
        }
        return resultStr;
    }


    @ApiOperation (value = "根据品牌id获取型号", notes = "根据品牌id获取型号")
    @ApiImplicitParams (
            {
                    @ApiImplicitParam (name = "ppid", value = "品牌id", paramType = "query", required
                            = true)
            }
    )
    @ApiResponse (code = 400, message = "参数没有填好", response = String.class)
    @RequestMapping (value = "/getXhwhListByPpid", method = RequestMethod.POST)
    @ResponseBody
    public List<QysswjXxzxTYwXhwh> getXhwhListByPpid(@RequestParam (required = true) String ppid) {
        xhwhList = new ArrayList<>();
        try {
            xhwhList = qysswjXxzxTYwXhwhService.getXhwhListByPpid(ppid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xhwhList;
    }


}
