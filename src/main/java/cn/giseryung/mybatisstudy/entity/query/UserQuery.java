package cn.giseryung.mybatisstudy.entity.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "用户查询实体类")
public class UserQuery {
    @Schema(name = "name", description = "用户名关键字", defaultValue = "admin")
    private String name;
    @Schema(name = "status", description = "用户状态 1-正常，2-冻结", defaultValue = "1")
    private Integer status;
    @Schema(name = "minBalance", description = "余额最小值", defaultValue = "10")
    private Integer minBalance;
    @Schema(name = "maxBalance", description = "余额最小值", defaultValue = "10000")
    private Integer maxBalance;


}
