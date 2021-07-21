package io.renren.modules.device.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.common.utils.Result;
import io.renren.modules.device.entity.MaintainTempEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.device.entity.MissionitemEntity;
import io.renren.modules.device.service.MissionitemService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import sun.applet.Main;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-17 23:33:31
 */
@RestController
@RequestMapping("generator/missionitem")
public class MissionitemController {
    @Autowired
    private MissionitemService missionitemService;

    @GetMapping("/ifo")
    public Result queryAll(){
        Result<List<MissionitemEntity>> result = new Result<>();
        List<MissionitemEntity> missionitemEntities = missionitemService.queryAll();
        return result.ok(missionitemEntities);
    }

    @PostMapping("/add")
    public R addItem(@RequestBody MissionitemEntity item){
        missionitemService.insertItem(item);
        return R.ok();
    }
    @PostMapping("/update")
    public R updateItem(@RequestBody MissionitemEntity item){
        missionitemService.updateItem(item);
        return R.ok();
    }

    @PostMapping("/delete")
    public R deleteItem(@RequestBody Integer[] itemids){
        missionitemService.deleteItem(itemids);
        return R.ok();
    }
    @GetMapping("/search/{name}")
    public Result queryByName(@PathVariable("name") String name){
        Result<List<MissionitemEntity>> result = new Result<>();
        List<MissionitemEntity> missionitemEntities = missionitemService.queryByName(name);
        return result.ok(missionitemEntities);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("generator:missionitem:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = missionitemService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{itemid}")
    @RequiresPermissions("generator:missionitem:info")
    public R info(@PathVariable("itemid") Integer itemid){
		MissionitemEntity missionitem = missionitemService.getById(itemid);

        return R.ok().put("missionitem", missionitem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:missionitem:save")
    public R save(@RequestBody MissionitemEntity missionitem){
		missionitemService.save(missionitem);

        return R.ok();
    }

    /**
     * 修改
     */
//    @RequestMapping("/update")
//    @RequiresPermissions("generator:missionitem:update")
//    public R update(@RequestBody MissionitemEntity missionitem){
//		missionitemService.updateById(missionitem);
//
//        return R.ok();
//    }

    /**
     * 删除
     */
//    @RequestMapping("/delete")
//    @RequiresPermissions("generator:missionitem:delete")
//    public R delete(@RequestBody Integer[] itemids){
//		missionitemService.removeByIds(Arrays.asList(itemids));
//
//        return R.ok();
//    }

}
