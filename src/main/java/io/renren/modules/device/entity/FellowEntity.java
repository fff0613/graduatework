package io.renren.modules.device.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class FellowEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer deviceid;
    private Long userid;
    private String username;
    private String role;
    private String mobile;
    private String email;
    private String descr;
}
