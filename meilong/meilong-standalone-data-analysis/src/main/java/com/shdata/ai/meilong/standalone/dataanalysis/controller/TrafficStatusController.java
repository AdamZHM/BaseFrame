package com.shdata.ai.meilong.standalone.dataanalysis.controller;

import com.shdata.ai.meilong.standalone.dataanalysis.service.DwTrafficStatusInfoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 类名称: TrafficStatusController
 * 类描述：TODO
 * 创建人：张鸿铭 【zhanghm@shdata.com】
 * 创建时间： 2021/4/23 11:24
 * Copyright (c) 2020 上海市大数据股份有限公司
 * Version 1.0
 **/
@Log4j2
@RestController
@RequestMapping("/traffic")
public class TrafficStatusController {
    @Autowired
    DwTrafficStatusInfoService dwTrafficStatusInfoService;

    @GetMapping("test")
    public void TrafficStatus() throws IOException {
        dwTrafficStatusInfoService.insertTrafficStatusInfo("莲花路", "310112", "上海市");
    }
}
