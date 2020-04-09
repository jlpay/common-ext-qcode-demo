package com.jlpay.ext.qrcode.trans;

import com.alibaba.fastjson.JSON;
import com.jlpay.ext.qrcode.contants.TransContants;
import com.jlpay.ext.qrcode.trans.request.UnionJsPayRequest;
import com.jlpay.ext.qrcode.trans.response.UnionJsPayResponse;
import com.jlpay.ext.qrcode.trans.service.TransExecuteService;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * @Description: 银联行业码支付
 * @author: lvlinyang
 * @date: 2019/11/25 10:53
 */
public class UnionJsPayService {

    static {
        //设置系统参数
        TransContants.setJlpayProperty();
    }

    public static void main(String[] args) {

        //组装请求参数
        UnionJsPayRequest request = componentRequestData();
        System.out.println("-----请求参数=========>" + JSON.toJSON(request));

        //交易请求
        UnionJsPayResponse response = TransExecuteService.executor(request, UnionJsPayResponse.class);
        System.out.println("-----返回参数=========>" + JSON.toJSON(response));

    }

    private static UnionJsPayRequest componentRequestData() {
        UnionJsPayRequest request = new UnionJsPayRequest();
        //必传字段
        request.setMchId("84931015812A00N");//嘉联分配的商户号
        request.setOrgCode("50264239");//嘉联分配的机构号
        request.setNonceStr("123456789ABCDEFG");//随机字符串
        request.setPayType("unionpay");//交易类型    wxpay、unionpay
        request.setOutTradeNo("UNJS" + RandomStringUtils.randomNumeric(10));//商家系统内部订单号   机构下唯一
        request.setTotalFee("1");//交易金额
        request.setBody("银联行业码支付测试");//商品名
        request.setTermNo("12345678");//终端号   unionpay时必须8位
        request.setDeviceInfo("800056");//终端设备号
        request.setMchCreateIp("172.20.6.21");//终端IP
        request.setNotifyUrl("http://172.20.6.23:50001/qrcode/trans/unionpay/notify/");//回调地址
        request.setAttach("银联行业码支付商品描述");//商品描述


        //非必传字段
        request.setVersion("V1.0.1");//版本号
        request.setCharset("UTF-8");//字符集
        request.setSignType("RSA256");//签名方式
        request.setRemark("银联行业码支付备注");//备注
        request.setLongitude("113.571558");//经度
        request.setLatitude("22.144889");//纬度
        request.setOpUserId("1001");//操作员
        request.setOpShopId("100001");//门店号

        request.setUserId("XXXXXXXX");//银联二维码用户标识,通过授权码和APP标识获取
        request.setPaymentValidTime("20");//订单支付有效时间,默认20分钟

        return request;
    }

}
