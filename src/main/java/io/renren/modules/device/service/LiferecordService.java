package io.renren.modules.device.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.device.entity.*;
import io.renren.modules.sys.entity.SysUserEntity;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-09 12:43:22
 */
public interface LiferecordService extends IService<LiferecordEntity> {
    //历史数据
//    List<LiferecordEntity> getLifeBetweenStartAndEnd(Date start,Date end);
    /**/
    String executeInventory(InventoryEntity[] inventoryEntities);
    List<DeviceEntity> getInventoryDeviceList(Long recordid);
//    List<DeviceEntity> getInventoryIfo(Long recordid);
    //app
    List<LiferecordEntity> queryByContent(Long id,String content);
    List<LiferecordEntity> queryByExeId(Long id);
    List<LiferecordEntity> queryAll();
    List<SysUserEntity> queryFellowList();
    List<LiferecordEntity> transferByCondition(LifeCon item);
    List<LiferecordEntity> storageByCondition(LifeCon item);
    List<LiferecordEntity> deliveryByCondition(LifeCon item);
    List<LiferecordEntity> allocationByCondition(LifeCon item);
    List<LiferecordEntity> scrapByCondition(LifeCon item);
    List<LiferecordEntity> inventoryByCondition(LifeCon item);
    List<DeviceLogEntity> queryAllLog(Integer deviceId);
    PageUtils queryPage(Map<String, Object> params);
    List<LiferecordEntity> storagelist();
    List<LiferecordEntity> deliverylist();
    List<LiferecordEntity> transferlist();
    List<LiferecordEntity> stockreturnlist();
    List<LiferecordEntity> returnlist();
    List<LiferecordEntity> lentlist();
    List<LiferecordEntity> givebacklist();
    List<LiferecordEntity> inventorylist();
    List<LiferecordEntity> scraplist();
    List<LiferecordEntity> allocationlist();
    String addRecord(RecordEntity item);
    String addScrap(RecordEntity item);
    String addInventory(InventoryRecordEntity item);
    String addAllocation(RecordEntity item);
    String addDelivery(RecordEntity item);
//    String updateRecord(RecordEntity item);
}

