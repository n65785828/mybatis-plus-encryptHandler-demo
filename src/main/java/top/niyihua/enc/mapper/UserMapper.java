package top.niyihua.enc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import top.niyihua.enc.entity.User;
import top.niyihua.enc.secret.AESEncryptTypeHandler;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    @Insert("insert into user(id,name,mobile) values (#{user.id},#{user.name},#{user.mobile,jdbcType=VARCHAR,typeHandler=top.niyihua.enc.secret.AESEncryptTypeHandler})")
    int insertUser(@Param("user")User user);


    @Insert("<script>insert into user (id,name,mobile) " +
            "values " +
            "<foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\" >(#{item.id},#{item.name},#{item.mobile,jdbcType=VARCHAR,typeHandler=top.niyihua.enc.secret.AESEncryptTypeHandler})" +
            "</foreach></script>")
    int insertUser4(@Param("list") List<User> users);

    @Select("select * from user where mobile = #{mobile,jdbcType=VARCHAR,typeHandler=top.niyihua.enc.secret.AESEncryptTypeHandler}")
    @Results(id="userMap",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "mobile",property = "mobile",typeHandler = AESEncryptTypeHandler.class)
    })
    User findByMobileDecrypt(String mobile);

    @Select("select * from user where mobile = #{mobile,jdbcType=VARCHAR,typeHandler=top.niyihua.enc.secret.AESEncryptTypeHandler}")
    User findByMobile(String mobile);

    @Select("select id,name,mobile from user where name like '%${name}%'")
    @ResultMap("userMap")
    User findUserByNameLike(@Param("name") String name);



//    @Insert("insert into user(id,name,mobile) values (#{user.id},#{user.name},HEX((AES_ENCRYPT('${user.mobile}', 'b@BRATdBcHOt1&b0'))))")
//    @Insert("<script>insert into user(id,name,mobile) " +
////            "values " +
////            "<foreach collection=\"users\" item=\"user\" index=\"index\" separator=\",\" >(#{user.id},#{user.name},HEX((AES_ENCRYPT('${user.mobile}','b@BRATdBcHOt1&b0'))))" +
////            "</foreach></script>")
    @Insert("<script>insert into user (id,name,mobile) " +
            "values " +
            "<foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\" >(#{item.id},#{item.name},HEX((AES_ENCRYPT('${item.mobile}','b@BRATdBcHOt1&amp;b0'))))" +
            "</foreach></script>")
    int insertUser2(@Param("list") List<User> users);


    @Insert("<script>insert into user (id,name,mobile) " +
            "values " +
            "<foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\" >(#{item.id},#{item.name},#{item.mobile})" +
            "</foreach></script>")
    int insertUser3(@Param("list") List<User> users);
}
