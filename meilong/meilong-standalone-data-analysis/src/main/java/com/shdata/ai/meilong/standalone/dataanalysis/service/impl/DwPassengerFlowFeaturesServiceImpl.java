package com.shdata.ai.meilong.standalone.dataanalysis.service.impl;

import com.shdata.ai.meilong.standalone.dataanalysis.object.viewobject.PassengerFlowFeaturesVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.shdata.ai.meilong.standalone.dataanalysis.object.dataobject.DwPassengerFlowFeatures;
import com.shdata.ai.meilong.standalone.dataanalysis.mapper.DwPassengerFlowFeaturesMapper;
import com.shdata.ai.meilong.standalone.dataanalysis.service.DwPassengerFlowFeaturesService;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author zhufkt
 * @date 2021/4/21
 */

@Log4j2
@Service
@Transactional(rollbackFor=Exception.class)
public class DwPassengerFlowFeaturesServiceImpl implements DwPassengerFlowFeaturesService {

    @Resource
    private DwPassengerFlowFeaturesMapper dwPassengerFlowFeaturesMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return dwPassengerFlowFeaturesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PassengerFlowFeaturesVO passengerFlowFeaturesVO) {

        DwPassengerFlowFeatures dwPassengerFlowFeatures = new DwPassengerFlowFeatures();
        BeanUtils.copyProperties(passengerFlowFeaturesVO, dwPassengerFlowFeatures);

        int cnt = dwPassengerFlowFeaturesMapper.insert(dwPassengerFlowFeatures);
        log.info("About {} records are inserted into table dwPassengerFlowFeatures", cnt);

        return cnt;
    }

    @Override
    public int insertSelective(PassengerFlowFeaturesVO passengerFlowFeaturesVO) {
        DwPassengerFlowFeatures dwPassengerFlowFeatures = new DwPassengerFlowFeatures();
        BeanUtils.copyProperties(passengerFlowFeaturesVO, dwPassengerFlowFeatures);

        int cnt = dwPassengerFlowFeaturesMapper.insertSelective(dwPassengerFlowFeatures);
        log.info("About {} records are inserted into table dwPassengerFlowFeatures", cnt);

        return cnt;
    }

    @Override
    public PassengerFlowFeaturesVO selectByPrimaryKey(Long id) {
        DwPassengerFlowFeatures dwPassengerFlowFeatures = dwPassengerFlowFeaturesMapper.selectByPrimaryKey(id);

        PassengerFlowFeaturesVO passengerFlowFeaturesVO = new PassengerFlowFeaturesVO();
        if(dwPassengerFlowFeatures != null)
        {
            BeanUtils.copyProperties(dwPassengerFlowFeatures, passengerFlowFeaturesVO);
        }

        return passengerFlowFeaturesVO;

    }

    @Override
    public int updateByPrimaryKeySelective(DwPassengerFlowFeatures record) {
        return dwPassengerFlowFeaturesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DwPassengerFlowFeatures record) {
        return dwPassengerFlowFeaturesMapper.updateByPrimaryKey(record);
    }

}

