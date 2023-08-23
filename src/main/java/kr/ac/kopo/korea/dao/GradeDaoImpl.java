package kr.ac.kopo.korea.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.korea.model.Grade;

@Repository
public class GradeDaoImpl implements GradeDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<Grade> list() {
		return sql.selectList("grade.list");
	}

	@Override
	public void add(Grade item) {
		sql.insert("grade.add", item);

	}

	@Override
	public Grade item(int id) {
		return sql.selectOne("grade.item", id);
	}

	@Override
	public void update(Grade item) {
		sql.update("grade.update", item);

	}

	@Override
	public void delete(int id) {
		sql.delete("grade.delete", id);

	}

	@Override
	public void firstAdd(Grade item) {
		sql.insert("grade.firstAdd", item);
		
	}

}
