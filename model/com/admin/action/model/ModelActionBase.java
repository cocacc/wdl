package com.admin.action.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class ModelActionBase implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	private String text;
	private List<ModelActionUnit>  items;
	
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
	public List<ModelActionUnit> getItems() {
		return items;
	}
	public void setItems(List<ModelActionUnit>  items) {
		this.items = items;
	}  
}
