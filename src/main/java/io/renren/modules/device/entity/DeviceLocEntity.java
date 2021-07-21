package io.renren.modules.device.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeviceLocEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String stockname;
    /**
     *
     */
    private String stockroom;
    /**
     *
     */
    private String stocktype;
    /**
     *
     */
    private String stockdetailloc;
    /**
     *
     */
    private String stockcontainer;
    private String country;
    /**
     *
     */
    private String province;
    /**
     *
     */
    private String city;
    /**
     *
     */
    private String district;
    /**
     *
     */
    private String street;
    /**
     *
     */
    private Integer streetnumber;

}
