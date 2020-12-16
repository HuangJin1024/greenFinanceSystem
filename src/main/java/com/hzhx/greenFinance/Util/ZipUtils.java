package com.hzhx.greenFinance.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
	private static final int BUFFER_SIZE = 2 * 1024;

	/**
	 * 压缩成ZIP
	 * 
	 * @param fileList
	 *            需要压缩的文件列表
	 * @param out
	 *            压缩文件输出流
	 * @throws RuntimeException
	 *             压缩失败会抛出运行时异常
	 */
	public static void toZip(File[] fileList, OutputStream out) {
		long start = System.currentTimeMillis();
		ZipOutputStream zos = null;
		try {
			zos = new ZipOutputStream(out);
			for (File srcFile : fileList) {
				byte[] buf = new byte[BUFFER_SIZE];
				zos.putNextEntry(new ZipEntry(srcFile.getName()));
				int len;
				FileInputStream in = new FileInputStream(srcFile);
				while ((len = in.read(buf)) != -1) {
					zos.write(buf, 0, len);
				}
				zos.closeEntry();
				in.close();
			}
			long end = System.currentTimeMillis();
			//logger.debug("压缩完成，耗时：" + (end - start) + " ms");
		} catch (Exception e) {
			e.printStackTrace();
			//logger.error("系统异常：", e);
		} finally {
			if (zos != null) {
				try {
					zos.close();
				} catch (IOException e) {
					e.printStackTrace();
					//logger.error("系统异常：", e);
				}
			}
		}
	}
}
