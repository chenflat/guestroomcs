package com.managementsystem.guestroom.domain.platform;

/**
 * 提示类型
 * */
public enum Alert {
	WARNING("block"), ERROR("error"), SUCCESS("success"), INFO("info");

	private String code;

	private Alert(String name) {
		this.code = name;
	}

	public static Alert fromCode(String s) {
		if (s == null)
			return null;
		for (Alert alert : Alert.values()) {
			if (alert.equals(s.toUpperCase()))
				return alert;
		}
		throw new IllegalArgumentException(s.toUpperCase());
	}

	public boolean equals(String s) {
		if (this.code != null)
			return this.code.equalsIgnoreCase(s);
		return false;
	}

	public String getCode() {
		return code;
	}
}
