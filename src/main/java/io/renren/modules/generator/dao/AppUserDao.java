package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.AppUserEntityTwo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-22 14:51:43
 */
@Mapper
public interface AppUserDao extends BaseMapper<AppUserEntityTwo> {
	List<AppUserEntityTwo> queryByName(String username);
}
