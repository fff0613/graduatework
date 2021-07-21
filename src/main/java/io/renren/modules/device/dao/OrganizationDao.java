package io.renren.modules.device.dao;

import io.renren.modules.device.entity.DeviceModelEntity;
import io.renren.modules.device.entity.OrganizationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-08 13:57:16
 */
@Mapper
public interface OrganizationDao extends BaseMapper<OrganizationEntity> {
    List<OrganizationEntity>  queryAllBystate();
    List<OrganizationEntity> queryAll();
    String insertOrg(OrganizationEntity item);
    List<OrganizationEntity> queryByName(String s);
    List<String> queryOrgList();
    void updateOrg(OrganizationEntity org);
    void deleteOrg(String orgName);
    String queryOrgName(String orgName);
}
