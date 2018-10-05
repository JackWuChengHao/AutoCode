package CodeForFuture.AutoCode.Resources;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import CodeForFuture.AutoCode.Application;

@Component
public final class ZipTools {  
	
	private final static Logger logger =  Logger.getLogger(Application.class); 

	public static void packToolFiles(String dirpath, String zipFilePath)
			throws Exception {

		OutputStream out = null;
		BufferedOutputStream bos = null;
		ZipArchiveOutputStream zaos = null;
		File zipFile = new File(zipFilePath);
		if (!zipFile.getParentFile().exists()) {
			zipFile.getParentFile().mkdirs();
		}
		zipFile.delete();
		try {
			out = new FileOutputStream(zipFile);
		} catch (FileNotFoundException e) {
			logger.error(e);
		}
		bos = new BufferedOutputStream(out);
		zaos = new ZipArchiveOutputStream(bos);
		zaos.setEncoding("UTF-8");
		packToolFiles(zaos, dirpath, "");
		zaos.flush();
		zaos.close();
		bos.flush();
		bos.close();
		out.flush();
		out.close();
	}

	private static void packToolFiles(ZipArchiveOutputStream zaos,
			String dirpath, String pathName) throws FileNotFoundException,
	IOException {
		ByteArrayOutputStream tempbaos = new ByteArrayOutputStream();
		BufferedOutputStream tempbos = new BufferedOutputStream(tempbaos);
		File dir = new File(dirpath);
		// 返回此绝对路径下的文件
		File[] files = dir.listFiles();
		if (files == null || files.length < 1) {
			return;
		}
		for (int i = 0; i < files.length; i++) {
			// 判断此文件是否是一个文件夹
			if (files[i].isDirectory()) {
				packToolFiles(zaos, files[i].getAbsolutePath(), pathName
						+ files[i].getName() + File.separator);
			} else {
				zaos.putArchiveEntry(new ZipArchiveEntry(pathName
						+ files[i].getName()));
				IOUtils.copy(new FileInputStream(files[i].getAbsolutePath()),
						zaos);
				zaos.closeArchiveEntry();
			}
		}
		tempbaos.flush();
		tempbaos.close();
		tempbos.flush();
		tempbos.close();
	}


}