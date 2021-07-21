package io.renren.modules.device.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;
@Data
public class DeviceIfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer deviceid;
    /**
     *
     */
    private String devicename;
    /**
     *
     */
    private String devicetype;
    /**
     *
     */

    private String manufacture;
    /**
     *
     */
    private String devicestate;
    /**
     *
     */
    private Date storagedate;
    /**
     *
     */
    private String stockdetailloc;
    /**
     *
     */
    private String stockcontainer;
    /**
     *
     */
    private String stockroom;
    /**
     *
     */
    private String stockname;
    /**
     *
     */
    private String stockid;

}
