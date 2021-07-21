package io.renren.modules.device.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.device.dao.LiferecordDao;
import io.renren.modules.device.entity.HistoryEntity;
import io.renren.modules.device.entity.LiferecordEntity;
import io.renren.modules.device.service.HistoryService;
import io.renren.modules.device.service.LiferecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("HistoryService")
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    LiferecordService liferecordService;
    @Override
    public HistoryEntity getLifeFreq(HistoryEntity historyEntity) {
//        List<LiferecordEntity> lifelist = liferecordService.getLifeBetweenStartAndEnd(historyEntity.getStarttime(), historyEntity.getEndtime());
//        historyEntity.setTotal(lifelist.size());

        return null;
    }
}
