package kr.ac.kopo.korea.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.korea.model.QA;
import kr.ac.kopo.korea.pager.Pager;

@Repository
public class QADaoImpl implements QADao {
	
	@Autowired
	SqlSession sql;
	
	@Override
	public int total(Pager pager) {
		return sql.selectOne("qa.total", pager);
	}

	@Override
	public List<QA> list(Pager pager) {
		return sql.selectList("qa.list", pager);
	}

	@Override
	public void add(QA item) {
		sql.insert("qa.add", item);

	}

	@Override
	public QA item(int id) {
		return sql.selectOne("qa.item", id);
	}

	@Override
	public void update(QA item) {
		sql.update("qa.update", item);

	}

	@Override
	public void delete(int id) {
		sql.delete("qa.delete", id);

	}

	@Override
	public void delete(int id, String memberId) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("id", id);
		map.put("memberId", memberId);
		
		sql.delete("qa.delete_member", map);
	}

	@Override
	public List<QA> search(String keyword) {
		Pager pager = new Pager();

		pager.setPerPage(0);
		pager.setKeyword(keyword);
		
		return sql.selectList("qa.list", pager);
	}

}
