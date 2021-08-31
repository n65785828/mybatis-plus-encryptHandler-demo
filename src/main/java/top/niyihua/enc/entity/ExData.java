package top.niyihua.enc.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ExData {
    private String code;
    private String name;
    private String upV;//涨幅
    private String upSpeed;//涨速
    private String openP;//开盘
    private String nowVolume;//现量
    private String liuTongZ;//流通市值Z
    private String totalMoney;//总金额
    private String openMoney;//开盘金额
    private String closeVar;//封单额
    private String flowMarketVaR;//流通市值
    private String changeHand;// 换手%
    private String nowPrice;//现价
}
