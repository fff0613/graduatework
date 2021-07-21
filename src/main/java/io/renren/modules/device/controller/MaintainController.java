package io.renren.modules.device.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.common.utils.Result;
import io.renren.modules.device.entity.*;
import io.renren.modules.sys.controller.AbstractController;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import io.swagger.models.auth.In;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.device.service.MaintainService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-17 10:45:15
 */
@RestController
@RequestMapping("generator/maintain")
public class MaintainController extends AbstractController {
    @Autowired
    private MaintainService maintainService;
    @Autowired
    private SysUserService sysUserService;
    @GetMapping("/user/{userid}")
    public Result getUser(@PathVariable("userid")Long userid){
        Result<String> result = new Result<>();
        String s = sysUserService.queryByUserId(userid);
        return result.ok(s);
    }
    @GetMapping("fellowlist")
    public Result queryList(){
        Result<List<SysUserEntity>> result = new Result<>();
        List<SysUserEntity> list = maintainService.queryFellowList();
        return result.ok(list);
    }
    @PostMapping("/search")
    public Result search(@RequestBody MaintainConRec item){
        MaintainconEntity maintainconEntity = new MaintainconEntity();
        maintainconEntity.setEnd(item.getEnd());
        maintainconEntity.setState(item.getState());
        if(item.getDevice() != null && !item.getDevice().equals(""))
            maintainconEntity.setDevice(Integer.parseInt(item.getDevice()));
        maintainconEntity.setStart(item.getStart());
        maintainconEntity.setTheme(item.getTheme());
        maintainconEntity.setType(item.getType());
        Result<List<MaintainEntity>> result = new Result<>();
        List<MaintainEntity> maintainEntities = maintainService.queryByCon(maintainconEntity);
        return result.ok(maintainEntities);
    }

    @GetMapping("/ifo")
    public Result queryAll(){
        Result<List<MaintainEntity>> result = new Result<>();
        List<MaintainEntity> queryall = maintainService.queryall();
        return result.ok(queryall);
    }
    @GetMapping("/ifo/{exeid}")
    public Result queryByExeId(@PathVariable("exeid")Long exeid){
        Result<List<MaintainEntity>> result = new Result<>();
        List<MaintainEntity> queryall = maintainService.queryByExeId(exeid);
        return result.ok(queryall);
    }
    @GetMapping("/ifo/{exeid}/{content}")
    public Result queryByContent(@PathVariable("exeid")Long exeid,@PathVariable("content")String content){
        Result<List<MaintainEntity>> result = new Result<>();
        List<MaintainEntity> queryall = maintainService.queryByContent(exeid,content);
        return result.ok(queryall);
    }
    @PostMapping("/add")
    public R add(@RequestBody ReportMaintainEntity item){
        if(item.getReporterid() == null || item.getReporterid().equals("")){
            System.out.println(item.getReporterid());
            item.setReporterid(CurrentUserEntity.userid);
            System.out.println(item.getReporterid());
        }
        maintainService.insertRepair(item);
        return R.ok();
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:maintain:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = maintainService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{workorderid}")
//    @RequiresPermissions("generator:maintain:info")
    public R info(@PathVariable("workorderid") Integer workorderid){
		MaintainEntity maintain = maintainService.getById(workorderid);

        return R.ok().put("maintain", maintain);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:maintain:save")
    public R save(@RequestBody MaintainEntity maintain){
		maintainService.save(maintain);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update/distribute")
//    @RequiresPermissions("generator:maintain:update")
    public R update(@RequestBody MaintainEntity maintain){
		maintainService.updateDelivery(maintain);

        return R.ok();
    }
    @RequestMapping("/update/execute")
//    @RequiresPermissions("generator:maintain:update")
    public R updateExe(@RequestBody MaintainEntity maintain){
        maintainService.updateExecute(maintain);

        return R.ok();
    }
    @RequestMapping("/update/confirm")
//    @RequiresPermissions("generator:maintain:update")
    public R updateConfirm(@RequestBody MaintainEntity maintain){
        maintainService.updateConfirm(maintain);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:maintain:delete")
    public R delete(@RequestBody Integer[] workorderids){
		maintainService.removeByIds(Arrays.asList(workorderids));

        return R.ok();
    }

}
