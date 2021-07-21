package io.renren.modules.device.dao;

import io.renren.modules.device.entity.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-18 12:49:17
 */
@Mapper
public interface MaintainprojectDao extends BaseMapper<MaintainprojectEntity> {
	List<Integer> getProList(Integer deviceid);
	List<Integer> getDeviceList(Integer proid);
	void insertMD(Integer mpid,Integer deviceid);
	void updateMD(MaintainDeviceEntity item);
	int insertPro(MaintainprojectEntity item);
	void updatePro(MaintainprojectEntity item);
	void deletePro(Integer id);
	List<MaintainprojectEntity> queryAll();
	List<MaintainprojectEntity> queryByType(MaintainProjectCon item);
	List<MaintainprojectEntity> queryByState(MaintainProjectCon item);
	List<MaintainprojectEntity> queryByTheme(MaintainProjectCon item);
	List<MaintainprojectEntity> queryByTypeAndState(MaintainProjectCon item);
	List<MaintainprojectEntity> queryByTypeAndTheme(MaintainProjectCon item);
	List<MaintainprojectEntity> queryByStateAndTheme(MaintainProjectCon item);
	List<MaintainprojectEntity> queryByTypeAndStateAndTheme(MaintainProjectCon item);
}
