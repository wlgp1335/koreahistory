package kr.ac.kopo.korea.service;

import java.util.List;

import kr.ac.kopo.korea.model.History;
import kr.ac.kopo.korea.pager.Pager;

public interface HistoryService {

	List<History> list(Pager pager);

	void add(History item);

	History item(int id);

	void update(History item);

	void delete(int id, String memberId);

	boolean deleteAttach(int id);

	List<History> search(String keyword);
	
}
