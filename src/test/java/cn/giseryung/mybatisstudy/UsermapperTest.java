package cn.giseryung.mybatisstudy;

import cn.giseryung.mybatisstudy.mapper.UserMapper;
import cn.giseryung.mybatisstudy.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = MybatisStudyApplication.class)
@SpringBootTest
public class UsermapperTest {
    @Resource
    UserMapper userMapper;
    @Test
    public void getByID() {
        QueryWrapper<User> wrapper = new QueryWrapper<User>()
                .select("id","name","remark")
                .ge("id",2);
        List<User> userList = userMapper.selectList(wrapper);
        System.out.println(userList);
    }
}
