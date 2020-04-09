package com.jlpay.ext.qrcode.trans;

import com.alibaba.fastjson.JSON;
import com.jlpay.ext.qrcode.contants.TransContants;
import com.jlpay.ext.qrcode.trans.request.AppPayRequest;
import com.jlpay.ext.qrcode.trans.response.AppPayResponse;
import com.jlpay.ext.qrcode.trans.service.TransExecuteService;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author zhaoyang2
 * APP支付demo    该接口暂不开放
 */
public class AppPayService {
	
	static{
		//设置系统参数
		TransContants.setJlpayProperty();
	}
	
	public static void main(String[] args) {
        System.out.println("暂不开放使用");

        /*
		//组装请求参数
		AppPayRequest request = componentRequestData();
		//交易请求
		AppPayResponse response = TransExecuteService.executor(request, AppPayResponse.class);
		System.out.println("返回参数=========>"+ JSON.toJSON(response));
		*/
		
	}

	private static AppPayRequest componentRequestData() {
		AppPayRequest request = new AppPayRequest();
		//必传字段
		request.setMchId("84931015812A00N");//嘉联分配的商户号
		request.setOrgCode("50264239");//嘉联分配的机构号
		request.setNonceStr("123456789");//随机字符串
		request.setPayType("wxpay");//交易类型    wxpay、unionpay
		request.setOutTradeNo("APP"+RandomStringUtils.randomNumeric(10));//商家系统内部订单号   机构下唯一
		request.setTotalFee("1");//交易金额
		request.setBody("APP支付测试");//商品名
		request.setTermNo("800056");//终端号   unionpay时必须8位
		request.setDeviceInfo("800056");//终端设备号  
		request.setMchCreateIp("172.20.6.21");//终端IP
		request.setSubAppid("wx77ce81b42d454ae2");//APP应用绑定的APPID
		request.setNotifyUrl("http://172.20.6.23:50001/qrcode/trans/unionpay/notify/");//回调地址
		request.setAttach("APP支付商品描述");//商品描述
		//非必传字段
		request.setUserId("");//银联二维码用户标识     unionpay时必须传
		request.setVersion("V1.0.1");//版本号
		request.setCharset("UTF-8");//字符集
		request.setSignType("RSA256");//签名方式
		request.setRemark("APP支付备注");//备注
		request.setLongitude("113.571558");//经度
		request.setLatitude("22.144889");//纬度
		request.setOpUserId("1001");//操作员
		request.setOpShopId("1001");//门店号
		
		return request;
	}
	
}
