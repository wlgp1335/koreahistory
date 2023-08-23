package kr.ac.kopo.korea.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.korea.model.Notice;
import kr.ac.kopo.korea.pager.Pager;

@Repository
public class NoticeDaoImpl implements NoticeDao {

	@Autowired
	SqlSession sql;

	@Override
	public int total(Pager pager) {

		return sql.selectOne("notice.total", pager);
	}

	@Override
	public List<Notice> list(Pager pager) {

		return sql.selectList("notice.list", pager);
	}

	@Override
	public void add(Notice item) {
		sql.insert("notice.add", item);

	}

	@Override
	public Notice item(int id) {

		return sql.selectOne("notice.item", id);
	}

	@Override
	public void update(Notice item) {
		sql.update("notice.update", item);

	}

	@Override
	public void delete(int id) {
		sql.delete("notice.delete", id);

	}

	@Override
	public void delete(int id, String memberId) {
		HashMap<String, Object> map = new HashMap<>();

		map.put("id", id);
		map.put("memberId", memberId);

		sql.delete("notice.delete_member", map);

	}

	@Override
	public List<Notice> search(String keyword) {
		Pager pager = new Pager();

		pager.setPerPage(0);
		pager.setKeyword(keyword);
		
		return sql.selectList("notice.list", pager);
	}

}
