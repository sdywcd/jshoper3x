package com.jshop.action.backstage.utils.qiniu;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.PutPolicy;


/**
 * 七牛上传文件
* @ClassName: QiNiuUploadsFile 
* @Description: TODO
* @author sdywcd@gmail.com
* @date 2015年3月20日 下午12:22:47 
*
 */
public class QiNiuUploadFiles {

	public static int upLoads(String key,String localFile) throws AuthException, JSONException{
		Config.ACCESS_KEY = QiNiuConfig.ACCESS_KEY;
		Config.SECRET_KEY = QiNiuConfig.SECRET_KEY;
		Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
		PutPolicy putPolicy = new PutPolicy(QiNiuConfig.BUCKETNAME);
		String uptoken = putPolicy.token(mac);
		PutExtra extra = new PutExtra();
		PutRet ret = IoApi.putFile(uptoken, key, localFile, extra);
		int code=ret.getStatusCode();
		return code;
	}

	
}
