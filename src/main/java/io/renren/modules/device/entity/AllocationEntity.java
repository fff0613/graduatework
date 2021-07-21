package io.renren.modules.device.entity;

import lombok.Data;

import java.util.Date;

@Data
public class AllocationEntity {
    private Long recordid;
    private String stockname;
    private String orgname;
    private Integer amount;
    private String reporter;//name
    private String executor;
    private Date happentime;
    private String state;
}
