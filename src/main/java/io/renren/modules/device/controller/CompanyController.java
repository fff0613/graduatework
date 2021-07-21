package io.renren.modules.device.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.common.utils.Result;
import io.renren.modules.device.entity.OptionEntity;
import io.renren.modules.device.entity.OrganizationEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.device.entity.CompanyEntity;
import io.renren.modules.device.service.CompanyService;
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
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/cpylist")
    public Result queryList(){
        Result<List<OptionEntity>> result = new Result<>();
        List<OptionEntity> list = companyService.queryList();
        return result.ok(list);
    }
    @GetMapping("/suplist")
    public Result querySupList(){
        Result<List<OptionEntity>> result = new Result<>();
        List<OptionEntity> list = companyService.querySupList();
        return result.ok(list);
    }
    @GetMapping("/manlist")
    public Result queryManList(){
        Result<List<OptionEntity>> result = new Result<>();
        List<OptionEntity> list = companyService.queryManList();
        return result.ok(list);
    }
    @GetMapping("/ifo")
    public Result queryAll(){
        Result<List<CompanyEntity>> result = new Result<>();
        List<CompanyEntity> list = companyService.queryAll();
        return result.ok(list);
    }
    @RequestMapping("/search/{cpyName}")
    public Result queryByName(@PathVariable("cpyName") String cpyName){
        Result<List<CompanyEntity>> result = new Result<>();
        List<CompanyEntity> list = companyService.queryByName(cpyName);
        return result.ok(list);
    }
    @PostMapping("/add")
    public Result add(@RequestBody CompanyEntity companyEntity){
        System.out.println(companyEntity.toString());
        String s = companyService.insertCpy(companyEntity);
        System.out.println(companyEntity.toString());
        System.out.println(s);
        Result<String> result = new Result<>();
        return result.ok(s);
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:company:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = companyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{companyname}")
//    @RequiresPermissions("generator:company:info")
    public Result info(@PathVariable("companyname") String companyname){
//		CompanyEntity company = companyService.getById(companyname);
        Result<List<CompanyEntity>> result = new Result<>();
        List<CompanyEntity> companyEntities = companyService.queryByName(companyname);
        return result.ok(companyEntities);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:company:save")
    public R save(@RequestBody CompanyEntity company){
		companyService.save(company);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("generator:company:update")
    public R update(@RequestBody CompanyEntity company){
		companyService.updateCpy(company);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("generator:company:delete")
    public R delete(@RequestBody String[] companynames){
		companyService.deleteCpy(companynames);

        return R.ok();
    }

}
