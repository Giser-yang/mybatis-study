package cn.giseryung.mybatisstudy.mapper;

import cn.giseryung.mybatisstudy.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> queryUserByIds(@Param("ids") List<Long> id);

    void addTime(@Param("ew") LambdaQueryWrapper<User> wrapper, @Param("seconds") Integer seconds) ;


}
