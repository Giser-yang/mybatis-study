package cn.giseryung.mybatisstudy;

import cn.giseryung.mybatisstudy.entity.po.PeripheralPoint;
import cn.giseryung.mybatisstudy.mapper.PeripheralPointMapper;
import cn.giseryung.mybatisstudy.service.PeripheralPointService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PeripheralPointTest {
    @Autowired
    private PeripheralPointMapper peripheralPointMapper;
    @Test
    public void testToGeoJson(){
        List<PeripheralPoint> peripheralPoints =  peripheralPointMapper.getGeoJsonList();
        peripheralPoints.forEach(peripheralPoint->{
            System.out.println(peripheralPoint);
        });
//        System.out.println(peripheralPoints);
    }
}
