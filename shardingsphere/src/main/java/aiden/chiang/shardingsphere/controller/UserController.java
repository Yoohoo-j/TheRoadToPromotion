package aiden.chiang.shardingsphere.controller;

import aiden.chiang.shardingsphere.entity.User;
import aiden.chiang.shardingsphere.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: TheRoadToPromotion
 * @description:
 * @author: Mr.Jiang
 * @create: 2022-04-13 23:18
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/select")
    public List<User> select() {
        return userService.getUserList();
    }

    @GetMapping("/insert")
    public Boolean insert(@RequestParam(name = "name", required = false) String name,
                          @RequestParam(name = "age", required = false) int age) {
        User user = new User();
        user.setAge(age);
        user.setName(name);
        return userService.save(user);
    }

}
