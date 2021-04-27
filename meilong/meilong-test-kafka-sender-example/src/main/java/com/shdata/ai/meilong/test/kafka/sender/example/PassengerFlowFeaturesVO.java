package com.shdata.ai.meilong.test.kafka.sender.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zhufkt
 * @date 2021/4/21
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassengerFlowFeaturesVO {

    /**
     * 地铁客流开始时间
     */
    private Date startTime;

    /**
     * 地铁站名字
     */
    private String stationName;

    /**
     * 地铁客流结束时间
     */
    private Date endTime;

    private Long stepOutNumX;

    private Long stepInNumX;

    /**
     * 城市
     */
    private String city;

    /**
     * 原始数据创建时间
     */
    private Date dataCreateTime;

    /**
     * 湿度
     */
    private String humidity;

    /**
     * 地点
     */
    private String location;

    /**
     * 省市
     */
    private String province;

    /**
     * 道路阻塞
     */
    private Double roadBlocked;

    /**
     * 道路拥挤
     */
    private Double roadCongested;

    /**
     * 道路畅通
     */
    private Double roadExpedite;

    /**
     * 道路未知
     */
    private Double roadUnknown;

    /**
     * 气温
     */
    private String temperature;

    /**
     * 交通描述
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
     * 地铁线
     */
    private String railLine;

    private Double firstDisBikeSum;

    private Double secondDisBikeSum;

    private Double thirdDisBikeSum;

    private Double fourthDisBikeSum;

    /**
     * 单车上锁状态
     */
    private String lockStatus;

    /**
     * 是否是周末
     */
    private Boolean isWeekend;

    /**
     * 字符串日期
     */
    private String dayStr;

    /**
     * 一天中的第几个小时
     */
    private Long hour;

    /**
     * 是否是假日
     */
    private Boolean isHoliday;

    /**
     * 假日名称
     */
    private String holidayDetail;

    /**
     * 一天中的时段
     */
    private String hourPeriod;

    /**
     * 一周中的第几天
     */
    private Long dayOfWeek;

    private Date minGroup;

    private Double stepInNumY;

    private Double stepOutNumY;

    private Integer stepInCleaned;

    private Integer stepOutCleaned;

    /**
     * 是否是离群值
     */
    private Integer isOutlier;

}
