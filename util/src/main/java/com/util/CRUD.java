package com.util;

<<<<<<< HEAD
import java.util.*;

public interface CRUD<T> {

	public void create(T parameter);
	public List<T> read();
=======
public interface CRUD<T> {

	public void create(T parameter);
	public void read();
>>>>>>> 73f5e5b4ca6f3300f19dc4612b4298afad1366ec
	public void update(T parameter);
	public void delete(int parameter);
}