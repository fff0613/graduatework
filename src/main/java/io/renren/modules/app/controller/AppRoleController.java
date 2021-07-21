package io.renren.modules.app.controller;

import io.renren.common.utils.R;
import io.renren.common.utils.Result;
import io.renren.common.validator.Assert;
import io.renren.modules.app.entity.AppUserEntity;
import io.renren.modules.app.entity.PasswordEntity;
import io.renren.modules.app.service.UserService;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.form.PasswordForm;
import io.renren.modules.sys.service.SysRoleService;
import io.renren.modules.sys.service.SysUserService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/ifo")
public class AppRoleController {
    @Autowired
    private UserService userService;
    @Autowired
    SysRoleService sysRoleService;
    @Autowired
    SysUserService sysUserService;
//    @GetMapping("/role/{mobile}")
//    public Result getRole(@PathVariable("mobile")String mobile){
//        Result<List<String>> result = new Result<List<String>>();
//        return result;
//    }
    @GetMapping("/{mobile}")
    public Result queryByMobile(@PathVariable("mobile")String mobile){
        System.out.println("mobile");
        Result<AppUserEntity> result = new Result<>();
        AppUserEntity sysUserEntity = userService.querySysUserByMobile(mobile);
        return result.ok(sysUserEntity);
    }
    //meixie
    @PostMapping("/password")
    public R password(@RequestBody PasswordEntity form){
//        Assert.isBlank(form.getConfirmpassword(), "新密码不为能空");
//        SysUserEntity user = sysUserService.getUserById(form.getId());
//        //sha256加密
//        String password = new Sha256Hash(form.getPassword(), user.getSalt()).toHex();
//        //sha256加密
//        String newPassword = new Sha256Hash(form.getConfirmpassword(), user.getSalt()).toHex();
//
//        //更新密码
//        boolean flag = sysUserService.updatePassword(user.getUserId(), password, newPassword);
//        if(!flag){
//            return R.error("原密码不正确");
//        }
//        userService.updateUser(form);

        return R.ok();
    }
}
