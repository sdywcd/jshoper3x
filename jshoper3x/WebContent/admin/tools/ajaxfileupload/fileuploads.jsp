<%@page import="com.itextpdf.text.log.SysoLogger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.io.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="org.apache.commons.fileupload.disk.*"%>
<%@ page import="org.apache.commons.fileupload.servlet.*"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page
	import="org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper"%>
<%@ page import="org.json.simple.*"%>
<%@ page import="com.jshop.action.backstage.utils.FileUploadTool"%>
<%@ page import="com.jshop.action.backstage.utils.BaseTools"%>
<%
	String patha = request.getContextPath();

	String basePatha = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + patha;
%>
<!-- 
用户图片上传和文件上传
formfileid=页面上file类型的表单id
dirtag=页面上文件尺寸标记
 -->
<%
	byte[] buffer = new byte[1024];
	//Struts2 请求 包装过滤器
	MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper) request;
	FileUploadTool ft = new FileUploadTool();
	//获取页面上传递过来的formfiledid和dirtag
	String formfileid = request.getParameter("formfileid");
	String clientName = request.getParameter("clientName");
	//String buildingProgramId = request
	//.getParameter("buildingProgramId");
	//String dirtag = request.getParameter("dirtag");
	String sourceType = request.getParameter("sourceType");
	String fileType = request.getParameter("fileType");
	String appfileType = request.getParameter("appfileType");
	String dir = request.getParameter("dir");
	int rannum = 0;//随机数
	String nowTimeStr = "";//保存当前时间
	String extName = "";//保存文件扩展名
	String newFileName = "";//保存新的文件名
	String savePath = "";//保存文件的路径
	String filePath = "";//文件全路径
	String fileSrc = "";//用于前台显示的src
	String filesavehref = "";//前台文件保存相对地址
	String fileWH = "";//图片原始尺寸
	String backmsg = "";//建立结果信息反馈字段
	String files[];
	files = wrapper.getFileNames(formfileid);
	if (formfileid != null && files != null) {
		String fileName = wrapper.getFileNames(formfileid)[0]; //获得上传的文件名
		//获得文件过滤器
		File file = wrapper.getFiles(formfileid)[0];
		extName = ft.collectFileExtName(fileName);
		if ("image".equals(fileType)) {
			if ("watermark".equals(sourceType)) {
				String basePath = request.getSession().getServletContext().getRealPath("") + File.separator + dir;//文件保存目录路径
				String dirPath = File.separator + sourceType + File.separator;//获取有资源类型定义的保存目录
				String path = ft.makeFilePath(basePath, dirPath, "project");
				savePath = basePath + path;//不包含文件名的保存路径
				nowTimeStr = ft.collectNowTime(BaseTools.DATEFORMATEYMDHMS);//获取当前时间
				rannum = ft.collectRandom();//获取一个随机数
				newFileName = nowTimeStr + rannum + extName;// 文件重命名后的名字
				filePath = savePath + newFileName;//组合完整的路径
				//filePath = filePath.replace("//", "/");//替换路径中的符号
				//获取文件输出流
				FileOutputStream fos = new FileOutputStream(filePath);
				//获取内存中当前文件输入流
				InputStream in = new FileInputStream(file);
				try {
					int num = 0;
					while ((num = in.read(buffer)) > 0) {
						fos.write(buffer, 0, num);
					}
				} catch (Exception e) {
					e.printStackTrace(System.err);
				} finally {
					in.close();
					fos.close();
				}
				fileSrc = basePatha + File.separator + dir + path + newFileName;
				filesavehref = File.separator + dir + dirPath + newFileName;

			} else {
				if (ft.checkIsImage(extName)) {
					fileWH = ft.collectImageFileWH(file);
					String basePath = request.getSession().getServletContext().getRealPath("") + File.separator + dir;//文件保存目录路径
					String dirPath = File.separator + clientName + File.separator + appfileType + File.separator;//获取由程序编号+图片大小标记组成的保存路径
					String path = ft.makeFilePath(basePath, dirPath, "project");//判断是否已经建立了目录有返回，无责新建，project表示根据项目建立目录
					savePath = basePath + path;//不包含文件名的保存路径
					nowTimeStr = ft.collectNowTime(BaseTools.DATEFORMATEYMDHMS);//获取当前时间
					rannum = ft.collectRandom();//获取一个随机数
					newFileName = nowTimeStr + rannum + extName;// 文件重命名后的名字
					filePath = savePath + newFileName;//组合完整的路径
					//filePath = filePath.replace("//", "/");//替换路径中的符号
					//获取文件输出流
					FileOutputStream fos = new FileOutputStream(filePath);
					//获取内存中当前文件输入流
					InputStream in = new FileInputStream(file);
					try {
						int num = 0;
						while ((num = in.read(buffer)) > 0) {
							fos.write(buffer, 0, num);
						}
					} catch (Exception e) {
						e.printStackTrace(System.err);
					} finally {
						in.close();
						fos.close();
					}
					fileSrc = basePatha + File.separator + dir + path + newFileName;
					filesavehref = File.separator + dir + dirPath + newFileName;

				}
			}
		}

		if ("file".equals(fileType)) {
			fileWH = ft.collectImageFileWH(file);
			String basePath = request.getSession().getServletContext().getRealPath("") + File.separator + dir + File.separator + clientName + File.separator;
			;//文件保存目录路径
			String dirPath = File.separator + clientName + File.separator + appfileType + File.separator;//获取由程序编号+图片大小标记组成的保存路径
			String path = ft.makeFilePath(basePath, dirPath, "project");//判断是否已经建立了目录有返回，无责新建，project表示根据项目建立目录
			savePath = basePath + path;//不包含文件名的保存路径
			nowTimeStr = ft.collectNowTime(BaseTools.DATEFORMATEYMDHMS);//获取当前时间
			rannum = ft.collectRandom();//获取一个随机数
			newFileName = nowTimeStr + rannum + extName;// 文件重命名后的名字
			filePath = savePath + newFileName;//组合完整的路径
			//filePath = filePath.replace("//", "/");//替换路径中的符号
			//获取文件输出流
			FileOutputStream fos = new FileOutputStream(filePath);
			//获取内存中当前文件输入流
			InputStream in = new FileInputStream(file);
			try {
				int num = 0;
				while ((num = in.read(buffer)) > 0) {
					fos.write(buffer, 0, num);
				}
			} catch (Exception e) {
				e.printStackTrace(System.err);
			} finally {
				in.close();
				fos.close();
			}
			fileSrc = basePatha + dir + path + newFileName;
			filesavehref = File.separator + dir + dirPath + newFileName;
		}
		if ("audio".equals(fileType)) {
			if (ft.checkIsAudio(extName)) {
				String basePath = request.getSession().getServletContext().getRealPath("") + File.separator + dir + File.separator + clientName + File.separator;
				;//文件保存目录路径
				String dirPath = File.separator + clientName + File.separator + appfileType + File.separator;//获取由程序编号+图片大小标记组成的保存路径
				String path = ft.makeFilePath(basePath, dirPath, "project");//判断是否已经建立了目录有返回，无责新建，project表示根据项目建立目录
				savePath = basePath + path;//不包含文件名的保存路径
				nowTimeStr = ft.collectNowTime(BaseTools.DATEFORMATEYMDHMS);//获取当前时间
				rannum = ft.collectRandom();//获取一个随机数
				newFileName = nowTimeStr + rannum + extName;// 文件重命名后的名字
				filePath = savePath + newFileName;//组合完整的路径
				//filePath = filePath.replace("//", "/");//替换路径中的符号
				//获取文件输出流
				FileOutputStream fos = new FileOutputStream(filePath);
				//获取内存中当前文件输入流
				InputStream in = new FileInputStream(file);
				try {
					int num = 0;
					while ((num = in.read(buffer)) > 0) {
						fos.write(buffer, 0, num);
					}
				} catch (Exception e) {
					e.printStackTrace(System.err);
				} finally {
					in.close();
					fos.close();
				}

				fileSrc = basePatha + File.separator + dir + path + newFileName;
				filesavehref = File.separator + dir + dirPath + newFileName;
			}
		}
		if ("vedio".equals(fileType)) {
			if (ft.checkIsVedio(extName)) {
				String basePath = request.getSession().getServletContext().getRealPath("") + File.separator + dir + File.separator + clientName + File.separator;//文件保存目录路径
				String dirPath = File.separator + clientName + File.separator + appfileType + File.separator;//获取由程序编号+图片大小标记组成的保存路径
				String path = ft.makeFilePath(basePath, dirPath, "project");//判断是否已经建立了目录有返回，无责新建，project表示根据项目建立目录
				savePath = basePath + path;//不包含文件名的保存路径
				nowTimeStr = ft.collectNowTime(BaseTools.DATEFORMATEYMDHMS);//获取当前时间
				rannum = ft.collectRandom();//获取一个随机数
				newFileName = nowTimeStr + rannum + extName;// 文件重命名后的名字
				filePath = savePath + newFileName;//组合完整的路径
				//filePath = filePath.replace("//", "/");//替换路径中的符号
				//获取文件输出流
				FileOutputStream fos = new FileOutputStream(filePath);
				//获取内存中当前文件输入流
				InputStream in = new FileInputStream(file);
				try {
					int num = 0;
					while ((num = in.read(buffer)) > 0) {
						fos.write(buffer, 0, num);
					}
				} catch (Exception e) {
					e.printStackTrace(System.err);
				} finally {
					in.close();
					fos.close();
				}
				fileSrc = basePatha + File.separator + dir + path + newFileName;
				filesavehref = File.separator + dir + dirPath + newFileName;
			}
		}
	} else {
		backmsg = "无法获取页面文件域";
	}
	
	//fileSrc = fileSrc.replaceAll("\\\\", "/");
	JSONObject obj = new JSONObject();
	obj.put("error", 0);
	obj.put("fileSrc", fileSrc);
	obj.put("fileWH", fileWH);
	obj.put("filesavehref", filesavehref);
	obj.put("backmsg", backmsg);
	out.println(obj.toJSONString());
%>

