package com.jshop.action.backstage.image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.json.annotations.JSON;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jshop.action.backstage.aspect.ImgTAspect;
import com.jshop.action.backstage.base.BaseTAction;
import com.jshop.action.backstage.utils.BaseTools;
import com.jshop.action.backstage.utils.FileUploadTool;
import com.jshop.action.backstage.utils.GsonJson;
import com.jshop.action.backstage.utils.ImgCutTools;
import com.jshop.action.backstage.utils.ServerFileInfo;
import com.jshop.action.backstage.utils.Validate;
import com.jshop.action.backstage.utils.config.GlobalParam;
import com.jshop.action.backstage.utils.config.ReadSysConfig;
import com.jshop.action.backstage.utils.qiniu.ImgFileBean;
import com.jshop.action.backstage.utils.qiniu.QiNiuConfig;
import com.jshop.action.backstage.utils.qiniu.QiNiuUploadFiles;
import com.jshop.action.backstage.utils.statickey.StaticKey;
import com.opensymphony.xwork2.ActionContext;
import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.PutPolicy;

@Namespace("")
@ParentPackage("jshop")
public class ImgTAction extends BaseTAction implements ServletResponseAware,
		ServletRequestAware {
	private static final Logger log = LoggerFactory.getLogger(ImgTAction.class);

	private static final long serialVersionUID = 1L;
	private final static String DIR = "Uploads";
	private final static String SVNDIR = ".svn";
	private File fileupload;
	private String fileuploadFileName;
	private String allfilename;
	private String qqfile;
	private String directoryname;
	private String filestrs;
	private HttpServletResponse response;
	private HttpServletRequest request;
	/**
	 * 保存服务器文件目录
	 */
	private List<ServerFileInfo> list = new ArrayList<ServerFileInfo>();
	private String query;
	private String qtype;
	private int total = 0;
	private int rp;
	private int page = 1;
	private List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
	private String creatorid;
	private String imgdirpath;
	/**
	 * 上传图片后保存的路径
	 */
	private String mNewImgPath;
	/**
	 * 图片文件保存的目录
	 */
	private String targetSavePath;
	/**
	 * 云存储文件名
	 */
	private String cloudFileKey;
	private String extName;// 文件后缀

	private boolean sucflag;

	public String getCloudFileKey() {
		return cloudFileKey;
	}

	public void setCloudFileKey(String cloudFileKey) {
		this.cloudFileKey = cloudFileKey;
	}

	public String getExtName() {
		return extName;
	}

	public void setExtName(String extName) {
		this.extName = extName;
	}

	public String getTargetSavePath() {
		return targetSavePath;
	}

	public void setTargetSavePath(String targetSavePath) {
		this.targetSavePath = targetSavePath;
	}

	public String getmNewImgPath() {
		return mNewImgPath;
	}

	public void setmNewImgPath(String mNewImgPath) {
		this.mNewImgPath = mNewImgPath;
	}

	public File getFileupload() {
		return fileupload;
	}

	public void setFileupload(File fileupload) {
		this.fileupload = fileupload;
	}

	public String getFileuploadFileName() {
		return fileuploadFileName;
	}

	public void setFileuploadFileName(String fileuploadFileName) {
		this.fileuploadFileName = fileuploadFileName;
	}

	public String getAllfilename() {
		return allfilename;
	}

	public void setAllfilename(String allfilename) {
		this.allfilename = allfilename;
	}

	@JSON(serialize = false)
	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	@JSON(serialize = false)
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getQqfile() {
		return qqfile;
	}

	public void setQqfile(String qqfile) {
		this.qqfile = qqfile;
	}

	public List<ServerFileInfo> getList() {
		return list;
	}

	public void setList(List<ServerFileInfo> list) {
		this.list = list;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public List<Map<String, Object>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String, Object>> rows) {
		this.rows = rows;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public boolean isSucflag() {
		return sucflag;
	}

	public void setSucflag(boolean sucflag) {
		this.sucflag = sucflag;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRp() {
		return rp;
	}

	public void setRp(int rp) {
		this.rp = rp;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getImgdirpath() {
		return imgdirpath;
	}

	public void setImgdirpath(String imgdirpath) {
		this.imgdirpath = imgdirpath;
	}

	public String getDirectoryname() {
		return directoryname;
	}

	public void setDirectoryname(String directoryname) {
		this.directoryname = directoryname;
	}

	public String getFilestrs() {
		return filestrs;
	}

	public void setFilestrs(String filestrs) {
		this.filestrs = filestrs;
	}

	/**
	 * 清理错误
	 */
	@Override
	public void validate() {
		this.clearErrorsAndMessages();

	}

	/**
	 * 读取服务器文件夹下得文件
	 */
	@Action(value = "readAllSeverDirectoryFile", results = { @Result(name = "json", type = "json") })
	public String readAllSeverDirectoryFile() {
		this.findDefaultDirectoryFile();
		return "json";

	}

	/**
	 * 获取服务器文件夹下文件
	 * 
	 * @return
	 */
	public void findDefaultDirectoryFile() {
		int currentPage = page;
		int lineSize = rp;
		if (Validate.StrNotNull(this.getDirectoryname())) {
			String savedir = "/" + DIR + File.separatorChar;
			String savePath = ServletActionContext.getServletContext()
					.getRealPath("");
			savePath = savePath + savedir + this.getDirectoryname()
					+ File.separatorChar;
			File file = new File(savePath);
			String[] filelist = file.list();
			SimpleDateFormat sDateFormat;
			sDateFormat = new SimpleDateFormat("yyyyMMddmmss");
			String nowTimeStr = "";
			if (list != null) {
				list.clear();
			}
			for (int i = 0; i < filelist.length; i++) {
				File f = new File(file.getPath(), filelist[i]);
				if (f.isFile() && !f.isHidden()) {
					nowTimeStr = sDateFormat.format(new Date(f.lastModified()));
					ServerFileInfo sfi = new ServerFileInfo();
					sfi.setDirectoryname(f.getName());
					sfi.setCreatetime(nowTimeStr);
					sfi.setImgfilepath(savedir + this.getDirectoryname() + "/"
							+ f.getName());
					list.add(sfi);
				}
			}
			if (list != null && list.size() > 0) {
				total = currentPage * lineSize > list.size() ? list.size()
						: currentPage * lineSize;
				list.subList((currentPage - 1) * lineSize, total);
				this.ProcessAllSeverDirectoryFile(list);
			}
		}
	}

	public void ProcessAllSeverDirectoryFile(List<ServerFileInfo> list) {
		rows.clear();
		for (Iterator<ServerFileInfo> it = list.iterator(); it.hasNext();) {
			ServerFileInfo sfi = (ServerFileInfo) it.next();
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", sfi.getDirectoryname());
			cellMap.put(
					"cell",
					new Object[] {
							"<img width='100px' height='100px' src='"
									+ BaseTools.getBasePath()
									+ sfi.getImgfilepath()
									+ "'/><br/><a target='_blank' href='"
									+ BaseTools.getBasePath()
									+ sfi.getImgfilepath() + "'>"
									+ sfi.getDirectoryname() + "</a>",
							sfi.getCreatetime() });
			rows.add(cellMap);
		}
	}

	/**
	 * 创建服务器目录
	 * 
	 * @return
	 */
	@Action(value = "createDirectory", results = { @Result(name = "json", type = "json") })
	public String createDirectory() {
		String savedir = "/" + DIR + File.separatorChar;
		String savePath = ServletActionContext.getServletContext().getRealPath(
				"");
		savePath = savePath + savedir + this.getImgdirpath()
				+ File.separatorChar;
		File dir = new File(savePath);
		if (!dir.exists()) {
			dir.mkdirs();
			this.setSucflag(true);
			return "json";
		} else {
			this.setSucflag(false);
			return "json";
		}
	}

	/**
	 * 检测目录是否存在
	 * 
	 * @return
	 */

	public String isexistdir() {
		String nowTimeStr = "";
		String savedir = DIR + "/";
		String realpath = "";
		SimpleDateFormat sDateFormat;
		sDateFormat = new SimpleDateFormat("yyyyMMdd");
		nowTimeStr = sDateFormat.format(new Date());
		String savePath = ServletActionContext.getServletContext().getRealPath(
				"/");
		savePath = savePath + savedir + nowTimeStr + "/";
		File dir = new File(savePath);
		if (!dir.exists()) {
			dir.mkdirs();
			realpath = savedir + nowTimeStr + "/";
			return realpath;
		} else {
			realpath = savedir + nowTimeStr + "/";
			return realpath;
		}
	}

	/**
	 * 异步图片
	 * 
	 * @throws JSONException
	 * @throws AuthException
	 * 
	 * @throws IOException
	 */
	@Action(value = "ajaxFileUploads", results = { @Result(name = "json", type = "json") })
	public String ajaxFileUploads() throws JSONException, AuthException {
		String extName=StaticKey.EMPTY;
		String newFilename = StaticKey.EMPTY;
		String nowTimeStr = StaticKey.EMPTY;
		String realpath = StaticKey.EMPTY;
		if (Validate.StrNotNull(this.getImgdirpath())) {
			realpath = DIR + "/" + this.getImgdirpath() + "/";
		} else {
			realpath = this.isexistdir();
		}
		SimpleDateFormat sDateFormat;
		Random r = new Random();
		String savePath = ServletActionContext.getServletContext().getRealPath(
				"/");
		savePath = savePath + realpath;
		HttpServletResponse response = ServletActionContext.getResponse();
		int rannum = (int) (r.nextDouble() * (99999 - 1000 + 1)) + 10000;
		sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		nowTimeStr = sDateFormat.format(new Date());
		String filename = request.getHeader(StaticKey.X_FILE_NAME);
		if (filename.lastIndexOf(StaticKey.DOT) >= 0) {
			extName = filename.substring(filename.lastIndexOf(StaticKey.DOT));
		}
		newFilename = nowTimeStr + rannum + extName;
		PrintWriter writer = null;
		InputStream is = null;
		FileOutputStream fos = null;
		try {
			writer = response.getWriter();
			is = request.getInputStream();
			fos = new FileOutputStream(new File(savePath + newFilename));
			IOUtils.copy(is, fos);
			
			ImgFileBean ifb=new ImgFileBean();
			String localFile = savePath + newFilename;// 已上传到本地的图片路径
			String cloudFileKey = realpath + newFilename;// 云上的文件名称
			String compressLocalFile=StaticKey.EMPTY;//已上传到本地的压缩图片路径
			String compresscloudFileKey=StaticKey.EMPTY;//云上的压缩文件名称
			Properties p = ReadSysConfig.getJConfig();
			// 检测是否启用云存储图片
			String issaveimgtocloud = p.getProperty(
					GlobalParam.ISSAVEIMGTOCLOUD, StaticKey.ZERO);
			if (StringUtils.equals(issaveimgtocloud, StaticKey.ONE)) {
				int code = QiNiuUploadFiles.upLoads(localFile, cloudFileKey);
				if (200 == code) {
					response.setStatus(HttpServletResponse.SC_OK);
					//writeFileInfo="{success:'" + QiNiuConfig.QINIUIMGHOST+ cloudFileKey + "'}";
					ifb.setSucflag(true);
					ifb.setCloudImg(true);
					ifb.setNormalfilepath(QiNiuConfig.QINIUIMGHOST+ cloudFileKey);
				}
			}else if(StringUtils.equals(issaveimgtocloud, StaticKey.ZERO)){
				//如果不启用云存储表示本地存储
				ifb.setSucflag(true);
				ifb.setNormalfilepath(localFile);
			}
			boolean isImg=ImgCutTools.checkIsImg(extName);
			if(isImg){
				//检测是否需要压缩图片
				String isimagecompression = p.getProperty(
						GlobalParam.ISIMAGECOMPRESSION, StaticKey.ZERO);
				if (isimagecompression.equals(StaticKey.ONE)) {
					// 只有当开启压缩时才执行压缩方法并保存缩略图
					int width = Integer.parseInt(p.getProperty(
							GlobalParam.THUMBNAILWIDTH,
							GlobalParam.DEFAULTWIDTH));
					int height = Integer.parseInt(p.getProperty(
							GlobalParam.THUMBNAILHEIGHT,
							GlobalParam.DEFAULTHEIGHT));
					compressLocalFile=ImgCutTools.compressImages(localFile, savePath,
							width, height);
					compresscloudFileKey=newFilename+ "_" + String.valueOf(width) + "_"
							+ String.valueOf(height) + extName;
					if(compressLocalFile!=null){
						if (StringUtils.equals(issaveimgtocloud, StaticKey.ONE)) {
							//调用七牛云存储，存储压缩后的图片
							int code = QiNiuUploadFiles.upLoads(compressLocalFile, compresscloudFileKey);
							if (200 == code) {
								ifb.setSucflag(true);
								ifb.setCloudImg(true);
								ifb.setCompressfilepath(QiNiuConfig.QINIUIMGHOST+ compresscloudFileKey);
							}
						}else if(StringUtils.equals(issaveimgtocloud, StaticKey.ZERO)){
							ifb.setSucflag(true);
							ifb.setCompressfilepath(compressLocalFile);
						}
					}
				}
				// 检测是否本地保存原图，如果不保存原图意味着删除本地图片
				String issaveoriginalbitmap = p.getProperty(
						GlobalParam.ISSAVEORIGINALBITMAP, StaticKey.ZERO);
				if (StringUtils.equals(issaveoriginalbitmap, StaticKey.ZERO)) {
					//删除本地原图
					File file = new File(localFile);
					if (file != null) {
						if (file.exists() && file.isFile() && !file.isHidden()) {
							file.delete();
						}
					}
					//删除本地压缩图
					File compressFile=new File(compressLocalFile);
					if (compressFile != null) {
						if (compressFile.exists() && compressFile.isFile() && !compressFile.isHidden()) {
							compressFile.delete();
						}
					}
				}
			}
			writer.print(GsonJson.parseDataToJson(ifb));
		} catch (FileNotFoundException ex) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			writer.print("{success: false}");
			log.debug(ImgTAction.class.getName() + "has thrown an exception: "
					+ ex.getMessage());
		} catch (IOException ex) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			writer.print("{success: false}");
			log.debug(ImgTAction.class.getName() + "has thrown an exception: "
					+ ex.getMessage());
		} finally {
			try {
				this.setImgdirpath(null);
				if (fos != null) {
					fos.close();
				}
				if (is != null) {
					is.close();
				}
				if(writer!=null){
					writer.flush();
					writer.close();
				}
			} catch (IOException e) {
				log.debug(ImgTAction.class.getName() + "has thrown an exception:"
						+ e.getMessage());
			}
		}
		return JSON;
	}

	/**
	 * 读取服务器文件
	 */
	@Action(value = "readAllSeverDirectory", results = { @Result(name = "json", type = "json") })
	public String readAllSeverDirectory() {
		if (StaticKey.SC.equals(this.getQtype())) {
			this.findDefaultAllSeverDirectory();
			return "json";
		} else {
			if (Validate.StrisNull(this.getQuery())) {
				return "json";
			} else {
				return "json";
			}
		}
	}

	public void findDefaultAllSeverDirectory() {
		int currentPage = page;
		int lineSize = rp;
		String savedir = "/" + DIR + "/";
		String savePath = ServletActionContext.getServletContext().getRealPath(
				"/");
		savePath = savePath + savedir;
		File file = new File(savePath);
		String[] filelist = file.list();
		SimpleDateFormat sDateFormat;
		sDateFormat = new SimpleDateFormat("yyyyMMddmmss");
		String nowTimeStr = StaticKey.EMPTY;
		List<ServerFileInfo> list=new ArrayList<ServerFileInfo>();
		if(filelist!=null){
			for (int i = 0; i < filelist.length; i++) {
				File f = new File(file.getPath(), filelist[i]);
				if (f.isDirectory() && !f.getName().equals(SVNDIR) && !f.isHidden()) {
					String filecount[] = f.list();
					nowTimeStr = sDateFormat.format(new Date(f.lastModified()));
					ServerFileInfo sfi = new ServerFileInfo();
					sfi.setDirectoryname(f.getName());
					sfi.setCreatetime(nowTimeStr);
					sfi.setCount(filecount.length);
					list.add(sfi);
				}
			}
		}
		if (list != null && list.size() > 0) {
			total = currentPage * lineSize > list.size() ? list.size()
					: currentPage * lineSize;
			list.subList((currentPage - 1) * lineSize, total);
			this.ProcessAllSeverDirectory(list);
		}
	}

	public void ProcessAllSeverDirectory(List<ServerFileInfo> list) {
		rows.clear();
		for (Iterator<ServerFileInfo> it = list.iterator(); it.hasNext();) {
			ServerFileInfo sfi = (ServerFileInfo) it.next();
			Map<String, Object> cellMap = new HashMap<String, Object>();
			cellMap.put("id", sfi.getDirectoryname());
			cellMap.put("cell", new Object[] {
					"<a href='imagematerialfolderlistment.jsp?directoryname="
							+ sfi.getDirectoryname() + "&folder=images" + "'>"
							+ sfi.getDirectoryname() + "</a>", sfi.getCount(),
					sfi.getCreatetime() });
			rows.add(cellMap);
		}
	}

	/**
	 * 删除服务器端文件
	 */
	@Action(value = "delServerDirectoryFile", results = { @Result(name = "json", type = "json") })
	public String delServerDirectoryFile() {
		String savedir = "/"+DIR+"/";
		String savePath = ServletActionContext.getServletContext().getRealPath(
				"/");
		if (Validate.StrNotNull(this.getDirectoryname())) {
			String dirs[]=StringUtils.split(this.getDirectoryname(), StaticKey.SPLITDOT);
			for (int i = 0; i < dirs.length; i++) {
				savePath = savePath + savedir + dirs[i] + "/";
				File file = new File(savePath);
				if (file.exists()) {
					String[] filelist = file.list();
					if(filelist!=null){
						for (int j = 0; j < filelist.length; j++) {
							File f = new File(file.getPath(), filelist[j]);
							if (f.exists() && f.isFile() && !f.isHidden()) {
								f.delete();
							}
						}
					}
					file.delete();
				}
			}

			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}

	/**
	 * 删除服务器上单个文件
	 * 
	 * @return
	 */
	@Action(value = "delServerFile", results = { @Result(name = "json", type = "json") })
	public String delServerFile() {
		String savedir = "/" + DIR + "/";
		String savePath = ServletActionContext.getServletContext().getRealPath(
				"/");
		if (Validate.StrNotNull(this.getFilestrs())) {
			String dir = this.getDirectoryname().trim();
			String files[] = this.getFilestrs().split(",");
			for (int i = 0; i < files.length; i++) {
				savePath = savePath + savedir + dir + File.separatorChar
						+ files[i];
				File f = new File(savePath);
				if (f.exists() && f.isFile() && !f.isHidden()) {
					f.delete();
				}
			}
			this.setSucflag(true);
			return "json";
		}
		this.setSucflag(false);
		return "json";
	}

	/**
	 * 增加图片数据
	 * 
	 * @return
	 */
	// @Action(value = "addImgTWhenEdit", results = { @Result(name = "json",
	// type = "json") })
	// public String addImgTWhenEdit(Map<String, Object> imgVal) {
	// ImgT img = new ImgT();
	// img.setImgId(this.getSerial().Serialid(Serial.IMG));
	// img.setImgName(imgVal.get("imgName").toString());
	// img.setImgType(imgVal.get("imgType").toString());
	// img.setImgHref(imgVal.get("imgHref").toString());
	// img.setUsedGoodsid(imgVal.get("usedGoodsid").toString());
	// img.setUsedGoodsname(imgVal.get("usedGoodsname").toString());
	// img.setState(imgVal.get("state").toString());
	// img.setCreatetime(BaseTools.systemtime());
	// img.setCreatorid(BaseTools.adminCreateId());
	// if (this.getImgTServiceImpl().addImgT(img) > 0) {
	// return "json";
	// }
	// return "json";
	// }

	/**
	 * 增加图片数据
	 * 
	 * @return
	 */
	// @Action(value = "addImgTWhenInsert", results = { @Result(name = "json",
	// type = "json") })
	// public String addImgTWhenInsert(Map<String, Object> imgVal) {
	// ImgT img = new ImgT();
	// img.setImgId(this.getSerial().Serialid(Serial.IMG));
	// img.setImgName(imgVal.get("imgName").toString());
	// img.setImgType(imgVal.get("imgType").toString());
	// img.setImgHref(imgVal.get("imgHref").toString());
	// img.setState(imgVal.get("state").toString());
	// img.setCreatetime(BaseTools.systemtime());
	// img.setCreatorid(BaseTools.adminCreateId());
	// if (this.getImgTServiceImpl().addImgT(img) > 0) {
	// return "json";
	// }
	// return "json";
	// }

	/**
	 * 检测图片是否已经在图片表中
	 * 
	 * @param imgName
	 * @return
	 */

	// public ImgT findImgTByImgName(String imgName) {
	// bean = this.getImgTServiceImpl().findImgTByImgName(imgName);
	// if (bean != null) {
	// return bean;
	// }
	// return null;
	// }

	/**
	 * 删除图片
	 * 
	 * @return
	 */
	// @Action(value = "delImgT", results = { @Result(name = "json", type =
	// "json") })
	// public String delImgT() {
	// String imgId = this.getImgId() + ",";
	// String[] array = imgId.split(",");
	// //检测是否已经存在引用关系
	// List<ImgT> list =
	// this.getImgTServiceImpl().findImgTByusedGoodsidandusedPositionId(this.getImgId());
	// if (list != null) {
	// for (Iterator it = list.iterator(); it.hasNext();) {
	// ImgT i = (ImgT) it.next();
	// if (i.getUsedGoodsid() == null && i.getUsedPositionId() == null) {
	// ServerFileDel.Del(this.getImgHref());
	// this.getImgTServiceImpl().delImgT(array);
	// this.setSucflag(true);
	// return "json";
	// }
	// }
	// }
	// this.setSucflag(false);
	// return "json";
	//
	// }

	/**
	 * 根据被商品引用id获取数据
	 * 
	 * @return
	 */
	// public List<ImgT> findImgTByusedGoodsid(String usedGoodsid) {
	// List<ImgT> list =
	// this.getImgTServiceImpl().findImgTByusedGoodsid(usedGoodsid);
	// if (list != null) {
	// return list;
	// }
	// return null;
	// }

	/**
	 * 获取被商品引用但是未被自定义引用的图片
	 * 
	 * @return
	 */
	// public List<ImgT> findImgTByusedGoodsidandPositionIdisNull(String
	// usedGoodsid) {
	// List<ImgT> list =
	// this.getImgTServiceImpl().findImgTByusedGoodsidandPositionIdisNull(usedGoodsid);
	// if (list != null) {
	// return list;
	// }
	// return null;
	// }

	/**
	 * 更新商品图片状态
	 * 
	 * @param imgId
	 * @param state
	 */
	// public void updateImgState(String imgId, String state) {
	// this.getImgTServiceImpl().updateImgState(imgId, state);
	// }

	/**
	 * 获取图片引用关系
	 * 
	 * @return
	 */
	// @Action(value = "findimgShip", results = { @Result(name = "json", type =
	// "json") })
	// public String findimgShip() {
	//
	// if (this.getQtype().equals("sc")) {
	//
	// this.findDefaultAllImgTByImgName(this.getImgName());
	// } else {
	// if (Validate.StrisNull(this.getQuery())) {
	// return "json";
	// } else {
	// return "json";
	// }
	// }
	//
	// return "json";
	// }

	// public void findDefaultAllImgTByImgName(String imgName) {
	// int currentPage = page;
	// int lineSize = rp;
	// total = this.getImgTServiceImpl().countfindAllImgTByImgName(imgName);
	// if (Validate.StrNotNull(sortname) && Validate.StrNotNull(sortorder)) {
	// String queryString = "from ImgT order by " + sortname + " " + sortorder +
	// "";
	// List<ImgT> list = this.getImgTServiceImpl().sortAllImgT(currentPage,
	// lineSize, queryString);
	// if (list != null) {
	// this.ProcessImgTList(list);
	// }
	// }
	// }
	//
	// public void ProcessImgTList(List<ImgT> list) {
	// rows.clear();
	// for (Iterator it = list.iterator(); it.hasNext();) {
	// ImgT itt = (ImgT) it.next();
	// Map<String, Object> cellMap = new HashMap<String, Object>();
	// cellMap.put("id", itt.getImgId());
	// cellMap.put("cell", new Object[] {
	// "<input id='id' name='firstcol' class='firstimgtid' type='checkbox' value='"
	// + itt.getImgId() + "'/>",
	// "<a target='_blank' href='GetGoodsdetailBygoodsid.action?goodsid=" +
	// itt.getUsedGoodsid() + "'>" + itt.getUsedGoodsname() + "</a>",
	// itt.getUsedPositionName() });
	// rows.add(cellMap);
	// }
	//
	// }
}
