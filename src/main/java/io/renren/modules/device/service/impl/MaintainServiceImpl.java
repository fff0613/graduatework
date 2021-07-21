package io.renren.modules.device.service.impl;

import io.renren.modules.device.entity.MaintainconEntity;
import io.renren.modules.device.entity.ReportMaintainEntity;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.device.dao.MaintainDao;
import io.renren.modules.device.entity.MaintainEntity;
import io.renren.modules.device.service.MaintainService;


@Service("maintainService")
public class MaintainServiceImpl extends ServiceImpl<MaintainDao, MaintainEntity> implements MaintainService {
    @Autowired
    SysUserService sysUserService;

    @Override
    public String insertRepair(ReportMaintainEntity item) {
//        if(item.getOrdertype().equals("保养"))
//            return insertMaintain(item);
//        else{
            MaintainEntity repair = new MaintainEntity();
            repair.setDeviceid(item.getDeviceid());
            repair.setReporthappentime(item.getReporthappentime());
            repair.setRuntimestate(item.getRuntimestate());
            repair.setDesrc(item.getDesrc());
            repair.setUrgency(item.getUrgency());
            repair.setMaintaintype(item.getMaintaintype());
            repair.setLimittime(item.getLimittime());
//            getUser();
            repair.setReporterid(item.getReporterid());
            repair.setExecutorid(item.getExecutorid());
            if(item.getExecutorid() != null && item.getExecutorid() != 0){
                repair.setState("待执行");
                repair.setDistributiontime(item.getReporthappentime());
                repair.setDistributeid(item.getReporterid());
            }else{
                repair.setState("待处理");
            }
            repair.setOrdertype(item.getOrdertype());

            repair.setTheme(item.getTheme());
            try{
                baseMapper.insertRepair(repair);
                return "insert success";
            }catch (Exception e){
                System.out.println(e);
                return "insert fail";
            }
//        }


    }

    @Override
    public List<MaintainEntity> queryByContent(Long id, String content) {
        return baseMapper.queryByContent(id,content);
    }

    @Override
    public List<MaintainEntity> queryByExeId(Long id) {
        return baseMapper.queryByExeId(id);
    }

    @Override
    public void updateExecute(MaintainEntity item) {
        baseMapper.updateExecute(item);
    }

    @Override
    public void updateConfirm(MaintainEntity item) {
        baseMapper.updateConfirm(item);
    }

    @Override
    public void updateDelivery(MaintainEntity item) {
        baseMapper.updateDelivery(item);
    }

    @Override
    public List<SysUserEntity> queryFellowList() {
        return sysUserService.queryList();
    }

    public String insertMaintain(ReportMaintainEntity item) {
        MaintainEntity maintain = new MaintainEntity();
        maintain.setDeviceid(item.getDeviceid());
        maintain.setReporthappentime(item.getReporthappentime());
        maintain.setRuntimestate(item.getRuntimestate());
        maintain.setDesrc(item.getDesrc());
        maintain.setUrgency(item.getUrgency());
        maintain.setMaintaintype(item.getMaintaintype());
        maintain.setLimittime(item.getLimittime());
        maintain.setReporterid(item.getReporterid());
        maintain.setExecutorid(item.getExecutorid());
        maintain.setState("待处理");
        maintain.setOrdertype("保养");

        maintain.setTheme(item.getTheme());
        try{
            baseMapper.insertRepair(maintain);
            return "insert success";
        }catch (Exception e){
            System.out.println(e);
            return "insert fail";
        }

    }
    @Override
    public List<MaintainEntity> queryall() {
        return baseMapper.querylist();
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MaintainEntity> page = this.page(
                new Query<MaintainEntity>().getPage(params),
                new QueryWrapper<MaintainEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<MaintainEntity> queryByCon(MaintainconEntity item) {
//        if(item.getDevice())
        String type = item.getType();
        String state = item.getState();
        String theme = item.getTheme();
        Integer device = item.getDevice();
        if(type != null && state != null && theme != null && device != null){
            return baseMapper.queryByTypeAndStateAndDeviceAndTheme(item);
        }else if(type != null && state != null && device != null){
            return baseMapper.queryByTypeAndStateAndDevice(item);
        }else if(type != null && state != null && theme != null){
            return baseMapper.queryByTypeAndStateAndTheme(item);
        }else if(type != null && theme != null && device != null)
            return baseMapper.queryByTypeAndDeviceAndTheme(item);
        else if(state != null && theme != null && device != null)
            return baseMapper.queryByStateAndDeviceAndTheme(item);
        else if(type != null && state != null)
            return baseMapper.queryByTypeAndState(item);
        else if(state != null && theme != null)
            return baseMapper.queryByStateAndTheme(item);
        else if(state != null && device != null)
            return baseMapper.queryByStateAndDevice(item);
        else if(type != null && device != null)
            return baseMapper.queryByTypeAndDevice(item);
        else if(type != null && theme != null)
            return baseMapper.queryByTypeAndTheme(item);
        else if(theme != null && device != null)
            return baseMapper.queryByDeviceAndTheme(item);
        else if(type != null)
            return baseMapper.queryByType(item);
        else if(theme != null )
            return baseMapper.queryByTheme(item);
        else if(state != null)
            return baseMapper.queryByState(item);
        else if(device != null)
            return baseMapper.queryByDevice(item);
        else
            return baseMapper.querylist();
    }

}