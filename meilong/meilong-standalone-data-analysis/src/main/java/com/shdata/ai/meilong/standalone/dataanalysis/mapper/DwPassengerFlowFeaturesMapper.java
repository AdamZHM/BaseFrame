package com.shdata.ai.meilong.standalone.dataanalysis.mapper;

import com.shdata.ai.meilong.standalone.dataanalysis.object.dataobject.DwPassengerFlowFeatures;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * @author zhufkt
 * @date 2021/4/21
 */

@Mapper
@Repository
public interface DwPassengerFlowFeaturesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DwPassengerFlowFeatures record);

    int insertSelective(DwPassengerFlowFeatures record);

    DwPassengerFlowFeatures selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DwPassengerFlowFeatures record);

    int updateByPrimaryKey(DwPassengerFlowFeatures record);
}