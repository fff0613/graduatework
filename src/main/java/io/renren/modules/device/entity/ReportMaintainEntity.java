package io.renren.modules.device.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ReportMaintainEntity {
    private Integer deviceid;
    /**
     *
     */
    private Date reporthappentime;
    /**
     *
     */
    private String faultreason;
    /**
     *
     */
    private String runtimestate;
    /**
     *
     */
    private String desrc;
    /**
     *
     */
    private Integer urgency;
    /**
     *
     */
    private Date limittime;
    /**
     *
     */
    private Long executorid;
    /**
     *
     */
    private Long reporterid;
    private String theme;
    private String state;
    private String maintaintype;
    private String ordertype;
}
