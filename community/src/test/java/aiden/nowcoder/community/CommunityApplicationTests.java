package aiden.nowcoder.community;

import aiden.nowcoder.community.dao.DiscussPostMapper;
import aiden.nowcoder.community.dao.LoginTicketMapper;
import aiden.nowcoder.community.dao.UserMapper;
import aiden.nowcoder.community.entity.DiscussPost;
import aiden.nowcoder.community.entity.LoginTicket;
import aiden.nowcoder.community.entity.User;
import aiden.nowcoder.community.util.CommunityUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.security.krb5.internal.Ticket;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunityApplicationTests {

    @Autowired
    DiscussPostMapper discussPostMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    LoginTicketMapper loginTicketMapper;

    @Test
    public void testSelectPosts(){ //
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(101, 0, 10);
        discussPosts.forEach(System.out::println);
    }

    @Test
    public void testSelectById(){
        User user = userMapper.selectById(101);
        System.out.println(user);

    }

    @Test
    public void testInsertLoginTicket(){
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(101);
        loginTicket.setTicket("abc");
        loginTicket.setStatus(0);
        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000 * 60 * 10));
        loginTicketMapper.insertLoginTicket(loginTicket);
    }

    @Test
    public void testSelectLoginTicket(){
        LoginTicket loginTicket = loginTicketMapper.selectByTicket("abc");
        System.out.println(loginTicket);
        loginTicketMapper.updateStatus(1, "abc");
        loginTicket = loginTicketMapper.selectByTicket("abc");
        System.out.println(loginTicket);
    }

    @Test
    public void testMd5(){
        String s = CommunityUtil.md5("123456" + "9441e");
        System.out.println(s);
    }



}
