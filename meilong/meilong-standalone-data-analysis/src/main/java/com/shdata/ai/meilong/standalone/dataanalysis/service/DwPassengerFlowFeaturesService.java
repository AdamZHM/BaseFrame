package com.shdata.ai.meilong.standalone.dataanalysis.service;

import com.shdata.ai.meilong.standalone.dataanalysis.object.dataobject.DwPassengerFlowFeatures;
import com.shdata.ai.meilong.standalone.dataanalysis.object.viewobject.PassengerFlowFeaturesVO;


/**
 * @author zhufkt
 * @date 2021/4/21
 */


public interface DwPassengerFlowFeaturesService {


    int deleteByPrimaryKey(Long id);

    int insert(PassengerFlowFeaturesVO passengerFlowFeaturesVO);

    int insertSelective(PassengerFlowFeaturesVO passengerFlowFeaturesVO);

    PassengerFlowFeaturesVO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DwPassengerFlowFeatures record);

    int updateByPrimaryKey(DwPassengerFlowFeatures record);

}

