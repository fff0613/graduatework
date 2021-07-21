package io.renren.modules.generator.service.impl;

import io.renren.modules.sys.entity.SysUserEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.AppUserDao;
import io.renren.modules.generator.entity.AppUserEntityTwo;
import io.renren.modules.generator.service.AppUserService;


@Service("appUserService")
public class AppUserServiceImpl extends ServiceImpl<AppUserDao, AppUserEntityTwo> implements AppUserService {

//    @Override
//    public void insertAppUser(AppUserEntityTwo item) {
//        baseMapper.save
//    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String username = (String)params.get("username");
        IPage<AppUserEntityTwo> page = this.page(
                new Query<AppUserEntityTwo>().getPage(params),
                new QueryWrapper<AppUserEntityTwo>()
                    .like(StringUtils.isNotBlank(username),"username", username)
        );

        return new PageUtils(page);
    }

    @Override
    public List<AppUserEntityTwo> queryByName(String name) {
        return baseMapper.queryByName(name);
    }

}