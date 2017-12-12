package com.admin.action.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class ModelMobiAction {

	private static final long serialVersionUID = 1L;

	private int id;
	private String text;
	
	public String getText() {
		return text;
	}
	public void setText(String ptext) {
		this.text = ptext;
	}
	
	
	
	@JsonIgnore
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
}
