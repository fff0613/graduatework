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
 * @date 2021-04-28 10:53:21
 */
@Data
@TableName("mission_template")
public class MissionTemplateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer itemid;
	/**
	 * 
	 */
	private String name;
	private Integer tempid;
	private boolean iscomplete;
	private float number;

	public boolean getIscomplete() {
		return this.iscomplete ;
	}
}
