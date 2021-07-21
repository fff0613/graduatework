package io.renren.modules.device.controller;

import io.renren.common.utils.R;
import io.renren.common.utils.Result;
import io.renren.modules.device.entity.MaintainTempEntity;
import io.renren.modules.device.entity.MissionTemplateEntity;
import io.renren.modules.device.entity.MissionitemEntity;
import io.renren.modules.device.service.MissionTemplateService;
import io.renren.modules.device.service.MissionitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missiontemp")
public class MissionTemplateController {
    @Autowired
    MissionTemplateService missionTemplateService;
    @Autowired
    private MissionitemService missionitemService;

    @GetMapping("/ifo/{tempid}")
    public Result getTempById(@PathVariable("tempid")Integer tempid){
        Result<List<MissionitemEntity>> result = new Result<>();
        List<MissionitemEntity> maintainTempEntities = missionTemplateService.queryTempByIdTwo(tempid);
        return result.ok(maintainTempEntities);
    }

    @GetMapping("/ifo/device/{deviceid}/{orderid}")
    public Result queryByDevice(@PathVariable("deviceid") Integer deviceid,@PathVariable("orderid") Integer orderid){
        Result<List<MaintainTempEntity>> result = new Result<>();
        System.out.println(deviceid +" " + orderid);
        List<MaintainTempEntity> missionitemEntities = missionitemService.queryByDevice(deviceid,orderid);
        return result.ok(missionitemEntities);
    }
    @PostMapping("/updatelist")
    public R updateItemList(@RequestBody MaintainTempEntity[] item){
        missionitemService.updateList(item);
        return R.ok();
    }

}
