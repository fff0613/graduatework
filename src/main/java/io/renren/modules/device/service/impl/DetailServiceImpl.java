package io.renren.modules.device.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.device.dao.DeviceDao;
import io.renren.modules.device.entity.*;
import io.renren.modules.device.service.*;
import io.renren.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service("detailService")
public class DetailServiceImpl extends ServiceImpl<DeviceDao, DeviceEntity> implements DetailService {
    @Autowired
    StockService stockService;
    @Autowired
    SysUserService sysUserService;
    @Autowired
    DeviceService deviceService;
    @Autowired
    MaintainService maintainService;
    @Autowired
    MaintainprojectService maintainprojectService;


    @Override
    public List<MaintainprojectEntity> getProList(Integer deviceid) {
        List<MaintainprojectEntity> proList = maintainprojectService.getProList(deviceid);
//        List<MaintainprojectEntity> result = new ArrayList<>();
//        for(int i = 0;i < proList.size();i++){
//            if(proList.get(i) != null)
//                proList.remove(i);
//        }
        return proList;
    }

    @Override
    public List<OrganizationEntity> queryOrg(int deviceId) {
        List<OrganizationEntity> list = baseMapper.queryOrgList(deviceId);
        for(int i = 0;i < list.size();i++){
            if(list.get(i) == null)
                list.remove(i);
        }
        return list;
    }

    @Override
    public List<CompanyEntity> queryCompany(int deviceId) {
        List<CompanyEntity> list = new ArrayList<>();
        CompanyEntity manu = baseMapper.queryManuList(deviceId);
        CompanyEntity sup = baseMapper.querySupList(deviceId);
        list.add(manu);
        list.add(sup);
        System.out.println(list);
        for(int i = 0;i < list.size();i++){
            if(list.get(i) == null)
                list.remove(i);
        }
        return list;
    }

    @Override
    public DeviceLocEntity queryLoc(int deviceId) {
        System.out.println(deviceId +" deviceid");
        Map<String, Object> map = baseMapper.queryLoc(deviceId);
        DeviceLocEntity deviceLocEntity = null;
        //stockName,stockRoom,stockDetailLoc,stockContainer
        for(Map.Entry<String,Object> item :map.entrySet()){
            System.out.println(item.getKey() +"ass"+item.getValue()+"wrr");
        }
        if(map.get("stockName") != null && !map.get("stockName").equals("")){
            List<StockEntity> stockEntities = stockService.queryByName((String)map.get("stockName"));
            deviceLocEntity.setStockname((String)map.get("stockName"));
            if(stockEntities != null && stockEntities.size() != 0){
                deviceLocEntity.setCountry(stockEntities.get(0).getCountry());
                deviceLocEntity.setProvince(stockEntities.get(0).getProvince());
                deviceLocEntity.setCity(stockEntities.get(0).getCity());
                deviceLocEntity.setDistrict(stockEntities.get(0).getDistrict());
                deviceLocEntity.setStreet(stockEntities.get(0).getStreet());
                deviceLocEntity.setStreetnumber(stockEntities.get(0).getStreetnumber());
                deviceLocEntity.setStockroom((String)map.get("stockRoom"));
                deviceLocEntity.setStockdetailloc((String)map.get("stockDetailLoc"));
                deviceLocEntity.setStockcontainer((String)map.get("stockContainer"));
                deviceLocEntity.setStocktype(stockEntities.get(0).getStocktype());
            }
            System.out.println(deviceLocEntity.toString());
        }

        return deviceLocEntity;
    }

    @Override
    public List<DeviceLogEntity> queryDeviceLog(int deviceId) {
        List<LiferecordEntity> list = baseMapper.queryDeviceLog(deviceId);
        List<DeviceLogEntity> result = new LinkedList<>();
        for(LiferecordEntity item :list){
            DeviceLogEntity temp = new DeviceLogEntity();
            temp.setHappenDate(item.getHappentime());
            temp.setFellow(sysUserService.queryByUserId(item.getExecutorid()));
            StringBuilder s = new StringBuilder("");
            if(item.getRecordtype().equals("入库") && item.getStoragetype().equals("转移")){
                s.append("从"+item.getOldstockname()+"(库房)转移到了"+item.getStockname()+"(库房)");
            }else if(item.getRecordtype().equals("入库")){
                s.append("进入了"+item.getStockname()+"(库房)");
            }else if(item.getRecordtype().equals("出库")){
                s.append("从"+item.getOldstockname()+"(库房)移出");
            }else if(item.getRecordtype().equals("调拨")){
                s.append("调拨至"+item.getCompanyname()+"公司");
            }else if(item.getRecordtype().equals("盘点")){
                s.append("位于"+item.getStockname()+"(库房)中被盘点");
            }else if(item.getRecordtype().equals("报废")){
                s.append("被报废");
            }
            temp.setDescr(s.toString());
            result.add(temp);
        }
        System.out.println("lifelog "+result);
        return result;
    }

    @Override
    public List<EffectiveProtocolEntity> queryEffectiveProtocol(int deviceId) {
        return null;
    }

    @Override
    public List<MaintainLogEntity> queryMaintainLog(Integer deviceid) {
        List<MaintainEntity> maintainEntities = baseMapper.queryMaintainLog(deviceid);
        List<MaintainLogEntity> result = new LinkedList<>();
        for(MaintainEntity item : maintainEntities){
            MaintainLogEntity temp = new MaintainLogEntity();
            temp.setProName(item.getTheme());
            temp.setProType(item.getOrdertype());
            temp.setProId(item.getWorkorderid());
            temp.setReportDate(item.getReporthappentime());
            temp.setExecutor(sysUserService.queryByUserId(item.getReporterid()));
            temp.setState(item.getState());
            DeviceEntity deviceEntity = deviceService.queryById(item.getDeviceid());
//            List<StockEntity> stockEntities = stockService.queryByName(deviceEntity.getStockname());
            temp.setAddr(deviceEntity.getStockname());
            result.add(temp);
        }
        return result;
    }

    @Override
    public List<MaintainLogEntity> queryRepairLog(Integer deviceid) {
        List<MaintainEntity> maintainEntities = baseMapper.queryRepairLog(deviceid);
        List<MaintainLogEntity> result = new LinkedList<>();
        for(MaintainEntity item : maintainEntities){
            MaintainLogEntity temp = new MaintainLogEntity();
            temp.setProName(item.getTheme());
            temp.setProType(item.getOrdertype());
            temp.setProId(item.getWorkorderid());
            temp.setReportDate(item.getReporthappentime());
            temp.setExecutor(sysUserService.queryByUserId(item.getReporterid()));
            temp.setState(item.getState());
            DeviceEntity deviceEntity = deviceService.queryById(item.getDeviceid());
//            List<StockEntity> stockEntities = stockService.queryByName(deviceEntity.getStockname());
            temp.setAddr(deviceEntity.getStockname());
            result.add(temp);
        }
        return result;
    }
}
