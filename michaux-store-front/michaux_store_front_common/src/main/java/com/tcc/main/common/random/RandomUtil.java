package com.tcc.main.common.random;

import java.util.Random;

/**
 * 生成随机字符串
 */
public class RandomUtil {
	
	private static final int DEFAULT_STR_LENGTH = 32;
	
	/**
	 * 生成随机字符串,带数字和字母,字母有大小写。默认为32位
	 */
	public static String generateStr() {
		
		return generateStr(DEFAULT_STR_LENGTH);
	}

	/**
	 * 生成随机字符串,带数字和字母,字母有大小写
	 */
	public static String generateStr(int length) {
		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			// 输出字母还是数字
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			// 字符串
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 取得大写字母还是小写字母
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (choice + random.nextInt(26));
			} else if ("num".equalsIgnoreCase(charOrNum)) {
				// 数字
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}
	
	/**
	 * 生成随机字符串,只有数字
	 */
	public static String generateNumber(int length) {
		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			val += String.valueOf(random.nextInt(10));
		}
		return val;
	}
	
	public static String getRdmKey(int length) { 
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
    public static String getNumberKey(int length){
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
//      return "1111";
    }
	
}
