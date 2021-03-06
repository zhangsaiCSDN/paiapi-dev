package com.woniuxy.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmS {
	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url   发送请求的URL
	 * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	
	public static String appcode = "909d03a7c5764dd49758b251d2bad11d";
//	public static String mobile = "17629086273";
//	public static String params = "没鸟,95274";
	public static String sign = "网极科技";
	public static String tpl_id = "47331";
	
	
//	public static void main(String[] args) {
//		// 发送 GET 请求
//
////		String params = "没鸟,95274";
////		String mobile = "17629086273";
////		String s = SmS.sendGet("https://smsapi.api51.cn/single_sms_get/",
////				"mobile=" + mobile + "&params=" + params + "&sign=" + sign + "&tpl_id=" + tpl_id, appcode);
////		System.out.println(s);
//		sendCode("anvxcv", "17629086273");
//		/*
//		 * //发送 POST 请求 String
//		 * sr=HttpRequest.sendPost("http://localhost:6144/Home/RequestPostString",
//		 * "key=123&v=456"); System.out.println(sr);
//		 */
//	}
	
	
	public static Map<String,String> sendCode(String username,String mobile){
		Map<String,String> map = new HashMap<>();
		String code = AppUtils.uuid().substring(0, 5);
//		System.out.println(code);
		String params = username+","+code;
		String s = SmS.sendGet("https://smsapi.api51.cn/single_sms_get/",
				"mobile=" + mobile + "&params=" + params + "&sign=" + sign + "&tpl_id=" + tpl_id, appcode);
//		System.out.println(s);
		map.put("code", code);
		map.put("result",s);
		return map;
	}

	public static String sendGet(String url, String param, String appcode) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setRequestProperty("Authorization", "APPCODE " + appcode);
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				// System.out.println(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url   发送请求的 URL
	 * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
}