package io.renren.modules.device.service.impl;

import io.renren.modules.device.entity.CompanyEntity;
import io.renren.modules.device.entity.OptionEntity;
import io.renren.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.device.dao.StockDao;
import io.renren.modules.device.entity.StockEntity;
import io.renren.modules.device.service.StockService;


@Service("stockService")
public class StockServiceImpl extends ServiceImpl<StockDao, StockEntity> implements StockService {
    @Autowired
    SysUserService sysUserService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StockEntity> page = this.page(
                new Query<StockEntity>().getPage(params),
                new QueryWrapper<StockEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<StockEntity> queryAll() {
        return baseMapper.queryAll();
    }

    @Override
    public String insertStock(StockEntity item) {
        if(isExisted(item.getStockname()))
            return item.getStockname()+" exist";
        try {
            String s = sysUserService.queryByUserId(item.getExecutorid());
            item.setExecutor(s);
            baseMapper.insertStock(item);
            return "insert success";
        }catch(Exception e) {
            return "insert fail";
        }
    }

    @Override
    public List<StockEntity> queryByName(String s) {
        return baseMapper.queryByName(s);
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
    public void updateStock(StockEntity item) {
        String s = sysUserService.queryByUserId(item.getExecutorid());
        item.setExecutor(s);
        baseMapper.updateStock(item);
    }

    @Override
    public void deleteStock(String[] stockNames) {
        for(String name:stockNames)
            baseMapper.deleteStock(name);
    }

    @Override
    public String getOrgName(String stockname) {
        return baseMapper.getOrgName(stockname);
    }

    public boolean isExisted(String stockNames) {
        List<StockEntity> stockEntities = baseMapper.queryByName(stockNames);
        if(stockEntities.size() == 0)
            return false;
        else{
//            organizationEntities.toString();
            return true;
        }
    }
}