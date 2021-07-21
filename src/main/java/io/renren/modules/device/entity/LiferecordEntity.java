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
 * @date 2021-04-09 12:43:22
 */
@Data
@TableName("liferecord")
public class LiferecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long recordid;
	/**
	 * 
	 */
	private String recordtype;
	/**
	 * 
	 */
	private String organizationname;
	/**
	 * 
	 */
	private Integer deviceid;
	/**
	 * 
	 */
	private Date happentime;
	/**
	 * 
	 */
	private String storagetype;
	/**
	 * 
	 */
	private Integer storagebatch;
	/**
	 * 
	 */
	private String originorganizationname;
	/**
	 * 
	 */
	private Integer deliverybatch;
	/**
	 * 
	 */
	private Date lenttime;
	/**
	 * 
	 */
	private Date givebacktime;
	/**
	 * 
	 */
	private Integer lentuserid;
	/**
	 * 
	 */
	private Integer givebackuserid;
	/**
	 * 
	 */
	private String lentstate;
	/**
	 * 
	 */
	private String givebackstate;
	/**
	 * 
	 */
	private Date allocationtime;
	/**
	 * 
	 */
	private Date tuneintime;
	/**
	 * 
	 */
	private String tuneincompanyname;
	/**
	 * 
	 */
	private String tuneindepartment;
	/**
	 * 
	 */
	private Float residualvaule;
	/**
	 * 
	 */
	private Float moneysum;
	/**
	 * 
	 */
	private String returncompanyname;
	/**
	 * 
	 */
	private String oldstockcontainer;
	/**
	 * 
	 */
	private String oldstockroom;
	/**
	 * 
	 */
	private String oldstockname;
	/**
	 * 
	 */
	private String oldcompanyname;
	/**
	 * 
	 */
	private String oldorgname;
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
	private String companyname;
	/**
	 * 
	 */
	private String orgname;
	/**
	 * 
	 */
	private Long reporterid;
	/**
	 * 
	 */
	private Long executorid;
	/**
	 * 
	 */
	private Long responsibleuserid;
	/**
	 * 
	 */
	private Long allocationuserid;
	/**
	 * 
	 */
	private Long tuneinuserid;
	/**
	 * 
	 */
	private Long checkuserid;
	/**
	 * 
	 */
	private String reason;
	/**
	 * 
	 */
	private Integer amount;
	/**
	 * 
	 */
	private String state;
	/**
	 * 
	 */
	private String descr;
	/**
	 * 
	 */
	private String afterdescr;

	private String reportername;
	private String executorname;
	private String devicename;

}
