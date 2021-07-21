package io.renren.modules.device.entity;

import lombok.Data;

import java.util.Date;

@Data
public class MaintainConRec {
    private String state;
    private String type;
    private String device;
    private String theme;
    private Date start;
    private Date end;
}
