package io.renren.modules.device.dao;

import io.renren.modules.device.entity.DeviceOrgEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-08 13:57:16
 */
@Mapper
public interface DeviceOrgDao extends BaseMapper<DeviceOrgEntity> {
	void insertOrg(DeviceOrgEntity item);
	void deleteOrg(DeviceOrgEntity item);
}
