package cn.giseryung.mybatisstudy.service.impl;

import cn.giseryung.mybatisstudy.mapper.UserMapper;
import cn.giseryung.mybatisstudy.pojo.User;
import cn.giseryung.mybatisstudy.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Autowired(required = false)
//    @Resource
    private UserMapper userMapper;
    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    @Override
    public List<User> getUserByIds(List<Long> ids) {
        List<User> userList = userMapper.queryUserByIds(ids);
        return userList;
    }

    @Override
    public void addTime(Integer seconds) {
        List<Integer> ids = List.of(1,2,3);
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>().in(User::getId,ids);
        System.out.println(seconds);
        userMapper.addTime(wrapper,seconds);
    }
}
