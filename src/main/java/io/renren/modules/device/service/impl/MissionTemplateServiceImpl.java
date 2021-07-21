package io.renren.modules.device.service.impl;

import io.renren.modules.device.entity.MaintainTempEntity;
import io.renren.modules.device.entity.MissionitemEntity;
import io.renren.modules.device.service.MissionitemService;
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

import io.renren.modules.device.dao.MissionTemplateDao;
import io.renren.modules.device.entity.MissionTemplateEntity;
import io.renren.modules.device.service.MissionTemplateService;


@Service("missionTemplateService")
public class MissionTemplateServiceImpl extends ServiceImpl<MissionTemplateDao, MissionTemplateEntity> implements MissionTemplateService {
    @Autowired
    MissionitemService missionitemService;

    @Override
    public void insertMT(MissionTemplateEntity item) {
        baseMapper.insertMT(item);
    }
    @Override
    public List<MissionitemEntity> queryTempByIdTwo(Integer tempid) {
        List<MissionTemplateEntity> missionTemplateEntities = baseMapper.queryTempById(tempid);
        List<MissionitemEntity> list = new ArrayList<>(missionTemplateEntities.size());
        System.out.println("missiontemp mtentities"+missionTemplateEntities);
        for(MissionTemplateEntity missionTemplateEntity:missionTemplateEntities){
            MissionitemEntity missionitemEntity = missionitemService.queryById(missionTemplateEntity.getItemid());

            list.add(missionitemEntity);

        }
        return list;
    }
    @Override
    public List<MaintainTempEntity> queryTempById(Integer tempid) {
        List<MissionTemplateEntity> missionTemplateEntities = baseMapper.queryTempById(tempid);
        List<MaintainTempEntity> list = new ArrayList<>(missionTemplateEntities.size());
        System.out.println("missiontemp mtentities"+missionTemplateEntities);
        for(MissionTemplateEntity missionTemplateEntity:missionTemplateEntities){
            MissionitemEntity missionitemEntity = missionitemService.queryById(missionTemplateEntity.getItemid());
            System.out.println("missionitementity "+missionitemEntity);
            if(missionitemEntity != null){
                MaintainTempEntity maintainTempEntity = new MaintainTempEntity();
                maintainTempEntity.setId(missionTemplateEntity.getId());
                maintainTempEntity.setTempid(missionTemplateEntity.getTempid());
                maintainTempEntity.setIscomplete(missionTemplateEntity.getIscomplete());
                maintainTempEntity.setName(missionitemEntity.getItemname());
                maintainTempEntity.setItemid(missionitemEntity.getItemid());
                maintainTempEntity.setItemdescr(missionitemEntity.getItemdescr());
                maintainTempEntity.setState(missionitemEntity.getState());
                maintainTempEntity.setMethod(missionitemEntity.getMethod());
                maintainTempEntity.setResult(missionitemEntity.getResult());
                maintainTempEntity.setHours(missionitemEntity.getHours());
                maintainTempEntity.setNumber(missionTemplateEntity.getNumber());
                list.add(maintainTempEntity);
            }

        }
        return list;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MissionTemplateEntity> page = this.page(
                new Query<MissionTemplateEntity>().getPage(params),
                new QueryWrapper<MissionTemplateEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void updateMt(MissionTemplateEntity item) {
        baseMapper.updateMt(item);
    }

}