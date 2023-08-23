package kr.ac.kopo.korea.dao;

import java.util.List;

import kr.ac.kopo.korea.model.QA;
import kr.ac.kopo.korea.pager.Pager;

public interface QADao {
	
	int total(Pager pager);

	List<QA> list(Pager pager);

	void add(QA item);

	QA item(int id);

	void update(QA item);

	void delete(int id);

	void delete(int id, String memberId);

	List<QA> search(String keyword);

}
