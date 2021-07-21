package io.renren.modules.device.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class InventoryEntity implements Serializable {
    private Long orderid;
    private Integer deviceid;
    private boolean dohave;
    private Date complete;
    private Long executorid;
    private String executorname;
}
