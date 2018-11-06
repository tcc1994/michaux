package com.tcc.main.common.encrypt;

import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

/**
 * RSA加密
 */
public class RSAEncrypt {

	private static final String DEFAULT_KEY = "8grJ3171OK3o5l82h0So9Js9s4q6oE6U43kre848Nsn08eA4vl005183Vfd8G275op0HD097d0aZm68hpulVw34YX3Z5PUP1J5Sv9lG7A4zbP5616Q0a7I8z3l7P5L4a";
	
	/**
	 * RSA加密
	 */
	public static String encryptData(String data, String pubKey) {
		try {
			PublicKey publicKey = getPublicKey(pubKey);
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] plainText = data.getBytes();
			byte[] enBytes = cipher.doFinal(plainText);
			return Base64.encode(enBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * RSA解密
	 */
	public static String decryptData(String data, String priKey) {
		try {
			PrivateKey privateKey = getPrivateKey(priKey);
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] plainText = Base64.decode(data);
			byte[] deBytes = cipher.doFinal(plainText);
			return new String(deBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 得到公钥
	 */
	private static PublicKey getPublicKey(String key) throws Exception {
		if (key == null) {
			key = DEFAULT_KEY;
		}
		byte[] keyBytes;
		keyBytes = Base64.decode(key);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(keySpec);
		return publicKey;
	}
	
	/**
	 * 得到私钥
	 */
	private static PrivateKey getPrivateKey(String key) throws Exception {
		if (key == null) {
			key = DEFAULT_KEY;
		}
		byte[] keyBytes;
		keyBytes = Base64.decode(key);
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
		return privateKey;
	}
	
	/**
	 * 得到秘钥字符串
	 */
	@SuppressWarnings("unused")
	private static String getKeyString(Key key) throws Exception {
		byte[] keyBytes = key.getEncoded();
		return Base64.encode(keyBytes);
	}
	
	public static void main(String[] args) throws Exception {
//		// 获得对象 KeyPairGenerator 参数 RSA 1024个字节
//		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
//		keyPairGen.initialize(1024);
//		// 通过对象 KeyPairGenerator 获取对象KeyPair
//		KeyPair keyPair = keyPairGen.generateKeyPair();
//
//		// 通过对象 KeyPair 获取RSA公私钥对象RSAPublicKey RSAPrivateKey
//		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
//		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
//		// 公私钥对
//		
//		System.out.println("公钥:" + getKeyString(publicKey));
//		System.out.println("私钥:" + getKeyString(privateKey));
		String pubKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCBVVTmfiuYHujcWtPfnpeCKGReo8iitoT6e6ufPNCxR/0AFnWBcf9V7v9CzFQJO9XiI1YEV8kl4VMyklLPYK32RzODyIkn5fpFcieD7zjmPoyeLMEw6jy4pf4h+gUVDqQM2TT/8Lycfj5dArOSfMSD56yvDNKTkJGat+7k2dzLEwIDAQAB";
		String priKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIFVVOZ+K5ge6Nxa09+el4IoZF6jyKK2hPp7q5880LFH/QAWdYFx/1Xu/0LMVAk71eIjVgRXySXhUzKSUs9grfZHM4PIiSfl+kVyJ4PvOOY+jJ4swTDqPLil/iH6BRUOpAzZNP/wvJx+Pl0Cs5J8xIPnrK8M0pOQkZq37uTZ3MsTAgMBAAECgYAXTWientz765XJHhROliR2LxDmfFwJ9RjAiMfDSRHQ30eWXHWPfRqkQQt83ZPGliFTPUqiPa7gRFjZI8QH2UN+ejXuVhfFIy0sAeqG/BQhGMAXE2SZfxqsgxydr9DPoEPlpklsVYGL+7swddDH7oD4ldDmyi2UBa2MJrIF67ZRAQJBAMhc58P1X8QmAUmWjyKEbD6QvpNWQF0/87DqssSY3OqlxjE5AMxOnv2dI4bQP9Jkck107IJZco0p2q/NdZANNJ0CQQClPy7V9mZrqk+gGW90Aj1c7ER3hFRfdIoI/0xANWx/JbFGh7vewIQm+nTHe06EuAYCE8H0LYwhNAZbbBaJBndvAkAprrpAmBF+OvHVn07TvXzPX0lmWXE2dRF7YrgiEjMTVb1vjA5QcqK83C4B490DJgZpesOhMn6UQ3rNTA8DEtw5AkEAmFMR3XHxH7YzCCXqM0oNPqccxf9Zt1Q6GekcZOPaS6p3K8jbSY61QykElQ35ZyYrg6aq12dVERZf9c5BR7aKSQJBAMIp4n2TagAWxeq47gdDQ98PoK1cTxyfpWjKCSU9fbj/riW9/xL43Bd2ADgx/G0kKbYTM/pAm4kIlJ0LL9yvUZY=";
//		
		String aaa = "asfdasdfa";
		String encryptData = encryptData(aaa, pubKey);
		System.out.println(encryptData);
		String decryptData = decryptData(encryptData, priKey);
		System.out.println(decryptData);
		
	}

}
