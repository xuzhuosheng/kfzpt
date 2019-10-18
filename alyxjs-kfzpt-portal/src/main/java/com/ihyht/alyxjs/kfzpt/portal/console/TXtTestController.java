package com.ihyht.alyxjs.kfzpt.portal.console;


import com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.model.Fw;
import com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.model.TXtTest;
import com.ihyht.alyxjs.kfzpt.service.portal.rds.portal.service.TXtTestService;
import com.ihyht.alyxjs.nbjcpt.common.api.ApiReturnCodeEnum;
import com.ihyht.commons.lang.model.RestResponse;
import com.netflix.discovery.converters.Auto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api (value = "Test", description = "Test")
@RestController
@RequestMapping ("/Te")
public class TXtTestController {

    @Autowired
    private TXtTestService tXtTestService;

    @RequestMapping (path = "/{id}", method = RequestMethod.GET)
    @ApiOperation (value = "通过id标识查找")
    public RestResponse findById(@PathVariable String id) {
        TXtTest tXtTest = tXtTestService.findById(id);
        if (tXtTest != null) {
            return RestResponse.success(tXtTest);
        } else {
            return RestResponse.failed(ApiReturnCodeEnum.queryFail);
        }
    }

}
