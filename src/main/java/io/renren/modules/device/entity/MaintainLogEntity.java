package io.renren.modules.device.entity;

import lombok.Data;

import java.util.Date;

@Data
public class MaintainLogEntity {
    private Integer proId;
    private String proName;
    private String proType;
    private Date reportDate;
    private String executor;
    private String addr;
    private String state;
}
