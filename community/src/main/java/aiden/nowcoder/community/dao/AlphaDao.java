package aiden.nowcoder.community.dao;

import aiden.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AlphaDao {

    @Select(value = "select * " +
            "        from discuss_post\n" +
            "        where status != 2\n" +
            "        order by type desc, create_time desc\n" +
            "        limit #{offset}, #{limit}")
    List<DiscussPost> selectDiscussPosts(@Param("offset") int offset, @Param("limit") int limit);
}
