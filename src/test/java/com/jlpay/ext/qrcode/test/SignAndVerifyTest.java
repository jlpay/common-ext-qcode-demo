package com.jlpay.ext.qrcode.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jlpay.ext.qrcode.trans.utils.RSA256Utils;

public class SignAndVerifyTest {

    private static final String SIGN_KEY = "sign";
    //业务JSON对象.
    private static final String jsonText = "{\"tranId\":\"9005950620171122141120864367\",\"tranTime\":\"20171122141117\",\"merNo\":\"DF1000255100012\",\"respMsg\":\"company's account error:bank union no or bank sub name is empty\",\"origTranId\":\"9001940120171121191126863891\",\"respCode\":\"02\"}";
    //用户公KEY
    private static final String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAp80Cyw5T4fRD0mkZAM0uOnxv6G84v8UElpoxlPdt2q0Q3oLJ8SAcLVOXoCA7Yd/gHgdDwP7aAfbb1U5/srzwqpd/rkdf3d2pPbljy2GW46n53VUK6f1wrghJi/jUsuZvr/lfgjaeKQEoyajzS/PbXQaKEtQSmG/9S7cmctktjMGU2uNH8j36H9dQPLucgcVZLSjkxH2UsMg0LabLC+l5zJDmnHcHqBlEPPl/mUDUNYj4S2bWdCQJ5IrBVJoNGQikRy01jE6NCrMFNxfAnphBJ/RGzBqH5J3icQ7ICUOVYNftJu0A6OSj6g3We+SWkytzWGixjqo67faP/+YddicjmwIDAQAB";
    //服务端私KEY
    private static final String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCnzQLLDlPh9EPSaRkAzS46fG/obzi/xQSWmjGU923arRDegsnxIBwtU5egIDth3+AeB0PA/toB9tvVTn+yvPCql3+uR1/d3ak9uWPLYZbjqfndVQrp/XCuCEmL+NSy5m+v+V+CNp4pASjJqPNL89tdBooS1BKYb/1LtyZy2S2MwZTa40fyPfof11A8u5yBxVktKOTEfZSwyDQtpssL6XnMkOacdweoGUQ8+X+ZQNQ1iPhLZtZ0JAnkisFUmg0ZCKRHLTWMTo0KswU3F8CemEEn9EbMGofkneJxDsgJQ5Vg1+0m7QDo5KPqDdZ75JaTK3NYaLGOqjrt9o//5h12JyObAgMBAAECggEAU/KhqhqR5qIAaDzCEH+V2Ba3Gc7C0lXrlLixg3hB0jvxC5DdHK/WyOpgGfDmJHIPOpah0+TsBj2M/2sVQcN6l63RZ8w3btTdPY8JGQ/KoD1CTvOj0SpE/BwTR16GcrYMPDqDCK7wc00sLa9DgMUQArspyn+kifTFAOMw7hYuzpKeXzGvWnwp6dF3o8JqzuPC3LVsb8FTlQoHiBejDaBHCJH0MiaHFqkdEVzDBBLFp9iGGgR69gT26ITDZs6xFYt3YbHv1bGcezXmVdTJsxaDLN6xrVkwSH6oVZFmHA7oDUorUk9PbwGqWigN1OOwBTjlRQpEoDQQ7TM8Tn4JcaOosQKBgQDdrsomJGcmJYFgnuecK7UU+QPC4nGMQ+51lK+b1iRk/mUsM3ay5A5wtMOl6vdUOAx6IEcOLFpUYAzo7MYISGOrxLWsv1faDZWaVNeol3CDVZQq8/TFOLD0HgkqvDTm6rBuuDLt4fuOHQD+On04ZEUrgO5xh/UGaTosEz0dFZJiSQKBgQDBxuYKSv03e5n8mXKJqxCCqe8Tnc6i3THYYOUrl8ffEnOeNPqbIzhLU3oEzjcvQDw50DAd5hRclLoXn02Y/C1oZ4jlKf3/jhsiIZZyJga8MdoyoK5DJX0BR8HSAlG+SWmxYjSrV6rmUHSG45hBG2VX/zVG7r1hC5gMTjXVmZQWwwKBgBr+KYczb4vpjTNipfkSKV6AY8DbKdBWhTa0AB4NmSjjARa8vXtS4Z8/o4MUdUFAAeTtATnslKMpfujty78+cUR9E1IRinT2qny8T/YrWnvjc8M3KVrKaGGRNrSJbjef5BPXQfxNRAAt7+0E2jJ/oxyE+oPAdkltjrPHM+3SrpxhAoGAKgV79Vd1ugZvyjtsfzY9ilhXpCVgnijhmk7I478ydMmHkRNkFSh6GLuthkVB6lk/tjnTdWhjmgAWqvC83yQwpKdvJGMK1dR3RduKyI4+f6k/7CK0J5OFnDV3bpdaKq244eKuEUodoXxpCKdqaRQL0h1h7FPxdY4SFvkO65c2agkCgYEAzCsyz+y9wOexsKY9mRyXPJEquUtifYBQNKmwUOqnaQTdwpGtU+cJ/7xRcIjTh2SIn2XXjsHmIPsy756Yy7gZRQoBmoU85niEDVB9oy1v+uXjxqD+G16tcYtSBF2y8sjNvH7UZmD5YgU+spQSZ2Pd9mU0pR1kVEnRaXi7NPS3kQ8=";


    public static void main(String[] args) {
        /**
         * 签名
         */
        JSONObject contextJson = JSON.parseObject(jsonText);
        System.out.println("-----原始Json内容=========>" + contextJson);
        String sginStr = getSignContext(contextJson);
        //获取签名字段,升序排列
        System.out.println("-----获取签名字段并升序排列=========>" + sginStr);
        String sign256 = RSA256Utils.sign256(sginStr, privateKey);
        System.out.println("-----sign256签名=========>" + sign256);
        contextJson.put(SIGN_KEY, sign256);
        System.out.println("-----完整签名的JSON内容=========>" + JSON.toJSONString(contextJson));

        /**
         * 验证签名
         */
        JSONObject verifycontextJson = JSON.parseObject(JSON.toJSONString(contextJson));
        String verifyStr = getSignContext(verifycontextJson);
        String sign2 = verifycontextJson.getString(SIGN_KEY);
        //验证签名
        boolean flag = RSA256Utils.verify256(verifyStr, publicKey, sign2);
        System.out.println("-----签名验证结果=========>" + JSON.toJSONString(flag));
    }

    /**
     * 从JSON对象获取SIGN_KEY.
     *
     * @param contextJson
     * @return
     */
    private static String getSignContext(JSONObject contextJson) {
        List<String> keys = new ArrayList<>(contextJson.keySet());
        Collections.sort(keys);
        Map<String, Object> treeMap = new TreeMap<>();
        for (String key : keys) {
            if (!SIGN_KEY.equals(key)) {
                treeMap.put(key, contextJson.get(key));
            }
        }
        return JSON.toJSONString(treeMap);
    }
}
