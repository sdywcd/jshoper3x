package com.jshop.action.backstage.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;

/**
 * 图片裁剪
 * 
 * @author sdywcd
 * 
 */
public class ImgCutTools {

	public static void compressImages(String needCutImgPath,
			String targetSavePath, int width, int height) throws IOException {
		File file = new File(needCutImgPath);
		if (!file.exists()) {
			throw new IOException("图片不存在:" + needCutImgPath);
		}
		if (width != 0 && height != 0) {
			// 截取文件名称
			String fileName = file.getName();
			// 文件后缀
			String extName = null;
			// 新文件名
			String newFileName = null;
			// 图片类型
			String formatName = null;
			if (fileName.lastIndexOf(".") >= 0) {
				extName = fileName.substring(fileName.lastIndexOf("."));
				fileName = fileName.substring(0, fileName.lastIndexOf("."));
				formatName = extName.substring(1, extName.length());
			}
			//缩略图名称
			newFileName = fileName + "_" + String.valueOf(width) + "_"
					+ String.valueOf(height) + extName;
			copyImageFile(file, targetSavePath+newFileName);
			BufferedImage bufferedImage = ImageIO.read(file);
			BufferedImage zoomImage = compress(bufferedImage, width, height);
			ImageIO.write(zoomImage, formatName, new File(targetSavePath
					+ newFileName));

		}
	}

	/**
	 * 压缩图片
	 * 
	 * @param bufferedImage
	 * @param width
	 * @param height
	 * @return
	 */
	private static BufferedImage compress(BufferedImage bufferedImage,
			int width, int height) {
		BufferedImage compressImage = new BufferedImage(width, height,
				bufferedImage.getType());
		Image image = bufferedImage.getScaledInstance(width, height,
				Image.SCALE_SMOOTH);
		Graphics graphics = compressImage.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.drawImage(image, 0, 0, null);
		return compressImage;
	}

	/**
	 * 复制图片文件进行缩略图处理
	 * @param oldFile
	 * @param newFilePath
	 * @throws IOException
	 */
	private static void copyImageFile(File oldFile,String newFilePath)
			throws IOException {
		File newImageFile=new File(newFilePath);
		if(!newImageFile.exists()){
			newImageFile.createNewFile();
		}
		FileInputStream in=new FileInputStream(
				oldFile);
		FileOutputStream out = new FileOutputStream(newFilePath);
		IOUtils.copy(in, out);
		in.close();
		out.flush();
		out.close();

	}

}
