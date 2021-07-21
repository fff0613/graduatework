package io.renren.modules.device.entity;

import lombok.Data;

@Data
public class MaintainDeviceEntity {
    private Long id;
    private Integer proid;
    private Integer deviceid;
    private boolean iscomplete;
}
