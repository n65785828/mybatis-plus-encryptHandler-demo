package top.niyihua.enc;


import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.niyihua.enc.converter.BgConverter;
import top.niyihua.enc.entity.ExData;
import top.niyihua.enc.entity.ExDataCalculate;
import top.niyihua.enc.entity.User;
import top.niyihua.enc.mapper.UserMapper;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class EncApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        User user = new User();
        user.setId("18911");
        user.setName("lili");
        user.setMobile("18914087917");
        int i = userMapper.insertUser(user);
        System.out.println(i);
    }

    @Test
    void test2(){
        User userById1 = userMapper.findUserByMobile("18914087917");
        userById1.setName("tttt");
        userMapper.updateById(userById1);
        System.out.println(userById1);
    }

    @Test
    void test3(){
        User is = userMapper.findUserByNameLike("is");
        System.out.println(is);
    }


    @Test
    void test4(){
        ExcelReader reader = ExcelUtil.getReader("D://aa.xlsx", 0);
        reader.addHeaderAlias("代码", "code");
        reader.addHeaderAlias("名称", "name");
        reader.addHeaderAlias("涨幅%", "upV");
        reader.addHeaderAlias("涨速%", "upSpeed");
        reader.addHeaderAlias("开盘%", "openP");
        reader.addHeaderAlias("现量", "nowVolume");
        reader.addHeaderAlias("流通市值Z", "liuTongZ");
        reader.addHeaderAlias("总金额", "totalMoney");
        reader.addHeaderAlias("开盘金额", "openMoney");
        reader.addHeaderAlias("封单额", "closeVar");
        reader.addHeaderAlias("流通市值", "flowMarketVaR");
        reader.addHeaderAlias("换手%", "changeHand");
        reader.addHeaderAlias("现价", "nowPrice");
        List<ExData> all = reader.readAll(ExData.class);
        reader.close();
        ExData exData = all.get(0);
        ExDataCalculate convert = BgConverter.convert(exData);
        System.out.println(exData);
        System.err.println(convert);
        ExData revert = BgConverter.revert(convert);
        List<ExData> collect = all.stream().map(BgConverter::convert).map(BgConverter::revert).collect(Collectors.toList());
        ExcelWriter writer = ExcelUtil.getWriter(new File("D://cc.xlsx"));
        writer.addHeaderAlias("code", "代码");
        writer.addHeaderAlias("name", "名称");
        writer.addHeaderAlias("upV", "涨幅%");
        writer.addHeaderAlias("upSpeed", "涨速%");
        writer.addHeaderAlias("openP", "开盘%");
        writer.addHeaderAlias("nowVolume", "现量");
        writer.addHeaderAlias("liuTongZ", "流通市值Z");
        writer.addHeaderAlias("totalMoney", "总金额");
        writer.addHeaderAlias("openMoney", "开盘金额");
        writer.addHeaderAlias("closeVar", "封单额");
        writer.addHeaderAlias("flowMarketVaR", "流通市值");
        writer.addHeaderAlias("changeHand", "换手%");
        writer.addHeaderAlias("nowPrice", "现价");
        writer.write(collect);
        writer.close();

    }
}
