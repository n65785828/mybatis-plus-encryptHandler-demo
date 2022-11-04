package top.niyihua.enc;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.enums.SqlKeyword;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.niyihua.enc.entity.User;
import top.niyihua.enc.mapper.UserMapper;
import top.niyihua.enc.pc.MyLambdaQueryWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@SpringBootTest
class EncApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        User user = new User();
        user.setId("222112");
        user.setName("wangwu");
        user.setMobile("18914087917");
        int i = userMapper.insertUser(user);
        System.out.println(i);
    }

    @Test
    void tz(){
        User userByMobile1 = userMapper.findByMobileDecrypt("18914087917");
        System.out.println(userByMobile1);
    }

    @Test
    void test2(){
        MyLambdaQueryWrapper<User> userMyLambdaQueryWrapper = new MyLambdaQueryWrapper<>();
        userMyLambdaQueryWrapper.addCondition(true,User::getMobile , SqlKeyword.EQ, "18914087917", "typeHandler=top.niyihua.enc.secret.AESEncryptTypeHandler");
        userMyLambdaQueryWrapper.addCondition(true, User::getName, SqlKeyword.LIKE, "wangw%", null);
        List<User> users = userMapper.selectList(userMyLambdaQueryWrapper);
        System.out.println();

        users.forEach(System.out::println);
    }

    @Test
    void test3(){
        LambdaUpdateWrapper<User> userLambdaUpdateWrapper = Wrappers.<User>lambdaUpdate();
        userLambdaUpdateWrapper.set(true,User::getMobile,"17777658","typeHandler=top.niyihua.enc.secret.AESEncryptTypeHandler");
    }



    @Test
    void  test5(){
        int sum = 0;
        for(int i =250;i<300;i++){
            long time = System.currentTimeMillis();
            List<User> userList = new ArrayList<>();
            for (int j = 0; j < 1000; j++) {
                User u = new User();
                u.setId(i+"-"+j);
                u.setName(i+""+j);
                u.setMobile(i+""+j);
                userList.add(u);
            }
            userMapper.insertUser4(userList);
            long tt = System.currentTimeMillis()-time;
            sum+=tt;
            System.err.println(tt);
        }
        System.out.println(sum/50);

    }

    @Test
    public void test44(){
        Function<CS,CS> function = CS::getCs;
        function.apply(new CS());
        System.out.println(function);
    }


    public static class CS {
        public CS getCs() {
            return new CS();
        }

    }





}
