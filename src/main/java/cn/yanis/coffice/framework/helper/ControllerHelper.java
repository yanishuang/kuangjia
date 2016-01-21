package cn.yanis.coffice.framework.helper;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import cn.yanis.coffice.framework.annotation.Action;
import cn.yanis.coffice.framework.bean.Handler;
import cn.yanis.coffice.framework.bean.Request;

/**
 * 控制器助手类
 * 
 * @author huangjunxian
 * 
 */
public class ControllerHelper {

	/**
	 * 用于存放请求与处理器的映射关心
	 */
	private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();

	static {
		// 获取所有的Controller类
		Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
		if (CollectionUtils.isNotEmpty(controllerClassSet)) {
			// 遍历所有Controller类
			for (Class<?> controllerClass : controllerClassSet) {
				// 获取Controller类中定义的方法
				Method[] methods = controllerClass.getDeclaredMethods();
				if (ArrayUtils.isNotEmpty(methods)) {
					// 遍历这些类里面的方法
					for (Method method : methods) {
						// 判断当前方法是否带有Action注解
						if (method.isAnnotationPresent(Action.class)) {
							// 从action注解中获取url映射规则
							Action action = method.getAnnotation(Action.class);
							String mapping = action.value();
							if (mapping.matches("\\w+:/\\w*")) {
								String[] array = mapping.split(":");
								if (ArrayUtils.isNotEmpty(array)
										&& array.length == 2) {
									// 获取请求路径和请求方法
									String requestMethod = array[0];
									String requestPath = array[1];
									Request request = new Request(requestMethod, requestPath);
									Handler handler = new Handler(controllerClass, method);
									//初始化Action map
									ACTION_MAP.put(request, handler);
								}
							}

						}
					}
				}
			}
		}

	}
	
	/**
	 * 获取Handler
	 */
	public static Handler getHandler(String requestMethod ,String requestPath){
		Request request = new Request(requestMethod, requestPath);
		return ACTION_MAP.get(request);
		
	}
}
