package cn.giseryung.mybatisstudy;

import cn.giseryung.mybatisstudy.entity.po.User;
import cn.giseryung.mybatisstudy.entity.po.UserInfo;
import cn.giseryung.mybatisstudy.mapper.UserMapper;
import cn.giseryung.mybatisstudy.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = MybatisStudyApplication.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
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

    @Test
    void testPageQuery(){
//        int pageNum =3, pageSize = 3;
//        //分页条件
//        Page<User> page = Page.of(pageNum,pageSize);
//        // 排序条件
//        page.addOrder(OrderItem.ascs("balance","id"));
//        QueryWrapper<User> wrapper = new QueryWrapper<User>().ge("balance",100);
//        //2 分页查询
//        Page<User> p = userService.page(page);
//
//        //3 解析
//        Long total = p.getTotal();
//        System.out.println(total);
//        Long pages = p.getPages();
//        System.out.println(pages);
//
//        List<User> userList = p.getRecords();
//        System.out.println(userList);
        int pageNo = 1, pageSize = 2;
        // 1.准备分页条件
        // 1.1.分页条件
        PageHelper.startPage(pageNo,pageSize);
        PageHelper.orderBy("id desc");
        QueryWrapper<User> wrapper = new QueryWrapper<User>().ge("balance",100);
        PageInfo<User> pageInfo = new PageInfo<>(userService.list(wrapper));

        // 3.解析
        long total = pageInfo.getTotal();
        System.out.println("total = " + total);
        long pages = pageInfo.getPages();
        System.out.println("pages = " + pages);
        List<User> users = pageInfo.getList();
        users.forEach(System.out::println);


    }
}
