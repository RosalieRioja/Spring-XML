package com.util;

public interface CRUD<T> {

	public void create(T parameter);
	public void read();
	public void update(T parameter);
	public void delete(int parameter);
}