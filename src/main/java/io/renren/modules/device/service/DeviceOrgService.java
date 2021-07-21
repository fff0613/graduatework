package io.renren.modules.device.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.device.entity.DeviceOrgEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-08 13:57:16
 */
public interface DeviceOrgService extends IService<DeviceOrgEntity> {
    void insertOrg(DeviceOrgEntity item);
    void deleteOrg(DeviceOrgEntity item);
    PageUtils queryPage(Map<String, Object> params);
}

