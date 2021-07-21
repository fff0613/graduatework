package io.renren.modules.device.dao;

import io.renren.modules.device.entity.DeviceModelEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.device.entity.DeviceTypeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-08 13:57:16
 */
@Mapper
public interface DeviceModelDao extends BaseMapper<DeviceModelEntity> {
    List<String> queryByType(String type);
    List<DeviceModelEntity> queryAll();
    String insertModel(DeviceModelEntity item);
    List<DeviceModelEntity> queryByName(String s);
    List<String> queryModelList();
    void updateModel(DeviceModelEntity model);
    void deleteModel(String model);
}
