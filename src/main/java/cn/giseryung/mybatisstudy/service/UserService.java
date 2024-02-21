package cn.giseryung.mybatisstudy.service;

import cn.giseryung.mybatisstudy.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserService extends IService<User> {
    void add(User user);

    List<User> getUserByIds(List<Long> ids);

    void addTime(Integer seconds);
}
