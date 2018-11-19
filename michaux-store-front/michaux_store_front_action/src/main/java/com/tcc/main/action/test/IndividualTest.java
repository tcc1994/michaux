package com.tcc.main.action.test;

import java.math.BigDecimal;

/**
 * @Description individual testing
 * @Author Tu chengcheng
 * @Company Michaux Store Copyright
 * @Date 2018年11月16日 下午2:14:45
 */
public class IndividualTest {

	public static void main(String[] args) {
		System.out.println(monkeyEatPeach());
		System.out.println(monkeyEatPeach1(monkey()));
		xyzValue();
	}
	
	/**
	 * 猴子吃桃问题:
	 * 猴子第一天摘下若干个桃子，当时就吃了一半，还不过瘾，
	 * 就又吃了一个。第二天又将剩下的桃子吃掉一半，又多吃了一个。以后每天都吃
	 * 前一天剩下的一半零一个。到第 10 天在想吃的时候就剩一个桃子了,求第一天共
	 * 摘下来多少个桃子？
	 */
	public static int monkeyEatPeach(){
		int sum = 1;
		for (int i = 1; i < 10; i++) {
			sum = (sum + 1)* 2 ;
		}
		return sum;
	}
	public static int monkeyEatPeach1(int sum){
		for (int i = 0; i < 10; i++) {
			sum = sum / 2 - 1;
			if(sum == 1){
				break;
			}
		}
		return sum;
	}
	
	public static int monkey(){
		int total = 1;
	    for (int i = 10; i > 0; i--) {
	        System.out.println("第" + i + "天，有桃子" + total + "颗");
	        total = (total + 1) * 2;
	    }
	    return total;
	}
	
	/**
	 * 已知 XYZ+YZZ=532，其中，X、Y、Z 为数字，编程求出 X、Y 和 Z 的值。
	 */
	public static int xyzValue(){
		int compareTo = 1;
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				for (int z = 0; z < 10; z++) {
					String xx = String.valueOf(x);
					String yy = String.valueOf(y);
					String zz = String.valueOf(z);
					String xyz = xx+yy+zz;
					String yzz = yy+zz+zz;
					BigDecimal XYZ = new BigDecimal(xyz);
					BigDecimal YZZ = new BigDecimal(yzz);
					BigDecimal add = XYZ.add(YZZ);
					BigDecimal YZZd = new BigDecimal(985);
					compareTo = add.compareTo(YZZd);
					if(compareTo == 0){
						System.err.println(x);
						System.err.println(y);
						System.err.println(z);
					}
				}
			}
		}
		if(compareTo == 1){
			System.err.println("不存在!!");
		}
		return 0;
	}
	
	
	
}
