package io.renren.modules.device.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.device.entity.CompanyEntity;
import io.renren.modules.device.entity.OptionEntity;
import io.renren.modules.device.entity.StockEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-08 13:57:16
 */
public interface StockService extends IService<StockEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<StockEntity> queryAll();
    String insertStock(StockEntity item);
    List<StockEntity> queryByName(String s);
    List<OptionEntity> queryList();
    void updateStock(StockEntity item);
    void deleteStock(String[] stockNames);
    String getOrgName(String stockname);
}

