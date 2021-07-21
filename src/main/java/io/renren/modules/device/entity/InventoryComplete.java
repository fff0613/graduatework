package io.renren.modules.device.entity;

import lombok.Data;

import java.util.Date;

@Data
public class InventoryComplete {
    private Long orderid;
    private Integer deviceid;
    private boolean dohave;
    private Date complete;
}
