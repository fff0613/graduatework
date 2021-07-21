package io.renren.modules.device.dao;

import io.renren.modules.device.entity.CompanyEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.device.entity.OrganizationEntity;
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
public interface CompanyDao extends BaseMapper<CompanyEntity> {
	List<String> queryList();
    List<String> querySupList();
    List<String> queryManList();
    List<CompanyEntity> queryAll();
    void insertCpy(CompanyEntity item);
    List<CompanyEntity> queryByName(String s);
    void updateCpy(CompanyEntity org);
    void deleteCpy(String cpyName);
    String queryCpyName(String cpyName);
}
