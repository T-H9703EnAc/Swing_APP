package com.app.components;

import java.awt.event.ActionEvent;

import org.apache.commons.lang3.StringUtils;

import com.app.abstracts.AbstractButton;
import com.app.consts.Constant.JankenAction;

public class MainButton extends AbstractButton {
	private final String btnName;

	public MainButton(String btnName, boolean btnFlg) {
		super(btnName, btnFlg);
		this.btnName = btnName;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(StringUtils.equals(JankenAction.ROCK.getName(),e.getActionCommand())) {
			System.out.println(btnName);
		}
	}

}
