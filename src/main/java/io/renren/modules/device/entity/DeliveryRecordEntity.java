package io.renren.modules.device.entity;

import lombok.Data;

import java.util.Date;

@Data
public class DeliveryRecordEntity {
    private String stockname;
    private Integer stockbatch;
    private String storagetype;
    private Date storagetime;
    private String descr;
    private String originstock;
    private Long reporterid;
    private String devicename;
    private Integer deviceid;
    private String devicetype;
    private String devicemodel;
    private String manufacture;
    private Integer amount;
}
