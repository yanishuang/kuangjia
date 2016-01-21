package cn.yanis.coffice.framework.helper;

import java.util.HashSet;
import java.util.Set;

import cn.yanis.coffice.framework.annotation.Controller;
import cn.yanis.coffice.framework.annotation.Service;
import cn.yanis.coffice.framework.util.ClassUtil;

/**
 * 类操作助手类
 * 
 * @author huangjunxian
 * 
 */
public final class ClassHelper {

	/**
	 * 定义类的集合
	 */
	private static final Set<Class<?>> CLASS_SET;

	static {
		String basePackage = ConfigHelper.getAppBasePackage();
		CLASS_SET = ClassUtil.getClassSet(basePackage);
	}

	/**
	 * 获取应用包名下的所有类
	 * 
	 * @return
	 */
	public static Set<Class<?>> getClassSet() {
		return CLASS_SET;
	}

	/**
	 * 获取应用包名下所有Service类
	 */
	public static Set<Class<?>> getServiceClassSet() {
		HashSet<Class<?>> classSet = new HashSet<Class<?>>();
		for (Class<?> cls : CLASS_SET) {
			if (cls.isAnnotationPresent(Service.class)) {
				classSet.add(cls);
			}
		}
		return classSet;
	}

	/**
	 * 获取应用包下所有的Controller类
	 */

	public static Set<Class<?>> getControllerClassSet() {
		HashSet<Class<?>> classSet = new HashSet<Class<?>>();
		for (Class<?> cls : CLASS_SET) {
			if (cls.isAnnotationPresent(Controller.class)) {
				classSet.add(cls);
			}
		}
		return classSet;
	}

	/**
	 * 获取应用包名下所有bean类（包括：service，Controller等）
	 */
	public static Set<Class<?>> getBeanClassSet() {
		HashSet<Class<?>> beanClassSet = new HashSet<Class<?>>();
		beanClassSet.addAll(getControllerClassSet());
		beanClassSet.addAll(getServiceClassSet());
		return beanClassSet;

	}
}
