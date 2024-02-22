package cn.giseryung.mybatisstudy.entity.vo;

import cn.giseryung.mybatisstudy.entity.po.UserInfo;
import cn.giseryung.mybatisstudy.enums.UserStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
@Schema(description = "用户VO实体")
@Data
public class UserVO {
    @Schema(name = "id",description = "用户id",type = "long")
    private Long id;

    @Schema(name = "username",description = "用户名",type = "string")
    private String username;

    @Schema(name = "info",description = "详细信息",type ="string" )
    private UserInfo info;

    @Schema(name = "status",description = "使用状态（1正常 2冻结）")
    private UserStatus status;

    @Schema(name = "balance",description = "账户余额")
    private Integer balance;

    @Schema(name = "addresses",description = "用户的收获地址")
    private List<AddressVO> addresses;
}
