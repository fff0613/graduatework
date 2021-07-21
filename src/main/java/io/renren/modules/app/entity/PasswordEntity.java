package io.renren.modules.app.entity;

import lombok.Data;

@Data
public class PasswordEntity {
    private Long id;
    private String password;
    private String confirmpassword;
}
