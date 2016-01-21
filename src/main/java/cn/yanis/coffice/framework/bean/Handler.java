package cn.yanis.coffice.framework.bean;

import java.lang.reflect.Method;

/**
 * 封装action信息
 * 
 * @author huangjunxian
 * 
 */
public class Handler {
	/**
	 * Controller类
	 */

	private Class<?> controllerClass;

	/**
	 * Action方法
	 */
	private Method actionMethod;

	public Handler(Class<?> controllerClass, Method actionMethod) {
		super();
		this.controllerClass = controllerClass;
		this.actionMethod = actionMethod;
	}

	public Class<?> getControllerClass() {
		return controllerClass;
	}

	public Method getActionMethod() {
		return actionMethod;
	}

}
