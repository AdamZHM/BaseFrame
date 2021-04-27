package com.shdata.ai.meilong.standalone.dataanalysis.object.dataobject;

import java.util.Date;
import lombok.Data;

/**
 * 类名称: OdsMetroStationInfo
 * 类描述：TODO
 * 创建人：张鸿铭 【zhanghm@shdata.com】
 * 创建时间： 2021/4/23 16:35
 * Copyright (c) 2020 上海市大数据股份有限公司
 * Version 1.0
 **/
/**
    * 地铁站信息
    */
@Data
public class OdsMetroStationInfo {
    private Long id;

    /**
    * 城市代码
    */
    private String addressCode;

    /**
    * 城市名称
    */
    private String city;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 地铁线路
    */
    private String lineNumber;

    /**
    * 路名
    */
    private String location;

    /**
    * 地铁站名称
    */
    private String stationName;

    /**
    * 更新时间
    */
    private Date updateTime;
}