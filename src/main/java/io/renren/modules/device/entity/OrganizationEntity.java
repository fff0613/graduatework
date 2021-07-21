package io.renren.modules.device.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-04-08 13:57:16
 */
@Data
@TableName("organization")
public class OrganizationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private String orgid;
	/**
	 * 
	 */
	private String innerid;
	/**
	 * 
	 */
	@TableId
	private String orgname;
	/**
	 * 
	 */
	private String shortname;
	/**
	 * 
	 */
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
	/**
	 * 
	 */
	private String state;

}
