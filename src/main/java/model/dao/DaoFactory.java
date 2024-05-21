package model.dao;

import model.dao.impl.DaoAbrigosJDBC;

public class DaoFactory {
	public static DaoAbrigos createDaoAbrigo() {
		return new DaoAbrigosJDBC();
	}
}
