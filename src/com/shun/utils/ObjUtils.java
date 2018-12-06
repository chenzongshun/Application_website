package com.shun.utils;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/**
* @author czs
* @version 创建时间：2018年6月23日 下午6:55:54 <br>
* 这个项目的工具类
*/
public class ObjUtils {

	/**
	 * @return 最新的时间字符串
	 */
	public static String getCurrentDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(new Date());
	}

	/**
	 * 判断是手机还是电脑
	 * @param request
	 * @return
	 */
	public static boolean isMobileDevice(HttpServletRequest request) {
		String requestHeader = request.getHeader("user-agent");
		/**
		 * android : 所有android设备
		 * mac os : iphone ipad
		 * windows phone:Nokia等windows系统的手机
		 */
		String[] deviceArray = new String[] { "android", "mac os", "windows phone" };
		if (requestHeader == null)
			return false;
		requestHeader = requestHeader.toLowerCase();
		for (int i = 0; i < deviceArray.length; i++) {
			if (requestHeader.indexOf(deviceArray[i]) > 0) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 返回真实的ip对应的真实地址
	 * @param ip 字符串式IP地址
	 * 可以用的ip地址接口		
	 * http://ip.ws.126.net/ipquery?ip=223.157.25.51
	 * http://whois.pconline.com.cn/jsLabel.jsp?ip=223.157.26.164&id=showIpInfo
	 * @return
	 */
	public static String getTrueIpAddrees(String ip){
		String addrees = null;
		try {
            URL url = new URL("http://whois.pconline.com.cn/jsLabel.jsp?ip=" + ip + "&id=showIpInfo");// 字符串转成请求地址
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接
            connection.connect();// 连接会话
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "GBK"));// 响应结果为输入流
            String line;
            StringBuilder sb = new StringBuilder();// 输出的结果
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            connection.disconnect();// 断开连接
//            System.out.println(sb.toString());
            addrees = sb.toString();
			addrees = addrees.substring(addrees.indexOf("='") - addrees.indexOf(addrees.indexOf("='")));
			addrees = addrees.replace(" ", "");
			addrees = addrees.replace("'", "");
			addrees = addrees.replace(";", "");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("IP地址转换为真实地址请求失败 :" + e.getMessage());
        }
		return addrees;
	}
	
	public static void main(String[] args) {
		System.out.println(getTrueIpAddrees("223.157.25.51"));
	}
}
