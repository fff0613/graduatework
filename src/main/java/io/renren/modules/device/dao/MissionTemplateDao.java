package io.renren.modules.device.dao;

import io.renren.modules.device.entity.MaintainTempEntity;
import io.renren.modules.device.entity.MissionTemplateEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-28 10:53:21
 */
@Mapper
public interface MissionTemplateDao extends BaseMapper<MissionTemplateEntity> {
    void insertMT(MissionTemplateEntity item);
    List<MissionTemplateEntity> queryTempById(Integer tempid);
    void updateMt(MissionTemplateEntity item);
}
