package com.shdata.ai.meilong.test.kafka.sender.example.object;

import java.util.Date;
import lombok.Data;

/**
 * 类名称: DwMetroPsgFlowInfo
 * 类描述：TODO
 * 创建人：张鸿铭 【zhanghm@shdata.com】
 * 创建时间： 2021/4/27 15:35
 * Copyright (c) 2020 上海市大数据股份有限公司
 * Version 1.0
 **/
@Data
public class DwMetroPsgFlowInfoVO {
    private String stationId;

    private String lineId;

    private String stepOut;

    private String stepIn;

    private Date countStartTime;

    private Date createTime;

    private Date countEndTime;

    private String stationName;

    private String lineBelong;

    private String x;

    private String y;
}