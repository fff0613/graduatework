package io.renren.modules.device.entity;

import lombok.Data;

import java.util.Date;

@Data
public class HistoryEntity {
    private Date starttime;
    private Date endtime;
    private Integer[] amount;
    private DeliveryEntity[] device;
    private Integer total;
}
