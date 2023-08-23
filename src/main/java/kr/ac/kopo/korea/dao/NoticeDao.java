package kr.ac.kopo.korea.dao;

import java.util.List;

import kr.ac.kopo.korea.model.Notice;
import kr.ac.kopo.korea.pager.Pager;

public interface NoticeDao {

	int total(Pager pager);

	List<Notice> list(Pager pager);

	void add(Notice item);

	Notice item(int id);

	void update(Notice item);

	void delete(int id);

	void delete(int id, String memberId);

	List<Notice> search(String keyword);

}
