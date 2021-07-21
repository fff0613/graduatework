package io.renren.modules.device.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.device.dao.EffectiveProtocolDao;
import io.renren.modules.device.entity.EffectiveProtocolEntity;
import io.renren.modules.device.service.EffectiveProtocolService;


@Service("effectiveProtocolService")
public class EffectiveProtocolServiceImpl extends ServiceImpl<EffectiveProtocolDao, EffectiveProtocolEntity> implements EffectiveProtocolService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EffectiveProtocolEntity> page = this.page(
                new Query<EffectiveProtocolEntity>().getPage(params),
                new QueryWrapper<EffectiveProtocolEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<EffectiveProtocolEntity> queryProList(Integer deviceid) {
        return baseMapper.queryProList(deviceid);
    }

    @Override
    public void insertPro(EffectiveProtocolEntity item) {
        baseMapper.insertPro(item);
    }

    @Override
    public void updatePro(EffectiveProtocolEntity item) {
        baseMapper.updatePro(item);
    }

    @Override
    public void deletePro(EffectiveProtocolEntity item) {
//        for(EffectiveProtocolEntity item:items)
            baseMapper.deletePro(item.getProid(),item.getDeviceid());
    }

}