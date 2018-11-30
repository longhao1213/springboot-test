package com.lh.controller;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 龙浩 on 2018/7/19.
 */
@RestController
@RequestMapping("api")
@Api(value = "Swagger测试相关的api", tags = {"用户操作接口"})
public class SwaggerDemoController {

    private final static Logger logger = LoggerFactory.getLogger(SwaggerDemoController.class);

    @ApiOperation(value = "测试logger的效果", notes = "就是打印在控制条")
    @ApiImplicitParam(name = "message",value = "内容",required = true,dataType = "String")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public void log(@RequestParam(name = "message", required = true) String message) {
        logger.info(message);
    }

    @ApiOperation(value = "测试实体类接受的效果", notes = "返回传入的实体类")
    @RequestMapping(value = "/testUser", method = RequestMethod.POST)
    public User logtest(@RequestBody User user) {
        return user;
    }
}
