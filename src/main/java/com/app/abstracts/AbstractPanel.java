package com.app.abstracts;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;

public abstract class AbstractPanel extends JPanel implements EventActionListener{
	
	/**
	 * コンストラクタ
	 */
	public AbstractPanel() {
		// レイアウトマネージャを無効にする(これがないとパネル上のボタン等の位置を指定が反映されない)
		setLayout(null);
	}
	
	/**
	 * ボタン押下時のイベント処理の抽象化メソッド
	 */
	public abstract void actionPerformed(ActionEvent e);
	
	/**
	 * パネルにボタンを登録する(対象のパネル上にボタンを表示させたい場合)
	 * @param buttons 登録するボタン
	 */
	public void registerButton(AbstractButton... buttons) {
		for (AbstractButton button : buttons) {
			// ボタンをpanel上に表示できるようにする
			super.add(button);
			button.addActionListener(this);
		}

	}
	
	/**
	 * パネルにラベルを登録する(対象のパネル上にボタンを表示させたい場合)
	 * @param labels 登録するラベル
	 */
	public void registerLabel(AbstractLabel... labels) {
		for (AbstractLabel label : labels) {
			// ボタンをpanel上に表示できるようにする
			super.add(label);
		}

	}

}
