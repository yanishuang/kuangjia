package cn.yanis.coffice.framework;

import cn.yanis.coffice.framework.helper.BeanHelper;
import cn.yanis.coffice.framework.helper.ClassHelper;
import cn.yanis.coffice.framework.helper.ControllerHelper;
import cn.yanis.coffice.framework.helper.IocHelper;
import cn.yanis.coffice.framework.util.ClassUtil;

/**
 * 加载相应的Helper类
 * 
 * @author huangjunxian
 * 
 */
public final class HelperLoader {

	public static void init(){
		Class<?>[] classList= {
			ClassHelper.class,
			BeanHelper.class,
			IocHelper.class,
			ControllerHelper.class
		};
		for (Class<?> cls : classList) {
			ClassUtil.loadClass(cls.getName());
		}
	}
}
