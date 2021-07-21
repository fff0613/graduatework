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
@TableName("fellowarrival")
public class FellowarrivalEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long userid;
	/**
	 * 
	 */
	private String username;
	/**
	 * 
	 */
	private Date arrivaltime;
	/**
	 * 
	 */
	private String arrivalloc;
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

}
