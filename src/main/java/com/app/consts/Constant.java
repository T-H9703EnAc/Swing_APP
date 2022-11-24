package com.app.consts;

public class Constant {

	public static final String TITLE = "じゃんけんゲーム";

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
			return x;
		}

		public int getY() {
			return y;
		}

	}

}
