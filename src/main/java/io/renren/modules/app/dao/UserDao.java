/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.app.entity.PasswordEntity;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
    SysUserService queryByMobile(String mobile);
    void updatePassword(PasswordEntity passwordEntity);
}
