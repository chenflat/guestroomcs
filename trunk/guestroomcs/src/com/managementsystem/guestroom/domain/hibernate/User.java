package com.managementsystem.guestroom.domain.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户对象
 * */
public class User implements java.io.Serializable, Cloneable {
	private static final long serialVersionUID = -6785605278782593754L;
	private String userId;
	private String username;
	private Date createDate;
	private Date modifiedDate;
	private String password;
	private Integer passwordEncrypted;
	private Date passwordModifiedDate;
	private String firstName;
	private String middleName;
	private String lastName;
	private String displayname;
	private String digest;
	private String emailAddress;
	private String reminderQueryQuestion;
	private String reminderQueryAnswer;
	private String timeZone;
	private String language;
	private String greeting;
	private String comments;
	private String jobTitle;
	private Date loginDate;
	private String loginIp;
	private Date lastLoginDate;
	private String lastLoginIp;
	private Integer status;
	private Set roles = new HashSet(0);
	private Set shiftworks = new HashSet(0);

	public User() {
	}

	public User(String userId) {
		this.userId = userId;
	}

	public User(String userId, String username, Date createDate,
			Date modifiedDate, String password, Integer passwordEncrypted,
			Date passwordModifiedDate, String firstName, String middleName,
			String lastName, String displayname, String digest,
			String emailAddress, String reminderQueryQuestion,
			String reminderQueryAnswer, String timeZone, String language,
			String greeting, String comments, String jobTitle, Date loginDate,
			String loginIp, Date lastLoginDate, String lastLoginIp,
			Integer status, Set roles, Set shiftworks) {
		this.userId = userId;
		this.username = username;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.password = password;
		this.passwordEncrypted = passwordEncrypted;
		this.passwordModifiedDate = passwordModifiedDate;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.displayname = displayname;
		this.digest = digest;
		this.emailAddress = emailAddress;
		this.reminderQueryQuestion = reminderQueryQuestion;
		this.reminderQueryAnswer = reminderQueryAnswer;
		this.timeZone = timeZone;
		this.language = language;
		this.greeting = greeting;
		this.comments = comments;
		this.jobTitle = jobTitle;
		this.loginDate = loginDate;
		this.loginIp = loginIp;
		this.lastLoginDate = lastLoginDate;
		this.lastLoginIp = lastLoginIp;
		this.status = status;
		this.roles = roles;
		this.shiftworks = shiftworks;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPasswordEncrypted() {
		return this.passwordEncrypted;
	}

	public void setPasswordEncrypted(Integer passwordEncrypted) {
		this.passwordEncrypted = passwordEncrypted;
	}

	public Date getPasswordModifiedDate() {
		return this.passwordModifiedDate;
	}

	public void setPasswordModifiedDate(Date passwordModifiedDate) {
		this.passwordModifiedDate = passwordModifiedDate;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDisplayname() {
		return this.displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public String getDigest() {
		return this.digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getReminderQueryQuestion() {
		return this.reminderQueryQuestion;
	}

	public void setReminderQueryQuestion(String reminderQueryQuestion) {
		this.reminderQueryQuestion = reminderQueryQuestion;
	}

	public String getReminderQueryAnswer() {
		return this.reminderQueryAnswer;
	}

	public void setReminderQueryAnswer(String reminderQueryAnswer) {
		this.reminderQueryAnswer = reminderQueryAnswer;
	}

	public String getTimeZone() {
		return this.timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getGreeting() {
		return this.greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Date getLoginDate() {
		return this.loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginIp() {
		return this.loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set getRoles() {
		return this.roles;
	}

	public void setRoles(Set roles) {
		this.roles = roles;
	}

	public Set getShiftworks() {
		return this.shiftworks;
	}

	public void setShiftworks(Set shiftworks) {
		this.shiftworks = shiftworks;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
