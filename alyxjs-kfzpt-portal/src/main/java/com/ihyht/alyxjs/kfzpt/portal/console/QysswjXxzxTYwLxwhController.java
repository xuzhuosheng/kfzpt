package com.ihyht.alyxjs.kfzpt.portal.console;

import com.ihyht.alyxjs.kfzpt.portal.base.AbstractRestController;
import com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.model.QysswjXxzxTYwLxwh;
import com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.service.QysswjXxzxTYwLxwhService;
import com.ihyht.alyxjs.nbjcpt.common.api.ApiReturnCodeEnum;
import com.ihyht.commons.lang.model.RestResponse;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * (QysswjXxzxTYwLxwh)表控制层
 *
 * @author makejava
 * @since 2019-09-21 09:59:24
 */
@Api (value = "耗材管理", description = "类型维护类")
@RestController
@RequestMapping ("/Lxwh")
@PropertySource ("classpath:application.properties")
public class QysswjXxzxTYwLxwhController extends AbstractRestController {
    /**
     * 服务对象
     */
    @Resource
    private QysswjXxzxTYwLxwhService qysswjXxzxTYwLxwhService;


    private List<QysswjXxzxTYwLxwh> lxwhList;


    @Value ("${pageSize}")
    private int pageSize;


    @ApiOperation (value = "获取所有在用类型，并且分页.页面显示数据", notes = "1.返回List。2.页码大于0,整数,分页")
    @ApiImplicitParams ({
            @ApiImplicitParam (name = "searchContent", value = "搜索内容", paramType = "query", required = false),
            @ApiImplicitParam (name = "pageNum", value = "页码", paramType = "query", required = true)
    })
    @ApiResponse (code = 400, message = "参数没有填好", response = String.class)
    @RequestMapping (value = "/getLxwhList", method = RequestMethod.POST)
    @ResponseBody
    public List<QysswjXxzxTYwLxwh> getLxwhList(@RequestParam (required = false) String searchContent,
                                               @RequestParam (required = true) int pageNum) {
        lxwhList = new ArrayList<>();
        try {
            lxwhList = qysswjXxzxTYwLxwhService.getLxwhList(searchContent, pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lxwhList;
    }

    @ApiOperation (value = "根据id获取类型", notes = "返回QysswjXxzxTYwLxwh对象")
    @ApiImplicitParams ({
            @ApiImplicitParam (name = "id", value = "id", paramType = "query", required = true)
    })
    @ApiResponse (code = 400, message = "参数没有填好", response = String.class)
    @RequestMapping (value = "/getLxwhById", method = RequestMethod.POST)
    @ResponseBody
    public QysswjXxzxTYwLxwh getLxwhById(@RequestParam (required = true) String id) {
        QysswjXxzxTYwLxwh ywLxwh = new QysswjXxzxTYwLxwh();
        try {
            ywLxwh = qysswjXxzxTYwLxwhService.getLxwhById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ywLxwh;
    }


    @ApiOperation (value = "新增保存", notes = "返回字符串，成功返回success，失败返回error")
    @ApiImplicitParam (name = "lxmc", value = "类型名称", paramType = "query", required = true)
    @ApiResponse (code = 400, message = "参数没有填好", response = String.class)
    @RequestMapping (value = "/addLxwh", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse addLxwh(@RequestParam (required = false) String lxmc) {
        boolean flag = true;
        try {
            qysswjXxzxTYwLxwhService.addLxwh(lxmc);
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }

        if (flag) {
            return RestResponse.success(flag);
        } else {
            return RestResponse.failed(ApiReturnCodeEnum.saveFail);
        }
    }


    @ApiOperation (value = "修改后保存", notes = "返回字符串，成功返回success，失败返回error")
    @ApiImplicitParams (
            {
                    @ApiImplicitParam (name = "id", value = "主键id", paramType = "query", required = true),
                    @ApiImplicitParam (name = "lxmc", value = "类型名称", paramType = "query", required = true)

            }
    )
    @ApiResponse (code = 400, message = "参数没有填好", response = String.class)
    @RequestMapping (value = "/editLxwh", method = RequestMethod.POST)
    @ResponseBody
    public String editLxwh(@RequestParam (required = false) String lxmc, @RequestParam (required = false) String id) {
        String resultStr = "success";
        try {
            qysswjXxzxTYwLxwhService.editLxwh(id, lxmc);
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
    @RequestMapping (value = "/editLxwhZt", method = RequestMethod.POST)
    @ResponseBody
    public String editLxwhZt(@RequestParam (required = true) String ids) {
        String resultStr = "success";
        try {
            String idArr[] = ids.split(",");
            List<String> idList = Arrays.asList(idArr);
            qysswjXxzxTYwLxwhService.editLxwhZt(idList);
        } catch (Exception e) {
            resultStr = "error";
            e.printStackTrace();
        }
        return resultStr;
    }


    @ApiOperation (value = "获取所有在用类型 ", notes = "返回List ")
    @ApiResponse (code = 400, message = "参数没有填好", response = String.class)
    @RequestMapping (value = "/getAllLxwhList", method = RequestMethod.POST)
    @ResponseBody
    public List<QysswjXxzxTYwLxwh> getAllLxwhList() {
        lxwhList = new ArrayList<>();
        try {
            lxwhList = qysswjXxzxTYwLxwhService.getAllLxwhList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lxwhList;
    }


}
