package com.jshop.action.backstage.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Namespace("")
@ParentPackage("jshop")
public class FileUploadTool extends ActionSupport {
	private boolean sucflag;
	private String filepath;

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public FileUploadTool() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 获取图片尺寸
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String collectImageFileWH(File file) throws IOException {
		BufferedImage bi = ImageIO.read(file);
		return bi.getWidth() + "*" + bi.getHeight();
	}

	/**
	 * 组合重命名后的文件名 传入项目名、当前时间、随机数、后缀、文件后缀名
	 * 
	 * @param projectname
	 * @param nowtime
	 * @param random
	 * @param aftertag
	 * @param extname
	 * @return
	 */
	public String collectMakeFileNameTag(String projectname, String nowtime, String random, String aftertag, String extname) {

		return extname;

	}

	/**
	 * 返回当前文件的后缀名
	 * 
	 * @param fileFileName
	 * @return
	 */
	public String collectFileExtName(String fileFileName) {
		String extName = ""; // 保存文件拓展名
		if (fileFileName != null) {
			if (fileFileName.lastIndexOf(".") >= 0) {
				extName = fileFileName.substring(fileFileName.lastIndexOf("."));
			}
		}
		return extName;

	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public String collectNowTime(String dateformate) {
		String nowTimeStr = ""; // 保存当前时间
		SimpleDateFormat sDateFormat = new SimpleDateFormat(dateformate); // 时间格式化的格式
		nowTimeStr = sDateFormat.format(new Date());
		return nowTimeStr;
	}

	/**
	 * 获取随机数
	 * 
	 * @return
	 */
	public int collectRandom() {
		Random r = new Random();
		int rannum = (int) (r.nextDouble() * (99999 - 10000 + 1)) + 10000; // 获取随机数
		return rannum;
	}

	/**
	 * 获取项目名
	 * 
	 * @param projectname
	 * @return
	 */
	public String collectProjectName(String projectname) {
		if (projectname != null) {
			return projectname;
		}
		return null;
	}

	// 检查是否是图片格式
	public boolean checkIsImage(String imgStr) {
		boolean flag = false;
		if (imgStr != null) {
			if (imgStr.equalsIgnoreCase(".gif") || imgStr.equalsIgnoreCase(".jpg") || imgStr.equalsIgnoreCase(".jpeg") || imgStr.equalsIgnoreCase(".png") || imgStr.equalsIgnoreCase(".bmp")) {
				flag = true;
			}
		}
		return flag;
	}

	// 检查是否是音频格式
	public boolean checkIsAudio(String audioStr) {
		boolean flag = false;
		if (audioStr != null) {
			if (audioStr.equalsIgnoreCase(".mid") || audioStr.equalsIgnoreCase(".wav") || audioStr.equalsIgnoreCase(".mp1") || audioStr.equalsIgnoreCase(".mp3") || audioStr.equalsIgnoreCase(".mp2") || audioStr.equalsIgnoreCase(".vqf") || audioStr.equalsIgnoreCase(".aif") || audioStr.equalsIgnoreCase("aiff") || audioStr.equalsIgnoreCase(".au") || audioStr.equalsIgnoreCase(".voc") || audioStr.equalsIgnoreCase(".ra") || audioStr.equalsIgnoreCase(".ram") || audioStr.equalsIgnoreCase(".rm") || audioStr.equalsIgnoreCase(".mod") || audioStr.equalsIgnoreCase(".s3m") || audioStr.equalsIgnoreCase(".xm") || audioStr.equalsIgnoreCase(".mtm") || audioStr.equalsIgnoreCase(".far") || audioStr.equalsIgnoreCase(".kar") || audioStr.equalsIgnoreCase(".it")) {
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * 检查是否为视频文件
	 * 
	 * @param vedioStr
	 * @return
	 */
	public boolean checkIsVedio(String vedioStr) {
		boolean flag = false;
		if (Validate.StrNotNull(vedioStr)) {
			if (vedioStr.equalsIgnoreCase(".avi") || vedioStr.equalsIgnoreCase(".mp4") || vedioStr.equalsIgnoreCase(".3gp") || vedioStr.equalsIgnoreCase(".mpg") || vedioStr.equalsIgnoreCase(".rmvb") || vedioStr.equalsIgnoreCase(".dat") || vedioStr.equalsIgnoreCase(".mpeg") || vedioStr.equalsIgnoreCase(".mpg") || vedioStr.equalsIgnoreCase(".miv") || vedioStr.equalsIgnoreCase(".mpe") || vedioStr.equalsIgnoreCase(".m2v") || vedioStr.equalsIgnoreCase(".vob") || vedioStr.equalsIgnoreCase(".mp4") || vedioStr.equalsIgnoreCase(".asf") || vedioStr.equalsIgnoreCase(".mov") || vedioStr.equalsIgnoreCase(".asf") || vedioStr.equalsIgnoreCase(".wmv") || vedioStr.equalsIgnoreCase(".rm") || vedioStr.equalsIgnoreCase(".flash") || vedioStr.equalsIgnoreCase(".flv")) {
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * 检测目录是否存在
	 * 
	 * @param projectname
	 *            表示有项目作为目录分割
	 * @param tag
	 *            =project表示通过项目分割目录。tag=time,表示通过时间分割目录
	 * @return
	 */

	public String makeFilePath(String basepath, String dirpath, String tag) {
		if (tag != null) {
			if ("project".equals(tag)) {
				String savedir = dirpath;
				String realpath = "";
				String savePath = "";
				savePath = basepath + savedir;
				File dir = new File(savePath);
				if (!dir.exists()) {
					dir.mkdirs();
					realpath = savedir;
					return realpath;
				} else {
					realpath = savedir;
					return realpath;
				}
			}
			if ("time".equals(tag)) {
				String nowTimeStr = this.collectNowTime(BaseTools.DATEFORMATEYMD);
				String savedir = "/Uploads/";
				String realpath = "";
				String savePath = "";
				savePath = basepath + savedir + nowTimeStr + "/";
				File dir = new File(savePath);
				if (!dir.exists()) {
					dir.mkdirs();
					realpath = savedir + nowTimeStr;
					return realpath;
				} else {
					realpath = savedir + nowTimeStr;
					return realpath;
				}
			}

		}
		return null;

	}

	/**
	 * 判断目录是否可写
	 * 
	 * @param dirPath
	 * @return
	 */
	public boolean isFileCanWrite(String dirPath) {
		if (dirPath != null) {
			File filedir = new File(dirPath);
			if (filedir.canWrite()) {
				return true;
			}
			return false;
		}
		return false;

	}

	/**
	 * 删除服务器上的文件
	 * 
	 * @param filepath
	 * @return
	 */
	@Action(value = "delFile", results = { @Result(type = "json", name = "json") })
	public String delServerFile() {
		String savePath = ServletActionContext.getServletContext().getRealPath("") + this.getFilepath();
		System.out.println(savePath);
		File file = new File(savePath);
		if (file.exists()) {
			if (file.delete()) {
				this.setSucflag(true);
				return "json";
			}
			this.setSucflag(false);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}

}
