package aiden.chiang.shardingsphere.service;

import aiden.chiang.shardingsphere.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @program: TheRoadToPromotion
 * @description:
 * @author: Mr.Jiang
 * @create: 2022-04-13 23:26
 **/
public interface UserService extends IService<User> {

    /**
     * 保存用户信息
     * @param entity
     * @return
     */
    @Override
    boolean save(User entity);

    /**
     * 查询全部用户信息
     * @return
     */
    List<User> getUserList();
}