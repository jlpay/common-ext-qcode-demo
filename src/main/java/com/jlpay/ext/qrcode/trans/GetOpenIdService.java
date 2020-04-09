package com.jlpay.ext.qrcode.trans;

import com.alibaba.fastjson.JSON;
import com.jlpay.ext.qrcode.contants.TransContants;
import com.jlpay.ext.qrcode.trans.request.GetOpenIdRequest;
import com.jlpay.ext.qrcode.trans.response.GetOpenIdResponse;
import com.jlpay.ext.qrcode.trans.service.TransExecuteService;

/**
 * @author zhaoyang2
 * 授权码获取openId或userId的demo
 * payType:wxpay 测试环境可以验证
 * payTYpe:unionpay 测试环境报文仅供参考
 */
public class GetOpenIdService {

    static {
        //设置系统参数
        TransContants.setJlpayProperty();
    }

    public static void main(String[] args) {
        //组装请求参数
        GetOpenIdRequest request = componentRequestData();
        System.out.println("-----请求参数=========>" + JSON.toJSON(request));

        //交易请求
        GetOpenIdResponse response = TransExecuteService.executor(request, GetOpenIdResponse.class);
        System.out.println("-----返回参数=========>" + JSON.toJSON(response));

    }

    private static GetOpenIdRequest componentRequestData() {
        GetOpenIdRequest request = new GetOpenIdRequest();
        //必传字段
        request.setMchId("84931015812A00N");//嘉联分配的商户号
        request.setOrgCode("50264239");//嘉联分配的机构号
        request.setNonceStr("123456789");//随机字符串
        request.setPayType("wxpay");//交易类型    wxpay、unionpay
        request.setAuthCode("134519057319081876");//授权码  unionpay:Y/uPmzGRTDuU3eNSzpepYg== 仅供参考
        //非必传字段
        request.setSubAppid("");//公众账号ID
//		request.setAppUpIdentifier("UnionPay/1.0 CloudPay");//银联支付标识  银联二维码必送
        request.setVersion("V1.0.1");//版本号
        request.setCharset("UTF-8");//字符集
        request.setSignType("RSA256");//签名方式

        return request;
    }

}
