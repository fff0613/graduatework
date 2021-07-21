package io.renren.modules.device.controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import io.renren.common.utils.Result;
import io.renren.modules.device.entity.DeviceModelEntity;
import io.renren.modules.device.entity.OptionEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.device.entity.OrganizationEntity;
import io.renren.modules.device.service.OrganizationService;
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
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;
    @GetMapping("/orglist")
    public Result queryOrgList(){
        Result<List<OptionEntity>> result = new Result<>();
        List<OptionEntity> list = organizationService.queryOrgList();
        System.out.println(list.toString());
        return result.ok(list);
    }
    @GetMapping("/actorglist")
    public Result queryActOrgList(){
        Result<List<OrganizationEntity>> result = new Result<>();
        List<OrganizationEntity> list = organizationService.queryActOrg();
        System.out.println(list.toString());
        return result.ok(list);
    }
    @GetMapping("/ifo")
    public Result queryAll(){
        Result<List<OrganizationEntity>> result = new Result<>();
        List<OrganizationEntity> list = organizationService.queryAll();
        return result.ok(list);
    }
    @RequestMapping("/search/{orgName}")
    public Result queryByName(@PathVariable("orgName") String orgName){
        Result<List<OrganizationEntity>> result = new Result<>();
        List<OrganizationEntity> list = organizationService.queryByOrgName(orgName);
        return result.ok(list);
    }
    @PostMapping("/add")
    public Result addOrg(@RequestBody OrganizationEntity organizationEntity){
        String s = organizationService.insertOrg(organizationEntity);
        System.out.println(organizationEntity.toString());
        System.out.println(s);
        Result<String> result = new Result<>();
        return result.ok(s);
    }
    /**
     * 列表
     */
//    @RequestMapping("/list")
//    @RequiresPermissions("rganization:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = organizationService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }


    /**
     * 信息
     */
//    @RequestMapping("/info/{orgname}")
//    @RequiresPermissions("organization:info")
//    public R info(@PathVariable("orgname") String orgname){
//		OrganizationEntity organization = organizationService.getById(orgname);
//
//        return R.ok().put("organization", organization);
//    }

    /**
     * 保存
     */
//    @RequestMapping("/save")
//    @RequiresPermissions("organization:save")
//    public R save(@RequestBody OrganizationEntity organization){
//		organizationService.save(organization);
//
//        return R.ok();
//    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("organization:update")
    public R update(@RequestBody OrganizationEntity organization){
		organizationService.updateOrg(organization);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("generator:organization:delete")
    public R delete(@RequestBody String[] orgnames){
		organizationService.deleteOrg(orgnames);
        return R.ok();
    }

}
