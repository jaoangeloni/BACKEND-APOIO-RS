package model.dao.impl;

import java.util.List;
import java.sql.Connection;

import aplicativo.Abrigos;
import model.dao.DaoAbrigos;

public class DaoAbrigosJDBC implements DaoAbrigos {

	private Connection conn;
	
	public DaoAbrigosJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Abrigos obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Abrigos obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Abrigos id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Abrigos findById(Abrigos id) {
			"SELECT "
		
	}

	@Override
	public List<Abrigos> findall() {
		// TODO Auto-generated method stub
		return null;
	}

}
