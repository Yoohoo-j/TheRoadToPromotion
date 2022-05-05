package aiden.nowcoder.community.dao;

import aiden.nowcoder.community.entity.LoginTicket;
import org.apache.ibatis.annotations.*;

/**
 * @program: TheRoadToPromotion
 * @description:
 * @author: Mr.Jiang
 * @create: 2022-04-23 20:55
 **/
@Mapper
public interface LoginTicketMapper {

    @Insert(value = "insert into login_ticket(user_id, ticket, status, expired) " +
                    "values(#{userId}, #{ticket}, #{status}, #{expired})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    int insertLoginTicket(LoginTicket loginTicket);

    @Select({"select id, user_id, ticket, status, expired",
            "from login_ticket where ticket=#{ticket}"})
    LoginTicket selectByTicket(String ticket);

    @Update({"<script>",
    "update login_ticket set status=#{status} where ticket=#{ticket} ",
    "<if test=\"ticket!=null\"> ",
    "</if>",
    "</script>"})
    int updateStatus(@Param("status") int status, @Param("ticket")String ticket);
}
