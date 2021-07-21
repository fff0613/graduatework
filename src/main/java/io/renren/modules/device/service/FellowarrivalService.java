package io.renren.modules.device.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.device.entity.FellowarrivalEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-18 12:49:17
 */
public interface FellowarrivalService extends IService<FellowarrivalEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

