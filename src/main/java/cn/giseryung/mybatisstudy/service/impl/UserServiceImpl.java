package cn.giseryung.mybatisstudy.service.impl;

import cn.giseryung.mybatisstudy.mapper.UserMapper;
import cn.giseryung.mybatisstudy.pojo.User;
import cn.giseryung.mybatisstudy.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
//    @Resource
    private UserMapper userMapper;
    @Override
    public void add(User user) {
        userMapper.insert(user);
    }
}
