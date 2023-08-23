package kr.ac.kopo.korea.dao;

import java.util.List;

import kr.ac.kopo.korea.model.Grade;

public interface GradeDao {

	List<Grade> list();

	void add(Grade item);

	Grade item(int id);

	void update(Grade item);

	void delete(int id);

	void firstAdd(Grade item);

}
