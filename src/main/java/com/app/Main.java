package com.app;

import com.app.components.MainFrame;
import com.app.configs.Configs;
import com.app.utils.PropertiesUtil;

public class Main {

	public static void main(String[] args) {	
		
		try {
			PropertiesUtil.setRunrgs(args);
			Configs.getInstance();
			Configs configs = Configs.getInstance();
			System.out.println(configs.getMyIP());
			System.out.println(configs.getMyPort());
			System.out.println(configs.getYourIP());
			System.out.println(configs.getYourPort());
			MainFrame mainFrame = new MainFrame(args);
			mainFrame.open();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}	
	}

}
