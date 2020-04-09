package com.jlpay.ext.qrcode.trans;

import com.alibaba.fastjson.JSON;
import com.jlpay.ext.qrcode.contants.TransContants;
import com.jlpay.ext.qrcode.trans.request.RefundRequest;
import com.jlpay.ext.qrcode.trans.response.RefundResponse;
import com.jlpay.ext.qrcode.trans.service.TransExecuteService;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author zhaoyang2
 * 退货demo
 */
public class RefundService {
	
	static{
		//设置系统参数
		TransContants.setJlpayProperty();
	}
	
	public static void main(String[] args) {
		//组装请求参数
		RefundRequest request = componentRequestData();
		System.out.println("-----请求参数=========>"+ JSON.toJSON(request));
		//交易请求
		RefundResponse response = TransExecuteService.executor(request, RefundResponse.class);
		System.out.println("-----返回参数=========>"+ JSON.toJSON(response));
		
	}

	private static RefundRequest componentRequestData() {
		RefundRequest request = new RefundRequest();
		//必传字段
		request.setMchId("84931015812A00N");//嘉联分配的商户号
		request.setOrgCode("50264239");//嘉联分配的机构号
		request.setNonceStr("123456789abcdefg");//随机字符串
		request.setOutTradeNo("TK"+RandomStringUtils.randomNumeric(10));//商家系统内部订单号   机构下唯一
		request.setOriOutTradeNo("BS7845814554");//商家系统内部原订单号   机构下唯一
		request.setTotalFee("1");//交易金额（退货金额）
		request.setMchCreateIp("172.20.6.21");//终端IP
		//非必传字段
		request.setPayType("alipay");//交易类型    wxpay、alipay、unionpay
		request.setVersion("V1.0.1");//版本号
		request.setCharset("UTF-8");//字符集
		request.setSignType("RSA256");//签名方式
		request.setLongitude("113.571558");//经度
		request.setLatitude("22.144889");//纬度
		
		return request;
	}
	
}
