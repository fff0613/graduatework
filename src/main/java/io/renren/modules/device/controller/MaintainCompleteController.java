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

import io.renren.modules.device.entity.MaintainCompleteEntity;
import io.renren.modules.device.service.MaintainCompleteService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-09 21:24:29
 */
@RestController
@RequestMapping("generator/maintaincomplete")
public class MaintainCompleteController {
    @Autowired
    private MaintainCompleteService maintainCompleteService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:maintaincomplete:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = maintainCompleteService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:maintaincomplete:info")
    public R info(@PathVariable("id") Long id){
		MaintainCompleteEntity maintainComplete = maintainCompleteService.getById(id);

        return R.ok().put("maintainComplete", maintainComplete);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:maintaincomplete:save")
    public R save(@RequestBody MaintainCompleteEntity maintainComplete){
		maintainCompleteService.save(maintainComplete);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:maintaincomplete:update")
    public R update(@RequestBody MaintainCompleteEntity maintainComplete){
		maintainCompleteService.updateById(maintainComplete);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:maintaincomplete:delete")
    public R delete(@RequestBody Long[] ids){
		maintainCompleteService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
