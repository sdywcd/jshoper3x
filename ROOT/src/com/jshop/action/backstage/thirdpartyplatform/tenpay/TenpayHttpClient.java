package com.jshop.action.backstage.thirdpartyplatform.tenpay;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;



/**
 * �Ƹ�ͨhttp����https����ͨ�ſͻ���<br/>
 * ========================================================================<br/>
 * api˵����<br/>
 * setReqContent($reqContent),�����������ݣ�����post��get������get��ʽ�ṩ<br/>
 * getResContent(), ��ȡӦ������<br/>
 * setMethod(method),�������󷽷�,post����get<br/>
 * getErrInfo(),��ȡ������Ϣ<br/>
 * setCertInfo(certFile, certPasswd),����֤�飬˫��httpsʱ��Ҫʹ��<br/>
 * setCaInfo(caFile), ����CA����ʽδpem���������򲻼��<br/>
 * setTimeOut(timeOut)�� ���ó�ʱʱ�䣬��λ��<br/>
 * getResponseCode(), ȡ���ص�http״̬��<br/>
 * call(),������ýӿ�<br/>
 * getCharset()/setCharset(),�ַ����<br/>
 * 
 * ========================================================================<br/>
 *
 */
public class TenpayHttpClient {
	
	private static final String USER_AGENT_VALUE = 
		"Mozilla/4.0 (compatible; MSIE 6.0; Windows XP)";
	
	private static final String JKS_CA_FILENAME = 
		"tenpay_cacert.jks";
	
	private static final String JKS_CA_ALIAS = "tenpay";
	
	private static final String JKS_CA_PASSWORD = "";
	
	/** ca֤���ļ� */
	private File caFile;
	
	/** ֤���ļ� */
	private File certFile;
	
	/** ֤������ */
	private String certPasswd;
	
	/** �������ݣ�����post��get������get��ʽ�ṩ */
	private String reqContent;
	
	/** Ӧ������ */
	private String resContent;
	
	/** ���󷽷� */
	private String method;
	
	/** ������Ϣ */
	private String errInfo;
	
	/** ��ʱʱ��,����Ϊ��λ */
	private int timeOut;
	
	/** httpӦ����� */
	private int responseCode;
	
	/** �ַ���� */
	private String charset;
	
	private InputStream inputStream;
	
	public TenpayHttpClient() {
		this.caFile = null;
		this.certFile = null;
		this.certPasswd = "";
		
		this.reqContent = "";
		this.resContent = "";
		this.method = "POST";
		this.errInfo = "";
		this.timeOut = 30;//30��
		
		this.responseCode = 0;
		this.charset = "GBK";
		
		this.inputStream = null;
	}

	/**
	 * ����֤����Ϣ
	 * @param certFile ֤���ļ�
	 * @param certPasswd ֤������
	 */
	public void setCertInfo(File certFile, String certPasswd) {
		this.certFile = certFile;
		this.certPasswd = certPasswd;
	}
	
	/**
	 * ����ca
	 * @param caFile
	 */
	public void setCaInfo(File caFile) {
		this.caFile = caFile;
	}
	
	/**
	 * ������������
	 * @param reqContent ��������
	 */
	public void setReqContent(String reqContent) {
		this.reqContent = reqContent;
	}
	
	/**
	 * ��ȡ�������
	 * @return String
	 * @throws IOException 
	 */
	public String getResContent() {
		try {
			this.doResponse();
		} catch (IOException e) {
			this.errInfo = e.getMessage();
			//return "";
		}
		return this.resContent;
	}
	
	/**
	 * �������󷽷�post����get
	 * @param method ���󷽷�post/get
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	
	/**
	 * ��ȡ������Ϣ
	 * @return String
	 */
	public String getErrInfo() {
		return this.errInfo;
	}
	
	/**
	 * ���ó�ʱʱ��,����Ϊ��λ
	 * @param timeOut ��ʱʱ��,����Ϊ��λ
	 */
	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}
	
	/**
	 * ��ȡhttp״̬��
	 * @return int
	 */
	public int getResponseCode() {
		return this.responseCode;
	}
	
	/**
	 * ִ��http���á�true:�ɹ� false:ʧ��
	 * @return boolean
	 */
	public boolean call() {
		
		boolean isRet = false;
		
		//http
		if(null == this.caFile && null == this.certFile) {
			try {
				this.callHttp();
				isRet = true;
			} catch (IOException e) {
				this.errInfo = e.getMessage();
			}
			return isRet;
		}
		
		//https
		try {
			this.callHttps();
			isRet = true;
		} catch (UnrecoverableKeyException e) {
			this.errInfo = e.getMessage();
		} catch (KeyManagementException e) {
			this.errInfo = e.getMessage();
		} catch (CertificateException e) {
			this.errInfo = e.getMessage();
		} catch (KeyStoreException e) {
			this.errInfo = e.getMessage();
		} catch (NoSuchAlgorithmException e) {
			this.errInfo = e.getMessage();
		} catch (IOException e) {
			this.errInfo = e.getMessage();
		}
		
		return isRet;
		
	}
	
	protected void callHttp() throws IOException {
		
		if("POST".equals(this.method.toUpperCase())) {
			String url = HttpClientUtil.getURL(this.reqContent);
			String queryString = HttpClientUtil.getQueryString(this.reqContent);
			byte[] postData = queryString.getBytes(this.charset);
			this.httpPostMethod(url, postData);
			
			return ;
		}
		
		this.httpGetMethod(this.reqContent);
		
	} 
	
	protected void callHttps() throws IOException, CertificateException,
			KeyStoreException, NoSuchAlgorithmException,
			UnrecoverableKeyException, KeyManagementException {

		// caĿ¼
		String caPath = this.caFile.getParent();

		File jksCAFile = new File(caPath + "/"
				+ TenpayHttpClient.JKS_CA_FILENAME);
		if (!jksCAFile.isFile()) {
			X509Certificate cert = (X509Certificate) HttpClientUtil
					.getCertificate(this.caFile);

			FileOutputStream out = new FileOutputStream(jksCAFile);

			// store jks file
			HttpClientUtil.storeCACert(cert, TenpayHttpClient.JKS_CA_ALIAS,
					TenpayHttpClient.JKS_CA_PASSWORD, out);

			out.close();

		}

		FileInputStream trustStream = new FileInputStream(jksCAFile);
		FileInputStream keyStream = new FileInputStream(this.certFile);

		SSLContext sslContext = HttpClientUtil.getSSLContext(trustStream,
				TenpayHttpClient.JKS_CA_PASSWORD, keyStream, this.certPasswd);
		
		//�ر���
		keyStream.close();
		trustStream.close();
		
		if("POST".equals(this.method.toUpperCase())) {
			String url = HttpClientUtil.getURL(this.reqContent);
			String queryString = HttpClientUtil.getQueryString(this.reqContent);
			byte[] postData = queryString.getBytes(this.charset);
			
			this.httpsPostMethod(url, postData, sslContext);
			
			return ;
		}
		
		this.httpsGetMethod(this.reqContent, sslContext);

	}
	
	/**
	 * ��http post��ʽͨ��
	 * @param url
	 * @param postData
	 * @throws IOException
	 */
	protected void httpPostMethod(String url, byte[] postData)
			throws IOException {

		HttpURLConnection conn = HttpClientUtil.getHttpURLConnection(url);

		this.doPost(conn, postData);
	}
	
	/**
	 * ��http get��ʽͨ��
	 * 
	 * @param url
	 * @throws IOException
	 */
	protected void httpGetMethod(String url) throws IOException {
		
		HttpURLConnection httpConnection =
			HttpClientUtil.getHttpURLConnection(url);
		
		this.setHttpRequest(httpConnection);
		
		httpConnection.setRequestMethod("GET");
		
		this.responseCode = httpConnection.getResponseCode();
		
		this.inputStream = httpConnection.getInputStream();
		
	}
	
	/**
	 * ��https get��ʽͨ��
	 * @param url
	 * @param sslContext
	 * @throws IOException
	 */
	protected void httpsGetMethod(String url, SSLContext sslContext)
			throws IOException {

		SSLSocketFactory sf = sslContext.getSocketFactory();

		HttpsURLConnection conn = HttpClientUtil.getHttpsURLConnection(url);

		conn.setSSLSocketFactory(sf);

		this.doGet(conn);

	}
	
	protected void httpsPostMethod(String url, byte[] postData,
			SSLContext sslContext) throws IOException {

		SSLSocketFactory sf = sslContext.getSocketFactory();

		HttpsURLConnection conn = HttpClientUtil.getHttpsURLConnection(url);

		conn.setSSLSocketFactory(sf);

		this.doPost(conn, postData);

	}
	
	/**
	 * ����http����Ĭ������
	 * @param httpConnection
	 */
	protected void setHttpRequest(HttpURLConnection httpConnection) {
		
		//�������ӳ�ʱʱ��
		httpConnection.setConnectTimeout(this.timeOut * 1000);
		
		//User-Agent
		httpConnection.setRequestProperty("User-Agent", 
				TenpayHttpClient.USER_AGENT_VALUE);
		
		//��ʹ�û���
		httpConnection.setUseCaches(false);
		
		//�����������
		httpConnection.setDoInput(true);
		httpConnection.setDoOutput(true);
		
	}
	
	/**
	 * ����Ӧ��
	 * @throws IOException
	 */
	protected void doResponse() throws IOException {
		
		if(null == this.inputStream) {
			return;
		}
		
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(this.inputStream, this.charset) );
		
		//��ȡӦ������
		this.resContent = HttpClientUtil.bufferedReader2String(reader);
		
		//�ر���
		reader.close();
		
		//�ر�������
		this.inputStream.close();
		
	}
	
	/**
	 * post��ʽ����
	 * @param conn
	 * @param postData
	 * @throws IOException
	 */
	protected void doPost(HttpURLConnection conn, byte[] postData)
			throws IOException {

		// ��post��ʽͨ��
		conn.setRequestMethod("POST");

		// ��������Ĭ������
		this.setHttpRequest(conn);

		// Content-Type
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");

		BufferedOutputStream out = new BufferedOutputStream(conn
				.getOutputStream());

		final int len = 1024; // 1KB
		HttpClientUtil.doOutput(out, postData, len);

		// �ر���
		out.close();

		// ��ȡ��Ӧ����״̬��
		this.responseCode = conn.getResponseCode();

		// ��ȡӦ��������
		this.inputStream = conn.getInputStream();

	}
	
	/**
	 * get��ʽ����
	 * @param conn
	 * @throws IOException
	 */
	protected void doGet(HttpURLConnection conn) throws IOException {
		
		//��GET��ʽͨ��
		conn.setRequestMethod("GET");
		
		//��������Ĭ������
		this.setHttpRequest(conn);
		
		//��ȡ��Ӧ����״̬��
		this.responseCode = conn.getResponseCode();
		
		//��ȡӦ��������
		this.inputStream = conn.getInputStream();
	}

	
}
