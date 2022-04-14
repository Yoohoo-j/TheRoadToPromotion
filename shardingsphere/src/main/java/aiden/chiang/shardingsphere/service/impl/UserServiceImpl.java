package aiden.chiang.shardingsphere.service.impl;

import aiden.chiang.shardingsphere.dao.mapper.UserMapper;
import aiden.chiang.shardingsphere.entity.User;
import aiden.chiang.shardingsphere.service.UserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: TheRoadToPromotion
 * @description:
 * @author: Mr.Jiang
 * @create: 2022-04-13 23:26
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public boolean save(User entity) {
        return super.save(entity);
    }

    @Override
    public List<User> getUserList() {
        return baseMapper.selectList(Wrappers.<User>lambdaQuery());
    }

}
