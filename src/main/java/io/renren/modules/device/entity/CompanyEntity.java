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
@TableName("company")
public class CompanyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private String companyid;
	/**
	 * 
	 */
	private String innerid;
	/**
	 * 
	 */
	@TableId
	private String companyname;
	/**
	 * 
	 */
	private String shortname;
	/**
	 * 
	 */
	private String companytype;
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
