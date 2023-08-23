package kr.ac.kopo.korea.service;

import java.util.List;

import kr.ac.kopo.korea.model.Grade;

public interface GradeService {

	List<Grade> list();

	void add(Grade item);

	Grade item(int id);

	void update(Grade item);

	void delete(int id);

	void firstAdd(Grade item);


}
