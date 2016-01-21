package cn.yanis.coffice.framework.helper;

import java.lang.reflect.Field;
import java.util.Map;

import cn.yanis.coffice.framework.annotation.Inject;
import cn.yanis.coffice.framework.util.ArrayUtils;
import cn.yanis.coffice.framework.util.CollectionUtils;
import cn.yanis.coffice.framework.util.ReflectionUtil;

/**
 * 依赖注入助手类
 * 
 * @author huangjunxian
 * 
 */
public class IocHelper {

	static {
		// 获取所有的bean类与bean实例之间的映射关系
		Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
		if (CollectionUtils.isNotEmpty(beanMap)) {
			for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
				Class<?> beanClass = beanEntry.getKey();
				Object beanInstance = beanEntry.getValue();
				Field[] beanFields = beanClass.getDeclaredFields();
				if (ArrayUtils.isNotEmpty(beanFields)) {
					for (Field beanField : beanFields) {
						//判断是否带有inject注解
						if(beanField.isAnnotationPresent(Inject.class)){
							Class<?> beanFieldClass = beanField.getType();
							Object beanFieldInstance = beanMap.get(beanFieldClass);
							if(beanFieldInstance!=null){
								ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
								
							}
						}
					}
				}
			}

		}
	}
}
