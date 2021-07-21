package io.renren.modules.device.service.impl;

import io.renren.modules.device.entity.*;
import io.renren.modules.device.service.DeviceService;
import io.renren.modules.device.service.MissionTemplateService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.device.dao.MaintainprojectDao;
import io.renren.modules.device.service.MaintainprojectService;


@Service("maintainprojectService")
public class MaintainprojectServiceImpl extends ServiceImpl<MaintainprojectDao, MaintainprojectEntity> implements MaintainprojectService {
    @Autowired
    DeviceService deviceService;
    @Autowired
    MissionTemplateService missionTemplateService;

    @Override
    public List<MaintainprojectEntity> getProList(Integer deviceid) {
        List<Integer> proList = baseMapper.getProList(deviceid);
        List<MaintainprojectEntity> result = new ArrayList<>();
        System.out.println(proList);
        if(proList.size() != 0){
            for(Integer id : proList){
//                MaintainprojectEntity mtpro = new MaintainprojectEntity();
//                MaintainprojectEntity byId = ;
                if(getById(id) == null)
                    continue;
                result.add(getById(id));
            }
        }
        return result;
    }

    @Override
    public List<DeviceEntity> getDeviceList(Integer proid) {
        List<Integer> deviceList = baseMapper.getDeviceList(proid);
        List<DeviceEntity> deviceEntities = new ArrayList<>();
        if(deviceList.size() != 0){
            for(Integer id:deviceList){
                DeviceEntity deviceEntity = deviceService.queryById(id);
                deviceEntities.add(deviceEntity);
            }
        }
        return deviceEntities;
    }

    @Override
    public List<DeviceEntity> queryByCon(Map<String, Object> params) {
        String stock = (String)params.get("stock");
        String name = (String)params.get("device");
        System.out.println(stock+" stock");
        System.out.println(name+" name");
        if(stock != null && name != null)
            return deviceService.queryByStockAndName(stock,name);
        else if(stock != null){
            return deviceService.queryByStock(stock);
        }else if(name != null)
            return deviceService.queryByName(name);
        else
            return deviceService.queryAll();
    }

    @Override
    public void insertPro(MaintainPro item) {
        MaintainprojectEntity me = new MaintainprojectEntity();
        me.setProjectname(item.getProjectname());
        me.setProjecttype(item.getProjecttype());
        me.setCycle(item.getCycle());
        me.setUnit(item.getUnit());
        me.setEndtime(item.getEndtime());
        me.setStarttime(item.getStarttime());
        me.setEstimate(item.getEstimate());
        if(item.getIsdelivery().equals("true"))
            me.setIsdelivery(1);
        else
            me.setIsdelivery(0);
        if(item.getState().equals("true"))
            me.setState("启用");
        else
            me.setState("禁用");
        baseMapper.insertPro(me);
        String projectname = me.getProjectname();
        Integer[] deviceid = item.getDeviceid();
        Integer[] missionid = item.getTemplate();
        for(Integer id:deviceid){
            baseMapper.insertMD(me.getProjectid(),id);
        }
        for(Integer id:missionid){
            MissionTemplateEntity missione = new MissionTemplateEntity();
            missione.setTempid(me.getProjectid());
            missione.setItemid(id);
            missione.setIscomplete(false);
            missione.setName(projectname);
            missionTemplateService.insertMT(missione);
        }
        me.setTemplate(me.getProjectid());
        baseMapper.updatePro(me);
    }

    @Override
    public void updatePro(MaintainPro item) {

    }

    @Override
    public void deletePro(Integer id) {
        baseMapper.deletePro(id);
    }

    @Override
    public List<MaintainprojectEntity> queryAll() {
        return baseMapper.queryAll();
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MaintainprojectEntity> page = this.page(
                new Query<MaintainprojectEntity>().getPage(params),
                new QueryWrapper<MaintainprojectEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<MaintainprojectEntity> queryMPByCon(MaintainProjectCon item) {
        String type = item.getType();
        String state = item.getState();
        String theme = item.getTheme();
        if(type != null && state != null && theme != null){
            return baseMapper.queryByTypeAndStateAndTheme(item);
        }
        else if(type != null && state != null)
            return baseMapper.queryByTypeAndState(item);
        else if(state != null && theme != null)
            return baseMapper.queryByStateAndTheme(item);
        else if(type != null && theme != null)
            return baseMapper.queryByTypeAndTheme(item);
        else if(type != null)
            return baseMapper.queryByType(item);
        else if(theme != null )
            return baseMapper.queryByTheme(item);
        else if(state != null)
            return baseMapper.queryByState(item);
        else
            return baseMapper.queryAll();
    }

}