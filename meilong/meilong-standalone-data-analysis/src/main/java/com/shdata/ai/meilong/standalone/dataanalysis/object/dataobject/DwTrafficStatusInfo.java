package com.shdata.ai.meilong.standalone.dataanalysis.object.dataobject;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * 类名称: DwTrafficStatusInfo
 * 类描述：TODO
 * 创建人：张鸿铭 【zhanghm@shdata.com】
 * 创建时间： 2021/4/23 10:01
 * Copyright (c) 2020 上海市大数据股份有限公司
 * Version 1.0
 **/
/**
    * 高德交通态势数据
    */
@Data
public class DwTrafficStatusInfo {
    private Long id;

    /**
    * 城市
    */
    private String city;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 湿度
    */
    private String humidity;

    /**
    * 路名，从梅隆现场实时客流数据获取
    */
    private String location;

    /**
    * 省份
    */
    private String province;

    /**
    * 拥堵
    */
    private String roadBlocked;

    /**
    * 拥挤
    */
    private String roadCongested;

    /**
    * 畅通
    */
    private String roadExpedite;

    /**
    * 未知
    */
    private String roadUnknown;

    /**
    * 温度
    */
    private String temperature;

    /**
    * 路况描述
    */
    private String trafficDesc;

    /**
    * 天气
    */
    private String weather;

    /**
    * 风向
    */
    private String windDirection;

    /**
    * 风速
    */
    private String windPower;

    /**
    * 更新时间
    */
    private Date updateTime;
}