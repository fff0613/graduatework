package io.renren.modules.device.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.device.entity.MaintainEntity;
import io.renren.modules.device.entity.MaintainLogEntity;
import io.renren.modules.device.entity.MaintainconEntity;
import io.renren.modules.device.entity.ReportMaintainEntity;
import io.renren.modules.sys.entity.SysUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-17 10:45:15
 */
public interface MaintainService extends IService<MaintainEntity> {
    List<MaintainEntity> queryByContent(Long id,String content);
    List<MaintainEntity> queryByExeId(Long id);
    void updateExecute(MaintainEntity item);
    void updateConfirm(MaintainEntity item);
    void updateDelivery(MaintainEntity item);
    List<SysUserEntity> queryFellowList();
    String insertMaintain(ReportMaintainEntity item);
    String insertRepair(ReportMaintainEntity item);
    List<MaintainEntity> queryall();
    PageUtils queryPage(Map<String, Object> params);
//    List<MaintainLogEntity> queryMaintainLog(Integer deviceid);
//    List<MaintainLogEntity> queryRepairLog(Integer deviceid);
    List<MaintainEntity> queryByCon(MaintainconEntity item);
}

