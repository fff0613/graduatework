package io.renren.modules.device.dao;

import com.qiniu.linking.model.Device;
import io.renren.modules.device.entity.DeviceTypeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-08 13:57:16
 */
@Mapper
public interface DeviceTypeDao extends BaseMapper<DeviceTypeEntity> {
	List<DeviceTypeEntity> queryAll();
	String insertType(DeviceTypeEntity item);
	void updateState(DeviceTypeEntity item);
	List<DeviceTypeEntity> queryByName(String s);
	List<String> queryAllType();
	String updateType(DeviceTypeEntity item);
}
