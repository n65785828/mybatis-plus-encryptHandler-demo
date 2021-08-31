package top.niyihua.enc.converter;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import top.niyihua.enc.entity.ExData;
import top.niyihua.enc.entity.ExDataCalculate;

import java.math.BigDecimal;

public class BgConverter {
    public static ExDataCalculate convert(ExData exData){
        ExDataCalculate exDataCalculate = new ExDataCalculate();
        exDataCalculate.setCode(exData.getCode());
        exDataCalculate.setName(exData.getName());
        if(StringUtils.isBlank(exData.getUpV())||(StringUtils.isNotBlank(exData.getUpV())&&exData.getUpV().contains("--"))){
            exDataCalculate.setUpV(null);
        }else{
            exDataCalculate.setUpV(new BigDecimal(exData.getUpV()));
        }
        if(StringUtils.isBlank(exData.getUpSpeed())||(StringUtils.isNotBlank(exData.getUpSpeed())&&exData.getUpSpeed().contains("--"))){
            exDataCalculate.setUpSpeed(null);
        }else{
            exDataCalculate.setUpSpeed(new BigDecimal(exData.getUpSpeed()));
        }

        if(StringUtils.isBlank(exData.getOpenP())||(StringUtils.isNotBlank(exData.getOpenP())&&exData.getOpenP().contains("--"))){
            exDataCalculate.setOpenP(null);
        }else{
            exDataCalculate.setOpenP(new BigDecimal(exData.getOpenP()));
        }

        if(StringUtils.isBlank(exData.getNowVolume())||(StringUtils.isNotBlank(exData.getNowVolume())&&exData.getNowVolume().contains("--"))){
            exDataCalculate.setNowVolume(null);
        }else{
            exDataCalculate.setNowVolume(new BigDecimal(exData.getNowVolume()));
        }

        if(StringUtils.isBlank(exData.getLiuTongZ())||(StringUtils.isNotBlank(exData.getLiuTongZ())&&exData.getLiuTongZ().contains("--"))){
            exDataCalculate.setLiuTongZ(null);
        }else{
            StringBuffer stringBuffer = new StringBuffer(exData.getLiuTongZ().trim());
            stringBuffer.setLength(stringBuffer.length()-1);
            exDataCalculate.setLiuTongZ(new BigDecimal(stringBuffer.toString()));
        }

        if(StringUtils.isBlank(exData.getTotalMoney())||(StringUtils.isNotBlank(exData.getTotalMoney())&&exData.getTotalMoney().contains("--"))){
            exDataCalculate.setTotalMoney(null);
        }else{
            exDataCalculate.setTotalMoney(new BigDecimal(exData.getTotalMoney()));
        }

        if(StringUtils.isBlank(exData.getOpenMoney())||(StringUtils.isNotBlank(exData.getOpenMoney())&&exData.getOpenMoney().contains("--"))){
            exDataCalculate.setOpenMoney(null);
        }else{
            exDataCalculate.setOpenMoney(new BigDecimal(exData.getOpenMoney()));
        }

        if(StringUtils.isBlank(exData.getCloseVar())||(StringUtils.isNotBlank(exData.getCloseVar())&&exData.getCloseVar().contains("--"))){
            exDataCalculate.setCloseVar(null);
        }else{
            exDataCalculate.setCloseVar(new BigDecimal(exData.getCloseVar()));
        }

        if(StringUtils.isBlank(exData.getFlowMarketVaR())||(StringUtils.isNotBlank(exData.getFlowMarketVaR())&&exData.getFlowMarketVaR().contains("--"))){
            exDataCalculate.setFlowMarketVaR(null);
        }else{
            StringBuffer stringBuffer = new StringBuffer(exData.getFlowMarketVaR().trim());
            stringBuffer.setLength(stringBuffer.length()-1);
            exDataCalculate.setFlowMarketVaR(new BigDecimal(stringBuffer.toString()));
        }

        if(StringUtils.isBlank(exData.getChangeHand())||(StringUtils.isNotBlank(exData.getChangeHand())&&exData.getChangeHand().contains("--"))){
            exDataCalculate.setChangeHand(null);
        }else{
            exDataCalculate.setChangeHand(new BigDecimal(exData.getChangeHand()));
        }
        if(StringUtils.isBlank(exData.getChangeHand())||(StringUtils.isNotBlank(exData.getChangeHand())&&exData.getChangeHand().contains("--"))){
            exDataCalculate.setChangeHand(null);
        }else{
            exDataCalculate.setChangeHand(new BigDecimal(exData.getChangeHand()));
        }

        if(StringUtils.isBlank(exData.getNowPrice())||(StringUtils.isNotBlank(exData.getNowPrice())&&exData.getNowPrice().contains("--"))){
            exDataCalculate.setNowPrice(null);
        }else{
            exDataCalculate.setNowPrice(new BigDecimal(exData.getNowPrice()));
        }

        return exDataCalculate;
    }

    public static ExData revert(ExDataCalculate exDataCalculate){
        ExData exData = new ExData();
        exData.setCode(exDataCalculate.getCode());
        exData.setName(exDataCalculate.getName());

        if(exDataCalculate.getUpV()==null){
            exData.setUpV("--");
        }else{
            exData.setUpV(exDataCalculate.getUpV().toString());
        }

        if(exDataCalculate.getUpSpeed()==null){
            exData.setUpSpeed("--");
        }else{
            exData.setUpSpeed(exDataCalculate.getUpSpeed().toString());
        }

        if(exDataCalculate.getOpenP()==null){
            exData.setOpenP("--");
        }else{
            exData.setOpenP(exDataCalculate.getOpenP().toString());
        }

        if(exDataCalculate.getNowVolume()==null){
            exData.setNowVolume("--");
        }else{
            exData.setNowVolume(exDataCalculate.getNowVolume().toString());
        }

        if(exDataCalculate.getLiuTongZ()==null){
            exData.setLiuTongZ("--");
        }else{
            exData.setLiuTongZ(exDataCalculate.getLiuTongZ().toString()+"亿");
        }

        if(exDataCalculate.getTotalMoney()==null){
            exData.setTotalMoney("--");
        }else{
            exData.setTotalMoney(exDataCalculate.getTotalMoney().toString());
        }

        if(exDataCalculate.getOpenMoney()==null){
            exData.setOpenMoney("--");
        }else{
            exData.setOpenMoney(exDataCalculate.getOpenMoney().toString());
        }

        if(exDataCalculate.getCloseVar()==null){
            exData.setCloseVar("--");
        }else{
            exData.setCloseVar(exDataCalculate.getCloseVar().toString());
        }

        if(exDataCalculate.getFlowMarketVaR()==null){
            exData.setFlowMarketVaR("--");
        }else{
            exData.setFlowMarketVaR(exDataCalculate.getFlowMarketVaR().toString()+"亿");
        }

        if(exDataCalculate.getChangeHand()==null){
            exData.setChangeHand("--");
        }else{
            exData.setChangeHand(exDataCalculate.getChangeHand().toString());
        }

        if(StringUtils.isBlank(exData.getNowPrice())||(StringUtils.isNotBlank(exData.getNowPrice())&&exData.getNowPrice().contains("--"))){
            exDataCalculate.setNowPrice(null);
        }else{
            exDataCalculate.setNowPrice(new BigDecimal(exData.getNowPrice()));
        }

        if(exDataCalculate.getNowPrice()==null){
            exData.setNowPrice("--");
        }else{
            exData.setNowPrice(exDataCalculate.getNowPrice().toString());
        }
        return exData;
    }
}
