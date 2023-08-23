package kr.ac.kopo.korea.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.korea.model.History;
import kr.ac.kopo.korea.pager.Pager;

@Repository
public class HistoryDaoImpl implements HistoryDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public int total(Pager pager) {
		return sql.selectOne("history.total", pager);
	}

	@Override
	public List<History> list(Pager pager) {
		return sql.selectList("history.list", pager);
	}

	@Override
	public void add(History item) {
		sql.insert("history.add", item);

	}

	@Override
	public History item(int id) {
		return sql.selectOne("history.item", id);
	}

	@Override
	public void update(History item) {
		sql.update("history.update", item);

	}

	@Override
	public void delete(int id) {
		sql.delete("history.delete", id);

	}

	@Override
	public void delete(int id, String memberId) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("id", id);
		map.put("memberId", memberId);
		
		sql.delete("history.delete_member", map);
		
	}

	@Override
	public List<History> search(String keyword) {
		Pager pager = new Pager();
		
		pager.setPerPage(0);
		pager.setKeyword(keyword);
		
		return sql.selectList("history.list", pager);
	}

}
