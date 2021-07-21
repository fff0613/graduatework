package io.renren.modules.device.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-18 12:49:17
 */
@Data
@TableName("maintainproject")
public class MaintainprojectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
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
	private Integer isdelivery;
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
	private Integer template;
	private Integer deviceid;
}
