package io.renren.modules.device.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.device.dao.MaintainCompleteDao;
import io.renren.modules.device.entity.MaintainCompleteEntity;
import io.renren.modules.device.service.MaintainCompleteService;


@Service("maintainCompleteService")
public class MaintainCompleteServiceImpl extends ServiceImpl<MaintainCompleteDao, MaintainCompleteEntity> implements MaintainCompleteService {

    @Override
    public int insert(MaintainCompleteEntity item) {
        return baseMapper.insert(item);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MaintainCompleteEntity> page = this.page(
                new Query<MaintainCompleteEntity>().getPage(params),
                new QueryWrapper<MaintainCompleteEntity>()
        );

        return new PageUtils(page);
    }

}