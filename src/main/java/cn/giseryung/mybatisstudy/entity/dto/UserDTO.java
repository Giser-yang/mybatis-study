package cn.giseryung.mybatisstudy.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Map;

@Data
@Schema(description = "用户表单实体")
public class UserDTO {
//    @Schema(name = "id")
//    private Long id;

    @Schema(name = "username",description = "用户名",defaultValue = "not null",example = "admin",required = true)
    private String username;

    @Schema(name = "password",description = "密码",defaultValue = "admin")
    private String password;

    @Schema(name = "phone",description = "注册手机号",defaultValue = "17760485080")
    private String phone;

    @Schema(name = "info",description = "详细信息，JSON风格",defaultValue =  "{\"number\":\"1\"}")
    private String info;

    @Schema(name = "balance",description = "账户余额",defaultValue = "400")
    private Integer balance;
}
