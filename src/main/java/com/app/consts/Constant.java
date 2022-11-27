package com.app.consts;

public class Constant {

	public static final String TITLE = "じゃんけんゲーム";

	public static final String START_BUTTON = "START";

	public static final String NO_NAME_SET = null;

	public static final String DEBUG_MODE = "d";

	/**
	 * 画面サイズ
	 *
	 */
	public enum GamenSize {
		HI_VISION("1", 1440, 1080), HD("2", 1280, 720), Full_HD("3", 1920, 1080),;

		private String selectNo;

		private int x;

		private int y;

		private GamenSize(String selectNo, int x, int y) {
			this.selectNo = selectNo;
			this.x = x;
			this.y = y;
		}

		public String getSelectNo() {
			return selectNo;
		}

		public int getX() {
			return this.x;
		}

		public int getY() {
			return this.y;
		}

	}

	/**
	 * じゃんけんアクション
	 *
	 */
	public enum JankenAction {
		ROCK("グー"), SCISSORS("チョキ"), PAPER("パー");

		private String name;

		private JankenAction(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}
	}

	public enum RunArgs {
		ARG0("GamenSize"), ARG1("Player"), ARG2("FileName"), ARG3("RunType"),;

		private String key;

		private RunArgs(String key) {
			this.key = key;
		}

		public String getKey() {
			return this.key;
		}
	}

	public enum PropertyFile {
		MY_IP("MyIP"), My_PORT("MyPort"), YOUR_IP("YourIP"), YOUR_PORT("YourPort"),;

		private String key;

		private PropertyFile(String key) {
			this.key = key;
		}

		public String getKey() {
			return this.key;
		}
	}

	public enum BattleResult {
		WIN, LOSE, DRAW
	}

}
