package io.renren.modules.device.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.device.dao.DeviceOrgDao;
import io.renren.modules.device.entity.DeviceOrgEntity;
import io.renren.modules.device.service.DeviceOrgService;


@Service("deviceOrgService")
public class DeviceOrgServiceImpl extends ServiceImpl<DeviceOrgDao, DeviceOrgEntity> implements DeviceOrgService {

    @Override
    public void insertOrg(DeviceOrgEntity item) {
        baseMapper.insertOrg(item);
    }

    @Override
    public void deleteOrg(DeviceOrgEntity item) {
        baseMapper.deleteOrg(item);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DeviceOrgEntity> page = this.page(
                new Query<DeviceOrgEntity>().getPage(params),
                new QueryWrapper<DeviceOrgEntity>()
        );

        return new PageUtils(page);
    }

}