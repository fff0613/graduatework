package io.renren.modules.device.service;

import io.renren.modules.device.entity.*;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DetailService {
//    DeviceEntity queryById(int deviceId);
    List<MaintainprojectEntity> getProList(Integer deviceid);
    List<OrganizationEntity> queryOrg(int deviceId);
    List<CompanyEntity> queryCompany(int deviceId);
    DeviceLocEntity queryLoc(int deviceId);
    List<DeviceLogEntity> queryDeviceLog(int deviceId);
    List<EffectiveProtocolEntity> queryEffectiveProtocol(int deviceId);
    //maintain
    List<MaintainLogEntity> queryMaintainLog(Integer deviceid);
    List<MaintainLogEntity> queryRepairLog(Integer deviceid);
}
