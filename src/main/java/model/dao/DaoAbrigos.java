package model.dao;

import java.util.List;

import aplicativo.Abrigos;

public interface DaoAbrigos {

	void insert(Abrigos obj);
	void update(Abrigos obj);
	void deleteById(Abrigos id);
	Abrigos findById(Abrigos id);
	List<Abrigos> findall();
}
