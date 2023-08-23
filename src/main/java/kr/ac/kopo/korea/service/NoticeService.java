package kr.ac.kopo.korea.service;

import java.util.List;

import kr.ac.kopo.korea.model.Notice;
import kr.ac.kopo.korea.pager.Pager;

public interface NoticeService {

	List<Notice> list(Pager pager);

	void add(Notice item);

	Notice item(int id);

	void update(Notice item);

	void delete(int id, String memberId);

	boolean deleteAttach(int id);

	List<Notice> search(String keyword);


}
