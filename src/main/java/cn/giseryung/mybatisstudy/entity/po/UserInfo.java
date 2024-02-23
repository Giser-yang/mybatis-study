package cn.giseryung.mybatisstudy.entity.po;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class UserInfo {
    @Schema(name = "age",description = "年龄",example = "18")
    private Integer age;
    @Schema(name = "intro",description = "介绍",example = "佛系青年")
    private String intro;
    @Schema(name = "gender",description = "性别",example = "male")
    private String gender;
}