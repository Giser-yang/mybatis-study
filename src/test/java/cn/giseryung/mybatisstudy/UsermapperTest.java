package cn.giseryung.mybatisstudy;

import cn.giseryung.mybatisstudy.entity.po.User;
import cn.giseryung.mybatisstudy.entity.po.UserInfo;
import cn.giseryung.mybatisstudy.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = MybatisStudyApplication.class)
@SpringBootTest
public class UsermapperTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    void testInsert() {
        User user = new User();
        // user.setId(5L);
        user.setUsername("ErGouZi");
        user.setPassword("123");
        user.setPhone("18688990013");
        user.setBalance(200);
        user.setInfo(UserInfo.of(24, "英文老师", "female"));
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
    }
}
