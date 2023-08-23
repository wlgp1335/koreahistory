package kr.ac.kopo.korea.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.korea.model.Often;
import kr.ac.kopo.korea.pager.Pager;

@Repository
public class OftenqaDaoImpl implements OftenqaDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public int total(Pager pager) {
		
		return sql.selectOne("oftenqa.total", pager);
	}

	@Override
	public List<Often> list(Pager pager) {
		
		return sql.selectList("oftenqa.list", pager);
	}

	@Override
	public void add(Often item) {
		sql.insert("oftenqa.add", item);

	}

	@Override
	public Often item(int id) {
		
		return sql.selectOne("oftenqa.item", id);
	}

	@Override
	public void update(Often item) {
		sql.update("oftenqa.update", item);

	}

	@Override
	public void delete(int id) {
		sql.delete("oftenqa.delete", id);

	}

	@Override
	public void delete(int id, String memberId) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("id", id);
		map.put("memberId", memberId);
		
		sql.delete("oftenqa.delete_member", map);
		
	}

	@Override
	public List<Often> search(String keyword) {
		Pager pager = new Pager();

		pager.setPerPage(0);
		pager.setKeyword(keyword);
		
		return sql.selectList("oftenqa.list", pager);
	}

}
