package io.renren.modules.device.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MaintainPro implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer projectid;
    /**
     *
     */
    private String projectname;
    /**
     *
     */
    private String projectloc;
    /**
     *
     */
    private String projecttype;
    /**
     *
     */
    private Date starttime;
    /**
     *
     */
    private Date endtime;
    /**
     *
     */
    private String state;
    /**
     *
     */
    private Integer estimate;
    /**
     *
     */
    private String isdelivery;
    /**
     *
     */
    private String con;
    /**
     *
     */
    private String contype;
    /**
     *
     */
    private String conproject;
    /**
     *
     */
    private String unit;
    /**
     *
     */
    private Integer cycle;
    private Integer[] template;
    private Integer[] deviceid;
}
