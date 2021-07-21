package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-05-22 14:51:43
 */
@Data
@TableName("tb_user")
public class AppUserEntityTwo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long userId;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 创建时间
	 */
	private Date createTime;

}
