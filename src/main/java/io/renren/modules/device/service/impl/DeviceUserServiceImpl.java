package io.renren.modules.device.service.impl;

import io.renren.modules.device.entity.FellowEntity;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
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

import io.renren.modules.device.dao.DeviceUserDao;
import io.renren.modules.device.entity.DeviceUserEntity;
import io.renren.modules.device.service.DeviceUserService;


@Service("deviceUserService")
public class DeviceUserServiceImpl extends ServiceImpl<DeviceUserDao, DeviceUserEntity> implements DeviceUserService {
    @Autowired
    SysUserService sysUserService;
    @Override
    public List<SysUserEntity> getUserByDeviceId(Integer deviceid, String role) {
        List<DeviceUserEntity> list = baseMapper.getUserByDeviceId(deviceid,role);
        List<SysUserEntity> result = new ArrayList<>();
        for(int i = 0;i < list.size();i++){
            if(list.get(i) == null)
                continue;
            else{
                SysUserEntity userById = sysUserService.getUserById(list.get(i).getUserid());
                if(userById != null)
                    result.add(userById);
            }
        }
        return result;
    }

    @Override
    public List<FellowEntity> queryFellow(int deviceId) {
        List<DeviceUserEntity> list = baseMapper.getUserIdByDeviceId(deviceId);
        List<FellowEntity> result = new ArrayList<>();
        for(int i = 0;i < list.size();i++){
            if(list.get(i) == null)
               continue;
            else{
                SysUserEntity userById = sysUserService.getUserById(list.get(i).getUserid());
                if(userById == null)
                    continue;
                else{
                    FellowEntity fellowEntity = new FellowEntity();
                    fellowEntity.setUserid(userById.getUserId());
                    fellowEntity.setDeviceid(list.get(i).getDeviceid());
                    fellowEntity.setDescr(list.get(i).getDescr());
                    fellowEntity.setEmail(userById.getEmail());
                    fellowEntity.setMobile(userById.getMobile());
                    fellowEntity.setRole(list.get(i).getRole());
                    fellowEntity.setUsername(userById.getUsername());
                    result.add(fellowEntity);
                }

            }
        }
        return result;
    }

    @Override
    public String insertFellow(FellowEntity item) {
        try{
//            int id = baseMapper.insertUser(item);
            item.setUserid(Long.parseLong(item.getUsername()));
//            System.out.println();
            baseMapper.insertFellow(item);
            return "insert success";
        }catch (Exception e){
            System.out.println(e);
            return "inset fail";
        }
    }

    @Override
    public void deleteFellow(FellowEntity item) {
        baseMapper.deleteFellow(item);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DeviceUserEntity> page = this.page(
                new Query<DeviceUserEntity>().getPage(params),
                new QueryWrapper<DeviceUserEntity>()
        );

        return new PageUtils(page);
    }

}