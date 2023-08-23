package kr.ac.kopo.korea.dao;

import kr.ac.kopo.korea.model.Attach;

public interface AttachDao {

	void deleteByNoticeId(int id);

	void deleteByhistoryId(int id);

	void historyAdd(Attach attach);

	void noticeAdd(Attach attach);

	boolean delete(int id);

}
