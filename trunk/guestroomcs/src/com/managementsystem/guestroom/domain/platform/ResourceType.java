package com.managementsystem.guestroom.domain.platform;

/**
 * 资源类型
 * */
public enum ResourceType {
	URL("url"), // 地址
	METHOD("method"); // 方法

	private String code;

	private ResourceType(String name) {
		this.code = name;
	}

	public static ResourceType fromCode(String s) {
		if (s == null)
			return null;
		for (ResourceType type : ResourceType.values()) {
			if (type.equals(s.toUpperCase()))
				return type;
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
