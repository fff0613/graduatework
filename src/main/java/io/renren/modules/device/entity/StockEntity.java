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
 * @date 2021-04-08 13:57:16
 */
@Data
@TableName("stock")
public class StockEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
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
	/**
	 * 
	 */
	private String orgname;
	/**
	 * 
	 */
	private String companyname;
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
	private String executor;
	private Long executorid;
}
