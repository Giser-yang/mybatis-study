package cn.giseryung.mybatisstudy.mapper;

import cn.giseryung.mybatisstudy.entity.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {


    void deductMoneyById(Long id, Integer money);
}
