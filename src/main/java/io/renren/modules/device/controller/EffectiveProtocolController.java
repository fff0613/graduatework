package io.renren.modules.device.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.common.utils.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.device.entity.EffectiveProtocolEntity;
import io.renren.modules.device.service.EffectiveProtocolService;
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
@RequestMapping("/effectiveprotocol")
public class EffectiveProtocolController {
    @Autowired
    private EffectiveProtocolService effectiveProtocolService;

    @PostMapping("/prolist")
    public Result queryList(@RequestParam Map<String, Object> params){
        Result<List<EffectiveProtocolEntity>> result = new Result<>();
//        List<EffectiveProtocolEntity> list = effectiveProtocolService.queryProList((Integer) params.get("deviceid"));
        List<EffectiveProtocolEntity> list = effectiveProtocolService.queryProList(Integer.parseInt((String) params.get("deviceid")));
        System.out.println(list);
        return result.ok(list);
    }
    @PostMapping("/add")
    public void addPro(@RequestBody EffectiveProtocolEntity item){
        System.out.println(item.toString());
        effectiveProtocolService.insertPro(item);
    }
    @PostMapping("/update")
    public void updatePro(@RequestBody EffectiveProtocolEntity item){
        System.out.println(item.toString());
        effectiveProtocolService.updatePro(item);
    }
    @PostMapping("/delete")
    public void deletePro(@RequestBody EffectiveProtocolEntity items){
        System.out.println(items.toString());
        effectiveProtocolService.deletePro(items);
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:effectiveprotocol:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = effectiveProtocolService.queryPage(params);

        return R.ok().put("page", page);
    }

    @RequestMapping("/{deviceId}")
    public Result queryAllProByDeviceId(@PathVariable("deviceId") Integer deviceId){
        Result result = new Result();
        return result;
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{proid}")
    @RequiresPermissions("generator:effectiveprotocol:info")
    public R info(@PathVariable("proid") Integer proid){
		EffectiveProtocolEntity effectiveProtocol = effectiveProtocolService.getById(proid);

        return R.ok().put("effectiveProtocol", effectiveProtocol);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:effectiveprotocol:save")
    public R save(@RequestBody EffectiveProtocolEntity effectiveProtocol){
		effectiveProtocolService.save(effectiveProtocol);

        return R.ok();
    }

    /**
     * 修改
     */
//    @RequestMapping("/update")
//    @RequiresPermissions("generator:effectiveprotocol:update")
//    public R update(@RequestBody EffectiveProtocolEntity effectiveProtocol){
//		effectiveProtocolService.updateById(effectiveProtocol);
//
//        return R.ok();
//    }

    /**
     * 删除
     */
//    @RequestMapping("/delete")
//    @RequiresPermissions("generator:effectiveprotocol:delete")
//    public R delete(@RequestBody Integer[] proids){
//		effectiveProtocolService.removeByIds(Arrays.asList(proids));
//
//        return R.ok();
//    }

}
