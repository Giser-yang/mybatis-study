package cn.giseryung.mybatisstudy.mapper;

import cn.giseryung.mybatisstudy.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    int insert( User user);
}
