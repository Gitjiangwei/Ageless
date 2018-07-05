package com.ageless.util;

import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImagesUtil {

	static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

	private static String basePath = Thread.currentThread()
			.getContextClassLoader().getResource("").getPath();// ��ȡ��ǰִ���̵߳�·��
	private static final SimpleDateFormat sDateFormat = new SimpleDateFormat(
			"yyyyMMddHHmmss");// ʱ��
	private static final Random r = new Random();// �����

	/**
	 * 
	 * @param
	 *            �ϴ��ļ�
	 * @param targetAddr
	 *            Ŀ��·��
	 * @return
	 */
	public static String generateThumbnail(InputStream io, String imgName,
			String targetAddr) {
		String realFileName = getRandomFileName();// ����ļ���
		String extension = getFileExtension(imgName);// ��ú�׺
		makeDirPath(targetAddr);// �����ļ���
		String relativeAddr = targetAddr + realFileName + extension;
		logger.debug("current relativeAddr is " + relativeAddr);
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);

		logger.debug("current complete addr is " + PathUtil.getImgBasePath()
				+ relativeAddr);
		try {
			Thumbnails
					.of(io)
					.size(1000, 1000).toFile(dest);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("上传图片失败！");
		}
		return relativeAddr;
	}

	/**
	 * ����Ŀ��·������Ҫ���ļ���
	 * 
	 * @param targetAddr
	 */
	private static void makeDirPath(String targetAddr) {
		String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}

	/**
	 * ��ȡ�ϴ��ļ��ĺ�׺
	 * 
	 * @param
	 * @return
	 */
	private static String getFileExtension(String imgName) {
		return imgName.substring(imgName.lastIndexOf("."));
	}

	/**
	 * ��������ļ������Է�ֹ����
	 * 
	 * @return
	 */
	public static String getRandomFileName() {
		int rannum = r.nextInt(89999) + 10000;
		String nowTimeStr = sDateFormat.format(new Date());
		return nowTimeStr + rannum;
	}

	/**
	 * �ж�storePath���ļ���·������Ŀ¼��·���� ������ļ�·����ɾ�����ļ��� �����Ŀ¼·����ɾ����Ŀ¼�µ������ļ�������Ŀ¼
	 * 
	 * @param storePath
	 */
	public static void deleteFileOrPath(String storePath) {
		File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
		if (fileOrPath.exists()) {
			if (fileOrPath.isDirectory()) {
				File files[] = fileOrPath.listFiles();
				for (int i = 0; i < files.length; i++) {
					files[i].delete();
				}
			}
			fileOrPath.delete();
		}
	}

}
