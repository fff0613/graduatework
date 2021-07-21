package io.renren.modules.app.entity;

import lombok.Data;

import java.util.Date;

@Data
public class AppUserEntity {
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
    private String salt;
    private String email;
    private boolean status;
    private Long createUserId;
}
