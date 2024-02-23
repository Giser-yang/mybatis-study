package cn.giseryung.mybatisstudy.service.impl;

import cn.giseryung.mybatisstudy.entity.po.Address;
import cn.giseryung.mybatisstudy.mapper.AddressMapper;
import cn.giseryung.mybatisstudy.service.AddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {
}
