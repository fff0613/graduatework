package io.renren.modules.generator.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.renren.common.utils.Constant;
import io.renren.modules.generator.entity.AppUserEntityThree;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.generator.entity.AppUserEntityTwo;
import io.renren.modules.generator.service.AppUserService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 用户
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-22 14:51:43
 */
@RestController
@RequestMapping("generator/user")
public class AppUserController {
    @Autowired
    private AppUserService appUserService;
//    @Autowired
//    private UserService userService;
//    @GetMapping("/search/{username}")
//    public R search(@PathVariable("username")String username){
//        List<AppUserEntityTwo> appUserEntityTwos = appUserService.queryByName(username);
//        return R.ok("user",appUserEntityTwos);
//    }
    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("generator:user:list")
    public R list(@RequestParam Map<String, Object> params){

        PageUtils page = appUserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
//    @RequiresPermissions("generator:user:info")
    public R info(@PathVariable("userId") Long userId){
		AppUserEntityTwo user = appUserService.getById(userId);

        return R.ok().put("user", user);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("generator:user:save")
    public R save(@RequestBody AppUserEntityTwo user){
//        AppUserEntityTwo user2 = new AppUserEntityTwo();
//        user2.setUsername(user.getUsername());
//        user2.setMobile(user.getMobile());
        user.setPassword(DigestUtils.sha256Hex(user.getPassword()));
//        user2.setCreateTime(user.getCreateTime());
        Date day=new Date();
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setCreateTime(day);
        appUserService.save(user);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("generator:user:update")
    public R update(@RequestBody AppUserEntityTwo user){
//        AppUserEntityTwo user2 = new AppUserEntityTwo();
//        user2.setUsername(user.getUsername());
//        user2.setMobile(user.getMobile());
        user.setPassword(DigestUtils.sha256Hex(user.getPassword()));

//        user2.setCreateTime(user.getCreateTime());
		appUserService.updateById(user);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("generator:user:delete")
    public R delete(@RequestBody Long[] userIds){
		appUserService.removeByIds(Arrays.asList(userIds));

        return R.ok();
    }

}
