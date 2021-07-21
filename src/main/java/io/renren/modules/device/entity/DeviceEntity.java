package io.renren.modules.device.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-08 13:57:16
 */
@Data
@TableName("device")
public class DeviceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
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
	private String devicemodel;
	/**
	 * 
	 */
	private String devicesourse;
	/**
	 * 
	 */
	private String devicestate;
	/**
	 * 
	 */
	private Date buydate;
	/**
	 * 
	 */
	private Float taxrate;
	/**
	 * 
	 */
	private Float beforetax;
	/**
	 * 
	 */
	private Float tax;
	/**
	 * 
	 */
	private String manufacture;
	/**
	 * 
	 */
	private String supporter;
	/**
	 * 
	 */
	private Date storagedate;
	/**
	 * 
	 */
	private Integer storagebatch;
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
	/**
	 * 
	 */
	private Date effectivedate;
	/**
	 * 
	 */
	private Integer amount;
	private Date startdate;

}
