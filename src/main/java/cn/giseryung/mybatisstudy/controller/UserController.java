package cn.giseryung.mybatisstudy.controller;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import cn.giseryung.mybatisstudy.pojo.Result;
import cn.giseryung.mybatisstudy.pojo.User;
import cn.giseryung.mybatisstudy.pojodto.UserFormDto;
import cn.giseryung.mybatisstudy.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "用户管理")
@RestController
@RequestMapping("/user")
//@AllArgsConstructor
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(summary = "新增用户")
    @PostMapping
    public Result saveUser(@RequestBody UserFormDto userFormDto) {
        //1、把userFormDto拷贝到user
        System.out.println(userFormDto);
        User user = new User();
        BeanUtils.copyProperties(userFormDto,user);
        System.out.println(user);
        //2、新增
        userService.save(user);
        return Result.success();
    }
    @DeleteMapping("/{id}")
    public Result deleteUserById(@PathVariable("id") Integer id){
        userService.removeById(id);
        return Result.success();
    }
//
//    @GetMapping
//    public Result<List<User>>
//    @PutMapping
//    public Result updateUser(@RequestBody UserFormDto userFormDto){
//
////        userService.updateById()
//    }
}
