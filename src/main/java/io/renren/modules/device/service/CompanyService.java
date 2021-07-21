package io.renren.modules.device.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.device.entity.CompanyEntity;
import io.renren.modules.device.entity.OptionEntity;
import io.renren.modules.device.entity.OrganizationEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-08 13:57:16
 */
public interface CompanyService extends IService<CompanyEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<CompanyEntity> queryAll();
    String insertCpy(CompanyEntity item);
    List<CompanyEntity> queryByName(String s);
    List<OptionEntity> queryList();
    List<OptionEntity> querySupList();
    List<OptionEntity> queryManList();
    void updateCpy(CompanyEntity item);
    void deleteCpy(String[] cpyNames);
    boolean isExisted(String cpyNames);
}

