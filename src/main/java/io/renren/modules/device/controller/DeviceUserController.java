package io.renren.modules.device.controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import io.renren.common.utils.Result;
import io.renren.modules.device.entity.FellowEntity;
import io.renren.modules.device.entity.OrganizationEntity;
import io.renren.modules.sys.entity.SysUserEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.device.entity.DeviceUserEntity;
import io.renren.modules.device.service.DeviceUserService;
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
@RequestMapping("/deviceuser")
public class DeviceUserController {
    @Autowired
    private DeviceUserService deviceUserService;

//    @PostMapping("/fellowlist")
//    public Result relativeFel(@RequestParam Map<String, Object> params){
////        Result<List<OrganizationEntity>> result = new Result<>();
////        System.out.println(params.get("deviceid"));
//////        DeviceEntity device = deviceService.queryById(Integer.parseInt((String)params.get("deviceid")));
////        List<OrganizationEntity> device = deviceUserService.queryFellow(Integer.parseInt((String)params.get("deviceid")));
////        return result.ok(device);
//    }
    @RequestMapping("/userlist/{deviceid}/{role}")
    public Result getUserByDeviceId(@PathVariable("deviceid")Integer deviceid,@PathVariable("role")String role){
        Result<List<SysUserEntity>> result = new Result<>();
        List<SysUserEntity> list = deviceUserService.getUserByDeviceId(deviceid,role);
        return result.ok(list);
    }
    @RequestMapping("/app/userlist/{deviceid}/{role}")
    public Result getAppUserByDeviceId(@PathVariable("deviceid")Integer deviceid,@PathVariable("role")String role){
        Result<List<SysUserEntity>> result = new Result<>();
        List<SysUserEntity> list = deviceUserService.getUserByDeviceId(deviceid,role);
        return result.ok(list);
    }
    @RequestMapping("/fellowlist")
    public Result getUserIdByDeviceId(@RequestParam Map<String, Object> params){
        Result<List<FellowEntity>> result = new Result<>();
        List<FellowEntity> list = deviceUserService.queryFellow(Integer.parseInt((String)params.get("deviceid")));
        return result.ok(list);
     }
     @PostMapping("/add")
     public R addUser(@RequestBody FellowEntity item){
         String s = deviceUserService.insertFellow(item);
         System.out.println(s);
         return R.ok();
     }
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:deviceuser:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = deviceUserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{deviceid}")
    @RequiresPermissions("generator:deviceuser:info")
    public R info(@PathVariable("deviceid") Integer deviceid){
		DeviceUserEntity deviceUser = deviceUserService.getById(deviceid);

        return R.ok().put("deviceUser", deviceUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:deviceuser:save")
    public R save(@RequestBody DeviceUserEntity deviceUser){
		deviceUserService.save(deviceUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:deviceuser:update")
    public R update(@RequestBody DeviceUserEntity deviceUser){
		deviceUserService.updateById(deviceUser);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("generator:deviceuser:delete")
    public R delete(@RequestBody FellowEntity item){
		deviceUserService.deleteFellow(item);

        return R.ok();
    }

}
