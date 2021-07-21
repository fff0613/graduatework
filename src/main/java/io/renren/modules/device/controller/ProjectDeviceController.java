package io.renren.modules.device.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.device.entity.ProjectDeviceEntity;
import io.renren.modules.device.service.ProjectDeviceService;
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
@RequestMapping("generator/projectdevice")
public class ProjectDeviceController {
    @Autowired
    private ProjectDeviceService projectDeviceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:projectdevice:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = projectDeviceService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{projectid}")
    @RequiresPermissions("generator:projectdevice:info")
    public R info(@PathVariable("projectid") Integer projectid){
		ProjectDeviceEntity projectDevice = projectDeviceService.getById(projectid);

        return R.ok().put("projectDevice", projectDevice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:projectdevice:save")
    public R save(@RequestBody ProjectDeviceEntity projectDevice){
		projectDeviceService.save(projectDevice);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:projectdevice:update")
    public R update(@RequestBody ProjectDeviceEntity projectDevice){
		projectDeviceService.updateById(projectDevice);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:projectdevice:delete")
    public R delete(@RequestBody Integer[] projectids){
		projectDeviceService.removeByIds(Arrays.asList(projectids));

        return R.ok();
    }

}
