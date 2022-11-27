package com.app.managers;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.app.abstracts.AbstractLabel;
import com.app.consts.Constant.BattleResult;
import com.app.consts.Constant.JankenAction;
import com.app.utils.CommunicationUtil;

/**
 * じゃんけんゲームのシステムを追加
 * @author takeru
 *
 */
public class GameManager extends Thread {

	private String action;
	private String result;
	private AbstractLabel[] labels;

	public GameManager(String action,  AbstractLabel... labels) {
		this.action = action;
		this.labels = labels;
	}

	@Override
	public void run() {

		try {
			String setText = "じゃんけんぽん！ あなた：" + this.action;
			this.labels[0].setText(setText);		
			List<String> yourAction = CommunicationUtil.getDataUDP();

			this.judgmentResult(this.action, yourAction.get(0));
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	private void judgmentResult(String myActionName, String yourActionName) {

		JankenAction myAction = this.getAction(myActionName);
		JankenAction yourAction = this.getAction(yourActionName);

		switch (myAction) {
		case ROCK:
			switch (yourAction) {
			case ROCK:
				this.result = BattleResult.DRAW.name();
				break;
			case SCISSORS:
				this.result = BattleResult.WIN.name();
				break;
			case PAPER:
				this.result = BattleResult.LOSE.name();
				break;
			}
			break;
		case SCISSORS:
			switch (yourAction) {
			case ROCK:
				this.result = BattleResult.LOSE.name();
				break;
			case SCISSORS:
				this.result = BattleResult.DRAW.name();
				break;
			case PAPER:
				this.result = BattleResult.WIN.name();

				break;
			}

			break;
		case PAPER:
			switch (yourAction) {
			case ROCK:
				this.result = BattleResult.WIN.name();
				break;
			case SCISSORS:
				this.result = BattleResult.LOSE.name();
				break;
			case PAPER:
				this.result = BattleResult.DRAW.name();
				break;
			}
			break;
		}
		this.labels[1].setText("結果：" + this.result);
	}

	/**
	 * じゃんけんアクションを取得
	 * @param action アクション名
	 * @return アクション
	 */
	private JankenAction getAction(String action) {
		if (StringUtils.equals(JankenAction.ROCK.getName(), action)) {
			return JankenAction.ROCK;
		} else if (StringUtils.equals(JankenAction.SCISSORS.getName(), action)) {
			return JankenAction.SCISSORS;
		} else {
			return JankenAction.PAPER;
		}
	}

	public String getResult() {
		return this.result;
	}
	
	
}
