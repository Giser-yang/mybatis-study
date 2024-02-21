package cn.giseryung.mybatisstudy.pojo;

import com.baomidou.mybatisplus.annotation.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("public.user")
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @NotEmpty
    @Pattern(regexp = "^\\S{1,125}$")
    private String name;
    private String remark;
    private Integer status;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
