package cn.giseryung.mybatisstudy.service.impl;

import cn.giseryung.mybatisstudy.entity.po.PeripheralPoint;
import cn.giseryung.mybatisstudy.mapper.PeripheralPointMapper;
import cn.giseryung.mybatisstudy.service.PeripheralPointService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PeripheralPointServiceImpl extends ServiceImpl<PeripheralPointMapper, PeripheralPoint> implements PeripheralPointService {
}
