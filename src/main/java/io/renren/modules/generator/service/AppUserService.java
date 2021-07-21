package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.AppUserEntityTwo;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 用户
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-22 14:51:43
 */
public interface AppUserService extends IService<AppUserEntityTwo> {
//    void insertAppUser(AppUserEntityTwo item);
    PageUtils queryPage(Map<String, Object> params);
    List<AppUserEntityTwo> queryByName(String name);
}

