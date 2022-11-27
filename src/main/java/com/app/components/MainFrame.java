package com.app.components;

import org.apache.commons.lang3.StringUtils;

import com.app.abstracts.AbstractFrame;
import com.app.abstracts.AbstractPanel;
import com.app.consts.Constant.GamenSize;

public class MainFrame extends AbstractFrame {
	
	/**
	 * コンストラクタ
	 * @param args
	 */
	public MainFrame(String[] args) {
		// 画面サイズの選択
		this.selectedGamenSize(args);
		// フレームをWindowsの中央の位置に表示する
		super.setLocationRelativeTo(null);
	}
	
	/**
	 * 画面サイズを選択する
	 * @param args
	 */
	private void selectedGamenSize(String[] args) {
		
		if(StringUtils.equals(args[0],GamenSize.HI_VISION.getSelectNo())) {
			super.setSize(GamenSize.HI_VISION);
		}else if(StringUtils.equals(args[0],GamenSize.HD.getSelectNo())) {
			super.setSize(GamenSize.HD);
		}else if(StringUtils.equals(args[0],GamenSize.Full_HD.getSelectNo())) {
			super.setSize(GamenSize.Full_HD);
		}else {
			super.setSize(GamenSize.HD);
		}
	}
		
	/**
	 * ウィンドウを開く
	 */
	public void open() {
		AbstractPanel panel = new MainPanel();
		super.getContentPane().add(panel);
		super.setVisible(true);
		
	}

}
