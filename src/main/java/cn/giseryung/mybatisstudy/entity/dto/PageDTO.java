package cn.giseryung.mybatisstudy.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "分页查询结果")
public class PageDTO<T> {
    @Schema(name = "total",description = "总条数")
    private Long total;
    @Schema(name = "pages",description = "总页数")
    private Integer pages;
    @Schema(name = "list",description = "集合")
    private List<T> list;
}
