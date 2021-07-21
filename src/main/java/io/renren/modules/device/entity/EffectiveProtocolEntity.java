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
@TableName("effective_protocol")
public class EffectiveProtocolEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer proid;
	/**
	 * 
	 */
	private Integer deviceid;
	/**
	 * 
	 */
	private String proname;
	/**
	 * 
	 */
	private String protype;
	/**
	 * 
	 */
	private String manufacture;
	/**
	 * 
	 */
	private Date starttime;
	/**
	 * 
	 */
	private Date endtime;

}
