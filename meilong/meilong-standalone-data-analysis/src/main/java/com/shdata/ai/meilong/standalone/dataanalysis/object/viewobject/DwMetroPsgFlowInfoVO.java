package com.shdata.ai.meilong.standalone.dataanalysis.object.viewobject;

import lombok.Data;

import java.util.Date;

/**
 * 类名称: DwMetroPsgFlowInfo
 * 类描述：TODO
 * 创建人：张鸿铭 【zhanghm@shdata.com】
 * 创建时间： 2021/4/27 13:39
 * Copyright (c) 2020 上海市大数据股份有限公司
 * Version 1.0
 **/

/**
    * 地铁客流信息
    */
@Data
public class DwMetroPsgFlowInfoVO {
    private Long id;

    /**
    * 站台id
    */
    private String stationId;

    private String lineId;

    private String stepOut;

    private String stepIn;

    private Date countStartTime;

    /**
    * 创建时间
    */
    private Date createTime;

    private Date countEndTime;

    private String stationName;

    private String lineBelong;

    private String x;

    private String y;

    /**
    * 更新时间
    */
    private Date updateTime;

    private Boolean isUsed;
}