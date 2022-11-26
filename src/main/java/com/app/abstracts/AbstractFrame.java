package com.app.abstracts;

import javax.swing.JFrame;

import com.app.consts.Constant;
import com.app.consts.Constant.GamenSize;

public abstract class AbstractFrame extends JFrame {
	public AbstractFrame() {
		// タイトル
		super.setTitle(Constant.TITLE);
		// 閉じるボタンがクリックされた時にアプリケーションを終了するように設定する
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * 画面サイズをセット
	 * @param size 画面サイズ
	 */
	protected void setSize(GamenSize size) {
		super.setSize(size.getX(), size.getY());
	}
}
