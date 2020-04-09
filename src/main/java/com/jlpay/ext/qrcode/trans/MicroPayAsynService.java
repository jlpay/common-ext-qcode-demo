package com.jlpay.ext.qrcode.trans;

import com.alibaba.fastjson.JSON;
import com.jlpay.ext.qrcode.contants.TransContants;
import com.jlpay.ext.qrcode.trans.request.MicroPayAsynRequest;
import com.jlpay.ext.qrcode.trans.response.MicropayAsynResponse;
import com.jlpay.ext.qrcode.trans.service.TransExecuteService;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author zhaoyang2
 * 条形码支付异步demo
 */
public class MicroPayAsynService {
	static{
		//设置系统参数
		TransContants.setJlpayProperty();
	}
	
	public static void main(String[] args) {
		System.out.println("该接口已关闭");
		/*
		//组装请求参数
		MicroPayAsynRequest request = componentRequestData();
		//交易请求
		MicropayAsynResponse response = TransExecuteService.executor(request, MicropayAsynResponse.class);
		System.out.println("返回参数=========>"+ JSON.toJSON(response));
		*/
	}

	private static MicroPayAsynRequest componentRequestData() {
		MicroPayAsynRequest request = new MicroPayAsynRequest();
		//必传字段
		request.setMchId("84931015812A00N");//嘉联分配的商户号
		request.setOrgCode("50264239");//嘉联分配的机构号
		request.setNonceStr("123456789");//随机字符串
		request.setPayType("alipay");//交易类型    wxpay、alipay、unionpay
		request.setOutTradeNo("BS"+RandomStringUtils.randomNumeric(10));//商家系统内部订单号   机构下唯一
		request.setTotalFee("100");//交易金额
		request.setBody("异步被扫测试");//商品名
		request.setTermNo("800056");//终端号   unionpay时必须8位
		request.setDeviceInfo("800056");//终端设备号  
		request.setMchCreateIp("172.20.6.21");//终端IP
		request.setAuthCode("286674884362587493");//授权码
		request.setAttach("异步被扫商品描述");//商品描述
		//非必传字段
		request.setVersion("V1.0.1");//版本号
		request.setCharset("UTF-8");//字符集
		request.setSignType("RSA256");//签名方式
		request.setRemark("异步被扫备注");//备注
		request.setLongitude("113.571558");//经度
		request.setLatitude("22.144889");//纬度
		request.setOpUserId("1001");//操作员
		request.setOpShopId("1001");//门店号
		
		return request;
	}
	
}
