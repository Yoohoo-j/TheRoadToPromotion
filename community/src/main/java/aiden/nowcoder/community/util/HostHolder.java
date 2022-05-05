package aiden.nowcoder.community.util;

import aiden.nowcoder.community.entity.User;
import org.springframework.stereotype.Component;

/**
 * @program: TheRoadToPromotion
 * @description: 持有用户的信息，代替Session对象
 * @author: Mr.Jiang
 * @create: 2022-04-25 00:28
 **/
@Component
public class HostHolder {

    private ThreadLocal<User> users = new ThreadLocal<>();

    public void setUser(User user){
        users.set(user);
    }

    public User getUser(){
        return users.get();
    }

    public void clear(){
        users.remove();
    }

}
