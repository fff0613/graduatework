package io.renren.modules.device.service.impl;

import io.renren.modules.device.entity.*;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.device.dao.DeviceDao;
import io.renren.modules.device.service.DeviceService;


@Service("deviceService")
public class DeviceServiceImpl extends ServiceImpl<DeviceDao, DeviceEntity> implements DeviceService {

    @Override
    public List<DeviceEntity> queryName(Integer[] deviceids) {
        List<DeviceEntity> res = new ArrayList<>();
        for(Integer item :deviceids){
            res.add(baseMapper.queryById(item));
        }
        return res;
    }

    @Override
    public List<DeviceEntity> queryByCon(DeviceCon item) {
        String org = (String) item.getOrg();
        String state = (String) item.getState();
        String type = (String) item.getType();
        String devicename = (String) item.getDevicename();
        System.out.println(org +" "+state+" "+type+" "+devicename);
        if(devicename == null){
            if(org != null && state != null && type != null){
                return baseMapper.queryByOrgAndStateAndType(org,state,type);
            }else if (org != null && state != null){
                return baseMapper.queryByOrgAndState(org,state);
            }else if(org != null && type != null){
                return baseMapper.queryByOrgAndType(org,type);
            }else if(state != null && type != null){
                return baseMapper.queryByStateAndType(state,type);
            }else if(state != null){
                return baseMapper.queryByState(state);
            }else if(org != null){
                return baseMapper.queryByOrg(org);
            }else{
                return baseMapper.queryByType(type);
            }
        }else{
            if(org != null && state != null && type != null){
                return baseMapper.queryByOrgAndStateAndTypeAndName(org,state,type,devicename);
            }else if (org != null && state != null){
                return baseMapper.queryByOrgAndStateAndName(org,state,devicename);
            }else if(org != null && type != null){
                return baseMapper.queryByOrgAndTypeAndName(org,type,devicename);
            }else if(state != null && type != null){
                return baseMapper.queryByStateAndTypeAndName(state,type,devicename);
            }else if(state != null){
                return baseMapper.queryByStateAndName(state,devicename);
            }else if(org != null){
                return baseMapper.queryByOrgAndName(org,devicename);
            }else if(type != null){
                return baseMapper.queryByTypeAndName(type,devicename);
            }else
                return baseMapper.queryByName(devicename);
        }
    }

    @Override
    public List<DeviceEntity> queryByOrg(String org) {
        List<DeviceEntity> list = baseMapper.queryByOrg(org);
        List<DeviceIfoEntity> result = new LinkedList<>();
        deformation(result,list);
        return null;
    }

    @Override
    public List<DeviceEntity> queryByLoc(String loc) {
        List<DeviceEntity> list = baseMapper.queryByLoc(loc);
        List<DeviceIfoEntity> result = new LinkedList<>();
        deformation(result,list);
        return null;
    }

    @Override
    public List<DeviceEntity> queryByType(String type) {
        List<DeviceEntity> list = baseMapper.queryByType(type);
        List<DeviceIfoEntity> result = new LinkedList<>();
        deformation(result,list);
        return null;
    }

    @Override
    public List<DeviceEntity> queryByOrgAndLoc(String org, String loc) {
        List<DeviceEntity> list = baseMapper.queryByOrgAndLoc(org,loc);
        List<DeviceIfoEntity> result = new LinkedList<>();
        deformation(result,list);
        return null;
    }

    @Override
    public List<DeviceEntity> queryByOrgAndState(String org, String state) {
        List<DeviceEntity> list = baseMapper.queryByOrgAndState(org,state);
        List<DeviceIfoEntity> result = new LinkedList<>();
        deformation(result,list);
        return null;
    }

    @Override
    public List<DeviceEntity> queryByOrgAndType(String org, String type) {
        List<DeviceEntity> list = baseMapper.queryByOrgAndType(org,type);
        List<DeviceIfoEntity> result = new LinkedList<>();
        deformation(result,list);
        return null;
    }

    @Override
    public List<DeviceEntity> queryByLocAndState(String loc, String state) {
        List<DeviceEntity> list = baseMapper.queryByLocAndState(loc,state);
        List<DeviceIfoEntity> result = new LinkedList<>();
        deformation(result,list);
        return null;
    }

    @Override
    public List<DeviceEntity> queryByLocAndType(String loc, String type) {
        List<DeviceEntity> list = baseMapper.queryByLocAndType(loc,type);
        List<DeviceIfoEntity> result = new LinkedList<>();
        deformation(result,list);
        return null;
    }

    @Override
    public List<DeviceEntity> queryByStateAndType(String state, String type) {
        List<DeviceEntity> list = baseMapper.queryByStateAndType(state,type);
        List<DeviceIfoEntity> result = new LinkedList<>();
        deformation(result,list);
        return null;
    }

    @Override
    public List<DeviceEntity> queryByOrgAndStateAndLoc(String org, String loc, String state) {
        List<DeviceEntity> list = baseMapper.queryByOrgAndStateAndLoc(org,loc,state);
        List<DeviceIfoEntity> result = new LinkedList<>();
        deformation(result,list);
        return null;
    }

    @Override
    public List<DeviceEntity> queryByOrgAndStateAndType(String org, String state, String type) {
        List<DeviceEntity> list = baseMapper.queryByOrgAndStateAndType(org,state,type);
        List<DeviceIfoEntity> result = new LinkedList<>();
        deformation(result,list);
        return null;
    }

    @Override
    public List<DeviceEntity> queryByLocAndStateAndType(String loc, String state, String type) {
        List<DeviceEntity> list = baseMapper.queryByLocAndStateAndType(loc,state,type);
        List<DeviceIfoEntity> result = new LinkedList<>();
        deformation(result,list);
        return null;
    }

    @Override
    public List<DeviceEntity> queryByOrgAndStateAndLocAnaType(String org, String loc, String state, String type) {
        List<DeviceEntity> list = baseMapper.queryByOrgAndStateAndLocAnaType(org,loc,state,type);
        List<DeviceIfoEntity> result = new LinkedList<>();
        deformation(result,list);
        return null;
    }

    @Override
    public List<DeviceIfoEntity> queryBriefIfo() {
        List<DeviceEntity> list = baseMapper.queryAll();
        List<DeviceIfoEntity> result = new LinkedList<>();
        deformation(result,list);
        return result;
    }
    public void deformation(List<DeviceIfoEntity> result,List<DeviceEntity> list){
        for(DeviceEntity item : list){
            DeviceIfoEntity temp = new DeviceIfoEntity();
            temp.setDeviceid(item.getDeviceid());
            temp.setDevicename(item.getDevicename());
            temp.setDevicestate(item.getDevicestate());
            temp.setDevicetype(item.getDevicetype());
            temp.setManufacture(item.getManufacture());
            temp.setStockcontainer(item.getStockcontainer());
            temp.setStockid(item.getStockid());
            temp.setStockcontainer(item.getStockcontainer());
            temp.setStockname(item.getStockname());
            temp.setStockroom(item.getStockroom());
            temp.setStoragedate(item.getStoragedate());
            result.add(temp);
        }
    }

    @Override
    public List<DeviceEntity> queryByState(String state) {
        List<DeviceEntity> list = baseMapper.queryByState(state);
        List<DeviceEntity> result = new LinkedList<>();
//        deformation(result,list);
        return list;
    }

//    @Override
//    public List<DeviceEntity> queryByStockAndState(String stock, String state) {
//        return null;
//    }

    @Override
    public List<DeviceEntity> queryByStockAndState(String stock,String state) {
        return baseMapper.queryByStockAndState(stock,state);
    }


    @Override
    public List<io.renren.modules.device.entity.DeviceEntity> queryAll(){
        return baseMapper.queryAll();
    }
    public io.renren.modules.device.entity.DeviceEntity queryById(Integer deviceid) {
        return baseMapper.queryById(deviceid);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DeviceEntity> page = this.page(
                new Query<DeviceEntity>().getPage(params),
                new QueryWrapper<DeviceEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public String insertDevice(DeviceEntity item) {
//        if(isExisted())
//            return item.getDevicename()+" exist";
        try {
            baseMapper.insertDevice(item);
            return "insert success";
        }catch(Exception e) {
            System.out.println(e);
            return "insert fail";
        }
    }
    public boolean isExisted(Integer deviceid) {
        DeviceEntity deviceEntity = baseMapper.queryById(deviceid);
        if(deviceEntity == null)
            return false;
        else{
//            organizationEntities.toString();
            return true;
        }
    }
    @Override
    public void updateDevice(DeviceEntity item) {
        baseMapper.updateDevice(item);
    }

    @Override
    public void deleteDevice(Integer[] items) {
        for(Integer item:items)
            baseMapper.deleteDevice(item);
    }

    @Override
    public String updateBrief(DeviceBriefIfo item) {
//        if(isExisted(item.getId()))
//            return "already exist";
        baseMapper.updateBrief(item);
        return "update success";
    }

    @Override
    public void updateStock(String stockname, String state, Integer deviceid) {
        baseMapper.updateStock(stockname,state,deviceid);
    }

    @Override
    public List<DeviceBriefIfo> getDeviceList() {
        List<DeviceEntity> deviceList = baseMapper.getDeviceList();
        List<DeviceBriefIfo> result = new LinkedList<>();
        for(DeviceEntity item:deviceList){
            DeviceBriefIfo device = new DeviceBriefIfo();
            device.setId(item.getDeviceid());
            device.setName(item.getDevicename());
            result.add(device);
        }
        return result;
    }

    @Override
    public List<DeviceEntity> maintainSearch(Map<String, Object> params) {
        return baseMapper.queryByStorckAndName((String)params.get("stock"),(String)params.get("devicename"));
    }

    @Override
    public List<DeviceEntity> queryByStockAndName(String stock, String name) {
        return baseMapper.queryByStorckAndName(stock,name);
    }

    @Override
    public List<DeviceEntity> queryByStock(String stock) {
        return baseMapper.queryByStock(stock);
    }

    @Override
    public List<DeviceEntity> queryByName(String name) {
        return baseMapper.queryByName(name);
    }

}