package com.yagout.defense.util;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class ARPUtil {
	
	/**
	 * 获得客户端的IP地址
	 * @param request
	 * @return ip
	 */
	private static String getIpByRequest(HttpServletRequest request) {
		String ip = request.getRemoteHost();
		if(ip.equals("0:0:0:0:0:0:0:1")||ip==null)
		{
			ip="127.0.0.1";
		}
		return ip;
	}

	/**
	 * 执行dos命令
	 * @param cmd
	 * @return result
	 * @throws Exception
	 */
	private static String command(String cmd) throws Exception{
        Process process = Runtime.getRuntime().exec(cmd);
        process.waitFor();
        InputStream in = process.getInputStream();
        StringBuilder result = new StringBuilder();
        byte[] data = new byte[256];
        while(in.read(data) != -1){
            String encoding = System.getProperty("sun.jnu.encoding");
            result.append(new String(data,encoding));
        }
        return result.toString();
    }
	
	/**
	 * 获得本地mac地址
	 * @return mac
	 */
	private static String getLocateMac() {
		InetAddress inetAddress=null;
		byte[] mac=null;
		StringBuffer sb = new StringBuffer();
		try {
			inetAddress = InetAddress.getLocalHost();
			mac = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
			
			for(int i=0; i<mac.length; i++) {
				if(i!=0) {
					sb.append("-");
				}
				//字节转换为整数
				int temp = mac[i]&0xff;
				String str = Integer.toHexString(temp);
				if(str.length()==1) {
					sb.append("0"+str);
				}else {
					sb.append(str);
				}
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString().toUpperCase();
	}
	
	/**
	 * 从IP地址中获得MAC地址
	 * @param ip
	 * @return mac
	 */
	public static String getMacByRequest(HttpServletRequest request) {
		String result=null;
		String mac=null;
		String ip=getIpByRequest(request);
		
		try {
			result = command("ping "+ip+" -n 2");
			if(result.contains("TTL")){
	            result = command("arp -a "+ip);
	        }
	        String regExp = "([0-9A-Fa-f]{2})([-:][0-9A-Fa-f]{2}){5}";
	        Pattern pattern = Pattern.compile(regExp);
	        Matcher matcher = pattern.matcher(result);
	        StringBuilder sb = new StringBuilder();
	        while (matcher.find()) {
	            String temp = matcher.group();
	            sb.append(temp);
	        }
	        mac=sb.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        if(mac==null||mac.equals(""))
        {
            mac=getLocateMac();
        }
        
        return mac;
	}
}
