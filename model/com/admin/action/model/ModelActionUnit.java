package com.admin.action.model;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
@JsonSerialize
public class ModelActionUnit implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	private String text;
	private String path;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
