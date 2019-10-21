package com.ihyht.alyxjs.kfzpt.portal.console.caigou;

import com.ihyht.alyxjs.kfzpt.portal.utils.ExcelUtil;
import com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.model.QysswjXxzxTYwCgjh;
import com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.model.QysswjXxzxTYwLbwh;
import com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.service.QysswjXxzxTYwCgjhService;
import com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.service.QysswjXxzxTYwCgjhxqService;
import com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.service.QysswjXxzxTYwLbwhService;
import com.ihyht.alyxjs.nbjcpt.common.api.ApiReturnCodeEnum;
import com.ihyht.commons.lang.ExcelUtils;
import com.ihyht.commons.lang.model.RestResponse;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * (QysswjXxzxTYwCgjh)表控制层
 *
 * @author makejava
 * @since 2019-10-21 11:47:26
 */
@Api(value = "采购计划", description = "采购计划")
@PropertySource("classpath:application.properties")
@RequestMapping("/Cgjh")
@RestController
public class QysswjXxzxTYwCgjhController {
    /**
     * 服务对象
     */
    @Resource
    private QysswjXxzxTYwCgjhService qysswjXxzxTYwCgjhService;

    @Resource
    private QysswjXxzxTYwLbwhService qysswjXxzxTYwLbwhService;

    @Resource
    private QysswjXxzxTYwCgjhxqService qysswjXxzxTYwCgjhxqService;

    @Value("${pageSize}")
    private int pageSize;


    @ApiOperation(value = "获取所有采购计划并且分页")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "cgjhmc", value = "采购计划名称", paramType = "query", required = false),
            @ApiImplicitParam(name = "qsrq", value = "起始日期", paramType = "query", required = false),
            @ApiImplicitParam(name = "zzrq", value = "终止日期", paramType = "query", required = false),
            @ApiImplicitParam(name = "pageNum", value = "页码", paramType = "query", required = true)
    })
    @ApiResponse(code = 400, message = "参数没有填好", response = String.class)
    @RequestMapping(value = "/getCgjhList", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse getCgjhList(@RequestParam(required = false) String cgjhmc,
                                    @RequestParam(required = false) String qsrq,
                                    @RequestParam(required = false) String zzrq,
                                    @RequestParam(required = true) int pageNum
    ) {
        System.out.println(qsrq);
        List<QysswjXxzxTYwCgjh> cgjhList = qysswjXxzxTYwCgjhService.getYwLbwhList(cgjhmc, qsrq, zzrq, pageNum,
                pageSize);
        if (cgjhList != null) {
            return RestResponse.success(cgjhList);
        } else {
            return RestResponse.failed(ApiReturnCodeEnum.saveFail);
        }

    }

    @ApiOperation(value = "新增采购计划")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cgjhmc", value = "采购计划名称", paramType = "query", required = false)
    })
    @ApiResponse(code = 400, message = "参数没有填好", response = String.class)
    @RequestMapping(value = "/addCgjh", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse addCgjh(@RequestParam(required = true) String cgjhmc) {

        boolean flag = qysswjXxzxTYwCgjhService.addCgjh(cgjhmc);

        if (flag) {
            return RestResponse.success(flag);
        } else {
            return RestResponse.failed(ApiReturnCodeEnum.saveFail);
        }

    }

    @ApiOperation(value = "智能生成采购计划", notes = "获取类别里的数据")
    @RequestMapping(value = "/createCgjh", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse createCgjh() {

        List<QysswjXxzxTYwLbwh> ywLbwhAuto = qysswjXxzxTYwLbwhService.getLbwhListAuto();

        if (ywLbwhAuto != null) {
            return RestResponse.success(ywLbwhAuto);
        } else {
            return RestResponse.failed(ApiReturnCodeEnum.saveFail);
        }
    }


    @ApiOperation(value = "导出Excel", notes = "导出Excel")
    @RequestMapping(value = "/expExcel", method = RequestMethod.POST)
    @ResponseBody
    public void expExcel(@RequestParam(required = false) String cgjhid, HttpServletResponse response) {

//        QysswjXxzxTYwCgjh qysswjXxzxTYwCgjh = qysswjXxzxTYwCgjhService.getCgjhById(cgjhid);
//        List<QysswjXxzxTYwCgjhxq> cgjhxqList = new ArrayList<>();
//
//        if (qysswjXxzxTYwCgjh != null) {
//            cgjhxqList = qysswjXxzxTYwCgjhxqService.getCgjhxqByCgjhId(cgjhid);
//        }
//
//        if (qysswjXxzxTYwCgjh != null && cgjhxqList != null) {
//        }

        ExcelUtil.exportExcel("", null, null,response);

    }


}
