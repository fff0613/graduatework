package io.renren.modules.device.controller;

import io.renren.common.utils.R;
import io.renren.modules.device.entity.HistoryEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/history")
public class HistoryController{
    @PostMapping
    public R getFreq(@RequestBody HistoryEntity historyEntity){

        return R.ok();
    }
}
