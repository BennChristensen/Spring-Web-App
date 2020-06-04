package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Category {

	private long id;
	private String name;
	private int number;
	private int vat;
	private List<Grocery> groceries;
	
	public Category() {
		groceries = new ArrayList<Grocery>();
	}
	public String getName() {
		return name;
	}
	public int getNumber() {
		return number;
	}
	public int getVat() {
		return vat;
	}
	public long getId() {
		return id;
	}
}
