package kr.ac.kopo.korea.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.korea.model.Attach;

@Repository
public class AttachDaoImpl implements AttachDao {
	
	@Autowired
	SqlSession sql;
	
	@Override
	public void deleteByNoticeId(int id) {
		sql.delete("attach.delete_noticeid", id);
		
	}

	@Override
	public void deleteByhistoryId(int id) {
		sql.delete("attach.delete_historyid", id);
		
	}

	@Override
	public void historyAdd(Attach attach) {
		sql.insert("attach.historyAdd", attach);
		
	}

	@Override
	public void noticeAdd(Attach attach) {
		sql.insert("attach.noticeAdd", attach);
		
	}
	
	@Override
	public boolean delete(int id) {
		if(sql.delete("attach.delete", id)==1)
			return true;
		else
			return false;
	}

}
