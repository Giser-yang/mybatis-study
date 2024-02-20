package cn.giseryung.mybatisstudy.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("user")
public class User {
    @TableId
    private Integer id;
    @NotEmpty
    @Pattern(regexp = "^\\S{1,125}$")
    private String name;
    private String remark;
    private LocalDateTime createTime;
}
