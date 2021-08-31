package top.niyihua.enc.secret;


import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import top.niyihua.enc.util.AES;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(String.class)
public class AESEncryptTypeHandler extends BaseTypeHandler<String> {

    public static final String AES_KEY = "K2NIVYrjqFbkH7BtNYyG6w==";

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        try {
            String parameterEncode = AES.aesEncrypt(parameter,AES_KEY);
            ps.setString(i, parameterEncode);
        } catch (Exception e) {
            e.printStackTrace();
            ps.setString(i, parameter);
        }
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String columnValue = rs.getString(columnName);
        try {
            columnValue = AES.aesDecrypt(columnValue,AES_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return columnValue;
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
