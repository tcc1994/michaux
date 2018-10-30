package com.tcc.main.common.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 */
public class MD5Encrypt {
	
	public static final String DEFAULT_KEY = "(*^jiGkjgujTIiuo56*&kjTjgK?JsdlkfhsdlkfyoiewuyoisfhslkdtyKJGVjkYKJgvkj";
	
	/**
	 * 采用MD5加密字符串
	 */
	public static String encryptData(String data){
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte bx[]=(DEFAULT_KEY+data).getBytes("UTF-8");
			md.update(bx);
			return toHex(md.digest());
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String encryptDataNo(String data){
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte bx[]=(data).getBytes("UTF-8");
			md.update(bx);
			return toHex(md.digest());
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 采用MD5加密字符串
	 */
	public static String encryptData(String data,String userKey){
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update((DEFAULT_KEY + data + userKey).getBytes("UTF-8"));
			return toHex(md.digest());
		} catch (NoSuchAlgorithmException e) {
			return null;
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
	
	private static String toHex(byte buffer[]) {
		StringBuffer sb = new StringBuffer(buffer.length * 2);
		for (int i = 0; i < buffer.length; i++) {
			sb.append(Character.forDigit((buffer[i] & 240) >> 4, 16));
			sb.append(Character.forDigit(buffer[i] & 15, 16));
		}
		return sb.toString();
	}
	
}
