package io.renren.modules.device.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.device.dao.ProMissionDao;
import io.renren.modules.device.entity.ProMissionEntity;
import io.renren.modules.device.service.ProMissionService;


@Service("proMissionService")
public class ProMissionServiceImpl extends ServiceImpl<ProMissionDao, ProMissionEntity> implements ProMissionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProMissionEntity> page = this.page(
                new Query<ProMissionEntity>().getPage(params),
                new QueryWrapper<ProMissionEntity>()
        );

        return new PageUtils(page);
    }

}