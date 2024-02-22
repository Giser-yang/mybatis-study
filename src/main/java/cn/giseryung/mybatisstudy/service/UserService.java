package cn.giseryung.mybatisstudy.service;

import cn.giseryung.mybatisstudy.entity.po.User;
import cn.giseryung.mybatisstudy.entity.vo.UserVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserService extends IService<User> {

    void deductMoneyById(Long id, Integer money);

    List<User> queryUsers(String name, Integer status, Integer minBalance, Integer maxBalance);

    UserVO queryUserAndAddressById(Long id);
}
