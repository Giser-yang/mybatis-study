package cn.giseryung.mybatisstudy.service.impl;

import cn.giseryung.mybatisstudy.entity.dto.UserDTO;
import cn.giseryung.mybatisstudy.entity.po.Address;
import cn.giseryung.mybatisstudy.entity.po.User;
import cn.giseryung.mybatisstudy.entity.vo.AddressVO;
import cn.giseryung.mybatisstudy.entity.vo.UserVO;
import cn.giseryung.mybatisstudy.mapper.UserMapper;
import cn.giseryung.mybatisstudy.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.google.common.reflect.TypeToken;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
//@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public void deductMoneyById(Long id, Integer money) {
        //查询用户
        User user = getById(id);
        //校验用户状态
        if (user == null || user.getStatus() == 2) {
            throw new RuntimeException("用户状态异常！");
        }
        //检验余额是否充足
        if (user.getBalance() < money) {
            throw new RuntimeException("用户余额不足！");
        }
        //扣减余额
//        userMapper.deductMoneyById(id,money);
        int remainBalance = user.getBalance() - money;
        lambdaUpdate()
                .set(User::getBalance, remainBalance)
                .set(remainBalance == 0, User::getStatus, 2)
                .eq(User::getId, id)
                //乐观锁
                .eq(User::getBalance, user.getBalance())
                .update();
    }

    @Override
    public List<User> queryUsers(String name, Integer status, Integer minBalance, Integer maxBalance) {
        return lambdaQuery().like(name != null, User::getUsername, name)
                .eq(status != null, User::getStatus, status)
                .ge(minBalance != null, User::getBalance, minBalance)
                .le(maxBalance != null, User::getBalance, maxBalance)
                .list();
    }

    @Override
    public UserVO queryUserAndAddressById(Long id) {
        //1 查询用户
        User user = getById(id);
        if (user == null || user.getStatus() == 2) {
            throw new RuntimeException("用户状态异常");
        }
        // 2 查询地址
        List<Address> addressList = Db.lambdaQuery(Address.class).eq(Address::getUserId, id).list();
        //3 封装vo
        UserVO userVO = modelMapper.map(user, UserVO.class);
        //4 转地址vo
        if (!addressList.isEmpty()) {
            Type typeList = new org.modelmapper.TypeToken<List<AddressVO>>() {
            }.getType();
            userVO.setAddresses(modelMapper.map(addressList, typeList));
        }
        return userVO;
    }
}
