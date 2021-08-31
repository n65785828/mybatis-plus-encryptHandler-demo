package top.niyihua.enc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.niyihua.enc.mapper")
public class EncApplication {

    public static void main(String[] args) {
        SpringApplication.run(EncApplication.class, args);
    }

}
