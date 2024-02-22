package cn.giseryung.mybatisstudy.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "收货地址VO")
@Data
public class AddressVO {

    @Schema(name = "id",description = "id")
    private Long id;

    @Schema(name = "userId",description = "用户ID")
    private Long userId;

    @Schema(name = "province",description = "省")
    private String province;

    @Schema(name = "city",description = "市")
    private String city;

    @Schema(name = "town",description = "县/区")
    private String town;

    @Schema(name = "mobile",description = "手机")
    private String mobile;

    @Schema(name = "street",description = "详细地址")
    private String street;

    @Schema(name = "contact",description = "联系人")
    private String contact;

    @Schema(name = "isDefault",description = "是否是默认 1默认 0否")
    private Boolean isDefault;

    @Schema(name = "notes",description = "备注")
    private String notes;
}
