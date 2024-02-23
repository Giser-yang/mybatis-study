package cn.giseryung.mybatisstudy.entity.query;

import com.github.pagehelper.PageHelper;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
@Schema(description = "分页查询实体")
public class PageQuery {
    @Schema(name = "pageNo", description = "页码", example = "1")
    private Integer pageNo = 1;
    @Schema(name = "pageSize", description = "分页大小", example = "10")
    private Integer pageSize = 10;
    @Schema(name = "sortBy", description = "排序", example = "id")
    private String sortBy;
    @Schema(name = "isAsc", description = "是否升序", example = "true")
    private Boolean isAsc = true;

    public void toMapPage() {
        PageHelper.startPage(pageNo, pageSize);
        if (sortBy!=null) {
            if (isAsc) {
                PageHelper.orderBy(sortBy);
            } else {
                PageHelper.orderBy(sortBy + " desc");
            }
        } else {
            PageHelper.orderBy("update_time desc");
        }
    }
}
