package com.managementsystem.guestroom.domain.platform;

public class Message implements java.io.Serializable {

	private static final long serialVersionUID = -8568472624523056259L;

	private String title;
	private String text;
	private Alert alert;

	public Message() {
		
	}
	
	public Message(Alert alert,String text) {
		this.alert = alert;
		this.text = text;
	}
	
	public Message(Alert alert,String title,String text) {
		this.title = title;
		this.alert = alert;
		this.text = text;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Alert getAlert() {
		return alert;
	}

	public void setAlert(Alert alert) {
		this.alert = alert;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("<div class=\"alert alert-%s\">\n", this.alert.getCode()));
		sb.append("<button type=\"button\" class=\"close\" data-dismiss=\"alert\">×</button>\b");
		if (this.title != null && this.title.length() > 0) {
			sb.append(String.format("<h4>%s<h4>", title));
		}
		sb.append(this.text);
		sb.append("</div>");
		return sb.toString();
	}

}
