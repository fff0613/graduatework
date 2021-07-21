package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AppUserEntityThree implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long userId;
    private String username;
    private String mobile;
    private String password;
    private String confirmpassword;
    private Date createTime;
}
