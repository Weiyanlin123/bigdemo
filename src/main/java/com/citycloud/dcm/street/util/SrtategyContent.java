package com.citycloud.dcm.street.util;

import com.citycloud.dcm.street.constant.RiskcontrolBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

public class SrtategyContent {
	private static final Logger logger = LoggerFactory.getLogger(SrtategyContent.class);
    public static HashMap<Object,RiskcontrolBean> map= new HashMap<Object,RiskcontrolBean>();
	
	private static String configFileName = null;
	private static volatile long m_lastModifiedTime = 0;
	private static Properties configs = new Properties();
	
	static {

		/**
		 *
		 */
//	    String strtategyFile = SrtategyContent.class.getResource("/").getPath()
//                + "strtategy.properties";
		/**
		 * 获取外部配置文件必须和jar包在同级别目录下
		 */
		String strtategyFile = "strtategy.properties";
		SrtategyContent.init(strtategyFile);
	}
	
	public static String getProperty(String key) {
		String value = configs.getProperty(key);
		if (value != null) {
			value = value.trim();
		}
		return value;
	}

	public static String getProperty(String key, String defaults) {
		String value = configs.getProperty(key, defaults);
		if (value != null) {
			value = value.trim();
		}
		return value;
	}
	
	public static void init(String configFile) {


		InputStream input = null;
		try {
			configFileName = configFile;
			m_lastModifiedTime = new File(configFile).lastModified();
			input = (new FileInputStream(configFile));
			BufferedReader bf = new BufferedReader(new InputStreamReader(input,"utf-8"));
			configs.load(bf);
			Object[] keys = configs.keySet().toArray();
			for (int i = 0; i < keys.length; i++) {
			    RiskcontrolBean riskcontrolBean = new RiskcontrolBean();
			    String values =(String) configs.get(keys[i]);
			    String[] split = values.split("\\|");
			    riskcontrolBean.setInterceptionDimension(split[0]);
			    riskcontrolBean.setResultCode(split[1]);
			    riskcontrolBean.setInterceptTime(split[2]);
			    map.put(keys[i], riskcontrolBean);
            }
			
		} catch (Exception e) {
			logger.error("load config.conf error:", e);
		} finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (Exception e) {
				logger.error("", e);
			}
		}
		//重新读取配置文件线程
		Thread thread = new Thread(new ReConfigRunner());
		thread.start();
	}
	
	public static class ReConfigRunner implements Runnable {
		public void run() {
			while (true) {
				try {
					//睡眠1分钟后重新读取配置文件
					Thread.sleep(1 * 60 * 1000);
					
					//重新读取配置文件
					reloadConfigFile();
				} catch (Throwable e) {
				}
			}
		}
		
		/**
		 * 重新加载配置文件
		 */
		private void reloadConfigFile() {
			InputStream input = null;
			try {
				long lastModTime = new File(configFileName).lastModified();
				if (lastModTime > m_lastModifiedTime) {
					input = (new FileInputStream(configFileName));
					Properties tmp = new Properties();
					HashMap<Object, RiskcontrolBean> tmpHashmap = new HashMap<Object,RiskcontrolBean>();
					BufferedReader bf = new BufferedReader(new InputStreamReader(input,"utf-8"));  
					tmp.load(bf);
					configs = tmp;
					m_lastModifiedTime = lastModTime;
					map=tmpHashmap;
					Object[] keys = tmp.keySet().toArray();
		            for (int i = 0; i < keys.length; i++) {
		                RiskcontrolBean riskcontrolBean = new RiskcontrolBean();
		                String values =(String) configs.get(keys[i]);
		                String[] split = values.split("\\|");
		                riskcontrolBean.setInterceptionDimension(split[0]);
		                riskcontrolBean.setResultCode(split[1]);
		                riskcontrolBean.setInterceptTime(split[2]);
		                tmpHashmap.put(keys[i], riskcontrolBean);
		            }
					
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				logger.error("reload config.conf error:", e);
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("reload config.conf error:", e);
			} finally {
				try {
					if (input != null) {
						input.close();
					}
				} catch (Exception e) {
					logger.error("", e);
				}
			}
		}
	}
}