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

public class FilesFilter {
	public static void main(String[] args) {
		/** dispatcher **/
//		Map<String, String> map_dispatcher = new HashMap<String, String>();
//		map_dispatcher.put("sourcePath", "D:\\tomcatService\\dispatcher\\webapps\\dispatcher");
//		map_dispatcher.put("targetPath", "D:\\chaozhigou\\dispatcher");
//		
		/** member **/
//		Map<String, String> map_member = new HashMap<String, String>();
//		map_member.put("sourcePath", "D:\\tomcatService\\tomcat-member\\webapps\\member");
//		map_member.put("targetPath", "D:\\chaozhigou\\member");

//		Map<String, String> map_pay = new HashMap<String, String>();
//		map_pay.put("sourcePath", "D:\\tomcat-pay\\wtpwebapps\\chaozhigou-pay");
//		map_pay.put("targetPath", "D:\\chaozhigou\\pay");

		
		/** app **/
//		Map<String, String> map_app = new HashMap<String, String>();
//		map_app.put("sourcePath", "D:\\tomcat-app\\wtpwebapps\\chaozhigou-app");
//		map_app.put("targetPath", "D:\\chaozhigou\\chaozhigou-app");
		
		/** admin **/
//		Map<String, String> map_admin = new HashMap<String, String>();
//		map_admin.put("sourcePath", "D:\\tomcatService\\admin\\webapps\\admin");
//		map_admin.put("targetPath", "D:\\chaozhigou\\admin");

//		/** api **/
//		Map<String, String> map_api = new HashMap<String, String>();
//		map_api.put("sourcePath", "D:\\tomcatService\\api\\webapps\\api");
//		map_api.put("targetPath", "D:\\chaozhigou\\api");

		
		/** service **/
//		Map<String, String> map_service = new HashMap<String, String>();
//		map_service.put("sourcePath", "D:\\tomcatService\\tomcat_service\\webapps\\service");
//		map_service.put("targetPath", "D:\\chaozhigou\\service");


//		/** wap **/
		Map<String, String> map_wap = new HashMap<String, String>();
		map_wap.put("sourcePath", "G:\\tomcat\\yuhao\\webapps\\GuanDou");
		map_wap.put("targetPath", "E:\\工作\\deploy\\yuhao\\GuanDou");

//		String pathPrefix = "_";
//		String pathSuffix = "_V";
		String indexSuffix = "_";
		
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Collections.addAll(list, map_wap);
		
		//String startDate = "2017-03-06 09:00:00";銆�
		String startDate = "2020-03-17 15:50";


		for (Map<String, String> map : list) {
			String sourcePath = map.get("sourcePath");
			String targetPath = map.get("targetPath");
			
			try {
				File file = new File(sourcePath);

				// 涓嶅瓨鍦�
				if (!file.exists()) {
					throw new Exception();
				}

				// 鏄枃浠跺す
				if (file.isDirectory()) {
					// 瑕佷繚瀛樼殑鏂囦欢澶瑰悕绉�
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

}
