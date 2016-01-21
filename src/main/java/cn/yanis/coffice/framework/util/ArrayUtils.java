package cn.yanis.coffice.framework.util;

import java.lang.reflect.Field;

public class ArrayUtils {

	public static boolean isNotEmpty(Object[] array) {
		return !org.apache.commons.lang3.ArrayUtils.isEmpty(array);
	}

}
