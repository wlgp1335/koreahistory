package kr.ac.kopo.korea.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.korea.model.Reply;

@Repository
public class ReplyDaoImpl implements ReplyDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<Reply> qaList(int qaId) {
		return sql.selectList("reply.qaList", qaId);
	}

	@Override
	public void qaAdd(Reply reply) {
		sql.insert("reply.qaAdd", reply);
	}

	@Override
	public void qaDelete(int id) {
		sql.delete("reply.qaDelete", id);
	}

	@Override
	public List<Reply> historyList(int historyId) {
		return sql.selectList("reply.historyList", historyId);
	}

	@Override
	public void historyAdd(Reply reply) {
		sql.insert("reply.historyAdd", reply);
	}

	@Override
	public void historyDelete(int id) {
		sql.delete("reply.historyDelete", id);
	}

}
