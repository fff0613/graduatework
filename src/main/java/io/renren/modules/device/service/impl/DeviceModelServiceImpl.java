package io.renren.modules.device.service.impl;

import io.renren.modules.device.entity.DeviceTypeEntity;
import io.renren.modules.device.entity.OptionEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.device.dao.DeviceModelDao;
import io.renren.modules.device.entity.DeviceModelEntity;
import io.renren.modules.device.service.DeviceModelService;


@Service("deviceModelService")
public class DeviceModelServiceImpl extends ServiceImpl<DeviceModelDao, DeviceModelEntity> implements DeviceModelService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DeviceModelEntity> page = this.page(
                new Query<DeviceModelEntity>().getPage(params),
                new QueryWrapper<DeviceModelEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<DeviceModelEntity> queryAll() {
        return baseMapper.queryAll();
    }

    @Override
    public String insertModel(DeviceModelEntity item) {
        try {
            baseMapper.insertModel(item);

            return "insert success";
        }catch(Exception e) {
            return "insert fail";
        }
    }

    @Override
    public List<DeviceModelEntity> queryByModel(String s) {
        try {
            List<DeviceModelEntity> deviceTypeEntities = baseMapper.queryByName(s);
            return deviceTypeEntities;
        }catch(Exception e) {
            System.out.println("error");
            return null;
        }
    }

    @Override
    public List<OptionEntity> queryModelList() {
        List<String> strings = baseMapper.queryModelList();
        List<OptionEntity> list = new LinkedList<>();
        for(String s:strings){
            OptionEntity optionEntity = new OptionEntity();
            optionEntity.setLabel(s);
            optionEntity.setValue(s);
            list.add(optionEntity);
        }
        return list;
    }

    @Override
    public void updateModel(DeviceModelEntity item) {
        baseMapper.updateModel(item);
    }

    @Override
    public void deleteModel(String[] models) {
        for(String model:models)
            baseMapper.deleteModel(model);
    }

    @Override
    public List<OptionEntity> queryByType(String type) {
        List<String> strings = baseMapper.queryByType(type);
        List<OptionEntity> list = new LinkedList<>();
        for(String s:strings){
            OptionEntity optionEntity = new OptionEntity();
            optionEntity.setLabel(s);
            optionEntity.setValue(s);
            list.add(optionEntity);
        }
        return list;
    }

}