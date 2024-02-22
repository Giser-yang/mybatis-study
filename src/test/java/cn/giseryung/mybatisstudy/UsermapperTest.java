//package cn.giseryung.mybatisstudy;
//
//import cn.giseryung.mybatisstudy.mapper.UserMapper;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import jakarta.annotation.Resource;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
////@RunWith(SpringRunner.class)
////@SpringBootTest(classes = MybatisStudyApplication.class)
//@SpringBootTest
//public class UsermapperTest {
//    @Resource
//    UserMapper userMapper;
//    @Test
//    public void getByID() {
//        QueryWrapper<User> wrapper = new QueryWrapper<User>()
//                .select("id","name","remark")
//                .ge("id",2);
//        List<User> userList = userMapper.selectList(wrapper);
//        System.out.println(userList);
//    }
//}
