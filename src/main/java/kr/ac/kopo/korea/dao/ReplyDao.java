package kr.ac.kopo.korea.dao;

import java.util.List;

import kr.ac.kopo.korea.model.Reply;

public interface ReplyDao {

	List<Reply> qaList(int qaId);

	void qaAdd(Reply reply);

	void qaDelete(int id);

	List<Reply> historyList(int historyId);

	void historyAdd(Reply reply);
	
	void historyDelete(int id);

}
