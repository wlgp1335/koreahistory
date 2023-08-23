package kr.ac.kopo.korea.dao;

import java.util.List;

import kr.ac.kopo.korea.model.History;
import kr.ac.kopo.korea.pager.Pager;

public interface HistoryDao {

	int total(Pager pager);

	List<History> list(Pager pager);

	void add(History item);

	History item(int id);

	void update(History item);

	void delete(int id);

	void delete(int id, String memberId);

	List<History> search(String keyword);

}
