package top.niyihua.enc.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import top.niyihua.enc.secret.AESEncryptTypeHandler;

@Data
@ToString
@TableName(value = "user",autoResultMap = true)
public class User {
    @TableId
    private String id;
    private String name;
    @TableField(typeHandler = AESEncryptTypeHandler.class)
    private String mobile;
}
