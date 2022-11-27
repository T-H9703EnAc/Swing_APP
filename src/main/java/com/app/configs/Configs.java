package com.app.configs;

import java.util.Objects;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

import com.app.consts.Constant;
import com.app.consts.Constant.PropertyFile;
import com.app.consts.Constant.RunArgs;
import com.app.utils.PropertiesUtil;

public class Configs {
	private static Configs configs;

	private String myIP;

	private int myPort;

	private String yourIP;

	private int yourPort;

	private Configs() throws Exception {

		if (StringUtils.equals(PropertiesUtil.getRunrgs(RunArgs.ARG3), Constant.DEBUG_MODE)) {
			ResourceBundle rb = PropertiesUtil.readPropertyBundle(PropertiesUtil.getRunrgs(RunArgs.ARG2));
			this.myIP = PropertiesUtil.getProperty(rb, PropertyFile.MY_IP.getKey());
			this.myPort = Integer.parseInt(PropertiesUtil.getProperty(rb, PropertyFile.My_PORT.getKey()));
			this.yourIP = PropertiesUtil.getProperty(rb, PropertyFile.YOUR_IP.getKey());
			this.yourPort = Integer.parseInt(PropertiesUtil.getProperty(rb, PropertyFile.YOUR_PORT.getKey()));
		} else {
			Properties properties = PropertiesUtil.readProperty(PropertiesUtil.getRunrgs(RunArgs.ARG2));
			this.myIP = PropertiesUtil.getProperty(properties, PropertyFile.MY_IP.getKey());
			this.myPort = Integer.parseInt(PropertiesUtil.getProperty(properties, PropertyFile.My_PORT.getKey()));
			this.yourIP = PropertiesUtil.getProperty(properties, PropertyFile.YOUR_IP.getKey());
			this.yourPort = Integer.parseInt(PropertiesUtil.getProperty(properties, PropertyFile.YOUR_PORT.getKey()));
		}

	}

	public static synchronized Configs getInstance() throws Exception {
		return Objects.isNull(configs) ? new Configs() : configs;
	}

	public String getMyIP() {
		return myIP;
	}

	public static Configs getConfigs() {
		return configs;
	}

	public int getMyPort() {
		return myPort;
	}

	public String getYourIP() {
		return yourIP;
	}

	public int getYourPort() {
		return yourPort;
	}

}
