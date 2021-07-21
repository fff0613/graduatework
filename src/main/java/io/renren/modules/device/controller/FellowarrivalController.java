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

import io.renren.modules.device.entity.FellowarrivalEntity;
import io.renren.modules.device.service.FellowarrivalService;
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
@RequestMapping("generator/fellowarrival")
public class FellowarrivalController {
    @Autowired
    private FellowarrivalService fellowarrivalService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:fellowarrival:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fellowarrivalService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userid}")
    @RequiresPermissions("generator:fellowarrival:info")
    public R info(@PathVariable("userid") Long userid){
		FellowarrivalEntity fellowarrival = fellowarrivalService.getById(userid);

        return R.ok().put("fellowarrival", fellowarrival);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:fellowarrival:save")
    public R save(@RequestBody FellowarrivalEntity fellowarrival){
		fellowarrivalService.save(fellowarrival);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:fellowarrival:update")
    public R update(@RequestBody FellowarrivalEntity fellowarrival){
		fellowarrivalService.updateById(fellowarrival);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:fellowarrival:delete")
    public R delete(@RequestBody Long[] userids){
		fellowarrivalService.removeByIds(Arrays.asList(userids));

        return R.ok();
    }

}
