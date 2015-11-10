package com.tarena.action;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Map;

import com.tarena.util.ImageUtil;

/**
 *	生成验证码图片
 */
public class CreateImageAction 
	extends BaseAction {
	
	//output
	private InputStream imageStream;
	
	public String execute() {
		//生成验证码图片
		Map<String, BufferedImage> map = 
			ImageUtil.createImage();
		//取得验证码
		String code = 
			map.keySet().iterator().next();
		session.put("imageCode", code);
		//取得图片
		BufferedImage image = map.get(code);
		imageStream = 
			ImageUtil.getInputStream(image);
		return "success";
	}

	public InputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}

}
