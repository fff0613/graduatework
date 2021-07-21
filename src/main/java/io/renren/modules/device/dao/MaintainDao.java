package io.renren.modules.device.dao;

import io.renren.modules.device.entity.MaintainEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.device.entity.MaintainconEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;
import sun.applet.Main;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-17 10:45:15
 */
@Mapper
public interface MaintainDao extends BaseMapper<MaintainEntity> {
//	void insertMaintain(MaintainEntity item);
	void insertRepair(MaintainEntity item);
	void updateExecute(MaintainEntity item);
	void updateConfirm(MaintainEntity item);
	void updateDelivery(MaintainEntity item);
	List<MaintainEntity> querylist();
	List<MaintainEntity> queryByExeId(Long id);
	List<MaintainEntity> queryByContent(Long id,String content);
//	void insertReport(MaintainEntity item);
	List<MaintainEntity> queryRepairLog(Integer deviceid);
	List<MaintainEntity> queryMaintainLog(Integer deviceid);
	List<MaintainEntity> queryByCon(MaintainconEntity item);
	List<MaintainEntity> queryByType(MaintainconEntity item);
	List<MaintainEntity> queryByState(MaintainconEntity item);
	List<MaintainEntity> queryByDevice(MaintainconEntity item);
	List<MaintainEntity> queryByStart(MaintainconEntity item);
	List<MaintainEntity> queryByEnd(MaintainconEntity item);
	List<MaintainEntity> queryByTheme(MaintainconEntity item);
	List<MaintainEntity> queryByTypeAndState(MaintainconEntity item);
	List<MaintainEntity> queryByTypeAndDevice(MaintainconEntity item);
	List<MaintainEntity> queryByTypeAndTheme(MaintainconEntity item);
	List<MaintainEntity> queryByStateAndDevice(MaintainconEntity item);
	List<MaintainEntity> queryByStateAndTheme(MaintainconEntity item);
	List<MaintainEntity> queryByDeviceAndTheme(MaintainconEntity item);
	List<MaintainEntity> queryByTypeAndStateAndDevice(MaintainconEntity item);
	List<MaintainEntity> queryByTypeAndDeviceAndTheme(MaintainconEntity item);
	List<MaintainEntity> queryByTypeAndStateAndTheme(MaintainconEntity item);
	List<MaintainEntity> queryByStateAndDeviceAndTheme(MaintainconEntity item);
	List<MaintainEntity> queryByTypeAndStateAndDeviceAndTheme(MaintainconEntity item);
}
