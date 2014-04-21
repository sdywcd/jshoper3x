package com.jshop.action.backstage.pay.thirdpartyplatform.alifh;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;


public class AlipayService {

	public static String CreateUrl(String partner,
			String trade_no,
			String logistics_name,
			String invoice_no,
			String transport_type,
			String seller_ip,
            String input_charset,
            String key,
            String sign_type){
		Map sPara = new HashMap();
		sPara.put("service","send_goods_confirm_by_platform");
		sPara.put("partner", partner);
		sPara.put("trade_no", trade_no);
		sPara.put("logistics_name", logistics_name);
		sPara.put("invoice_no", invoice_no);
		sPara.put("transport_type", transport_type);
		sPara.put("seller_ip", seller_ip);
		sPara.put("_input_charset", input_charset);
		
		String strUrl = "https://www.alipay.com/cooperate/gateway.do?";
		Map sParaNew = AlipayBase.ParaFilter(sPara);
		String mysign = AlipayBase.BuildMysign(sParaNew, key);
		String arg = AlipayBase.CreateLinkString_urlencode(sParaNew, input_charset);
		strUrl = strUrl + arg + "sign=" + mysign + "&sign_type=" + sign_type;
		
		return strUrl;
	}
	

	public static String BuildPostform(String partner,
			String trade_no,
			String logistics_name,
			String invoice_no,
			String transport_type,
			String seller_ip,
            String input_charset,
            String key,
            String sign_type){
		Map sPara = new HashMap();
		sPara.put("service","send_goods_confirm_by_platform");
		sPara.put("partner", partner);
		sPara.put("trade_no", trade_no);
		sPara.put("logistics_name", logistics_name);
		sPara.put("invoice_no", invoice_no);
		sPara.put("transport_type", transport_type);
		sPara.put("seller_ip", seller_ip);
		sPara.put("_input_charset", input_charset);
		
		Map sParaNew = AlipayBase.ParaFilter(sPara);
		String mysign = AlipayBase.BuildMysign(sParaNew, key);
		
		StringBuffer sbHtml = new StringBuffer();
		List keys = new ArrayList(sParaNew.keySet());
		String gateway = "https://www.alipay.com/cooperate/gateway.do?";
		
		sbHtml.append("<form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\"" + gateway + "_input_charset=" + input_charset + "\" method=\"post\">");
		for (int i = 0; i < keys.size(); i++) {
			String name = (String) keys.get(i);
			String value = (String) sParaNew.get(name);
			
			sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
		}
        sbHtml.append("<input type=\"hidden\" name=\"sign\" value=\"" + mysign + "\"/>");
        sbHtml.append("<input type=\"hidden\" name=\"sign_type\" value=\"" + sign_type + "\"/></form>");
        
        sbHtml.append("<input type=\"button\" name=\"v_action\" value=\"֧��������\" onClick=\"document.forms['alipaysubmit'].submit();\">");
		
		return sbHtml.toString();
	}
}
