package com.ageless.util;

public class PathUtil {

	private static String seperator = System.getProperty("file.separator");

	public static String getImgBasePath() {
		String os = System.getProperty("os.name");
		String basePath = "";
		if (os.toLowerCase().startsWith("win")) {
			basePath = "E:/IdeaProjects/Ageless/src/main/resources/static/";
		} else {
			basePath = "/home/xiangze/image/";
		}
		basePath = basePath.replace("/", seperator);
		return basePath;
	}

	public static String getShopImagePath(long shopId) {
		String imagePath = "/images/item/" + shopId + "/";
		return imagePath.replace("/", seperator);
	}
}
