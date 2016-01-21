package cn.yanis.coffice.framework.helper;

import java.util.Properties;

import cn.yanis.coffice.framework.ConfigConstant;
import cn.yanis.coffice.framework.util.PropsUtil;

/**
 * 属性文件
 * 
 * @author huangjunxian
 * 
 */
public final class ConfigHelper {

	private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);
	
	/**
	 * 获取jdbc驱动
	 */
	public static String getJdbcDriver(){
		return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_DRIVER);
	}
	
	/**
	 * 获取jdbcURl
	 */
	public static String getJdbcUrl(){
		return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_URL);
	}
	
	/**
	 * 获取jdbc用户名
	 */
	public static String getJdbcUsername(){
		return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_USERNAME);
	}
	
	/**
	 * 获取密码
	 */
	public static String getJdbcPassword(){
		return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_PASSWORD);
	}
	
	/**
	 * 获取应用基础包名
	 */
	public static String getAppBasePackage(){
		return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_BASE_PACKAGE);
	}
	
	/**
	 * 获取应用jsp路径
	 */
	public static String getAppJspPath(){
		return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_JSP_PATH,"/WEB-INF/view/");
	}
	
	/**
	 * 获取静态资源路径
	 */
	public static String getAppAssetPath(){
		return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_ASSET_PATH,"/asset/");
	}
}
