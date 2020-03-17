package com.zhang;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhang.utils.DateUtils;
import com.zhang.utils.FileUtils;
import com.zhang.utils.StringUtils;

public class FilesFilterOfYtc {
	public static void main(String[] args) {
//		String sourcePath = "E:\\tomcat-dispatcher\\wtpwebapps\\chaozhigou-dispatcher";
//		String targetPath = "D:\\chaozhigou\\dispatcher";
		
//		String sourcePath = "E:\\tomcat-member\\wtpwebapps\\chaozhigou-member";
//		String targetPath = "D:\\chaozhigou\\member";

//		String sourcePath = "E:\\tomcat-pay\\wtpwebapps\\chaozhigou-pay";
//		String targetPath = "D:\\chaozhigou\\pay";
		  
		String sourcePath = "E:\\tomcat-admin\\wtpwebapps\\chaozhigou-admin";
		String targetPath = "D:\\chaozhigou\\admin";
		
//		String sourcePath = "E:\\tomcat-api\\wtpwebapps\\chaozhigou-api";
//		String targetPath = "D:\\chaozhigou\\api"; 
	 
//		String sourcePath = "E:\\tomcat-service\\wtpwebapps\\chaozhigou-service";
//		String targetPath = "D:\\chaozhigou\\service";  
 		
//		String sourcePath = "E:\\workspace\\chaozhigou-wap\\src\\main\\webapp\\images";
//		String targetPath = "D:\\chaozhigou\\chaozhigou-wap-webapp\\images";
 	
//		String sourcePath = "E:\\tomcat-weilinli\\wtpwebapps\\chaozhigou-wap";
//		String targetPath = "D:\\chaozhigou\\weilinli";
		   
		String startDate = "2017-04-05 20:38";      
		 
//		String pathPrefix = "_";
//		String pathSuffix = "_V";
		String indexSuffix = "_";

		try {
			File file = new File(sourcePath);

			// 不存在
			if (!file.exists()) {
				throw new Exception();
			}

			// 是文件夹
			if (file.isDirectory()) {
				// 要保存的文件夹名称
				if (StringUtils.isStrObjBlank(targetPath)) {
					targetPath = file.getPath() + indexSuffix + DateUtils.getCurrentDateStr();
				}
				FileUtils.copyDirectory(file, targetPath, startDate);

			} else {
				if (StringUtils.isStrObjBlank(targetPath)) {
					targetPath = file.getParent() + indexSuffix + DateUtils.getCurrentDateStr();
				}
				FileUtils.copyFile(file, targetPath, startDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
