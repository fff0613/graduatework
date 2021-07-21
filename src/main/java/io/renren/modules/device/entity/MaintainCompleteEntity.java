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
 * @date 2021-05-09 21:24:29
 */
@Data
@TableName("maintain_complete")
public class MaintainCompleteEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Integer tempid;
	/**
	 * 
	 */
	private Integer itemid;
	/**
	 * 
	 */
	private Date executetime;
	/**
	 * 
	 */
	private boolean iscomplete;
	/**
	 * 
	 */
	private Float number;

}
