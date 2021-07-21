package io.renren.modules.device.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.device.entity.DeviceTypeEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-08 13:57:16
 */
public interface DeviceTypeService extends IService<DeviceTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<DeviceTypeEntity> queryAll();
    String insertType(DeviceTypeEntity item);
    String updateState(DeviceTypeEntity item);
    List<DeviceTypeEntity> queryByType(String s);
    List<String> queryTypeList();
    void updateType(DeviceTypeEntity item);
}

