package io.renren.modules.device.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.device.dao.FellowarrivalDao;
import io.renren.modules.device.entity.FellowarrivalEntity;
import io.renren.modules.device.service.FellowarrivalService;


@Service("fellowarrivalService")
public class FellowarrivalServiceImpl extends ServiceImpl<FellowarrivalDao, FellowarrivalEntity> implements FellowarrivalService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FellowarrivalEntity> page = this.page(
                new Query<FellowarrivalEntity>().getPage(params),
                new QueryWrapper<FellowarrivalEntity>()
        );

        return new PageUtils(page);
    }

}