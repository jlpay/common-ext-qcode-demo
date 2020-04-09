package com.jlpay.ext.qrcode.trans;

import com.alibaba.fastjson.JSON;
import com.jlpay.ext.qrcode.contants.TransContants;
import com.jlpay.ext.qrcode.trans.request.MicroPayRequest;
import com.jlpay.ext.qrcode.trans.response.MicroPayResponse;
import com.jlpay.ext.qrcode.trans.service.TransExecuteService;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author zhaoyang2
 * 条形码支付demo
 * 此接口可能会返回待确认的订单状态，此时需要接入方调用订单查询接口主动查询订单实际支付情况，
 * 建议等待5秒后发起查询，间隔10秒，15秒，20秒…，如果仍然为“待确认”状态，调用撤销接口关闭该笔交易。
 */
public class MicroPayService {

    static {
        //设置系统参数
        TransContants.setJlpayProperty();
    }

    public static void main(String[] args) {

        //组装请求参数
        MicroPayRequest request = componentRequestData();
        System.out.println("-----请求参数=========>" + JSON.toJSON(request));

        //交易请求
        MicroPayResponse response = TransExecuteService.executor(request, MicroPayResponse.class);
        System.out.println("-----返回参数=========>" + JSON.toJSON(response));

    }

    private static MicroPayRequest componentRequestData() {
        MicroPayRequest request = new MicroPayRequest();
        //必传字段
        request.setMchId("84931015812A00N");//嘉联分配的商户号
        request.setOrgCode("50264239");//嘉联分配的机构号
        request.setNonceStr("123456789abcdefg");//随机字符串
        request.setPayType("wxpay");//交易类型    wxpay、alipay、unionpay
        request.setOutTradeNo("BS" + RandomStringUtils.randomNumeric(10));//商家系统内部订单号   机构下唯一
        request.setTotalFee("1");//交易金额
        request.setBody("被扫测试");//商品名
        request.setTermNo("12345678");//终端号   unionpay时必须8位
        request.setDeviceInfo("20190101");//终端设备号
        request.setMchCreateIp("172.20.6.21");//终端IP
        request.setAuthCode("134655430723047245");//授权码
        request.setAttach("被扫商品描述");//商品描述
        //非必传字段
        request.setVersion("V1.0.3");//版本号
        request.setCharset("UTF-8");//字符集
        request.setSignType("RSA256");//签名方式
        request.setRemark("被扫备注");//备注
        request.setLongitude("113.571558");//经度
        request.setLatitude("22.144889");//纬度
        request.setOpUserId("1001");//操作员
        request.setOpShopId("100001");//门店号
        request.setPaymentValidTime("20");//订单支付有效时间, 默认20分钟

        return request;
    }

}
