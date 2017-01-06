package com.util;

import java.util.*;

public interface CRUD<T> {

	public void create(T parameter);
	public List<T> read(int parameter);
	public void update(T parameter);
	public void delete(T parameter);
	//public void delete(int parameter);
}