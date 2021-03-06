package com.managementsystem.guestroom.domain.hibernate;

public class Faq implements java.io.Serializable {

	private static final long serialVersionUID = 4201774104425118621L;
	private String faqId;
	private Faqcategory faqcategory;
	private String question;
	private String answer;
	private Integer priority;
	private String comment;

	public Faq() {
	}

	public Faq(String faqId) {
		this.faqId = faqId;
	}

	public Faq(String faqId, Faqcategory faqcategory, String question,
			String answer, Integer priority, String comment) {
		this.faqId = faqId;
		this.faqcategory = faqcategory;
		this.question = question;
		this.answer = answer;
		this.priority = priority;
		this.comment = comment;
	}

	public String getFaqId() {
		return this.faqId;
	}

	public void setFaqId(String faqId) {
		this.faqId = faqId;
	}

	public Faqcategory getFaqcategory() {
		return this.faqcategory;
	}

	public void setFaqcategory(Faqcategory faqcategory) {
		this.faqcategory = faqcategory;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getPriority() {
		return this.priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
