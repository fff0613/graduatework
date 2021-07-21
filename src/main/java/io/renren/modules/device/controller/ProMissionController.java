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

import io.renren.modules.device.entity.ProMissionEntity;
import io.renren.modules.device.service.ProMissionService;
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
@RequestMapping("generator/promission")
public class ProMissionController {
    @Autowired
    private ProMissionService proMissionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:promission:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = proMissionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{projectid}")
    @RequiresPermissions("generator:promission:info")
    public R info(@PathVariable("projectid") Integer projectid){
		ProMissionEntity proMission = proMissionService.getById(projectid);

        return R.ok().put("proMission", proMission);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:promission:save")
    public R save(@RequestBody ProMissionEntity proMission){
		proMissionService.save(proMission);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:promission:update")
    public R update(@RequestBody ProMissionEntity proMission){
		proMissionService.updateById(proMission);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:promission:delete")
    public R delete(@RequestBody Integer[] projectids){
		proMissionService.removeByIds(Arrays.asList(projectids));

        return R.ok();
    }

}
