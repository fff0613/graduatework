package io.renren.modules.device.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.device.entity.*;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-18 12:49:17
 */
public interface MaintainprojectService extends IService<MaintainprojectEntity> {

    List<MaintainprojectEntity> getProList(Integer deviceid);
    List<DeviceEntity> getDeviceList(Integer proid);
    List<DeviceEntity> queryByCon(Map<String, Object> params);
    void insertPro(MaintainPro item);
    void updatePro(MaintainPro item);
    void deletePro(Integer id);
    List<MaintainprojectEntity> queryAll();
    PageUtils queryPage(Map<String, Object> params);
    List<MaintainprojectEntity> queryMPByCon(MaintainProjectCon item);
}

