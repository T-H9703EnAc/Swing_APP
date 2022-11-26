package com.app.abstracts;

import javax.swing.JLabel;

public abstract class AbstractLabel extends JLabel {
	
	/**
	 * コンストラクタ
	 */
	public AbstractLabel() {
		super();
	}
	
	/**
	 * コンストラクタ
	 * @param labelText ラベルのテキスト
	 */
	public AbstractLabel(String labelText) {
		super(labelText);
	}
	
	/**
	 * ラベル内容を設定
	 * @param labelText ラベルのテキスト
	 */
	public void setText(String labelText) {
		super.setText(labelText);
	}
	
	/**
	 * ラベルのサイズと位置を決める
	 * @param x X座標
	 * @param y Y座標
	 * @param width ラベルの横幅の大きさ委
	 * @param height ラベルの縦幅の大きさ委
	 */
	public void setLabelSizeAndPosition(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
	}
}
