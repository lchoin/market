package com.jzf.market.common.utils;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;


public class ImageUtil {
	public static final String rootName = "image";
	public static final int rootNameLength = rootName.length();
	public static final String drive = System.getProperties().getProperty("os.name").toLowerCase().startsWith("win") ? "D:" : File.separator + "root/feng";
	public static final String rootDirectory = drive + File.separator + rootName;
	
	public static final int IMG_WIDTH = 128*2;
	public static final int IMG_HIGH= 128*2;

	/**
	 * 修改图片大小，返回图片地址
	 * 
	 * @param is
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static String updateImage(InputStream is, String fileName)
			throws Exception {
		String filePath = ImageUtil.resizeImage(is, "jpg", getPath(fileName));
		return filePath.substring(filePath.indexOf(rootName) + rootNameLength+1);
	}
	/**
	 * 无损存储
	 * @param is		读取到的图片流
	 * @param fileName	要存储的文件名
	 * @return
	 * @throws Exception
	 */
	public static String store(InputStream is, String fileName) throws Exception{
		File file = getPath(fileName);
		FileOutputStream fos = new FileOutputStream(file);
		IOUtils.copy(is, fos);
		
		String filePath = file.getAbsolutePath();
		return filePath.substring(filePath.indexOf(rootName) + rootNameLength+1);
	}


    /**
	 * 
	 * @param FileName
	 * @return
	 */
	private static File getPath(String FileName) {
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		String directory1 = df.format(new Date());
		df = new SimpleDateFormat("HHmmssSSS");
		String directory2 = df.format(new Date());

		File f = new File(rootDirectory + File.separator + directory1
				+ File.separator + directory2);
		try {
			if (f.mkdirs()) {
				return new File(f, FileName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			df = null;
		}
		return null;
	}

	/**
	 * 调整大小，返回文件地址
	 * 
	 * @param is
	 * @param format
	 * @param toFile
	 * @throws IOException
	 */
	public static String resizeImage(InputStream is, String format, File toFile)
			throws IOException {
		BufferedImage prevImage = ImageIO.read(is);
		BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_HIGH,
				BufferedImage.TYPE_INT_BGR);
		Graphics graphics = image.createGraphics();
		// graphics.drawImage(prevImage, 0, 0, 595, 842, null);
		graphics.drawImage(prevImage, 0, 0, IMG_WIDTH, IMG_HIGH, null);
		ImageIO.write(image, format, toFile);
		is.close();
		return toFile.getAbsolutePath();
	}
}
