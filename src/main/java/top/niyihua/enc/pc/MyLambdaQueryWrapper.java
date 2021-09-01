package top.niyihua.enc.pc;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.enums.SqlKeyword;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;


public class MyLambdaQueryWrapper<T> extends LambdaQueryWrapper<T> {
    public LambdaQueryWrapper addCondition(boolean condition, SFunction<T,?> function, SqlKeyword sqlKeyword, Object val, String typeHandler) {
        return  maybeDo(condition, () -> appendSqlSegments(columnToSqlSegment(function), sqlKeyword,
                () -> formatParam(typeHandler, val)));
    }
}
