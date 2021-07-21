package io.renren.modules.device.service.impl;

import io.renren.modules.device.entity.OptionEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.device.dao.OrganizationDao;
import io.renren.modules.device.entity.OrganizationEntity;
import io.renren.modules.device.service.OrganizationService;


@Service("organizationService")
public class OrganizationServiceImpl extends ServiceImpl<OrganizationDao, OrganizationEntity> implements OrganizationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrganizationEntity> page = this.page(
                new Query<OrganizationEntity>().getPage(params),
                new QueryWrapper<OrganizationEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<OrganizationEntity> queryActOrg() {
        return baseMapper.queryAllBystate();
    }

    @Override
    public List<OrganizationEntity> queryAll() {
        return baseMapper.queryAll();
    }

    @Override
    public String insertOrg(OrganizationEntity item) {
        if(isExisted(item.getOrgname()))
            return "orgname exist";
        try {
            baseMapper.insertOrg(item);
            return "insert success";
        }catch(Exception e) {
            return "insert fail";
        }
    }

    @Override
    public List<OrganizationEntity> queryByOrgName(String s) {
        return baseMapper.queryByName(s);
    }

    @Override
    public List<OptionEntity> queryOrgList() {
        List<String> strings = baseMapper.queryOrgList();
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
    public void updateOrg(OrganizationEntity item) {
        baseMapper.updateOrg(item);
    }

    @Override
    public void deleteOrg(String[] orgNames) {
        for(String orgName:orgNames)
            baseMapper.deleteOrg(orgName);
    }

    @Override
    public boolean isExisted(String orgNames) {
        List<OrganizationEntity> organizationEntities = baseMapper.queryByName(orgNames);
        if(organizationEntities.size() == 0)
            return false;
        else{
//            organizationEntities.toString();
            return true;
        }

    }

}