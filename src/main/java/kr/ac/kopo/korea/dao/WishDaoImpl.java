package kr.ac.kopo.korea.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WishDaoImpl implements WishDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public int add(int historyId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("historyId", historyId);
		
		return sql.insert("history.wish_add", map);
	}

	@Override
	public int delete(int historyId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("historyId", historyId);
		
		return sql.delete("history.wish_delete", map);
	}

}
