package cn.yanis.coffice.framework.util;

import java.util.Map;

/**
 * 工具类
 * 
 * @author huangjunxian
 * 
 */
public class CollectionUtils {

	public static Boolean isNotEmpty(Map map) {
		if (map != null) {
			return map.size() == 0 ? false : true;
		}
		return false;
	}

}
