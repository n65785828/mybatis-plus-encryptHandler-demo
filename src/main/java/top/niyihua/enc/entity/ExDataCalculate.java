package top.niyihua.enc.entity;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class ExDataCalculate {
    private String code;
    private String name;
    private BigDecimal upV;//涨幅
    private BigDecimal upSpeed;//涨速
    private BigDecimal openP;//开盘
    private BigDecimal nowVolume;//现量
    private BigDecimal liuTongZ;//流通市值Z
    private BigDecimal totalMoney;//总金额
    private BigDecimal openMoney;//开盘金额
    private BigDecimal closeVar;//封单额
    private BigDecimal flowMarketVaR;//流通市值
    private BigDecimal changeHand;// 换手%
    private BigDecimal nowPrice;//现价
}
