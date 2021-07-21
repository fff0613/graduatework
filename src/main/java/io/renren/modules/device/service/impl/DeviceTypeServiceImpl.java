package io.renren.modules.device.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.device.dao.DeviceTypeDao;
import io.renren.modules.device.entity.DeviceTypeEntity;
import io.renren.modules.device.service.DeviceTypeService;


@Service("deviceTypeService")
public class DeviceTypeServiceImpl extends ServiceImpl<DeviceTypeDao, DeviceTypeEntity> implements DeviceTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DeviceTypeEntity> page = this.page(
                new Query<DeviceTypeEntity>().getPage(params),
                new QueryWrapper<DeviceTypeEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<DeviceTypeEntity> queryAll() {
        return baseMapper.queryAll();
    }

    @Override
    public String insertType(DeviceTypeEntity item) {
        try {
            baseMapper.insertType(item);
            return "insert success";
        }catch(Exception e) {
            return "insert fail";
        }
    }

    @Override
    public String updateState(DeviceTypeEntity item) {
        try {
            baseMapper.updateState(item);
            return "update success";
        }catch(Exception e) {
            return "update fail";
        }
    }

    @Override
    public List<DeviceTypeEntity> queryByType(String s) {
        try {
            List<DeviceTypeEntity> deviceTypeEntities = baseMapper.queryByName(s);
            return deviceTypeEntities;
        }catch(Exception e) {
            System.out.println("error");
            return null;
        }
    }

    @Override
    public List<String> queryTypeList() {
        return baseMapper.queryAllType();
    }

    @Override
    public void updateType(DeviceTypeEntity item) {
        baseMapper.updateType(item);
    }

}