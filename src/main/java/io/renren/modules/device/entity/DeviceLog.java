package io.renren.modules.device.entity;

import lombok.Data;

import java.util.Date;

@Data
public class DeviceLog {
    private Date operationDate;
    private String fellow;
    private String descr;
}
