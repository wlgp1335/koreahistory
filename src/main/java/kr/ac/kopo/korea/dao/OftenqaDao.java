package kr.ac.kopo.korea.dao;

import java.util.List;

import kr.ac.kopo.korea.model.Often;
import kr.ac.kopo.korea.pager.Pager;

public interface OftenqaDao {

	int total(Pager pager);

	List<Often> list(Pager pager);

	void add(Often item);

	Often item(int id);

	void update(Often item);

	void delete(int id);

	void delete(int id, String memberId);

	List<Often> search(String keyword);

}
