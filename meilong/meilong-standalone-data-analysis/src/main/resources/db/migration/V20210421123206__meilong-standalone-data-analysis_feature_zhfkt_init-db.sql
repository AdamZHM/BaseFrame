create table dw_passenger_flow_features
(
    id                  bigint auto_increment primary key,
    start_time          timestamp                          null comment '地铁客流开始时间',
    station_name        mediumtext                         null comment '地铁站名字',
    end_time            timestamp                          null comment '地铁客流结束时间',
    step_out_num_x      bigint                             null comment '',
    step_in_num_x       bigint                             null comment '',
    city                mediumtext                         null comment '城市',
    humidity            mediumtext                         null comment '湿度',
    location            mediumtext                         null comment '地点',
    province            mediumtext                         null comment '省市',
    road_blocked        double                             null comment '道路阻塞',
    road_congested      double                             null comment '道路拥挤',
    road_expedite       double                             null comment '道路畅通',
    road_unknown        double                             null comment '道路未知',
    temperature         mediumtext                         null comment '气温',
    traffic_desc        mediumtext                         null comment '交通描述',
    weather             mediumtext                         null comment '天气',
    wind_direction      mediumtext                         null comment '风向',
    wind_power          mediumtext                         null comment '风速',
    rail_line           mediumtext                         null comment '地铁线',
    first_dis_bike_sum  double                             null comment '',
    second_dis_bike_sum double                             null comment '',
    third_dis_bike_sum  double                             null comment '',
    fourth_dis_bike_sum double                             null comment '',
    lock_status         mediumtext                         null comment '单车上锁状态',
    is_weekend          bit                                null comment '是否是周末',
    day_str             mediumtext                         null comment '字符串日期',
    hour                bigint                             null comment '一天中的第几个小时',
    is_holiday          bit                                null comment '是否是假日',
    holiday_detail      mediumtext                         null comment '假日名称',
    hour_period         mediumtext                         null comment '一天中的时段',
    day_of_week         bigint                             null comment '一周中的第几天',
    min_group           timestamp                          null comment '',
    step_in_num_y       double                             null comment '',
    step_out_num_y      double                             null comment '',
    step_in_cleaned     int                                null comment '',
    step_out_cleaned    int                                null comment '',
    is_outlier          int                                null comment '是否是离群值',
    is_used             bool     default FALSE             not null,
    create_time         datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time         datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    INDEX create_time_index (create_time),
    INDEX is_used_index (is_used)
)
    DEFAULT CHARSET = utf8mb4
    comment '地铁乘客客流信息特征';

create table dw_traffic_status_info
(
    id             bigint auto_increment
        primary key,
    city           varchar(255)                       null comment '城市',
    create_time    datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    humidity       varchar(255)                       null comment '湿度',
    location       varchar(255)                       null comment '地点',
    province       varchar(255)                       null comment '省份',
    road_blocked   varchar(255)                       null comment '拥堵',
    road_congested varchar(255)                       null comment '拥挤',
    road_expedite  varchar(255)                       null comment '畅通',
    road_unknown   varchar(255)                       null comment '未知',
    temperature    varchar(255)                       null comment '温度',
    traffic_desc   varchar(255)                       null comment '路况描述',
    weather        varchar(255)                       null comment '天气',
    wind_direction varchar(255)                       null comment '风向',
    wind_power     varchar(255)                       null comment '风速',
    update_time    datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_used        bool     default FALSE             not null
)
    charset = utf8mb4
    comment '高德交通态势数据';

CREATE TABLE ods_metro_station_info
(
    id           bigint                                 NOT NULL AUTO_INCREMENT,
    address_code varchar(255) DEFAULT NULL comment '城市代码',
    city         varchar(255) DEFAULT NULL comment '城市名称',
    create_time  datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    line_number  varchar(255) DEFAULT NULL comment '地铁线路',
    location     varchar(255) DEFAULT NULL comment '路名',
    station_name varchar(255) DEFAULT NULL comment '地铁站名称',
    update_time  datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_used      bool         default FALSE             not null,
    PRIMARY KEY (id)
)
    charset = utf8mb4
    comment '地铁站信息';

CREATE TABLE `dw_metro_psg_flow_info`
(
    id               bigint                                 NOT NULL AUTO_INCREMENT,
    station_id       varchar(255) DEFAULT NULL comment '站台id',
    line_id          varchar(255) DEFAULT NULL,
    step_out         varchar(255) DEFAULT NULL,
    step_in          varchar(255) DEFAULT NULL,
    count_start_time timestamp                              NULL DEFAULT NULL,
    create_time      datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    count_end_time   timestamp                              NULL DEFAULT NULL,
    station_name     varchar(255) DEFAULT NULL,
    line_belong      varchar(255) DEFAULT NULL,
    x                varchar(255) DEFAULT NULL,
    y                varchar(255) DEFAULT NULL,
    update_time      datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_used          bool         default FALSE             not null,
    PRIMARY KEY (id)
)
    charset = utf8mb4
    comment '地铁客流信息';