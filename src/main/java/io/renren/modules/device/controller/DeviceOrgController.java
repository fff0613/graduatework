package io.renren.modules.device.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.utils.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.device.entity.DeviceOrgEntity;
import io.renren.modules.device.service.DeviceOrgService;
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
@RequestMapping("generator/deviceorg")
public class DeviceOrgController {
    @Autowired
    private DeviceOrgService deviceOrgService;

    @CrossOrigin
    @PostMapping("/addorg")
    public R addorg(@RequestParam Map<String, Object> params){
        DeviceOrgEntity item = new DeviceOrgEntity();
        System.out.println(params.get("deviceid"));
        item.setDeviceid(Integer.parseInt((String)params.get("deviceid")));
        item.setOrgname((String)params.get("orgname"));
        deviceOrgService.insertOrg(item);
        return R.ok();
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:deviceorg:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = deviceOrgService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{deviceid}")
    @RequiresPermissions("generator:deviceorg:info")
    public R info(@PathVariable("deviceid") Integer deviceid){
		DeviceOrgEntity deviceOrg = deviceOrgService.getById(deviceid);

        return R.ok().put("deviceOrg", deviceOrg);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:deviceorg:save")
    public R save(@RequestBody DeviceOrgEntity deviceOrg){
		deviceOrgService.save(deviceOrg);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:deviceorg:update")
    public R update(@RequestBody DeviceOrgEntity deviceOrg){
		deviceOrgService.updateById(deviceOrg);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
//    @RequiresPermissions("generator:deviceorg:delete")
    public R delete(@RequestParam Map<String, Object> params){
        DeviceOrgEntity item = new DeviceOrgEntity();
        System.out.println(params.get("deviceid"));
        item.setDeviceid(Integer.parseInt((String)params.get("deviceid")));
        item.setOrgname((String)params.get("orgname"));
        deviceOrgService.deleteOrg(item);
        return R.ok();
    }

}
