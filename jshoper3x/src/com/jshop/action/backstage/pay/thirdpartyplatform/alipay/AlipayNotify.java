package com.jshop.action.backstage.pay.thirdpartyplatform.alipay;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;


public class AlipayNotify {
	
	public static String GetMysign(Map Params, String key){
		Map sParaNew = AlipayFunction.ParaFilter(Params);//���˿�ֵ��sign��sign_type����
		String mysign = AlipayFunction.BuildMysign(sParaNew, key);//���ǩ����
		
		return mysign;
	}
	
	
	public static String Verify(String notify_id){
		
		String transport = AlipayConfig.transport;
		String partner = AlipayConfig.partner;
		String veryfy_url = "";
		if(transport.equalsIgnoreCase("https")){
			veryfy_url = "https://www.alipay.com/cooperate/gateway.do?service=notify_verify";
		} else{
			veryfy_url = "http://notify.alipay.com/trade/notify_query.do?";
		}
		veryfy_url = veryfy_url + "&partner=" + partner + "&notify_id=" + notify_id;
		
		String responseTxt = CheckUrl(veryfy_url);
		
		return responseTxt;
	}
	

	public static String CheckUrl(String urlvalue){
		String inputLine = "";

		try {
			URL url = new URL(urlvalue);
			HttpURLConnection urlConnection = (HttpURLConnection) url
					.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					urlConnection.getInputStream()));
			inputLine = in.readLine().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return inputLine;
	}
}
