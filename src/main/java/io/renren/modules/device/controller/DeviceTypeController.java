package io.renren.modules.device.controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import io.renren.common.utils.Result;
import io.renren.modules.device.entity.OptionEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.device.entity.DeviceTypeEntity;
import io.renren.modules.device.service.DeviceTypeService;
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
@RequestMapping("devicetype")
public class DeviceTypeController {
    @Autowired
    private DeviceTypeService deviceTypeService;

    @GetMapping("/typelist")
    public Result queryTypeList(){
        Result<List<OptionEntity>> result = new Result<>();
        List<String> strings = deviceTypeService.queryTypeList();
        List<OptionEntity> list = new LinkedList<>();
        for(String s:strings){
            OptionEntity optionEntity = new OptionEntity();
            optionEntity.setLabel(s);
            optionEntity.setValue(s);
            list.add(optionEntity);
        }
        return result.ok(list);
    }

    @GetMapping("/ifo")
    public Result queryAll(){
        Result<List<DeviceTypeEntity>> result = new Result<>();
        List<DeviceTypeEntity> list = deviceTypeService.queryAll();
        return result.ok(list);
    }
    @RequestMapping("/search/{type}")
    public Result queryByType(@PathVariable("type") String type){
        Result<List<DeviceTypeEntity>> result = new Result<>();
        List<DeviceTypeEntity> list = deviceTypeService.queryByType(type);
        return result.ok(list);
    }
    @PostMapping("/add")
    public R addType(@RequestBody DeviceTypeEntity deviceType){
        String s = deviceTypeService.insertType(deviceType);
        return R.ok();
    }
    @PostMapping("updateState")
    public R updateState(@RequestBody DeviceTypeEntity deviceType){
        deviceTypeService.updateState(deviceType);
        return R.ok();
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("device_type:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = deviceTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{type}")
    @RequiresPermissions("device:type:info")
    public R info(@PathVariable("type") String type){
		DeviceTypeEntity deviceType = deviceTypeService.getById(type);

        return R.ok().put("deviceType", deviceType);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("device_type:save")
    public R save(@RequestBody DeviceTypeEntity deviceType){
		deviceTypeService.save(deviceType);
        System.out.println("ok");
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/updatetype")
    public R update(@RequestBody DeviceTypeEntity deviceType){
		deviceTypeService.updateType(deviceType);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("devicetype:delete")
    public R delete(@RequestBody String[] types){
		deviceTypeService.removeByIds(Arrays.asList(types));

        return R.ok();
    }

}
