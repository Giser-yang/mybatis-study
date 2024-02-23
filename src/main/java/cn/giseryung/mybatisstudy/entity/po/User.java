package cn.giseryung.mybatisstudy.entity.po;

import cn.giseryung.mybatisstudy.enums.UserStatus;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@TableName(value = "public.user",autoResultMap = true)
public class User {
    /**
     * 用户id
     */
     @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    // @TableField("`username`")
    private String username;

    /**
     * 密码
     */
    // @TableField(exist = false)
    private String password;

    /**
     * 注册手机号
     */
    private String phone;

    /**
     * 详细信息
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private UserInfo info;

    /**
     * 使用状态（1正常 2冻结）
     */
    private UserStatus status;

    /**
     * 账户余额
     */
    private Integer balance;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
