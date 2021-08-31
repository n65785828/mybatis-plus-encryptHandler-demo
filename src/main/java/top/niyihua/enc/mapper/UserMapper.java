package top.niyihua.enc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import top.niyihua.enc.entity.User;
import top.niyihua.enc.secret.AESEncryptTypeHandler;

public interface UserMapper extends BaseMapper<User> {
    @Insert("insert into user(id,name,mobile) values (#{user.id},#{user.name},#{user.mobile,jdbcType=VARCHAR,typeHandler=top.niyihua.enc.secret.AESEncryptTypeHandler})")
    int insertUser(@Param("user")User user);

    @Select("select id,name,mobile from user where mobile = #{mobile,jdbcType=VARCHAR,typeHandler=top.niyihua.enc.secret.AESEncryptTypeHandler}")
    @Results(id="userMap",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "mobile",property = "mobile",typeHandler = AESEncryptTypeHandler.class)
    })
    User findUserByMobile(String mobile);

    @Select("select id,name,mobile from user where name like '%${name}%'")
    @ResultMap("userMap")
    User findUserByNameLike(@Param("name") String name);
}
