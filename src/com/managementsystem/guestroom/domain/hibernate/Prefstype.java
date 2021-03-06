package com.managementsystem.guestroom.domain.hibernate;

// Generated 2012-11-6 13:37:38 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Prefstype generated by hbm2java
 */
public class Prefstype implements java.io.Serializable {

	private String prefstypeId;
	private String prefstypeName;
	private String prefstypeComment;
	private Set prefsdefinedfields = new HashSet(0);

	public Prefstype() {
	}

	public Prefstype(String prefstypeId) {
		this.prefstypeId = prefstypeId;
	}

	public Prefstype(String prefstypeId, String prefstypeName,
			String prefstypeComment, Set prefsdefinedfields) {
		this.prefstypeId = prefstypeId;
		this.prefstypeName = prefstypeName;
		this.prefstypeComment = prefstypeComment;
		this.prefsdefinedfields = prefsdefinedfields;
	}

	public String getPrefstypeId() {
		return this.prefstypeId;
	}

	public void setPrefstypeId(String prefstypeId) {
		this.prefstypeId = prefstypeId;
	}

	public String getPrefstypeName() {
		return this.prefstypeName;
	}

	public void setPrefstypeName(String prefstypeName) {
		this.prefstypeName = prefstypeName;
	}

	public String getPrefstypeComment() {
		return this.prefstypeComment;
	}

	public void setPrefstypeComment(String prefstypeComment) {
		this.prefstypeComment = prefstypeComment;
	}

	public Set getPrefsdefinedfields() {
		return this.prefsdefinedfields;
	}

	public void setPrefsdefinedfields(Set prefsdefinedfields) {
		this.prefsdefinedfields = prefsdefinedfields;
	}

}
