package cn.yanis.coffice.framework.bean;

import java.util.Map;

import cn.yanis.coffice.framework.util.CastUtil;

/**
 * 请求参数对象
 * 
 * @author huangjunxian
 * 
 */
public class Param {

	private Map<String, Object> paramMap;

	public Param(Map<String, Object> paramMap) {
		this.paramMap = paramMap;
	}

	/**
	 * 根据参数名获取long型参数值
	 */
	public long getLong(String name) {
		return CastUtil.castLong(paramMap.get(name));
	}
	
	/**
	 * 获取所有的字段信息
	 */
	public Map<String, Object> getMap() {
		return paramMap;
	}
}
