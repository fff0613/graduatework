package io.renren.modules.device.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.device.entity.DeviceEntity;
import io.renren.modules.device.entity.HistoryEntity;

public interface HistoryService{
    HistoryEntity getLifeFreq(HistoryEntity historyEntity);
}
