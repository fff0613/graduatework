package io.renren.modules.device.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.device.entity.MaintainTempEntity;
import io.renren.modules.device.entity.MissionTemplateEntity;
import io.renren.modules.device.entity.MissionitemEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-28 10:53:21
 */
public interface MissionTemplateService extends IService<MissionTemplateEntity> {
    void insertMT(MissionTemplateEntity item);
//    List<MissionitemEntity> queryAll();
    List<MaintainTempEntity> queryTempById(Integer tempid);
    List<MissionitemEntity> queryTempByIdTwo(Integer tempid);
    PageUtils queryPage(Map<String, Object> params);
    void updateMt(MissionTemplateEntity item);
}

