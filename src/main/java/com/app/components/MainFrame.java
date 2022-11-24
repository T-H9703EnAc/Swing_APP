package com.app.components;

import javax.swing.JFrame;

import org.apache.commons.lang3.StringUtils;

import com.app.consts.Constant;
import com.app.consts.Constant.GamenSize;

public class MainFrame extends JFrame {

	public MainFrame(String[] args) {
		// タイトル
		super.setTitle(Constant.TITLE);
		// 閉じるボタンがクリックされた時にアプリケーションを終了するように設定する
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 画面サイズの選択
		this.selectedGamenSize(args);
		// フレームをWindowsの中央の位置に表示する
		super.setLocationRelativeTo(null);
	}
	
	private void selectedGamenSize(String[] args) {
		
		if(args.length < 1) {
			this.setSize(GamenSize.HD);
		} else if(StringUtils.equals(args[0],GamenSize.HI_VISION.getSelectNo())) {
			this.setSize(GamenSize.HI_VISION);
		}else if(StringUtils.equals(args[0],GamenSize.HD.getSelectNo())) {
			this.setSize(GamenSize.HD);
		}else if(StringUtils.equals(args[0],GamenSize.Full_HD.getSelectNo())) {
			this.setSize(GamenSize.Full_HD);
		}else {
			this.setSize(GamenSize.HI_VISION);
		}
	}
	
	/**
	 * 画面サイズをセット
	 * @param size 画面サイズ
	 */
	private void setSize(GamenSize size) {
		super.setSize(size.getX(), size.getY());
	}
	
	/**
	 * ウィンドウを開く
	 */
	public void open() {
		super.setVisible(true);
	}

}
