package com.jlpay.ext.qrcode.trans;

import com.alibaba.fastjson.JSON;
import com.jlpay.ext.qrcode.contants.TransContants;
import com.jlpay.ext.qrcode.trans.request.WapH5PayRequest;
import com.jlpay.ext.qrcode.trans.response.WapH5PayResponse;
import com.jlpay.ext.qrcode.trans.service.TransExecuteService;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author zhaoyang2
 * 支付宝服务窗支付demo
 */
public class WapH5PayService {

    static {
        //设置系统参数
        TransContants.setJlpayProperty();
    }

    public static void main(String[] args) {
        //组装请求参数
        WapH5PayRequest request = componentRequestData();
        //交易请求
        WapH5PayResponse response = TransExecuteService.executor(request, WapH5PayResponse.class);
        System.out.println("-----返回参数=========>" + JSON.toJSON(response));

    }

    private static WapH5PayRequest componentRequestData() {
        WapH5PayRequest request = new WapH5PayRequest();
        //必传字段
        request.setMchId("84931015812A00N");//嘉联分配的商户号
        request.setOrgCode("50264239");//嘉联分配的机构号
        request.setNonceStr("123456789ABCDEFG");//随机字符串
        request.setPayType("alipay");//交易类型    alipay:支付宝服务窗,小程序支付
        request.setOutTradeNo("WAP" + RandomStringUtils.randomNumeric(10));//商家系统内部订单号   机构下唯一
        request.setTotalFee("1");//交易金额
        request.setBody("支付宝服务窗/小程序支付");//商品名
        request.setTermNo("800056");//终端号
        request.setDeviceInfo("800056");//终端设备号
        request.setMchCreateIp("172.20.6.21");//终端IP
        request.setNotifyUrl("http://172.20.6.23:50001/qrcode/trans/unionpay/notify/");//回调地址
        request.setAttach("支付宝服务窗商品描述");//商品描述


        //非必传字段
        request.setBuyerLogonId("13720106549");//买家支付宝账号       buyer_logon_id和buyer_id不能同时为空
        request.setBuyerId("");//买家支付宝用户ID    buyer_logon_id和buyer_id不能同时为空
        request.setVersion("V1.0.1");//版本号
        request.setCharset("UTF-8");//字符集
        request.setSignType("RSA256");//签名方式
        request.setRemark("支付宝服务窗备注");//备注
        request.setLongitude("113.571558");//经度
        request.setLatitude("22.144889");//纬度
        request.setOpUserId("1001");//操作员
        request.setOpShopId("100001");//门店号
        request.setPaymentValidTime("20");//订单支付有效时间,默认20分钟

        return request;
    }

}
