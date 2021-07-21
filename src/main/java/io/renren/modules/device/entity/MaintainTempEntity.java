package io.renren.modules.device.entity;

import lombok.Data;

import java.util.Date;

@Data
public class MaintainTempEntity {
    private Integer id;
    private Integer itemid;
    private String name;
    private Integer tempid;
    private boolean iscomplete;
    private String itemdescr;
    private String state;
    private String method;
    private String result;
    private Integer hours;
    private float number;
    private Date exetime;
}
