package io.renren.modules.device.controller;

import io.renren.common.utils.R;
import io.renren.common.utils.Result;
import io.renren.modules.device.entity.*;
import io.renren.modules.device.service.DetailService;
import io.renren.modules.device.service.DeviceService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/detail")
public class DetailController {
    @Autowired
    DetailService detailService;
    @Autowired
    DeviceService deviceService;

    @GetMapping("/maintainPorject/{deviceid}")
    public R getProject(@PathVariable("deviceid") Integer deviceId){
        List<MaintainprojectEntity> proList = detailService.getProList(deviceId);
        return R.ok().put("prolist",proList);
    }
    @RequestMapping("/repairlog/{deviceid}")
    public Result getRepairLog(@PathVariable("deviceid") Integer deviceId){
        Result<List<MaintainLogEntity>> result = new Result<>();
        List<MaintainLogEntity> maintainLogEntities = detailService.queryRepairLog(deviceId);
        System.out.println("controller repairlog");
        return result.ok(maintainLogEntities);
    }

    @RequestMapping("/maintainlog/{deviceid}")
    public Result getMaintainLog(@PathVariable("deviceid") Integer deviceId){
        Result<List<MaintainLogEntity>> result = new Result<>();
        List<MaintainLogEntity> maintainLogEntities = detailService.queryMaintainLog(deviceId);
        System.out.println("controller maintainlog");
        return result.ok(maintainLogEntities);
    }

    @RequestMapping("/devicelog/{deviceid}")
    public Result getDeviceLog(@PathVariable("deviceid") Integer deviceId){
        Result<List<DeviceLogEntity>> result = new Result<>();
        List<DeviceLogEntity> deviceLogEntities = detailService.queryDeviceLog(deviceId);
        System.out.println("controller devicelog");
        return result.ok(deviceLogEntities);
    }
    @RequestMapping("/location/{deviceid}")
    public Result getLoc(@PathVariable("deviceid") Integer deviceId){
        Result<DeviceLocEntity> result = new Result<>();
        DeviceLocEntity device = detailService.queryLoc(deviceId);
        return result.ok(device);
    }

    @GetMapping("/basis/{deviceId}")
    public Result basisIfo(@PathVariable("deviceId") String  deviceId){
        Result<DeviceEntity> result = new Result<>();
        DeviceEntity device = deviceService.getById(Integer.parseInt(deviceId));
        return result.ok(device);
    }
    @PostMapping("/orglist")
    public Result relativeOrg(@RequestParam Map<String, Object> params){
        Result<List<OrganizationEntity>> result = new Result<>();
        System.out.println(params.get("deviceid"));
//        DeviceEntity device = deviceService.queryById(Integer.parseInt((String)params.get("deviceid")));
        List<OrganizationEntity> list = detailService.queryOrg(Integer.parseInt((String)params.get("deviceid")));
//        List<OrganizationEntity> list = detailService.queryOrg((Integer) params.get("deviceid"));
        return result.ok(list);
    }
//    @PostMapping("/fellowlist")
//    public Result relativeFel(@RequestParam Map<String, Object> params){
//        Result<List<OrganizationEntity>> result = new Result<>();
//        System.out.println(params.get("deviceid"));
////        DeviceEntity device = deviceService.queryById(Integer.parseInt((String)params.get("deviceid")));
//        List<OrganizationEntity> device = detailService.queryOrg(Integer.parseInt((String)params.get("deviceid")));
//        return result.ok(device);
//    }
    @PostMapping("/complist")
    public Result relativeCom(@RequestParam Map<String, Object> params){
        Result<List<CompanyEntity>> result = new Result<>();
//        List<CompanyEntity> device = detailService.queryCompany((Integer) params.get("deviceid"));
        List<CompanyEntity> device = detailService.queryCompany(Integer.parseInt((String)params.get("deviceid")));
        return result.ok(device);
    }
    @PostMapping("/log")
    public  Result getAllLog(@RequestParam Map<String, Object> params){

        Result<DeviceLogEntity> result = new Result();
        return result;
    }
}
