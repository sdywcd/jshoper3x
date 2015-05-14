package com.jshop.action.mall.backstage.utils.qiniu;

/**
 * 图片上传结果返回内容实体
* @ClassName: ImgFileBean 
* @Description: TODO
* @author sdywcd@gmail.com
* @date 2015年3月23日 下午3:27:20 
*
 */
public class ImgFileBean {

	private boolean sucflag;
	private boolean isCloudImg;
	private String normalfilepath;
	private String compressfilepath;
	
	public boolean isCloudImg() {
		return isCloudImg;
	}
	public void setCloudImg(boolean isCloudImg) {
		this.isCloudImg = isCloudImg;
	}
	public boolean isSucflag() {
		return sucflag;
	}
	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}
	public String getNormalfilepath() {
		return normalfilepath;
	}
	public void setNormalfilepath(String normalfilepath) {
		this.normalfilepath = normalfilepath;
	}
	public String getCompressfilepath() {
		return compressfilepath;
	}
	public void setCompressfilepath(String compressfilepath) {
		this.compressfilepath = compressfilepath;
	}
	
	
}
