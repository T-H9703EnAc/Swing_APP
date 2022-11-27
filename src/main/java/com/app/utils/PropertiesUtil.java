package com.app.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.ResourceBundle;

import com.app.consts.Constant.RunArgs;

public class PropertiesUtil {
	
	/**
	 * 起動引数をシステムプロパティに設定
	 * @param args 起動引数
	 */
	public static void setRunrgs(String[] args) {
		System.setProperty(RunArgs.ARG0.getKey(), args[0]);
		System.setProperty(RunArgs.ARG1.getKey(), args[1]);
		System.setProperty(RunArgs.ARG2.getKey(), args[2]);
		System.setProperty(RunArgs.ARG3.getKey(), args[3]);
	}
	
	/**
	 * システムプロパティに設定した起動引数の値を取得
	 * @param runArgs 起動引数のターゲット
	 * @return 起動引数の値
	 */
	public static String getRunrgs(RunArgs runArgs) {
		return System.getProperty(runArgs.getKey());
	}
	

	/**
	 * Propertiesを使用したプロパティファイルの読み込み
	 * @param propertyFile プロパティファイル名
	 * @return プロパティファイルの内容
	 * @throws IOException
	 */
	public static Properties readProperty(String propertyFile) throws Exception{
		Properties properties = new Properties();

		//プロパティファイルのパスを指定する
		String strpass = Paths.get("").toAbsolutePath().toString() + propertyFile;

		try (InputStream istream = new FileInputStream(strpass);) {
			properties.load(istream);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw e;
		} 
		return properties;
	}
	
	/**
	 * プロパティファイルの値を取得
	 * @param properties プロパティファイル
	 * @param target 取得したいプロパティキー
	 * @return プロパティバリュー
	 */
	public static String getProperty(Properties properties, String target) {
		return properties.getProperty(target);
	}
	
	/**
	 * ResourceBundleを使用したプロパティファイルの読み込み
	 * @param propertyFile プロパティファイル名
	 * @return プロパティファイルの内容
	 */
	public static ResourceBundle readPropertyBundle(String propertyFile) {
		return ResourceBundle.getBundle(propertyFile);
	}
	
	/**
	 * プロパティファイルの値を取得
	 * @param rb プロパティファイル
	 * @param target 取得したいプロパティキー
	 * @return プロパティバリュー
	 */
	public static String getProperty(ResourceBundle rb, String target) {
		return rb.getString(target);
	}
}
