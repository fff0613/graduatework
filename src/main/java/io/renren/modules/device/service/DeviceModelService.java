package io.renren.modules.device.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.device.entity.DeviceModelEntity;
import io.renren.modules.device.entity.DeviceTypeEntity;
import io.renren.modules.device.entity.OptionEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-08 13:57:16
 */
public interface DeviceModelService extends IService<DeviceModelEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<DeviceModelEntity> queryAll();
    String insertModel(DeviceModelEntity item);
    List<DeviceModelEntity> queryByModel(String s);
    List<OptionEntity> queryModelList();
    void updateModel(DeviceModelEntity item);
    void deleteModel(String[] models);
    List<OptionEntity> queryByType(String type);
}

