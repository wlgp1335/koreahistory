package kr.ac.kopo.korea.service;

import java.util.List;

import kr.ac.kopo.korea.model.Often;
import kr.ac.kopo.korea.pager.Pager;

public interface OftenqaService {

	List<Often> list(Pager pager);

	void add(Often item);

	Often item(int id);
	
	void update(Often item);

	void delete(int id, String memberId);

	List<Often> search(String keyword);

}
