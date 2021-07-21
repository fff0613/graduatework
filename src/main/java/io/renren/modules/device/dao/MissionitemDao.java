package io.renren.modules.device.dao;

import io.renren.modules.device.entity.MissionitemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-17 23:33:31
 */
@Mapper
public interface MissionitemDao extends BaseMapper<MissionitemEntity> {
	List<MissionitemEntity> queryAll();
	void insertItem(MissionitemEntity item);
	void updateItem(MissionitemEntity item);
	void deleteItem(Integer itemid);
	List<MissionitemEntity> queryByName(String name);
	MissionitemEntity queryById(Integer itemid);
	List<Integer> getProList(Integer deviceid);

}
