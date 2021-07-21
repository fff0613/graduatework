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
 * @date 2021-04-17 23:33:31
 */
@Data
@TableName("missionitem")
public class MissionitemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer itemid;
	/**
	 * 
	 */
	private String itemname;
	/**
	 * 
	 */
	private String itemdescr;
	/**
	 * 
	 */
	private String state;
	/**
	 * 
	 */
	private String method;
	/**
	 * 
	 */
	private String result;
	/**
	 * 
	 */
	private Integer hours;

}
