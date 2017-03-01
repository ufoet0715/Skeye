package com.yagout.defense.util;

import java.util.HashMap;
import java.util.Map;

public class CRequest {
	/**
	 * 解析出url请求的路径，包括页面
	 * 
	 * @param strURL
	 *            url地址
	 * @return url路径
	 */
	public static String UrlPage(String strURL) {
		String strPage = null;
		String[] arrSplit = null;
		strURL = strURL.trim().toLowerCase();
		arrSplit = strURL.split("[?]");
		if (strURL.length() > 0) {
			if (arrSplit.length > 1) {
				if (arrSplit[0] != null) {
					strPage = arrSplit[0];
				}
			}
		}
		return strPage;
	}

	/**
	 * 解析出url参数中的键值对 如 "index.jsp?Action=del&id=123"，解析出Action:del,id:123存入map中
	 * 
	 * @param URL
	 *            url地址
	 * @return url请求参数部分
	 */
	public static Map<String, Object> URLRequest(String URL) {
		Map<String, Object> mapRequest = new HashMap<String, Object>();
		String[] arrSplit = null;
		// 每个键值为一组
		arrSplit = URL.split("[&]");
		for (String strSplit : arrSplit) {
			String[] arrSplitEqual = null;
			arrSplitEqual = strSplit.split("[=]");
			// 解析出键值
			if (arrSplitEqual.length > 1) {
				// 正确解析
				if(!"".equals(arrSplitEqual[1])){
					mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);
				}
			}
		}
		return mapRequest;
	}
}
