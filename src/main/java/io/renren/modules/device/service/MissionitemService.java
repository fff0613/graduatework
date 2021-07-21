package io.renren.modules.device.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.device.entity.MaintainTempEntity;
import io.renren.modules.device.entity.MissionitemEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-17 23:33:31
 */
public interface MissionitemService extends IService<MissionitemEntity> {
    List<MissionitemEntity> queryAll();
    void insertItem(MissionitemEntity item);
    void updateItem(MissionitemEntity item);
    void deleteItem(Integer[] itemid);
    List<MissionitemEntity> queryByName(String name);
    MissionitemEntity queryById(Integer itemid);
    PageUtils queryPage(Map<String, Object> params);
    //app
    List<MaintainTempEntity> queryByDevice(Integer deviceid,Integer orderid);
    void updateList(MaintainTempEntity[] list);
}

