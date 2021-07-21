package io.renren.modules.device.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.device.entity.DeviceUserEntity;
import io.renren.modules.device.entity.FellowEntity;
import io.renren.modules.sys.entity.SysUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-08 13:57:16
 */
public interface DeviceUserService extends IService<DeviceUserEntity> {
    List<SysUserEntity> getUserByDeviceId(Integer deviceid, String role);
    List<FellowEntity> queryFellow(int deviceId);
    String insertFellow(FellowEntity item);
    void deleteFellow(FellowEntity item);
    PageUtils queryPage(Map<String, Object> params);
}

