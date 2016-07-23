package com.mmle.utils;
/**
 * 
 * @ClassName: CheckTypeEnum 
 * @Description: TODO(安全检查类型) 
 * @author lbb
 * @date 2016年7月23日 下午8:28:50
 */
public enum CheckTypeEnum {

	/**
	 * 枚举常量必须要写在类开始的位置,不然会报错 水上安全检查 野生动物巡查 0 1
	 */

	water_safety_inspection(0), // 水上安全检查
	wildlife_patrol(1);// 野生动物巡查
	private String stringValue;
	private int intVlue;

	// 构造函数必须为private的,防止意外调用
	private CheckTypeEnum(String stringValue) {
		this.stringValue = stringValue;
	}

	// 构造函数必须为private的,防止意外调用
	private CheckTypeEnum(int intVlue) {
		this.intVlue = intVlue;
	}

	public String getStringValue() {
		return stringValue;
	}

	public int getIntVlue() {
		return intVlue;
	}

}
