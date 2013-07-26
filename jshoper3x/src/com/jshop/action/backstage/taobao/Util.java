package com.jshop.action.backstage.taobao;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Util {
	private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6',

		'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

		//线上
		//public final static String APP_KEY = "12449357";
		
		
		//public final static String APP_SERCET = "57c3ded88c09f1773824748a2db0ae4e";
		
		
		
		//public final static String sessionKey="6102223e6dacdb33909aebdb29712cb17794bf72ac4cb38114055901";
		
		public final static String sessionKey="6102b09d22efbd3481806219df761842d275a70f1880ff9114055901";
		
		public final static String APP_KEY = "12448096";
		
		public final static String APP_SERCET = "df0f15160f16773e77df71e59cff48e1";
		
		public final static String URL = "http://gw.api.taobao.com/router/rest";
		
		
		
		//public final static String URL="http://gw.api.tbsandbox.com/router/rest";
		
		public final static String logoff_URL="http://container.api.taobao.com/container/logoff";
		
		/**
		* 对参数进行MD5
		*
		* @param params
		* 排好序的参数Map
		* @param secret
		* 应用的密钥
		* @return MD5签名字符串
		* @throws UnsupportedEncodingException
		*/

		public static String sign(final TreeMap<String, String> params,

		String secret) throws UnsupportedEncodingException {

		if (null == params || params.isEmpty()) {

		return (String) null;

		}

		if (isBlank(secret)) {

		return (String) null;

		}

		StringBuilder sb = new StringBuilder();

		sb.append(secret);

		for (Iterator<Entry<String, String>> it = params.entrySet().iterator(); it

		.hasNext();) {

		Entry<String, String> entry = it.next();

		sb.append(entry.getKey()).append(defaultString(entry.getValue()));

		}

		sb.append(secret);

		byte[] bytes = sb.toString().getBytes("UTF-8");

		return md5Hex(bytes).toUpperCase();

		}

		public static boolean isBlank(String str) {

		int strLen;

		if (str == null || (strLen = str.length()) == 0) {

		return true;

		}

		for (int i = 0; i < strLen; i++) {

		if ((Character.isWhitespace(str.charAt(i)) == false)) {

		return false;

		}

		}

		return true;

		}

		 

		public static String defaultString(String str) {

		return str == null ? "" : str;

		}

		 

		private static String md5Hex(byte[] bytes) {

		return new String(encodeHex(getMd5Digest().digest(bytes)));

		}

		 

		private static MessageDigest getMd5Digest() {

		try {

		return MessageDigest.getInstance("MD5");

		} catch (NoSuchAlgorithmException e) {

		throw new RuntimeException(e.getMessage());

		}

		}

		 

		public static char[] encodeHex(byte[] data) {

		 

		int l = data.length;

		char[] out = new char[l << 1];

		 

		// two characters form the hex value.

		for (int i = 0, j = 0; i < l; i++) {

		out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];

		out[j++] = DIGITS[0x0F & data[i]];

		}

		 

		return out;

		}

	/**

     * 新的md5签名，首尾放secret。

     * @param secret 分配给您的APP_SECRET

     */

     public static String md5Signature(TreeMap<String, String> params, String secret) {

             String result = null;

             StringBuffer orgin = getBeforeSign(params, new StringBuffer(secret));

             if (orgin == null)

             return result;

             orgin.append(secret);

             try {

                     MessageDigest md = MessageDigest.getInstance("MD5");

                     result = byte2hex(md.digest(orgin.toString().getBytes("utf-8")));

             } catch (Exception e) {

                     throw new java.lang.RuntimeException("sign error !");

             }

         return result;

     }

     /**

     * 二行制转字符串

     */

     private static String byte2hex(byte[] b) {

             StringBuffer hs = new StringBuffer();

             String stmp = "";

             for (int n = 0; n < b.length; n++) {

                     stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));

                     if (stmp.length() == 1)

                             hs.append("0").append(stmp);

                     else

                             hs.append(stmp);

             }

             return hs.toString().toUpperCase();

     }

     /**

     * 添加参数的封装方法

     */

     private static StringBuffer getBeforeSign(TreeMap<String, String> params, StringBuffer orgin) {

             if (params == null)

                     return null;

             Map<String, String> treeMap = new TreeMap<String, String>();

             treeMap.putAll(params);

             Iterator<String> iter = treeMap.keySet().iterator();

             while (iter.hasNext()) {

                     String name = (String) iter.next();

                     orgin.append(name).append(params.get(name));

             }

             return orgin;

     }

     /**连接到TOP服务器并获取数据*/

     public static String getResult(String urlStr, String content) {

             URL url = null;

             HttpURLConnection connection = null;



             try {

                     url = new URL(urlStr);

                     connection = (HttpURLConnection) url.openConnection();

                     connection.setDoOutput(true);

                     connection.setDoInput(true);

                     connection.setRequestMethod("POST");

                     connection.setUseCaches(false);

                     connection.connect();



                     DataOutputStream out = new DataOutputStream(connection.getOutputStream());

                     out.write(content.getBytes("utf-8"));

                     out.flush();

                     out.close();



                     BufferedReader reader =

                     new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));

                     StringBuffer buffer = new StringBuffer();

                     String line = "";

                     while ((line = reader.readLine()) != null) {

                             buffer.append(line);

                     }

                     reader.close();

                     return buffer.toString();

             } catch (IOException e) {

                     e.printStackTrace();

             } finally {

                     if (connection != null) {

                             connection.disconnect();

                     }

             }

             return null;

     }
}
