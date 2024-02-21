package cn.giseryung.mybatisstudy.controller;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import cn.giseryung.mybatisstudy.pojo.Result;
import cn.giseryung.mybatisstudy.pojo.User;
import cn.giseryung.mybatisstudy.pojodto.UserFormDto;
import cn.giseryung.mybatisstudy.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
//@AllArgsConstructor
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public Result saveUser(@RequestBody UserFormDto userFormDto) {
        //1、把userFormDto拷贝到user
        User user = new User();
        BeanUtils.copyProperties(userFormDto,user);
        System.out.println(user);
        //2、新增
        userService.save(user);
        return Result.success();
    }
}
