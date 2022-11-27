package com.app.utils;

import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.app.consts.Constant.JankenAction;

public class CommonUtil {
	/**
	 * じゃんけんアクションを取得
	 * @param action アクションコマンド
	 * @return アクション
	 */
	public static JankenAction getAction(ActionEvent e) {
		if (StringUtils.equals(JankenAction.ROCK.getName(), e.getActionCommand())) {
			return JankenAction.ROCK;
		} else if (StringUtils.equals(JankenAction.SCISSORS.getName(), e.getActionCommand())) {
			return JankenAction.SCISSORS;
		} else {
			return JankenAction.PAPER;
		}

	}
	
	public static List<String> getList(String... datas){
		return (List<String>) Arrays.asList(datas);
	}
}
