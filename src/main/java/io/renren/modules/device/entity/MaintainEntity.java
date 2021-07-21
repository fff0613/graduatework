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
 * @date 2021-04-17 10:45:15
 */
@Data
@TableName("maintain")
public class MaintainEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer workorderid;
	/**
	 * 
	 */
	private Integer deviceid;
	/**
	 * 
	 */
	private Date reporthappentime;
	/**
	 * 
	 */
	private String faultreason;
	/**
	 * 
	 */
	private String runtimestate;
	/**
	 * 
	 */
	private String desrc;
	/**
	 * 
	 */
	private Integer urgency;
	/**
	 * 
	 */
//	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date limittime;
	/**
	 * 
	 */
	private Long executorid;//shenqing
	/**
	 * 
	 */
	private Long reporterid;//zhixing
	/**
	 * 
	 */
	private String faultdescr;
	/**
	 * 
	 */
	private String faulttype;
	/**
	 * 
	 */
	private String maintaintype;
	/**
	 * 
	 */
	private String beforedescr;
	/**
	 * 
	 */
	private String afterdescr;
	/**
	 * 
	 */
	private String preventmeasure;
	/**
	 * 
	 */
	private Date distributiontime;
	/**
	 * 
	 */
	private Date executehappentime;
	/**
	 * 
	 */
	private Date completetime;
	/**
	 * 
	 */
	private String checkadice;
	/**
	 * 
	 */
	private String state;
	/**
	 * 
	 */
	private Integer timelimit;
	/**
	 * 
	 */
	private String unit;
	/**
	 * 
	 */
	private Integer arrivallimit;

	private String ordertype;
	private String theme;
	private Long distributeid;
	private Long completeid;
}
