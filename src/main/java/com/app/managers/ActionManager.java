package com.app.managers;

import java.awt.event.ActionEvent;
import java.util.List;

import com.app.consts.Constant.JankenAction;
import com.app.utils.CommonUtil;
import com.app.utils.CommunicationUtil;

public class ActionManager extends Thread {
	
	private JankenAction action;
	
	public ActionManager(ActionEvent e) {
		this.action = CommonUtil.getAction(e);
	}

	@Override
	public void run() {
		try {
			List<String> sendData = CommonUtil.getList(this.action.getName());
			CommunicationUtil.sendDataUDP(sendData);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
