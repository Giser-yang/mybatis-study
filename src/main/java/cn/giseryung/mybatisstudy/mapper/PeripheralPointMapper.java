package cn.giseryung.mybatisstudy.mapper;

import cn.giseryung.mybatisstudy.entity.po.PeripheralPoint;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PeripheralPointMapper extends BaseMapper<PeripheralPoint> {
    List<PeripheralPoint>  getGeoJsonList();
}
