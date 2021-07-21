package io.renren.modules.device.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.common.utils.Result;
import io.renren.modules.device.entity.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.device.service.MaintainprojectService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-18 12:49:17
 */
@RestController
@RequestMapping("maintainproject")
public class MaintainprojectController {
    @Autowired
    private MaintainprojectService maintainprojectService;

    @PostMapping("/search")
    public Result search(@RequestBody MaintainProjectCon item){
        Result<List<MaintainprojectEntity>> result = new Result<>();
        List<MaintainprojectEntity> maintainEntities = maintainprojectService.queryMPByCon(item);
        return result.ok(maintainEntities);
    }
    @GetMapping("/devicelist/{recordid}")
    public R getDeviceList(@PathVariable("recordid")Integer recordid){
        List<DeviceEntity> inventoryDeviceList = maintainprojectService.getDeviceList(recordid);
        return R.ok().put("devicelist",inventoryDeviceList);
    }
    @GetMapping("/ifo")
    public Result queryAll(){
        Result<List<MaintainprojectEntity>> result = new Result<>();
        List<MaintainprojectEntity> maintainprojectEntities = maintainprojectService.queryAll();
        return result.ok(maintainprojectEntities);
    }
    @RequestMapping("/device/search")
    public Result queryDevice(@RequestParam Map<String, Object> params){
        Result<List<DeviceEntity>> result = new Result<>();
        List<DeviceEntity> deviceEntities = maintainprojectService.queryByCon(params);
        return result.ok(deviceEntities);
    }
    @PostMapping("/add")
    public R addPro(@RequestBody MaintainPro item){
        System.out.println(item.toString());
        maintainprojectService.insertPro(item);
        return R.ok();
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:maintainproject:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = maintainprojectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{projectid}")
//    @RequiresPermissions("generator:maintainproject:info")
    public R info(@PathVariable("projectid") Integer projectid){
		MaintainprojectEntity maintainproject = maintainprojectService.getById(projectid);

        return R.ok().put("maintainproject", maintainproject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:maintainproject:save")
    public R save(@RequestBody MaintainprojectEntity maintainproject){
		maintainprojectService.save(maintainproject);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:maintainproject:update")
    public R update(@RequestBody MaintainprojectEntity maintainproject){
		maintainprojectService.updateById(maintainproject);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("generator:maintainproject:delete")
    public R delete(@RequestBody Integer[] projectids){
		maintainprojectService.removeByIds(Arrays.asList(projectids));

        return R.ok();
    }

}
