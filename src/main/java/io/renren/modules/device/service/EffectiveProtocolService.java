package io.renren.modules.device.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.device.entity.EffectiveProtocolEntity;
import io.swagger.models.auth.In;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-08 13:57:16
 */
public interface EffectiveProtocolService extends IService<EffectiveProtocolEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<EffectiveProtocolEntity> queryProList(Integer deviceid);
    void insertPro(EffectiveProtocolEntity item);
    void updatePro(EffectiveProtocolEntity item);
    void deletePro(EffectiveProtocolEntity item);
}

