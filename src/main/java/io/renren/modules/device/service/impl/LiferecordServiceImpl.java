package io.renren.modules.device.service.impl;

import com.sun.org.apache.xpath.internal.operations.Bool;
import io.renren.modules.device.entity.*;
import io.renren.modules.device.service.DeviceService;
import io.renren.modules.device.service.StockService;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import io.renren.modules.sys.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.device.dao.LiferecordDao;
import io.renren.modules.device.service.LiferecordService;


@Service("liferecordService")
public class LiferecordServiceImpl extends ServiceImpl<LiferecordDao, LiferecordEntity> implements LiferecordService {
    @Autowired
    SysUserService sysUserService;
    @Autowired
    StockService stockService;
    @Autowired
    DeviceService deviceService;

    @Override
    public String executeInventory(InventoryEntity[] inventoryEntities) {
        try{
            if(inventoryEntities.length != 0){
                for(InventoryEntity item :inventoryEntities){
                    baseMapper.executeInventory(item);
                }
                String s = sysUserService.queryByUserId(inventoryEntities[0].getExecutorid());
                inventoryEntities[0].setExecutorname(s);
                baseMapper.updateExecutorid(inventoryEntities[0]);
            }
            return "execute finish";
        }catch (Exception e){
            e.printStackTrace();
            return "execute fail";
        }

    }

    @Override
    public List<DeviceEntity> getInventoryDeviceList(Long recordid) {
//        LiferecordEntity record = getById(recordid);
        List<Integer> deviceList = baseMapper.getDeviceList(recordid);
        List<DeviceEntity> deviceEntities = new ArrayList<>();
        List<InventoryComplete> inventoryComplete = baseMapper.getInventoryComplete(recordid);
        Map<Integer,Boolean> map = new HashMap<>();
        if(inventoryComplete.size() != 0){
            for(InventoryComplete item:inventoryComplete){
                map.put(item.getDeviceid(),item.isDohave());
            }
        }
        if(deviceList.size() != 0){
            for(Integer id:deviceList){
                DeviceEntity deviceEntity = deviceService.queryById(id);
                Boolean dohave = map.get(deviceEntity.getDeviceid());
                if(dohave != null && dohave)
                    deviceEntity.setStockdetailloc("有");
                else
                    deviceEntity.setStockdetailloc("无");
                deviceEntities.add(deviceEntity);

            }
        }
        return deviceEntities;
    }

    public void addResult(List<LiferecordEntity> liferecordEntities,List<StorageEntity> result){
        for(LiferecordEntity l:liferecordEntities){
            StorageEntity storageEntity = new StorageEntity();
            storageEntity.setAmount(l.getAmount());
            storageEntity.setHappentime(l.getHappentime());
            storageEntity.setOrgname(l.getOrgname());
            storageEntity.setRecordid(l.getRecordid());
            storageEntity.setReporter(l.getReportername());
            storageEntity.setState(l.getState());
            storageEntity.setStockname(l.getStockname());

            result.add(storageEntity);
        }
    }
    public void addResultTwo(List<LiferecordEntity> liferecordEntities,List<DeliveryEntity> result){
        for(LiferecordEntity l:liferecordEntities){
            DeliveryEntity storageEntity = new DeliveryEntity();
            storageEntity.setAmount(l.getAmount());
            storageEntity.setHappentime(l.getHappentime());
            storageEntity.setOrgname(l.getOrgname());
            storageEntity.setRecordid(l.getRecordid());
            storageEntity.setReporter(l.getReportername());
            storageEntity.setState(l.getState());
            storageEntity.setStockname(l.getStockname());
            storageEntity.setExecutor(l.getExecutorname());
            result.add(storageEntity);
        }
    }

    @Override
    public List<LiferecordEntity> queryAll() {
        return baseMapper.queryAll();
    }

    @Override
    public List<SysUserEntity> queryFellowList() {
        return sysUserService.queryList();
    }

    @Override
    public List<LiferecordEntity> storageByCondition(LifeCon item) {
        System.out.println(item);
        List<LiferecordEntity> result = new LinkedList<>();
        List<Long> name = new ArrayList<>();
        if(item.getExecutor() != null)
            name = sysUserService.getIdByUserName(item.getExecutor());
        else
            name = null;
        System.out.println(name);
        String state = item.getState(),stock = item.getStock();
        List<LiferecordEntity> liferecordEntities = new ArrayList<>();
        if(item.getExecutor() != null && state != null && stock != null){
//            for(Long n : name){
                liferecordEntities = baseMapper.storageByStockAndStateAndExecutor(stock, state, item.getExecutor());
//                addResult(liferecordEntities,result);
                for(LiferecordEntity temp : liferecordEntities)
                    result.add(temp);
//            }
        }else if(item.getExecutor() != null && state != null){
//            for(Long n : name){
                 liferecordEntities = baseMapper.storageByStateAndExecutor(state,item.getExecutor());
//                addResult(liferecordEntities,result);

//            }
        }else if(item.getExecutor() != null && stock != null){
//            for(Long n : name){
                 liferecordEntities = baseMapper.storageByStockAndExecutor(stock,item.getExecutor());
//                for(LiferecordEntity temp : liferecordEntities)
//                    result.add(temp);
//            }
        }else if(state != null && stock != null){
            liferecordEntities = baseMapper.storageByStockAndState(stock,state);
//            addResult(liferecordEntities,result);
        }else if(item.getExecutor() != null){
//            for(Long n : name){
                 liferecordEntities = baseMapper.storageByExecutor(item.getExecutor());
//                addResult(liferecordEntities,result);
//            }
        }else if(state != null){
             liferecordEntities = baseMapper.storageByState(state);
//            addResult(liferecordEntities,result);
        }else if(stock != null){
            liferecordEntities = baseMapper.storageByStock(stock);
//            addResult(liferecordEntities,result);
        }
        System.out.println("life "+liferecordEntities);
        for(LiferecordEntity temp : liferecordEntities)
            result.add(temp);
        System.out.println(result);
        return result;
    }
    @Override
    public List<LiferecordEntity> transferByCondition(LifeCon item) {
        List<LiferecordEntity> result = new LinkedList<>();
//        List<Long> name = new ArrayList<>();
//        if(item.getExecutor() != null)
//            name = sysUserService.getIdByUserName(item.getExecutor());
//        else
//            name = null;
        String state = item.getState(),stock = item.getStock();
        List<LiferecordEntity> liferecordEntities = new ArrayList<>();
        if(item.getExecutor() != null && state != null && stock != null){
//            for(Long n : name){
            liferecordEntities = baseMapper.transferByStockAndStateAndExecutor(stock, state, item.getExecutor());
//                addResultTwo(liferecordEntities,result);
//            }
        }else if(item.getExecutor() != null && state != null){
//            for(Long n : name){
            liferecordEntities = baseMapper.transferByStateAndExecutor(state,item.getExecutor());
//                addResultTwo(liferecordEntities,result);
//            }
        }else if(item.getExecutor() != null && stock != null){
//            for(Long n : name){
            liferecordEntities = baseMapper.transferByStockAndExecutor(stock,item.getExecutor());
//                addResultTwo(liferecordEntities,result);
//            }
        }else if(state != null && stock != null){
            liferecordEntities = baseMapper.transferByStockAndState(stock,state);
//            addResultTwo(liferecordEntities,result);
        }else if(item.getExecutor() != null){
//            for(Long n : name){
            liferecordEntities = baseMapper.transferByExecutor(item.getExecutor());
//                addResultTwo(liferecordEntities,result);
//            }
        }else if(state != null){
            liferecordEntities = baseMapper.transferByState(state);
//            addResultTwo(liferecordEntities,result);
        }else if(stock != null){
            liferecordEntities = baseMapper.transferByStock(stock);
//            addResultTwo(liferecordEntities,result);
        }
        for(LiferecordEntity temp : liferecordEntities)
            result.add(temp);
        System.out.println(result);
        return result;
    }

    @Override
    public List<LiferecordEntity> deliveryByCondition(LifeCon item) {
        List<LiferecordEntity> result = new LinkedList<>();
//        List<Long> name = new ArrayList<>();
//        if(item.getExecutor() != null)
//            name = sysUserService.getIdByUserName(item.getExecutor());
//        else
//            name = null;
        String state = item.getState(),stock = item.getStock();
        List<LiferecordEntity> liferecordEntities = new ArrayList<>();
        if(item.getExecutor() != null && state != null && stock != null){
//            for(Long n : name){
                liferecordEntities = baseMapper.deliveryByStockAndStateAndExecutor(stock, state, item.getExecutor());
//                addResultTwo(liferecordEntities,result);
//            }
        }else if(item.getExecutor() != null && state != null){
//            for(Long n : name){
                liferecordEntities = baseMapper.deliveryByStateAndExecutor(state,item.getExecutor());
//                addResultTwo(liferecordEntities,result);
//            }
        }else if(item.getExecutor() != null && stock != null){
//            for(Long n : name){
                 liferecordEntities = baseMapper.deliveryByStockAndExecutor(stock,item.getExecutor());
//                addResultTwo(liferecordEntities,result);
//            }
        }else if(state != null && stock != null){
            liferecordEntities = baseMapper.deliveryByStockAndState(stock,state);
//            addResultTwo(liferecordEntities,result);
        }else if(item.getExecutor() != null){
//            for(Long n : name){
                liferecordEntities = baseMapper.deliveryByExecutor(item.getExecutor());
//                addResultTwo(liferecordEntities,result);
//            }
        }else if(state != null){
             liferecordEntities = baseMapper.deliveryByState(state);
//            addResultTwo(liferecordEntities,result);
        }else if(stock != null){
             liferecordEntities = baseMapper.deliveryByStock(stock);
//            addResultTwo(liferecordEntities,result);
        }
        for(LiferecordEntity temp : liferecordEntities)
            result.add(temp);
        System.out.println(result);
        return result;
    }

    @Override
    public List<LiferecordEntity> allocationByCondition(LifeCon item) {
        List<LiferecordEntity> result = new LinkedList<>();
//        List<Long> name = new ArrayList<>();
//        if(item.getExecutor() != null)
//            name = sysUserService.getIdByUserName(item.getExecutor());
//        else
//            name = null;
        String state = item.getState(),stock = item.getStock();
        List<LiferecordEntity> liferecordEntities = new ArrayList<>();
        if(item.getExecutor() != null && state != null && stock != null){
//            for(Long n : name){
            liferecordEntities = baseMapper.allocationByStockAndStateAndExecutor(stock, state, item.getExecutor());
//                addResultTwo(liferecordEntities,result);
//            }
        }else if(item.getExecutor() != null && state != null){
//            for(Long n : name){
            liferecordEntities = baseMapper.allocationByStateAndExecutor(state,item.getExecutor());
//                addResultTwo(liferecordEntities,result);
//            }
        }else if(item.getExecutor() != null && stock != null){
//            for(Long n : name){
            liferecordEntities = baseMapper.allocationByStockAndExecutor(stock,item.getExecutor());
//                addResultTwo(liferecordEntities,result);
//            }
        }else if(state != null && stock != null){
            liferecordEntities = baseMapper.allocationByStockAndState(stock,state);
//            addResultTwo(liferecordEntities,result);
        }else if(item.getExecutor() != null){
//            for(Long n : name){
            liferecordEntities = baseMapper.allocationByExecutor(item.getExecutor());
//                addResultTwo(liferecordEntities,result);
//            }
        }else if(state != null){
            liferecordEntities = baseMapper.allocationByState(state);
//            addResultTwo(liferecordEntities,result);
        }else if(stock != null){
            liferecordEntities = baseMapper.allocationByStock(stock);
//            addResultTwo(liferecordEntities,result);
        }
        for(LiferecordEntity temp : liferecordEntities)
            result.add(temp);
        System.out.println(result);
        return result;
    }

    @Override
    public List<LiferecordEntity> scrapByCondition(LifeCon item) {
        List<LiferecordEntity> result = new LinkedList<>();
//        List<Long> name = new ArrayList<>();
//        if(item.getExecutor() != null)
//            name = sysUserService.getIdByUserName(item.getExecutor());
//        else
//            name = null;
        String state = item.getState(),stock = item.getStock();
        List<LiferecordEntity> liferecordEntities = new ArrayList<>();
        if(item.getExecutor() != null && state != null && stock != null){
//            for(Long n : name){
            liferecordEntities = baseMapper.scrapByStockAndStateAndExecutor(stock, state, item.getExecutor());
//                addResultTwo(liferecordEntities,result);
//            }
        }else if(item.getExecutor() != null && state != null){
//            for(Long n : name){
            liferecordEntities = baseMapper.scrapByStateAndExecutor(state,item.getExecutor());
//                addResultTwo(liferecordEntities,result);
//            }
        }else if(item.getExecutor() != null && stock != null){
//            for(Long n : name){
            liferecordEntities = baseMapper.scrapByStockAndExecutor(stock,item.getExecutor());
//                addResultTwo(liferecordEntities,result);
//            }
        }else if(state != null && stock != null){
            liferecordEntities = baseMapper.scrapByStockAndState(stock,state);
//            addResultTwo(liferecordEntities,result);
        }else if(item.getExecutor() != null){
//            for(Long n : name){
            liferecordEntities = baseMapper.scrapByExecutor(item.getExecutor());
//                addResultTwo(liferecordEntities,result);
//            }
        }else if(state != null){
            liferecordEntities = baseMapper.scrapByState(state);
//            addResultTwo(liferecordEntities,result);
        }else if(stock != null){
            liferecordEntities = baseMapper.scrapByStock(stock);
//            addResultTwo(liferecordEntities,result);
        }
        for(LiferecordEntity temp : liferecordEntities)
            result.add(temp);
        System.out.println(result);
        return result;
    }

    @Override
    public List<LiferecordEntity> inventoryByCondition(LifeCon item) {
        List<LiferecordEntity> result = new LinkedList<>();
//        List<Long> name = new ArrayList<>();
//        if(item.getExecutor() != null)
//            name = sysUserService.getIdByUserName(item.getExecutor());
//        else
//            name = null;
        String state = item.getState(),stock = item.getStock();
        List<LiferecordEntity> liferecordEntities = new ArrayList<>();
        if(item.getExecutor() != null && state != null && stock != null){
//            for(Long n : name){
            liferecordEntities = baseMapper.inventoryByStockAndStateAndExecutor(stock, state, item.getExecutor());
//                addResultTwo(liferecordEntities,result);
//            }
        }else if(item.getExecutor() != null && state != null){
//            for(Long n : name){
            liferecordEntities = baseMapper.inventoryByStateAndExecutor(state,item.getExecutor());
//                addResultTwo(liferecordEntities,result);
//            }
        }else if(item.getExecutor() != null && stock != null){
//            for(Long n : name){
            liferecordEntities = baseMapper.inventoryByStockAndExecutor(stock,item.getExecutor());
//                addResultTwo(liferecordEntities,result);
//            }
        }else if(state != null && stock != null){
            liferecordEntities = baseMapper.inventoryByStockAndState(stock,state);
//            addResultTwo(liferecordEntities,result);
        }else if(item.getExecutor() != null){
//            for(Long n : name){
            liferecordEntities = baseMapper.inventoryByExecutor(item.getExecutor());
//                addResultTwo(liferecordEntities,result);
//            }
        }else if(state != null){
            liferecordEntities = baseMapper.inventoryByState(state);
//            addResultTwo(liferecordEntities,result);
        }else if(stock != null){
            liferecordEntities = baseMapper.inventoryByStock(stock);
//            addResultTwo(liferecordEntities,result);
        }
        for(LiferecordEntity temp : liferecordEntities)
            result.add(temp);
        System.out.println(result);
        return result;
    }

    @Override
    public List<DeviceLogEntity> queryAllLog(Integer deviceId) {
        List<LiferecordEntity> list = baseMapper.queryById(deviceId);
        List<DeviceLogEntity> result = new LinkedList<>();
        for(LiferecordEntity item:list){
            DeviceLogEntity temp = new DeviceLogEntity();
            String username = sysUserService.queryByUserId(item.getExecutorid());
            temp.setDescr(username+"执行了"+item.getRecordtype()+"操作,状态为"+item.getState());
            temp.setHappenDate(item.getHappentime());
            temp.setFellow(username);
            result.add(temp);
        }
        return result;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LiferecordEntity> page = this.page(
                new Query<LiferecordEntity>().getPage(params),
                new QueryWrapper<LiferecordEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<LiferecordEntity> storagelist() {
//        List<LiferecordEntity> storagelist = baseMapper.storagelist();
//        for(LiferecordEntity item :storagelist){
//
//        }
        return baseMapper.storagelist();
    }

    @Override
    public List<LiferecordEntity> deliverylist() {
        return baseMapper.deliverylist();
    }

    @Override
    public List<LiferecordEntity> transferlist() {
        return baseMapper.transferlist();
    }

    @Override
    public List<LiferecordEntity> stockreturnlist() {
        return baseMapper.stockreturnlist();
    }

    @Override
    public List<LiferecordEntity> returnlist() {
        return baseMapper.returnlist();
    }

    @Override
    public List<LiferecordEntity> lentlist() {
        return baseMapper.lentlist();
    }

    @Override
    public List<LiferecordEntity> givebacklist() {
        return baseMapper.givebacklist();
    }

    @Override
    public List<LiferecordEntity> inventorylist() {

        return baseMapper.inventorylist();
    }

    @Override
    public List<LiferecordEntity> scraplist() {
        return baseMapper.scraplist();
    }

    @Override
    public List<LiferecordEntity> allocationlist() {
        return baseMapper.allocationlist();
    }

    @Override
    public String addRecord(RecordEntity item) {
        String type = item.getStoragetype();
        String username = sysUserService.queryByUserId(item.getReporterid());
        String exeUserName = sysUserService.queryByUserId(item.getExecutorid());
        System.out.println("username "+username);
//        try {
//            for (Liferecorddevice device : item.getDevicelist()) {
                LiferecordEntity life = new LiferecordEntity();
                life.setDeviceid(item.getDeviceid());
                life.setRecordtype("入库");
                life.setHappentime(item.getStoragetime());
                life.setOrgname(stockService.getOrgName(item.getStockname()));
                life.setStockname(item.getStockname());
                life.setOldstockname(item.getOriginstock());
                life.setReportername(username);//名字
                life.setReporterid(item.getReporterid());
                life.setExecutorid(item.getExecutorid());
                life.setExecutorname(exeUserName);
                life.setAmount(item.getAmount());
                life.setState("已完成");
                life.setDescr(item.getDescr());
                life.setStoragebatch(item.getStockbatch());
                life.setDevicename(item.getDevicename());
                life.setStoragetype(type);
                if (type.equals("转移") || (item.getOriginstock() != null && !item.getOriginstock().equals(""))) {
                    life.setStoragetype("转移");
                    life.setOldstockname(item.getOriginstock());
                    life.setOldorgname(stockService.getOrgName(item.getOriginstock()));
                    baseMapper.insertTransfer(life);
//                life.setOldstockroom(item.getOldRoom());
//                life.setOldcompanyname(item.getOldCompany());
//                life.setOldStockContainer(item.getOldStockContainer());
                }else if (type.equals("入库") || type.equals("退库") || type.equals("归还")) {

                    baseMapper.insertStorage(life);
                }
                System.out.println("addRecord "+life);
                deviceService.updateStock(item.getStockname(),"在库中",item.getDeviceid());
//            }
            return "insert success";
//        }catch(Exception e){
//            System.out.println(e);
//            return "insert fail";
//        }


    }

    @Override
    public String addScrap(RecordEntity item) {
        String username = sysUserService.queryByUserId(item.getReporterid());
        LiferecordEntity life = new LiferecordEntity();
        String exeUserName = sysUserService.queryByUserId(item.getExecutorid());
        life.setExecutorid(item.getExecutorid());
        life.setExecutorname(exeUserName);
        life.setDeviceid(item.getDeviceid());
        life.setRecordtype("报废");
        life.setHappentime(item.getStoragetime());
        life.setOrgname(stockService.getOrgName(item.getStockname()));
        life.setStockname(item.getStockname());
        life.setOldstockname(item.getOriginstock());
        life.setReportername(username);//名字
        life.setReporterid(item.getReporterid());
        life.setAmount(item.getAmount());
        life.setState("已完成");
        life.setDescr(item.getDescr());
        life.setDevicename(item.getDevicename());
//        life.setStoragebatch(item.getStockbatch());
        baseMapper.insertScrap(life);
        deviceService.updateStock(item.getStockname(),"已报废",item.getDeviceid());

        return "insert success";
    }

    @Override
    public String addInventory(InventoryRecordEntity item) {
        Integer[] device = item.getDevice();
        String username = sysUserService.queryByUserId(item.getReporterid());
        LiferecordEntity life = new LiferecordEntity();
        String exeUserName = sysUserService.queryByUserId(item.getExecutorid());
        life.setExecutorid(item.getExecutorid());
        life.setExecutorname(exeUserName);
        life.setDeviceid(device[0]);
        life.setRecordtype("盘点");
        life.setHappentime(item.getStoragetime());
        life.setOrgname(stockService.getOrgName(item.getStockname()));
        life.setStockname(item.getStockname());
        life.setOldstockname(item.getOriginstock());
        life.setReportername(username);//名字
        life.setReporterid(item.getReporterid());
        life.setAmount(item.getAmount());
        life.setState("待处理");
        life.setDescr(item.getDescr());
//        life.setStoragebatch(item.getStockbatch());
        Long aLong = baseMapper.insertInventory(life);
        deviceService.updateStock(item.getStockname(),"在库中",item.getDeviceid());
        for(Integer id:device){
            baseMapper.insertInventoryDevice(life.getRecordid(),id);
        }
        return "insert success";
    }

    @Override
    public String addAllocation(RecordEntity item) {
        String username = sysUserService.queryByUserId(item.getReporterid());
        LiferecordEntity life = new LiferecordEntity();
        String exeUserName = sysUserService.queryByUserId(item.getExecutorid());
        life.setExecutorid(item.getExecutorid());
        life.setExecutorname(exeUserName);
        life.setDeviceid(item.getDeviceid());
        life.setRecordtype("调拨");
        life.setHappentime(item.getStoragetime());
        life.setOrgname(stockService.getOrgName(item.getStockname()));
        life.setStockname(item.getStockname());
        life.setOldstockname(item.getOriginstock());
        life.setReportername(username);//名字
        life.setReporterid(item.getReporterid());
        life.setAmount(item.getAmount());
        life.setState("已完成");
        life.setDescr(item.getDescr());
        life.setDevicename(item.getDevicename());
//        life.setStoragebatch(item.getStockbatch());
        baseMapper.insertAllocation(life);
        deviceService.updateStock(item.getStockname(),"已出库",item.getDeviceid());

        return "insert success";
    }

    @Override
    public List<LiferecordEntity> queryByContent(Long id, String content) {
        return baseMapper.queryByContent(id,content);
    }

    @Override
    public List<LiferecordEntity> queryByExeId(Long id) {
        return baseMapper.queryByExeId(id);
    }



    @Override
    public String addDelivery(RecordEntity item) {
//        item.setReporterid(CurrentUserEntity.userid);
        String username = sysUserService.queryByUserId(item.getReporterid());
        String exeUserName = sysUserService.queryByUserId(item.getExecutorid());
        LiferecordEntity life = new LiferecordEntity();
//        String exeUserName = sysUserService.queryByUserId(item.getExecutorid());
        life.setExecutorid(item.getExecutorid());
        life.setExecutorname(exeUserName);
        life.setDeviceid(item.getDeviceid());
        life.setRecordtype("出库");
        life.setHappentime(item.getStoragetime());
        life.setOrgname(stockService.getOrgName(item.getStockname()));
        life.setOldorgname(stockService.getOrgName(item.getOriginstock()));
        life.setStockname(item.getStockname());
        life.setOldstockname(item.getOriginstock());
        life.setReportername(username);//名字
        life.setReporterid(item.getReporterid());
        life.setExecutorid(item.getExecutorid());
        life.setAmount(item.getAmount());
        life.setState("已完成");
        life.setDescr(item.getDescr());
        life.setDevicename(item.getDevicename());
        life.setStoragebatch(item.getStockbatch());
        life.setStoragetype(item.getStoragetype());
        baseMapper.insertDelivery(life);
        System.out.println("addDelivery "+life);
        deviceService.updateStock(item.getStockname(),"已出库",item.getDeviceid());

        return "insert success";
    }

    public void setEntity(RecordEntity item,LiferecordEntity life){
    }



}