package io.renren.modules.device.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.device.entity.MaintainCompleteEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-09 21:24:29
 */
public interface MaintainCompleteService extends IService<MaintainCompleteEntity> {
    int insert(MaintainCompleteEntity item);
    PageUtils queryPage(Map<String, Object> params);
}

