package io.renren.modules.device.controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import io.renren.common.utils.Result;
import io.renren.modules.device.entity.DeviceTypeEntity;
import io.renren.modules.device.entity.OptionEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.device.entity.DeviceModelEntity;
import io.renren.modules.device.service.DeviceModelService;
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
@RequestMapping("/devicemodel")
public class DeviceModelController {
    @Autowired
    private DeviceModelService deviceModelService;
    @GetMapping("/modellist/{devicetype}")
    public Result queryModel(@PathVariable("devicetype")String devicetype){
        Result<List<OptionEntity>> result = new Result<>();
        List<OptionEntity> optionEntities = deviceModelService.queryByType(devicetype);
        return result.ok(optionEntities);
    }

    @GetMapping("/modellist")
    public Result queryTypeList(){
        Result<List<OptionEntity>> result = new Result<>();
        List<OptionEntity> optionEntities = deviceModelService.queryModelList();
        return result.ok(optionEntities);
    }
    @GetMapping("/ifo")
    public Result queryAll(){
        Result<List<DeviceModelEntity>> result = new Result<>();
        List<DeviceModelEntity> list = deviceModelService.queryAll();
        return result.ok(list);
    }
    @RequestMapping("/search/{model}")
    public Result queryByModel(@PathVariable("model") String model){
        Result<List<DeviceModelEntity>> result = new Result<>();
        List<DeviceModelEntity> list = deviceModelService.queryByModel(model);
        return result.ok(list);
    }
    @PostMapping("/add")
    public R addModel(@RequestBody DeviceModelEntity deviceModel){
        String s = deviceModelService.insertModel(deviceModel);
        System.out.println(s);
        return R.ok();
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:devicemodel:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = deviceModelService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{model}")
    @RequiresPermissions("generator:devicemodel:info")
    public R info(@PathVariable("model") String model){
		DeviceModelEntity deviceModel = deviceModelService.getById(model);

        return R.ok().put("deviceModel", deviceModel);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("device_model:save")
    public R save(@RequestBody DeviceModelEntity deviceModel){
		deviceModelService.save(deviceModel);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody DeviceModelEntity deviceModel){
		deviceModelService.updateModel(deviceModel);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
//    @RequiresPermissions("generator:devicemodel:delete")
    public R delete(@RequestBody String[] models){
//		deviceModelService.removeByIds(Arrays.asList(models));
        deviceModelService.deleteModel(models);
        return R.ok();
    }

}
