package io.renren.modules.device.dao;

import io.renren.modules.device.entity.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.omg.CORBA.INTERNAL;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-08 13:57:16
 */
@Mapper
public interface DeviceDao extends BaseMapper<DeviceEntity> {
//    List<String> queryByType(String type);
    void updateStock(String stockname,String state,Integer deviceid);
    List<MaintainEntity> queryRepairLog(Integer deviceid);
    List<MaintainEntity> queryMaintainLog(Integer deviceid);
    List<LiferecordEntity> queryDeviceLog(Integer deviceid);
    List<DeviceEntity> queryByStockAndState(String stock,String state);
    List<DeviceEntity> queryByStock(String stock);
    List<DeviceEntity> queryByStorckAndName(String stock,String name);
    Integer insertDevice(DeviceEntity device);
    void updateDevice(DeviceEntity device);
    void updateBrief(DeviceBriefIfo item);
    void deleteDevice(Integer deviceId);
    Map<String,Object> queryLoc(Integer deviceId);
    List<DeviceEntity> getDeviceList();
    CompanyEntity queryManuList(Integer deviceId);
    CompanyEntity querySupList(Integer deviceId);
    List<OrganizationEntity> queryOrgList(Integer deviceId);
    List<DeviceEntity> queryAll();
    List<DeviceEntity> queryByState(String state);
    DeviceEntity queryById(int deviceid);
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
    List<DeviceEntity> queryByOrgAndStateAndTypeAndName(String org,String state,String type,String name);
    List<DeviceEntity> queryByOrgAndStateAndName(String org,String state,String name);
    List<DeviceEntity> queryByOrgAndTypeAndName(String org,String type,String name);
    List<DeviceEntity> queryByStateAndTypeAndName(String state,String type,String name);
    List<DeviceEntity> queryByOrgAndName(String org,String name);
    List<DeviceEntity> queryByTypeAndName(String type,String name);
    List<DeviceEntity> queryByStateAndName(String state,String name);
    List<DeviceEntity> queryByName(String name);
    List<DeviceEntity> queryByStockAndName(String stock,String name);
}
