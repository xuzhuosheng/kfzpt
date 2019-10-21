package com.ihyht.alyxjs.kfzpt.portal.console.kucun;


import io.swagger.annotations.Api;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api (value = "库存管理", description = "类型维护类")
@RestController
@RequestMapping ("/Kcgl")
@PropertySource ("classpath:application.properties")
public class KcglController {


}
