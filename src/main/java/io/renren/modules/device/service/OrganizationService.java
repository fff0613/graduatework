package io.renren.modules.device.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.device.entity.DeviceModelEntity;
import io.renren.modules.device.entity.OptionEntity;
import io.renren.modules.device.entity.OrganizationEntity;
import org.aspectj.weaver.ast.Or;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-08 13:57:16
 */
public interface OrganizationService extends IService<OrganizationEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<OrganizationEntity> queryActOrg();
    List<OrganizationEntity> queryAll();
    String insertOrg(OrganizationEntity item);
    List<OrganizationEntity> queryByOrgName(String s);
    List<OptionEntity> queryOrgList();
    void updateOrg(OrganizationEntity item);
    void deleteOrg(String[] orgNames);
    boolean isExisted(String orgNames);
}

