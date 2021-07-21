package io.renren.modules.device.service.impl;

import io.renren.modules.device.entity.MaintainCompleteEntity;
import io.renren.modules.device.entity.MaintainTempEntity;
import io.renren.modules.device.entity.MissionTemplateEntity;
import io.renren.modules.device.service.MaintainCompleteService;
import io.renren.modules.device.service.MissionTemplateService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.device.dao.MissionitemDao;
import io.renren.modules.device.entity.MissionitemEntity;
import io.renren.modules.device.service.MissionitemService;


@Service("missionitemService")
public class MissionitemServiceImpl extends ServiceImpl<MissionitemDao, MissionitemEntity> implements MissionitemService {
    @Autowired
    MissionTemplateService missionTemplateService;
    @Autowired
    MaintainCompleteService maintainCompleteService;
    @Override
    public List<MissionitemEntity> queryAll() {
        return baseMapper.queryAll();
    }

    @Override
    public void insertItem(MissionitemEntity item) {
        baseMapper.insertItem(item);
    }

    @Override
    public void updateItem(MissionitemEntity item) {
        baseMapper.updateItem(item);
    }

    @Override
    public void deleteItem(Integer[] itemid) {
        for(Integer item :itemid)
            baseMapper.deleteItem(item);
    }

    @Override
    public List<MissionitemEntity> queryByName(String name) {
        return baseMapper.queryByName(name);
    }

    @Override
    public MissionitemEntity queryById(Integer itemid) {
        return baseMapper.queryById(itemid);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String itemname = (String)params.get("itemname");
        IPage<MissionitemEntity> page = this.page(
                new Query<MissionitemEntity>().getPage(params),
                new QueryWrapper<MissionitemEntity>()
                        .like(StringUtils.isNotBlank(itemname),"itemname", itemname)
        );

        return new PageUtils(page);
    }

    @Override
    public void updateList(MaintainTempEntity[] list) {
        if(list != null){
            for(MaintainTempEntity item:list){
//                MissionTemplateEntity temp = new MissionTemplateEntity();
//                temp.setId(item.getId());
//                temp.setIscomplete(item.isIscomplete());
//                temp.setNumber(item.getNumber());
//                missionTemplateService.updateMt(temp);
                MaintainCompleteEntity maintainCompleteEntity = new MaintainCompleteEntity();
                maintainCompleteEntity.setNumber(item.getNumber());
                maintainCompleteEntity.setIscomplete(item.isIscomplete());
                maintainCompleteEntity.setItemid(item.getItemid());
                maintainCompleteEntity.setTempid(item.getTempid());
                maintainCompleteEntity.setExecutetime(item.getExetime());
                maintainCompleteService.insert(maintainCompleteEntity);
            }
        }
    }

    @Override
    public List<MaintainTempEntity> queryByDevice(Integer deviceid,Integer orderid) {
        List<MaintainTempEntity> result = new ArrayList<>();
        List<Integer> proList = baseMapper.getProList(deviceid);
        Map<Integer,Integer> map = new HashMap<>();
        if(proList.size() != 0){
            for(Integer proid:proList){
                List<MaintainTempEntity> maintainTempEntities = missionTemplateService.queryTempById(proid);
                for(int i = 0;i < maintainTempEntities.size();i++){
                    if(!map.containsKey(maintainTempEntities.get(i).getItemid())){
                        result.add(maintainTempEntities.get(i));
                        map.put(maintainTempEntities.get(i).getItemid(),0);
                    }
                }
            }
        }else{
            List<MissionitemEntity> missionitemEntities = baseMapper.queryAll();
            for(MissionitemEntity missionitemEntity:missionitemEntities){
                MaintainTempEntity maintainTempEntity = new MaintainTempEntity();
//                maintainTempEntity.setId(missionitemEntity.getId());
                maintainTempEntity.setTempid(orderid);
                maintainTempEntity.setIscomplete(false);
                maintainTempEntity.setName(missionitemEntity.getItemname());
                maintainTempEntity.setItemid(missionitemEntity.getItemid());
                maintainTempEntity.setItemdescr(missionitemEntity.getItemdescr());
                maintainTempEntity.setState(missionitemEntity.getState());
                maintainTempEntity.setMethod(missionitemEntity.getMethod());
                maintainTempEntity.setResult(missionitemEntity.getResult());
                maintainTempEntity.setHours(missionitemEntity.getHours());
                maintainTempEntity.setNumber(0.0f);
                result.add(maintainTempEntity);
            }
        }
        return result;
    }

}