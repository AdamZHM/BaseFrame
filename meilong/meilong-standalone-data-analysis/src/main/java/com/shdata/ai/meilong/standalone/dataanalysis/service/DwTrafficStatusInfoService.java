package com.shdata.ai.meilong.standalone.dataanalysis.service;

import java.io.IOException;
import java.util.List;
import com.shdata.ai.meilong.standalone.dataanalysis.object.dataobject.DwTrafficStatusInfo;
    /**
 * 类名称: DwTrafficStatusInfoService
 * 类描述：TODO
 * 创建人：张鸿铭 【zhanghm@shdata.com】
 * 创建时间： 2021/4/23 10:01
 * Copyright (c) 2020 上海市大数据股份有限公司
 * Version 1.0
 **/
public interface DwTrafficStatusInfoService{


    int deleteByPrimaryKey(Long id);

    int insert(DwTrafficStatusInfo record);

    int insertSelective(DwTrafficStatusInfo record);

    DwTrafficStatusInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DwTrafficStatusInfo record);

    int updateByPrimaryKey(DwTrafficStatusInfo record);

    int batchInsert(List<DwTrafficStatusInfo> list);

    void insertTrafficStatusInfo(String roadName, String addressCode, String cityName) throws IOException;
}
