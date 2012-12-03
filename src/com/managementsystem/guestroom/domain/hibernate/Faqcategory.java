package com.managementsystem.guestroom.domain.hibernate;

import java.util.HashSet;
import java.util.Set;


public class Faqcategory implements java.io.Serializable {

	private static final long serialVersionUID = 8991212093117847545L;
	private String catId;
	private String catName;
	private Integer catOrder;
	private String catDesc;
	private Set faqs = new HashSet(0);

	public Faqcategory() {
	}

	public Faqcategory(String catId) {
		this.catId = catId;
	}

	public Faqcategory(String catId, String catName, Integer catOrder,
			String catDesc, Set faqs) {
		this.catId = catId;
		this.catName = catName;
		this.catOrder = catOrder;
		this.catDesc = catDesc;
		this.faqs = faqs;
	}

	public String getCatId() {
		return this.catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return this.catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public Integer getCatOrder() {
		return this.catOrder;
	}

	public void setCatOrder(Integer catOrder) {
		this.catOrder = catOrder;
	}

	public String getCatDesc() {
		return this.catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	public Set getFaqs() {
		return this.faqs;
	}

	public void setFaqs(Set faqs) {
		this.faqs = faqs;
	}

}
