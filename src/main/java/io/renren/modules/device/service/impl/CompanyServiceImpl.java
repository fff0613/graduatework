package io.renren.modules.device.service.impl;

import io.renren.modules.device.entity.OptionEntity;
import io.renren.modules.device.entity.OrganizationEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.device.dao.CompanyDao;
import io.renren.modules.device.entity.CompanyEntity;
import io.renren.modules.device.service.CompanyService;


@Service("companyService")
public class CompanyServiceImpl extends ServiceImpl<CompanyDao, CompanyEntity> implements CompanyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CompanyEntity> page = this.page(
                new Query<CompanyEntity>().getPage(params),
                new QueryWrapper<CompanyEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CompanyEntity> queryAll() {
        return baseMapper.queryAll();
    }

    @Override
    public String insertCpy(CompanyEntity item) {
        if(isExisted(item.getCompanyname()))
            return item.getCompanyname()+" exist";
        try {
            baseMapper.insertCpy(item);
            return "insert success";
        }catch(Exception e) {
            e.printStackTrace();
            return "insert fail";
        }
    }

    @Override
    public List<CompanyEntity> queryByName(String s) {

        List<CompanyEntity> companyEntities = baseMapper.queryByName(s);
        System.out.println(companyEntities);
        return companyEntities;
    }

    @Override
    public List<OptionEntity> queryList() {
        List<String> strings = baseMapper.queryList();
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
    public List<OptionEntity> querySupList() {
        List<String> strings = baseMapper.querySupList();
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
    public List<OptionEntity> queryManList() {
        List<String> strings = baseMapper.queryManList();
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
    public void updateCpy(CompanyEntity item) {
        baseMapper.updateCpy(item);
    }

    @Override
    public void deleteCpy(String[] cpyNames) {
        for(String cpyName:cpyNames)
            baseMapper.deleteCpy(cpyName);
    }

    public boolean isExisted(String cpyNames) {
        List<CompanyEntity> companyEntities = baseMapper.queryByName(cpyNames);
        if(companyEntities.size() == 0)
            return false;
        else{
//            organizationEntities.toString();
            return true;
        }
    }

}