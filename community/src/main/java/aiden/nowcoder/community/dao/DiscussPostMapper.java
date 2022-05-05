package aiden.nowcoder.community.dao;

import aiden.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    @Select(value = "select * " +
            "        from discuss_post\n" +
            "        where status != 2\n" +
            "        and user_id = #{userId}\n" +
            "        order by type desc, create_time desc\n" +
            "        limit #{offset}, #{limit}")
    List<DiscussPost> selectDiscussPosts(@Param("userId") int userId, @Param("offset") int offset, @Param("limit") int limit);

    @Select(value = "select * " +
            "        from discuss_post\n" +
            "        where status != 2\n" +
//            "        and user_id = #{userId}\n" +
            "        order by type desc, create_time desc\n" +
            "        limit #{offset}, #{limit}")
    List<DiscussPost> selectAllDiscussPosts(@Param("offset") int offset, @Param("limit") int limit);


    @Select(value = "select count(id)\n" +
            "        from discuss_post\n" +
            "        where status != 2\n" +
            "        and user_id = #{userId}\n")
    int selectDiscussPostRows(@Param("userId") int userId);

    int insertDiscussPost(DiscussPost discussPost);

    DiscussPost selectDiscussPostById(int id);
}
