package com.tcc.main.common.dict;

/**
 * @Description 客户端 -- 注册来源(0:PC;1:Android;2:IOS;3:小程序;4:H5;)
 * @Author Tu chengcheng
 * @Company Michaux Store Copyright
 * @Date 2018年10月30日 下午1:22:34
 */
public interface RegClient {

	/**
	 * @Description pc
	 */
	public static final Integer PC = 0;
	
	/**
	 * @Description android
	 */
	public static final Integer ANDROID = 1;
	
	/**
	 * @Description ios
	 */
	public static final Integer IOS = 2;
	
	/**
	 * @Description 小程序
	 */
	public static final Integer APPLET = 3;
	
	/**
	 * @Description h5
	 */
	public static final Integer H5 = 4;
}
