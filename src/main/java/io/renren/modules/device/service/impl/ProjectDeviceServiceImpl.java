package io.renren.modules.device.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.device.dao.ProjectDeviceDao;
import io.renren.modules.device.entity.ProjectDeviceEntity;
import io.renren.modules.device.service.ProjectDeviceService;


@Service("projectDeviceService")
public class ProjectDeviceServiceImpl extends ServiceImpl<ProjectDeviceDao, ProjectDeviceEntity> implements ProjectDeviceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProjectDeviceEntity> page = this.page(
                new Query<ProjectDeviceEntity>().getPage(params),
                new QueryWrapper<ProjectDeviceEntity>()
        );

        return new PageUtils(page);
    }

}