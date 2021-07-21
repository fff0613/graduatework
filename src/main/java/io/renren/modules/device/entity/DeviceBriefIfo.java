package io.renren.modules.device.entity;

import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;

@Data
public class DeviceBriefIfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String state;
}
