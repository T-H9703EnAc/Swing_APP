package com.app.components;

import java.awt.event.ActionEvent;

import org.apache.commons.lang3.StringUtils;

import com.app.abstracts.AbstractButton;
import com.app.abstracts.AbstractLabel;
import com.app.abstracts.AbstractPanel;
import com.app.consts.Constant;
import com.app.consts.Constant.BattleResult;
import com.app.consts.Constant.JankenAction;
import com.app.managers.GameManager;

public class MainPanel extends AbstractPanel {

	private AbstractButton startButton;
	private AbstractButton rockButton;
	private AbstractButton scissorsButton;
	private AbstractButton paperButton;
	private AbstractLabel label;
	private AbstractLabel labelResult;

	/**
	 * コンストラクタ
	 */
	public MainPanel() {
		super();
		this.startButton = new MainButton(Constant.START_BUTTON, true);
		this.rockButton = new MainButton(JankenAction.ROCK.getName(), false);
		this.scissorsButton = new MainButton(JankenAction.SCISSORS.getName(), false);
		this.paperButton = new MainButton(JankenAction.PAPER.getName(), false);
		this.label = new MainLabel();
		this.labelResult = new MainLabel();

		this.startButton.setButtonSizeAndPosition(400, 500, 600, 100);
		this.rockButton.setButtonSizeAndPosition(400, 300, 150, 100);
		this.scissorsButton.setButtonSizeAndPosition(600, 300, 150, 100);
		this.paperButton.setButtonSizeAndPosition(800, 300, 150, 100);
		this.label.setLabelSizeAndPosition(400, 100, 600, 100);
		this.labelResult.setLabelSizeAndPosition(400, 150, 600, 100);

		// このパネルで使用するボタンを登録
		super.registerButton(this.startButton, this.rockButton, this.scissorsButton, this.paperButton);
		this.registerLabel(this.label, this.labelResult);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (StringUtils.equals(Constant.START_BUTTON, e.getActionCommand())) {
			this.rockButton.setEnabled(true);
			this.scissorsButton.setEnabled(true);
			this.paperButton.setEnabled(true);
			this.startButton.setEnabled(false);
			this.label.setText("最初はグーじゃんけん");
			return;
		}

		try {
			GameManager gameManager = new GameManager(e.getActionCommand(), this.label, this.labelResult);
			gameManager.start();
			if (!this.isDraw(gameManager.getResult())) {
				this.rockButton.setEnabled(false);
				this.scissorsButton.setEnabled(false);
				this.paperButton.setEnabled(false);
				this.startButton.setEnabled(true);
			}
		} catch (Exception e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

	}

	private boolean isDraw(String result) {
		return StringUtils.equals(result, BattleResult.DRAW.name());

	}

}
