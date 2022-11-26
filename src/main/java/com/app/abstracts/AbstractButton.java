package com.app.abstracts;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

public abstract class AbstractButton extends JButton implements EventActionListener{
	
	/**
	 * コンストラクタ
	 * @param btnName ボタン名
	 */
	public AbstractButton(String btnName, boolean btnFlg) {
		// ボタン名
		super(btnName);
		// ボタンイベントを登録する
		super.addActionListener(this);
		// ボタンの活性制御
		this.setButtonEnabled(btnFlg);
	}
	
	/**
	 * ボタンのサイズと位置を決める
	 * @param x X座標
	 * @param y Y座標
	 * @param width ボタンの横幅の大きさ委
	 * @param height ボタンの縦幅の大きさ委
	 */
	public void setButtonSizeAndPosition(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
	}
	
	/**
	 * ボタン押下時のイベント処理の抽象化メソッド
	 */
	public abstract void actionPerformed(ActionEvent e);
	
	/**
	 * ボタンの活性・非活性を制御
	 * @param btnFlg
	 */
	protected void setButtonEnabled(boolean btnFlg) {
		super.setEnabled(btnFlg);	
	}
}
