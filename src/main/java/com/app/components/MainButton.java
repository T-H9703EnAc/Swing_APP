package com.app.components;

import java.awt.event.ActionEvent;

import org.apache.commons.lang3.StringUtils;

import com.app.abstracts.AbstractButton;
import com.app.consts.Constant;
import com.app.managers.ActionManager;

public class MainButton extends AbstractButton {

	public MainButton(String btnName, boolean btnFlg) {
		super(btnName, btnFlg);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!StringUtils.equals(Constant.START_BUTTON, e.getActionCommand())) {
			try {
				ActionManager actionManager = new ActionManager(e);
				actionManager.start();
			} catch (Exception e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
		}
	}

}
