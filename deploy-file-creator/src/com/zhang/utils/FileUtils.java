package com.zhang.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

public class FileUtils {

	/**
	 * 鎷疯礉鏂囦欢澶�
	 * @param sourceFile
	 * @param targetPath
	 */
	public static void copyDirectory(File sourceFile, String targetPath) {
		copyDirectory(sourceFile, targetPath, null);
	}

	/**
	 * 鎷疯礉鏂囦欢澶�
	 * @param sourceFile
	 * @param targetPath
	 * @param startDate 鎷疯礉鐨勬枃浠跺紑濮嬫椂闂�
	 */
	public static void copyDirectory(File sourceFile, String targetPath, String startDate) {
		if (!sourceFile.exists()) {
			return;
		}

		// 涓嶆槸鏂囦欢澶�
		if (!sourceFile.isDirectory()) {
			System.out.println(sourceFile.getAbsolutePath() + "------涓嶆槸鏂囦欢澶�");
			return;
		}

		// 鍒涘缓鏂囦欢澶�
		// File targetDirectory = new File(targetPath);
		// if (!targetDirectory.exists()) {
		// targetDirectory.mkdir();
		// }

		for (File f : sourceFile.listFiles()) {
			if (f.isDirectory()) {
				String path = targetPath + File.separator + f.getName();
				
				if(path.contains("SecurityServiceImp")){
					System.err.println("");
				}
				
				copyDirectory(f, path, startDate);
			} else {
				copyFile(f, targetPath, startDate);
			}
		}
	}

	/**
	 * 鎷疯礉鏂囦欢
	 * @param sourceFile 琚嫹璐濈殑鏂囦欢
	 * @param targetPath 鏂囦欢瀛樻斁鐨勭洰褰�
	 */
	public static void copyFile(File sourceFile, String targetPath) {
		copyFile(sourceFile, targetPath, null);
	}

	/**
	 * 鎷疯礉鏂囦欢
	 * @param sourceFile 琚嫹璐濈殑鏂囦欢
	 * @param targetPath 鏂囦欢瀛樻斁鐨勭洰褰�
	 * @param startDate 鎷疯礉鐨勬枃浠跺紑濮嬫椂闂�
	 */
	public static void copyFile(File sourceFile, String targetPath, String startDate) {
		if (!sourceFile.exists()) {
			return;
		}
		// 鏂囦欢澶�
		if (sourceFile.isDirectory()) {
			return;
		}

		// 鏃堕棿闄愬埗
		if (!StringUtils.isStrObjBlank(startDate)) {
			long lastModified = sourceFile.lastModified();

			String modifiedDateStr = DateUtils.dateToString(new Date(lastModified));
			if (modifiedDateStr.compareTo(startDate) < 0) {
				return;
			}
		}

		// 鍒涘缓鏂囦欢澶�
		File file = new File(targetPath);
		if (!file.exists()) {
			file.mkdirs();
		}

		// 鍒涘缓鏂囦欢
		String targetFilePath = targetPath + File.separator + sourceFile.getName();
		File targetFile = new File(targetFilePath);
		if (!targetFile.exists()) {
			try {
				targetFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(sourceFile);

		// 鏂囦欢鎷疯礉
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(sourceFile);
			out = new FileOutputStream(targetFile);
			byte[] buffer = new byte[1024];
			int read = -1;
			while ((read = in.read(buffer)) != -1) {
				out.write(buffer, 0, read);
			}
			out.flush();
			out.close();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 鍒犻櫎鏂囦欢\鐩綍
	 * @param file
	 */
	public static void deleteFile(File file) {
		// 鍒犻櫎鏂囦欢
		if (!file.isDirectory()) {
			file.delete();
			return;
		}

		// 鍒犻櫎鏂囦欢澶�

		// 鍏堝埅闄や笅绾х洰褰�
		File[] files = file.listFiles();
		if (files.length > 0) {
			for (File tmp : files) {
				deleteFile(tmp);
			}
		}

		// 鍐嶅垹闄ゆ湰绾х洰褰�
		file.delete();
	}
}
