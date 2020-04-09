package com.jlpay.ext.qrcode.trans;

import com.alibaba.fastjson.JSON;
import com.jlpay.ext.qrcode.contants.TransContants;
import com.jlpay.ext.qrcode.trans.request.AuthorizationBindRequest;
import com.jlpay.ext.qrcode.trans.response.AuthorizationBindResponse;
import com.jlpay.ext.qrcode.trans.service.TransExecuteService;

/**
 * @author zhaoyang2
 * 绑定支付目录demo 此接口测试环境无法测试,报文仅做参考
 */
public class AuthorizationBindService {
	
	static{
		//设置系统参数
		TransContants.setJlpayProperty();
	}
	
	public static void main(String[] args) {
		//组装请求参数
		AuthorizationBindRequest request = componentRequestData();
		System.out.println("-----请求参数=========>"+ JSON.toJSON(request));

		//交易请求
		AuthorizationBindResponse response = TransExecuteService.executor(request, AuthorizationBindResponse.class);
		System.out.println("-----返回参数=========>"+ JSON.toJSON(response));
		
	}

	private static AuthorizationBindRequest componentRequestData() {
		AuthorizationBindRequest request = new AuthorizationBindRequest();
		//必传字段
		request.setMchId("84931015812A00N");//嘉联分配的商户号
		request.setOrgCode("50264239");//嘉联分配的机构号
		request.setNonceStr("123456789");//随机字符串

		request.setPayType("wxpay");//交易类型    wxpay
		request.setMchCreateIp("127.0.0.1");//终端IP
		//非必传字段
		request.setJsapiPath("https://mf.jlpay.com");//JSAPI支付授权目录
		request.setSubAppid("");//公众账号ID

		request.setVersion("V1.0.1");//版本号
		request.setCharset("UTF-8");//字符集
		request.setSignType("RSA256");//签名方式
		
		return request;
	}
	
}
