package cn.giseryung.mybatisstudy.controller;

import cn.giseryung.mybatisstudy.entity.dto.PageDTO;
import cn.giseryung.mybatisstudy.entity.dto.UserDTO;
import cn.giseryung.mybatisstudy.entity.po.User;
import cn.giseryung.mybatisstudy.entity.po.UserInfo;
import cn.giseryung.mybatisstudy.entity.query.PageQuery;
import cn.giseryung.mybatisstudy.entity.query.UserQuery;
import cn.giseryung.mybatisstudy.entity.vo.UserVO;
import cn.giseryung.mybatisstudy.pojo.Result;
import cn.giseryung.mybatisstudy.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@Tag(name = "用户", description = "用户管理")
@RestController
@RequestMapping("/user")
//@AllArgsConstructor
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    ModelMapper modelMapper = new ModelMapper();

    @PostMapping("register")
    @Operation(summary = "用户注册")
    public Result register(@RequestBody UserDTO userDTO) {
        //1 把dto拷贝到po
        //验证用户名是否存在 待完成！！！
        User user = modelMapper.map(userDTO, User.class);
        //2 新增
        userService.save(user);
        return Result.success(Map.of("userId", user.getId()));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "用户删除")
    public Result delete(@PathVariable("id") Long id) {
        userService.removeById(id);
        return Result.success();
    }

    //    @GetMapping("/{id}")
//    @Operation(summary = "用户查询")
//    public Result<UserDTO> search(@PathVariable("id") Long id){
//        User user =  userService.getById(id);
//        UserDTO userDTO = modelMapper.map(user,UserDTO.class);
//        return Result.success(userDTO);
//    }
    @GetMapping("/{id}")
    @Operation(summary = "用户查询")
    public Result<UserVO> search(@PathVariable("id") Long id) {
        UserVO UserVO = userService.queryUserAndAddressById(id);
        return Result.success(UserVO);
    }

    @GetMapping()
    @Operation(summary = "用户批量查询")
    @Parameter(name = "ids", description = "用户id集合", example = "1,2,3")
    public Result<List<UserVO>> search(@RequestParam("ids") List<Long> ids) {
        List<User> userList = userService.listByIds(ids);
        Type listType = new TypeToken<List<UserVO>>() {
        }.getType();
        List<UserVO> userVOList = modelMapper.map(userList, listType);
        return Result.success(userVOList);
    }

    @PutMapping("/{id}/deduction/{money}")
    @Operation(summary = "根据用户id扣减余额")
    public Result<UserVO> deductMoneyById(@PathVariable("id") Long id, @PathVariable("money") Integer money) {
        userService.deductMoneyById(id, money);
        User user = userService.getById(id);
        UserVO userVO = modelMapper.map(user, UserVO.class);
        return Result.success(userVO);
    }

    @GetMapping("/list")
    @Operation(summary = "用户筛选")
    public Result<PageDTO<UserVO>> list(@ParameterObject UserQuery userQuery) {
        // 分页及排序条件初始化
        userQuery.toMapPage();
        List<User> userList = userService.queryUsers(userQuery.getName(), userQuery.getStatus(),
                userQuery.getMinBalance(), userQuery.getMaxBalance());
        // 分页
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        // po 转 vo
        Type listType = new TypeToken<List<UserVO>>() {}.getType();
        List<UserVO> userVOList = modelMapper.map(pageInfo.getList(), listType);
        // 封装PageDTO
        PageDTO<UserVO> pageDTO = new PageDTO<>();
        pageDTO.setPages(pageInfo.getPages());
        pageDTO.setTotal(pageInfo.getTotal());
        pageDTO.setList(userVOList);
        return Result.success(pageDTO);
    }

}
