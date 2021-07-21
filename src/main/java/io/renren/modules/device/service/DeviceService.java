package io.renren.modules.device.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.device.entity.DeviceBriefIfo;
import io.renren.modules.device.entity.DeviceCon;
import io.renren.modules.device.entity.DeviceEntity;
import io.renren.modules.device.entity.DeviceIfoEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-08 13:57:16
 */
public interface DeviceService extends IService<DeviceEntity> {
    List<DeviceEntity> queryName(Integer[] deviceids);
    List<DeviceEntity> queryByCon(DeviceCon item);
    List<DeviceEntity> queryByOrg(String org);
    List<DeviceEntity> queryByLoc(String loc);
    List<DeviceEntity> queryByType(String type);
    List<DeviceEntity> queryByOrgAndLoc(String org,String loc);
    List<DeviceEntity> queryByOrgAndState(String org,String state);
    List<DeviceEntity> queryByOrgAndType(String org,String type);
    List<DeviceEntity> queryByLocAndState(String loc,String state);
    List<DeviceEntity> queryByLocAndType(String loc,String type);
    List<DeviceEntity> queryByStateAndType(String state,String type);
    List<DeviceEntity> queryByOrgAndStateAndLoc(String org,String loc,String state);
    List<DeviceEntity> queryByOrgAndStateAndType(String org,String state,String type);
    List<DeviceEntity> queryByLocAndStateAndType(String loc,String state,String type);
    List<DeviceEntity> queryByOrgAndStateAndLocAnaType(String org,String loc,String state,String type);
    List<DeviceIfoEntity> queryBriefIfo();
    List<DeviceEntity> queryByState(String state);
    List<DeviceEntity> queryByStockAndState(String stock,String state);
    List<DeviceEntity> queryAll();
    DeviceEntity queryById(Integer deviceid);
    PageUtils queryPage(Map<String, Object> params);
    String insertDevice(DeviceEntity item);
    void updateDevice(DeviceEntity item);
    void deleteDevice(Integer[] items);
    String updateBrief(DeviceBriefIfo item);
    void updateStock(String stockname,String state,Integer deviceid);
    List<DeviceBriefIfo> getDeviceList();
    List<DeviceEntity> maintainSearch(Map<String, Object> params);
    List<DeviceEntity> queryByStockAndName(String stock,String name);
    List<DeviceEntity> queryByStock(String stock);
    List<DeviceEntity> queryByName(String name);
}

