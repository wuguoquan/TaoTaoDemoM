package com.wugq.taotao.manager.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.wugq.taotao.common.utils.IDUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wugq.taotao.manager.service.PictureService;

@Service
public class PictureServiceImpl implements PictureService {

	@Value("${NGINX_LOCAL_BASE_PATH}")
	private String LOCAL_BASE_PATH;
	@Value("${NGINX_WEB_BASE_PATH}")
	private String WEB_BASE_PATH;

	@Override
	public Map uploadPicture(MultipartFile uploadFile) {
		Map resultMap = new HashMap<>();
		try {
			//生成一个新的文件名
			//取原始文件名
			String oldName = uploadFile.getOriginalFilename();
			//生成新文件名
			//UUID.randomUUID();
			String newName = IDUtils.genImageName();
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			//图片上传
			String imagePath = new DateTime().toString("/yyyy/MM/dd");
			boolean result = uploadImageFile(LOCAL_BASE_PATH, imagePath, newName, uploadFile);
			//返回结果
			if(!result) {
				resultMap.put("error", 1);
				resultMap.put("message", "文件上传失败");
				return resultMap;
			}
			resultMap.put("error", 0);
			resultMap.put("url", WEB_BASE_PATH + imagePath + File.separator + newName);
			return resultMap;
			
		} catch (Exception e) {
			resultMap.put("error", 1);
			resultMap.put("message", "文件上传发生异常");
			return resultMap;
		}
	}

	public static boolean uploadImageFile(String basePath,
									 String filePath,
									 String filename,
									 MultipartFile file) {
		// 如果文件不为空，写入上传路径
		if(!file.isEmpty()){
			File savePath = new File(basePath + filePath, filename);
			// 判断路径是否存在，如果不存在就创建一个
			if (!savePath.getParentFile().exists()) {
				savePath.getParentFile().mkdirs();
			}
			// 将上传文件保存到一个目标文件当中
			try {
				file.transferTo(new File(basePath + filePath + File.separator + filename));
			} catch (IOException e) {
				return false;
			}
			return true;
		}else{
			return false;
		}
	}
}


