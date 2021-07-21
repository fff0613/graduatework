package io.renren.modules.device.dao;

import io.renren.modules.device.entity.EffectiveProtocolEntity;
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
public interface EffectiveProtocolDao extends BaseMapper<EffectiveProtocolEntity> {
	List<EffectiveProtocolEntity> queryProList(Integer deviceid);
	void insertPro(EffectiveProtocolEntity item);
	void updatePro(EffectiveProtocolEntity item);
	void deletePro(Integer proid,Integer deviceid);
}
