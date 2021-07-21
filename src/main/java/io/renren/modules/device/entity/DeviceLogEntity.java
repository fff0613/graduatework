package io.renren.modules.device.entity;

import lombok.Data;


import java.util.Date;

@Data
public class DeviceLogEntity {
    private Date happenDate;
    private String fellow;
    private String descr;
}
