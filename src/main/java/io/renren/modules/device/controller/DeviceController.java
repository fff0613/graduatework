package io.renren.modules.device.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.renren.common.utils.Result;
import io.renren.modules.device.entity.*;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.device.service.DeviceService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-08 13:57:16
 */
@RestController
@RequestMapping("/device")
@Api("device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;
    @RequestMapping("/app/searchname")
    public Result queryName(@RequestBody Integer[] deviceids){
        Result<List<DeviceEntity>> result = new Result<>();
        List<DeviceEntity> deviceEntities = deviceService.queryName(deviceids);
        return result.ok(deviceEntities);
    }

    @GetMapping("/{stockname}")
    public Result queryByStock(@PathVariable("stockname")String stockname){
        Result<List<DeviceEntity>> result = new Result<>();
        List<DeviceEntity> deviceEntities = deviceService.queryByStock(stockname);
        return result.ok(deviceEntities);
    }
    @GetMapping("/devicelist")
    public Result getDeviceList(){
        Result<List<DeviceBriefIfo>> result = new Result<>();
        List<DeviceBriefIfo> deviceList = deviceService.getDeviceList();
        System.out.println(deviceList);
        return result.ok(deviceList);
    }
    @PostMapping("/search")
    public Result queryByCondition(@RequestBody DeviceCon item){
        Result<List<DeviceEntity>> result = new Result<>();
        List<DeviceEntity> deviceEntities = deviceService.queryByCon(item);
        return result.ok(deviceEntities);
    }
    @PostMapping("/maintainsearch")
    public Result maintainSearch(@RequestParam Map<String, Object> params){
        Result<List<DeviceEntity>> result = new Result<>();
        List<DeviceEntity> deviceEntities = deviceService.maintainSearch(params);
        return result.ok(deviceEntities);
    }

    @GetMapping("/ifo/{deviceid}")
    public Result queryByid(@PathVariable("deviceid") Integer deviceid){
        System.out.println("deviceid: "+deviceid);
        Result<DeviceEntity> result = new Result<>();
        DeviceEntity deviceEntity = deviceService.queryById(deviceid);
        return result.ok(deviceEntity);
    }
    /**
     * 列表
     */
    @PostMapping("/updatebrief")
    public Result updateBrief(@RequestBody DeviceBriefIfo params){
//        DeviceBriefIfo deviceBriefIfo = new DeviceBriefIfo();
//        deviceBriefIfo.setId((Integer)params.get("deviceid"));
//        deviceBriefIfo.setName((String)params.get("devicename"));
//        deviceBriefIfo.setState((String)params.get("devicestate"));
        System.out.println(params.toString());
        String s = deviceService.updateBrief(params);
        Result<String> result = new Result<>();
        return result.ok(s);
    }

    @GetMapping("/brief")
    public Result queryDevice(){
        //ModelAndView mv = new ModelAndView();
//        List<DeviceIfoEntity> list = deviceService.queryBriefIfo();
        Result<List<DeviceEntity>> result = new Result();
        List<DeviceEntity> deviceEntities = deviceService.queryAll();
        //result.setData("asgjds");

        return result.ok(deviceEntities);
    }
    @PostMapping("/add")
//    @RequiresPermissions("device:save")
    public Result addDevice(@RequestBody DeviceEntity device){
        Result<String> result = new Result<>();
        System.out.println(device.toString());
        String s = deviceService.insertDevice(device);
        System.out.println(s);
//        DeviceEntity newDevice = new DeviceEntity();
//        setDeviceEntity(newDevice,device);
//        System.out.println(newDevice.getDevicename());
//        deviceService.save(newDevice);
        return result.ok(s);
    }
    public void setDeviceEntity(DeviceEntity newDevice,Map<String, Object> device){
        newDevice.setDevicename((String)device.get("deviceName"));
        newDevice.setDevicemodel((String)device.get("deviceModel"));
        newDevice.setDevicetype((String)device.get("deviceType"));
        newDevice.setBeforetax((Float) device.get("beforeTax"));
        newDevice.setDevicesourse((String)device.get("deviceSourse"));
        newDevice.setManufacture((String)device.get("manufacture"));
        newDevice.setTax((Float) device.get("tax"));
        newDevice.setTaxrate((Float) device.get("taxRate"));
        newDevice.setSupporter((String)device.get("supporter"));
//        newDevice.setBuydate((Date)device.get("buyDate"));
//        newDevice.setEffectivedate((Date)device.get("effectiveDate"));
//        newDevice.setStockdetailloc((String)device.get("mountLoc"));
//        newDevice.setStoragedate((Date)device.get("mountDate"));
        //启用日期
    }


    @PostMapping("/state")
    public Result queryState(@RequestParam Map<String, Object> params){
        Result<List<DeviceEntity>> result = new Result();
        List<DeviceEntity> list = deviceService.queryByState((String)params.get("state"));
        return result.ok(list);
    }
    //从queryByStock变成了queryByStockAndName
    @PostMapping("/origin")
    public Result queryOrigin(@RequestParam Map<String, Object> params){
        Result<List<DeviceEntity>> result = new Result();
        List<DeviceEntity> list = deviceService.queryByStockAndState((String)params.get("stock"),"在库中");
        return result.ok(list);
    }


    @RequestMapping("/list")
    @RequiresPermissions("generator:device:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = deviceService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @PostMapping("/info")
///   @RequiresPermissions("generator:device:info")
    public Result info(@RequestParam Map<String, Object> params){
        System.out.println(params.get("deviceid"));
        DeviceEntity device = deviceService.queryById(Integer.parseInt((String)params.get("deviceid")));
        Result<DeviceEntity> result = new Result<>();
        return result.ok(device);
    }
    @GetMapping("/info/{deviceid}")
//    @RequiresPermissions("generator:liferecord:info")
    public R info(@PathVariable("deviceid") String deviceid){
        System.out.println(deviceid+" deviceid");
        DeviceEntity deviceEntity = deviceService.queryById(Integer.parseInt(deviceid));

        return R.ok().put("device", deviceEntity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:device:save")
    public R save(@RequestBody DeviceEntity device){
		deviceService.save(device);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
//    @RequiresPermissions("generator:device:update")
    public R update(@RequestBody DeviceEntity device){
        System.out.println(device.toString());
        deviceService.updateDevice(device);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
//    @RequiresPermissions("generator:device:delete")
    public R delete(@RequestBody Integer[] deviceids){
		deviceService.deleteDevice(deviceids);

        return R.ok();
    }

}
