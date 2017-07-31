package com.jzf.market.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jzf.market.common.utils.ImageUtil;
import com.jzf.market.controller.app.BaseAPPController;


/**
 * 图片
 * @author feng
 * 
 * 2017年1月10日 上午11:33:01
 */
@Controller
@RequestMapping("/image")
public class ImageController extends BaseAPPController {

	@RequestMapping("/upload")
	public @ResponseBody
	Map<String, String> upload(MultipartFile pictureFile) throws Exception {
		// 封装数据
		Map<String, String> message = new HashMap<String, String>();
		
		// 进行图片上传
		if (pictureFile != null && pictureFile.getOriginalFilename() != null
				&& pictureFile.getOriginalFilename().length() > 0) {
			
			// 上传文件原始名称
			String originalFilename = pictureFile.getOriginalFilename();

			// 将内存中的文件写入磁盘
			InputStream is = pictureFile.getInputStream();
			// 图片上传成功后，将图片的地址写到数据库
			String filePath = "";
//			filePath = ImageUtil.updateImage(is, originalFilename);
			filePath = ImageUtil.store(is, originalFilename);
			
			// 图片上传成功，将新图片地址返回
			message.put("message", "文件上传成功");
			message.put("status", "1");
			message.put("filePath", filePath);
		}else{
			message.put("message", "文件上传失败");
			message.put("status", "0");
		}
		return message;
	}
	
	@RequestMapping("/getImg")
	public void getImg(String path,String number, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(number == null || number.equals("")){
			number = "1";
		}
		String imgPath = path.split(",")[Integer.valueOf(number)-1];
		File f = new File(ImageUtil.rootDirectory,imgPath);
		if(!f.exists()){
			System.out.println(f.getAbsolutePath()+"----------不存在");
			return;
		}
		InputStream is = new FileInputStream(f);
		OutputStream os = response.getOutputStream();
		
		int len = 0;
		byte[] b = new byte[1024];
		while((len = is.read(b)) != -1){
			os.write(b, 0, len);
		}
		is.close();
		os.close();
	}
}
