package aiden.chiang.shardingsphere.dao.mapper;

import aiden.chiang.shardingsphere.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserMapper extends BaseMapper<User>{
    public List<User> findAllUser();
}
