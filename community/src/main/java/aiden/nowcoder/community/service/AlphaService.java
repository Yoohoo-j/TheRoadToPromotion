package aiden.nowcoder.community.service;

import aiden.nowcoder.community.dao.AlphaDao;
import aiden.nowcoder.community.dao.DiscussPostMapper;
import aiden.nowcoder.community.dao.UserMapper;
import aiden.nowcoder.community.entity.DiscussPost;
import aiden.nowcoder.community.entity.User;
import aiden.nowcoder.community.util.CommunityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;
import java.util.List;

/**
 * @program: TheRoadToPromotion
 * @description:
 * @author: Mr.Jiang
 * @create: 2022-05-06 13:06
 **/
@Service
public class AlphaService {

    @Autowired
    private AlphaDao alphaDao;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private TransactionTemplate transactionTemplate;

    public AlphaService(){
        System.out.println("实例化AlphaService");
    }

    @PostConstruct
    public void init(){
        System.out.println("初始化AlphaService");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁AlphaService");
    }

    public List<DiscussPost> find(){return alphaDao.selectDiscussPosts(0, 10);}

//    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
//    public Object transactionDemo(){
//        User user = new User();
//        user.setUsername("alpha");
//        user.setSalt(CommunityUtil.generateUUID().substring(0,5));
//        user.setPassword(CommunityUtil.md5("123" + user.getSalt()));
//        user.setEmail("alpha@qq.com");
//        user.setHeaderUrl("http://image.nowcoder.com/head/99t.png");
//        user.setCreateTime(new Date());
//        userMapper.insertUser(user);
//
//        DiscussPost discussPost = new DiscussPost();
//        discussPost.setUserId(user.getId());
//        discussPost.setTitle("hell0");
//        discussPost.setContent("新人报道");
//        discussPost.setCreateTime(new Date());
//        discussPostMapper.insertDiscussPost(discussPost);
//
////        throw new RuntimeException("sdf");
//        return "123";
//
//    }

    public Object transactionDemo2(){
        transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        return transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                // TODO
                return null;
            }
        });
    }

}
