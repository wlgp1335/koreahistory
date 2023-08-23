package kr.ac.kopo.korea.service;

import java.util.List;

import kr.ac.kopo.korea.model.QA;
import kr.ac.kopo.korea.pager.Pager;

public interface QAService {

	List<QA> list(Pager pager);

	void add(QA item);

	QA item(int id);

	void update(QA item);

	void delete(int id, String memberId);

	List<QA> search(String keyword);

}
